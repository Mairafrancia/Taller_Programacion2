package MAIN;
import CLASES.Mundial;
import MAIN.CargadorDatos;

public class Main {
    public static void main(String[] args) {
        Mundial mundial = CargadorDatos.cargar();
        System.out.println("Mundial " + mundial.getAnio());
    }
}


