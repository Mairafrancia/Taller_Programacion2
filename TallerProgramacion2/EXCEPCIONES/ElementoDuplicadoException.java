package EXCEPCIONES;

/**
 * Se lanza cuando se intenta registrar un elemento (director técnico, integrante del cuerpo técnico, etc.)
 * que ya existe registrado en la selección.
 */
public class ElementoDuplicadoException extends TorneoException {
    
    /**
     * Constructor que especifica qué elemento está duplicado.
     * @param elemento Descripción del elemento que ya existe registrado.
     */
    public ElementoDuplicadoException(String elemento) {
        super("El elemento '" + elemento + "' ya existe registrado.");
    }
}
