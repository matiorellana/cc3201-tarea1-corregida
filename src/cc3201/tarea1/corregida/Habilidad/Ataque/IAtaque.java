package cc3201.tarea1.corregida.Habilidad.Ataque;

import cc3201.tarea1.corregida.Entrenador;
import cc3201.tarea1.corregida.Carta.Pokemon.Pokemon;
import cc3201.tarea1.corregida.Habilidad.IHabilidad;

public interface IAtaque extends IHabilidad {

    int getDano();

    boolean comprobar(Pokemon pokemon);

    void attack(Entrenador entrenador);
}
