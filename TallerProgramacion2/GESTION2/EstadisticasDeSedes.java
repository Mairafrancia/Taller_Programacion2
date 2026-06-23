package GESTION2;

import java.util.ArrayList;

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
        int contador = 0;
        for (Partido p : estadio.getPartidos()) {
            if (p != null && p.getEventos() != null && !p.getEventos().isEmpty()) {
                contador++;
            }
        }
        return contador;
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
            if (sede.getCiudad().equalsIgnoreCase(ciudad)) {
                for (Estadio e : sede.getEstadios()) {
                    if (e != null && e.getPartidos() != null) {
                        for (Partido p : e.getPartidos()) {
                            if (p != null && p.getEventos() != null && !p.getEventos().isEmpty()) {
                                totalPartidos++;
                            }
                        }
                    }
                }
            }
        }
        return totalPartidos;
    }
    /**
     * Devuelve el detalle de los partidos jugados en un estadio específico,
     * incluyendo fecha, horario, equipos participantes y resultado final.
     *
     * @param estadio El objeto Estadio sobre el cual se realiza la consulta.
     * @return Lista de Strings con el detalle de cada partido, o null si el estadio es null.
     */
    public ArrayList<String> detallePorEstadio(Estadio estadio) {
        if (estadio == null) {
            return null;
        }
        ArrayList<String> detalle = new ArrayList<>();
        for (Partido p : estadio.getPartidos()) {
            if (p == null) continue;
            if (p.getEventos() == null || p.getEventos().isEmpty()) continue;
            String local = "?";
            String visitante = "?";
            int golesLocal = 0;
            int golesVisitante = 0;
            if (p.getParticipacionLocal() != null) {
                Seleccion selLocal = p.getParticipacionLocal().getSeleccion();
                local = (selLocal != null) ? selLocal.getNombreFederacion() : "?";
                golesLocal = p.getParticipacionLocal().cantidadGoles();
            }
            if (p.getParticipacionVisitante() != null) {
                Seleccion selVisitante = p.getParticipacionVisitante().getSeleccion();
                visitante = (selVisitante != null) ? selVisitante.getNombreFederacion() : "?";
                golesVisitante = p.getParticipacionVisitante().cantidadGoles();
            }
            detalle.add("  " + p.getFecha() + " " + p.getHorario() + " - " 
                + local + " vs " + visitante 
                + " - Resultado: " + golesLocal + "-" + golesVisitante);
        }
        return detalle;
    }

    /**
     * Devuelve el detalle de los partidos jugados en todos los estadios
     * de una ciudad específica, incluyendo fecha, horario, equipos y resultado.
     *
     * @param mundial El objeto Mundial que contiene el registro global de sedes.
     * @param ciudad El nombre de la ciudad por la cual filtrar los encuentros.
     * @return Lista de Strings con el detalle de cada partido, o null si los parametros son invalidos.
     */
    public ArrayList<String> detallePorCiudad(Mundial mundial, String ciudad) {
        if (mundial == null || ciudad == null || ciudad.isEmpty()) {
            return null;
        }
        ArrayList<String> detalle = new ArrayList<>();
        for (Sede sede : mundial.getSedes()) {
            if (sede == null || sede.getCiudad() == null) continue;
            if (sede.getCiudad().equalsIgnoreCase(ciudad)) {
                for (Estadio e : sede.getEstadios()) {
                    if (e == null) continue;
                    ArrayList<String> detalleEstadio = detallePorEstadio(e);
                    if (detalleEstadio != null) {
                        detalle.addAll(detalleEstadio);
                    }
                }
            }
        }
        return detalle;
    }
}