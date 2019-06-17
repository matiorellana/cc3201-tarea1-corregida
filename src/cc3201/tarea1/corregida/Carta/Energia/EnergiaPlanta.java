package cc3201.tarea1.corregida.Carta.Energia;

import cc3201.tarea1.corregida.Carta.Pokemon.Pokemon;

public class EnergiaPlanta extends Energia implements IEnergia {

    public EnergiaPlanta(String nombre) {

        super(nombre);
    }

    @Override
    public void anadir(Pokemon pokemon) {

        if(!pokemon.getEnergias().containsKey("Planta")){
            pokemon.getEnergias().put("Planta", 1);
        }
        else{
            pokemon.getEnergias().put("Planta", pokemon.getEnergias().get("Planta") + 1);
        }
    }
}
