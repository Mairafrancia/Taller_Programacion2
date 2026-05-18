package CLASES;

import java.util.ArrayList;

public class Grupo {

    private String identificador;
    private String descripcion;

    // ASOCIACIONES
    private Fase fase;
    private ArrayList<Seleccion> selecciones;

    // CONSTRUCTOR SIN PARAMETROS
    public Grupo() {
        this.identificador = "";
        this.descripcion = "";
        this.fase = null;
        this.selecciones = new ArrayList<>();
    }

    // CONSTRUCTOR PARAMETRIZADO
    public Grupo(String identificador, String descripcion, Fase fase) {
        this.identificador = identificador;
        this.descripcion = descripcion;
        this.fase = fase;
        this.selecciones = new ArrayList<>(); // Inicializamos la lista de selecciones como vacía y llenamos con el metodo agregarSeleccion
    }

    // SETTERS Y GETTERS
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

    // METODOS ASOCIACIONES
    public void agregarSeleccion(Seleccion seleccion) {
        if (seleccion != null) {
            this.selecciones.add(seleccion);
        }
    }

    // METODO PARA OBTENER LOS PUNTOS DE UNA SELECCION EN ESTE GRUPO
    public int obtenerPuntos(Seleccion s) {

        // **/ LOGICA SEGUN LA CONSIGNA:
        // **/ Victoria: 3 pts.
        // **/Empate: 1 pt.
        // **/Derrota: 0 pts.

        int puntos = 0; // Empezamos con cero puntos

        // Recorremos cada partido en el que participó esta selección
        for (Participacion p : s.getParticipaciones()) {
            Partido part = p.getPartido();
            int golesFavor = p.cantidadGoles(); // Goles que hicimos nosotros
            int golesContra = 0; // Acá vamos a guardar los del rival

            // IDENTIFICAMOS AL RIVAL
            if (p.isEsLocal()) {
                // Si nosotros fuimos locales, el rival es el visitante
                Participacion rival = part.getParticipacionVisitante();
                golesContra = rival.cantidadGoles();
            } else {
                // Si nosotros fuimos visitantes, el rival es el local
                Participacion rival = part.getParticipacionLocal();
                golesContra = rival.cantidadGoles();
            }

            if (golesFavor > golesContra) // Ganamos (+3)
                puntos += 3;
            else if (golesFavor == golesContra) // Empatamos (+1)
                puntos += 1;
            // Si perdimos no hace nada (suma 0)
        }
        return puntos; // Devolvemos el total de puntos acumulados
    }
}
