package cc3201.tarea1.corregida.Habilidad;

import cc3201.tarea1.corregida.Entrenador;

public interface IHabilidad {

    String getNombre();

    int getCoste();

    void activar(Entrenador entrenador);
}
