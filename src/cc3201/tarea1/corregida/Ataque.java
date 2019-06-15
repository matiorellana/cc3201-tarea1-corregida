package cc3201.tarea1.corregida;

public abstract class Ataque implements IAtaque{

    protected String nombre;
    protected int dano;
    protected int coste;
    protected String descripcion;

    protected Ataque(String nombre, int dano, int coste, String descripcion){

        this.nombre = nombre;
        this.dano = dano;
        this.coste = coste;
        this.descripcion = descripcion;
    }

    public int getDano(){

        return this.dano;
    }

    protected int getCoste(){

        return this.coste;
    }

    public abstract boolean comprobar(Pokemon pokemon);
}
