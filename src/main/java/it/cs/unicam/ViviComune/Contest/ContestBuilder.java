package it.cs.unicam.ViviComune.Contest;

import it.cs.unicam.ViviComune.POI.POI;

import java.util.Date;

public class ContestBuilder {
    private String id;
    private String nome;
    private String descrizione;
    private Date dataInizio;
    private Date dataFine;
    private POI poi;
    private boolean isPubblico;

    public ContestBuilder(String id) {
        this.id = id;
    }

    public ContestBuilder withNome(String nome) {
        this.nome = nome;
        return this;
    }

    public ContestBuilder withDescrizione(String descrizione) {
        this.descrizione = descrizione;
        return this;
    }

    public ContestBuilder withDataInizio(Date dataInizio) {
        this.dataInizio = dataInizio;
        return this;
    }

    public ContestBuilder withDataFine(Date dataFine) {
        this.dataFine = dataFine;
        return this;
    }

    public ContestBuilder withPOI(POI poi) {
        this.poi = poi;
        return this;
    }

    public ContestBuilder isPubblico(boolean isPubblico) {
        this.isPubblico = isPubblico;
        return this;
    }

    public Contest build() {
        return new Contest(id, nome, descrizione, dataInizio, dataFine, poi, isPubblico);
    }
}
