package GESTION2;

import CLASES.*;
import java.util.ArrayList;

public class TablaDePosicionesPorGrupo {

    /**
     * Genera la tabla de posiciones de un grupo, ordenada por puntos de mayor a menor.
     * Utiliza Grupo.obtenerPuntos() para calcular los puntos de cada selección,
     * filtrando únicamente los partidos correspondientes a la fase del grupo.
     *
     * @param grupo El grupo del que se desea obtener la tabla.
     * @return Lista de Strings con la posición, nombre y puntos de cada selección,
     *         o null si el grupo es nulo.
     */
    public ArrayList<String> obtenerTablaPosiciones(Grupo grupo) {
        if (grupo == null) {
            return null;
        }

        // Copia defensiva para no modificar el orden original del grupo
        ArrayList<Seleccion> selecciones = new ArrayList<>(grupo.getSelecciones());
        int n = selecciones.size();

        // Calculamos los puntos de cada selección en un array paralelo
        int[] puntos = new int[n];
        for (int i = 0; i < n; i++) {
            puntos[i] = grupo.obtenerPuntos(selecciones.get(i));
        }

        // Ordenamos por puntos de mayor a menor (burbuja)
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - 1 - i; j++) {
                if (puntos[j] < puntos[j + 1]) {
                    // Intercambiamos puntos
                    int tempPuntos = puntos[j];
                    puntos[j] = puntos[j + 1];
                    puntos[j + 1] = tempPuntos;
                    // Intercambiamos selecciones en paralelo
                    Seleccion tempSel = selecciones.get(j);
                    selecciones.set(j, selecciones.get(j + 1));
                    selecciones.set(j + 1, tempSel);
                }
            }
        }

        // Construimos el resultado
        ArrayList<String> tabla = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            tabla.add((i + 1) + ". " + selecciones.get(i).getNombreFederacion()
                    + " - " + puntos[i] + " pts");
        }

        return tabla;
    }
}