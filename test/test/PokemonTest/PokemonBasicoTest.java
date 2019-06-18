package test.PokemonTest;

import cc3201.tarea1.corregida.*;
import cc3201.tarea1.corregida.Carta.Pokemon.Basico.PokemonBasicoAgua;
import cc3201.tarea1.corregida.Carta.Pokemon.Basico.PokemonBasicoFuego;
import cc3201.tarea1.corregida.Carta.Pokemon.Basico.PokemonBasicoRayo;
import cc3201.tarea1.corregida.Habilidad.Ataque.Ataque;
import cc3201.tarea1.corregida.Habilidad.Ataque.AtaqueAgua;
import cc3201.tarea1.corregida.Habilidad.Ataque.AtaqueFuego;
import cc3201.tarea1.corregida.Carta.Energia.Energia;
import cc3201.tarea1.corregida.Carta.Energia.EnergiaAgua;
import cc3201.tarea1.corregida.Carta.Energia.EnergiaFuego;
import cc3201.tarea1.corregida.Carta.Pokemon.Pokemon;
import cc3201.tarea1.corregida.Carta.Pokemon.PokemonAgua;
import cc3201.tarea1.corregida.Carta.Pokemon.PokemonFuego;
import cc3201.tarea1.corregida.Carta.Pokemon.PokemonRayo;
import cc3201.tarea1.corregida.Habilidad.IHabilidad;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;

import static org.junit.Assert.*;

public class PokemonBasicoTest {

    private Entrenador entrenador;

    private Pokemon pokeAgua;
    private Pokemon pokeFuego;
    private Pokemon pokeRayo;

    private Ataque atkAgua;
    private Ataque atkFuego;

    private ArrayList<IHabilidad> ataques1;
    private ArrayList<IHabilidad> ataques2;

    private Energia agua;
    private Energia fuego;

    @Before
    public void setUp(){

        entrenador = new Entrenador();

        atkAgua = new AtaqueAgua("a", 40, 4, "gg");
        atkFuego = new AtaqueFuego("f", 20, 3,"f");

        ataques1 = new ArrayList<>();
        ataques1.add(atkAgua);
        ataques1.add(atkFuego);

        ataques2 = new ArrayList<>();
        ataques2.add(atkFuego);

        pokeAgua = new PokemonBasicoAgua("agua", 10, 50, ataques1);
        pokeFuego = new PokemonBasicoFuego("fuego", 11, 70, ataques2);
        pokeRayo = new PokemonBasicoRayo("rayo", 12, 0, ataques2);

        agua = new EnergiaAgua("ea");
        fuego = new EnergiaFuego("ef");
    }


    @Test
    public void jugar() {

        pokeAgua.jugar(entrenador);
        assertEquals(pokeAgua, entrenador.getBanca().get(0));

        pokeFuego.jugar(entrenador);
        assertEquals(pokeFuego, entrenador.getBanca().get(1));
    }

    @Test
    public void getHp() {

        assertEquals(50, pokeAgua.getHp());
        assertEquals(70, pokeFuego.getHp());
    }

    @Test
    public void addEnergia() {

        pokeAgua.addEnergia(agua);
        int valor = pokeAgua.getEnergias().get("Agua");

        assertEquals(1, valor);

        pokeAgua.addEnergia(agua);
        valor = pokeAgua.getEnergias().get("Agua");

        assertEquals(2, valor);

        pokeAgua.addEnergia(fuego);
        valor = pokeAgua.getEnergias().get("Fuego");

        assertEquals(1,valor);
    }

    @Test
    public void hpCero() {

        assertFalse(pokeAgua.hpCero());
        assertTrue(pokeRayo.hpCero());
    }

    @Test
    public void danoDebilidad() {

        assertEquals(50, pokeAgua.getHp());
        pokeAgua.danoDebilidad(atkFuego);
        assertEquals(10, pokeAgua.getHp());
    }

    @Test
    public void danoResistencia() {

        assertEquals(50, pokeAgua.getHp());
        pokeAgua.danoResistencia(atkAgua);
        assertEquals(40, pokeAgua.getHp());
    }

    @Test
    public void danoEstandar() {

        assertEquals(50, pokeAgua.getHp());
        pokeAgua.danoEstandar(atkFuego);
        assertEquals(30, pokeAgua.getHp());
    }

    @Test
    public void seleccionarAtaque() {

        pokeAgua.seleccionarAtaque(0);
        assertEquals(atkAgua, pokeAgua.getAtaqueSeleccionado());

        pokeAgua.seleccionarAtaque(1);
        assertEquals(atkFuego, pokeAgua.getAtaqueSeleccionado());
    }

    @Test
    public void getAtaqueSeleccionado() {

        pokeFuego.seleccionarAtaque(0);
        assertEquals(atkFuego, pokeFuego.getAtaqueSeleccionado());
    }

    @Test
    public void getEnergias() {

        pokeAgua.addEnergia(agua);
        HashMap<String, Integer> map = pokeAgua.getEnergias();
        int valor = map.get("Agua");

        assertEquals(1, valor);

        pokeAgua.addEnergia(fuego);
        map = pokeAgua.getEnergias();
         valor = map.get("Fuego");

         assertEquals(1, valor);
    }

    @Test
    public void getID(){

        assertEquals(10, pokeAgua.getID());
        assertEquals(11, pokeFuego.getID());
    }

    @Test
    public void heredarEnergias(){

        pokeAgua.addEnergia(agua);
        pokeAgua.addEnergia(agua);

        pokeFuego.heredarEnergia(pokeAgua);

        int valor = pokeFuego.getEnergias().get("Agua");

        assertEquals(2, valor);
    }

    @Test
    public void getNombre(){

        assertEquals("agua", pokeAgua.getNombre());
        assertEquals("rayo", pokeRayo.getNombre());
    }

    @Test
    public void setSalud(){

        assertEquals(50, pokeAgua.getHp());
        pokeAgua.setSalud(20);
        assertEquals(20, pokeAgua.getHp());
        pokeAgua.setSalud(-10);
        assertEquals(0, pokeAgua.getHp());
    }
}