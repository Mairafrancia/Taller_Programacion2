package GESTION2;

import CLASES.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

/**
 * Procesa los resultados de las participaciones cruzadas de los equipos en un mismo grupo
 * para confeccionar y ordenar la tabla de posiciones oficial bajo criterios FIFA estándar.
 * @author Florencia Benitez
 * @author Agustina Barreto
 * @author Francia Maira
 * @author Gabriela Yañez
 */
public class TablaDePosicionesPorGrupo {

    /**
     * Estructura de datos interna (clase de soporte) diseñada para acumular, 
     * calcular y consolidar las variables estadísticas puntuales de cada selección.
     */
    private static class Posicion {
        /** La Selección nacional asociada a estas estadísticas. */
        Seleccion seleccion;
        /** Cantidad de puntos acumulados (3 por victoria, 1 por empate). */
        int puntos;
        /** Cantidad total de partidos válidos disputados en el grupo. */
        int partidosJugados;
        /** Cantidad de partidos ganados. */
        int partidosGanados;
        /** Cantidad de partidos empatados. */
        int partidosEmpatados;
        /** Cantidad de partidos perdidos. */
        int partidosPerdidos;
        /** Sumatoria de goles anotados por la selección. */
        int golesFavor;
        /** Sumatoria de goles recibidos en contra. */
        int golesContra;

        /**
         * Calcula de forma dinámica la diferencia neta de goles de la selección.
         * @return El resultado aritmético de restar goles en contra a los goles a favor.
         */
        int getDiferenciaGoles() {
            return golesFavor - golesContra;
        }
    }

    /**
     * Genera la tabla de posiciones oficial de un Grupo, procesando sus partidos asignados
     * y aplicando un ordenamiento jerárquico por puntos, diferencia de goles, goles a favor 
     * y desempate alfabético.
     *
     * @param grupo El objeto Grupo del cual se desea calcular la tabla de posiciones.
     * @return Lista de Strings formateada fila por fila con las estadísticas de cada equipo, 
     * o null si el grupo provisto es nulo.
     */
    public ArrayList<String> obtenerTablaPosiciones(Grupo grupo) {
        if (grupo == null) {
            return null;
        }

        ArrayList<Seleccion> selecciones = new ArrayList<>(grupo.getSelecciones());

        ArrayList<Posicion> posiciones = new ArrayList<>();

        for (Seleccion seleccion : selecciones) {
            Posicion posicionEquipo = new Posicion();
            posicionEquipo.seleccion = seleccion;

            // Analiza el histórico de partidos en los que participó este equipo
            if (seleccion.getParticipaciones() == null) continue;
            for (Participacion participacion : seleccion.getParticipaciones()) {
                if (participacion == null) continue;
                Partido partido = participacion.getPartido();
                // Filtro 1: El partido debe existir y corresponder a la misma fase (ej: Fase de Grupos)
                if (partido == null || partido.getFase() != grupo.getFase()) {
                    continue; // Solo partidos de la misma fase del grupo
                }

                Participacion participacionRival = participacion.isEsLocal() ? partido.getParticipacionVisitante() : partido.getParticipacionLocal();
                if (participacionRival == null || !grupo.getSelecciones().contains(participacionRival.getSeleccion())) {
                    continue; // Ignorar si el rival no pertenece al mismo grupo
                }
                // Solo se cuenta el partido si ya tiene al menos un evento registrado,
                // lo que indica que efectivamente se jugo. Un partido planificado sin
                // eventos cargados aun no se disputo y no debe sumar como empate 0-0.
                if (partido.getEventos() == null || partido.getEventos().isEmpty()) {
                    continue;
                }
                int golesFavorPartido = participacion.cantidadGoles();
                int golesContraPartido = participacionRival.cantidadGoles();

                posicionEquipo.partidosJugados++;
                posicionEquipo.golesFavor += golesFavorPartido;
                posicionEquipo.golesContra += golesContraPartido;

                if (golesFavorPartido > golesContraPartido) {
                    posicionEquipo.partidosGanados++;
                    posicionEquipo.puntos += 3;
                } else if (golesFavorPartido == golesContraPartido) {
                    posicionEquipo.partidosEmpatados++;
                    posicionEquipo.puntos += 1;
                } else {
                    posicionEquipo.partidosPerdidos++;
                }
            }
            posiciones.add(posicionEquipo);
        }

        Collections.sort(posiciones, new Comparator<Posicion>() {
            @Override
            public int compare(Posicion posicionA, Posicion posicionB) { 
                if (posicionA.puntos != posicionB.puntos) return Integer.compare(posicionB.puntos, posicionA.puntos);
                
                if (posicionA.getDiferenciaGoles() != posicionB.getDiferenciaGoles()) return Integer.compare(posicionB.getDiferenciaGoles(), posicionA.getDiferenciaGoles());
                
                if (posicionA.golesFavor != posicionB.golesFavor) return Integer.compare(posicionB.golesFavor, posicionA.golesFavor);
                
                String nombreA = posicionA.seleccion.getNombreFederacion() != null ? posicionA.seleccion.getNombreFederacion() : "";
                String nombreB = posicionB.seleccion.getNombreFederacion() != null ? posicionB.seleccion.getNombreFederacion() : "";
                return nombreA.compareToIgnoreCase(nombreB); 
            }
        });

        ArrayList<String> tabla = new ArrayList<>();
        for (int i = 0; i < posiciones.size(); i++) {
            Posicion posicionEquipo = posiciones.get(i);
            tabla.add((i + 1) + ". " + posicionEquipo.seleccion.getNombreFederacion()
                    + " | Puntos: "          + posicionEquipo.puntos
                    + " | Jugados: "         + posicionEquipo.partidosJugados
                    + " | Ganados: "         + posicionEquipo.partidosGanados
                    + " | Empatados: "       + posicionEquipo.partidosEmpatados
                    + " | Perdidos: "        + posicionEquipo.partidosPerdidos
                    + " | Goles a favor: "   + posicionEquipo.golesFavor
                    + " | Goles en contra: " + posicionEquipo.golesContra
                    + " | Diferencia: "      + posicionEquipo.getDiferenciaGoles());
        }

        return tabla;
    }
}