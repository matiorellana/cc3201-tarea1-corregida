package test;

import cc3201.tarea1.corregida.*;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.*;

public class AtaquePsiquicoTest {

    private Pokemon pokeFuego;

    private Energia psiquico;

    private Ataque atkLucha;
    private Ataque atkPsiquico;

    ArrayList<Ataque> ataques2;

    @Before
    public void setUp() throws Exception {

        atkLucha = new AtaqueLucha("d4", 30, 7, "prueba4");
        atkPsiquico = new AtaquePsiquico("e5", 25, 8, "prueba5");

        ataques2 = new ArrayList<Ataque>();
        ataques2.add(atkLucha);
        ataques2.add(atkPsiquico);

        pokeFuego = new PokemonFuego("fuego",2, 150, ataques2);

        psiquico = new EnergiaPsiquico("p");
    }

    @Test
    public void comprobar() {

        pokeFuego.addEnergia(psiquico);
        assertFalse(atkPsiquico.comprobar(pokeFuego));

        for(int i=0; i<7; i++){

            pokeFuego.addEnergia(psiquico);
        }

        assertTrue(atkPsiquico.comprobar(pokeFuego));
    }
}