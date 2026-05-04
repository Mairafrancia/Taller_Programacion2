package MI_TALLER;
import java.util.ArrayList;

public class Seleccion {
    private String nombreFederacion;
    private String camisetaPrincipal;
    private String camisetaSecundaria;
    private boolean cabezaGrupo;
    private int rankingFIFA;
    private Grupo grupo;
    private Pais pais;
    private ArrayList<Jugador> jugadores ;
    private DirectorTecnico directorTecnico; 
    private ArrayList<CuerpoTecnico> cuerposTecnicos ;
    private ArrayList<Participacion> participaciones; //lista de n participaciones

   
    //constructor por defecto(){
    public Seleccion(){
        this.jugadores = new ArrayList<>();
        this.cuerposTecnicos = new ArrayList<>();
        this.participaciones = new ArrayList<>();
    }
   
    //constructor parametrizado
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

    //metodos de agregar
    public void agregarJugador(Jugador jugador){
        if (jugador != null){
            this.jugadores.add(jugador);
        }
    }

    public void agregarCuerpoTecnico(CuerpoTecnico cuerpoTecnico){
        if (cuerpoTecnico != null){
            this.cuerposTecnicos.add(cuerpoTecnico);
        }
    }

    public void agregarParticipacion(Participacion participacion){
        if (participacion != null){
            this.participaciones.add(participacion);
        }
    }

    //metodos get y set
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


}
