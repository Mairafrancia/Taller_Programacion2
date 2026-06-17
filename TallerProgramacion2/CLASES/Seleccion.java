package CLASES;

import java.util.ArrayList;

/**
 * Representa la seleccion nacional de futbol de un pais participante
 * del torneo mundial. Contiene informacion sobre la federacion, camisetas,
 * ranking FIFA, y las listas de jugadores, directores tecnicos, cuerpo
 * tecnico y participaciones en partidos.
 * 
 * @author Florencia Benitez
 * @author Agustina Barreto
 * @author Francia Maira
 * @author Gabriela Yañez
 */
public class Seleccion {

    /** Nombre de la federacion nacional (ej: AFA, CBF, FFF). */
    private String nombreFederacion;

    /** Identificador de la camiseta principal de la seleccion. */
    private String camisetaPrincipal;

    /** Identificador de la camiseta secundaria de la seleccion. */
    private String camisetaSecundaria;

    /** Indica si la seleccion es cabeza de grupo en el sorteo. */
    private boolean cabezaGrupo;

    /** Posicion de la seleccion en el ranking FIFA al momento del torneo. */
    private int rankingFIFA;

    /** Grupo de la fase de grupos al que pertenece la seleccion. */
    private Grupo grupo;

    /** Pais al que representa la seleccion. */
    private Pais pais;

    /** Lista de jugadores que integran el plantel de la seleccion. */
    private ArrayList<Jugador> jugadores;

    /** Lista de directores tecnicos de la seleccion. */
    private ArrayList<DirectorTecnico> directoresTecnicos;

    /** Lista de integrantes del cuerpo tecnico (preparadores, medicos, etc.). */
    private ArrayList<CuerpoTecnico> cuerposTecnicos;

    /** Lista de participaciones de la seleccion en los partidos del torneo. */
    private ArrayList<Participacion> participaciones;

    /**
     * Constructor sin parametros. Inicializa con valores por defecto
     * y listas vacias.
     */
    public Seleccion() {
        this.nombreFederacion = "";
        this.camisetaPrincipal = "";
        this.camisetaSecundaria = "";
        this.cabezaGrupo = false;
        this.rankingFIFA = 0;
        this.directoresTecnicos = new ArrayList<>();
        this.jugadores = new ArrayList<>();
        this.cuerposTecnicos = new ArrayList<>();
        this.participaciones = new ArrayList<>();
    }

    /**
     * Constructor con parametros.
     *
     * @param nombreFederacion   Nombre de la federacion nacional.
     * @param camisetaPrincipal  Identificador de la camiseta principal.
     * @param camisetaSecundaria Identificador de la camiseta secundaria.
     * @param cabezaGrupo        True si la seleccion es cabeza de grupo.
     * @param rankingFIFA        Posicion en el ranking FIFA.
     * @param grupo              Grupo de la fase de grupos asignado.
     * @param pais               Pais al que representa la seleccion.
     */
    public Seleccion(String nombreFederacion, String camisetaPrincipal, String camisetaSecundaria,
            boolean cabezaGrupo, int rankingFIFA, Grupo grupo, Pais pais) {
        this.nombreFederacion = nombreFederacion;
        this.camisetaPrincipal = camisetaPrincipal;
        this.camisetaSecundaria = camisetaSecundaria;
        this.cabezaGrupo = cabezaGrupo;
        this.rankingFIFA = rankingFIFA;
        this.grupo = grupo;
        this.pais = pais;
        this.directoresTecnicos = new ArrayList<>();
        this.jugadores = new ArrayList<>();
        this.cuerposTecnicos = new ArrayList<>();
        this.participaciones = new ArrayList<>();
    }

    /** @return El nombre de la federacion. */
    public String getNombreFederacion() {
        return nombreFederacion;
    }

    /** @param nombreFederacion El nombre de la federacion a asignar. */
    public void setNombreFederacion(String nombreFederacion) {
        this.nombreFederacion = nombreFederacion;
    }

    /** @return El identificador de la camiseta principal. */
    public String getCamisetaPrincipal() {
        return camisetaPrincipal;
    }

    /** @param camisetaPrincipal El identificador a asignar. */
    public void setCamisetaPrincipal(String camisetaPrincipal) {
        this.camisetaPrincipal = camisetaPrincipal;
    }

    /** @return El identificador de la camiseta secundaria. */
    public String getCamisetaSecundaria() {
        return camisetaSecundaria;
    }

    /** @param camisetaSecundaria El identificador a asignar. */
    public void setCamisetaSecundaria(String camisetaSecundaria) {
        this.camisetaSecundaria = camisetaSecundaria;
    }

    /** @return True si la seleccion es cabeza de grupo. */
    public boolean isCabezaGrupo() {
        return cabezaGrupo;
    }

    /** @param cabezaGrupo True si es cabeza de grupo. */
    public void setCabezaGrupo(boolean cabezaGrupo) {
        this.cabezaGrupo = cabezaGrupo;
    }

    /** @return La posicion en el ranking FIFA. */
    public int getRankingFIFA() {
        return rankingFIFA;
    }

    /** @param rankingFIFA La posicion en el ranking a asignar. */
    public void setRankingFIFA(int rankingFIFA) {
        this.rankingFIFA = rankingFIFA;
    }

    /** @return El grupo asignado a la seleccion. */
    public Grupo getGrupo() {
        return grupo;
    }

    /** @param grupo El grupo a asignar. */
    public void setGrupo(Grupo grupo) {
        this.grupo = grupo;
    }

    /** @return El pais que representa la seleccion. */
    public Pais getPais() {
        return pais;
    }

    /** @param pais El pais a asignar. */
    public void setPais(Pais pais) {
        this.pais = pais;
    }

    /** @return La lista de jugadores del plantel. */
    public ArrayList<Jugador> getJugadores() {
        return jugadores;
    }

    /** @return La lista de directores tecnicos. */
    public ArrayList<DirectorTecnico> getDirectoresTecnicos() {
        return directoresTecnicos;
    }

    /** @return La lista del cuerpo tecnico. */
    public ArrayList<CuerpoTecnico> getCuerposTecnicos() {
        return cuerposTecnicos;
    }

    /** @return La lista de participaciones en partidos. */
    public ArrayList<Participacion> getParticipaciones() {
        return participaciones;
    }


    /**
     * Agrega un jugador al plantel de la seleccion.
     * No agrega si el jugador es null.
     *
     * @param jugador El jugador a incorporar.
     */
    public void agregarJugador(Jugador jugador) {
        if (jugador != null)
            this.jugadores.add(jugador);
    }

    /**
     * Agrega un integrante al cuerpo tecnico de la seleccion.
     * No agrega si el integrante es null.
     *
     * @param cuerpoTecnico El integrante a incorporar.
     */
    public void agregarCuerpoTecnico(CuerpoTecnico cuerpoTecnico) {
        if (cuerpoTecnico != null)
            this.cuerposTecnicos.add(cuerpoTecnico);
    }

    /**
     * Agrega una participacion a la lista de la seleccion.
     * No agrega si la participacion es null.
     *
     * @param participacion La participacion a incorporar.
     */
    public void agregarParticipacion(Participacion participacion) {
        if (participacion != null)
            this.participaciones.add(participacion);
    }

    /**
     * Agrega un director tecnico a la lista de la seleccion.
     * No agrega si el director es null.
     *
     * @param directorTecnico El director tecnico a incorporar.
     */
    public void agregarDirectoresTecnicos(DirectorTecnico directorTecnico) {
        if (directorTecnico != null)
            this.directoresTecnicos.add(directorTecnico);
    }
}