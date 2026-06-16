package CLASES;

/**
 * Representa la posición táctica que ocupa un jugador en el campo de juego.
 * @author Florencia Benitez
 * @author Agustina Barreto
 * @author Francia Maira
 * @author Gabriela Yañez
 */
public enum Posicion {

    /** Portero o guardameta encargado de defender el arco. */
    ARQUERO,

    /** Jugador de la línea defensiva que protege el área propia. */
    DEFENSOR,

    /** Volante o centrocampista encargado de la transición y creación de juego. */
    MEDIOCAMPISTA,

    /** Atacante o punta encargado principalmente de anotar goles. */
    DELANTERO;
}