package cc3201.tarea1.corregida.Carta.Pokemon.Fase1;

import cc3201.tarea1.corregida.Carta.Pokemon.VisitorPokemon;
import cc3201.tarea1.corregida.Entrenador;

public interface PokemonFase1 {

    void accept(VisitorPokemon visitor, Entrenador entrenador);
}
