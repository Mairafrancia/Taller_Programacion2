package GESTION2;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import CLASES.Jugador;
import CLASES.Seleccion;

/**
 * Se encarga de procesar las estadísticas individuales de anotaciones para 
 * confeccionar el ranking descendente de los máximos anotadores de todo el torneo.
 *
 * @author Florencia Benitez
 * @author Agustina Barreto
 * @author Francia Maira
 * @author Gabriela Yañez
 */
public class RankingDeGoleadores {

    /**
     * Busca a qué selección pertenece un jugador recorriendo la lista de selecciones.
     *
     * @param jugador     El jugador a buscar.
     * @param selecciones Lista de todas las selecciones del torneo.
     * @return El nombre de la federación, o "Selección desconocida" si no se encuentra.
     */
    private String obtenerNombreSeleccion(Jugador jugador, ArrayList<Seleccion> selecciones) {
        for (Seleccion sel : selecciones) {
            if (sel != null && sel.getJugadores() != null && sel.getJugadores().contains(jugador)) {
                return sel.getNombreFederacion();
            }
        }
        return "Seleccion desconocida";
    }

    /**
     * Genera el ranking global de goleadores del Mundial,
     * ordenado por cantidad de goles de mayor a menor.
     * Incluye el nombre de la selección a la que pertenece cada jugador.
     *
     * @param selecciones Lista de todas las selecciones que participan en el torneo.
     * @return Lista de Strings con posición, nombre, selección y goles.
     */
    public ArrayList<String> obtenerRankingGlobal(ArrayList<Seleccion> selecciones) {
        if (selecciones == null || selecciones.isEmpty()) {
            return null;
        }

        ArrayList<Jugador> todosLosJugadores = new ArrayList<>();
        for (Seleccion sel : selecciones) {
            if (sel != null && sel.getJugadores() != null) {
                todosLosJugadores.addAll(sel.getJugadores());
            }
        }

        Collections.sort(todosLosJugadores, new Comparator<Jugador>() {
            @Override
            public int compare(Jugador a, Jugador b) {
                return Integer.compare(b.contarGoles(), a.contarGoles());
            }
        });

        ArrayList<String> ranking = new ArrayList<>();
        int posicion = 1;

        for (Jugador j : todosLosJugadores) {
            if (j != null && j.contarGoles() > 0) {
                String nombreSel = obtenerNombreSeleccion(j, selecciones);
                ranking.add(posicion + ". " + j.getNombre() + " (" + nombreSel + ") - " + j.contarGoles() + (j.contarGoles() == 1 ? " gol" : " goles"));
                posicion++;
            }
        }

        if (ranking.isEmpty()) {
            ranking.add("Sin goles registrados en el torneo actual.");
        }

        return ranking;
    }
}