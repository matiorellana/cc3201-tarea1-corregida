package cc3201.tarea1.corregida;

public abstract class Energia implements IEnergia{

    protected String nombre;

    protected Energia(String nombre){

        this.nombre = nombre;
    }

    @Override
    public void jugar(Entrenador entrenador) {

        entrenador.getPokemonActivo().addEnergia(this);
    }

    public abstract void anadir(Pokemon pokemon);
}
