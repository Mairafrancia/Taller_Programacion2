package taller_programacion2;

import java.util.ArrayList;

public class Grupo {
    private String identificador;
    private String descripcion;
    private Fase fase;
    private ArrayList<Seleccion> selecciones;

    //constructor por defecto
    public Grupo(){
        this.selecciones = new ArrayList<>();
    }
    //constructor parametrizado
    
    public Grupo(String identificador, String descripcion, Fase fase, ArrayList<Seleccion> selecciones) {
        this.identificador = identificador;
        this.descripcion = descripcion;
        this.fase = fase;
        this.selecciones = selecciones;
    }

    //metodo agregar seleccion
    public void agregarSeleccion(Seleccion seleccion){
        if (seleccion != null){
            this.selecciones.add(seleccion);
        }
    }

    //metodos get y set
    
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

    //metodo obtener puntos
    public int obtenerPuntos(Seleccion s){
      return 0;
    }

}

