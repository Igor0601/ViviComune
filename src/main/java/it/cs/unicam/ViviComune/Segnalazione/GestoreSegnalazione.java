package it.cs.unicam.ViviComune.Segnalazione;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class GestoreSegnalazione {
    private List<Segnalazione> segnalazioni;

    public GestoreSegnalazione() {
        this.segnalazioni = new ArrayList<>();
    }

    public void creaSegnalazione(String id, String descrizione, TipoRiferimento tipoRiferimento, String riferimentoId) {
        Segnalazione segnalazione = new Segnalazione(id, descrizione, tipoRiferimento, riferimentoId);
        segnalazioni.add(segnalazione);
    }

    public void eliminaSegnalazione(String id) {
        segnalazioni.removeIf(segnalazione -> segnalazione.getId().equals(id));
    }

    public Segnalazione getSegnalazione(String id) {
        for (Segnalazione segnalazione : segnalazioni) {
            if (segnalazione.getId().equals(id)) {
                return segnalazione;
            }
        }
        return null;
    }

    public List<Segnalazione> getTutteSegnalazioni() {
        return segnalazioni;
    }
}

