package test;

import cc3201.tarea1.corregida.*;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class EnergiaAguaTest {

    private Entrenador entrenador;
    private Pokemon pokeAgua;
    private Energia agua;
    private Ataque atkAgua;
    private ArrayList<Ataque> ataques;

    @Before
    public void setUp() throws Exception {

        atkAgua = new AtaqueAgua("agua", 20, 4, "prueba");

        ataques = new ArrayList<>();
        ataques.add(atkAgua);

        pokeAgua = new PokemonAgua("water", 1, 50, ataques);

        entrenador = new Entrenador();

        agua = new EnergiaAgua("energia");
    }

    @Test
    public void anadir() {

        assertEquals(null, pokeAgua.getEnergias().get("Agua"));

        agua.anadir(pokeAgua);
        int valor = pokeAgua.getEnergias().get("Agua");
        assertEquals(1, valor);

        agua.anadir(pokeAgua);
        valor = pokeAgua.getEnergias().get("Agua");
        assertEquals(2, valor);
    }

    @Test
    public void jugar() {

        entrenador.addMano(pokeAgua);
        entrenador.juega(pokeAgua);
        entrenador.pokemonActivo();

        assertEquals(null, entrenador.getPokemonActivo().getEnergias().get("Agua"));

        agua.jugar(entrenador);

        int valor = entrenador.getPokemonActivo().getEnergias().get("Agua");
        assertEquals(1, valor);

        agua.jugar(entrenador);
        valor = entrenador.getPokemonActivo().getEnergias().get("Agua");

        assertEquals(2, valor);
    }
}