package cc3201.tarea1.corregida.Carta.Pokemon.Basico;

import cc3201.tarea1.corregida.Habilidad.Ataque.Ataque;
import cc3201.tarea1.corregida.Carta.Pokemon.IPokemon;
import cc3201.tarea1.corregida.Carta.Pokemon.PokemonPlanta;
import cc3201.tarea1.corregida.Carta.Pokemon.VisitorPokemon;
import cc3201.tarea1.corregida.Entrenador;
import cc3201.tarea1.corregida.Habilidad.IHabilidad;

import java.util.ArrayList;

public class PokemonBasicoPlanta extends PokemonPlanta implements IPokemon, PokemonBasico {

    private VisitorPokemon visitor = new VisitorPokemon();
    public PokemonBasicoPlanta(String nombre, int id, int salud, ArrayList<IHabilidad> ataques){

        super(nombre, id, salud, ataques);
    }

    @Override
    public void play(Entrenador entrenador) {

        this.accept(this.visitor, entrenador);
    }

    @Override
    public void accept(VisitorPokemon visitor, Entrenador entrenador) {
        visitor.visitorBasico(this, entrenador);
    }
}
