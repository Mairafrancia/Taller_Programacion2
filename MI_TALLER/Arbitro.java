package MI_TALLER;
import java.util.ArrayList;
//jjhjh

public class Arbitro extends Persona {
    private int aniosExperiencia;
    private Pais pais;
    private ArrayList<Arbitraje> arbitrajes;

    public Arbitro(){
        super("", 0);
        this.arbitrajes = new ArrayList<>();
    }

    //constructor parametrizado
   
    
    public Arbitro(String nombre, int fecNacimiento, int aniosExperiencia, Pais pais, ArrayList<Arbitraje> arbitrajes) {
        super(nombre, fecNacimiento);
        this.aniosExperiencia = aniosExperiencia;
        this.pais = pais;
        this.arbitrajes = arbitrajes;
    }

    //metodo agregar arbitraje
    public void agregarArbitraje(Arbitraje arbitraje){
        if (arbitraje != null){
            this.arbitrajes.add(arbitraje);
        }
    }

    //metodos get y set 
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

}
