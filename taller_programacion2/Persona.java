package taller_programacion2;


public abstract class Persona {
    protected String nombre;
    protected int fecNacimiento;

    public Persona(){
        this.fecNacimiento= 0;
        this.nombre = "";
    }

    public Persona(String nombre, int fecNacimiento) {
        this.nombre = nombre;
        this.fecNacimiento = fecNacimiento;
    }


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

