package test;

import cc3201.tarea1.corregida.Carta.Energia.*;
import cc3201.tarea1.corregida.Carta.Pokemon.Basico.*;
import cc3201.tarea1.corregida.Carta.Pokemon.Pokemon;
import cc3201.tarea1.corregida.Controlador;
import cc3201.tarea1.corregida.Entrenador;
import cc3201.tarea1.corregida.Habilidad.Ataque.*;
import cc3201.tarea1.corregida.Habilidad.IHabilidad;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.*;

public class ControladorTest {

    private Controlador controlador;

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

    ArrayList<IHabilidad> ataques1;
    ArrayList<IHabilidad> ataques2;
    ArrayList<IHabilidad> ataques3;

    @Before
    public void setUp(){

        controlador = new Controlador();

        atkPlanta = new AtaquePlanta("a1", 20, 3, "prueba1");
        atkFuego = new AtaqueFuego("b2", 10, 2, "prueba2");
        atkAgua = new AtaqueAgua("c3", 15, 5, "prueba3");
        atkLucha = new AtaqueLucha("d4", 30, 7, "prueba4");
        atkPsiquico = new AtaquePsiquico("e5", 25, 8, "prueba5");
        atkRayo = new AtaqueRayo("f6", 7, 10, "prueba6");

        ataques1 = new ArrayList<>();
        ataques1.add(atkAgua);
        ataques1.add(atkFuego);
        ataques1.add(atkPlanta);
        ataques1.add(atkRayo);

        ataques2 = new ArrayList<>();
        ataques2.add(atkLucha);
        ataques2.add(atkPsiquico);

        ataques3 = new ArrayList<>();
        ataques3.add(atkRayo);

        entrenador = new Entrenador();
        rival = new Entrenador();

        pokePlanta = new PokemonBasicoPlanta("planta",1, 100, ataques1);
        pokeFuego = new PokemonBasicoFuego("fuego",2, 150, ataques2);
        pokeAgua = new PokemonBasicoAgua("agua", 3, 80, ataques1);
        pokeLucha = new PokemonBasicoLucha("lucha", 4, 70, ataques3);
        pokePsiquico = new PokemonBasicoPsiquico("psiquico", 5, 50, ataques2);
        pokeRayo = new PokemonBasicoRayo("pikachu", 6, 120, ataques3);

        planta = new EnergiaPlanta("p");
        fuego = new EnergiaFuego("f");
        agua = new EnergiaAgua("a");
        lucha = new EnergiaLucha("l");
        psiquico = new EnergiaPsiquico("psi");
        rayo = new EnergiaRayo("r");
    }

    @Test
    public void robarCarta() {

        entrenador.addCartaMazo(pokeAgua);
        entrenador.addCartaMazo(agua);

        assertEquals(0, entrenador.getMano().size());
        controlador.robarCarta(entrenador);
        assertEquals(1,entrenador.getMano().size());
        controlador.robarCarta(entrenador);
        assertEquals(1,entrenador.getMano().size());
    }

    @Test
    public void jugarCartaMano() {

        controlador.setTurno();
        entrenador.addMano(pokeFuego);
        entrenador.addMano(fuego);
        controlador.jugarCartaMano(entrenador,0);
        entrenador.pokemonActivo();

        assertEquals(pokeFuego, entrenador.getBanca().get(0));

        controlador.jugarCartaMano(entrenador,0);

        int valor = entrenador.getBanca().get(0).getEnergias().get("Fuego");
        assertEquals(1, valor);
    }

    @Test
    public void terminarTurno() {

        controlador.terminarTurno();
        assertEquals(0, controlador.getTurno());

        controlador.setTurno();
        assertEquals(1, controlador.getTurno());

        controlador.terminarTurno();
        assertEquals(0,controlador.getTurno());

        controlador.terminarTurno();
        assertEquals(0,controlador.getTurno());
    }

    @Test
    public void ataque() {

        controlador.setTurno();

        entrenador.addMano(pokeFuego);
        entrenador.juega(pokeFuego);
        entrenador.pokemonActivo();
        entrenador.selectAtaque(0);
        for(int i=0; i<7; i++){
            entrenador.getPokemonActivo().addEnergia(lucha);
        }

        rival.addMano(pokeAgua);
        rival.juega(pokeAgua);
        rival.pokemonActivo();

        controlador.ataque(entrenador, rival);

        assertEquals(0, controlador.getTurno());
    }
}