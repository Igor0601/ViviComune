package it.cs.unicam.ViviComune.Contest;

import it.cs.unicam.ViviComune.Utente.Utente;
import it.cs.unicam.ViviComune.POI.POI;
import it.cs.unicam.ViviComune.ContenutoAggiuntivo.contenutoAggiuntivo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class GestoreContest {
    @Autowired
    private ContestRepository contestRepository;

    public void creaContest(String id, String nome, String descrizione, Date dataInizio, Date dataFine, POI poi, boolean isPubblico) {
        Contest contest = new Contest(id, nome, descrizione, dataInizio, dataFine, poi, isPubblico);
        contestRepository.save(contest);
    }

    public void eliminaContest(String id) {
        contestRepository.deleteById(id);
    }

    public Contest getContest(String id) {
        Optional<Contest> contest = contestRepository.findById(id);
        return contest.orElse(null);
    }

    public List<Contest> getTuttiContests() {
        return contestRepository.findAll();
    }

    public void aggiungiPartecipante(String contestId, Utente utente) {
        Contest contest = getContest(contestId);
        if (contest != null) {
            contest.aggiungiPartecipante(utente);
            contestRepository.save(contest);
        }
    }

    public void invitaUtente(String contestId, Utente utente) {
        Contest contest = getContest(contestId);
        if (contest != null) {
            contest.invitaUtente(utente);
            contestRepository.save(contest);
        }
    }

    public void aggiungiContenuto(String contestId, contenutoAggiuntivo contenuto) {
        Contest contest = getContest(contestId);
        if (contest != null) {
            contest.aggiungiContenuto(contenuto);
            contestRepository.save(contest);
        }
    }

    public void dichiaraVincitore(String contestId, String contenutoId) {
        Contest contest = getContest(contestId);
        if (contest != null) {
            contenutoAggiuntivo contenuto = contest.getContenuto(contenutoId);
            if (contenuto != null) {
                contest.setVincitore(contenuto.getAutore());
                contest.setContenutoVincitore(contenuto);
                contestRepository.save(contest);
            }
        }
    }
}
