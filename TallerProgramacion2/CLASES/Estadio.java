package CLASES;

import java.util.ArrayList;

public class Estadio {

    private String nombre;
    private int capacidad;
    private Sede sede; // un estadio pertenece a una sede
    private ArrayList<Partido> partidos; //lista de partidos que tiene ese estadio

    // CONSTRUCTOR SIN PARAMETROS
    public Estadio(){
        this.nombre = "";
        this.capacidad = 0;
        this.sede = null;
        this.partidos = new ArrayList<>();
    }
    
    // CONSTRUCTOR CON PARAMETROS
    public Estadio(String nombre, int capacidad, Sede sede) {
        this.nombre = nombre;
        this.capacidad = capacidad;
        this.sede = sede;
        this.partidos = new ArrayList<>(); // inicializamos la lista de partidos como vacía y llenamos con el metodo agregarPartido
    }
    
    //SETTERS Y GETTERS

    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public int getCapacidad() {
        return capacidad;
    }
    public void setCapacidad(int capacidad) {
        this.capacidad = capacidad;
    }
    public Sede getSede() {
        return sede;
    }
    public void setSede(Sede sede) {
        this.sede = sede;
    }
    public ArrayList<Partido> getPartidos() {
        return partidos;
    }
    public void setPartidos(ArrayList<Partido> partidos) {
        this.partidos = partidos;
    }

    //METODOS 

    //metodo agregarPartido
    public void agregarPartido(Partido partido){
        if (partido != null){
            this.partidos.add(partido);
            // Le avisamos al partido que este es su estadio
            if (partido.getEstadio() != this) {
                partido.setEstadio(this);
            }
        }
       
    }
    
}

