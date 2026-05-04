package taller_programacion2;

public class Evento {
    private TipoEvento tipo;
    private int minuto;
    private Jugador jugador; //un solo jugador esta involucrado a un evento
    
    //constructor por defecto
    public Evento(){

    }
    
    //constructor parametrizado
    public Evento(TipoEvento tipo, int minuto, Jugador jugador) {
        this.tipo = tipo;
        this.minuto = minuto;
        this.jugador = jugador;
    }
    
    //metodos get y set
    public TipoEvento getTipo() {
        return tipo;
    }
    public void setTipo(TipoEvento tipo) {
        this.tipo = tipo;
    }
    public int getMinuto() {
        return minuto;
    }
    public void setMinuto(int minuto) {
        this.minuto = minuto;
    }
    public Jugador getJugador() {
        return jugador;
    }
    public void setJugador(Jugador jugador) {
        this.jugador = jugador;
    }

}
