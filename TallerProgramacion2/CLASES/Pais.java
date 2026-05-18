package CLASES;

import java.util.ArrayList;

public class Pais {

    private String nombre;
    private String bandera;
    private ArrayList<Sede> sedes; // un pais tiene muchas sedes
    private Seleccion seleccion; // puede tener o no una seleccion
    private ArrayList<Arbitro> arbitros;

    // CONSTRUCTOR SIN PARAMETROS
    public Pais() {
        this.nombre = "";
        this.bandera = "";
        this.sedes = new ArrayList<>();
        this.seleccion = null;
        this.arbitros = new ArrayList<>();
    }

    // CONSTRUCTOR PARAMETRIZADO
    public Pais(String nombre, String bandera, Seleccion seleccion) {
        this.nombre = nombre;
        this.bandera = bandera;
        this.sedes = new ArrayList<>();
        this.seleccion = seleccion;
        this.arbitros = new ArrayList<>(); // Inicializamos la lista de árbitros vacía y la llenamos con metodo
    }

    //SETTERS Y GETTERS
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getBandera() {
        return bandera;
    }

    public void setBandera(String bandera) {
        this.bandera = bandera;
    }

    public ArrayList<Sede> getSedes() {
        return sedes;
    }

    public void setSedes(ArrayList<Sede> sedes) {
        this.sedes = sedes;
    }

    public Seleccion getSeleccion() {
        return seleccion;
    }

    public void setSeleccion(Seleccion seleccion) {
        this.seleccion = seleccion;
    }

    public ArrayList<Arbitro> getArbitros() {
        return arbitros;
    }

    public void setArbitros(ArrayList<Arbitro> arbitros) {
        this.arbitros = arbitros;
    }

    //METODOS

    // metodo agregarSede
    public void agregarSede(Sede sede) {
        if (sede != null) {
            this.sedes.add(sede);
        }
    }

    // metodo agregarArbitro
    public void agregarArbitro(Arbitro arbitro) {
        if (arbitro != null) {
            this.arbitros.add(arbitro);
        }
    }
}