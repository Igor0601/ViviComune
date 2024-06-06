package it.cs.unicam.ViviComune.POI;

import it.cs.unicam.ViviComune.ContenutoAggiuntivo.contenutoAggiuntivo;
import it.cs.unicam.ViviComune.Utils.Coordinate;
import it.cs.unicam.ViviComune.Utils.Stato;

import java.util.ArrayList;
import java.util.List;

public class POI {
    private String id;
    private String nome;
    private String descrizione;
    private Stato statoPOI;
    private Coordinate coordinate;
    private List<contenutoAggiuntivo> listaContenutiAggiuntivi;
    public POI(String id, String nome, String descrizione, Coordinate coordinate) {
        this.id = id;
        this.nome = nome;
        this.descrizione = descrizione;
        this.listaContenutiAggiuntivi = new ArrayList<>();
        this.statoPOI = Stato.ATTESA;
        this.coordinate = coordinate;

    }
    public String getId() {
        return id;
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

    public List<contenutoAggiuntivo> getListaContenutiAggiuntivi() {
        return listaContenutiAggiuntivi;
    }

    public Stato getStatoPOI() {
        return statoPOI;
    }
    public void setStatoPOI(Stato statoPOI) {
        this.statoPOI = statoPOI;
    }
    public Coordinate getCoordinate() {
        return coordinate;
    }
    public void setCoordinate(Coordinate coordinate) {
        this.coordinate = coordinate;
    }

    public void aggiungiContenutoAggiuntivo(contenutoAggiuntivo contenuto){
        this.listaContenutiAggiuntivi.add(contenuto);
    }

}
