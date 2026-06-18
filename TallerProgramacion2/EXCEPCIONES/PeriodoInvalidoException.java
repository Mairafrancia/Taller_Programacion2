package EXCEPCIONES;

/**
 * Se lanza cuando se intenta registrar un evento asociado a un jugador que no participa
 * en el partido donde se desea registrar el evento.
 * @author Florencia Benitez
 * @author Agustina Barreto
 * @author Francia Maira
 * @author Gabriela Yañez
 */
public class PeriodoInvalidoException extends TorneoException {
    
    /**
     * Constructor que especifica el nombre del jugador.
     */
    
    
    public PeriodoInvalidoException(String mensaje) {
        super(mensaje);
    }
}