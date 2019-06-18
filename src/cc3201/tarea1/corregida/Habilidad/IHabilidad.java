package cc3201.tarea1.corregida.Habilidad;

import cc3201.tarea1.corregida.Carta.Pokemon.Pokemon;
import cc3201.tarea1.corregida.Entrenador;

public interface IHabilidad {

    String getNombre();

    int getCoste();

    void activar(Entrenador jugador, Entrenador rival);

    boolean comprobar(Pokemon pokemonActivo);
}
