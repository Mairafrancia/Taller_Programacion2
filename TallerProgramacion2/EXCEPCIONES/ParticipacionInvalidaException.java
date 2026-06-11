package EXCEPCIONES;

/**
 * Se lanza cuando se intenta asignar dos participaciones a un partido con la misma localía,
 * es decir, ambas locales o ambas visitantes, lo que viola la regla de que debe haber
 * exactamente un equipo local y uno visitante.
 */
public class ParticipacionInvalidaException extends TorneoException {
    
    /**
     * Constructor sin parámetros adicionales.
     */
    public ParticipacionInvalidaException() {
        super("Error: una participación debe ser local y la otra visitante.");
    }
    public ParticipacionInvalidaException(String mensaje) {
        super(mensaje);
    }
}
