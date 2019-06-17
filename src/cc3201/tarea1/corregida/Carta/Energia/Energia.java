package cc3201.tarea1.corregida.Carta.Energia;

import cc3201.tarea1.corregida.Entrenador;
import cc3201.tarea1.corregida.Carta.Pokemon.Pokemon;

import java.util.Scanner;

public abstract class Energia implements IEnergia {

    protected String nombre;
    protected Scanner scanner;

    protected Energia(String nombre){

        this.nombre = nombre;
        scanner = new Scanner(System.in);
    }

    @Override
    public void jugar(Entrenador entrenador) {

        System.out.println("Ingresa numero para elegir pokemon de la banca:");
        int index = scanner.nextInt();
        entrenador.getBanca().get(index).addEnergia(this);
    }

    @Override
    public String getNombre(){

        return this.nombre;
    }

    public abstract void anadir(Pokemon pokemon);
}
