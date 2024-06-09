package it.cs.unicam.ViviComune.Utente;

import it.cs.unicam.ViviComune.Itinerario.Itinerario;
import it.cs.unicam.ViviComune.POI.POI;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class GestoreUtente {
    private List<Utente> utenti;

    public GestoreUtente() {
        this.utenti = new ArrayList<>();
    }

    public void creaUtente(String id, String nome, String cognome, String email, String username, RuoloUtente ruolo) {
        Utente utente = new Utente(id, nome, cognome, email, username, ruolo);
        utenti.add(utente);
    }

    public void modificaUtente(String id, String nome, String cognome, String email, RuoloUtente ruolo) {
        for (Utente utente : utenti) {
            if (utente.getId().equals(id)) {
                utente.setNome(nome);
                utente.setCognome(cognome);
                utente.setEmail(email);
                utente.setRuolo(ruolo);
                break;
            }
        }
    }

    public void eliminaUtente(String id) {
        utenti.removeIf(utente -> utente.getId().equals(id));
    }

    public Utente getUtente(String id) {
        for (Utente utente : utenti) {
            if (utente.getId().equals(id)) {
                return utente;
            }
        }
        return null;
    }

    public List<Utente> getTuttiUtenti() {
        return utenti;
    }

    public boolean esisteUtenteConEmail(String email) {
        for (Utente utente : utenti) {
            if (utente.getEmail().equals(email)) {
                return true;
            }
        }
        return false;
    }

    public boolean esisteUtenteConUsername(String username) {
        for (Utente utente : utenti) {
            if (utente.getUsername().equals(username)) {
                return true;
            }
        }
        return false;
    }

    public void aggiungiPOISalvato(String userId, POI poi) {
        Utente utente = getUtente(userId);
        if (utente != null) {
            utente.aggiungiPOISalvato(poi);
        }
    }

    public void aggiungiItinerarioSalvato(String userId, Itinerario itinerario) {
        Utente utente = getUtente(userId);
        if (utente != null) {
            utente.aggiungiItinerarioSalvato(itinerario);
        }
    }
}
