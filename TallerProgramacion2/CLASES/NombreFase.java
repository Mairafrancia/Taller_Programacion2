package CLASES;

/**
 * Representa las distintas fases o etapas del torneo mundial.
 * * NOTA IMPORTANTE: No alterar el orden de las constantes, ya que el ordinal() 
 * se utiliza en la lógica del sistema para determinar la instancia máxima alcanzada.
 */
public enum NombreFase {

    /** Fase inicial de grupos (Ordinal 0). */
    GRUPOS,

    /** Fase de octavos de final (Ordinal 1). */
    OCTAVOS_DE_FINAL,

    /** Fase de cuartos de final (Ordinal 2). */
    CUARTOS_DE_FINAL,

    /** Fase de semifinales (Ordinal 3). */
    SEMIFINAL,

    /** Partido por el tercer puesto del torneo (Ordinal 4). */
    TERCER_PUESTO,

    /** Partido final para definir al campeón (Ordinal 5). */
    FINAL;
}