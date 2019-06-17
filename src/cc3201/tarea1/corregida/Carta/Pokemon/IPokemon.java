package cc3201.tarea1.corregida.Carta.Pokemon;

import cc3201.tarea1.corregida.Ataque.Ataque;
import cc3201.tarea1.corregida.Carta.Carta;
import cc3201.tarea1.corregida.Carta.Energia.Energia;

import java.util.HashMap;

public interface IPokemon extends Carta {

    int getHp();

    void addEnergia(Energia e);

    boolean hpCero();

    void danoDebilidad(Ataque ataque);

    void danoResistencia(Ataque ataque);

    void danoEstandar(Ataque ataque);

    void seleccionarAtaque(int index);

    Ataque getAtaqueSeleccionado();

    HashMap<String, Integer> getEnergias();

    int getID();

    void heredarEnergia(Pokemon pokemon);
}
