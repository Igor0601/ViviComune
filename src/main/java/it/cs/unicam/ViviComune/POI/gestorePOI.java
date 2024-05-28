package it.cs.unicam.ViviComune.POI;

import java.util.ArrayList;
import java.util.List;

public class gestorePOI {

    private List<POI> poiList;

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
        poiList.removeIf(poi -> poi.getId() == id);
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
