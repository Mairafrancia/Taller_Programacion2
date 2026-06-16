package CLASES;

/**
 * Representa al director tecnico de una seleccion nacional.
 * Extiende {@link Persona} e incorpora la fecha en que fue nombrado
 * como director tecnico de la seleccion.
 */
public class DirectoresTecnicos extends Persona {

    /** Fecha en que fue nombrado director tecnico, en formato YYYYMMDD. */
    private int fechaNombramiento;

    /**
     * Constructor sin parametros. Inicializa con valores por defecto.
     */
    public DirectoresTecnicos() {
        super();
        this.fechaNombramiento = 0;
    }

    /**
     * Constructor con parametros.
     *
     * @param nombre             Nombre completo del director tecnico.
     * @param fecNacimiento      Fecha de nacimiento en formato YYYYMMDD.
     * @param fechaNombramiento  Fecha en que fue nombrado DT, en formato YYYYMMDD.
     */
    public DirectoresTecnicos(String nombre, int fecNacimiento, int fechaNombramiento) {
        super(nombre, fecNacimiento);
        this.fechaNombramiento = fechaNombramiento;
    }

    /**
     * Retorna la fecha de nombramiento del director tecnico.
     * @return La fecha de nombramiento en formato YYYYMMDD.
     */
    public int getFechaNombramiento() {
        return fechaNombramiento;
    }

    /**
     * Establece la fecha de nombramiento del director tecnico.
     * @param fechaNombramiento La fecha en formato YYYYMMDD.
     */
    public void setFechaNombramiento(int fechaNombramiento) {
        this.fechaNombramiento = fechaNombramiento;
    }
}