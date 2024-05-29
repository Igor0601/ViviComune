package it.cs.unicam.ViviComune.POI;

import it.cs.unicam.ViviComune.Utente.GestoreItinerario;

import java.util.ArrayList;
import java.util.List;

public class gestorePOI {

    private List<POI> poiList;
    private GestoreItinerario gestoreItinerario;

    public gestorePOI() {
        poiList = new ArrayList<>();
    }

    public void creaPOI(int id, String nome, String descrizione) {
        POI poi = new POI(id, nome, descrizione);
        poiList.add(poi);
    }

    public void modificaPOI(int id, String nome, String descrizione) {
        for (POI poi : poiList) {
            if (poi.getId() == id) {
                poi.setNome(nome);
                poi.setDescrizione(descrizione);
                break;
            }
        }
    }

    public void eliminaPOI(int id) {
        POI poiDaEliminare = null;
        for (POI poi : poiList) {
            if (poi.getId() == id) {
                poiDaEliminare = poi;
                break;
            }
        }
        if (poiDaEliminare != null) {
            poiList.remove(poiDaEliminare);
            gestoreItinerario.rimuoviPOIdaTuttiItinerari(poiDaEliminare);
        }
    }

    public POI getPOI(int id) {
        for (POI poi : poiList) {
            if (poi.getId() == id) {
                return poi;
            }
        }
        return null;
    }

    public List<POI> getTuttiPOI() {
        return poiList;
    }
}