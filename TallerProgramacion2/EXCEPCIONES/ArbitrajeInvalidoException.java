package EXCEPCIONES;

/**
 * Se lanza cuando se intenta asignar un arbitraje sin árbitro o sin rol definido.
 * Indica que el arbitraje no cumple con los requisitos mínimos de validez.
 * @author Florencia Benitez
 * @author Agustina Barreto
 * @author Francia Maira
 * @author Gabriela Yañez
 */
public class ArbitrajeInvalidoException extends TorneoException {
    
    /**
     * Constructor sin parámetros adicionales. Utiliza un mensaje de error por defecto.
     */
    public ArbitrajeInvalidoException() {
        super("Arbitraje inválido: debe tener asignado un árbitro y un rol.");
    }
}