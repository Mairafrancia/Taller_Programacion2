package GESTION2;

import CLASES.*;
//import java.util.ArrayList;

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
        // Quitamos trim() y dejamos solo el chequeo de nulo y vacío directo
        if (mundial == null || ciudad == null || ciudad.isEmpty()) {
            return -1;
        }

        int totalPartidos = 0;

        for (Sede sede : mundial.getSedes()) {
            if (sede == null || sede.getCiudad() == null) {
                continue;
            }

            // Mantenemos el ignoreCase que es clave para las búsquedas
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