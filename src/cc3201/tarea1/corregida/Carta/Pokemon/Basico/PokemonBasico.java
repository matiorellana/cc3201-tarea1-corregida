package cc3201.tarea1.corregida.Carta.Pokemon.Basico;

import cc3201.tarea1.corregida.Carta.Pokemon.IPokemon;
import cc3201.tarea1.corregida.Carta.Pokemon.VisitorPokemon;
import cc3201.tarea1.corregida.Entrenador;

public interface PokemonBasico extends IPokemon {

    void accept(VisitorPokemon visitor, Entrenador entrenador);
}
