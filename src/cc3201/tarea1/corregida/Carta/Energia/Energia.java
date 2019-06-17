package cc3201.tarea1.corregida.Carta.Energia;

import cc3201.tarea1.corregida.Entrenador;
import cc3201.tarea1.corregida.Carta.Pokemon.Pokemon;

public abstract class Energia implements IEnergia {

    protected String nombre;

    protected Energia(String nombre){

        this.nombre = nombre;
    }

    @Override
    public void jugar(Entrenador entrenador) {

        entrenador.getPokemonActivo().addEnergia(this);
    }

    @Override
    public String getNombre(){

        return this.nombre;
    }

    public abstract void anadir(Pokemon pokemon);
}
