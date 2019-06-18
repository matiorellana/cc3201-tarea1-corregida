package test;

import cc3201.tarea1.corregida.Habilidad.Ataque.ElectricShock;
import cc3201.tarea1.corregida.Habilidad.HabilidadPokemon.Heal;
import cc3201.tarea1.corregida.Habilidad.IHabilidad;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class HabilidadTest {

    private IHabilidad electrickShock;
    private IHabilidad heal;

    @Before
    public void setUp(){

        electrickShock = new ElectricShock();
        heal = new Heal();
    }

    @Test
    public void getNombre() {

        assertEquals("ElectricShock", electrickShock.getNombre());
        assertEquals("Heal", heal.getNombre());
    }

    @Test
    public void getCoste() {

        assertEquals(5, heal.getCoste());
        assertEquals(4, electrickShock.getCoste());
    }
}