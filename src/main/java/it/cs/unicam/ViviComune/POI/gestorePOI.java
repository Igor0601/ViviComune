package it.cs.unicam.ViviComune.POI;

import it.cs.unicam.ViviComune.Itinerario.GestoreItinerario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;

@Service
public class gestorePOI {

    private List<POI> poiList;

    @Autowired
    private GestoreItinerario gestoreItinerario;

    public gestorePOI() {
        poiList = new ArrayList<>();
    }

    public void creaPOI(String id, String nome, String descrizione) {
        POI poi = new POI(id, nome, descrizione);
        poiList.add(poi);
    }

    public void modificaPOI(String id, String nome, String descrizione) {
        for (POI poi : poiList) {
            if (poi.getId().equals(id)) {
                poi.setNome(nome);
                poi.setDescrizione(descrizione);
                break;
            }
        }
    }

    public void eliminaPOI(String id) {
        POI poiDaEliminare = null;
        for (POI poi : poiList) {
            if (poi.getId().equals(id)) {
                poiDaEliminare = poi;
                break;
            }
        }
        if (poiDaEliminare != null) {
            poiList.remove(poiDaEliminare);
            gestoreItinerario.rimuoviPOIdaTuttiItinerari(poiDaEliminare);
        }
    }

    public POI getPOI(String id) {
        for (POI poi : poiList) {
            if (poi.getId().equals(id)){
                return poi;
            }
        }
        return null;
    }

    public List<POI> getTuttiPOI() {
        return new ArrayList<>(poiList);
    }
}