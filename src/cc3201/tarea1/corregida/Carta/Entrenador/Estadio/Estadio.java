package cc3201.tarea1.corregida.Carta.Entrenador.Estadio;

import cc3201.tarea1.corregida.Entrenador;

public abstract class Estadio implements IEstadio{

    protected String nombre;
    protected String descripcion;

    public Estadio(String nombre, String descripcion){

        this.nombre = nombre;
        this.descripcion = descripcion;
    }

    @Override
    public void reemplazar(Estadio estadio, Entrenador entrenador) {

        estadio.jugar(entrenador);
    }

    @Override
    public String getNombre() {
        return null;
    }

    @Override
    public abstract void jugar(Entrenador entrenador);
}
