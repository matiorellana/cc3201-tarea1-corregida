package cc3201.tarea1.corregida;

public class AtaqueFuego extends Ataque {

    public AtaqueFuego(String nombre, int dano, int coste, String descripcion){

        super(nombre, dano, coste, descripcion);
    }

    @Override
    public boolean comprobar(Pokemon pokemon) {

        if (pokemon.energias.get("Fuego") >= this.getCoste()){
            return true;
        }
        else{
            return false;
        }
    }
}
