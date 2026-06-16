package EXCEPCIONES;

/**
 * Se lanza cuando se intenta registrar un elemento (director técnico, integrante del cuerpo técnico, etc.)
 * que ya existe registrado en la selección.
 * @author Florencia Benitez
 * @author Agustina Barreto
 * @author Francia Maira
 * @author Gabriela Yañez
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