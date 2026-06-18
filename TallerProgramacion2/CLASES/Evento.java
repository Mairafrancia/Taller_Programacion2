package CLASES;

import EXCEPCIONES.MinutoInvalidoException;

/**
 * Representa un evento ocurrido durante un partido de futbol.
 * Un evento es cualquier accion relevante dentro del campo de juego,
 * como un gol, una tarjeta o una sustitucion, y siempre involucra
 * a un unico jugador.
 * @author Florencia Benitez
 * @author Agustina Barreto
 * @author Francia Maira
 * @author Gabriela Yañez
 */
public class Evento {

    /** Tipo de evento ocurrido (GOL, TARJETA_AMARILLA, etc.). */
    private TipoEvento tipo;

    /** Minuto del partido en el que ocurrio el evento. */
    private int minuto;

    /** Jugador involucrado en el evento. */
    private Jugador jugador;

    /**
     * Constructor sin parametros. Inicializa el evento con valores por defecto.
     */
    public Evento() {
        this.tipo = null;
        this.minuto = 0;
        this.jugador = null;
    }

    /**
     * Constructor con parametros.
     *
     * @param tipo    El tipo de evento ocurrido.
     * @param minuto  El minuto del partido en que ocurrio el evento.
     * @param jugador El jugador involucrado en el evento.
     * @throws MinutoInvalidoException Si el minuto es menor a 1 o mayor a 130.
     */
    public Evento(TipoEvento tipo, int minuto, Jugador jugador) throws MinutoInvalidoException {
        if (minuto < 1 || minuto > 130) {
            throw new MinutoInvalidoException("El minuto " + minuto + " no es válido. Debe estar entre 1 y 130.");
        }
        this.tipo = tipo;
        this.minuto = minuto;
        this.jugador = jugador;
    }

    /**
     * Retorna el tipo de evento.
     * @return El tipo de evento.
     */
    public TipoEvento getTipo() {
        return tipo;
    }

    /**
     * Establece el tipo de evento.
     * @param tipo El tipo de evento a asignar.
     */
    public void setTipo(TipoEvento tipo) {
        this.tipo = tipo;
    }

    /**
     * Retorna el minuto en que ocurrio el evento.
     * @return El minuto del evento.
     */
    public int getMinuto() {
        return minuto;
    }

    /**
     * Establece el minuto en que ocurrio el evento.
     * @param minuto El minuto a asignar.
     * @throws MinutoInvalidoException Si el minuto es menor a 1 o mayor a 130.
     */
    public void setMinuto(int minuto) throws MinutoInvalidoException {
        if (minuto < 1 || minuto > 130) {
            throw new MinutoInvalidoException("El minuto " + minuto + " no es válido. Debe estar entre 1 y 130.");
        }
        this.minuto = minuto;
    }

    /**
     * Retorna el jugador involucrado en el evento.
     * @return El jugador del evento.
     */
    public Jugador getJugador() {
        return jugador;
    }

    /**
     * Establece el jugador involucrado en el evento.
     * @param jugador El jugador a asignar.
     */
    public void setJugador(Jugador jugador) {
        this.jugador = jugador;
    }
}