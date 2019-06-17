package cc3201.tarea1.corregida.Carta.Pokemon.Fase2;

import cc3201.tarea1.corregida.Ataque.Ataque;
import cc3201.tarea1.corregida.Carta.Pokemon.IPokemon;
import cc3201.tarea1.corregida.Carta.Pokemon.PokemonLucha;
import cc3201.tarea1.corregida.Carta.Pokemon.VisitorPokemon;
import cc3201.tarea1.corregida.Entrenador;

import java.util.ArrayList;

public class PokemonFase2Lucha extends PokemonLucha implements IPokemon, PokemonFase2 {

    public PokemonFase2Lucha(String nombre, int id, int salud, ArrayList<Ataque> ataques){

        super(nombre, id, salud, ataques);
    }

    @Override
    public void play(Entrenador entrenador) {

        this.accept(this.visitor, entrenador);
    }

    @Override
    public void accept(VisitorPokemon visitor, Entrenador entrenador) {
        visitor.visitorFase(this, entrenador);
    }
}