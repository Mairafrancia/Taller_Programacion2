package EXCEPCIONES;

/**
 * Se lanza cuando se intenta registrar un jugador que ya ha sido asignado a otra selección
 * del torneo, violando la regla de unicidad global de jugadores.
 *
 * @author Florencia Benitez
 * @author Agustina Barreto
 * @author Francia Maira
 * @author Gabriela Yañez
 */
public class JugadorDuplicadoException extends TorneoException {

    /**
     * Constructor sin parámetros. Utiliza un mensaje de error por defecto.
     */
    public JugadorDuplicadoException() {
        super("El jugador ya ha sido asignado a otra seleccion del torneo.");
    }

    /**
     * Constructor que especifica el nombre del jugador duplicado.
     * @param nombre El nombre del jugador que se intenta registrar duplicadamente.
     */
    public JugadorDuplicadoException(String nombre) {
        super("El jugador '" + nombre + "' ya ha sido asignado a otra seleccion del torneo.");
    }
}