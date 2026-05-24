package GESTION2;

import CLASES.*;
import java.util.ArrayList;

public class InformeDisciplinario {

    /**
     * Genera el informe disciplinario de una selección,
     * mostrando la cantidad de tarjetas amarillas, rojas y dobles amarillas.
     * Recorre los eventos de cada jugador de la selección.
     *
     * @param seleccion La selección de la que se desea el informe.
     * @return Lista de Strings con el resumen, o null si la selección es nula.
     */
    public ArrayList<String> informePorSeleccion(Seleccion seleccion) {
        if (seleccion == null) {
            return null;
        }

        int amarillas = 0;
        int rojas = 0;
        int dobleAmarilla = 0;

        for (Jugador j : seleccion.getJugadores()) {
            if (j == null) continue;

            for (Evento e : j.getEventos()) {
                if (e == null) continue;

                if (e.getTipo() == TipoEvento.TARJETA_AMARILLA) {
                    amarillas++;
                } else if (e.getTipo() == TipoEvento.TARJETA_ROJA) {
                    rojas++;
                } else if (e.getTipo() == TipoEvento.DOBLE_AMARILLA) {
                    dobleAmarilla++;
                }
            }
        }

        ArrayList<String> informe = new ArrayList<>();
        informe.add("Selección: " + seleccion.getNombreFederacion());
        informe.add("Tarjetas amarillas: " + amarillas);
        informe.add("Tarjetas rojas: " + rojas);
        informe.add("Dobles amarillas: " + dobleAmarilla);

        return informe;
    }

    /**
     * Genera el informe disciplinario de un jugador específico,
     * mostrando la cantidad de tarjetas amarillas, rojas y dobles amarillas.
     *
     * @param jugador El jugador del que se desea el informe.
     * @return Lista de Strings con el resumen, o null si el jugador es nulo.
     */
    public ArrayList<String> informePorJugador(Jugador jugador) {
        if (jugador == null) {
            return null;
        }

        int amarillas = 0;
        int rojas = 0;
        int dobleAmarilla = 0;

        for (Evento e : jugador.getEventos()) {
            if (e == null) continue;

            if (e.getTipo() == TipoEvento.TARJETA_AMARILLA) {
                amarillas++;
            } else if (e.getTipo() == TipoEvento.TARJETA_ROJA) {
                rojas++;
            } else if (e.getTipo() == TipoEvento.DOBLE_AMARILLA) {
                dobleAmarilla++;
            }
        }

        ArrayList<String> informe = new ArrayList<>();
        informe.add("Jugador: " + jugador.getNombre());
        informe.add("Tarjetas amarillas: " + amarillas);
        informe.add("Tarjetas rojas: " + rojas);
        informe.add("Dobles amarillas: " + dobleAmarilla);

        return informe;
    }
}