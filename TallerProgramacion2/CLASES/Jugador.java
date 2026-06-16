package CLASES;

import java.util.ArrayList;

/**
 * Representa a un jugador de futbol que forma parte de una seleccion nacional.
 * Extiende {@link Persona} e incorpora atributos propios del jugador como
 * el dorsal, posicion, peso, altura y la lista de eventos en los que participo.
 * @author Florencia Benitez
 * @author Agustina Barreto
 * @author Francia Maira
 * @author Gabriela Yañez
 */
public class Jugador extends Persona {

    /** Numero de dorsal del jugador en la seleccion. */
    private int dorsal;

    /** Posicion en la que juega habitualmente (arquero, defensor, etc.). */
    private Posicion posicion;

    /** Peso del jugador en kilogramos. */
    private float peso;

    /** Altura del jugador en metros. */
    private float altura;

    /** Lista de eventos en los que participo el jugador durante el torneo. */
    private ArrayList<Evento> eventos;

    /**
     * Constructor sin parametros. Inicializa con valores por defecto.
     */
    public Jugador() {
        super();
        this.dorsal = 0;
        this.posicion = null;
        this.peso = 0;
        this.altura = 0;
        this.eventos = new ArrayList<>();
    }

    /**
     * Constructor con parametros.
     *
     * @param nombre         Nombre completo del jugador.
     * @param fecNacimiento  Fecha de nacimiento en formato YYYYMMDD.
     * @param dorsal         Numero de dorsal del jugador.
     * @param posicion       Posicion en la que juega.
     * @param peso           Peso en kilogramos.
     * @param altura         Altura en metros.
     * @param eventos        Lista inicial de eventos (puede ser null; se inicializa vacia).
     */
    public Jugador(String nombre, int fecNacimiento, int dorsal, Posicion posicion,
                   float peso, float altura, ArrayList<Evento> eventos) {
        super(nombre, fecNacimiento);
        this.dorsal = dorsal;
        this.posicion = posicion;
        this.peso = peso;
        this.altura = altura;
        this.eventos = new ArrayList<>();
    }

    /**
     * Retorna el numero de dorsal del jugador.
     * @return El dorsal.
     */
    public int getDorsal() {
        return dorsal;
    }

    /**
     * Establece el numero de dorsal del jugador.
     * @param dorsal El dorsal a asignar.
     */
    public void setDorsal(int dorsal) {
        this.dorsal = dorsal;
    }

    /**
     * Retorna la posicion del jugador.
     * @return La posicion.
     */
    public Posicion getPosicion() {
        return posicion;
    }

    /**
     * Establece la posicion del jugador.
     * @param posicion La posicion a asignar.
     */
    public void setPosicion(Posicion posicion) {
        this.posicion = posicion;
    }

    /**
     * Retorna el peso del jugador en kilogramos.
     * @return El peso.
     */
    public float getPeso() {
        return peso;
    }

    /**
     * Establece el peso del jugador en kilogramos.
     * @param peso El peso a asignar.
     */
    public void setPeso(float peso) {
        this.peso = peso;
    }

    /**
     * Retorna la altura del jugador en metros.
     * @return La altura.
     */
    public float getAltura() {
        return altura;
    }

    /**
     * Establece la altura del jugador en metros.
     * @param altura La altura a asignar.
     */
    public void setAltura(float altura) {
        this.altura = altura;
    }

    /**
     * Retorna la lista de eventos en los que participo el jugador.
     * @return La lista de eventos.
     */
    public ArrayList<Evento> getEventos() {
        return eventos;
    }

    /**
     * Reemplaza la lista completa de eventos del jugador.
     * @param eventos La nueva lista de eventos.
     */
    public void setEventos(ArrayList<Evento> eventos) {
        this.eventos = eventos;
    }

    /**
     * Agrega un evento a la lista del jugador.
     * No agrega si el evento es null.
     *
     * @param evento El evento a incorporar.
     */
    public void agregarEvento(Evento evento) {
        if (evento != null) {
            this.eventos.add(evento);
        }
    }

    /**
     * Cuenta la cantidad de goles convertidos por el jugador
     * recorriendo su lista de eventos.
     *
     * @return La cantidad de eventos de tipo GOL registrados.
     */
    public int contarGoles() {
        int goles = 0;
        for (Evento e : this.eventos) {
            if (e != null && e.getTipo() == TipoEvento.GOL) {
                goles++;
            }
        }
        return goles;
    }
}