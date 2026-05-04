package MI_TALLER;
import java.util.ArrayList;

public class Mundial {
    private int anio;
    private String mascota;
    private int fechaDesde;
    private int fechaHasta;
    private ArrayList<Sede> sedes; // new ArrayList<>(); // el mundial agrega varias sedes (clase contenedora en la clase sede(componente) no se hace referencia a mundial)
    
    //constructor por defecto
    public Mundial(){
        this.sedes = new ArrayList<>();
    }
    //constructor parametrizado
    public Mundial(int anio, String mascota, int fechaDesde, int fechaHasta, ArrayList<Sede> sedes) {
        this.anio = anio;
        this.mascota = mascota;
        this.fechaDesde = fechaDesde;
        this.fechaHasta = fechaHasta;
        this.sedes = sedes;
    }

    //metodo agregarSede
    public void agregarSede(Sede sede){
        if (sede != null){
            this.sedes.add(sede);
        }
    }
   
    //metodos get y set
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
}
