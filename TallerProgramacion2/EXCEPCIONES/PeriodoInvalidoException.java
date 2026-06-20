package EXCEPCIONES;

/**
 * Se lanza cuando el periodo de fechas configurado para el Mundial es inválido,
 * por ejemplo si la fecha de inicio es posterior a la de finalización,
 * o si las fechas no corresponden al año del torneo.
 *
 * @author Florencia Benitez
 * @author Agustina Barreto
 * @author Francia Maira
 * @author Gabriela Yañez
 */
public class PeriodoInvalidoException extends TorneoException {

    /**
     * Constructor con mensaje por defecto.
     */
    public PeriodoInvalidoException() {
        super("El periodo del Mundial es invalido: verifique que la fecha de inicio sea anterior a la de finalizacion.");
    }

    /**
     * Constructor con mensaje personalizado.
     * @param mensaje Detalle específico del error de periodo.
     */
    public PeriodoInvalidoException(String mensaje) {
        super(mensaje);
    }
}