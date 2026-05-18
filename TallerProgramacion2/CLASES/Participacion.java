package CLASES;

public class Participacion {

    private boolean esLocal;

    // tiene 1 partido y 1 seleccion
    private Partido partido;
    private Seleccion seleccion;

    // CONSTRUCTOR SIN PARAMETROS
    public Participacion() {
        this.esLocal = false;
        this.partido = null;
        this.seleccion = null;
    }

    // CONSTRUCTOR CON PARAMETROS
    public Participacion(boolean esLocal, Partido partido, Seleccion seleccion) {
        this.esLocal = esLocal;
        this.partido = partido;
        this.seleccion = seleccion;
    }

    // SETTERS Y GETTERS
    public boolean isEsLocal() {
        return esLocal;
    }

    public void setEsLocal(boolean esLocal) {
        this.esLocal = esLocal;
    }

    public Partido getPartido() {
        return partido;
    }

    public void setPartido(Partido partido) {
        this.partido = partido;
    }

    public Seleccion getSeleccion() {
        return seleccion;
    }

    public void setSeleccion(Seleccion seleccion) {
        this.seleccion = seleccion;
    }

    // METODOS
    public int cantidadGoles() {
        return 0;
    }

    public int cantidadTarjAmarillas() {
        return 0;
    }

    public int cantidadTarRojas() {
        return 0;
    }

}
