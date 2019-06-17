package cc3201.tarea1.corregida.Carta.Energia;

import cc3201.tarea1.corregida.Carta.Pokemon.Pokemon;

public class EnergiaRayo extends Energia implements IEnergia {

    public EnergiaRayo(String nombre) {

        super(nombre);
    }

    @Override
    public void anadir(Pokemon pokemon) {

        if(!pokemon.getEnergias().containsKey("Rayo")){
            pokemon.getEnergias().put("Rayo", 1);
        }
        else{
            pokemon.getEnergias().put("Rayo", pokemon.getEnergias().get("Rayo") + 1);
        }
    }
}
