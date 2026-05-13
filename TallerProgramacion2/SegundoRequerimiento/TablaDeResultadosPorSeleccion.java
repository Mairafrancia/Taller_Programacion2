package SegundoRequerimiento;

import taller_programacion2.*;
import java.util.ArrayList;

public class TablaDeResultadosPorSeleccion {
    
    // Contar los goles que hizo una selección en un partido
    private static int contarGoles(Seleccion seleccion, Partido partido) {
        int goles = 0;
        ArrayList<Evento> eventos = partido.getEventos();
        
        for (int i = 0; i < eventos.size(); i++) {
            Evento evento = eventos.get(i);
            if (evento.getTipo() == TipoEvento.GOL) {
                Jugador jugador = evento.getJugador();
                if (seleccion.getJugadores().contains(jugador)) {
                    goles = goles + 1;
                }
            }
        }
        return goles;
    }
    
    // Mostrar todos los partidos de una selección
    public static void mostrarPartidos(Seleccion seleccion) {
        ArrayList<Participacion> participaciones = seleccion.getParticipaciones();
        
        System.out.println("\n--- Partidos de " + seleccion.getNombreFederacion() + " ---\n");
        
        for (int i = 0; i < participaciones.size(); i++) {
            Participacion p = participaciones.get(i);
            Partido partido = p.getPartido();
            
            if (partido == null) {
                continue;
            }
            
            // Obtener el rival
            Participacion rival_participacion;
            String tipo = "";
            
            if (p.isEsLocal()) {
                rival_participacion = partido.getParticipacionVisitante();
                tipo = "Local";
            } else {
                rival_participacion = partido.getParticipacionLocal();
                tipo = "Visitante";
            }
            
            String rival = "Desconocido";
            if (rival_participacion != null && rival_participacion.getSeleccion() != null) {
                rival = rival_participacion.getSeleccion().getNombreFederacion();
            }
            
            // Calcular goles
            int goles_seleccion = contarGoles(seleccion, partido);
            int goles_rival = 0;
            if (rival_participacion != null && rival_participacion.getSeleccion() != null) {
                goles_rival = contarGoles(rival_participacion.getSeleccion(), partido);
            }
            
            // Mostrar el partido
            System.out.println((i+1) + ". " + seleccion.getNombreFederacion() + " " + goles_seleccion + " - " + goles_rival + " " + rival + " (" + tipo + ")");
        }
        System.out.println();
    }
    
    // Mostrar estadísticas de una selección
    public static void mostrarEstadisticas(Seleccion seleccion) {
        ArrayList<Participacion> participaciones = seleccion.getParticipaciones();
        
        int victorias = 0;
        int empates = 0;
        int derrotas = 0;
        int goles_totales = 0;
        int goles_contra = 0;
        
        // Contar resultados
        for (int i = 0; i < participaciones.size(); i++) {
            Participacion p = participaciones.get(i);
            Partido partido = p.getPartido();
            
            if (partido == null) {
                continue;
            }
            
            int goles_seleccion = contarGoles(seleccion, partido);
            goles_totales = goles_totales + goles_seleccion;
            
            // Obtener rival
            Participacion p_rival;
            if (p.isEsLocal()) {
                p_rival = partido.getParticipacionVisitante();
            } else {
                p_rival = partido.getParticipacionLocal();
            }
            
            if (p_rival != null && p_rival.getSeleccion() != null) {
                int goles_rival = contarGoles(p_rival.getSeleccion(), partido);
                goles_contra = goles_contra + goles_rival;
                
                // Clasificar el resultado
                if (goles_seleccion > goles_rival) {
                    victorias = victorias + 1;
                } else if (goles_seleccion == goles_rival) {
                    empates = empates + 1;
                } else {
                    derrotas = derrotas + 1;
                }
            }
        }
        
        System.out.println("\n--- Estadisticas de " + seleccion.getNombreFederacion() + " ---\n");
        System.out.println("Partidos: " + participaciones.size());
        System.out.println("Victorias: " + victorias);
        System.out.println("Empates: " + empates);
        System.out.println("Derrotas: " + derrotas);
        System.out.println("Goles: " + goles_totales);
        System.out.println("Goles en contra: " + goles_contra);
        System.out.println();
    }
}
