package MI_TALLER;
import java.util.ArrayList;

public class Estadio {
    private String nombre;
    private int capacidad;
    private Sede sede; // un estadio pertenece a una sede
    private ArrayList<Partido> partidos = new ArrayList<>(); //lista de partidos que tiene ese estadio
    //constructor
    public Estadio(String nombre, int capacidad, Sede sede) {
        this.nombre = nombre;
        this.capacidad = capacidad;
        this.sede = sede;
    }

    //metodo agregarPartido
    public void agregarPartido(Partido partido){
        if (partido != null){
            this.partidos.add(partido);
        }
    }

    //metodos get y set

    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public int getCapacidad() {
        return capacidad;
    }
    public void setCapacidad(int capacidad) {
        this.capacidad = capacidad;
    }
    public Sede getSede() {
        return sede;
    }
    public void setSede(Sede sede) {
        this.sede = sede;
    }
    public ArrayList<Partido> getPartidos() {
        return partidos;
    }
    public void setPartidos(ArrayList<Partido> partidos) {
        this.partidos = partidos;
    }
    
}
