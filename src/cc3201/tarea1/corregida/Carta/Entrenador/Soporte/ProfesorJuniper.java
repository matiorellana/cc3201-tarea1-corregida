package cc3201.tarea1.corregida.Carta.Entrenador.Soporte;

import cc3201.tarea1.corregida.Entrenador;

public class ProfesorJuniper extends Soporte implements ISoporte {

    public ProfesorJuniper() {
        super("ProfesorJuniper", "Descarta tu mano y roba 7 cartas.");
    }

    @Override
    public void jugar(Entrenador entrenador) {

        for(int i = 0; i < entrenador.getMano().size(); i++){

            entrenador.descartarCarta(entrenador.getMano().get(i));
            entrenador.getMano().remove(i);
        }

        for (int j = 0; j < 7; j++){

            entrenador.robarMazo();
        }

        this.descartar(entrenador);
    }
}
