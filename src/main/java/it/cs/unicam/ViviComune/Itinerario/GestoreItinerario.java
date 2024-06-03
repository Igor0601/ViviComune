package it.cs.unicam.ViviComune.Itinerario;
import it.cs.unicam.ViviComune.POI.POI;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class GestoreItinerario {
    private List<Itinerario> itinerarioList;

    public GestoreItinerario() {
        itinerarioList = new ArrayList<Itinerario>();
    }

    public Itinerario getItinerario(String ID){
        for(Itinerario itinerario : itinerarioList) {
            if (itinerario.getID().equals(ID)) {
                return itinerario;
            }
        }
        return null;
    }

    public void creaItinerario(String ID, String nome, String descrizione){
        Itinerario itinerario = new Itinerario(ID, nome, descrizione);
        itinerarioList.add(itinerario);
    }

    public void modificaItinerario(String ID, String nome, String descrizione){
        for(Itinerario itinerario : itinerarioList) {
            if (itinerario.getID().equals(ID)) {
                itinerario.setNome(nome);
                itinerario.setDescrizione(descrizione);
                break;
            }
        }
    }

    public void aggiungiPOIAllItinerario(String itinerarioID, POI poi){
        Itinerario itinerario = getItinerario(itinerarioID);
        if(itinerario != null){
            itinerario.aggiungiPOI(poi);
        }
    }

    public void rimuoviPOIDaItinerario(String itinerarioID, POI poi){
        Itinerario itinerario = getItinerario(itinerarioID);
        if(itinerario != null){
            itinerario.rimuoviPOI(poi);
        }
    }

    public void rimuoviPOIdaTuttiItinerari(POI poi) {
        for (Itinerario itinerario : itinerarioList) {
            itinerario.rimuoviPOI(poi);
        }
    }

    public void eliminaItinerario(String ID){
        for(int i = 0; i<itinerarioList.size(); i++){
            if(itinerarioList.get(i).getID().equals(ID)){
                itinerarioList.remove(i);
                break;
            }
        }
    }

    public List<Itinerario> getTuttiItinerari(){
        return new ArrayList<>(itinerarioList);
    }

    public boolean esisteItinerarioConID(String ID) {
        for (Itinerario itinerario : itinerarioList) {
            if (itinerario.getID().equals(ID)) {
                return true;
            }
        }
        return false;
    }

    public boolean esisteItinerarioConNome(String nome) {
        for (Itinerario itinerario : itinerarioList) {
            if (itinerario.getNome().equals(nome)) {
                return true;
            }
        }
        return false;
    }
}