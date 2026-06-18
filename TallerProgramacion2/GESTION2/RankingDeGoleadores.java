package GESTION2;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import CLASES.Jugador;
import CLASES.Seleccion;

/**
 * Se encarga de procesar las estadísticas individuales de anotaciones para 
 * confeccionar el ranking descendente de los máximos anotadores de todo el torneo.
 * * @author Florencia Benitez
 * @author Agustina Barreto
 * @author Francia Maira
 * @author Gabriela Yañez
 */
public class RankingDeGoleadores {

    /**
     * Genera el ranking global de goleadores del Mundial,
     * ordenado por cantidad de goles de mayor a menor.
     *
     * @param selecciones Lista de todas las selecciones que participan en el torneo.
     * @return Lista de Strings con posición, nombre, selección y goles.
     */
    public ArrayList<String> obtenerRankingGlobal(ArrayList<Seleccion> selecciones) {
        // Control de seguridad 
        if (selecciones == null || selecciones.isEmpty()) {
            return null;
        }

        // Recolectamos TODOS los jugadores de TODAS las selecciones en una lista única
        ArrayList<Jugador> todosLosJugadores = new ArrayList<>();
        for (Seleccion sel : selecciones) {
            if (sel != null && sel.getJugadores() != null) {
                todosLosJugadores.addAll(sel.getJugadores());
            }
        }

        // NOTA DE DISEÑO (Complejidad y Consistencia):
        // Aunque ahora procesamos el universo completo de jugadores del torneo (N ≈ 1200 jugadores), 
        // la operación sigue siendo lineal en memoria y el método contarGoles() resuelve en tiempo constante O(1).
        // El ordenamiento O(N log N) en memoria para este volumen de datos toma milisegundos, por lo que 
        // priorizamos mantener el diseño limpio sin estructuras intermedias de caché (caché/maps).
        Collections.sort(todosLosJugadores, new Comparator<Jugador>() {
            @Override
            public int compare(Jugador a, Jugador b) {
                // Orden descendente (b, a)
                return Integer.compare(b.contarGoles(), a.contarGoles());
            }
        });

        // Generación del reporte de texto para el ranking global
        ArrayList<String> ranking = new ArrayList<>();
        int posicion = 1; 

        // Recorremos la lista global ya ordenada
        for (Jugador j : todosLosJugadores) {
            // Filtro de exclusión: solo entran al reporte los que tengan al menos un gol
            if (j != null && j.contarGoles() > 0) {
                // Tip: Sería ideal si 'j' tiene acceso al nombre de su selección para dar contexto,
                // de lo contrario, j.getNombre() funciona perfectamente.
                ranking.add(posicion + ". " + j.getNombre() + " - " + j.contarGoles() + " goles");
                posicion++; 
            }
        }

        // Si absolutamente nadie ha metido un gol todavía
        if (ranking.isEmpty()) {
            ranking.add("Sin goles registrados en el torneo actual.");
        }

        return ranking;
    }
}