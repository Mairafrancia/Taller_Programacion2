package CLASES;

public class DirectoresTecnicos extends Persona {
    private int fechaNombramiento;

    // CONSTRUCTOR SIN PARAMETROS
    public DirectoresTecnicos() {
        super();
        this.fechaNombramiento = 0;
    }
    // CONSTRUCTOR CON PARAMETROS
    public DirectoresTecnicos(String nombre, int fecNacimiento, int fechaNombramiento) {
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


