package cc3201.tarea1.corregida;

public class AtaqueLucha extends Ataque implements IAtaque {

    public AtaqueLucha(String nombre, int dano, int coste, String descripcion) {

        super(nombre, dano, coste, descripcion);
    }

    @Override
    public boolean comprobar(Pokemon pokemon) {

        if (pokemon.getEnergias().get("Lucha") >= this.getCoste()){
            return true;
        }
        else{
            return false;
        }
    }
}
