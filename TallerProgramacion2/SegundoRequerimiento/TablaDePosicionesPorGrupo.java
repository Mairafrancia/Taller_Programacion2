package SegundoRequerimiento;

import taller_programacion2.*;
import java.util.ArrayList;

public class TablaDePosicionesPorGrupo {
    
    // Contar goles de una selección en un partido
    public static int contarGoles(Seleccion seleccion, Partido partido) {
        int goles = 0;
        for (Evento evento : partido.getEventos()) {
            if (evento.getTipo() == TipoEvento.GOL) {
                if (seleccion.getJugadores().contains(evento.getJugador())) {
                    goles++;
                }
            }
        }
        return goles;
    }
    
    // Calcular puntos de una selección (victoria=3, empate=1, derrota=0)
    public static int calcularPuntos(Seleccion seleccion) {
        int puntos = 0;
        
        for (Participacion participacion : seleccion.getParticipaciones()) {
            Partido partido = participacion.getPartido();
            if (partido == null) continue;
            
            int golesSeleccion = contarGoles(seleccion, partido);
            
            // Obtener goles del equipo contrario
            Participacion otra;
            if (participacion.isEsLocal()) {
                otra = partido.getParticipacionVisitante();
            } else {
                otra = partido.getParticipacionLocal();
            }
            
            if (otra != null && otra.getSeleccion() != null) {
                int golesContrario = contarGoles(otra.getSeleccion(), partido);
                
                if (golesSeleccion > golesContrario) {
                    puntos = puntos + 3;  // Victoria
                } else if (golesSeleccion == golesContrario) {
                    puntos = puntos + 1;  // Empate
                }
            }
        }
        
        return puntos;
    }
    
    // Mostrar tabla de posiciones de un grupo
    public static void mostrarTabla(Grupo grupo) {
        ArrayList<Seleccion> selecciones = grupo.getSelecciones();
        
        System.out.println("\n=== TABLA DE POSICIONES - GRUPO " + grupo.getIdentificador() + " ===\n");
        System.out.println("Seleccion              | Puntos | Partidos");
        System.out.println("-------------------------------------------");
        
        // Mostrar cada selección con sus puntos
        for (int i = 0; i < selecciones.size(); i++) {
            Seleccion sel = selecciones.get(i);
            int puntos = calcularPuntos(sel);
            int partidos = sel.getParticipaciones().size();
            
            System.out.println((i+1) + ". " + sel.getNombreFederacion() + " | " + puntos + " | " + partidos);
        }
        System.out.println();
    }
}
