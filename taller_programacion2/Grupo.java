package taller_programacion2;

import java.util.ArrayList;

public class Grupo {
    
    private String identificador;
    private String descripcion;

    // ASOCIACIONES
    private Fase fase;
    private ArrayList<Seleccion> selecciones;

    // CONSTRUCTOR SIN PARAMETROS
    public Grupo() {
        this.selecciones = new ArrayList<>();
    }
    
    // CONSTRUCTOR PARAMETRIZADO
    public Grupo(String identificador, String descripcion, Fase fase, ArrayList<Seleccion> selecciones) {
        this.identificador = identificador;
        this.descripcion = descripcion;
        this.fase = fase;
        this.selecciones = selecciones;
    }

    //SETTERS Y GETTERS
    public String getIdentificador() {
        return identificador;
    }

    public void setIdentificador(String identificador) {
        this.identificador = identificador;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Fase getFase() {
        return fase;
    }

    public void setFase(Fase fase) {
        this.fase = fase;
    }

    public ArrayList<Seleccion> getSelecciones() {
        return selecciones;
    }

    public void setSelecciones(ArrayList<Seleccion> selecciones) {
        this.selecciones = selecciones;
    }

    //METODOS ASOCIACIONES
    public void agregarSeleccion(Seleccion seleccion) {
        if (seleccion != null) {
            this.selecciones.add(seleccion);
        }
    }

    // METODO
    public int obtenerPuntos(Seleccion s) {
        return 0;
    }

}
