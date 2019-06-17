package cc3201.tarea1.corregida.Carta.Pokemon;

import cc3201.tarea1.corregida.Entrenador;

import java.util.ArrayList;

public class VisitorPokemon {

    public void visitorBasico(Pokemon basico, Entrenador entrenador){

        entrenador.addBanca(basico);
    }

    public void visitorFase(Pokemon fase, Entrenador entrenador){

        ArrayList<Pokemon> banca = entrenador.getBanca();
        for(int i = 0; i < banca.size(); i++){
            if(banca.get(i).getID()+1 == fase.getID()){
                fase.heredarEnergia(banca.get(i));
                entrenador.descartarCarta(banca.get(i));
                entrenador.getBanca().remove(i);
                entrenador.getBanca().add(i, fase);
                break;
            }
        }
    }
}
