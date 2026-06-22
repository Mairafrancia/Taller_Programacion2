package CLASES;

import java.util.ArrayList;

/**
 * Representa una sede del torneo mundial, es decir, una ciudad
 * donde se disputaran partidos. Cada sede pertenece a un pais
 * y puede contar con uno o mas estadios.
 * @author Florencia Benitez
 * @author Agustina Barreto
 * @author Francia Maira
 * @author Gabriela Yañez
 */
public class Sede {

    /** Nombre de la ciudad donde se ubica la sede. */
    private String ciudad;

    /** Altura de la ciudad sobre el nivel del mar en metros. */
    private float alturaNivelMar;

    /** Descripcion del clima predominante en la ciudad (ej: Templado, Tropical). */
    private String clima;

    /** Zona horaria de la sede en formato GMT (ej: GMT-3, GMT+1). */
    private String zonaHoraria;

    /** Pais al que pertenece la sede. */
    private Pais pais;

    /** Lista de estadios ubicados en esta sede. */
    private ArrayList<Estadio> estadios;

    /**
     * Constructor sin parametros. Inicializa con valores por defecto.
     */
    public Sede() {
        this.ciudad = "";
        this.alturaNivelMar = 0.0f;
        this.clima = "";
        this.zonaHoraria = "";
        this.estadios = new ArrayList<>();
        this.pais = null;
    }

    /**
     * Constructor con parametros.
     *
     * @param ciudad          Nombre de la ciudad.
     * @param alturaNivelMar  Altura sobre el nivel del mar en metros.
     * @param clima           Descripcion del clima predominante.
     * @param zonaHoraria     Zona horaria en formato GMT.
     * @param pais            Pais al que pertenece la sede.
     */
    public Sede(String ciudad, float alturaNivelMar, String clima, String zonaHoraria, Pais pais) {
        this.ciudad = ciudad;
        this.alturaNivelMar = alturaNivelMar;
        this.clima = clima;
        this.zonaHoraria = zonaHoraria;
        this.pais = pais;
        this.estadios = new ArrayList<>();
    }

    /** @return El nombre de la ciudad. */
    public String getCiudad() { return ciudad; }

    /** @param ciudad El nombre de la ciudad a asignar. */
    public void setCiudad(String ciudad) { this.ciudad = ciudad; }

    /** @return La altura sobre el nivel del mar en metros. */
    public float getAlturaNivelMar() { return alturaNivelMar; }

    /** @param alturaNivelMar La altura a asignar. */
    public void setAlturaNivelMar(float alturaNivelMar) { this.alturaNivelMar = alturaNivelMar; }

    /** @return La descripcion del clima. */
    public String getClima() { return clima; }

    /** @param clima El clima a asignar. */
    public void setClima(String clima) { this.clima = clima; }

    /** @return La zona horaria en formato GMT. */
    public String getZonaHoraria() { return zonaHoraria; }

    /** @param zonaHoraria La zona horaria a asignar. */
    public void setZonaHoraria(String zonaHoraria) { this.zonaHoraria = zonaHoraria; }

    /** @return El pais al que pertenece la sede. */
    public Pais getPais() { return pais; }

    /** @param pais El pais a asignar. */
    public void setPais(Pais pais) { this.pais = pais; }

    /** @return La lista de estadios de la sede. */
    public ArrayList<Estadio> getEstadios() { return estadios; }

  

    /**
     * Agrega un estadio a la lista de la sede.
     * No agrega si el estadio es null.
     *
     * @param estadio El estadio a incorporar.
     */
    public void agregarEstadio(Estadio estadio) {
        if (estadio != null) {
            this.estadios.add(estadio);
        }
    }
}