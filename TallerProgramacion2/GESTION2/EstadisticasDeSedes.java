package GESTION2;

import CLASES.*;

/**
 * Proporciona métodos estadísticos y de consulta sobre sedes, estadios
 * y la distribución de los partidos disputados en un torneo mundial.
 *
 * @author Florencia Benitez
 * @author Agustina Barreto
 * @author Francia Maira
 * @author Gabriela Yañez
 */
public class EstadisticasDeSedes {

    /**
     * Devuelve la cantidad de partidos jugados en un estadio específico.
     *
     * @param estadio El objeto {@link Estadio} sobre el cual se realiza la consulta.
     * @return Cantidad total de partidos registrados en el estadio, o -1 si el estadio provisto es {@code null}.
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
     *
     * @param mundial El objeto {@link Mundial} que contiene el registro global de sedes.
     * @param ciudad El nombre de la ciudad por la cual filtrar los encuentros.
     * @return El total acumulado de partidos jugados en esa ciudad, o -1 si el mundial o la ciudad son inválidos/nulos.
     */
    public int partidosPorCiudad(Mundial mundial, String ciudad) {
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