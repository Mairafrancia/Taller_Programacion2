package taller_programacion2;

public class Arbitraje {
    private CategoriaArbitro rol;

    // ASOCIACIONES
    private Partido partido;
    private Arbitro arbitro;

    // CONSTRUCTOR SIN PARAMETROS
    public Arbitraje(){
        this.rol= null;
        this.arbitro = null;
        this.partido = null;
    }


    //CONSTRUCTOR PARAMETRIZADO
    public Arbitraje(CategoriaArbitro rol, Partido partido, Arbitro arbitro) {
        this.rol = rol;
        this.partido = partido;
        this.arbitro = arbitro;
    }

    //SETTERS Y GETTERS
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
