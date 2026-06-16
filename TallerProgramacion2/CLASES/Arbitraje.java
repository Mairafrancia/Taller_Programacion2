package CLASES;

/**
 * Representa la asignacion de un arbitro a un partido bajo un rol especifico.
 * Vincula un {@link Arbitro} con un {@link Partido} y define la categoria
 * (rol) que cumple dentro del equipo arbitral.
 * @author Florencia Benitez
 * @author Agustina Barreto
 * @author Francia Maira
 * @author Gabriela Yañez
 */
public class Arbitraje {

    /** Rol que cumple el arbitro en el partido (PRINCIPAL, ASISTENTE_1, etc.). */
    private CategoriaArbitro rol;

    /** Partido en el que se desempena el arbitro. */
    private Partido partido;

    /** Arbitro asignado al partido. */
    private Arbitro arbitro;

    /**
     * Constructor sin parametros. Inicializa con valores por defecto.
     */
    public Arbitraje() {
        this.rol = null;
        this.arbitro = null;
        this.partido = null;
    }

    /**
     * Constructor con parametros.
     *
     * @param rol     Categoria o rol del arbitro en el partido.
     * @param partido Partido al que pertenece este arbitraje.
     * @param arbitro Arbitro asignado.
     */
    public Arbitraje(CategoriaArbitro rol, Partido partido, Arbitro arbitro) {
        this.rol = rol;
        this.partido = partido;
        this.arbitro = arbitro;
    }

    /**
     * Retorna el rol del arbitro en el partido.
     * @return La categoria del arbitro.
     */
    public CategoriaArbitro getRol() {
        return rol;
    }

    /**
     * Establece el rol del arbitro en el partido.
     * @param rol La categoria a asignar.
     */
    public void setRol(CategoriaArbitro rol) {
        this.rol = rol;
    }

    /**
     * Retorna el partido al que pertenece este arbitraje.
     * @return El partido.
     */
    public Partido getPartido() {
        return partido;
    }

    /**
     * Establece el partido al que pertenece este arbitraje.
     * @param partido El partido a asignar.
     */
    public void setPartido(Partido partido) {
        this.partido = partido;
    }

    /**
     * Retorna el arbitro asignado.
     * @return El arbitro.
     */
    public Arbitro getArbitro() {
        return arbitro;
    }

    /**
     * Establece el arbitro asignado.
     * @param arbitro El arbitro a asignar.
     */
    public void setArbitro(Arbitro arbitro) {
        this.arbitro = arbitro;
    }
}