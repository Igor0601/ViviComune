package it.cs.unicam.ViviComune.ContenutoAggiuntivo;

import it.cs.unicam.ViviComune.POI.POI;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class GestoreContenutoAggiuntivo {
    private List<ContenutoAggiuntivo> contenutoList;

    public GestoreContenutoAggiuntivo() {
        contenutoList = new ArrayList<>();
    }

    public void creaContenutoAggiuntivo(String id, String nome, String descrizione, File file) {
        ContenutoAggiuntivo contenuto = new ContenutoAggiuntivo(id, nome, descrizione, file);
        contenutoList.add(contenuto);
    }

    public void eliminaContenutoAggiuntivo(String id){
        for(int i = 0; i<contenutoList.size(); i++){
            if(contenutoList.get(i).getId().equals(id)){
                contenutoList.remove(i);
                break;
            }
        }
    }
}
