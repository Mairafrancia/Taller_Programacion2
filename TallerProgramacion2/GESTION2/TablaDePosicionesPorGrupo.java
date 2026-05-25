package GESTION2;
import CLASES.*;
import java.util.ArrayList;
//import java.util.Collections;
//import java.util.Comparator;

public class TablaDePosicionesPorGrupo {

    public ArrayList<String> obtenerTablaPosiciones(Grupo grupo) {
        if (grupo == null) {
            return null;
        }

        // 1. Copia defensiva de las selecciones del grupo
        ArrayList<Seleccion> selecciones = new ArrayList<>(grupo.getSelecciones());
        int n = selecciones.size();

        // 2. Calculamos los puntos UNA SOLA VEZ y los guardamos en la misma posición indexada
        int[] puntos = new int[n];
        for (int i = 0; i < n; i++) {
            puntos[i] = grupo.obtenerPuntos(selecciones.get(i));
        }

        // 3. Creamos una lista de índices (0, 1, 2, ..., n-1)
        ArrayList<Integer> indices = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            indices.add(i);
        }

        // 4. Ordenamos los ÍNDICES basándonos en los valores del array de puntos (de Mayor a Menor)
        indices.sort((i1, i2) -> Integer.compare(puntos[i2], puntos[i1]));

        // 5. Construimos el resultado final recorriendo los índices ya ordenados
        ArrayList<String> tabla = new ArrayList<>();
        for (int pos = 0; pos < n; pos++) {
            int idx = indices.get(pos); // Obtenemos el índice real de la selección en esa posición
            
            Seleccion sel = selecciones.get(idx);
            int pts = puntos[idx];
            
            tabla.add((pos + 1) + ". " + sel.getNombreFederacion() + " - " + pts + " pts");
        }

        return tabla;
    }
}