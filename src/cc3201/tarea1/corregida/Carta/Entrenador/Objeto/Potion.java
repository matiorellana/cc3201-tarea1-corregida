package cc3201.tarea1.corregida.Carta.Entrenador.Objeto;

import cc3201.tarea1.corregida.Carta.Pokemon.Pokemon;
import cc3201.tarea1.corregida.Entrenador;

import java.util.Scanner;

public class Potion extends Objeto implements IObjeto {

    private Scanner scanner;

    protected Potion() {

        super("Potion", "Remueve hasta 2 contadores de daño de uno de tus Pokémon.");
        scanner = new Scanner(System.in);
    }

    @Override
    public void efecto(Entrenador entrenador) {

        System.out.println("Ingrese numero para seleccionar Pokemon:");

        int index = scanner.nextInt();

        Pokemon seleccionado = entrenador.getBanca().get(index);
        entrenador.getBanca().get(index).setSalud(seleccionado.getHp() + 20);
    }
}
