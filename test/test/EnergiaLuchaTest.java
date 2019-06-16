package test;

import cc3201.tarea1.corregida.*;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.*;

public class EnergiaLuchaTest {

    private Entrenador entrenador;
    private Pokemon pokeAgua;
    private Energia lucha;
    private Ataque atkAgua;
    private ArrayList<Ataque> ataques;

    @Before
    public void setUp() throws Exception {

        atkAgua = new AtaqueAgua("agua", 20, 4, "prueba");

        ataques = new ArrayList<>();
        ataques.add(atkAgua);

        pokeAgua = new PokemonAgua("water", 1, 50, ataques);

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