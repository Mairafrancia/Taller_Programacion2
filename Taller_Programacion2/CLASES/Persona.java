package CLASES;


public abstract class Persona {
    
    protected String nombre;
    protected int fecNacimiento;

    // CONSTRUCTOR SIN PARAMETROS
    public Persona(){
        this.fecNacimiento= 0;
        this.nombre = "";
    }

    // CONSTRUCTOR PARAMETRIZADO
    public Persona(String nombre, int fecNacimiento) {
        this.nombre = nombre;
        this.fecNacimiento = fecNacimiento;
    }

    // SETTERS Y GETTERS
    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public int getFecNacimiento() {
        return fecNacimiento;
    }
    public void setFecNacimiento(int fecNacimiento) {
        this.fecNacimiento = fecNacimiento;
    }


}

