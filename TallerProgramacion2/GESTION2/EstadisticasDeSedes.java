package GESTION2;

import CLASES.*;
import java.util.ArrayList;

public class EstadisticasDeSedes {

    /**
     * Devuelve la cantidad de partidos jugados en un estadio específico.
     */
    public int partidosPorEstadio(Estadio estadio) {
        if (estadio == null) {
            return -1;
        }
        return estadio.getPartidos().size();
    }

    /**
     * Devuelve la cantidad de partidos jugados en todos los estadios
     * de una ciudad específica, recorriendo las sedes del mundial.
     */
    public int partidosPorCiudad(Mundial mundial, String ciudad) {
        if (mundial == null || ciudad == null || ciudad.trim().isEmpty()) {
            return -1;
        }

        int totalPartidos = 0;

        for (Sede sede : mundial.getSedes()) {
            if (sede == null || sede.getCiudad() == null) {
                continue;
            }

            // Solo procesamos las sedes de la ciudad buscada
            if (sede.getCiudad().equalsIgnoreCase(ciudad)) {
                for (Estadio e : sede.getEstadios()) {
                    if (e != null && e.getPartidos() != null) {
                        totalPartidos += e.getPartidos().size();
                    }
                }
            }
        }

        return totalPartidos;
    }
}