package EXCEPCIONES;

/**
 * Se lanza cuando se intenta registrar una selección que ya está vinculada a otro país
 * o que ya ha sido asignada a un grupo.
 * @author Florencia Benitez
 * @author Agustina Barreto
 * @author Francia Maira
 * @author Gabriela Yañez
 */
public class SeleccionYaRegistradaException extends TorneoException {
    
    /**
     * Constructor que especifica el nombre de la selección.
     * @param nombreSeleccion El nombre o identificador de la selección ya registrada.
     */
    public SeleccionYaRegistradaException(String nombreSeleccion) {
        super("La selección '" + nombreSeleccion + "' ya ha sido registrada en el torneo.");
    }
}