package it.cs.unicam.ViviComune.Itinerario;

import it.cs.unicam.ViviComune.POI.POI;

import java.util.ArrayList;
import java.util.List;

public class Itinerario {
    private int ID;
    private String nome;
    private String descrizione;
    private List<POI> listaPOI;

    public Itinerario(int ID, String nome, String descrizione) {
        this.ID = ID;
        this.nome = nome;
        this.descrizione = descrizione;
    }
    public int getID() {
        return ID;
    }
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDescrizione() {
        return descrizione;
    }

    public void setDescrizione(String descrizione) {
        this.descrizione = descrizione;
    }

    public List<POI> getListaPOI() {
        return listaPOI;
    }

    public void setListaPOI(List<POI> listaPOI) {
        this.listaPOI = listaPOI;
    }
}
