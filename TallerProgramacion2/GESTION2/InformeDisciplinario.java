package GESTION2;

import CLASES.*;
import java.util.ArrayList;

/**
 * Se encarga de procesar y consolidar la información sobre las sanciones y el 
 * comportamiento disciplinario (tarjetas) tanto a nivel individual de jugadores 
 * como colectivo por selecciones.
 * * @author Florencia Benitez
 * @author Agustina Barreto
 * @author Francia Maira
 * @author Gabriela Yañez
 */
public class InformeDisciplinario {

    /** Índice asignado al conteo de tarjetas amarillas en los arreglos de control. */
    private static final int AMARILLAS = 0;
    
    /** Índice asignado al conteo de tarjetas rojas directas en los arreglos de control. */
    private static final int ROJAS = 1;
    
    /** Índice asignado al conteo de expulsiones por doble amonestación en los arreglos de control. */
    private static final int DOBLES = 2;

    /**
     * Método privado auxiliar para unificar la lógica de conteo de tarjetas.
     * Recorre una lista de incidencias y clasifica las sanciones según el tipo de evento.
     * * @param eventos Lista de eventos deportivos a procesar.
     * @return Un array de enteros de tamaño 3 mapeado mediante las constantes de la clase.
     */
    private int[] contarTarjetas(ArrayList<Evento> eventos) {
        int[] contadores = new int[3];
        for (Evento e : eventos) {
            if (e == null) continue;
            
            if (e.getTipo() == TipoEvento.TARJETA_AMARILLA) {
                contadores[AMARILLAS]++;
            } else if (e.getTipo() == TipoEvento.TARJETA_ROJA) {
                contadores[ROJAS]++;
            } else if (e.getTipo() == TipoEvento.DOBLE_AMARILLA) {
                contadores[DOBLES]++;
            }
        }
        return contadores;
    }

    /**
     * Genera un informe disciplinario consolidado acumulando las tarjetas
     * de todos los jugadores que integran una selección determinada.
     * * @param seleccion La Selección sobre la cual se calculará el consolidado.
     * @return Lista de Strings con el desglose del reporte, o null si la selección provista es null.
     */
    public ArrayList<String> informePorSeleccion(Seleccion seleccion) {
        if (seleccion == null) return null;

        int[] tarjetasSeleccion = new int[3];

        for (Jugador j : seleccion.getJugadores()) {
            if (j == null) continue;
            
            int[] tarjetasJugador = contarTarjetas(j.getEventos());
            tarjetasSeleccion[AMARILLAS] += tarjetasJugador[AMARILLAS];
            tarjetasSeleccion[ROJAS]     += tarjetasJugador[ROJAS];
            tarjetasSeleccion[DOBLES]    += tarjetasJugador[DOBLES];
        }

        ArrayList<String> informe = new ArrayList<>();
        informe.add("Selección: " + seleccion.getNombreFederacion());
        informe.add("Tarjetas amarillas: " + tarjetasSeleccion[AMARILLAS]);
        informe.add("Tarjetas rojas: " + tarjetasSeleccion[ROJAS]);
        informe.add("Dobles amarillas: " + tarjetasSeleccion[DOBLES]);

        return informe;
    }

    /**
     * Genera un informe detallado con las estadísticas disciplinarias individuales 
     * asociadas a las sanciones recibidas por un jugador en el torneo.
     * * @param jugador El Jugador del cual se desea el reporte disciplinario.
     * @return Lista de Strings con el desglose del reporte, o null si el jugador provisto es null.
     */
    public ArrayList<String> informePorJugador(Jugador jugador) {
        if (jugador == null) return null;

        int[] tarjetas = contarTarjetas(jugador.getEventos());

        ArrayList<String> informe = new ArrayList<>();
        informe.add("Jugador: " + jugador.getNombre());
        informe.add("Tarjetas amarillas: " + tarjetas[AMARILLAS]);
        informe.add("Tarjetas rojas: " + tarjetas[ROJAS]);
        informe.add("Dobles amarillas: " + tarjetas[DOBLES]);

        return informe;
    }
}