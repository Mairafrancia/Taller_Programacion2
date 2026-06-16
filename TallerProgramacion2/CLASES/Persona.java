package CLASES;

/**
 * Clase abstracta que representa a una persona dentro del sistema.
 * Sirve como base para todas las entidades que tienen nombre y fecha
 * de nacimiento, como jugadores, directores tecnicos, cuerpo tecnico
 * y arbitros.
 * @author Florencia Benitez
 * @author Agustina Barreto
 * @author Francia Maira
 * @author Gabriela Yañez
 */
public abstract class Persona {

    /** Nombre completo de la persona. */
    protected String nombre;

    /** Fecha de nacimiento en formato YYYYMMDD. */
    protected int fecNacimiento;

    /**
     * Constructor sin parametros. Inicializa con valores por defecto.
     */
    public Persona() {
        this.nombre = "";
        this.fecNacimiento = 0;
    }

    /**
     * Constructor con parametros.
     *
     * @param nombre         Nombre completo de la persona.
     * @param fecNacimiento  Fecha de nacimiento en formato YYYYMMDD.
     */
    public Persona(String nombre, int fecNacimiento) {
        this.nombre = nombre;
        this.fecNacimiento = fecNacimiento;
    }

    /**
     * Retorna el nombre de la persona.
     * @return El nombre completo.
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * Establece el nombre de la persona.
     * @param nombre El nombre a asignar.
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * Retorna la fecha de nacimiento de la persona.
     * @return La fecha de nacimiento en formato YYYYMMDD.
     */
    public int getFecNacimiento() {
        return fecNacimiento;
    }

    /**
     * Establece la fecha de nacimiento de la persona.
     * @param fecNacimiento La fecha en formato YYYYMMDD.
     */
    public void setFecNacimiento(int fecNacimiento) {
        this.fecNacimiento = fecNacimiento;
    }
}