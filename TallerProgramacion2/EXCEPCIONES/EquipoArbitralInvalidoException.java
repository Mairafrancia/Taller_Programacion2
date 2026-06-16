package EXCEPCIONES;

/**
 * Se lanza cuando se intenta usar un partido sin haber asignado un equipo arbitral válido.
 * Indica que el partido no cumple con los requisitos de seguridad y validez de competencia.
 */
public class EquipoArbitralInvalidoException extends TorneoException {
    
    /**
     * Constructor sin parámetros adicionales. Utiliza un mensaje de error por defecto.
     */
    public EquipoArbitralInvalidoException() {
        super("Un partido debe tener asignado un equipo de Arbitraje válido (con árbitro y rol).");
    }
}