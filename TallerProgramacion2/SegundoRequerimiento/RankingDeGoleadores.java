package SegundoRequerimiento;

import taller_programacion2.*;
import java.util.ArrayList;

public class RankingDeGoleadores {
    
    // Contar los goles de un jugador en todos los partidos
    public static int contarGolesJugador(Jugador jugador, ArrayList<Partido> partidos) {
        int goles = 0;
        
        for (int i = 0; i < partidos.size(); i++) {
            Partido partido = partidos.get(i);
            ArrayList<Evento> eventos = partido.getEventos();
            
            for (int j = 0; j < eventos.size(); j++) {
                Evento evento = eventos.get(j);
                
                if (evento.getTipo() == TipoEvento.GOL) {
                    Jugador j_evento = evento.getJugador();
                    if (j_evento != null && j_evento.equals(jugador)) {
                        goles = goles + 1;
                    }
                }
            }
        }
        
        return goles;
    }
    
    // Obtener lista de todos los jugadores que patearon goles
    public static ArrayList<Jugador> obtenerJugadoresConGoles(ArrayList<Partido> partidos) {
        ArrayList<Jugador> jugadores = new ArrayList<>();
        
        for (int i = 0; i < partidos.size(); i++) {
            Partido partido = partidos.get(i);
            ArrayList<Evento> eventos = partido.getEventos();
            
            for (int j = 0; j < eventos.size(); j++) {
                Evento evento = eventos.get(j);
                
                if (evento.getTipo() == TipoEvento.GOL) {
                    Jugador jugador = evento.getJugador();
                    if (jugador != null) {
                        // Verificar que el jugador no esté duplicado
                        boolean ya_existe = false;
                        for (int k = 0; k < jugadores.size(); k++) {
                            if (jugadores.get(k).equals(jugador)) {
                                ya_existe = true;
                                break;
                            }
                        }
                        
                        if (!ya_existe) {
                            jugadores.add(jugador);
                        }
                    }
                }
            }
        }
        
        return jugadores;
    }
    
    // Ordenar jugadores por cantidad de goles (burbuja)
    public static ArrayList<Jugador> ordenarJugadores(ArrayList<Jugador> jugadores, ArrayList<Partido> partidos) {
        ArrayList<Jugador> ordenados = new ArrayList<>(jugadores);
        
        // Ordenamiento de burbuja
        for (int i = 0; i < ordenados.size() - 1; i++) {
            for (int j = 0; j < ordenados.size() - 1 - i; j++) {
                Jugador j1 = ordenados.get(j);
                Jugador j2 = ordenados.get(j + 1);
                
                int goles1 = contarGolesJugador(j1, partidos);
                int goles2 = contarGolesJugador(j2, partidos);
                
                if (goles1 < goles2) {
                    // Intercambiar
                    ordenados.set(j, j2);
                    ordenados.set(j + 1, j1);
                }
            }
        }
        
        return ordenados;
    }
    
    // Mostrar ranking de goleadores
    public static void mostrarRanking(ArrayList<Partido> partidos) {
        ArrayList<Jugador> jugadores = obtenerJugadoresConGoles(partidos);
        ArrayList<Jugador> ordenados = ordenarJugadores(jugadores, partidos);
        
        System.out.println("\n--- Ranking de Goleadores ---\n");
        
        for (int i = 0; i < ordenados.size(); i++) {
            Jugador jugador = ordenados.get(i);
            int goles = contarGolesJugador(jugador, partidos);
            
            System.out.println((i + 1) + ". " + jugador.getNombre() + " - " + goles + " goles");
        }
        
        System.out.println();
    }
}
