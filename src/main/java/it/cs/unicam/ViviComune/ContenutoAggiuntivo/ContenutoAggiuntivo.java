package it.cs.unicam.ViviComune.ContenutoAggiuntivo;

import it.cs.unicam.ViviComune.Stato;

import java.io.File;

public class ContenutoAggiuntivo {
    private String id;
    private String autore;
    private String descrizione;
    private File file;
    private Stato statoContenuto;

    public ContenutoAggiuntivo(String id, String nome, String descrizione, File file){
        this.id = id;
        this.autore = autore;
        this.descrizione = descrizione;
        this.file = file;
    }
    public String getId(){return id;}
    public void setId(String id){this.id = id;}
    public String getAutore(){return autore;}
    public void setAutore(String autore){this.autore = autore;}
    public String getDescrizione(){return descrizione;}

    public void setDescrizione(String descrizione) {
        this.descrizione = descrizione;
    }

    public Stato getStatoContenuto() {
        return statoContenuto;
    }
    public void setStatoContenuto(Stato statoContenuto) {
        this.statoContenuto = statoContenuto;
    }

    public File getFile(){return file;}
    public void setFile(File file){this.file = file;}
}
