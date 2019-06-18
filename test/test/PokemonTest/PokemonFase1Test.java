package test.PokemonTest;

import cc3201.tarea1.corregida.Carta.Pokemon.Basico.*;
import cc3201.tarea1.corregida.Carta.Pokemon.Fase1.*;
import cc3201.tarea1.corregida.Carta.Pokemon.Pokemon;
import cc3201.tarea1.corregida.Carta.Pokemon.VisitorPokemon;
import cc3201.tarea1.corregida.Entrenador;
import cc3201.tarea1.corregida.Habilidad.Ataque.Ataque;
import cc3201.tarea1.corregida.Habilidad.Ataque.AtaqueAgua;
import cc3201.tarea1.corregida.Habilidad.IHabilidad;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.*;

public class PokemonFase1Test {

    private Pokemon pokeBasicoAgua;
    private Pokemon pokeBasicoFuego;
    private Pokemon pokeBasicoPlanta;
    private Pokemon pokeBasicoLucha;
    private Pokemon pokeBasicoPsiquico;
    private Pokemon pokeBasicoRayo;

    private Pokemon pokeFase1Agua;
    private Pokemon pokeFase1Fuego;
    private Pokemon pokeFase1Planta;
    private Pokemon pokeFase1Lucha;
    private Pokemon pokeFase1Psiquico;
    private Pokemon pokeFase1Rayo;

    private Entrenador entrenador;

    private Ataque ataque;

    private ArrayList<IHabilidad> ataques;

    @Before
    public void setUp(){

        ataque = new AtaqueAgua("gg", 10, 2, "GG");

        ataques = new ArrayList<>();
        ataques.add(ataque);

        pokeBasicoAgua = new PokemonBasicoAgua("agua", 1, 30, ataques);
        pokeBasicoFuego = new PokemonBasicoFuego("fuego", 3, 40, ataques);
        pokeBasicoPlanta = new PokemonBasicoPlanta("planta", 5, 20, ataques);
        pokeBasicoLucha = new PokemonBasicoLucha("lucha", 7, 30, ataques);
        pokeBasicoPsiquico = new PokemonBasicoPsiquico("psiquico", 9, 40, ataques);
        pokeBasicoRayo = new PokemonBasicoRayo("rayo", 11, 20, ataques);

        pokeFase1Agua = new PokemonFase1Agua("AGUA", 2,50, ataques);
        pokeFase1Fuego = new PokemonFase1Fuego("FUEGO", 4, 60, ataques);
        pokeFase1Planta = new PokemonFase1Planta("PLANTA", 6, 40, ataques);
        pokeFase1Lucha = new PokemonFase1Lucha("LUCHA", 8, 60, ataques);
        pokeFase1Psiquico = new PokemonFase1Psiquico("PSIQUICO", 10, 70, ataques);
        pokeFase1Rayo = new PokemonFase1Rayo("RAYO", 12, 50, ataques);

        entrenador = new Entrenador();
    }

    @Test
    public void play() {

        assertEquals(0, entrenador.getBanca().size());
        pokeBasicoRayo.play(entrenador);
        assertEquals(1, entrenador.getBanca().size());
        pokeFase1Psiquico.play(entrenador);
        assertEquals(1, entrenador.getBanca().size());
        assertFalse(entrenador.getBanca().contains(pokeFase1Psiquico));
        pokeFase1Rayo.play(entrenador);
        assertTrue(entrenador.getBanca().contains(pokeFase1Rayo));
        assertFalse(entrenador.getBanca().contains(pokeBasicoRayo));
        assertEquals(1, entrenador.getBanca().size());

        pokeBasicoPsiquico.play(entrenador);
        pokeBasicoAgua.play(entrenador);
        pokeBasicoFuego.play(entrenador);
        pokeBasicoPlanta.play(entrenador);
        pokeBasicoLucha.play(entrenador);

        assertEquals(6,entrenador.getBanca().size());
        assertTrue(entrenador.getBanca().contains(pokeBasicoAgua));
        assertFalse(entrenador.getBanca().contains(pokeFase1Fuego));

        pokeFase1Psiquico.play(entrenador);
        pokeFase1Agua.play(entrenador);
        pokeFase1Fuego.play(entrenador);
        pokeFase1Planta.play(entrenador);
        pokeFase1Lucha.play(entrenador);

        assertEquals(6,entrenador.getBanca().size());
        assertFalse(entrenador.getBanca().contains(pokeBasicoAgua));
        assertTrue(entrenador.getBanca().contains(pokeFase1Fuego));
    }
}