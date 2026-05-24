package GESTION1;

import CLASES.*;

public class RegistrosEventosCampos {

    /**
     * Registra un evento ocurrido en un partido en tiempo real, vinculándolo
     * tanto al Partido donde sucedió como al Jugador que lo protagonizó.
     * Asegura la consistencia bidireccional de la información.
     * 
     * @param partido     El Partido en el cual sucede el evento.
     * @param jugador     El Jugador que cometió o protagonizó el evento.
     * @param nuevoEvento El objeto Evento (ya creado con su minuto y tipo).
     * @return true si el evento se registró con éxito en ambos lados; false si hubo
     *         nulos.
     */

    public boolean registrarEventoDeCampo(Partido partido, Jugador jugador, Evento nuevoEvento) {
        // int minuto, TipoEvento tipo lo saque de los parametros pq evento los tiene en
        // sus atributos

        // Validamos que ningún componente clave sea nulo
        if (partido == null || nuevoEvento == null || jugador == null) {
            return false;
        }

        // Vinculamos el jugador al evento (El evento guarda internamente quién lo hizo)
        nuevoEvento.setJugador(jugador);

        // Registramos el evento en el Partido (usando el método que ya tenemmos en Partido)
        if (partido.getEventos() != null) {
            partido.agregarEvento(nuevoEvento);
        } else {
            return false; // Si la lista del partido no existe, fallamos de forma segura
        }

        // Registramos el evento en el Jugador (usando el método que ya tenemos en Jugador)
        if (jugador.getEventos() != null) {
            jugador.agregarEvento(nuevoEvento);
            return true; // Éxito rotundo en la doble asignación, sin imprimir nada
        }

        return false;

        // if (!partido.contieneJugador(jugador)) { //ESTE METODO LO PUSE EN LA CLASE
        // PARTIDO, ESTA PARA CONTROLAR Q EL JUGADOR ESTE EN ESTE PARTIDO
        // return false;
        // }

        // Evento nuevoEvento = new Evento();
        // nuevoEvento.setTipo(tipo);
        // nuevoEvento.setMinuto(minuto);
        // nuevoEvento.setJugador(jugador);

        // partido.agregarEvento(nuevoEvento);
        // return true;
    }
}