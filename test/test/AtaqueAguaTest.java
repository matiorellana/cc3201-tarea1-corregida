package test;

import cc3201.tarea1.corregida.*;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.*;

public class AtaqueAguaTest {

    private Pokemon pokePlanta;

    private Energia agua;

    private Ataque atkPlanta;
    private Ataque atkFuego;
    private Ataque atkAgua;
    private Ataque atkRayo;

    ArrayList<Ataque> ataques1;

    @Before
    public void setUp() throws Exception {

        atkPlanta = new AtaquePlanta("a1", 20, 3, "prueba1");
        atkFuego = new AtaqueFuego("b2", 10, 2, "prueba2");
        atkAgua = new AtaqueAgua("c3", 15, 5, "prueba3");
        atkRayo = new AtaqueRayo("f6", 7, 10, "prueba6");

        ataques1 = new ArrayList<>();
        ataques1.add(atkAgua);
        ataques1.add(atkFuego);
        ataques1.add(atkPlanta);
        ataques1.add(atkRayo);

        pokePlanta = new PokemonPlanta("planta",1, 100, ataques1);

        agua = new EnergiaAgua("a");
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

        assertEquals(15, atkAgua.getDano());
        assertEquals(10, atkFuego.getDano());
        assertEquals(7, atkRayo.getDano());
    }
}