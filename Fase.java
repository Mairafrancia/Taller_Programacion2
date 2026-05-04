package MI_TALLER;
import java.util.ArrayList;

public class Fase {
    private NombreFase nombre;
    private ArrayList<Grupo> grupos ;
    private ArrayList<Partido> partidos ;

    //constructor por defecto
    public Fase(){
        this.grupos = new ArrayList<>();
        this.partidos = new ArrayList<>();
    }

    //constructor parametrizado
   
    public Fase(NombreFase nombre, ArrayList<Grupo> grupos, ArrayList<Partido> partidos) {
        this.nombre = nombre;
        this.grupos = grupos;
        this.partidos = partidos;
    }

    //metodos de agregar
    public void agregarGrupo(Grupo grupo){
        if (grupo != null){
            this.grupos.add(grupo);
        }
    }

    public void agregarPartido(Partido partido){
        if(partido != null){
            this.partidos.add(partido);
        }
    }

    //metodos get y set
    public NombreFase getNombre() {
        return nombre;
    }
    public void setNombre(NombreFase nombre) {
        this.nombre = nombre;
    }
    public ArrayList<Grupo> getGrupos() {
        return grupos;
    }
    public void setGrupos(ArrayList<Grupo> grupos) {
        this.grupos = grupos;
    }
    public ArrayList<Partido> getPartidos() {
        return partidos;
    }
    public void setPartidos(ArrayList<Partido> partidos) {
        this.partidos = partidos;
    }


}
