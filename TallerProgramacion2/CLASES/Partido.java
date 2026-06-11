package CLASES;

import java.util.ArrayList;
import EXCEPCIONES.*;

public class Partido {
    private int fecha;
    private int horario;
    private int duracion;
    private int tiempoAdicional;

    //ASOCIACIONES
    private Participacion[] participaciones = new Participacion[2]; // un array con solo dos participaciones (mejor unalista )
    private Estadio estadio; // un partido se lleva a cabo en un estadio
    private Fase fase; // corresponde a una fase
    private ArrayList<Evento> eventos;
    private ArrayList<Arbitraje> arbitrajes;

    //CONSTRUCTOR SIN PARAMETROS
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

    // CONSTRUCTOR CON PARAMETROS
    public Partido(int fecha, int horario, int duracion, int tiempoAdicional,
            Estadio estadio, Fase fase) {
        this.fecha = fecha;
        this.horario = horario;
        this.duracion = duracion;
        this.tiempoAdicional = tiempoAdicional;
        // Nace con el espacio justo y vacío para llenarse con el método
        this.participaciones = new Participacion[2];
        this.estadio = estadio;
        this.fase = fase;
        this.eventos = new ArrayList<>();
        this.arbitrajes = new ArrayList<>();
    }

    //SETETRS Y GETTERS

    public int getFecha() {
        return fecha;
    }

    public void setFecha(int fecha) {
        this.fecha = fecha;
    }

    public int getHorario() {
        return horario;
    }

    public void setHorario(int horario) {
        this.horario = horario;
    }

    public int getDuracion() {
        return duracion;
    }

    public void setDuracion(int duracion) {
        this.duracion = duracion;
    }

    public int getTiempoAdicional() {
        return tiempoAdicional;
    }

    public void setTiempoAdicional(int tiempoAdicional) {
        this.tiempoAdicional = tiempoAdicional;
    }

    public Participacion[] getParticipaciones() {
        return participaciones;
    }

    public void setParticipaciones(Participacion[] participaciones) {
        this.participaciones = participaciones;
    }

    public Estadio getEstadio() {
        return estadio;
    }

    public void setEstadio(Estadio estadio) {
        this.estadio = estadio;
    }

    public Fase getFase() {
        return fase;
    }

    public void setFase(Fase fase) {
        this.fase = fase;
    }

    public ArrayList<Evento> getEventos() {
        return eventos;
    }

    public void setEventos(ArrayList<Evento> eventos) {
        this.eventos = eventos;
    }

    public ArrayList<Arbitraje> getArbitrajes() {
        return arbitrajes;
    }

    public void setArbitrajes(ArrayList<Arbitraje> arbitrajes) {
        this.arbitrajes = arbitrajes;
    }

    //METODOS

    /**
     * Registra un evento en este partido validando que el jugador participe.
     * @param evento El evento a registrar.
     * @throws ValoresNulosException si evento o su jugador es null.
     * @throws JugadorNoParticipaEnPartidoException si el jugador no participa en este partido.
     */
    public void agregarEvento(Evento evento) throws ValoresNulosException, JugadorNoParticipaEnPartidoException {
        if (evento == null || evento.getJugador() == null) {
            throw new ValoresNulosException("evento");
        }
        if (!contieneJugador(evento.getJugador())) {
            throw new JugadorNoParticipaEnPartidoException(evento.getJugador().getNombre());
        }
        this.eventos.add(evento);
    }

    /**
     * Registra un arbitraje en este partido validando que tenga árbitro y rol.
     * @param arbitraje El arbitraje a registrar.
     * @throws ValoresNulosException si arbitraje, su árbitro o rol es null.
     */
    public void agregarArbitraje(Arbitraje arbitraje) throws ValoresNulosException, ArbitrajeInvalidoException {
        if (arbitraje == null || arbitraje.getArbitro() == null || arbitraje.getRol() == null) {
            throw new ArbitrajeInvalidoException();
        }
        this.arbitrajes.add(arbitraje);
    }

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

    // Verifica si un jugador participa en este partido por alguna de las selecciones
    public boolean contieneJugador(Jugador jugador) {
        if (jugador == null) {
            return false;
        }
        for (Participacion p : participaciones) {
            if (p != null && p.getSeleccion() != null && p.getSeleccion().getJugadores() != null) {
                for (Jugador j : p.getSeleccion().getJugadores()) {
                    if (j == jugador) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    /**
     * Asigna dos participaciones al partido (una local, una visitante).
     * @param p1 Primera participación.
     * @param p2 Segunda participación.
     * @throws ValoresNulosException si alguna participación es null.
     * @throws ParticipacionInvalidaException si ambas tienen la misma localía.
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

    // Recorre las participaciones del partido y devuelve la del equipo local
    // (esLocal = true)
    // el participaciones[i] != null en el if lo utilizo para evitar un error en
    // caso de que todavía no se hayan asignado las participaciones.
    public Participacion getParticipacionLocal() {
        for (int i = 0; i < participaciones.length; i++) {
            if (participaciones[i] != null && participaciones[i].isEsLocal()) {
                return participaciones[i];
            }
        }
        return null;
    }

    // Recorre las participaciones del partido y devuelve la del equipo visitante
    // (esLocal = false)
    public Participacion getParticipacionVisitante() {
        for (int i = 0; i < participaciones.length; i++) {
            if (participaciones[i] != null && !participaciones[i].isEsLocal()) {
                return participaciones[i];
            }
        }
        return null;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        Partido otro = (Partido) obj;
        if (fecha != otro.fecha || horario != otro.horario) {
            return false;
        }
        if (estadio != otro.estadio) {
            return false;
        }
        return fase == otro.fase;
    }

    // En Partido.java, agregar este método:
    public void asignarParticipacionesSinExcepcion(Participacion p1, Participacion p2) {
        this.participaciones[0] = p1;
        this.participaciones[1] = p2;
    }

    
}
