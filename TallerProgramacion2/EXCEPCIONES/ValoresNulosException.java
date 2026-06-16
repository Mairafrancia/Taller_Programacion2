package EXCEPCIONES;

/**
 * Se lanza cuando se reciben valores null en parámetros donde no son permitidos.
 * Indica un error de validación de entrada.
 * @author Florencia Benitez
 * @author Agustina Barreto
 * @author Francia Maira
 * @author Gabriela Yañez
 */
public class ValoresNulosException extends TorneoException {
    
    /**
     * Constructor que especifica qué campo es nulo.
     * @param campo Descripción del campo o parámetro que es null.
     */
    public ValoresNulosException(String campo) {
        super("Error: " + campo + " no puede ser null.");
    }
}