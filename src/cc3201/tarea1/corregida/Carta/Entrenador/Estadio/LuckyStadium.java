package cc3201.tarea1.corregida.Carta.Entrenador.Estadio;

import cc3201.tarea1.corregida.Entrenador;
import cc3201.tarea1.corregida.Moneda;

public class LuckyStadium extends Estadio implements IEstadio {

    private Moneda moneda;

    public LuckyStadium() {

        super("LuckyStadium", "Una vez durante su turno, el jugador puede lanzar una moneda. Si sale" +
                "cara, el jugador roba una carta.");
        moneda = new Moneda();
    }

    @Override
    public void jugar(Entrenador entrenador) {

        int resultado = moneda.lanzar();
        if(resultado == 0){
            entrenador.robarMazo();
        }
    }
}
