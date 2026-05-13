package SegundoRequerimiento;
import taller_programacion2.*;


public class SegundosRequerimientos{

    public void estadisticasDeSedesPorEstadio(Estadio estadio){
        int cantidadPartidos = estadio.getPartidos().size();
        System.out.println("Cantidad de partidos en el estadio: " + cantidadPartidos);
    }

    public void estadisticasDeSedesPorCiudad(String ciudad, Mundial mundial) {
        int cantidadPartidos = 0;
        for (Sede sede : mundial.getSedes()) {
            if (sede.getCiudad().equals(ciudad)) {
                for (Estadio estadio : sede.getEstadios()) {
                    cantidadPartidos += estadio.getPartidos().size();
                }
            }
        }
        System.out.println("Cantidad de partidos en la ciudad " + ciudad + ": " + cantidadPartidos);
    }

}

