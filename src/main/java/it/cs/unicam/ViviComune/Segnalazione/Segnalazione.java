package it.cs.unicam.ViviComune.Segnalazione;

public class Segnalazione {
    private int id;
    private String descrizione;

    public Segnalazione(int id, String descrizione) {
        this.id = id;
        this.descrizione = descrizione;
    }
    public int getId() {
        return id;
    }
    public String getDescrizione() {
        return descrizione;
    }
    public void setDescrizione(String descrizione) {
        this.descrizione = descrizione;
    }

}
