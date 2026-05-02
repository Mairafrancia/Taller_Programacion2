package MI_TALLER;

public class CuerpoTecnico extends Persona {
    private Rol rol;

    //constructor
    public CuerpoTecnico(String nombre, int fecNacimiento, Rol rol) {
        super(nombre, fecNacimiento);
        this.rol = rol;
    }

    //metodo get y set

    public Rol getRol() {
        return rol;
    }

    public void setRol(Rol rol) {
        this.rol = rol;
    }
    
}
