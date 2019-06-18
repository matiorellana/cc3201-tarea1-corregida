package test.PokemonTest;

import cc3201.tarea1.corregida.Carta.Pokemon.Basico.*;
import cc3201.tarea1.corregida.Carta.Pokemon.Fase1.*;
import cc3201.tarea1.corregida.Carta.Pokemon.Fase2.*;
import cc3201.tarea1.corregida.Carta.Pokemon.Pokemon;
import cc3201.tarea1.corregida.Entrenador;
import cc3201.tarea1.corregida.Habilidad.Ataque.Ataque;
import cc3201.tarea1.corregida.Habilidad.Ataque.AtaqueAgua;
import cc3201.tarea1.corregida.Habilidad.IHabilidad;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.*;

public class PokemonFase2Test {

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

    private Pokemon pokeFase2Agua;
    private Pokemon pokeFase2Fuego;
    private Pokemon pokeFase2Planta;
    private Pokemon pokeFase2Lucha;
    private Pokemon pokeFase2Psiquico;
    private Pokemon pokeFase2Rayo;

    private Entrenador entrenador;

    private Ataque ataque;

    private ArrayList<IHabilidad> ataques;

    @Before
    public void setUp(){

        ataque = new AtaqueAgua("gg", 10, 2, "GG");

        ataques = new ArrayList<>();
        ataques.add(ataque);

        pokeBasicoAgua = new PokemonBasicoAgua("agua", 1, 30, ataques);
        pokeBasicoFuego = new PokemonBasicoFuego("fuego", 4, 40, ataques);
        pokeBasicoPlanta = new PokemonBasicoPlanta("planta", 7, 20, ataques);
        pokeBasicoLucha = new PokemonBasicoLucha("lucha", 10, 30, ataques);
        pokeBasicoPsiquico = new PokemonBasicoPsiquico("psiquico", 13, 40, ataques);
        pokeBasicoRayo = new PokemonBasicoRayo("rayo", 16, 20, ataques);

        pokeFase1Agua = new PokemonFase1Agua("AGUA", 2,50, ataques);
        pokeFase1Fuego = new PokemonFase1Fuego("FUEGO", 5, 60, ataques);
        pokeFase1Planta = new PokemonFase1Planta("PLANTA", 8, 40, ataques);
        pokeFase1Lucha = new PokemonFase1Lucha("LUCHA", 11, 60, ataques);
        pokeFase1Psiquico = new PokemonFase1Psiquico("PSIQUICO", 14, 70, ataques);
        pokeFase1Rayo = new PokemonFase1Rayo("RAYO", 17, 50, ataques);

        pokeFase2Agua = new PokemonFase2Agua("AGUA", 3,70, ataques);
        pokeFase2Fuego = new PokemonFase2Fuego("FUEGO", 6, 80, ataques);
        pokeFase2Planta = new PokemonFase2Planta("PLANTA", 9, 60, ataques);
        pokeFase2Lucha = new PokemonFase2Lucha("LUCHA", 12, 90, ataques);
        pokeFase2Psiquico = new PokemonFase2Psiquico("PSIQUICO", 15, 100, ataques);
        pokeFase2Rayo = new PokemonFase2Rayo("RAYO", 18, 80, ataques);

        entrenador = new Entrenador();
    }

    @Test
    public void play() {

        assertEquals(0, entrenador.getBanca().size());

        pokeBasicoRayo.play(entrenador);
        pokeBasicoPsiquico.play(entrenador);
        pokeBasicoAgua.play(entrenador);
        pokeBasicoFuego.play(entrenador);
        pokeBasicoPlanta.play(entrenador);
        pokeBasicoLucha.play(entrenador);

        assertEquals(6,entrenador.getBanca().size());
        assertTrue(entrenador.getBanca().contains(pokeBasicoAgua));
        assertFalse(entrenador.getBanca().contains(pokeFase1Fuego));
        assertFalse(entrenador.getBanca().contains(pokeFase2Fuego));

        pokeFase2Fuego.play(entrenador);

        assertFalse(entrenador.getBanca().contains(pokeFase2Fuego));

        pokeFase1Rayo.play(entrenador);
        pokeFase1Psiquico.play(entrenador);
        pokeFase1Agua.play(entrenador);
        pokeFase1Fuego.play(entrenador);
        pokeFase1Planta.play(entrenador);
        pokeFase1Lucha.play(entrenador);

        assertEquals(6,entrenador.getBanca().size());
        assertFalse(entrenador.getBanca().contains(pokeBasicoAgua));
        assertTrue(entrenador.getBanca().contains(pokeFase1Fuego));

        assertFalse(entrenador.getBanca().contains(pokeFase2Fuego));

        pokeFase2Fuego.play(entrenador);

        assertTrue(entrenador.getBanca().contains(pokeFase2Fuego));

        pokeFase2Agua.play(entrenador);
        pokeFase2Planta.play(entrenador);
        pokeFase2Lucha.play(entrenador);
        pokeFase2Psiquico.play(entrenador);
        pokeFase2Rayo.play(entrenador);

        assertTrue(entrenador.getBanca().contains(pokeFase2Planta));
        assertFalse(entrenador.getBanca().contains(pokeBasicoFuego));
        assertFalse(entrenador.getBanca().contains(pokeFase1Fuego));
    }
}