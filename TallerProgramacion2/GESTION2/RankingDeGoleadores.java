package GESTION2;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import CLASES.Jugador;
import CLASES.Seleccion;

/**
 * Se encarga de procesar las estadísticas individuales de anotaciones para 
 * confeccionar el ranking descendente de los máximos anotadores del torneo.
 * * @author Florencia Benitez
 * @author Agustina Barreto
 * @author Francia Maira
 * @author Gabriela Yañez
 */
public class RankingDeGoleadores {

    /**
     * Genera el ranking de goleadores de una selección específica,
     * ordenado por cantidad de goles de mayor a menor.
     *
     * @param seleccion La selección de la que se desea el ranking.
     * @return Lista de Strings con posición, nombre y goles, o null si es nula.
     */
    public ArrayList<String> rankingPorSeleccion(Seleccion seleccion) {
        //control de seguridad 
        if (seleccion == null) {
            return null;
        }
        // Creamos una copia de la lista original para proteger los datos de la Selección
        ArrayList<Jugador> jugadores = new ArrayList<>(seleccion.getJugadores());
        // NOTA DE DISEÑO (Complejidad y Consistencia):
        // Se optó por mantener las llamadas a contarGoles() dentro del Comparator debido a que 
        // el tamaño del plantel es acotado y constante (N <= 26 jugadores). A diferencia de la 
        // tabla de posiciones por grupo (donde el cálculo de puntos involucra cruces de partidos 
        // y rivales), el impacto en la complejidad temporal aquí es despreciable.
        // Esto nos permite priorizar la legibilidad y simplicidad del código sin penalizar 
        // el rendimiento real de la aplicación.
        Collections.sort(jugadores, new Comparator<Jugador>() {
            @Override
            public int compare(Jugador a, Jugador b) {
                // Usamos Integer.compare por seguridad, pero al revés (b, a) para orden descendente
                return Integer.compare(b.contarGoles(), a.contarGoles());
            }
        });
        // Generación del reporte de texto para el ranking
        ArrayList<String> ranking = new ArrayList<>();
        int posicion = 1; //va a servir para llevar el nr de puesto
        // Recorremos la lista clonada que ya se encuentra ordenada por goles
        for (Jugador j : jugadores) {
            // Filtro de exclusión: solo entran al reporte los jugadores con al menos un gol anotado
            if (j != null && j.contarGoles() > 0) {
                ranking.add(posicion + ". " + j.getNombre()
                        + " - " + j.contarGoles() + " goles");
                posicion++; // Incrementa el contador de puesto en la tabla
            }
        }

        // Si ningún jugador convirtió goles, informamos
        if (ranking.isEmpty()) {
            ranking.add("Sin goleadores registrados para " + seleccion.getNombreFederacion());
        }

        return ranking;
    }
}