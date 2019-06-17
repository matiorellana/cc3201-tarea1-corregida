package cc3201.tarea1.corregida.Carta.Entrenador.Soporte;

import cc3201.tarea1.corregida.Entrenador;

public abstract class Soporte implements ISoporte {

    protected String nombre;
    protected String descripcion;

    protected Soporte(String nombre, String descripcion){

        this.nombre = nombre;
        this.descripcion = descripcion;
    }

    @Override
    public void descartar(Entrenador jugador) {

        jugador.descartarCarta(this);
    }

    @Override
    public String getNombre() {
        return this.nombre;
    }

    @Override
    public abstract void jugar(Entrenador entrenador);
}
