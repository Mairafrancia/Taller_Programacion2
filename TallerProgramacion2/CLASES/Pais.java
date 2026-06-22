package CLASES;

import java.util.ArrayList;

/**
 * Representa un pais participante del torneo mundial.
 * Un pais puede tener una o mas sedes, una seleccion nacional
 * y una lista de arbitros de su nacionalidad.
 * @author Florencia Benitez
 * @author Agustina Barreto
 * @author Francia Maira
 * @author Gabriela Yañez
 */
public class Pais {

    /** Nombre del pais. */
    private String nombre;

    /** Identificador o nombre del archivo de la bandera del pais. */
    private String bandera;

    /** Lista de sedes ubicadas en este pais. */
    private ArrayList<Sede> sedes;

    /**
     * Seleccion nacional del pais. Puede ser null si el pais
     * no tiene seleccion registrada en el torneo.
     */
    private Seleccion seleccion;

    /** Lista de arbitros de nacionalidad de este pais. */
    private ArrayList<Arbitro> arbitros;

    /**
     * Constructor sin parametros. Inicializa con valores por defecto.
     */
    public Pais() {
        this.nombre = "";
        this.bandera = "";
        this.sedes = new ArrayList<>();
        this.seleccion = null;
        this.arbitros = new ArrayList<>();
    }

    /**
     * Constructor con parametros.
     *
     * @param nombre    Nombre del pais.
     * @param bandera   Identificador del archivo de la bandera.
     * @param seleccion Seleccion nacional del pais (puede ser null).
     */
    public Pais(String nombre, String bandera, Seleccion seleccion) {
        this.nombre = nombre;
        this.bandera = bandera;
        this.sedes = new ArrayList<>();
        this.seleccion = seleccion;
        this.arbitros = new ArrayList<>();
    }

    /**
     * Retorna el nombre del pais.
     * @return El nombre del pais.
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * Establece el nombre del pais.
     * @param nombre El nombre a asignar.
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * Retorna el identificador de la bandera del pais.
     * @return La bandera del pais.
     */
    public String getBandera() {
        return bandera;
    }

    /**
     * Establece el identificador de la bandera del pais.
     * @param bandera La bandera a asignar.
     */
    public void setBandera(String bandera) {
        this.bandera = bandera;
    }

    /**
     * Retorna la lista de sedes del pais.
     * @return La lista de sedes.
     */
    public ArrayList<Sede> getSedes() {
        return sedes;
    }

    

    /**
     * Retorna la seleccion nacional del pais.
     * @return La seleccion, o null si no tiene.
     */
    public Seleccion getSeleccion() {
        return seleccion;
    }

   
    //
    /**
     * Retorna la lista de arbitros del pais.
     * @return La lista de arbitros.
     */
    public ArrayList<Arbitro> getArbitros() {
        return arbitros;
    }

    //
    /** Establece el identificador de la bandera del pais.
     * @param seleccion. Seleccion a asignar
     */
    public void setSeleccion(Seleccion seleccion){
        this.seleccion = seleccion;
    }




    /**
     * Agrega una sede a la lista del pais.
     * No agrega si la sede es null.
     *
     * @param sede La sede a incorporar.
     */
    public void agregarSede(Sede sede) {
        if (sede != null) {
            this.sedes.add(sede);
        }
    }

    /**
     * Agrega un arbitro a la lista del pais.
     * No agrega si el arbitro es null.
     *
     * @param arbitro El arbitro a incorporar.
     */
    public void agregarArbitro(Arbitro arbitro) {
        if (arbitro != null) {
            this.arbitros.add(arbitro);
        }
    }
}