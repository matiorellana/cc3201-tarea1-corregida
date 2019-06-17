package cc3201.tarea1.corregida.Carta.Pokemon;

import cc3201.tarea1.corregida.Ataque.Ataque;
import cc3201.tarea1.corregida.Carta.Carta;
import cc3201.tarea1.corregida.Carta.Energia.Energia;

public interface IPokemon extends Carta {

    void addEnergia(Energia e);

    boolean hpCero();

    void danoDebilidad(Ataque ataque);

    void danoResistencia(Ataque ataque);

    void danoEstandar(Ataque ataque);

    void seleccionarAtaque(int index);
}
