package cc3201.tarea1.corregida;

public class EnergiaLucha extends Energia implements IEnergia {

    public EnergiaLucha(String nombre) {

        super(nombre);
    }

    @Override
    public void anadir(Pokemon pokemon) {

        if(!pokemon.getEnergias().containsKey("Lucha")){
            pokemon.getEnergias().put("Lucha", 1);
        }
        else{
            pokemon.getEnergias().put("Lucha", pokemon.getEnergias().get("Lucha") + 1);
        }
    }
}
