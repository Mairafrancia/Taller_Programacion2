package CLASES;

import java.util.ArrayList;

public class Fase {

    private NombreFase nombre;

     //ASOCIACIONES
    private ArrayList<Grupo> grupos;
    private ArrayList<Partido> partidos;

    // CONSTRUCTOR SIN PARAMETROS
    public Fase() {
        this.nombre = null;
        this.partidos = new ArrayList<>();
        this.grupos = new ArrayList<>();
    }

    // CONSTRUCTOR CON PARAMETROS
    public Fase(NombreFase nombre, ArrayList<Grupo> grupos, ArrayList<Partido> partidos) {
        this.nombre = nombre;
        if (partidos != null) {
            this.partidos = partidos;
        } else {
            this.partidos = new ArrayList<>();
        }
        if (grupos != null) {
            this.grupos = grupos;
        } else {
            this.grupos = new ArrayList<>();
        }
    }

    // SETTERS Y GETTERS
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
    
    // metodos de agregar
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
