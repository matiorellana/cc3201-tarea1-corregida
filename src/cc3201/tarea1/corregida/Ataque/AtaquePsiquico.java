package cc3201.tarea1.corregida.Ataque;

import cc3201.tarea1.corregida.Entrenador;
import cc3201.tarea1.corregida.Carta.Pokemon.Pokemon;

public class AtaquePsiquico extends Ataque implements IAtaque {

    public AtaquePsiquico(String nombre, int dano, int coste, String descripcion) {

        super(nombre, dano, coste, descripcion);
    }

    @Override
    public boolean comprobar(Pokemon pokemon) {

        if (pokemon.getEnergias().get("Psiquico") >= this.getCoste()){
            return true;
        }
        else{
            return false;
        }
    }

    @Override
    public void attack(Entrenador entrenador) {

        entrenador.getPokemonActivo().danoPsiquico(this);
    }
}
