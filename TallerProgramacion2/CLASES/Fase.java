package CLASES;

import java.util.ArrayList;

/**
 * Representa una fase del torneo mundial (ej: Grupos, Octavos de Final,
 * Semifinal, Final). Cada fase agrupa los partidos y, en el caso de la
 * fase de grupos, tambien los grupos que la componen.
 * @author Florencia Benitez
 * @author Agustina Barreto
 * @author Francia Maira
 * @author Gabriela Yañez
 */
public class Fase {

    /** Nombre identificador de la fase segun el enum {@link NombreFase}. */
    private NombreFase nombre;

    /**
     * Lista de grupos que conforman esta fase.
     * Solo aplica para la fase de grupos; en fases eliminatorias esta vacia.
     */
    private ArrayList<Grupo> grupos;

    /** Lista de partidos disputados en esta fase. */
    private ArrayList<Partido> partidos;

    /**
     * Constructor sin parametros. Inicializa con valores por defecto.
     */
    public Fase() {
        this.nombre = null;
        this.grupos = new ArrayList<>();
        this.partidos = new ArrayList<>();
    }

    /**
     * Constructor con parametros.
     *
     * @param nombre El nombre de la fase segun {@link NombreFase}.
     */
    public Fase(NombreFase nombre) {
        this.nombre = nombre;
        this.grupos = new ArrayList<>();
        this.partidos = new ArrayList<>();
    }

    /** @return El nombre de la fase. */
    public NombreFase getNombre() { return nombre; }

    /** @param nombre El nombre de la fase a asignar. */
    public void setNombre(NombreFase nombre) { this.nombre = nombre; }

    /** @return La lista de grupos de la fase. */
    public ArrayList<Grupo> getGrupos() { return grupos; }

    /** @param grupos La nueva lista de grupos. */
    public void setGrupos(ArrayList<Grupo> grupos) { this.grupos = grupos; }

    /** @return La lista de partidos de la fase. */
    public ArrayList<Partido> getPartidos() { return partidos; }

    /** @param partidos La nueva lista de partidos. */
    public void setPartidos(ArrayList<Partido> partidos) { this.partidos = partidos; }

    /**
     * Agrega un grupo a la fase.
     * No agrega si el grupo es null.
     *
     * @param grupo El grupo a incorporar.
     */
    public void agregarGrupo(Grupo grupo) {
        if (grupo != null) {
            this.grupos.add(grupo);
        }
    }

    /**
     * Agrega un partido a la fase.
     * No agrega si el partido es null.
     *
     * @param partido El partido a incorporar.
     */
    public void agregarPartido(Partido partido) {
        if (partido != null) {
            this.partidos.add(partido);
        }
    }
}