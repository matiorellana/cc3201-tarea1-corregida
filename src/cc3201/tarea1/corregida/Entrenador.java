package cc3201.tarea1.corregida;

import cc3201.tarea1.corregida.Carta.Ataque.Ataque;
import cc3201.tarea1.corregida.Carta.Carta;
import cc3201.tarea1.corregida.Carta.Pokemon.Pokemon;

import java.util.ArrayList;

public class Entrenador {

    private ArrayList<Pokemon> banca;
    private ArrayList<Carta> mano;
    private Pokemon activo;
    private Ataque ataqueSeleccionado;

    public Entrenador(){

        this.banca = new ArrayList<>();
        this.mano = new ArrayList<>();
    }

    public void juega(Carta carta){

        if(this.mano.contains(carta)){
            carta.jugar(this);
        }
    }

    public void addBanca(Pokemon pokemon){

        if (this.banca.size() < 6){
            this.banca.add(pokemon);
            this.mano.remove(pokemon);
        }
    }

    public void addMano(Carta carta){

        this.mano.add(carta);
    }

    public void pokemonActivo(){

        this.activo = this.banca.get(0);
    }

    public Pokemon getPokemonActivo(){

        return this.activo;
    }

    public ArrayList<Pokemon> getBanca(){

        return this.banca;
    }

    public ArrayList<Carta> getMano(){

        return this.mano;
    }

    public void atacar(Entrenador entrenador){

        if (this.getPokemonActivo().getAtaqueSeleccionado().comprobar(this.getPokemonActivo())){

            this.getPokemonActivo().getAtaqueSeleccionado().attack(entrenador);
            entrenador.removerPokemon();
        }
    }

    public void selectAtaque(int index) {

        this.getPokemonActivo().seleccionarAtaque(index);
    }

    public void removerPokemon() {

        if(this.getPokemonActivo().hpCero()){

            this.getBanca().remove(0);
            this.activo = null;
        }
    }


}
