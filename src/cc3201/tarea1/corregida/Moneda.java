package cc3201.tarea1.corregida;

public class Moneda {

    public int lanzar(){

        System.out.println("Lanzando moneda: resultado");
        double valor = Math.random();
        if(valor < 0.5){

            System.out.println("Cara");
            return 0;
        }
        else{

            System.out.println("Sello");
            return 1;
        }
    }
}
