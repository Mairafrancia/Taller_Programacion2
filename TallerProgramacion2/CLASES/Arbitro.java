package CLASES;

import java.util.ArrayList;

/**
 * Representa a un arbitro que puede oficiar partidos del torneo.
 * Extiende {@link Persona} e incorpora los anos de experiencia,
 * el pais de origen y la lista de arbitrajes que ha realizado.
 */
public class Arbitro extends Persona {

    /** Anos de experiencia del arbitro en competencias oficiales. */
    private int aniosExperiencia;

    /** Pais de origen o nacionalidad del arbitro. */
    private Pais pais;

    /** Lista de arbitrajes realizados por este arbitro en el torneo. */
    private ArrayList<Arbitraje> arbitrajes;

    /**
     * Constructor sin parametros. Inicializa con valores por defecto.
     */
    public Arbitro() {
        super();
        this.aniosExperiencia = 0;
        this.pais = null;
        this.arbitrajes = new ArrayList<>();
    }

    /**
     * Constructor con parametros.
     *
     * @param nombre            Nombre completo del arbitro.
     * @param fecNacimiento     Fecha de nacimiento en formato YYYYMMDD.
     * @param aniosExperiencia  Anos de experiencia en competencias oficiales.
     * @param pais              Pais de origen del arbitro.
     */
    public Arbitro(String nombre, int fecNacimiento, int aniosExperiencia, Pais pais) {
        super(nombre, fecNacimiento);
        this.aniosExperiencia = aniosExperiencia;
        this.pais = pais;
        this.arbitrajes = new ArrayList<>();
    }

    /**
     * Retorna el pais de origen del arbitro.
     * @return El pais del arbitro.
     */
    public Pais getPais() {
        return pais;
    }

    /**
     * Establece el pais de origen del arbitro.
     * @param pais El pais a asignar.
     */
    public void setPais(Pais pais) {
        this.pais = pais;
    }

    /**
     * Retorna los anos de experiencia del arbitro.
     * @return Los anos de experiencia.
     */
    public int getAniosExperiencia() {
        return aniosExperiencia;
    }

    /**
     * Establece los anos de experiencia del arbitro.
     * @param aniosExperiencia Los anos de experiencia a asignar.
     */
    public void setAniosExperiencia(int aniosExperiencia) {
        this.aniosExperiencia = aniosExperiencia;
    }

    /**
     * Retorna la lista de arbitrajes realizados por este arbitro.
     * @return La lista de arbitrajes.
     */
    public ArrayList<Arbitraje> getArbitrajes() {
        return arbitrajes;
    }

    /**
     * Reemplaza la lista completa de arbitrajes del arbitro.
     * @param arbitrajes La nueva lista de arbitrajes.
     */
    public void setArbitrajes(ArrayList<Arbitraje> arbitrajes) {
        this.arbitrajes = arbitrajes;
    }

    /**
     * Agrega un arbitraje a la lista del arbitro.
     * No agrega si el arbitraje es null.
     *
     * @param arbitraje El arbitraje a incorporar.
     */
    public void agregarArbitraje(Arbitraje arbitraje) {
        if (arbitraje != null) {
            this.arbitrajes.add(arbitraje);
        }
    }
}