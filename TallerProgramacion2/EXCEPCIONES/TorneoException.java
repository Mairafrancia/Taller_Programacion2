package EXCEPCIONES;

/**
 * Excepción base para todas las excepciones del sistema de gestión del Torneo Mundial.
 * Proporciona una base común para el manejo robusto de errores específicos del dominio.
 */
public class TorneoException extends Exception {
    
    /**
     * Constructor con mensaje personalizado.
     * @param mensaje Descripción del error que ocurrió.
     */
    public TorneoException(String mensaje) {
        super(mensaje);
    }
}
