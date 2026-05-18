package CLASES;

public class CuerpoTecnico extends Persona {
    
    private Rol rol;

    // CONSTRUCTOR SIN PARAMETROS
    public CuerpoTecnico() {
        this.rol = null;
    }

    // CONSTRUCTOR PARAMETRIZADO
    public CuerpoTecnico(String nombre, int fecNacimiento, Rol rol) {
        super(nombre, fecNacimiento);
        this.rol = rol;
    }

    // SETTERS Y GETTERS
    public Rol getRol() {
        return rol;
    }

    public void setRol(Rol rol) {
        this.rol = rol;
    }

}
