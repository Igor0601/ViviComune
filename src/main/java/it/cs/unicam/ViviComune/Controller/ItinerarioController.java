package it.cs.unicam.ViviComune.Controller;

import it.cs.unicam.ViviComune.Itinerario.GestoreItinerario;
import it.cs.unicam.ViviComune.POI.gestorePOI;
import it.cs.unicam.ViviComune.Itinerario.Itinerario;
import it.cs.unicam.ViviComune.POI.POI;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/itinerario")
public class ItinerarioController {
    @Autowired
    private GestoreItinerario gestoreItinerario;
    @Autowired
    private gestorePOI gestorePOI;

    @PostMapping("/nuovo")
    public ResponseEntity<String> creaItinerario(@RequestBody Itinerario nuovoItinerario) {
        if (gestoreItinerario.esisteItinerarioConID(nuovoItinerario.getID())) {
            return new ResponseEntity<>("Un itinerario con lo stesso ID esiste già", HttpStatus.BAD_REQUEST);
        }
        if (gestoreItinerario.esisteItinerarioConNome(nuovoItinerario.getNome())) {
            return new ResponseEntity<>("Un itinerario con lo stesso nome esiste già", HttpStatus.BAD_REQUEST);
        }
        gestoreItinerario.creaItinerario(nuovoItinerario.getID(), nuovoItinerario.getNome(), nuovoItinerario.getDescrizione());
        return new ResponseEntity<>("Itinerario creato con successo", HttpStatus.CREATED);
    }

    @GetMapping("/")
    public ResponseEntity<List<Itinerario>> getTuttiItinerari() {
        List<Itinerario> itinerari = gestoreItinerario.getTuttiItinerari();
        return new ResponseEntity<>(itinerari, HttpStatus.OK);
    }

    @DeleteMapping("/elimina/{id}")
    public ResponseEntity<String> eliminaItinerario(@PathVariable String id) {
        Itinerario itinerario = gestoreItinerario.getItinerario(id);
        if (itinerario == null) {
            return new ResponseEntity<>("Itinerario non trovato", HttpStatus.NOT_FOUND);
        }
        gestoreItinerario.eliminaItinerario(id);
        return new ResponseEntity<>("Itinerario eliminato correttamente", HttpStatus.OK);
    }

    @PutMapping("/modifica/{id}")
    public ResponseEntity<String> modificaItinerario(@PathVariable String id, @RequestBody Itinerario itinerarioModificato) {
        Itinerario itinerarioEsistente = gestoreItinerario.getItinerario(id);
        if (itinerarioEsistente == null) {
            return new ResponseEntity<>("Itinerario non trovato", HttpStatus.NOT_FOUND);
        }
        if (!itinerarioModificato.getNome().equals(itinerarioEsistente.getNome()) &&
                gestoreItinerario.esisteItinerarioConNome(itinerarioModificato.getNome())) {
            return new ResponseEntity<>("Un itinerario con lo stesso nome esiste già", HttpStatus.BAD_REQUEST);
        }
        gestoreItinerario.modificaItinerario(id, itinerarioModificato.getNome(), itinerarioModificato.getDescrizione());
        return new ResponseEntity<>("Itinerario modificato correttamente", HttpStatus.OK);
    }

    @PostMapping("/{itinerarioID}/aggiungiPOI/{poiID}")
    public ResponseEntity<String> aggiungiPOIAllItinerario(@PathVariable String itinerarioID, @PathVariable String poiID) {
        Itinerario itinerario = gestoreItinerario.getItinerario(itinerarioID);
        if (itinerario == null) {
            return new ResponseEntity<>("Itinerario non trovato", HttpStatus.NOT_FOUND);
        }
        POI poi = gestorePOI.getPOI(poiID);
        if (poi == null) {
            return new ResponseEntity<>("POI non trovato", HttpStatus.NOT_FOUND);
        }
        gestoreItinerario.aggiungiPOIAllItinerario(itinerarioID, poi);
        return new ResponseEntity<>("POI aggiunto all'itinerario correttamente", HttpStatus.OK);
    }

    @DeleteMapping("/{itinerarioID}/rimuoviPOI/{poiID}")
    public ResponseEntity<String> rimuoviPOIDaItinerario(@PathVariable String itinerarioID, @PathVariable String poiID) {
        Itinerario itinerario = gestoreItinerario.getItinerario(itinerarioID);
        if (itinerario == null) {
            return new ResponseEntity<>("Errore: Itinerario non trovato", HttpStatus.NOT_FOUND);
        }
        POI poi = gestorePOI.getPOI(poiID);
        if (poi == null) {
            return new ResponseEntity<>("Errore: POI non trovato", HttpStatus.NOT_FOUND);
        }
        gestoreItinerario.rimuoviPOIDaItinerario(itinerarioID, poi);
        return new ResponseEntity<>("POI rimosso dall'itinerario correttamente", HttpStatus.OK);
    }

}
