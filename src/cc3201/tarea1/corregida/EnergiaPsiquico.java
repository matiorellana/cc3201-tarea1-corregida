package cc3201.tarea1.corregida;

public class EnergiaPsiquico extends Energia implements IEnergia {

    public EnergiaPsiquico(String nombre) {

        super(nombre);
    }

    @Override
    public void anadir(Pokemon pokemon) {

        if(!pokemon.getEnergias().containsKey("Psiquico")){
            pokemon.getEnergias().put("Psiquico", 1);
        }
        else{
            pokemon.getEnergias().put("Psiquico", pokemon.getEnergias().get("Psiquico") + 1);
        }
    }
}
