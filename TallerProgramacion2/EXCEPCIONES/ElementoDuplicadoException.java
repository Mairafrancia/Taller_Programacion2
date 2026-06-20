package EXCEPCIONES;

/**
 * Se lanza cuando se intenta registrar un elemento (director técnico, integrante del cuerpo técnico, etc.)
 * que ya existe registrado en la selección.
 *
 * @author Florencia Benitez
 * @author Agustina Barreto
 * @author Francia Maira
 * @author Gabriela Yañez
 */
public class ElementoDuplicadoException extends TorneoException {

    /**
     * Constructor sin parámetros. Utiliza un mensaje de error por defecto.
     */
    public ElementoDuplicadoException() {
        super("El elemento ya existe registrado en el sistema.");
    }

    /**
     * Constructor que especifica qué elemento está duplicado.
     * @param elemento Descripcion del elemento que ya existe registrado.
     */
    public ElementoDuplicadoException(String elemento) {
        super("El elemento '" + elemento + "' ya existe registrado.");
    }
}