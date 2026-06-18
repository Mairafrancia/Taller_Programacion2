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
        int totalPartidos = 0; //contador
        for (Sede sede : mundial.getSedes()) { //recorremos 1 x 1 las sedes del mundial
            if (sede == null || sede.getCiudad() == null) { //controlamos q no sea nula ni la sede ni la ciudad
                continue; //se saltea a la prox
            }
            // Mantenemos el ignoreCase que es clave para las búsquedas
            if (sede.getCiudad().equalsIgnoreCase(ciudad)) { //Compara el nombre de la ciudad de la sede con la ciudad que busca el usuario
                for (Estadio e : sede.getEstadios()) { //recorro todos los estadios de esa sede
                    if (e != null && e.getPartidos() != null) { //control
                        totalPartidos += e.getPartidos().size(); //al contador le incremento el tamaño de la lista de partidos
                    }
                }
            }
        }
        return totalPartidos; //dsp de revisar todas las sedes devolvemos el total acumulado
    }
}