package EXCEPCIONES;

/**
 * Se lanza cuando se intenta asignar un arbitraje sin árbitro o sin rol definido.
 * Indica que el arbitraje no cumple con los requisitos mínimos de validez.
 */
public class ArbitrajeInvalidoException extends TorneoException {
    
    /**
     * Constructor sin parámetros adicionales.
     */
    public ArbitrajeInvalidoException() {
        super("Arbitraje inválido: debe tener asignado un árbitro y un rol.");
    }
}
