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

    protected Pokemon(String nombre, int id, int salud, ArrayList<Ataque> ataques){

        this.nombre = nombre;
        this.id = id;
        this.salud = salud;
        this.ataques = ataques;
        this.energias = new HashMap<>();
    }

    public void jugar(Entrenador entrenador){

        entrenador.addBanca(this);
    }

    public int getHp(){

        return this.salud;
    }

    public void addEnergia(Energia energia){

        energia.anadir(this);
    }

    public boolean hpCero(){

        if(this.salud == 0){
            return true;
        }
        else{
            return false;
        }
    }

    public void danoDebilidad(Ataque ataque){

        this.salud -= ataque.getDano() * 2;
        if(this.salud < 0) {
            this.salud = 0;
        }
    }

    public void danoResistencia(Ataque ataque){

        int reduccion = ataque.getDano() - 30;
        if (reduccion > 0){
            this.salud -= reduccion;
        }
    }

    public void danoEstandar(Ataque ataque){

        this.salud -= ataque.getDano();
        if(this.salud < 0){
            this.salud = 0;
        }
    }
    public void seleccionarAtaque(int index){

        this.ataqueSeleccionado = this.ataques.get(index);
    }

    public Ataque getAtaqueSeleccionado(){

        return this.ataqueSeleccionado;
    }

    public HashMap<String, Integer> getEnergias(){

        return this.energias;
    }

    public abstract void danoFuego(Ataque ataque);

    public abstract void danoAgua(Ataque ataque);

    public abstract void danoPlanta(Ataque ataque);

    public abstract void danoRayo(Ataque ataque);

    public abstract void danoLucha(Ataque ataque);

    public abstract void danoPsiquico(Ataque ataque);


}
