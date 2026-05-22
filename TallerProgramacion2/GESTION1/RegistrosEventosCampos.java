package GESTION1;

import CLASES.*;

public class RegistrosEventosCampos {

    public boolean registrarEventoDeCampo(Partido partido, TipoEvento tipo, int minuto, Jugador jugador) {
        // Validaciones básicas
        if (partido == null || tipo == null || jugador == null || minuto < 0) {
            return false;
        }
        if (!partido.contieneJugador(jugador)) { //ESTE METODO LO PUSE EN LA CLASE PARTIDO, ESTA PARA CONTROLAR Q EL JUGADOR ESTE EN ESTE PARTIDO
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