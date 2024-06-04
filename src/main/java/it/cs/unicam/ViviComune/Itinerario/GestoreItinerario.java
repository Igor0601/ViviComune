package it.cs.unicam.ViviComune.Itinerario;
import it.cs.unicam.ViviComune.POI.POI;
import it.cs.unicam.ViviComune.Stato;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class GestoreItinerario {
    private List<Itinerario> itinerarioList;

    public GestoreItinerario() {
        itinerarioList = new ArrayList<Itinerario>();
    }

    public Itinerario getItinerario(String id){
        for(Itinerario itinerario : itinerarioList) {
            if (itinerario.getId().equals(id)) {
                return itinerario;
            }
        }
        return null;
    }

    public void creaItinerario(String id, String nome, String descrizione){
        Itinerario itinerario = new Itinerario(id, nome, descrizione);
        itinerarioList.add(itinerario);
    }

    public void modificaItinerario(String id, String nome, String descrizione){
        for(Itinerario itinerario : itinerarioList) {
            if (itinerario.getId().equals(id)) {
                itinerario.setNome(nome);
                itinerario.setDescrizione(descrizione);
                break;
            }
        }
    }

    public void aggiungiPOIAllItinerario(String itinerarioId, POI poi){
        Itinerario itinerario = getItinerario(itinerarioId);
        if(itinerario != null){
            itinerario.aggiungiPOI(poi);
        }
    }

    public void rimuoviPOIDaItinerario(String itinerarioId, POI poi){
        Itinerario itinerario = getItinerario(itinerarioId);
        if(itinerario != null){
            itinerario.rimuoviPOI(poi);
        }
    }

    public void rimuoviPOIdaTuttiItinerari(POI poi) {
        for (Itinerario itinerario : itinerarioList) {
            itinerario.rimuoviPOI(poi);
        }
    }

    public void eliminaItinerario(String id){
        for(int i = 0; i<itinerarioList.size(); i++){
            if(itinerarioList.get(i).getId().equals(id)){
                itinerarioList.remove(i);
                break;
            }
        }
    }

    public List<Itinerario> getTuttiItinerari(){
        return new ArrayList<>(itinerarioList);
    }

    public boolean esisteItinerarioConId(String id) {
        for (Itinerario itinerario : itinerarioList) {
            if (itinerario.getId().equals(id)) {
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

    public void approvaItinerario(String id){
        for (Itinerario itinerario : itinerarioList) {
            if (itinerario.getId().equals(id)) {
                itinerario.setStatoItinerario(Stato.APPROVATO);
            }
        }
    }

    public void disapprovaItinerario(String id){
        for (Itinerario itinerario : itinerarioList) {
            if (itinerario.getId().equals(id)) {
                itinerario.setStatoItinerario(Stato.DISAPPROVATO);
            }
        }
    }
}