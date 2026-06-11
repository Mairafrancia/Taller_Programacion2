package GESTION2;

import CLASES.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class TablaDePosicionesPorGrupo {

    // Clase interna para acumular las estadísticas de cada selección
    private static class Posicion {
        Seleccion seleccion;
        int puntos;
        int partidosJugados;
        int partidosGanados;
        int partidosEmpatados;
        int partidosPerdidos;
        int golesFavor;
        int golesContra;

        int getDiferenciaGoles() {
            return golesFavor - golesContra;
        }
    }

    public ArrayList<String> obtenerTablaPosiciones(Grupo grupo) {
        if (grupo == null) {
            return null;
        }

        // Copia defensiva de las selecciones del grupo
        ArrayList<Seleccion> selecciones = new ArrayList<>(grupo.getSelecciones());

        // Lista de posiciones que luego ordenaremos
        ArrayList<Posicion> posiciones = new ArrayList<>();

        // Calculamos las estadísticas por selección
        for (Seleccion seleccion : selecciones) {
            Posicion posicionEquipo = new Posicion();
            posicionEquipo.seleccion = seleccion;

            for (Participacion participacion : seleccion.getParticipaciones()) {
                Partido partido = participacion.getPartido();
                if (partido == null || partido.getFase() != grupo.getFase()) {
                    continue; // Solo partidos de la misma fase del grupo
                }

                Participacion participacionRival = participacion.isEsLocal() ? partido.getParticipacionVisitante() : partido.getParticipacionLocal();
                if (participacionRival == null || !grupo.getSelecciones().contains(participacionRival.getSeleccion())) {
                    continue; // Ignorar si el rival no pertenece al mismo grupo
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

        // Ordenar la tabla por puntos, luego diferencia de goles y goles a favor
        Collections.sort(posiciones, new Comparator<Posicion>() {
            @Override
            public int compare(Posicion posicionA, Posicion posicionB) {
                if (posicionA.puntos != posicionB.puntos) return Integer.compare(posicionB.puntos, posicionA.puntos);
                if (posicionA.getDiferenciaGoles() != posicionB.getDiferenciaGoles()) return Integer.compare(posicionB.getDiferenciaGoles(), posicionA.getDiferenciaGoles());
                if (posicionA.golesFavor != posicionB.golesFavor) return Integer.compare(posicionB.golesFavor, posicionA.golesFavor);
                String nombreA = posicionA.seleccion.getNombreFederacion() != null ? posicionA.seleccion.getNombreFederacion() : "";
                String nombreB = posicionB.seleccion.getNombreFederacion() != null ? posicionB.seleccion.getNombreFederacion() : "";
                return nombreA.compareToIgnoreCase(nombreB); // desempate alfabético
            }
        });

        ArrayList<String> tabla = new ArrayList<>();
        for (int i = 0; i < posiciones.size(); i++) {
            Posicion posicionEquipo = posiciones.get(i);
            // Construir la línea de salida para esta selección
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