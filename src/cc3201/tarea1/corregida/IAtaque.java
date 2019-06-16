package cc3201.tarea1.corregida;

public interface IAtaque {

    int getDano();

    boolean comprobar(Pokemon pokemon);

    void attack(Entrenador entrenador);
}
