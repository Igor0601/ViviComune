package it.cs.unicam.ViviComune.Utente;

import java.util.ArrayList;
import java.util.List;

public class GestoreUtente {
    private List<Utente> utenti;

    public GestoreUtente() {
        this.utenti = new ArrayList<>();
    }

    public void creaUtente(int id, String nome, String cognome, String email, String username, RuoloUtente ruolo) {
        Utente utente = new Utente(id, nome, cognome, email, username, ruolo);
        utenti.add(utente);
    }

    public void modificaUtente(int id, String nome, String cognome, String email, RuoloUtente ruolo) {
        for (Utente utente : utenti) {
            if (utente.getId() == id) {
                utente.setNome(nome);
                utente.setCognome(cognome);
                utente.setEmail(email);
                utente.setRuolo(ruolo);
                break;
            }
        }
    }

    public void eliminaUtente(int id) {
        utenti.removeIf(utente -> utente.getId() == id);
    }

    public Utente getUtente(int id) {
        for (Utente utente : utenti) {
            if (utente.getId() == id) {
                return utente;
            }
        }
        return null;
    }

    public List<Utente> getTuttiUtenti() {
        return utenti;
    }
}
