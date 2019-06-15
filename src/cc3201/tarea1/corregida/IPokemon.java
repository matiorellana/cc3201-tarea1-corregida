package cc3201.tarea1.corregida;

public interface IPokemon extends Carta {

    void addEnergia(Energia e);

    boolean hpCero();

    void danoDebilidad(Ataque ataque);

    void danoResistencia(Ataque ataque);

    void danoEstandar(Ataque ataque);

    void attack(Entrenador entrenador);

    void seleccionarAtaque(int index);
}
