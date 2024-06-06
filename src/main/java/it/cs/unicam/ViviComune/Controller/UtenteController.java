package it.cs.unicam.ViviComune.Controller;

import it.cs.unicam.ViviComune.Utente.GestoreUtente;
import it.cs.unicam.ViviComune.Utente.Utente;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/utente")
public class UtenteController {

    private GestoreUtente gestoreUtente;

    @Autowired
    public UtenteController(GestoreUtente gestoreUtente) {
        this.gestoreUtente = gestoreUtente;
    }

    @GetMapping("/")
    public ResponseEntity<List<Utente>> getAllUtenti() {
        List<Utente> poiList = gestoreUtente.getTuttiUtenti();
        return new ResponseEntity<>(poiList, HttpStatus.OK);
    }
}
