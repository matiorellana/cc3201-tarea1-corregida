package test.EnergiaTest;

import cc3201.tarea1.corregida.*;
import cc3201.tarea1.corregida.Carta.Pokemon.Basico.PokemonBasicoAgua;
import cc3201.tarea1.corregida.Habilidad.Ataque.Ataque;
import cc3201.tarea1.corregida.Habilidad.Ataque.AtaqueAgua;
import cc3201.tarea1.corregida.Carta.Energia.Energia;
import cc3201.tarea1.corregida.Carta.Energia.EnergiaLucha;
import cc3201.tarea1.corregida.Carta.Pokemon.Pokemon;
import cc3201.tarea1.corregida.Carta.Pokemon.PokemonAgua;
import cc3201.tarea1.corregida.Habilidad.IHabilidad;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.*;

public class EnergiaLuchaTest {

    private Entrenador entrenador;
    private Pokemon pokeAgua;
    private Energia lucha;
    private Ataque atkAgua;
    private ArrayList<IHabilidad> ataques;

    @Before
    public void setUp() throws Exception {

        atkAgua = new AtaqueAgua("agua", 20, 4, "prueba");

        ataques = new ArrayList<>();
        ataques.add(atkAgua);

        pokeAgua = new PokemonBasicoAgua("water", 1, 50, ataques);

        entrenador = new Entrenador();

        lucha = new EnergiaLucha("ryu");
    }

    @Test
    public void anadir() {

        assertEquals(null, pokeAgua.getEnergias().get("Lucha"));

        lucha.anadir(pokeAgua);
        int valor = pokeAgua.getEnergias().get("Lucha");
        assertEquals(1, valor);

        lucha.anadir(pokeAgua);
        valor = pokeAgua.getEnergias().get("Lucha");
        assertEquals(2, valor);
    }
}