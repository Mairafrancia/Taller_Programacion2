package taller_programacion2;



public class Participacion {
    private boolean esLocal;
    //tiene 1 partido y 1 seleccion
    private Partido partido;
    private Seleccion seleccion;

    //constructor por defecto
    public Participacion(){
        
    }

    //constructor parametrizado
    
    public Participacion(boolean esLocal, Partido partido, Seleccion seleccion) {
        this.esLocal = esLocal;
        this.partido = partido;
        this.seleccion = seleccion;
    }

    //metodos get y set
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

    //metodos del UML
    public int cantidadGoles(){
        return 0;
    }

    public int cantidadTarjAmarillas(){
        return 0;
    }

    public int cantidadTarRojas(){
        return 0;
    }
    
}


