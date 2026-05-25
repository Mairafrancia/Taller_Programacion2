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
        int puntos = 0;

        for (Participacion p : s.getParticipaciones()) {
            Partido part = p.getPartido();

            if (part == null || part.getFase() != this.fase) {
                continue;
            }

            // Verificar que el rival también pertenezca a ESTE grupo
            Participacion rivalPart = p.isEsLocal()
                ? part.getParticipacionVisitante()
                : part.getParticipacionLocal();

            if (rivalPart == null || !this.selecciones.contains(rivalPart.getSeleccion())) {
                continue; // El rival no es de este grupo, salteamos
            }

            int golesFavor = p.cantidadGoles();
            int golesContra = rivalPart.cantidadGoles();

            if (golesFavor > golesContra)
                puntos += 3;
            else if (golesFavor == golesContra)
                puntos += 1;
        }
        return puntos;
    }
}
