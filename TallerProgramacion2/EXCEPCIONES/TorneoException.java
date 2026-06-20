package EXCEPCIONES;

/**
 * Clase base de todas las excepciones del sistema de gestion del Mundial.
 * Las excepciones especificas del dominio (jugador duplicado, valores nulos,
 * participacion invalida, etc.) heredan de esta clase para permitir
 * capturarlas todas juntas con un unico catch(TorneoException) o
 * individualmente segun el error que se quiera manejar.
 *
 * @author Florencia Benitez
 * @author Agustina Barreto
 * @author Francia Maira
 * @author Gabriela Yañez
 */
public class TorneoException extends Exception {

    /**
     * Constructor sin parámetros. Utiliza un mensaje de error por defecto.
     */
    public TorneoException() {
        super("Se produjo un error en el sistema de gestion del torneo.");
    }

    /**
     * Constructor con mensaje personalizado.
     * @param mensaje Descripcion del error que ocurrio.
     */
    public TorneoException(String mensaje) {
        super(mensaje);
    }
}