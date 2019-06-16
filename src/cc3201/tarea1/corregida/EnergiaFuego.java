package cc3201.tarea1.corregida;

public class EnergiaFuego extends Energia implements IEnergia{

    public EnergiaFuego(String nombre){

        super(nombre);
    }

    @Override
    public void anadir(Pokemon pokemon) {

        if(!pokemon.getEnergias().containsKey("Fuego")){
            pokemon.getEnergias().put("Fuego", 1);
        }
        else{
            pokemon.getEnergias().put("Fuego", pokemon.getEnergias().get("Fuego") + 1);
        }
    }
}
