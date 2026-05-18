package CLASES;

import java.util.ArrayList;

public class Sede {

    private String ciudad;
    private float alturaNivelMar;
    private String clima;
    private String zonaHoraria;

    // ASOCIACIONES
    private Pais pais; // UN PAIS PUEDE TENER MAS DE UNA SEDE
    private ArrayList<Estadio> estadios; // UNA SEDE PUEDE TENER MUCHOS ESTADIOS
    
    // CONSTRUCTOR SIN PARAMETROS
    public Sede() {
        this.ciudad = "";
        this.alturaNivelMar = 0;
        this.clima = "";
        this.zonaHoraria = "";
        this.pais = null;
        this.estadios = new ArrayList<>();
    }

   // CONSTRUCTOR CON PARAMETROS
    public Sede(String ciudad, float alturaNivelMar, String clima, String zonaHoraria, Pais pais,
            ArrayList<Estadio> estadios) {
        this.ciudad = ciudad;
        this.alturaNivelMar = alturaNivelMar;
        this.clima = clima;
        this.zonaHoraria = zonaHoraria;
        this.pais = pais;
        // Si me pasan una lista, la uso; si me pasan null, creo una vacía
        if (estadios != null) {
            this.estadios = estadios;
        } else {
            this.estadios = new ArrayList<>();
        }
    }

    //SETTERS Y GETTERS
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

    //METODOS  

    // agregarEstadio
    public void agregarEstadio(Estadio estadio){
        if (estadio != null){
            this.estadios.add(estadio);
        }
    }
}

