package GESTION2;

import CLASES.*;
import java.util.ArrayList;

public class TablaDeResultadosPorSeleccion {

    /**
     * Genera un informe con los puntos totales e instancia máxima alcanzada
     * por una selección determinada, recorriendo todas sus participaciones.
     *
     * @param seleccion La selección de la que se desea obtener el informe.
     * @return Lista de Strings con el resumen, o null si la selección es nula.
     */
    public ArrayList<String> obtenerResultados(Seleccion seleccion) {
        if (seleccion == null) {
            return null;
        }

        int puntosTotales = 0;
        NombreFase instanciaMaxima = null;

        for (Participacion p : seleccion.getParticipaciones()) {
            Partido partido = p.getPartido();
            if (partido == null || partido.getFase() == null) {
                continue; 
            }

            NombreFase faseActual = partido.getFase().getNombre();
            if (faseActual == null) continue;

            // Actualizamos la instancia máxima usando ordinal()
            if (instanciaMaxima == null || faseActual.ordinal() > instanciaMaxima.ordinal()) {
                instanciaMaxima = faseActual;
            }

            // Calculamos puntos del partido
            int golesFavor = p.cantidadGoles();
            
            // OPTIMIZACIÓN: Asignación del rival usando el operador ternario
            Participacion rival = p.isEsLocal() 
                    ? partido.getParticipacionVisitante() 
                    : partido.getParticipacionLocal();

            // Si el rival existe, tomamos sus goles; si no, asumimos 0
            int golesContra = (rival != null) ? rival.cantidadGoles() : 0;

            // Sistema de puntuación estándar (3 por ganar, 1 por empatar)
            if (golesFavor > golesContra) {
                puntosTotales += 3;
            } else if (golesFavor == golesContra) {
                puntosTotales += 1;
            }
        }

        // Construimos el informe
        ArrayList<String> resultado = new ArrayList<>();
        resultado.add("Selección: " + seleccion.getNombreFederacion());
        resultado.add("Puntos totales: " + puntosTotales);
        resultado.add("Instancia máxima alcanzada: " + 
                (instanciaMaxima != null ? instanciaMaxima.name() : "Sin partidos registrados")); //operador ternario 

        return resultado;
    }
}