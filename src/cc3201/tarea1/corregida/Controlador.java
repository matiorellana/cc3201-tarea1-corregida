package cc3201.tarea1.corregida;

import cc3201.tarea1.corregida.Carta.Carta;

import java.util.ArrayList;

public class Controlador {

    private int turno = 0;

    public void robarCarta(Entrenador entrenador) {

        if (this.turno == 0) {

            entrenador.robarMazo();
            turno = 1;
        }
    }

    public void verCartasMano(Entrenador entrenador){

        if(this.turno == 1) {
            ArrayList<Carta> mano = entrenador.getMano();
            System.out.println("Se tiene las siguientes cartas en mano\n");
            for (int i = 0; i < mano.size(); i++) {
                System.out.println(i + ". " + mano.get(i).getNombre());
            }
        }
    }

    public void jugarCartaMano(Entrenador entrenador, int index) {

        if (this.turno == 1) {
            entrenador.juega(entrenador.getMano().get(index));
        }
    }

    public void verPokemon(Entrenador jugador){

        if(this.turno == 1) {
            System.out.println("Activo: " + jugador.getPokemonActivo().getNombre() + "\n");
            System.out.println("Banca: \n");
            for (int i = 1; i < jugador.getBanca().size(); i++) {
                System.out.println(jugador.getBanca().get(i).getNombre() + "\n");
            }
        }
    }

    public void pokemonCampo(Entrenador jugador, Entrenador rival) {

        if (this.turno == 1) {
            System.out.println("Tus pokemon: \n");
            verPokemon(jugador);
            System.out.println("Los pokemon de tu rival: \n");
            verPokemon(rival);
        }
    }

    public void terminarTurno(){
        this.turno = 0;
    }

    public void ataque(Entrenador jugador, Entrenador rival){

        jugador.atacar(rival);
        this.terminarTurno();
    }

    public void setTurno(){
        if(turno == 1){
            this.turno = 0;
        }
        else{
            this.turno = 1;
        }
    }

    public int getTurno(){
        return this.turno;
    }
}

