package test;

import cc3201.tarea1.corregida.*;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.*;

public class AtaqueFuegoTest {

    private Pokemon pokePlanta;
    private Pokemon pokeAgua;
    private Pokemon pokeFuego;

    private Energia fuego;

    private Ataque atkPlanta;
    private Ataque atkFuego;
    private Ataque atkAgua;
    private Ataque atkRayo;

    private Entrenador entrenador1;
    private Entrenador entrenador2;
    private Entrenador entrenador3;

    ArrayList<Ataque> ataques1;

    @Before
    public void setUp() throws Exception {

        atkPlanta = new AtaquePlanta("a1", 20, 3, "prueba1");
        atkFuego = new AtaqueFuego("b2", 35, 2, "prueba2");
        atkAgua = new AtaqueAgua("c3", 15, 5, "prueba3");
        atkRayo = new AtaqueRayo("f6", 7, 10, "prueba6");

        ataques1 = new ArrayList<>();
        ataques1.add(atkAgua);
        ataques1.add(atkFuego);
        ataques1.add(atkPlanta);
        ataques1.add(atkRayo);

        pokePlanta = new PokemonPlanta("planta",1, 100, ataques1);
        pokeFuego = new PokemonFuego("fuego", 2,100,ataques1);
        pokeAgua = new PokemonAgua("agua", 3, 100, ataques1);

        fuego = new EnergiaFuego("f");

        entrenador1 = new Entrenador();
        entrenador2 = new Entrenador();
        entrenador3 = new Entrenador();
    }

    @Test
    public void comprobar() {

        pokePlanta.addEnergia(fuego);
        assertFalse(atkFuego.comprobar(pokePlanta));

        pokePlanta.addEnergia(fuego);
        assertTrue(atkFuego.comprobar(pokePlanta));
    }

    @Test
    public void attack(){

        entrenador1.addMano(pokePlanta);
        entrenador1.juega(pokePlanta);
        entrenador1.pokemonActivo();
        assertEquals(100, entrenador1.getPokemonActivo().getHp());

        atkFuego.attack(entrenador1);
        assertEquals(30, entrenador1.getPokemonActivo().getHp());

        entrenador2.addMano(pokeFuego);
        entrenador2.juega(pokeFuego);
        entrenador2.pokemonActivo();
        assertEquals(100, entrenador2.getPokemonActivo().getHp());

        atkFuego.attack(entrenador2);
        assertEquals(65, entrenador2.getPokemonActivo().getHp());

        entrenador3.addMano(pokeAgua);
        entrenador3.juega(pokeAgua);
        entrenador3.pokemonActivo();
        assertEquals(100, entrenador3.getPokemonActivo().getHp());

        atkFuego.attack(entrenador3);
        assertEquals(65, entrenador3.getPokemonActivo().getHp());
    }
}