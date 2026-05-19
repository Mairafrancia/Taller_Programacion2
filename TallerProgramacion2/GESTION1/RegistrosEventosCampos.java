package GESTION1;

import CLASES.*;

/* Registro de Eventos de Campo: Durante los partidos, se deben registrar los
Eventos en tiempo real detallando entre otros el minuto y el jugador involucrado */
//controles agregados

public class RegistrosEventosCampos {

    public boolean registrarEventoDeCampo(Partido partido, TipoEvento tipo, int minuto, Jugador jugador) {
        if (partido == null || tipo == null || jugador == null || minuto < 0) {
            return false;
        }

        Evento nuevoEvento = new Evento();
        nuevoEvento.setTipo(tipo);
        nuevoEvento.setMinuto(minuto);
        nuevoEvento.setJugador(jugador);

        partido.agregarEvento(nuevoEvento);
        return true;
    }
}
