package test.AtaqueTest;

import cc3201.tarea1.corregida.*;
import cc3201.tarea1.corregida.Carta.Pokemon.Basico.PokemonBasicoAgua;
import cc3201.tarea1.corregida.Carta.Pokemon.Basico.PokemonBasicoRayo;
import cc3201.tarea1.corregida.Habilidad.Ataque.Ataque;
import cc3201.tarea1.corregida.Habilidad.Ataque.AtaqueRayo;
import cc3201.tarea1.corregida.Carta.Energia.Energia;
import cc3201.tarea1.corregida.Carta.Energia.EnergiaRayo;
import cc3201.tarea1.corregida.Carta.Pokemon.Pokemon;
import cc3201.tarea1.corregida.Carta.Pokemon.PokemonAgua;
import cc3201.tarea1.corregida.Carta.Pokemon.PokemonRayo;
import cc3201.tarea1.corregida.Habilidad.IHabilidad;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.*;

public class AtaqueRayoTest {

    private Pokemon pokeRayo;
    private Pokemon pokeAgua;

    private Energia rayo;

    private Ataque atkRayo;
    ArrayList<IHabilidad> ataques3;

    private Entrenador entrenador;
    private Entrenador rival;

    @Before
    public void setUp() throws Exception {

        atkRayo = new AtaqueRayo("f6", 7, 10, "prueba6");
        ataques3 = new ArrayList<>();
        ataques3.add(atkRayo);

        pokeRayo = new PokemonBasicoRayo("pikachu", 6, 120, ataques3);
        pokeAgua = new PokemonBasicoAgua("aquaman", 9,30, ataques3);

        rayo = new EnergiaRayo("r");

        entrenador = new Entrenador();
        rival = new Entrenador();
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

    @Test
    public void attack(){

        entrenador.addMano(pokeRayo);
        entrenador.juega(pokeRayo);
        entrenador.pokemonActivo();
        assertEquals(120, entrenador.getPokemonActivo().getHp());

        atkRayo.attack(entrenador);
        assertEquals(113, entrenador.getPokemonActivo().getHp());

        rival.addMano(pokeAgua);
        rival.juega(pokeAgua);
        rival.pokemonActivo();
        assertEquals(30, rival.getPokemonActivo().getHp());

        atkRayo.attack(rival);
        assertEquals(16, rival.getPokemonActivo().getHp());
    }
}