package taller_programacion2;

import java.util.ArrayList;



public class Sede {
    private String ciudad;
    private float alturaNivelMar;
    private String clima;
    private String zonaHoraria;
    private Pais pais; // una sede pertenece a un pais
    private ArrayList<Estadio> estadios; 
    
   //constructor parametrizado
    public Sede(String ciudad, float alturaNivelMar, String clima, String zonaHoraria, Pais pais,
            ArrayList<Estadio> estadios) {
        this.ciudad = ciudad;
        this.alturaNivelMar = alturaNivelMar;
        this.clima = clima;
        this.zonaHoraria = zonaHoraria;
        this.pais = pais;
        this.estadios = estadios;
    }

    //constructor por defecto
    public Sede(){
        this.estadios = new ArrayList<>();
    }

    //----------Metodo agregarEstadio
    public void agregarEstadio(Estadio estadio){
        if (estadio != null){
            this.estadios.add(estadio);
        }
    }

    //----------Metodos get y set
    public String getCiudad() {
        return ciudad;
    }
    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }
    public float getAlturaNivelMar() {
        return alturaNivelMar;
    }
    public void setAlturaNivelMar(float alturaNivelMar) {
        this.alturaNivelMar = alturaNivelMar;
    }
    public String getClima() {
        return clima;
    }
    public void setClima(String clima) {
        this.clima = clima;
    }
    public String getZonaHoraria() {
        return zonaHoraria;
    }
    public void setZonaHoraria(String zonaHoraria) {
        this.zonaHoraria = zonaHoraria;
    }
    public Pais getPais() {
        return pais;
    }
    public void setPais(Pais pais) {
        this.pais = pais;
    }
    public ArrayList<Estadio> getEstadios() {
        return estadios;
    }
    public void setEstadios(ArrayList<Estadio> estadios) {
        this.estadios = estadios;
    }

    
}

