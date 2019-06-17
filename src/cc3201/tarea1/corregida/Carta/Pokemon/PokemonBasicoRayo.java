package cc3201.tarea1.corregida.Carta.Pokemon;

import cc3201.tarea1.corregida.Ataque.Ataque;
import cc3201.tarea1.corregida.Entrenador;

import java.util.ArrayList;

public class PokemonBasicoRayo extends PokemonRayo implements IPokemon, PokemonBasico {

    public PokemonBasicoRayo(String nombre, int id, int salud, ArrayList<Ataque> ataques){

        super(nombre, id, salud, ataques);
    }

    @Override
    public void play(Entrenador entrenador) {

        this.accept(this.visitor, entrenador);
    }

    @Override
    public void accept(VisitorPokemon visitor, Entrenador entrenador) {
        visitor.visitorBasico(this, entrenador);
    }
}