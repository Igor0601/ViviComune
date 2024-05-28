package it.cs.unicam.ViviComune.Contest;

import it.cs.unicam.ViviComune.ContenutoAggiuntivo.ContenutoAggiuntivo;
import it.cs.unicam.ViviComune.POI.POI;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class GestoreContest {
    private List<Contest> contestList;
    public GestoreContest(){
        this.contestList = new ArrayList<>();
    }
    public void creaContest(int ID, String nome, String descrizione, String tipo, LocalDate dataInizio, LocalDate dataFine, POI poi){
        Contest contest = new Contest(ID, nome, descrizione, tipo, dataInizio,dataFine,poi);
        contestList.add(contest);
    }
    public void modificaContest(int ID, String nome, String descrizione, String tipo, LocalDate dataInizio, LocalDate dataFine, POI poi){
        for(Contest contest : contestList){
            if(contest.getID() == ID){
                contest.setNome(nome);
                contest.setTipo(tipo);
                contest.setDescrizione(descrizione);
                contest.setDataInizio(dataInizio);
                contest.setDataFine(dataFine);
                break;
            }
        }
    }
    public void eliminaCotest(int ID){
        contestList.removeIf(contest -> contest.getID() == ID);
    }
    public Contest getContest(int ID){
        for(Contest contest : contestList){
            if(contest.getID() == ID) return  contest;
        }
        return null;
    }
    public List<Contest> getTuttiContest(){
        return contestList;
    }
    public ContenutoAggiuntivo scegliVincitore(){
        //TODO implementare
        return null;
    }
}