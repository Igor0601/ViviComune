package it.cs.unicam.ViviComune.POI;

import it.cs.unicam.ViviComune.Itinerario.GestoreItinerario;
import it.cs.unicam.ViviComune.Utils.Coordinate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import it.cs.unicam.ViviComune.ContenutoAggiuntivo.contenutoAggiuntivo;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import it.cs.unicam.ViviComune.Utils.Stato;

@Service
public class gestorePOI {

    private List<POI> poiList;

    @Autowired
    private GestoreItinerario gestoreItinerario;

    public gestorePOI() {
        poiList = new ArrayList<>();
    }

    public void creaPOI(String id, String nome, String descrizione, Coordinate coordinate) {
        POI poi = new POI(id, nome, descrizione, coordinate);
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
            if (poi.getId().equals(id)) {
                return poi;
            }
        }
        return null;
    }

    public List<POI> getTuttiPOI() {
        return new ArrayList<>(poiList);
    }

    public boolean esistePOIConId(String id) {
        for (POI poi : poiList) {
            if (poi.getId().equals(id)) {
                return true;
            }
        }
        return false;
    }

    public boolean esistePOIConNome(String nome) {
        for (POI poi : poiList) {
            if (poi.getNome().equals(nome)) {
                return true;
            }
        }
        return false;
    }

    public void approvaPOI(String id) {
        for (POI poi : poiList) {
            if (poi.getId().equals(id)) {
                poi.setStatoPOI(Stato.APPROVATO);
            }
        }
    }

    public void disapprovaPOI(String id) {
        for (POI poi : poiList) {
            if (poi.getId().equals(id)) {
                poi.setStatoPOI(Stato.DISAPPROVATO);
            }
        }
    }

    public void aggiungiContenutoAggiuntivo(String poiId, String contenutoId, String nome, String descrizione, File file) {
        for (POI poi : poiList) {
            if (poi.getId().equals(poiId)) {
                contenutoAggiuntivo contenuto = new contenutoAggiuntivo(contenutoId, nome, descrizione, file);
                poi.aggiungiContenutoAggiuntivo(contenuto);
                break;
            }
        }
    }

    public void approvaContenutoAggiuntivo(String poiId, String contenutoId) {
        for (POI poi : poiList) {
            if (poi.getId().equals(poiId)) {
                for (contenutoAggiuntivo contenuto : poi.getListaContenutiAggiuntivi()) {
                    if (contenuto.getId().equals(contenutoId)) {
                        contenuto.approvaContenuto();
                        break;
                    }
                }
                break;
            }
        }
    }

    public void disapprovaContenutoAggiuntivo(String poiId, String contenutoId) {
        for (POI poi : poiList) {
            if (poi.getId().equals(poiId)) {
                for (contenutoAggiuntivo contenuto : poi.getListaContenutiAggiuntivi()) {
                    if (contenuto.getId().equals(contenutoId)) {
                        contenuto.disapprovaContenuto();
                        break;
                    }
                }
                break;
            }
        }

    }

    public void rimuoviContenutoAggiuntivo(String poiId, String contenutoId) {
        for (POI poi : poiList) {
            if (poi.getId().equals(poiId)) {
                contenutoAggiuntivo contenutoDaRimuovere = null;
                for (contenutoAggiuntivo contenuto : poi.getListaContenutiAggiuntivi()) {
                    if (contenuto.getId().equals(contenutoId)) {
                        contenutoDaRimuovere = contenuto;
                        break;
                    }
                }
                if (contenutoDaRimuovere != null) {
                    poi.getListaContenutiAggiuntivi().remove(contenutoDaRimuovere);
                }
                break;
            }
        }
    }
}