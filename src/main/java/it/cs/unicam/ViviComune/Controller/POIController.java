package it.cs.unicam.ViviComune.Controller;

import it.cs.unicam.ViviComune.POI.POI;
import it.cs.unicam.ViviComune.POI.gestorePOI;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;



@RestController
@RequestMapping("/poi")
public class POIController {


    private gestorePOI  gestorePoi;

    @Autowired
    public POIController(gestorePOI gestorePoi) {
        this.gestorePoi = gestorePoi;
    }


    @GetMapping("/")
    public ResponseEntity<List<POI>> getAllPOI() {
        List<POI> poiList = gestorePoi.getTuttiPOI();
        return new ResponseEntity<>(poiList, HttpStatus.OK);
    }

    @PostMapping("/nuovo")
    public ResponseEntity<String> creaPOI(@RequestBody POI nuovoPOI) {
        if (gestorePoi.esistePOIConId(nuovoPOI.getId())) {
            return new ResponseEntity<>("Un POI con lo stesso ID esiste già", HttpStatus.BAD_REQUEST);
        } else if (gestorePoi.esistePOIConNome(nuovoPOI.getNome())) {
            return new ResponseEntity<>("Un POI con lo stesso nome esiste già", HttpStatus.BAD_REQUEST);
        } else {
            gestorePoi.creaPOI(nuovoPOI.getId(), nuovoPOI.getNome(), nuovoPOI.getDescrizione(), nuovoPOI.getCoordinate());
            return new ResponseEntity<>("POI creato con successo", HttpStatus.CREATED);
        }
    }

    @DeleteMapping("/elimina/{id}")
    public ResponseEntity<String> eliminaPOI(@PathVariable String id) {
        POI poi = gestorePoi.getPOI(id);
        if (poi != null) {
            gestorePoi.eliminaPOI(id);
            return new ResponseEntity<>("POI eliminato con successo", HttpStatus.OK);
        } else {
            return new ResponseEntity<>("POI non trovato", HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping("/modifica/{id}")
    public ResponseEntity<String> modificaPOI(@PathVariable String id, @RequestBody POI poiModificato) {
        POI poi = gestorePoi.getPOI(id);
        if (poi != null) {
            gestorePoi.modificaPOI(id, poiModificato.getNome(), poiModificato.getDescrizione());
            return new ResponseEntity<>("POI modificato con successo", HttpStatus.OK);
        } else {
            return new ResponseEntity<>("POI non trovato", HttpStatus.NOT_FOUND);
        }
    }
}




