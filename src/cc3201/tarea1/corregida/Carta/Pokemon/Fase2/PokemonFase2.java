package cc3201.tarea1.corregida.Carta.Pokemon.Fase2;

import cc3201.tarea1.corregida.Carta.Pokemon.VisitorPokemon;
import cc3201.tarea1.corregida.Entrenador;

public interface PokemonFase2 {

    void accept(VisitorPokemon visitor, Entrenador entrenador);
}
