package GESTION1;

import CLASES.*;
import EXCEPCIONES.*;

/**
 * Gestiona el registro y control de las incidencias o eventos deportivos que 
 * ocurren en el campo de juego durante el desarrollo de un partido.
 * @author Florencia Benitez
 * @author Agustina Barreto
 * @author Francia Maira
 * @author Gabriela Yañez
 */
public class RegistrosEventosCampos {

    /**
     * Registra un evento ocurrido en un partido en tiempo real, vinculándolo
     * tanto al Partido donde sucedió como al Jugador que lo protagonizó.
     * Asegura la consistencia bidireccional de la información.
     * @param partido El Partido en el cual sucede el evento.
     * @param jugador El Jugador que cometió o protagonizó el evento.
     * @param nuevoEvento El objeto Evento (ya creado con su minuto y tipo).
     * @throws ValoresNulosException si alguno de los parámetros es null.
     * @throws JugadorNoParticipaEnPartidoException si el jugador no participa en el partido.
     */
    public void registrarEventoDeCampo(Partido partido, Jugador jugador, Evento nuevoEvento) 
            throws ValoresNulosException, JugadorNoParticipaEnPartidoException {
        if (partido == null || nuevoEvento == null || jugador == null) {
            throw new ValoresNulosException("partido, jugador o evento");
        }

        if (!partido.contieneJugador(jugador)) {
            throw new JugadorNoParticipaEnPartidoException(jugador.getNombre());
        }

        nuevoEvento.setJugador(jugador);

        partido.agregarEvento(nuevoEvento);

        jugador.agregarEvento(nuevoEvento);
    }
}