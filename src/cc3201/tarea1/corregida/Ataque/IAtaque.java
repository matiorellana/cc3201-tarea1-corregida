package cc3201.tarea1.corregida.Ataque;

import cc3201.tarea1.corregida.Entrenador;
import cc3201.tarea1.corregida.Carta.Pokemon.Pokemon;

public interface IAtaque {

    int getDano();

    boolean comprobar(Pokemon pokemon);

    void attack(Entrenador entrenador);
}
