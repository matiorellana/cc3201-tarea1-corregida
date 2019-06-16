package test;

import cc3201.tarea1.corregida.*;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.*;

public class AtaqueLuchaTest {

    private Pokemon pokeFuego;
    private Pokemon pokeLucha;
    private Pokemon pokePsiquico;

    private Energia lucha;

    private Ataque atkLucha;
    private Ataque atkPsiquico;

    ArrayList<Ataque> ataques2;

    private Entrenador entrenador1;
    private Entrenador entrenador2;
    private Entrenador entrenador3;

    @Before
    public void setUp() throws Exception {

        atkLucha = new AtaqueLucha("d4", 30, 7, "prueba4");
        atkPsiquico = new AtaquePsiquico("e5", 25, 8, "prueba5");

        ataques2 = new ArrayList<Ataque>();
        ataques2.add(atkLucha);
        ataques2.add(atkPsiquico);

        pokeFuego = new PokemonFuego("fuego",2, 150, ataques2);
        pokeLucha = new PokemonLucha("ken", 4, 100, ataques2);
        pokePsiquico = new PokemonPsiquico("abra", 5, 100, ataques2);

        lucha = new EnergiaLucha("l");

        entrenador1 = new Entrenador();
        entrenador2 = new Entrenador();
        entrenador3 = new Entrenador();
    }

    @Test
    public void comprobar() {

        pokeFuego.addEnergia(lucha);
        assertFalse(atkLucha.comprobar(pokeFuego));

        for(int i=0; i<6; i++){

            pokeFuego.addEnergia(lucha);
        }

        assertTrue(atkLucha.comprobar(pokeFuego));
    }

    @Test
    public void attack(){

        entrenador1.addMano(pokeLucha);
        entrenador1.juega(pokeLucha);
        entrenador1.pokemonActivo();
        assertEquals(100, entrenador1.getPokemonActivo().getHp());

        atkLucha.attack(entrenador1);
        assertEquals(70, entrenador1.getPokemonActivo().getHp());

        entrenador2.addMano(pokeFuego);
        entrenador2.juega(pokeFuego);
        entrenador2.pokemonActivo();
        assertEquals(150, entrenador2.getPokemonActivo().getHp());

        atkLucha.attack(entrenador2);
        assertEquals(120, entrenador2.getPokemonActivo().getHp());

        entrenador3.addMano(pokePsiquico);
        entrenador3.juega(pokePsiquico);
        entrenador3.pokemonActivo();
        assertEquals(100, entrenador3.getPokemonActivo().getHp());

        atkLucha.attack(entrenador3);
        assertEquals(100, entrenador3.getPokemonActivo().getHp());
    }
}