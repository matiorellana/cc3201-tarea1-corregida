package cc3201.tarea1.corregida.Carta.Energia;

import cc3201.tarea1.corregida.Carta.Pokemon.Pokemon;

public class EnergiaAgua extends Energia implements IEnergia {

    public EnergiaAgua(String nombre){

        super(nombre);
    }

    @Override
    public void anadir(Pokemon pokemon) {

        if(!pokemon.getEnergias().containsKey("Agua")){
            pokemon.getEnergias().put("Agua", 1);
        }
        else{
            pokemon.getEnergias().put("Agua", pokemon.getEnergias().get("Agua") + 1);
        }
    }
}
