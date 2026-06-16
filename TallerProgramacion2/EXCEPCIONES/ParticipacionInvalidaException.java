package EXCEPCIONES;

/**
 * Se lanza cuando se intenta asignar dos participaciones a un partido con la misma localía,
 * es decir, ambas locales o ambas visitantes, lo que viola la regla de que debe haber
 * exactamente un equipo local y uno visitante.
 * @author Florencia Benitez
 * @author Agustina Barreto
 * @author Francia Maira
 * @author Gabriela Yañez
 */
public class ParticipacionInvalidaException extends TorneoException {
    
    /**
     * Constructor sin parámetros adicionales. Utiliza un mensaje de error por defecto.
     */
    public ParticipacionInvalidaException() {
        super("Error: una participación debe ser local y la otra visitante.");
    }

    /**
     * Constructor que permite especificar un mensaje de error personalizado.
     * @param mensaje Detalle específico del error de participación.
     */
    public ParticipacionInvalidaException(String mensaje) {
        super(mensaje);
    }
}