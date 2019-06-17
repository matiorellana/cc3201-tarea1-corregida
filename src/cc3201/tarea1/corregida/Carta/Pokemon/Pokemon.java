package cc3201.tarea1.corregida.Carta.Pokemon;

import cc3201.tarea1.corregida.Ataque.Ataque;
import cc3201.tarea1.corregida.Carta.Energia.Energia;
import cc3201.tarea1.corregida.Entrenador;

import java.util.ArrayList;
import java.util.HashMap;

public abstract class Pokemon implements IPokemon {

    protected int id;
    protected int salud;
    protected String nombre;
    protected Ataque ataqueSeleccionado;
    protected ArrayList<Ataque> ataques;
    protected HashMap<String, Integer> energias;
    protected VisitorPokemon visitor;

    protected Pokemon(String nombre, int id, int salud, ArrayList<Ataque> ataques) {

        this.nombre = nombre;
        this.id = id;
        this.salud = salud;
        this.ataques = ataques;
        this.energias = new HashMap<>();
    }

    @Override
    public void jugar(Entrenador entrenador) {

        this.play(entrenador);
    }

    @Override
    public int getHp() {

        return this.salud;
    }
    @Override
    public void addEnergia(Energia energia) {

        energia.anadir(this);
    }
    @Override
    public boolean hpCero() {

        if (this.salud == 0) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    public void danoDebilidad(Ataque ataque) {

        this.salud -= ataque.getDano() * 2;
        if (this.salud < 0) {
            this.salud = 0;
        }
    }

    @Override
    public void danoResistencia(Ataque ataque) {

        int reduccion = ataque.getDano() - 30;
        if (reduccion > 0) {
            this.salud -= reduccion;
        }
    }

    @Override
    public void danoEstandar(Ataque ataque) {

        this.salud -= ataque.getDano();
        if (this.salud < 0) {
            this.salud = 0;
        }
    }

    @Override
    public void seleccionarAtaque(int index) {

        this.ataqueSeleccionado = this.ataques.get(index);
    }

    @Override
    public Ataque getAtaqueSeleccionado() {

        return this.ataqueSeleccionado;
    }

    @Override
    public HashMap<String, Integer> getEnergias() {

        return this.energias;
    }

    @Override
    public int getID() {

        return this.id;
    }

    @Override
    public void heredarEnergia(Pokemon pokemon) {

        this.energias = pokemon.getEnergias();
    }

    public abstract void danoFuego(Ataque ataque);

    public abstract void danoAgua(Ataque ataque);

    public abstract void danoPlanta(Ataque ataque);

    public abstract void danoRayo(Ataque ataque);

    public abstract void danoLucha(Ataque ataque);

    public abstract void danoPsiquico(Ataque ataque);

    public abstract void play(Entrenador entrenador);
}