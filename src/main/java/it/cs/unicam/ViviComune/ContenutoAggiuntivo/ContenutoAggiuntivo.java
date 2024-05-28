package it.cs.unicam.ViviComune.ContenutoAggiuntivo;

import java.io.File;

public class ContenutoAggiuntivo {
    private int ID;
    private String autore;
    private String descrizione;
    private File file;

    public ContenutoAggiuntivo(int ID, String nome, String descrizione, File file){
        this.ID = ID;
        this.autore = autore;
        this.descrizione = descrizione;
        this.file = file;
    }
    public int getID(){return ID;}
    public String getAutore(){return autore;}
    public String getDescrizione(){return descrizione;}
    public File getFile(){return file;}
}