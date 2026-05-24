package CLASES;

public class Participacion {

    private boolean esLocal;

    //ASOCIACIONES
    // tiene 1 partido y 1 seleccion
    private Partido partido;
    private Seleccion seleccion;

    // CONSTRUCTOR SIN PARAMETROS
    public Participacion() {
        this.esLocal = false;
        this.partido = null;
        this.seleccion = null;
    }

    // CONSTRUCTOR CON PARAMETROS
    public Participacion(boolean esLocal, Partido partido, Seleccion seleccion) {
        this.esLocal = esLocal;
        this.partido = partido;
        this.seleccion = seleccion;
    }

    // SETTERS Y GETTERS
    public boolean isEsLocal() {
        return esLocal;
    }

    public void setEsLocal(boolean esLocal) {
        this.esLocal = esLocal;
    }

    public Partido getPartido() {
        return partido;
    }

    public void setPartido(Partido partido) {
        this.partido = partido;
    }

    public Seleccion getSeleccion() {
        return seleccion;
    }

    public void setSeleccion(Seleccion seleccion) {
        this.seleccion = seleccion;
    }

    // METODOS
    
    // METODOS DE CONTEO USANDO FOR TRADICIONAL (DEBERIAMOS USAR EQUALS Y CONTAINS???)
    public int cantidadGoles() {
        int goles = 0;
        
        if (this.partido != null && this.seleccion != null) {
            // 1. Recorremos todos los eventos del partido
            for (Evento e : this.partido.getEventos()) {
                
                // 2. Si el evento es un GOL y tiene un jugador asociado
                if (e != null && e.getTipo() == TipoEvento.GOL && e.getJugador() != null) {
                    
                    // 3. Buscamos manualmente si ese jugador pertenece a nuestra selección
                    for (Jugador j : this.seleccion.getJugadores()) {
                        if (j == e.getJugador()){ //use referencia directa
                            goles++;
                            break; // Ya lo encontramos, pasamos al siguiente evento
                        }
                    }
                }
            }
        }
        return goles;
    }

    public int cantidadTarjAmarillas() {
        int amarillas = 0;
        if (this.partido != null && this.seleccion != null) {
            for (Evento e : this.partido.getEventos()) {
                if (e != null && e.getTipo() == TipoEvento.TARJETA_AMARILLA && e.getJugador() != null) {
                    
                    for (Jugador j : this.seleccion.getJugadores()) {
                        if (j.getNombre().equalsIgnoreCase(e.getJugador().getNombre())) {
                            amarillas++;
                            break;
                        }
                    }
                }
            }
        }
        return amarillas;
    }

    public int cantidadTarRojas() {
        int rojas = 0;
        if (this.partido != null && this.seleccion != null) {
            for (Evento e : this.partido.getEventos()) {
                if (e != null && e.getTipo() == TipoEvento.TARJETA_ROJA && e.getJugador() != null) {
                    
                    for (Jugador j : this.seleccion.getJugadores()) {
                        if (j.getNombre().equalsIgnoreCase(e.getJugador().getNombre())) {
                            rojas++;
                            break;
                        }
                    }
                }
            }
        }
        return rojas;
    }
}
