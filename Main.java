package MI_TALLER;

public class Main {
    public static void main(String[] args) {
        Mundial mundial = CargadorDatos.cargar();
        System.out.println("Mundial " + mundial.getAnio());
    }
}

