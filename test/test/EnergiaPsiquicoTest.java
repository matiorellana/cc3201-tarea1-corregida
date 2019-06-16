package test;

import cc3201.tarea1.corregida.*;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.*;

public class EnergiaPsiquicoTest {

    private Entrenador entrenador;
    private Pokemon pokeAgua;
    private Energia psiquico;
    private Ataque atkAgua;
    private ArrayList<Ataque> ataques;

    @Before
    public void setUp() throws Exception {

        atkAgua = new AtaqueAgua("agua", 20, 4, "prueba");

        ataques = new ArrayList<>();
        ataques.add(atkAgua);

        pokeAgua = new PokemonAgua("water", 1, 50, ataques);

        entrenador = new Entrenador();

        psiquico = new EnergiaPsiquico("pedro_angel");
    }

    @Test
    public void anadir() {

        assertEquals(null, pokeAgua.getEnergias().get("Psiquico"));

        psiquico.anadir(pokeAgua);
        int valor = pokeAgua.getEnergias().get("Psiquico");
        assertEquals(1, valor);

        psiquico.anadir(pokeAgua);
        valor = pokeAgua.getEnergias().get("Psiquico");
        assertEquals(2, valor);
    }
}