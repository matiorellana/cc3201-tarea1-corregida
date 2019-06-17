package cc3201.tarea1.corregida.Habilidad.Ataque;

import cc3201.tarea1.corregida.Entrenador;
import cc3201.tarea1.corregida.Moneda;

public class ElectricShock extends AtaqueRayo implements IAtaque{

    private Moneda moneda;

    public ElectricShock() {

        super("ElectricShock", 30, 4, "Lanza una moneda, si sale sello, este Pokémon recibe 10 de daño.");
        moneda = new Moneda();
    }

    @Override

    public void activar(Entrenador jugador, Entrenador rival){

        int resultado = moneda.lanzar();

        if(resultado == 1){

            jugador.getPokemonActivo().setSalud(jugador.getPokemonActivo().getHp() - 10);
        }
    }
}
