package cc3201.tarea1.corregida.Habilidad;

import cc3201.tarea1.corregida.Entrenador;

public abstract class Habilidad implements IHabilidad {

    protected String nombre;
    protected int coste;
    protected String descripcion;

    protected Habilidad(String nombre, int coste, String descripcion){

        this.nombre = nombre;
        this.coste = coste;
        this.descripcion = descripcion;
    }

    @Override
    public String getNombre() {
        return this.nombre;
    }

    @Override
    public int getCoste() {
        return this.coste;
    }

    @Override
    public abstract void activar(Entrenador entrenador);
}
