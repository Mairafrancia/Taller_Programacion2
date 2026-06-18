package GESTION2;

import CLASES.*;
import java.util.ArrayList;

/**
 * Se encarga de procesar el histórico de participaciones de una selección 
 * para consolidar su rendimiento total en el torneo y determinar de manera 
 * dinámica la instancia jerárquica más avanzada a la que logró clasificar.
 * * @author Florencia Benitez
 * @author Agustina Barreto
 * @author Francia Maira
 * @author Gabriela Yañez
 */
public class TablaDeResultadosPorSeleccion {

    /**
     * Genera un informe breve de resultados para una selección específica.
     * Recorre sus participaciones y calcula puntaje, partidos jugados y la fase máxima.
     *
     * @param seleccion La selección de la que se desea obtener el informe.
     * @return Lista de líneas con el resumen, o null si la selección es nula.
     */
    public ArrayList<String> obtenerResultados(Seleccion seleccion) {
        if (seleccion == null) {
            return null;
        }
        // Inicialización de los acumuladores de estadísticas globales
        int puntosTotales = 0;
        int partidosJugados = 0;
        int partidosGanados = 0;
        int partidosEmpatados = 0;
        int partidosPerdidos = 0;
        // Almacenará el Enum de la fase más lejana a la que llegó el equipo
        NombreFase instanciaMaxima = null; // fase más avanzada alcanzada

        // Recorrido de todos los partidos históricos en los que estuvo involucrado el equipo
        for (Participacion participacion : seleccion.getParticipaciones()) {
            Partido partido = participacion.getPartido();
            if (partido == null || partido.getFase() == null) {
                continue; 
            }

            NombreFase faseActual = partido.getFase().getNombre();
            if (faseActual == null) {
                continue;
            }
            // Comparación de jerarquía de fases usando su valor ordinal de Enum (ej: FINAL > CUARTOS)
            if (instanciaMaxima == null || faseActual.ordinal() > instanciaMaxima.ordinal()) {
                instanciaMaxima = faseActual;
            }

            // Identificación cruzada del rival
            Participacion participacionRival = participacion.isEsLocal() ? partido.getParticipacionVisitante(): partido.getParticipacionLocal();
            if (participacionRival == null) {
                continue; // ignorar si falta el rival
            }

            int golesFavor = participacion.cantidadGoles();
            int golesContra = participacionRival.cantidadGoles();
            // Computa los resultados deportivos del encuentro
            partidosJugados++;
            if (golesFavor > golesContra) {
                partidosGanados++;
                puntosTotales += 3; //ganado +3 puntos
            } else if (golesFavor == golesContra) {
                partidosEmpatados++;
                puntosTotales += 1; //empato +1 punto
            } else {
                partidosPerdidos++; //perdio 0 puntos
            }
        }

        // Construcción estructurada del reporte impreso final
        ArrayList<String> resultado = new ArrayList<>();
        resultado.add("Selección: " + seleccion.getNombreFederacion());
        resultado.add("Puntos totales: " + puntosTotales);
        resultado.add("Partidos jugados: " + partidosJugados);
        resultado.add("Ganados: " + partidosGanados);
        resultado.add("Empatados: " + partidosEmpatados);
        resultado.add("Perdidos: " + partidosPerdidos);
        // Operador ternario: si no hay partidos jugados avisa, de lo contrario muestra el texto de la fase
        resultado.add("Instancia máxima alcanzada: "
                + (instanciaMaxima != null ? instanciaMaxima.name() : "Sin partidos registrados"));

        return resultado;
    }
}