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
                continue; //que salte
            }

            NombreFase faseActual = partido.getFase().getNombre();

            // Actualizamos la instancia máxima usando ordinal()
            if (instanciaMaxima == null || faseActual.ordinal() > instanciaMaxima.ordinal()) {
                instanciaMaxima = faseActual;
            }

            // Calculamos puntos del partido
            int golesFavor = p.cantidadGoles();
            int golesContra = 0;

            if (p.isEsLocal()) {
                Participacion rival = partido.getParticipacionVisitante();
                if (rival != null) golesContra = rival.cantidadGoles();
            } else {
                Participacion rival = partido.getParticipacionLocal();
                if (rival != null) golesContra = rival.cantidadGoles();
            }

            if (golesFavor > golesContra)
                puntosTotales += 3;
            else if (golesFavor == golesContra)
                puntosTotales += 1;
        }

        // Construimos el informe
        ArrayList<String> resultado = new ArrayList<>();
        resultado.add("Selección: " + seleccion.getNombreFederacion());
        resultado.add("Puntos totales: " + puntosTotales);
        resultado.add("Instancia máxima alcanzada: " + 
                (instanciaMaxima != null ? instanciaMaxima.name() : "Sin partidos registrados"));

        return resultado;
    }
}