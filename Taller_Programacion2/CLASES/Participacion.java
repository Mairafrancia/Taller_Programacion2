package CLASES;

public class Participacion {

    private boolean esLocal;

    // tiene 1 partido y 1 seleccion
    private Partido partido;
    private Seleccion seleccion;

    // CONSTRUCTOR SIN PARAMETROS
    public Participacion() {
        this.esLocal = false;
        this.partido = null;
        this.seleccion = null;
    }

    // CONSTRUCTOR CON PARAMETROS
    public Participacion(boolean esLocal, Partido partido, Seleccion seleccion) {
        this.esLocal = esLocal;
        this.partido = partido;
        this.seleccion = seleccion;
    }

    // SETTERS Y GETTERS
    public boolean isEsLocal() {
        return esLocal;
    }

    public void setEsLocal(boolean esLocal) {
        this.esLocal = esLocal;
    }

    public Partido getPartido() {
        return partido;
    }

    public void setPartido(Partido partido) {
        this.partido = partido;
    }

    public Seleccion getSeleccion() {
        return seleccion;
    }

    public void setSeleccion(Seleccion seleccion) {
        this.seleccion = seleccion;
    }

    // METODOS
    public int cantidadGoles() {
        int goles = 0;
        for (Evento e : partido.getEventos()) {
            // Si el evento es GOL y el jugador pertenece a esta selección
            if (e.getTipo() == TipoEvento.GOL && seleccion.getJugadores().contains(e.getJugador())) {
                goles++;
            }
        }
        return goles;
    }

    // LAS TARJETAS SON DADAS A LOS JUGADORES, NO A LA SELECCION O PARTIDO
    public int cantidadTarjAmarillas() {
        int amarillas = 0;
        // Recorremos los eventos del partido en el que participamos
        for (Evento e : partido.getEventos()) {
            // Si el evento es tarjeta amarilla Y el jugador que la recibió es de nuestraselección
            if (e.getTipo() == TipoEvento.TARJETA_AMARILLA && seleccion.getJugadores().contains(e.getJugador())) {
                amarillas++;
            }
        }
        return amarillas;
    }

    public int cantidadTarRojas() {
        int rojas = 0;
        for (Evento e : partido.getEventos()) {
            // Si el evento es tarjeta roja Y el jugador es nuestro
            if (e.getTipo() == TipoEvento.TARJETA_ROJA && seleccion.getJugadores().contains(e.getJugador())) {
                rojas++;
            }
        }
        return rojas;
    }

}
