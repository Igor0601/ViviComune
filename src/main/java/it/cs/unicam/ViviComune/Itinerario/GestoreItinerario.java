package it.cs.unicam.ViviComune.Itinerario;

import it.cs.unicam.ViviComune.POI.POI;

import java.util.ArrayList;
import java.util.List;

public class GestoreItinerario {
    private List<Itinerario> itinerarioList;

    public GestoreItinerario() {
        itinerarioList = new ArrayList<Itinerario>();
    }

    public Itinerario getItinerario(int ID){
        for(Itinerario itinerario : itinerarioList) {
            if (itinerario.getID() == ID) {
                return itinerario;
            }
        }
        return null;
    }

    public void creaItinerario(int ID, String nome, String descrizione){
        Itinerario itinerario = new Itinerario(ID, nome, descrizione);
        itinerarioList.add(itinerario);
    }

    public void modificaItinerario(int ID, String nome, String descrizione){
        for(Itinerario itinerario : itinerarioList) {
            if (itinerario.getID() == ID) {
                itinerario.setNome(nome);
                itinerario.setDescrizione(descrizione);
                break;
            }
        }
    }

    public void aggiungiPOIAllItinerario(int itinerarioID, POI poi){
        Itinerario itinerario = getItinerario(itinerarioID);
        if(itinerario != null){
            itinerario.aggiungiPOI(poi);
        }
    }

    public void rimuoviPOIDaItinerario(int itinerarioID, POI poi){
        Itinerario itinerario = getItinerario(itinerarioID);
        if(itinerario != null){
            itinerario.rimuoviPOI(poi);
        }
    }

    public void eliminaItinerario(int ID){
        for(int i = 0; i<itinerarioList.size(); i++){
            if(itinerarioList.get(i).getID() == ID){
                itinerarioList.remove(i);
                break;
            }
        }
    }

    public void rimuoviPOIdaTuttiItinerari(POI poi) {
        for (Itinerario itinerario : itinerarioList) {
            itinerario.rimuoviPOI(poi);
        }
    }

    public List<Itinerario> getTuttiItinerari(){
        return itinerarioList;
    }
}