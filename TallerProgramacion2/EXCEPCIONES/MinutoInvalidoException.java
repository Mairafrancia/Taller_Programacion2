package EXCEPCIONES;

/**
 * Se lanza cuando se ingresa un minuto de juego que no es válido,
 * por ejemplo números negativos o mayores al tiempo reglamentario (130 minutos).
 *
 * @author Florencia Benitez
 * @author Agustina Barreto
 * @author Francia Maira
 * @author Gabriela Yañez
 */
public class MinutoInvalidoException extends TorneoException {

    /**
     * Constructor sin parámetros. Utiliza un mensaje de error por defecto.
     */
    public MinutoInvalidoException() {
        super("El minuto ingresado no es valido. Debe estar entre 1 y 130.");
    }

    /**
     * Constructor con mensaje personalizado.
     * @param mensaje Detalle especifico del error de minuto.
     */
    public MinutoInvalidoException(String mensaje) {
        super(mensaje);
    }
}