package test;

import cc3201.tarea1.corregida.*;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.*;

public class AtaqueRayoTest {

    private Pokemon pokeRayo;
    private Energia rayo;
    private Ataque atkRayo;
    ArrayList<Ataque> ataques3;

    @Before
    public void setUp() throws Exception {

        atkRayo = new AtaqueRayo("f6", 7, 10, "prueba6");
        ataques3 = new ArrayList<Ataque>();
        ataques3.add(atkRayo);
        pokeRayo = new PokemonRayo("pikachu", 6, 120, ataques3);
        rayo = new EnergiaRayo("r");
    }

    @Test
    public void comprobar() {

        pokeRayo.addEnergia(rayo);
        assertFalse(atkRayo.comprobar(pokeRayo));

        for(int i=0; i<9; i++){

            pokeRayo.addEnergia(rayo);
        }

        assertTrue(atkRayo.comprobar(pokeRayo));
    }
}