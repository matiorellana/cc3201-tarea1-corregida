package test.EnergiaTest;

import cc3201.tarea1.corregida.*;
import cc3201.tarea1.corregida.Carta.Pokemon.Basico.PokemonBasicoAgua;
import cc3201.tarea1.corregida.Habilidad.Ataque.Ataque;
import cc3201.tarea1.corregida.Habilidad.Ataque.AtaqueAgua;
import cc3201.tarea1.corregida.Carta.Energia.Energia;
import cc3201.tarea1.corregida.Carta.Energia.EnergiaFuego;
import cc3201.tarea1.corregida.Carta.Pokemon.Pokemon;
import cc3201.tarea1.corregida.Carta.Pokemon.PokemonAgua;
import cc3201.tarea1.corregida.Habilidad.IHabilidad;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.*;

public class EnergiaFuegoTest {

    private Entrenador entrenador;
    private Pokemon pokeAgua;
    private Energia fuego;
    private Ataque atkAgua;
    private ArrayList<IHabilidad> ataques;

    @Before
    public void setUp() throws Exception {

        atkAgua = new AtaqueAgua("agua", 20, 4, "prueba");

        ataques = new ArrayList<>();
        ataques.add(atkAgua);

        pokeAgua = new PokemonBasicoAgua("water", 1, 50, ataques);

        entrenador = new Entrenador();

        fuego = new EnergiaFuego("e");
    }

    @Test
    public void anadir() {

        assertEquals(null, pokeAgua.getEnergias().get("Fuego"));

        fuego.anadir(pokeAgua);
        int valor = pokeAgua.getEnergias().get("Fuego");
        assertEquals(1, valor);

        fuego.anadir(pokeAgua);
        valor = pokeAgua.getEnergias().get("Fuego");
        assertEquals(2, valor);
    }
}