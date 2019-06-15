package test;

import cc3201.tarea1.corregida.*;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.*;

public class EntrenadorTest {

    private Entrenador entrenador;
    private Entrenador rival;

    private Pokemon pokePlanta;
    private Pokemon pokeFuego;
    private Pokemon pokeAgua;
    private Pokemon pokeLucha;
    private Pokemon pokePsiquico;
    private Pokemon pokeRayo;

    private Energia planta;
    private Energia fuego;
    private Energia agua;
    private Energia lucha;
    private Energia psiquico;
    private Energia rayo;

    private Ataque atkPlanta;
    private Ataque atkFuego;
    private Ataque atkAgua;
    private Ataque atkLucha;
    private Ataque atkPsiquico;
    private Ataque atkRayo;

    ArrayList<Ataque> ataques1;
    ArrayList<Ataque> ataques2;
    ArrayList<Ataque> ataques3;

    @Before
    public void setUp() throws Exception {

        atkPlanta = new AtaquePlanta("a1", 20, 3, "prueba1");
        atkFuego = new AtaqueFuego("b2", 10, 2, "prueba2");
        atkAgua = new AtaqueAgua("c3", 15, 5, "prueba3");
        atkLucha = new AtaqueLucha("d4", 30, 7, "prueba4");
        atkPsiquico = new AtaquePsiquico("e5", 25, 8, "prueba5");
        atkRayo = new AtaqueRayo("f6", 7, 10, "prueba6");

        ataques1 = new ArrayList<Ataque>();
        ataques1.add(atkAgua);
        ataques1.add(atkFuego);
        ataques1.add(atkPlanta);
        ataques1.add(atkRayo);

        ataques2 = new ArrayList<Ataque>();
        ataques2.add(atkLucha);
        ataques2.add(atkPsiquico);

        ataques3 = new ArrayList<Ataque>();
        ataques3.add(atkRayo);

        entrenador = new Entrenador();
        rival = new Entrenador();

        pokePlanta = new PokemonPlanta("planta",1, 100, ataques1);
        pokeFuego = new PokemonFuego("fuego",2, 150, ataques2);
        pokeAgua = new PokemonAgua("agua", 3, 80, ataques1);
        pokeLucha = new PokemonLucha("lucha", 4, 70, ataques3);
        pokePsiquico = new PokemonPsiquico("psiquico", 5, 50, ataques2);
        pokeRayo = new PokemonRayo("pikachu", 6, 120, ataques3);

        planta = new EnergiaPlanta("p");
        fuego = new EnergiaFuego("f");
        agua = new EnergiaAgua("a");
        lucha = new EnergiaLucha("l");
        psiquico = new EnergiaPsiquico("psi");
        rayo = new EnergiaRayo("r");
    }

    @Test
    public void juega() {

        entrenador.addMano(pokeRayo);
        assertEquals(1, entrenador.getMano().size());

        entrenador.juega(pokeRayo);
        assertEquals(0, entrenador.getMano().size());
        assertEquals(pokeRayo, entrenador.getBanca().get(0));

        entrenador.addMano(rayo);
        entrenador.addMano(fuego);
        assertEquals(2, entrenador.getMano().size());

        entrenador.addMano(pokeFuego);
        entrenador.addMano(pokeAgua);
        entrenador.addMano(pokeLucha);
        entrenador.addMano(pokePlanta);
        entrenador.addMano(pokePsiquico);
        entrenador.addMano(pokeRayo);
        assertEquals(8, entrenador.getMano().size());

        entrenador.juega(pokeFuego);
        entrenador.juega(pokeAgua);
        entrenador.juega(pokeLucha);
        entrenador.juega(pokeLucha);
        assertEquals(5, entrenador.getMano().size());
        assertEquals(pokeLucha, entrenador.getBanca().get(3));

        entrenador.juega(pokePlanta);
        entrenador.juega(pokePsiquico);
        assertEquals(3, entrenador.getMano().size());
        assertEquals(pokePsiquico, entrenador.getBanca().get(5));

        entrenador.juega(pokeRayo);
        assertEquals(3, entrenador.getMano().size());
        assertEquals(pokePsiquico, entrenador.getBanca().get(5));

        entrenador.pokemonActivo();
        entrenador.juega(fuego);
        entrenador.juega(rayo);
        int valor = entrenador.getPokemonActivo().getEnergias().get("Fuego");
        assertEquals(1, valor);

        entrenador.addMano(rayo);
        entrenador.juega(rayo);
        valor = entrenador.getPokemonActivo().getEnergias().get("Rayo");
        assertEquals(2, valor);
    }

    @Test
    public void addBanca() {

    entrenador.addBanca(pokeRayo);
    assertEquals(pokeRayo, entrenador.getBanca().get(0));

    entrenador.addBanca(pokeFuego);
    assertEquals(pokeFuego, entrenador.getBanca().get(1));
    }

    @Test
    public void addMano() {

        entrenador.addMano(pokeAgua);

        assertEquals(pokeAgua, entrenador.getMano().get(0));

        entrenador.addMano(pokeFuego);
        entrenador.addMano(rayo);

        assertEquals(rayo, entrenador.getMano().get(2));
        assertEquals(pokeFuego, entrenador.getMano().get(1));
    }

    @Test
    public void pokemonActivo() {

        entrenador.addMano(pokeRayo);
        entrenador.addBanca(pokeRayo);
        entrenador.pokemonActivo();

        assertEquals(pokeRayo, entrenador.getPokemonActivo());
    }

    @Test
    public void getPokemonActivo() {

        entrenador.addMano(pokePsiquico);
        entrenador.addBanca(pokePsiquico);
        entrenador.pokemonActivo();

        Pokemon p = entrenador.getPokemonActivo();

        assertEquals(pokePsiquico, p);
    }

    @Test
    public void getBanca() {

        entrenador.addBanca(pokeAgua);

        assertEquals(pokeAgua,entrenador.getBanca().get(0));

        entrenador.addBanca(pokeFuego);

        assertEquals(pokeFuego,entrenador.getBanca().get(1));
        assertEquals(pokeAgua,entrenador.getBanca().get(0));
    }

    @Test
    public void getMano() {

        entrenador.addMano(pokeAgua);

        assertEquals(pokeAgua,entrenador.getMano().get(0));

        entrenador.addMano(fuego);

        assertEquals(fuego,entrenador.getMano().get(1));
        assertEquals(pokeAgua,entrenador.getMano().get(0));
    }

    @Test
    public void atacar() {

        rival.addMano(pokeRayo);
        rival.juega(pokeRayo);
        rival.pokemonActivo();

        entrenador.addMano(pokeFuego);
        entrenador.juega(pokeFuego);
        entrenador.pokemonActivo();
        entrenador.selectAtaque(0);

        for(int i=0; i<7; i++){

            entrenador.getPokemonActivo().addEnergia(lucha);
        }

        assertEquals(120, rival.getPokemonActivo().getHp());
        entrenador.atacar(rival);
        assertEquals(90, rival.getPokemonActivo().getHp());
    }

    @Test
    public void selectAtaque() {

        entrenador.addMano(pokeFuego);
        entrenador.juega(pokeFuego);
        entrenador.pokemonActivo();
        entrenador.selectAtaque(0);

        assertEquals(atkLucha, entrenador.getPokemonActivo().getAtaqueSeleccionado());

        entrenador.selectAtaque(1);

        assertEquals(atkPsiquico, entrenador.getPokemonActivo().getAtaqueSeleccionado());
    }

    @Test
    public void removerPokemon() {

        rival.addMano(pokeRayo);
        rival.addMano(pokeFuego);
        rival.juega(pokeRayo);
        rival.juega(pokeFuego);
        rival.pokemonActivo();
        rival.removerPokemon();
        assertEquals(pokeRayo, rival.getPokemonActivo());

        entrenador.addMano(pokeFuego);
        entrenador.juega(pokeFuego);
        entrenador.pokemonActivo();
        entrenador.selectAtaque(0);

        for(int i=0; i<7; i++){

            entrenador.getPokemonActivo().addEnergia(lucha);
        }
        for(int i = 0; i< 4; i++){

            entrenador.atacar(rival);
        }

        rival.pokemonActivo();;
        assertEquals(pokeFuego, entrenador.getBanca().get(0));
    }
}