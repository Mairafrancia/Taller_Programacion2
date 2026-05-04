package taller_programacion2;

import java.util.ArrayList;
public class Jugador extends Persona{
    private int dorsal;
    private Posicion posicion;
    private float peso;
    private float altura;
    private ArrayList<Evento> eventos ; //un jugador puede tener o no varios eventos

   
    //constructor parametrizado
    
    public Jugador(int dorsal, Posicion posicion, float peso, float altura, ArrayList<Evento> eventos) {
            this.dorsal = dorsal;
            this.posicion = posicion;
            this.peso = peso;
            this.altura = altura;
            this.eventos = eventos;
    }
    
    //constructor por defecto
    public Jugador(){
        this.eventos = new ArrayList<>();
    }

    //metodo agregar evento
    public void agregarEvento(Evento evento){
        if (evento != null){
            this.eventos.add(evento);
        }
    }

    //metodos get y set
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

