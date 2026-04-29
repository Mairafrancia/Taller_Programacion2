package MI_TALLER;
import java.util.ArrayList;


public class Arbitro extends Persona {
    private int aniosExperiencia;
    private Pais pais;
    private ArrayList<Arbitraje> arbitrajes = new ArrayList<>();

    //constructor
    public Arbitro(String nombre, int fecNacimiento,Pais pais, int aniosExperiencia) {
        super(nombre, fecNacimiento);
        this.pais = pais;
        this.aniosExperiencia = aniosExperiencia;
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
