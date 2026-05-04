package MI_TALLER;
import java.util.ArrayList;


public class Pais{
    private String nombre;
    private String bandera;
    private ArrayList<Sede> sedes; //un pais tiene muchas sedes
    private Seleccion seleccion; //puede tener o no una seleccion
    private ArrayList<Arbitro> arbitros;
    
    //constructor parametrizado

    public Pais(String nombre, String bandera, ArrayList<Sede> sedes, Seleccion seleccion,
            ArrayList<Arbitro> arbitros) {
        this.nombre = nombre;
        this.bandera = bandera;
        this.sedes = sedes;
        this.seleccion = seleccion;
        this.arbitros = arbitros;
    }

    //constructor por defecto
    public Pais(){
        this.sedes = new ArrayList<>();
        this.arbitros = new ArrayList<>();
    }
   
    //metodo agregarSede
    public void agregarSede(Sede sede){
        if (sede != null){
            this.sedes.add(sede);
        }
    }
    //metodo agregarArbitro
    public void agregarArbitro(Arbitro arbitro){
        if (arbitro != null){
            this.arbitros.add(arbitro);
        }
    }
    //metodos get y set
    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public String getBandera() {
        return bandera;
    }
    public void setBandera(String bandera) {
        this.bandera = bandera;
    }
    public ArrayList<Sede> getSedes() {
        return sedes;
    }
    public void setSedes(ArrayList<Sede> sedes) {
        this.sedes = sedes;
    }
    public Seleccion getSeleccion() {
        return seleccion;
    }
    public void setSeleccion(Seleccion seleccion) {
        this.seleccion = seleccion;
    }
    public ArrayList<Arbitro> getArbitros() {
        return arbitros;
    }
    public void setArbitros(ArrayList<Arbitro> arbitros) {
        this.arbitros = arbitros;
    }
    


}