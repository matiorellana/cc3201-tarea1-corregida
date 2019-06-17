package cc3201.tarea1.corregida.Carta.Entrenador.Objeto;

import cc3201.tarea1.corregida.Entrenador;

public abstract class Objeto implements IObjeto{

    protected String nombre;
    protected String descripcion;

    protected Objeto(String nombre, String descripcion){

        this.nombre = nombre;
        this.descripcion = descripcion;
    }

    @Override
    public void jugar(Entrenador entrenador){

        this.efecto(entrenador);
    }

    @Override
    public String getNombre(){

        return this.nombre;
    }

    @Override
    public abstract void efecto(Entrenador entrenador);
}
