package it.cs.unicam.ViviComune.Segnalazione;

public class Segnalazione {
    private String id;
    private String descrizione;
    private TipoRiferimento tipoRiferimento;
    private String riferimentoId;

    public Segnalazione(String id, String descrizione, TipoRiferimento tipoRiferimento, String riferimentoId) {
        this.id = id;
        this.descrizione = descrizione;
        this.tipoRiferimento = tipoRiferimento;
        this.riferimentoId = riferimentoId;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getDescrizione() {
        return descrizione;
    }

    public void setDescrizione(String descrizione) {
        this.descrizione = descrizione;
    }

    public TipoRiferimento getTipoRiferimento() {
        return tipoRiferimento;
    }

    public void setTipoRiferimento(TipoRiferimento tipoRiferimento) {
        this.tipoRiferimento = tipoRiferimento;
    }

    public String getRiferimentoId() {
        return riferimentoId;
    }

    public void setRiferimentoId(String riferimentoId) {
        this.riferimentoId = riferimentoId;
    }
}


