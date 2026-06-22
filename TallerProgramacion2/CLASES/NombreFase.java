package CLASES;

/**
 * Representa las distintas fases o etapas del torneo mundial,
 * según el diagrama de clases de la consigna.
 * <p>
 * Nota importante: no alterar el orden de las constantes. El ordinal()
 * se usa en TablaDeResultadosPorSeleccion para determinar la instancia
 * maxima alcanzada por una seleccion (mayor ordinal = fase más avanzada).
 *
 * @author Florencia Benitez
 * @author Agustina Barreto
 * @author Francia Maira
 * @author Gabriela Yañez
 */
public enum NombreFase {

    /** Fase inicial de grupos (Ordinal 0). */
    GRUPOS,

    /** Fase de dieciséisavos de final (Ordinal 1). */
    DIECISEISAVOS,

    /** Fase de octavos de final (Ordinal 2). */
    OCTAVOS,

    /** Fase de cuartos de final (Ordinal 3). */
    CUARTOS,

    /** Fase de semifinales (Ordinal 4). */
    SEMIFINAL,

    /** Partido final para definir al campeón (Ordinal 5). */
    FINAL;
}