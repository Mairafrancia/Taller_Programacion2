package SegundoRequerimiento;

import taller_programacion2.*;
import java.util.ArrayList;

public class FichaTecnicaPartido {
    
    // Método para obtener las alineaciones de ambos equipos
    // Devuelve una lista de listas: índice 0 = local, índice 1 = visitante
    public static ArrayList<ArrayList<Jugador>> obtenerAlineaciones(Partido partido) {
        ArrayList<ArrayList<Jugador>> alineaciones = new ArrayList<>();
        
        Participacion local = partido.getParticipacionLocal();
        Participacion visitante = partido.getParticipacionVisitante();
        
        ArrayList<Jugador> alineacionLocal = new ArrayList<>();
        if (local != null && local.getSeleccion() != null) {
            alineacionLocal.addAll(local.getSeleccion().getJugadores());
        }
        alineaciones.add(alineacionLocal);
        
        ArrayList<Jugador> alineacionVisitante = new ArrayList<>();
        if (visitante != null && visitante.getSeleccion() != null) {
            alineacionVisitante.addAll(visitante.getSeleccion().getJugadores());
        }
        alineaciones.add(alineacionVisitante);
        
        return alineaciones;
    }
    
    // Método para obtener los eventos del partido
    public static ArrayList<Evento> obtenerEventos(Partido partido) {
        return partido.getEventos();
    }
    
    // Método para obtener el resultado final
    public static String obtenerResultadoFinal(Partido partido) {
        int golesLocal = 0;
        int golesVisitante = 0;
        
        Participacion local = partido.getParticipacionLocal();
        Participacion visitante = partido.getParticipacionVisitante();
        
        for (Evento evento : partido.getEventos()) {
            if (evento.getTipo() == TipoEvento.GOL) {
                // Verificar si el jugador pertenece al equipo local o visitante
                if (local != null && local.getSeleccion() != null && local.getSeleccion().getJugadores().contains(evento.getJugador())) {
                    golesLocal++;
                } else if (visitante != null && visitante.getSeleccion() != null && visitante.getSeleccion().getJugadores().contains(evento.getJugador())) {
                    golesVisitante++;
                }
            }
        }
        
        return golesLocal + " - " + golesVisitante;
    }
    
    // Método para generar la ficha técnica completa
    public static void generarFichaTecnica(Partido partido) {
        System.out.println("=== FICHA TÉCNICA DEL PARTIDO ===");
        System.out.println("Fecha: " + partido.getFecha());
        System.out.println("Horario: " + partido.getHorario());
        System.out.println("Estadio: " + (partido.getEstadio() != null ? partido.getEstadio().getNombre() : "N/A"));
        System.out.println("Fase: " + (partido.getFase() != null ? partido.getFase().getNombre() : "N/A"));
        System.out.println();
        
        // Alineaciones
        ArrayList<ArrayList<Jugador>> alineaciones = obtenerAlineaciones(partido);
        Participacion local = partido.getParticipacionLocal();
        Participacion visitante = partido.getParticipacionVisitante();
        
        if (local != null && local.getSeleccion() != null) {
            System.out.println("Local: " + local.getSeleccion().getNombreFederacion());
            for (Jugador jugador : alineaciones.get(0)) {
                System.out.println("  - " + jugador.getNombre() + " (Dorsal: " + jugador.getDorsal() + ")");
            }
            System.out.println();
        }
        
        if (visitante != null && visitante.getSeleccion() != null) {
            System.out.println("Visitante: " + visitante.getSeleccion().getNombreFederacion());
            for (Jugador jugador : alineaciones.get(1)) {
                System.out.println("  - " + jugador.getNombre() + " (Dorsal: " + jugador.getDorsal() + ")");
            }
            System.out.println();
        }
        
        // Eventos
        ArrayList<Evento> eventos = obtenerEventos(partido);
        System.out.println("Eventos:");
        for (Evento evento : eventos) {
            System.out.println("  Minuto " + evento.getMinuto() + ": " + evento.getTipo() + " - " + 
                               (evento.getJugador() != null ? evento.getJugador().getNombre() : "N/A"));
        }
        System.out.println();
        
        // Resultado final
        String resultado = obtenerResultadoFinal(partido);
        System.out.println("Resultado Final: " + resultado);
    }
}
