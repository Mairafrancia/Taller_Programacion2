package MI_TALLER;

public class DirectorTecnico extends Persona {
    private int fechaNombramiento;
    
    //constructor
    public DirectorTecnico(String nombre, int fecNacimiento, int fechaNombramiento) {
        super(nombre, fecNacimiento);
        this.fechaNombramiento = fechaNombramiento;
    }

    //metodo get y set
    public int getFechaNombramiento() {
        return fechaNombramiento;
    }

    public void setFechaNombramiento(int fechaNombramiento) {
        this.fechaNombramiento = fechaNombramiento;
    }


}
