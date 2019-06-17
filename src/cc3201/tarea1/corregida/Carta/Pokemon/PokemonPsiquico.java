package cc3201.tarea1.corregida.Carta.Pokemon;

import cc3201.tarea1.corregida.Habilidad.Ataque.Ataque;
import cc3201.tarea1.corregida.Entrenador;

import java.util.ArrayList;

public abstract class PokemonPsiquico extends Pokemon implements IPokemon {

    public PokemonPsiquico(String nombre, int id, int salud, ArrayList<Ataque> ataques) {

        super(nombre, id, salud, ataques);
    }

    @Override
    public void danoFuego(Ataque ataque) {

        this.danoEstandar(ataque);
    }

    @Override
    public void danoAgua(Ataque ataque) {

        this.danoEstandar(ataque);
    }

    @Override
    public void danoPlanta(Ataque ataque) {

        this.danoEstandar(ataque);
    }

    @Override
    public void danoRayo(Ataque ataque) {

        this.danoEstandar(ataque);
    }

    @Override
    public void danoLucha(Ataque ataque) {

        this.danoResistencia(ataque);
    }

    @Override
    public void danoPsiquico(Ataque ataque) {

        this.danoDebilidad(ataque);
    }

    public abstract void play(Entrenador entrenador);
}
