package CLASES;

/**
 * Representa la participacion de una seleccion en un partido especifico.
 * Vincula una {@link Seleccion} con un {@link Partido} e indica si actua
 * como local o visitante. Ademas, provee metodos para contabilizar
 * eventos propios de la seleccion en ese partido (goles, tarjetas).
 * @author Florencia Benitez
 * @author Agustina Barreto
 * @author Francia Maira
 * @author Gabriela Yañez
 */
public class Participacion {

    /**
     * Indica si la seleccion actua como local en el partido.
     * True si es local, false si es visitante.
     */
    private boolean esLocal;

    /** Partido al que corresponde esta participacion. */
    private Partido partido;

    /** Seleccion que participa en el partido. */
    private Seleccion seleccion;

    /**
     * Constructor sin parametros. Inicializa con valores por defecto.
     */
    public Participacion() {
        this.esLocal = false;
        this.partido = null;
        this.seleccion = null;
    }

    /**
     * Constructor con parametros.
     *
     * @param esLocal   True si la seleccion actua como local, false si es visitante.
     * @param partido   Partido al que corresponde la participacion.
     * @param seleccion Seleccion que participa.
     */
    public Participacion(boolean esLocal, Partido partido, Seleccion seleccion) {
        this.esLocal = esLocal;
        this.partido = partido;
        this.seleccion = seleccion;
    }

    /**
     * Retorna si la seleccion es local en el partido.
     * @return True si es local, false si es visitante.
     */
    public boolean isEsLocal() { return esLocal; }

    /**
     * Establece si la seleccion es local en el partido.
     * @param esLocal True si es local, false si es visitante.
     */
    public void setEsLocal(boolean esLocal) { this.esLocal = esLocal; }

    /** @return El partido al que corresponde esta participacion. */
    public Partido getPartido() { return partido; }

    /** @param partido El partido a asignar. */
    public void setPartido(Partido partido) { this.partido = partido; }

    /** @return La seleccion que participa. */
    public Seleccion getSeleccion() { return seleccion; }

    /** @param seleccion La seleccion a asignar. */
    public void setSeleccion(Seleccion seleccion) { this.seleccion = seleccion; }

    /**
     * Cuenta la cantidad de goles convertidos por esta seleccion en el partido.
     * Recorre los eventos del partido buscando eventos de tipo GOL o
     * PENAL_CONVERTIDO cuyo jugador pertenezca al plantel de la seleccion,
     * usando comparacion por referencia. Se incluyen los penales convertidos
     * porque a efectos estadisticos tambien son goles validos.
     *
     * @return La cantidad de goles de la seleccion en el partido.
     */
    public int cantidadGoles() {
        int goles = 0;
        if (this.partido != null && this.seleccion != null) {
            for (Evento e : this.partido.getEventos()) {
                if (e != null && (e.getTipo() == TipoEvento.GOL || e.getTipo() == TipoEvento.PENAL_CONVERTIDO) && e.getJugador() != null) {
                    for (Jugador j : this.seleccion.getJugadores()) {
                        if (j == e.getJugador()) {
                            goles++;
                            break;
                        }
                    }
                }
            }
        }
        return goles;
    }

    /**
     * Cuenta la cantidad de tarjetas amarillas recibidas por jugadores
     * de esta seleccion en el partido.
     * Usa comparacion por referencia para identificar al jugador.
     *
     * @return La cantidad de tarjetas amarillas de la seleccion en el partido.
     */
    public int cantidadTarjAmarillas() {
        int amarillas = 0;
        if (this.partido != null && this.seleccion != null) {
            for (Evento e : this.partido.getEventos()) {
                if (e != null && e.getTipo() == TipoEvento.TARJETA_AMARILLA && e.getJugador() != null) {
                    for (Jugador j : this.seleccion.getJugadores()) {
                        if (j == e.getJugador()) {
                            amarillas++;
                            break;
                        }
                    }
                }
            }
        }
        return amarillas;
    }

    /**
     * Cuenta la cantidad de tarjetas rojas recibidas por jugadores
     * de esta seleccion en el partido.
     * Usa comparacion por referencia para identificar al jugador.
     *
     * @return La cantidad de tarjetas rojas de la seleccion en el partido.
     */
    public int cantidadTarRojas() {
        int rojas = 0;
        if (this.partido != null && this.seleccion != null) {
            for (Evento e : this.partido.getEventos()) {
                if (e != null && e.getTipo() == TipoEvento.TARJETA_ROJA && e.getJugador() != null) {
                    for (Jugador j : this.seleccion.getJugadores()) {
                        if (j == e.getJugador()) {
                            rojas++;
                            break;
                        }
                    }
                }
            }
        }
        return rojas;
    }
}