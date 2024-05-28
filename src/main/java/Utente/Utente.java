package Utente;

public class Utente {
    int id;
    String nome;
    String cognome;
    String email;
    String username;
    private RuoloUtente ruolo;

    public Utente(int id, String nome, String cognome, String email, String username, RuoloUtente ruolo) {
        this.id = id;
        this.nome = nome;
        this.cognome = cognome;
        this.email = email;
        this.username = username;
        this.ruolo=ruolo;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome(){
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCognome(){
        return cognome;
    }

    public void setCognome(String cognome){
        this.cognome=cognome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public RuoloUtente getRuolo() {
        return ruolo;
    }

    public void setRuolo(RuoloUtente ruolo) {
        this.ruolo = ruolo;
    }

}
