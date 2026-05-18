package CLASES;

import java.util.ArrayList;



public class Partido {
    private int fecha;
    private int horario;
    private int duracion;
    private int tiempoAdicional;
    private Participacion[] participaciones = new Participacion[2]; //un array con solo dos participaciones (mejor una lista )
    private Estadio estadio; //un partido se lleva a cabo en un estadio
    private Fase fase; // corresponde a una fase
    private ArrayList<Evento> eventos;
    private ArrayList<Arbitraje> arbitrajes ;

    //constructor por defecto
    public Partido(){
        this.eventos = new ArrayList<>();
        this.arbitrajes = new ArrayList<>();
    }

    //constructor parametrizado
     public Partido(int fecha, int horario, int duracion, int tiempoAdicional, Participacion[] participaciones,
            Estadio estadio, Fase fase, ArrayList<Evento> eventos, ArrayList<Arbitraje> arbitrajes) {
        this.fecha = fecha;
        this.horario = horario;
        this.duracion = duracion;
        this.tiempoAdicional = tiempoAdicional;
        this.participaciones = participaciones;
        this.estadio = estadio;
        this.fase = fase;
        this.eventos = eventos;
        this.arbitrajes = arbitrajes;
    }
   
    
    //metodos para agregar

    public void agregarEvento(Evento evento){
        if (evento != null){
            this.eventos.add(evento);
        }
    }

    public void agregarArbitraje(Arbitraje arbitraje){
        if (arbitraje != null){
            this.arbitrajes.add(arbitraje);
        }
    }
    //Verifica que p1 y p2 no sean null, ni que tengan el mismo valor de esLocal, luego asigna
    public void asignarParticipaciones(Participacion p1, Participacion p2) {
        if (p1 == null || p2 == null) {
            System.out.println("Error: las participaciones no pueden ser null");
            return ;
        }
        if (p1.isEsLocal () == p2.isEsLocal()){
            System.err.println( "Error: una participación debe ser local y la  otra visitante");
            return ;
        }
        this.participaciones[0] = p1;
        this.participaciones[1] = p2;
    }
    
    //Recorre las participaciones del partido y devuelve la del equipo local (esLocal = true)
    // el participaciones[i] != null en el if lo utilizo para evitar un error en caso de que todavía no se hayan asignado las participaciones.
    public Participacion getParticipacionLocal(){
         for (int i = 0; i < participaciones.length; i++){
             if (participaciones[i] != null && participaciones[i].isEsLocal()){
                return participaciones[i];
            }
         }
         return null;
}
    //Recorre las participaciones del partido y devuelve la del equipo visitante (esLocal = false)
        public Participacion getParticipacionVisitante(){
            for (int i = 0; i < participaciones.length; i++){
                 if (participaciones[i] != null && !participaciones[i].isEsLocal()){
                 return participaciones[i];
                 }
            }
             return null;
    }
     //metodos get y set

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
    
}

