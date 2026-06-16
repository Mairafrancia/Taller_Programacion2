package CLASES;

import java.util.ArrayList;
import EXCEPCIONES.*;

/**
 * Representa un partido de futbol dentro del torneo mundial.
 * Contiene informacion sobre fecha, horario, duracion, el estadio donde
 * se disputa, la fase a la que pertenece, las dos participaciones
 * (local y visitante), los eventos ocurridos y el equipo arbitral asignado.
 * @author Florencia Benitez
 * @author Agustina Barreto
 * @author Francia Maira
 * @author Gabriela Yañez
 */
public class Partido {

    /** Fecha del partido en formato YYYYMMDD. */
    private int fecha;

    /** Horario del partido en formato HHMM (ej: 2000 para las 20:00). */
    private int horario;

    /** Duracion del partido en minutos. */
    private int duracion;

    /** Tiempo adicional jugado en minutos. */
    private int tiempoAdicional;

    /**
     * Array de exactamente dos participaciones: una local (indice 0)
     * y una visitante (indice 1).
     */
    private Participacion[] participaciones = new Participacion[2];

    /** Estadio donde se disputa el partido. */
    private Estadio estadio;

    /** Fase del torneo a la que pertenece este partido. */
    private Fase fase;

    /** Lista de eventos ocurridos durante el partido (goles, tarjetas, etc.). */
    private ArrayList<Evento> eventos;

    /** Lista de arbitrajes asignados al partido. */
    private ArrayList<Arbitraje> arbitrajes;

    /**
     * Constructor sin parametros. Inicializa con valores por defecto.
     */
    public Partido() {
        this.fecha = 0;
        this.horario = 0;
        this.duracion = 0;
        this.tiempoAdicional = 0;
        this.participaciones = new Participacion[2];
        this.estadio = null;
        this.fase = null;
        this.eventos = new ArrayList<>();
        this.arbitrajes = new ArrayList<>();
    }

    /**
     * Constructor con parametros.
     *
     * @param fecha           Fecha del partido en formato YYYYMMDD.
     * @param horario         Horario en formato HHMM.
     * @param duracion        Duracion en minutos.
     * @param tiempoAdicional Tiempo adicional en minutos.
     * @param estadio         Estadio donde se disputara el partido.
     * @param fase            Fase del torneo a la que pertenece.
     */
    public Partido(int fecha, int horario, int duracion, int tiempoAdicional,
                   Estadio estadio, Fase fase) {
        this.fecha = fecha;
        this.horario = horario;
        this.duracion = duracion;
        this.tiempoAdicional = tiempoAdicional;
        this.participaciones = new Participacion[2];
        this.estadio = estadio;
        this.fase = fase;
        this.eventos = new ArrayList<>();
        this.arbitrajes = new ArrayList<>();
    }

    /** @return La fecha del partido en formato YYYYMMDD. */
    public int getFecha() { return fecha; }

    /** @param fecha La fecha a asignar en formato YYYYMMDD. */
    public void setFecha(int fecha) { this.fecha = fecha; }

    /** @return El horario del partido en formato HHMM. */
    public int getHorario() { return horario; }

    /** @param horario El horario a asignar en formato HHMM. */
    public void setHorario(int horario) { this.horario = horario; }

    /** @return La duracion del partido en minutos. */
    public int getDuracion() { return duracion; }

    /** @param duracion La duracion a asignar en minutos. */
    public void setDuracion(int duracion) { this.duracion = duracion; }

    /** @return El tiempo adicional en minutos. */
    public int getTiempoAdicional() { return tiempoAdicional; }

    /** @param tiempoAdicional El tiempo adicional a asignar en minutos. */
    public void setTiempoAdicional(int tiempoAdicional) { this.tiempoAdicional = tiempoAdicional; }

    /** @return El array de participaciones (local en [0], visitante en [1]). */
    public Participacion[] getParticipaciones() { return participaciones; }

    /** @param participaciones El nuevo array de participaciones. */
    public void setParticipaciones(Participacion[] participaciones) { this.participaciones = participaciones; }

    /** @return El estadio donde se disputa el partido. */
    public Estadio getEstadio() { return estadio; }

    /** @param estadio El estadio a asignar. */
    public void setEstadio(Estadio estadio) { this.estadio = estadio; }

    /** @return La fase del torneo a la que pertenece el partido. */
    public Fase getFase() { return fase; }

    /** @param fase La fase a asignar. */
    public void setFase(Fase fase) { this.fase = fase; }

    /** @return La lista de eventos del partido. */
    public ArrayList<Evento> getEventos() { return eventos; }

    /** @param eventos La nueva lista de eventos. */
    public void setEventos(ArrayList<Evento> eventos) { this.eventos = eventos; }

    /** @return La lista de arbitrajes del partido. */
    public ArrayList<Arbitraje> getArbitrajes() { return arbitrajes; }

    /** @param arbitrajes La nueva lista de arbitrajes. */
    public void setArbitrajes(ArrayList<Arbitraje> arbitrajes) { this.arbitrajes = arbitrajes; }

    /**
     * Registra un evento en el partido, validando que el jugador involucrado
     * efectivamente participe en alguna de las dos selecciones del partido.
     *
     * @param evento El evento a registrar.
     * @throws ValoresNulosException                  si el evento o su jugador es null.
     * @throws JugadorNoParticipaEnPartidoException   si el jugador no pertenece a ninguna
     *                                                 de las selecciones del partido.
     */
    public void agregarEvento(Evento evento)
            throws ValoresNulosException, JugadorNoParticipaEnPartidoException {
        if (evento == null || evento.getJugador() == null) {
            throw new ValoresNulosException("evento");
        }
        if (!contieneJugador(evento.getJugador())) {
            throw new JugadorNoParticipaEnPartidoException(evento.getJugador().getNombre());
        }
        this.eventos.add(evento);
    }

    /**
     * Registra un arbitraje en el partido, validando que tenga arbitro y rol asignados.
     *
     * @param arbitraje El arbitraje a registrar.
     * @throws ArbitrajeInvalidoException si el arbitraje, su arbitro o su rol es null.
     */
    public void agregarArbitraje(Arbitraje arbitraje)
            throws ValoresNulosException, ArbitrajeInvalidoException {
        if (arbitraje == null || arbitraje.getArbitro() == null || arbitraje.getRol() == null) {
            throw new ArbitrajeInvalidoException();
        }
        this.arbitrajes.add(arbitraje);
    }

    /**
     * Verifica si el equipo arbitral del partido es valido, es decir,
     * si existe al menos un arbitraje registrado y todos tienen arbitro y rol asignados.
     *
     * @return True si el equipo arbitral es valido, false en caso contrario.
     */
    public boolean tieneEquipoArbitralValido() {
        if (this.arbitrajes == null || this.arbitrajes.isEmpty()) {
            return false;
        }
        for (Arbitraje arbitraje : this.arbitrajes) {
            if (arbitraje == null || arbitraje.getArbitro() == null || arbitraje.getRol() == null) {
                return false;
            }
        }
        return true;
    }

    /**
     * Verifica si un jugador participa en este partido a traves de
     * alguna de las dos selecciones (local o visitante).
     *
     * @param jugador El jugador a buscar.
     * @return True si el jugador pertenece a alguna de las selecciones del partido.
     */
    public boolean contieneJugador(Jugador jugador) {
        if (jugador == null) return false;
        for (Participacion p : participaciones) {
            if (p != null && p.getSeleccion() != null && p.getSeleccion().getJugadores() != null) {
                for (Jugador j : p.getSeleccion().getJugadores()) {
                    if (j == jugador) return true;
                }
            }
        }
        return false;
    }

    /**
     * Asigna las dos participaciones al partido validando que una sea local
     * y la otra visitante.
     *
     * @param p1 Primera participacion.
     * @param p2 Segunda participacion.
     * @throws ValoresNulosException          si alguna participacion es null.
     * @throws ParticipacionInvalidaException si ambas tienen la misma localidad.
     */
    public void asignarParticipaciones(Participacion p1, Participacion p2)
            throws ValoresNulosException, ParticipacionInvalidaException {
        if (p1 == null || p2 == null) {
            throw new ValoresNulosException("participaciones");
        }
        if (p1.isEsLocal() == p2.isEsLocal()) {
            throw new ParticipacionInvalidaException();
        }
        this.participaciones[0] = p1;
        this.participaciones[1] = p2;
    }

    /**
     * Retorna la participacion del equipo local recorriendo el array
     * de participaciones y buscando la que tiene {@code esLocal = true}.
     *
     * @return La participacion local, o null si aun no fue asignada.
     */
    public Participacion getParticipacionLocal() {
        for (int i = 0; i < participaciones.length; i++) {
            if (participaciones[i] != null && participaciones[i].isEsLocal()) {
                return participaciones[i];
            }
        }
        return null;
    }

    /**
     * Retorna la participacion del equipo visitante recorriendo el array
     * de participaciones y buscando la que tiene {@code esLocal = false}.
     *
     * @return La participacion visitante, o null si aun no fue asignada.
     */
    public Participacion getParticipacionVisitante() {
        for (int i = 0; i < participaciones.length; i++) {
            if (participaciones[i] != null && !participaciones[i].isEsLocal()) {
                return participaciones[i];
            }
        }
        return null;
    }

    /**
     * Asigna las participaciones directamente sin validaciones.
     * Usado internamente por el {@code CargadorDatos} para inicializar
     * partidos de manera eficiente.
     *
     * @param p1 Participacion local.
     * @param p2 Participacion visitante.
     */
    public void asignarParticipacionesSinExcepcion(Participacion p1, Participacion p2) {
        this.participaciones[0] = p1;
        this.participaciones[1] = p2;
    }

    /**
     * Dos partidos son iguales si tienen la misma fecha, horario,
     * estadio y fase.
     *
     * @param obj El objeto a comparar.
     * @return True si los partidos son iguales segun los criterios indicados.
     */
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Partido otro = (Partido) obj;
        if (fecha != otro.fecha || horario != otro.horario) return false;
        if (estadio != otro.estadio) return false;
        return fase == otro.fase;
    }
}