package CLASES;

import java.util.ArrayList;

/**
 * Representa un estadio de futbol donde se disputan los partidos del torneo.
 * Cada estadio pertenece a una {@link Sede} y mantiene la lista de partidos
 * que se juegan en el.
 */
public class Estadio {

    /** Nombre del estadio. */
    private String nombre;

    /** Capacidad maxima de espectadores del estadio. */
    private int capacidad;

    /** Sede a la que pertenece el estadio. */
    private Sede sede;

    /** Lista de partidos disputados en este estadio. */
    private ArrayList<Partido> partidos;

    /**
     * Constructor sin parametros. Inicializa con valores por defecto.
     */
    public Estadio() {
        this.nombre = "";
        this.capacidad = 0;
        this.sede = null;
        this.partidos = new ArrayList<>();
    }

    /**
     * Constructor con parametros.
     *
     * @param nombre    Nombre del estadio.
     * @param capacidad Capacidad maxima de espectadores.
     * @param sede      Sede a la que pertenece el estadio.
     */
    public Estadio(String nombre, int capacidad, Sede sede) {
        this.nombre = nombre;
        this.capacidad = capacidad;
        this.sede = sede;
        this.partidos = new ArrayList<>();
    }

    /** @return El nombre del estadio. */
    public String getNombre() { return nombre; }

    /** @param nombre El nombre a asignar. */
    public void setNombre(String nombre) { this.nombre = nombre; }

    /** @return La capacidad maxima de espectadores. */
    public int getCapacidad() { return capacidad; }

    /** @param capacidad La capacidad a asignar. */
    public void setCapacidad(int capacidad) { this.capacidad = capacidad; }

    /** @return La sede a la que pertenece el estadio. */
    public Sede getSede() { return sede; }

    /** @param sede La sede a asignar. */
    public void setSede(Sede sede) { this.sede = sede; }

    /** @return La lista de partidos disputados en este estadio. */
    public ArrayList<Partido> getPartidos() { return partidos; }

    /** @param partidos La nueva lista de partidos. */
    public void setPartidos(ArrayList<Partido> partidos) { this.partidos = partidos; }

    /**
     * Agrega un partido a la lista del estadio y asegura la consistencia
     * bidireccional asignando este estadio al partido si aun no lo tiene.
     * No agrega si el partido es null.
     *
     * @param partido El partido a incorporar.
     */
    public void agregarPartido(Partido partido) {
        if (partido != null) {
            this.partidos.add(partido);
            if (partido.getEstadio() != this) {
                partido.setEstadio(this);
            }
        }
    }
}