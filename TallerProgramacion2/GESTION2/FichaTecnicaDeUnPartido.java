package GESTION2;

import CLASES.*;
import java.util.ArrayList;

/**
 * Se encarga de recopilar, estructurar y generar la información detallada de 
 * un encuentro específico para su posterior visualización o impresión.
 * * @author Florencia Benitez
 * @author Agustina Barreto
 * @author Francia Maira
 * @author Gabriela Yañez
 */
public class FichaTecnicaDeUnPartido {

    /**
     * Genera la ficha técnica completa de un partido, incluyendo
     * alineaciones, eventos y resultado final.
     *
     * @param partido El partido del que se desea la ficha técnica.
     * @return Lista de Strings con el detalle completo, o null si el partido es nulo.
     */
    public ArrayList<String> obtenerFicha(Partido partido) {
        if (partido == null) {
            return null;
        }

        Participacion local = partido.getParticipacionLocal();
        Participacion visitante = partido.getParticipacionVisitante();

        ArrayList<String> ficha = new ArrayList<>();

        // ENCABEZADO
        ficha.add("=== FICHA TÉCNICA DE PARTIDO ===");
        ficha.add("Fecha: " + partido.getFecha());
        ficha.add("Horario: " + partido.getHorario());
        if (partido.getEstadio() != null) {
            ficha.add("Estadio: " + partido.getEstadio().getNombre());
        }

        ficha.add("--- Resultado Final ---");
        if (local != null && visitante != null) {
            int golesLocal = local.cantidadGoles();
            int golesVisitante = visitante.cantidadGoles();
            
            String nombreLocal = (local.getSeleccion() != null) ? local.getSeleccion().getNombreFederacion() : "Local";
            String nombreVisitante = (visitante.getSeleccion() != null) ? visitante.getSeleccion().getNombreFederacion() : "Visitante";
            
            ficha.add(nombreLocal + " " + golesLocal + " - " + golesVisitante + " " + nombreVisitante);
        } else {
            ficha.add("Resultado no disponible");
        }

        // ALINEACIÓN LOCAL
        ficha.add("--- Alineación Local ---");
        if (local != null && local.getSeleccion() != null) {
            ficha.add("Selección: " + local.getSeleccion().getNombreFederacion());
            for (Jugador j : local.getSeleccion().getJugadores()) {
                if (j != null) {
                    ficha.add("  " + j.getDorsal() + " - " + j.getNombre());
                }
            }
        } else {
            ficha.add("Alineación local no disponible");
        }

        // ALINEACIÓN VISITANTE
        ficha.add("--- Alineación Visitante ---");
        if (visitante != null && visitante.getSeleccion() != null) {
            ficha.add("Selección: " + visitante.getSeleccion().getNombreFederacion());
            for (Jugador j : visitante.getSeleccion().getJugadores()) {
                if (j != null) {
                    ficha.add("  " + j.getDorsal() + " - " + j.getNombre());
                }
            }
        } else {
            ficha.add("Alineación visitante no disponible");
        }

        // EVENTOS DEL PARTIDO
        ficha.add("--- Eventos ---");
        if (partido.getEventos() == null || partido.getEventos().isEmpty()) {
            ficha.add("Sin eventos registrados");
        } else {
            for (Evento e : partido.getEventos()) {
                if (e != null) {
                    String jugadorNombre = (e.getJugador() != null) ? e.getJugador().getNombre() : "Desconocido";
                    ficha.add("  Min " + e.getMinuto() + " - " + e.getTipo() + " - " + jugadorNombre);
                }
            }
        }
        return ficha;
    }
}