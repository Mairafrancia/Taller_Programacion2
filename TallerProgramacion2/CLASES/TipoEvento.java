package CLASES;

/**
 * Representa los diferentes tipos de eventos que pueden ocurrir durante un partido.
 * @author Florencia Benitez
 * @author Agustina Barreto
 * @author Francia Maira
 * @author Gabriela Yañez
 */
public enum TipoEvento {

    /** Gol anotado por un jugador. */
    GOL,

    /** Amonestación con tarjeta amarilla. */
    TARJETA_AMARILLA,

    /** Expulsión directa con tarjeta roja. */
    TARJETA_ROJA,

    /** Infracción que sanciona un penal en contra. */
    PENAL_COMETIDO,

    /** Gol anotado mediante la ejecución de un penal. */
    PENAL_CONVERTIDO,

    /** Penal ejecutado que no terminó en gol. */
    PENAL_ERRADO,

    /** Expulsión por acumulación de dos tarjetas amarillas. */
    DOBLE_AMARILLA,

    /** Cambio o sustitución de un jugador por otro. */
    SUSTITUCION,

    /** Lesión sufrida por un jugador en el campo de juego. */
    LESION;
}