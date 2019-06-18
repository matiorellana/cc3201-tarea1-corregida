package cc3201.tarea1.corregida.Habilidad.HabilidadPokemon;

import cc3201.tarea1.corregida.Carta.Pokemon.Pokemon;
import cc3201.tarea1.corregida.Entrenador;
import cc3201.tarea1.corregida.Habilidad.Habilidad;
import cc3201.tarea1.corregida.Habilidad.IHabilidad;
import cc3201.tarea1.corregida.Moneda;

import java.util.Scanner;

public class Heal extends Habilidad implements IHabilidad {

    private Scanner scanner;
    private Moneda moneda;
    public Heal(){

        super("Heal", 5, "Una vez por turno, puedes lanzar una moneda. Si resulta cara, puedes" +
                "remover 1 contador de daño de uno de tus Pokémon.");

        scanner = new Scanner(System.in);
        moneda = new Moneda();
    }

    @Override
    public void activar(Entrenador jugador, Entrenador rival) {

        int resultado = moneda.lanzar();

        if(resultado == 0){

            System.out.println("Ingrese numero para seleccionar Pokemon:");

            int index = scanner.nextInt();

            Pokemon seleccionado = jugador.getBanca().get(index);
            jugador.getBanca().get(index).setSalud(seleccionado.getHp() + 10);
        }
    }

    @Override
    public boolean comprobar(Pokemon pokemonActivo) {
        return false;
    }
}
