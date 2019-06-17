package cc3201.tarea1.corregida;

import cc3201.tarea1.corregida.Carta.Carta;

import java.util.ArrayList;

public class Descarte {

    private ArrayList<Carta> cementerio;

    public Descarte(){

        this.cementerio = new ArrayList<>();
    }

    public void remover(Carta carta){

        if(this.cementerio.contains(carta)){
            this.cementerio.remove(carta);
        }
    }

    public void addCementerio(Carta carta){

        this.cementerio.add(carta);
    }

    public ArrayList<Carta> getCementerio(){

        return this.cementerio;
    }
}
