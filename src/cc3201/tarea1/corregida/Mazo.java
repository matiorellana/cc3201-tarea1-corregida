package cc3201.tarea1.corregida;

import cc3201.tarea1.corregida.Carta.Carta;

import java.util.ArrayList;

public class Mazo {

    private ArrayList<Carta> mazo;

    public Mazo(){

        this.mazo = new ArrayList<>();
    }

    public void robar(Entrenador entrenador){

        entrenador.addMano(this.mazo.get(0));
    }

    public void addCarta(Carta carta) {

        if (this.mazo.size() < 60){
            this.mazo.add(carta);
        }
    }
}
