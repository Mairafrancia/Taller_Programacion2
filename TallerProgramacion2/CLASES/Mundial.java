package CLASES;

import java.util.ArrayList;

//import EXCEPCIONES.PeriodoInvalidoException;

/**
 * Representa la entidad principal de un torneo mundial de fútbol.
 * Actúa como clase contenedora que gestiona el año, la mascota, el período
 * de fechas y las listas de sedes y fases que componen el torneo.
 * @author Florencia Benitez
 * @author Agustina Barreto
 * @author Francia Maira
 * @author Gabriela Yañez
 */
public class Mundial {

    /** Año de celebración del mundial. */
    private int anio;

    /** Nombre de la mascota oficial del torneo. */
    private String mascota;

    /** Fecha de inicio del torneo (representada en formato numérico YYYYMMDD o similar). */
    private int fechaDesde;

    /** Fecha de finalización del torneo (representada en formato numérico YYYYMMDD o similar). */
    private int fechaHasta;

    /** * Lista de sedes asociadas al mundial. 
     * El mundial actúa como contenedor en una relación de agregación; 
     * la clase Sede no mantiene referencia inversa a Mundial.
     */
    private ArrayList<Sede> sedes;

    /** Lista de las fases competitivas que componen el desarrollo del torneo. */
    private ArrayList<Fase> fases;

    /**
     * Constructor sin parámetros. Inicializa los atributos numéricos en cero,
     * las cadenas vacías y las listas de sedes y fases como colecciones vacías.
     */
    public Mundial() {
        this.anio = 0;
        this.mascota = "";
        this.fechaDesde = 0;
        this.fechaHasta = 0;
        this.sedes = new ArrayList<>();
        this.fases = new ArrayList<>();
    }

    /**
     * Constructor con parámetros.
     * Inicializa las listas de sedes y fases vacías para separar la lógica de creación 
     * de la lógica de asignación progresiva de elementos al mundial.
     *
     * @param anio       Año de celebración del mundial.
     * @param mascota    Nombre de la mascota oficial.
     * @param fechaDesde Fecha de inicio del torneo.
     * @param fechaHasta Fecha de finalización del torneo.
     */
    public Mundial(int anio, String mascota, int fechaDesde, int fechaHasta) {
        this.anio = anio;
        this.mascota = mascota;
        this.fechaDesde = fechaDesde;
        this.fechaHasta = fechaHasta;
        this.sedes = new ArrayList<>(); 
        this.fases = new ArrayList<>();
    }

    /**
     * Retorna el año de celebración del mundial.
     * @return El año del torneo.
     */
    public int getAnio() {
        return anio;
    }

    /**
     * Establece el año de celebración del mundial.
     * @param anio El año a asignar.
     */
    public void setAnio(int anio) {
        this.anio = anio;
    }

    /**
     * Retorna el nombre de la mascota oficial del mundial.
     * @return El nombre de la mascota.
     */
    public String getMascota() {
        return mascota;
    }

    /**
     * Establece el nombre de la mascota oficial del mundial.
     * @param mascota El nombre de la mascota a asignar.
     */
    public void setMascota(String mascota) {
        this.mascota = mascota;
    }

    /**
     * Retorna la fecha de inicio del mundial.
     * @return La fecha de inicio.
     */
    public int getFechaDesde() {
        return fechaDesde;
    }

    /**
     * Establece la fecha de inicio del mundial.
     * @param fechaDesde La fecha de inicio a asignar.
     */
    public void setFechaDesde(int fechaDesde) //throws PeriodoInvalidoException
    {
    //     if (fechaDesde > this.fechaHasta) {
    //     throw new PeriodoInvalidoException("La fecha de inicializacion no puede ser mayor a la de finalizacion.");
    // }
        this.fechaDesde = fechaDesde;
    }

    /**
     * Retorna la fecha de finalización del mundial.
     * @return La fecha de finalización.
     */
    public int getFechaHasta() {
        return fechaHasta;
    }

    /**
     * Establece la fecha de finalización del mundial.
     * @param fechaHasta La fecha de finalización a asignar.
     */
    public void setFechaHasta(int fechaHasta) //throws PeriodoInvalidoException
    {
        // if (fechaHasta < this.fechaDesde) {
        //     throw new PeriodoInvalidoException("La fecha de finalización no puede ser anterior a la de inicio.");
        // }
        this.fechaHasta = fechaHasta;
    }

    /**
     * Retorna la lista de sedes donde se disputa el mundial.
     * @return Lista con las sedes del torneo.
     */
    public ArrayList<Sede> getSedes() {
        return sedes;
    }

    /**
     * Retorna la lista de fases del torneo.
     * @return Lista con las fases de la competición.
     */
    public ArrayList<Fase> getFases() { 
        return fases; 
    }

    /**
     * Agrega una sede a la lista del mundial.
     * No realiza la acción si el objeto provisto es null.
     *
     * @param sede La sede a incorporar al torneo.
     */
    public void agregarSede(Sede sede) {
        if (sede != null) {
            this.sedes.add(sede);
        }
    }

    /**
     * Agrega una fase a la lista del mundial.
     * No realiza la acción si el objeto provisto es null.
     *
     * @param fase La fase a incorporar al torneo.
     */
    public void agregarFase(Fase fase) {
        if (fase != null) {
            this.fases.add(fase);
        }
    }
}