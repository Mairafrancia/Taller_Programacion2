package CLASES;

import java.util.ArrayList;

public class Seleccion {

    private String nombreFederacion;
    private String camisetaPrincipal;
    private String camisetaSecundaria;
    private boolean cabezaGrupo;
    private int rankingFIFA;

    // ASOCIACIONES
    private Grupo grupo;
    private Pais pais;
    private ArrayList<Jugador> jugadores;
    private DirectorTecnico directorTecnico; // es una lista de agregacion
    private ArrayList<CuerpoTecnico> cuerposTecnicos;
    private ArrayList<Participacion> participaciones; // lista de n participaciones

    // CONSTRUCTOR SIN PARAMETROS
    public Seleccion() {
        this.nombreFederacion = "";
        this.camisetaPrincipal = "";
        this.camisetaSecundaria = "";
        this.cabezaGrupo = false;
        this.rankingFIFA = 0;
        this.pais = null;
        this.grupo = null;
        this.participaciones = new ArrayList<>();
        this.jugadores = new ArrayList<>();
        this.directorTecnico = null;
        this.cuerposTecnicos = new ArrayList<>();
    }

    // CONSTRUCTOR CON PARAMETROS
    public Seleccion(String nombreFederacion, String camisetaPrincipal, String camisetaSecundaria, boolean cabezaGrupo,
            int rankingFIFA, Grupo grupo, Pais pais, ArrayList<Jugador> jugadores, DirectorTecnico directorTecnico,
            ArrayList<CuerpoTecnico> cuerposTecnicos, ArrayList<Participacion> participaciones) {
        this.nombreFederacion = nombreFederacion;
        this.camisetaPrincipal = camisetaPrincipal;
        this.camisetaSecundaria = camisetaSecundaria;
        this.cabezaGrupo = cabezaGrupo;
        this.rankingFIFA = rankingFIFA;
        this.grupo = grupo;
        this.pais = pais;
        this.jugadores = jugadores;
        this.directorTecnico = directorTecnico;
        this.cuerposTecnicos = cuerposTecnicos;
        this.participaciones = participaciones;
    }


    // SETTERS Y GETTERS
    public String getNombreFederacion() {
        return nombreFederacion;
    }

    public void setNombreFederacion(String nombreFederacion) {
        this.nombreFederacion = nombreFederacion;
    }

    public String getCamisetaPrincipal() {
        return camisetaPrincipal;
    }

    public void setCamisetaPrincipal(String camisetaPrincipal) {
        this.camisetaPrincipal = camisetaPrincipal;
    }

    public String getCamisetaSecundaria() {
        return camisetaSecundaria;
    }

    public void setCamisetaSecundaria(String camisetaSecundaria) {
        this.camisetaSecundaria = camisetaSecundaria;
    }

    public boolean isCabezaGrupo() {
        return cabezaGrupo;
    }

    public void setCabezaGrupo(boolean cabezaGrupo) {
        this.cabezaGrupo = cabezaGrupo;
    }

    public int getRankingFIFA() {
        return rankingFIFA;
    }

    public void setRankingFIFA(int rankingFIFA) {
        this.rankingFIFA = rankingFIFA;
    }

    public Grupo getGrupo() {
        return grupo;
    }

    public void setGrupo(Grupo grupo) {
        this.grupo = grupo;
    }

    public Pais getPais() {
        return pais;
    }

    public void setPais(Pais pais) {
        this.pais = pais;
    }

    public ArrayList<Jugador> getJugadores() {
        return jugadores;
    }

    public void setJugadores(ArrayList<Jugador> jugadores) {
        this.jugadores = jugadores;
    }

    public DirectorTecnico getDirectorTecnico() {
        return directorTecnico;
    }

    public void setDirectorTecnico(DirectorTecnico directorTecnico) {
        this.directorTecnico = directorTecnico;
    }

    public ArrayList<CuerpoTecnico> getCuerposTecnicos() {
        return cuerposTecnicos;
    }

    public void setCuerposTecnicos(ArrayList<CuerpoTecnico> cuerposTecnicos) {
        this.cuerposTecnicos = cuerposTecnicos;
    }

    public ArrayList<Participacion> getParticipaciones() {
        return participaciones;
    }

    public void setParticipaciones(ArrayList<Participacion> participaciones) {
        this.participaciones = participaciones;
    }

    // METODOS
    public void agregarJugador(Jugador jugador) {
        if (jugador != null) {
            this.jugadores.add(jugador);
        }
    }

    public void agregarCuerpoTecnico(CuerpoTecnico cuerpoTecnico) {
        if (cuerpoTecnico != null) {
            this.cuerposTecnicos.add(cuerpoTecnico);
        }
    }

    public void agregarParticipacion(Participacion participacion) {
        if (participacion != null) {
            this.participaciones.add(participacion);
        }
    }
}
