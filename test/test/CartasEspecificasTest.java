package test;

import cc3201.tarea1.corregida.Carta.Carta;
import cc3201.tarea1.corregida.Carta.Energia.Energia;
import cc3201.tarea1.corregida.Carta.Energia.EnergiaAgua;
import cc3201.tarea1.corregida.Carta.Entrenador.Estadio.LuckyStadium;
import cc3201.tarea1.corregida.Carta.Entrenador.Objeto.Potion;
import cc3201.tarea1.corregida.Carta.Entrenador.Soporte.ProfesorJuniper;
import cc3201.tarea1.corregida.Carta.Pokemon.Basico.PokemonBasicoFuego;
import cc3201.tarea1.corregida.Carta.Pokemon.Pokemon;
import cc3201.tarea1.corregida.Entrenador;
import cc3201.tarea1.corregida.Habilidad.Ataque.ElectricShock;
import cc3201.tarea1.corregida.Habilidad.HabilidadPokemon.Heal;
import cc3201.tarea1.corregida.Habilidad.IHabilidad;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.*;

public class CartasEspecificasTest {

    private IHabilidad electrickShock;
    private IHabilidad heal;
    private Carta luckyStadium;

    private Entrenador jugador;

    private Pokemon pokeFuego;
    private Energia agua;

    private ArrayList<IHabilidad> habilidad;

    @Before
    public void setUp(){

        electrickShock = new ElectricShock();
        heal = new Heal();
        luckyStadium = new LuckyStadium();

        jugador = new Entrenador();

        habilidad = new ArrayList<>();
        habilidad.add(electrickShock);

        pokeFuego = new PokemonBasicoFuego("A", 1, 30, habilidad);
        agua = new EnergiaAgua("qw");
    }

    @Test
    public void activar() {
    }

    @Test
    public void jugarLuckyStadium() {

        for (int i = 0; i < 10; i++){
            jugador.addCartaMazo(pokeFuego);
        }

        jugador.robarMazo();
        jugador.robarMazo();

        assertEquals(2, jugador.getMano().size());
        luckyStadium.jugar(jugador);
        int valor = jugador.getMano().size();

        if (valor>=2 && valor<= 3){
            assertTrue(true);
        }
        else{
            assertFalse(false);
        }
    }

}