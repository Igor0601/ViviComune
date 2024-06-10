package it.cs.unicam.ViviComune.Contest;

import it.cs.unicam.ViviComune.Utente.Utente;
import it.cs.unicam.ViviComune.POI.POI;
import it.cs.unicam.ViviComune.ContenutoAggiuntivo.contenutoAggiuntivo;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class GestoreContest {
    private List<Contest> contests;

    public GestoreContest() {
        this.contests = new ArrayList<>();
    }

    public void creaContest(String id, String nome, String descrizione, Date dataInizio, Date dataFine, POI poi, boolean isPubblico) {
        Contest contest = new Contest(id, nome, descrizione, dataInizio, dataFine, poi, isPubblico);
        contests.add(contest);
    }

    public void eliminaContest(String id) {
        contests.removeIf(contest -> contest.getId().equals(id));
    }

    public Contest getContest(String id) {
        for (Contest contest : contests) {
            if (contest.getId().equals(id)) {
                return contest;
            }
        }
        return null;
    }

    public List<Contest> getTuttiContests() {
        return contests;
    }

    public void aggiungiPartecipante(String contestId, Utente utente) {
        Contest contest = getContest(contestId);
        if (contest != null) {
            contest.aggiungiPartecipante(utente);
        }
    }

    public void invitaUtente(String contestId, Utente utente) {
        Contest contest = getContest(contestId);
        if (contest != null) {
            contest.invitaUtente(utente);
        }
    }

    public void aggiungiContenuto(String contestId, contenutoAggiuntivo contenuto) {
        Contest contest = getContest(contestId);
        if (contest != null) {
            contest.aggiungiContenuto(contenuto);
        }
    }

    public void dichiaraVincitore(String contestId, contenutoAggiuntivo contenuto) {
        Contest contest = getContest(contestId);
        if (contest != null) {
            contest.dichiaraVincitore(contenuto);
        }
    }
}
