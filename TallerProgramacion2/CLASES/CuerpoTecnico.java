package CLASES;

/**
 * Representa a un integrante del cuerpo tecnico de una seleccion nacional,
 * distinto del director tecnico. Puede cumplir distintos roles como
 * ayudante de campo, preparador fisico, medico, entre otros.
 * Extiende {@link Persona}.
 * @author Florencia Benitez
 * @author Agustina Barreto
 * @author Francia Maira
 * @author Gabriela Yañez
 */
public class CuerpoTecnico extends Persona {

    /** Rol que cumple el integrante dentro del cuerpo tecnico. */
    private Rol rol;

    /**
     * Constructor sin parametros. Inicializa con valores por defecto.
     */
    public CuerpoTecnico() {
        this.rol = null;
    }

    /**
     * Constructor con parametros.
     *
     * @param nombre         Nombre completo del integrante.
     * @param fecNacimiento  Fecha de nacimiento en formato YYYYMMDD.
     * @param rol            Rol que cumple dentro del cuerpo tecnico.
     */
    public CuerpoTecnico(String nombre, int fecNacimiento, Rol rol) {
        super(nombre, fecNacimiento);
        this.rol = rol;
    }

    /**
     * Retorna el rol del integrante en el cuerpo tecnico.
     * @return El rol asignado.
     */
    public Rol getRol() {
        return rol;
    }

    /**
     * Establece el rol del integrante en el cuerpo tecnico.
     * @param rol El rol a asignar.
     */
    public void setRol(Rol rol) {
        this.rol = rol;
    }
}