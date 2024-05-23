package it.cs.unicam.ViviComune.POI;

public class POI {
    private int id;
    private String nome;
    private String descrizione;
    public POI(int id, String nome, String descrizione) {
        this.id = id;
        this.nome = nome;
        this.descrizione = descrizione;
    }
    public int getId() {
        return id;
    }
    public String getNome() {
        return nome;
    }
    public String getDescrizione() {
        return descrizione;
    }

}
