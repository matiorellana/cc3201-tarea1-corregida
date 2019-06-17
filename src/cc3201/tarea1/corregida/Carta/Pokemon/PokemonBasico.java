package cc3201.tarea1.corregida.Carta.Pokemon;

import cc3201.tarea1.corregida.Entrenador;

public interface PokemonBasico extends IPokemon {

    void accept(VisitorPokemon visitor, Entrenador entrenador);
}
