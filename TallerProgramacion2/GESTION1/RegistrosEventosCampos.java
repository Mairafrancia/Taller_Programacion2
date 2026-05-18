package GESTION1;

import CLASES.*;

/* Registro de Eventos de Campo: Durante los partidos, se deben registrar los
Eventos en tiempo real detallando entre otros el minuto y el jugador involucrado */

public class RegistrosEventosCampos {

    public void registrarEventoDeCampo(Partido partido, TipoEvento tipo, int minuto, Jugador jugador) {
        // 1. Crear la instancia del Evento
        Evento nuevoEvento = new Evento();
        // 2. Configurar los datos (minuto, tipo y jugador)
        nuevoEvento.setTipo(tipo); 
        nuevoEvento.setMinuto(minuto);
        nuevoEvento.setJugador(jugador);
        // 3. Vincular el evento al partido
        // Como es composición, el partido lo guarda en su lista interna
        partido.agregarEvento(nuevoEvento);
        System.out.println("Evento registrado en el partido: " + tipo + " - Minuto: " + minuto);
    }
}
