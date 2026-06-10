package CLASES;

import java.util.ArrayList;

public class Mundial {
    private int anio;
    private String mascota;
    private int fechaDesde;
    private int fechaHasta;
    private ArrayList<Sede> sedes; // new ArrayList<>(); // el mundial agrega varias sedes (clase contenedora en la
  // clase sede(componente) no se hace referencia a mundial)
    private ArrayList<Fase> fases;

    //CONSTRUCTOR SIN PARAMETROS
    public Mundial() {
        this.anio = 0;
        this.mascota = "";
        this.fechaDesde = 0;
        this.fechaHasta = 0;
        this.sedes = new ArrayList<>();
        this.fases = new ArrayList<>();
    }

    // CONSTRUCTOR CON PARAMETROS
    public Mundial(int anio, String mascota, int fechaDesde, int fechaHasta) {
        this.anio = anio;
        this.mascota = mascota;
        this.fechaDesde = fechaDesde;
        this.fechaHasta = fechaHasta;
        this.sedes = new ArrayList<>(); // LA CREAMOS VACIA Y USAMOS EL METODO PARA LLENARLA, ASI SEPARA LA LOGICA DE CREACION DE LA LOGICA DE AGREGAR SEDES AL MUNDIAL
        this.fases = new ArrayList<>();
    }

    // SETTERS Y GETTERS
    public int getAnio() {
        return anio;
    }

    public void setAnio(int anio) {
        this.anio = anio;
    }

    public String getMascota() {
        return mascota;
    }

    public void setMascota(String mascota) {
        this.mascota = mascota;
    }

    public int getFechaDesde() {
        return fechaDesde;
    }

    public void setFechaDesde(int fechaDesde) {
        this.fechaDesde = fechaDesde;
    }

    public int getFechaHasta() {
        return fechaHasta;
    }

    public void setFechaHasta(int fechaHasta) {
        this.fechaHasta = fechaHasta;
    }

    public ArrayList<Sede> getSedes() {
        return sedes;
    }

    public void setSedes(ArrayList<Sede> sedes) {
        this.sedes = sedes;
    }

    // METODOS
    public void agregarSede(Sede sede) {
        if (sede != null) {
            this.sedes.add(sede);
        }
    }
    public void agregarFase(Fase fase) {
        if (fase != null) this.fases.add(fase);
    }

    public ArrayList<Fase> getFases() { return fases; }
    public void setFases(ArrayList<Fase> fases) { this.fases = fases; }
    
}
