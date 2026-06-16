package CLASES;

import java.util.ArrayList;

/**
 * Representa un grupo de la fase de grupos del torneo mundial.
 * Cada grupo pertenece a una {@link Fase} y contiene un conjunto
 * de {@link Seleccion}es que compiten entre si para clasificar
 * a la siguiente instancia.
 */
public class Grupo {

    /** Identificador del grupo (ej: "A", "B", "C"). */
    private String identificador;

    /** Descripcion del grupo (ej: "Grupo A"). */
    private String descripcion;

    /** Fase a la que pertenece este grupo. */
    private Fase fase;

    /** Lista de selecciones que integran este grupo. */
    private ArrayList<Seleccion> selecciones;

    /**
     * Constructor sin parametros. Inicializa con valores por defecto.
     */
    public Grupo() {
        this.identificador = "";
        this.descripcion = "";
        this.fase = null;
        this.selecciones = new ArrayList<>();
    }

    /**
     * Constructor con parametros.
     *
     * @param identificador Identificador del grupo (ej: "A", "B").
     * @param descripcion   Descripcion del grupo.
     * @param fase          Fase a la que pertenece el grupo.
     */
    public Grupo(String identificador, String descripcion, Fase fase) {
        this.identificador = identificador;
        this.descripcion = descripcion;
        this.fase = fase;
        this.selecciones = new ArrayList<>();
    }

    /** @return El identificador del grupo. */
    public String getIdentificador() { return identificador; }

    /** @param identificador El identificador a asignar. */
    public void setIdentificador(String identificador) { this.identificador = identificador; }

    /** @return La descripcion del grupo. */
    public String getDescripcion() { return descripcion; }

    /** @param descripcion La descripcion a asignar. */
    public void setDescripcion(String descripcion) { this.descripcion = descripcion; }

    /** @return La fase a la que pertenece el grupo. */
    public Fase getFase() { return fase; }

    /** @param fase La fase a asignar. */
    public void setFase(Fase fase) { this.fase = fase; }

    /** @return La lista de selecciones del grupo. */
    public ArrayList<Seleccion> getSelecciones() { return selecciones; }

    /** @param selecciones La nueva lista de selecciones. */
    public void setSelecciones(ArrayList<Seleccion> selecciones) { this.selecciones = selecciones; }

    /**
     * Agrega una seleccion al grupo.
     * No agrega si la seleccion es null.
     *
     * @param seleccion La seleccion a incorporar.
     */
    public void agregarSeleccion(Seleccion seleccion) {
        if (seleccion != null) {
            this.selecciones.add(seleccion);
        }
    }

    /**
     * Calcula los puntos acumulados por una seleccion en este grupo,
     * considerando unicamente los partidos jugados contra rivales
     * que pertenezcan al mismo grupo y en la misma fase.
     * <ul>
     *   <li>Victoria: 3 puntos</li>
     *   <li>Empate: 1 punto</li>
     *   <li>Derrota: 0 puntos</li>
     * </ul>
     *
     * @param s La seleccion de la que se calculan los puntos.
     * @return La cantidad de puntos acumulados en el grupo.
     */
    public int obtenerPuntos(Seleccion s) {
        int puntos = 0;

        for (Participacion p : s.getParticipaciones()) {
            Partido part = p.getPartido();

            if (part == null || part.getFase() != this.fase) {
                continue;
            }

            Participacion rivalPart = p.isEsLocal()
                ? part.getParticipacionVisitante()
                : part.getParticipacionLocal();

            if (rivalPart == null || !this.selecciones.contains(rivalPart.getSeleccion())) {
                continue;
            }

            int golesFavor  = p.cantidadGoles();
            int golesContra = rivalPart.cantidadGoles();

            if (golesFavor > golesContra)
                puntos += 3;
            else if (golesFavor == golesContra)
                puntos += 1;
        }
        return puntos;
    }
}