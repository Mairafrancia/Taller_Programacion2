package CLASES;

import java.util.ArrayList;

public class Fase {

    private NombreFase nombre;

    //ASOCIACIONES
    private ArrayList<Grupo> grupos;
    private ArrayList<Partido> partidos;

    // CONSTRUCTOR SIN PARÁMETROS
    public Fase() {
        this.nombre = null;
        this.grupos = new ArrayList<>();
        this.partidos = new ArrayList<>();
    }

    // CONSTRUCTOR CON PARÁMETROS
    public Fase(NombreFase nombre) {
        this.nombre = nombre;
        this.grupos = new ArrayList<>(); // Inicializamos la lista de grupos como vacía y llenamos con el metodo agregarGrupo
        this.partidos = new ArrayList<>();
    }

    //SETTERS Y GETTERS
    public NombreFase getNombre() {
        return nombre;
    }

    public void setNombre(NombreFase nombre) {
        this.nombre = nombre;
    }

    public ArrayList<Grupo> getGrupos() {
        return grupos;
    }

    public void setGrupos(ArrayList<Grupo> grupos) {
        this.grupos = grupos;
    }

    public ArrayList<Partido> getPartidos() {
        return partidos;
    }

    public void setPartidos(ArrayList<Partido> partidos) {
        this.partidos = partidos;
    }

    //METODOS

    public void agregarGrupo(Grupo grupo) {
        if (grupo != null) {
            this.grupos.add(grupo);
        }
    }

    public void agregarPartido(Partido partido) {
        if (partido != null) {
            this.partidos.add(partido);
        }
    }

}
