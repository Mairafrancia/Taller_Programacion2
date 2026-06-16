package CLASES;

/**
 * Representa la función o categoría asignada a un árbitro en un partido.
 * @author Florencia Benitez
 * @author Agustina Barreto
 * @author Francia Maira
 * @author Gabriela Yañez
 */
public enum CategoriaArbitro {

    /** Árbitro principal encargado de dirigir el juego en el campo. */
    PRINCIPAL,

    /** Primer árbitro asistente (juez de línea 1). */
    ASISTENTE_1,

    /** Segundo árbitro asistente (juez de línea 2). */
    ASISTENTE_2,

    /** Cuarto árbitro encargado de los cambios y el control fuera de la cancha. */
    CUARTO_ARBITRO,

    /** Árbitro principal a cargo de la cabina del VAR (Video Assistant Referee). */
    VAR_PRINCIPAL,

    /** Árbitro asistente en la cabina del VAR. */
    VAR_ASISTENTE;
}