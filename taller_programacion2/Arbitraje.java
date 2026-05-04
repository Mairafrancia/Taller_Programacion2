package taller_programacion2;


public class Arbitraje {
    private CategoriaArbitro rol;
    private Partido partido;
    private Arbitro arbitro;

   
    //constructor

    public Arbitraje(CategoriaArbitro rol, Partido partido, Arbitro arbitro) {
        this.rol = rol;
        this.partido = partido;
        this.arbitro = arbitro;
    }
    
    //metodos get y set
    public CategoriaArbitro getRol() {
        return rol;
    }
    public void setRol(CategoriaArbitro rol) {
        this.rol = rol;
    }
    public Partido getPartido() {
        return partido;
    }
    public void setPartido(Partido partido) {
        this.partido = partido;
    }
    public Arbitro getArbitro() {
        return arbitro;
    }
    public void setArbitro(Arbitro arbitro) {
        this.arbitro = arbitro;
    }

}

