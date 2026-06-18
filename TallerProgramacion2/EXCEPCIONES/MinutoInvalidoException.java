package EXCEPCIONES;

/**
 * Se lanza cuando se ingresa un minuto de juego que no es válido 
 * (por ejemplo, números negativos o mayores a lo reglamentario).
 */
public class MinutoInvalidoException extends TorneoException {
    
    public MinutoInvalidoException(String mensaje) {
        super(mensaje);
    }
}