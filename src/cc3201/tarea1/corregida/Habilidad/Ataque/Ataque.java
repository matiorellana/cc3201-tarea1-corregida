package cc3201.tarea1.corregida.Habilidad.Ataque;

import cc3201.tarea1.corregida.Entrenador;
import cc3201.tarea1.corregida.Carta.Pokemon.Pokemon;

public abstract class Ataque implements IAtaque {

    protected String nombre;
    protected int dano;
    protected int coste;
    protected String descripcion;

    protected Ataque(String nombre, int dano, int coste, String descripcion){

        this.nombre = nombre;
        this.dano = dano;
        this.coste = coste;
        this.descripcion = descripcion;
    }

    @Override
    public int getDano(){

        return this.dano;
    }

    @Override
    public int getCoste(){

        return this.coste;
    }

    @Override
    public String getNombre(){

        return this.nombre;
    }

    @Override
    public void activar(Entrenador entrenador){

        this.attack(entrenador);
    }

    public abstract boolean comprobar(Pokemon pokemon);

    public abstract void attack(Entrenador entrenador);
}
