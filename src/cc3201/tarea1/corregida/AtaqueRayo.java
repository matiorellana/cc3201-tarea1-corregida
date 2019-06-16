package cc3201.tarea1.corregida;

public class AtaqueRayo extends Ataque implements IAtaque {

    public AtaqueRayo(String nombre, int dano, int coste, String descripcion) {

        super(nombre, dano, coste, descripcion);
    }

    @Override
    public boolean comprobar(Pokemon pokemon) {

        if (pokemon.getEnergias().get("Rayo") >= this.getCoste()){
            return true;
        }
        else{
            return false;
        }
    }
}
