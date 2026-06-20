package EXCEPCIONES;

/**
 * Se lanza cuando se reciben valores null en parámetros donde no son permitidos.
 * Indica un error de validación de entrada.
 *
 * @author Florencia Benitez
 * @author Agustina Barreto
 * @author Francia Maira
 * @author Gabriela Yañez
 */
public class ValoresNulosException extends TorneoException {

    /**
     * Constructor sin parámetros. Utiliza un mensaje de error por defecto.
     */
    public ValoresNulosException() {
        super("Error: se recibio un valor null en un parametro que no lo permite.");
    }

    /**
     * Constructor que especifica qué campo es nulo.
     * @param campo Descripcion del campo o parametro que es null.
     */
    public ValoresNulosException(String campo) {
        super("Error: " + campo + " no puede ser null.");
    }
}