package it.cs.unicam.ViviComune.ContenutoAggiuntivo;

import it.cs.unicam.ViviComune.Utils.Stato;
import java.io.File;

public class contenutoAggiuntivo {
    private String id;
    private String nome;
    private String descrizione;
    private File file;
    private Stato statoContenuto;

    public contenutoAggiuntivo(String id, String nome, String descrizione, File file){
        this.id = id;
        this.nome = nome;
        this.descrizione = descrizione;
        this.file = file;
        this.statoContenuto = Stato.ATTESA;
    }
    public String getId(){return id;}
    public void setId(String id){this.id = id;}
    public String getNome(){return nome;}
    public void setNome(String nome){this.nome = nome;}
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

    public void approvaContenuto(){
        this.setStatoContenuto(Stato.APPROVATO);
    }

    public void disapprovaContenuto(){
        this.setStatoContenuto(Stato.DISAPPROVATO);
    }

    public File getFile(){return file;}
    public void setFile(File file){this.file = file;}
}