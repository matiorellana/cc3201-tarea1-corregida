package cc3201.tarea1.corregida.Carta.Pokemon;

import cc3201.tarea1.corregida.Habilidad.Ataque.Ataque;
import cc3201.tarea1.corregida.Entrenador;
import cc3201.tarea1.corregida.Habilidad.IHabilidad;

import java.util.ArrayList;

public abstract class PokemonAgua extends Pokemon implements IPokemon {

    public PokemonAgua(String nombre, int id, int salud, ArrayList<IHabilidad> ataques) {

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

        this.danoDebilidad(ataque);
    }

    @Override
    public void danoRayo(Ataque ataque) {

        this.danoDebilidad(ataque);
    }

    @Override
    public void danoLucha(Ataque ataque) {

        this.danoResistencia(ataque);
    }

    @Override
    public void danoPsiquico(Ataque ataque) {

        this.danoEstandar(ataque);
    }

    public abstract void play(Entrenador entrenador);
}
