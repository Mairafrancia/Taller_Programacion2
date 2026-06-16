package EXCEPCIONES;

/**
 * Se lanza cuando se intenta registrar un evento asociado a un jugador que no participa
 * en el partido donde se desea registrar el evento.
 * @author Florencia Benitez
 * @author Agustina Barreto
 * @author Francia Maira
 * @author Gabriela Yañez
 */
public class JugadorNoParticipaEnPartidoException extends TorneoException {
    
    /**
     * Constructor que especifica el nombre del jugador.
     * @param nombreJugador El nombre del jugador que no participa en el partido.
     */
    public JugadorNoParticipaEnPartidoException(String nombreJugador) {
        super("El jugador '" + nombreJugador + "' no participa en este partido, no se puede registrar eventos.");
    }
}