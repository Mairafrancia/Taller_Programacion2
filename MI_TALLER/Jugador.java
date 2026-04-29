package MI_TALLER;
import java.util.ArrayList;
public class Jugador extends Persona{
    private int dorsal;
    private Posicion posicion;
    private float peso;
    private float altura;
    private ArrayList<Evento> eventos = new ArrayList<>(); //un jugador puede tener o no varios eventos

   
    //constructor
    public Jugador(String nombre, int fecNacimiento, int dorsal, Posicion posicion, float peso, float altura) {
        super(nombre, fecNacimiento);
        this.dorsal = dorsal;
        this.posicion = posicion;
        this.peso = peso;
        this.altura = altura;
    }

    //metodo agregar evento
    public void agregarEvento(Evento evento){
        if (evento != null){
            this.eventos.add(evento);
        }
    }

    public int getDorsal() {
        return dorsal;
    }
    public void setDorsal(int dorsal) {
        this.dorsal = dorsal;
    }
    public Posicion getPosicion() {
        return posicion;
    }
    public void setPosicion(Posicion posicion) {
        this.posicion = posicion;
    }
    public float getPeso() {
        return peso;
    }
    public void setPeso(float peso) {
        this.peso = peso;
    }
    public float getAltura() {
        return altura;
    }
    public void setAltura(float altura) {
        this.altura = altura;
    }
     public ArrayList<Evento> getEventos() {
        return eventos;
    }

    public void setEventos(ArrayList<Evento> eventos) {
        this.eventos = eventos;
    }



}