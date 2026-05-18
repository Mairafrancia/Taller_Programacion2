package MAIN;

import CLASES.*;

public class Main {
    public static void main(String[] args) {
        Mundial mundial = CargadorDatos.cargar();
        System.out.println("Mundial " + mundial.getAnio());
    }
}


