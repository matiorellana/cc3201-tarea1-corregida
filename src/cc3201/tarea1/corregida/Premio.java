package cc3201.tarea1.corregida;

import cc3201.tarea1.corregida.Carta.Carta;

import java.util.ArrayList;

public class Premio {

    private ArrayList<Carta> premio;

    public Premio(){

        this.premio = new ArrayList<>();
    }

    public  void addPremio(Carta carta){

        if(this.premio.size() < 6){

            this.premio.add(carta);
        }
    }
}
