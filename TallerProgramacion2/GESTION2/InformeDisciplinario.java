package GESTION2;

import CLASES.*;
import java.util.ArrayList;

public class InformeDisciplinario {

    // Constantes para evitar "números mágicos" y mejorar la lectura de los índices del array
    private static final int AMARILLAS = 0;
    private static final int ROJAS = 1;
    private static final int DOBLES = 2;

    /**
     * Método privado auxiliar para no repetir la lógica de conteo de tarjetas.
     * Retorna un array de enteros mapeado por las constantes de la clase.
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