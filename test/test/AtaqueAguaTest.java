package test;

import cc3201.tarea1.corregida.*;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.*;

public class AtaqueAguaTest {

    private Pokemon pokePlanta;
    private Pokemon pokeAgua;
    private Pokemon pokeFuego;

    private Energia agua;

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
        atkFuego = new AtaqueFuego("b2", 10, 2, "prueba2");
        atkAgua = new AtaqueAgua("c3", 40, 5, "prueba3");
        atkRayo = new AtaqueRayo("f6", 7, 10, "prueba6");

        ataques1 = new ArrayList<>();
        ataques1.add(atkAgua);
        ataques1.add(atkFuego);
        ataques1.add(atkPlanta);
        ataques1.add(atkRayo);

        pokePlanta = new PokemonPlanta("planta",1, 100, ataques1);
        pokeFuego = new PokemonFuego("fuego", 2,100,ataques1);
        pokeAgua = new PokemonAgua("agua", 3, 100, ataques1);

        agua = new EnergiaAgua("a");

        entrenador1 = new Entrenador();
        entrenador2 = new Entrenador();
        entrenador3 = new Entrenador();
    }

    @Test
    public void comprobar() {

        pokePlanta.addEnergia(agua);
        assertFalse(atkAgua.comprobar(pokePlanta));

        for(int i=0; i<4; i++){

            pokePlanta.addEnergia(agua);
        }

        assertTrue(atkAgua.comprobar(pokePlanta));
    }

    @Test
    public void getDano() {

        assertEquals(40, atkAgua.getDano());
        assertEquals(10, atkFuego.getDano());
        assertEquals(7, atkRayo.getDano());
    }

    @Test
    public void attack(){

        entrenador1.addMano(pokePlanta);
        entrenador1.juega(pokePlanta);
        entrenador1.pokemonActivo();
        assertEquals(100, entrenador1.getPokemonActivo().getHp());

        atkAgua.attack(entrenador1);
        assertEquals(90, entrenador1.getPokemonActivo().getHp());

        entrenador2.addMano(pokeFuego);
        entrenador2.juega(pokeFuego);
        entrenador2.pokemonActivo();
        assertEquals(100, entrenador2.getPokemonActivo().getHp());

        atkAgua.attack(entrenador2);
        assertEquals(20, entrenador2.getPokemonActivo().getHp());

        entrenador3.addMano(pokeAgua);
        entrenador3.juega(pokeAgua);
        entrenador3.pokemonActivo();
        assertEquals(100, entrenador3.getPokemonActivo().getHp());

        atkAgua.attack(entrenador3);
        assertEquals(60, entrenador3.getPokemonActivo().getHp());
    }
}