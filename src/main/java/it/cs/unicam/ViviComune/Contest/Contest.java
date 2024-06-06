package it.cs.unicam.ViviComune.Contest;
import it.cs.unicam.ViviComune.ContenutoAggiuntivo.contenutoAggiuntivo;
import it.cs.unicam.ViviComune.POI.POI;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Contest {
    private int ID;
    private String nome;
    private String descrizione;
    private String tipo;
    private LocalDate dataInizio;
    private LocalDate dataFine;
    private POI poi;
    private List<contenutoAggiuntivo> contenuti;
    private List<String> invitati;

    public Contest(int ID, String nome, String descrizione, String tipo, LocalDate dataInizio, LocalDate dataFine, POI poi) {
        this.ID = ID;
        this.nome = nome;
        this.descrizione = descrizione;
        this.dataInizio = dataInizio;
        this.dataFine = dataFine;
        this.poi = poi;
        this.contenuti = new ArrayList<>();
        this.invitati = new ArrayList<>();
        this.tipo = tipo;
    }

    public int getID() {
        return ID;
    }
    public String getNome() {
        return nome;
    }
    public String getDescrizione() {
        return descrizione;
    }
    public String getTipo() {
        return tipo;
    }
    public LocalDate getDataInizio() {
        return dataInizio;
    }
    public LocalDate getDataFine() {
        return dataFine;
    }
    public POI getPoi() {
        return poi;
    }
    public List<contenutoAggiuntivo> getContenuti(){
        return contenuti;
    }
    public List<String> getInvitati(){
        return invitati;
    }
    public void setID(int ID) {
        this.ID = ID;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
    public void setDescrizione(String descrizione) {
        this.descrizione = descrizione;
    }
    public void setTipo(String tipo) {
        this.tipo = tipo;
    }
    public void setDataInizio(LocalDate dataInizio) {
        this.dataInizio = dataInizio;
    }
    public void setDataFine(LocalDate dataFine) {
        this.dataFine = dataFine;
    }
    public void setPoi(POI poi) {
        this.poi = poi;
    }
    public void setContenuti(List<contenutoAggiuntivo> contenuti) {
        this.contenuti = contenuti;
    }
    public void setInvitati(List<String> invitati) {
        this.invitati = invitati;
    }
    public void aggiungiInvitato(String username){
        if(tipo.equals("privato")){
            invitati.add(username);
        }
    }
}