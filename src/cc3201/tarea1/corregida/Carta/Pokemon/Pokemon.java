package cc3201.tarea1.corregida.Carta.Pokemon;

import cc3201.tarea1.corregida.Habilidad.Ataque.Ataque;
import cc3201.tarea1.corregida.Carta.Energia.Energia;
import cc3201.tarea1.corregida.Entrenador;
import cc3201.tarea1.corregida.Habilidad.IHabilidad;

import java.util.ArrayList;
import java.util.HashMap;

public abstract class Pokemon implements IPokemon {

    protected int id;
    protected int salud;
    protected String nombre;
    protected IHabilidad ataqueSeleccionado;
    protected ArrayList<IHabilidad> ataques;
    protected HashMap<String, Integer> energias;

    protected Pokemon(String nombre, int id, int salud, ArrayList<IHabilidad> ataques) {

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
    public IHabilidad getAtaqueSeleccionado() {

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

    @Override
    public String getNombre(){

        return this.nombre;
    }

    @Override
    public void setSalud(int hp){
        if(hp<0){
            this.salud = 0;
        }
        else{
            this.salud = hp;
        }
    }

    public abstract void danoFuego(Ataque ataque);

    public abstract void danoAgua(Ataque ataque);

    public abstract void danoPlanta(Ataque ataque);

    public abstract void danoRayo(Ataque ataque);

    public abstract void danoLucha(Ataque ataque);

    public abstract void danoPsiquico(Ataque ataque);

    public abstract void play(Entrenador entrenador);
}