package GESTION2;
import CLASES.*;
import java.util.ArrayList;
//import java.util.Collections;
import java.util.Comparator;

public class TablaDePosicionesPorGrupo {

    public ArrayList<String> obtenerTablaPosiciones(Grupo grupo) {
        if (grupo == null) {
            return null;
        }

        // 1. Copia defensiva de las selecciones
        ArrayList<Seleccion> selecciones = new ArrayList<>(grupo.getSelecciones());

        // 2. Ordenamos la lista directamente usando un Comparator.
        // Comparamos los puntos calculados dinámicamente por el grupo de mayor a menor.
        selecciones.sort(new Comparator<Seleccion>(){
            @Override
            public int compare(Seleccion s1, Seleccion s2) {
                int puntosS1 = grupo.obtenerPuntos(s1);
                int puntosS2 = grupo.obtenerPuntos(s2);
                
                // Para ordenar de MAYOR a MENOR, comparamos s2 contra s1
                return Integer.compare(puntosS2, puntosS1); 
            }
        });

        // 3. Construimos el resultado formateado
        ArrayList<String> tabla = new ArrayList<>();
        for (int i = 0; i < selecciones.size(); i++) {
            Seleccion sel = selecciones.get(i);
            int pts = grupo.obtenerPuntos(sel);
            
            tabla.add((i + 1) + ". " + sel.getNombreFederacion() + " - " + pts + " pts");
        }

        return tabla;
    }
}
