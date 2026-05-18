package CLASES;

import java.util.ArrayList;

public class Arbitro extends Persona {
    private int aniosExperiencia;
    
    // ASOCIACIONES
    private Pais pais;
    private ArrayList<Arbitraje> arbitrajes;

    // CONSTRUCTOR SIN PARAMETROS
    public Arbitro() {
        super();
        this.aniosExperiencia = 0;
        this.pais = null;
        this.arbitrajes = new ArrayList<>();
    }

    // CONSTRUCTOR PARAMETRIZADO
    public Arbitro(String nombre, int fecNacimiento, int aniosExperiencia, Pais pais, ArrayList<Arbitraje> arbitrajes) {
        super(nombre, fecNacimiento);
        this.aniosExperiencia = aniosExperiencia;
        this.pais = pais;
        if (arbitrajes != null) {
            this.arbitrajes = arbitrajes;
        } else {
            this.arbitrajes = new ArrayList<>();
        }

    }

   // SETTERS Y GETTERS
    public Pais getPais() {
        return pais;
    }

    public void setPais(Pais pais) {
        this.pais = pais;
    }

    public int getAniosExperiencia() {
        return aniosExperiencia;
    }

    public void setAniosExperiencia(int aniosExperiencia) {
        this.aniosExperiencia = aniosExperiencia;
    }

    public ArrayList<Arbitraje> getArbitrajes() {
        return arbitrajes;
    }

    public void setArbitrajes(ArrayList<Arbitraje> arbitrajes) {
        this.arbitrajes = arbitrajes;
    }

    // METODOS

     // metodo agregar arbitraje
    public void agregarArbitraje(Arbitraje arbitraje) {
        if (arbitraje != null) {
            this.arbitrajes.add(arbitraje);
        }
    }

}
