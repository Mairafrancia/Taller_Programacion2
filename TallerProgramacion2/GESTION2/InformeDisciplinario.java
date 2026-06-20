package GESTION2;

import CLASES.*;
import java.util.ArrayList;

/**
 * Se encarga de procesar y consolidar la información sobre las sanciones y el 
 * comportamiento disciplinario (tarjetas) tanto a nivel individual de jugadores 
 * como colectivo por selecciones.
 * @author Florencia Benitez
 * @author Agustina Barreto
 * @author Francia Maira
 * @author Gabriela Yañez
 */
public class InformeDisciplinario {

    private static final int AMARILLAS = 0;
    private static final int ROJAS     = 1;
    private static final int DOBLES    = 2;

    /**
     * Método privado auxiliar para contar tarjetas en una lista de eventos.
     *
     * REGLA: una DOBLE_AMARILLA implica que previamente se recibió una
     * TARJETA_AMARILLA en ese mismo partido, la cual ya fue contada como amarilla.
     * Para evitar contarla dos veces, se descuenta 1 amarilla por cada DOBLE_AMARILLA
     * registrada, dado que la primera amonestación siempre queda en los eventos.
     *
     * @param eventos Lista de eventos deportivos a procesar.
     * @return Array [amarillas, rojas, dobles] ya corregido.
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
                // La primera amarilla que derivó en esta doble ya fue contada
                // como TARJETA_AMARILLA: descontamos 1 para no duplicarla.
                if (contadores[AMARILLAS] > 0) {
                    contadores[AMARILLAS]--;
                }
            }
        }
        return contadores;
    }

    /**
     * Genera un informe disciplinario consolidado acumulando las tarjetas
     * de todos los jugadores que integran una selección determinada.
     *
     * @param seleccion La Selección sobre la cual se calculará el consolidado.
     * @return Lista de Strings con el desglose del reporte, o null si la selección es null.
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
     * de un jugador.
     *
     * @param jugador El Jugador del cual se desea el reporte disciplinario.
     * @return Lista de Strings con el desglose del reporte, o null si el jugador es null.
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