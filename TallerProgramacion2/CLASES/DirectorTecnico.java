package CLASES;

public class DirectorTecnico extends Persona {
    private int fechaNombramiento;

    // CONSTRUCTOR SIN PARAMETROS
    public DirectorTecnico() {
        super();
        this.fechaNombramiento = 0;
    }
    
    // CONSTRUCTOR CON PARAMETROS
    public DirectorTecnico(String nombre, int fecNacimiento, int fechaNombramiento) {
        super(nombre, fecNacimiento);
        this.fechaNombramiento = fechaNombramiento;
    }

    //SETTERS Y GETTERS
    public int getFechaNombramiento() {
        return fechaNombramiento;
    }

    public void setFechaNombramiento(int fechaNombramiento) {
        this.fechaNombramiento = fechaNombramiento;
    }


}


