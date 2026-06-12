package GESTION1;

import CLASES.*;
import EXCEPCIONES.*;

public class RegistrosEventosCampos {

    /**
     * Registra un evento ocurrido en un partido en tiempo real, vinculándolo
     * tanto al Partido donde sucedió como al Jugador que lo protagonizó.
     * Asegura la consistencia bidireccional de la información.
     * 
     * @param partido El Partido en el cual sucede el evento.
     * @param jugador El Jugador que cometió o protagonizó el evento.
     * @param nuevoEvento El objeto Evento (ya creado con su minuto y tipo).
     * @throws ValoresNulosException si alguno de los parámetros es null o las listas de eventos no existen.
     * @throws JugadorNoParticipaEnPartidoException si el jugador no participa en el partido.
     */
    public void registrarEventoDeCampo(Partido partido, Jugador jugador, Evento nuevoEvento) 
            throws ValoresNulosException, JugadorNoParticipaEnPartidoException {
        // Validamos que ningún componente clave sea nulo
        if (partido == null || nuevoEvento == null || jugador == null) {
            throw new ValoresNulosException("partido, jugador o evento");
        }

        // VALIDACIÓN CRÍTICA: El jugador debe participar en el partido
        if (!partido.contieneJugador(jugador)) {
            throw new JugadorNoParticipaEnPartidoException(jugador.getNombre());
        }

        // Vinculamos el jugador al evento (El evento guarda internamente quién lo hizo)
        nuevoEvento.setJugador(jugador);

        // Registramos el evento en el Partido (lanza excepciones si hay problemas)
        if (partido.getEventos() != null) {
            partido.getEventos().add(nuevoEvento);  // ← único cambio
        } else {
            throw new ValoresNulosException("lista de eventos del partido");
        }

        // Registramos el evento en el Jugador
        if (jugador.getEventos() != null) {
            jugador.agregarEvento(nuevoEvento);
        } else {
            throw new ValoresNulosException("lista de eventos del jugador");
        }
    }
}