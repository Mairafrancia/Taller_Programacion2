package CLASES;

public class Evento {
    private TipoEvento tipo;
    private int minuto;

    // ASOCIACIONES
    private Jugador jugador; //un solo jugador esta involucrado a un evento
    
    // CONSTRUCTOR SIN PARAMETROS
    public Evento() {
        this.tipo = null;
        this.minuto = 0;
        this.jugador = null;
    }
    
    // CONSTRUCTOR CON PARAMETROS
    public Evento(TipoEvento tipo, int minuto, Jugador jugador) {
        this.tipo = tipo;
        this.minuto = minuto;
        this.jugador = jugador;
    }
    
    // SETTERS Y GETTERS
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
