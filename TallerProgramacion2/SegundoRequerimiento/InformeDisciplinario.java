package SegundoRequerimiento;

import taller_programacion2.*;
// import java.util.ArrayList;

public class InformeDisciplinario {

    public void listadoTarjetasPorJugador(Jugador jugador) {
        System.out.println("Tarjetas del jugador " + jugador.getNombre() + ":");
        for (Evento evento : jugador.getEventos()) {
            if (evento.getTipo() == TipoEvento.TARJETAAMARILLA ||
                evento.getTipo() == TipoEvento.TARJETAROJA ||
                evento.getTipo() == TipoEvento.DOBLEAMARILLA) {
                System.out.println("- " + evento.getTipo() + " en el minuto " + evento.getMinuto());
            }
        }
    }

    public void listadoTarjetasPorSeleccion(Seleccion seleccion) {
        System.out.println("Tarjetas de la selección " + seleccion.getNombreFederacion() + ":");
        for (Jugador jugador : seleccion.getJugadores()) {
            for (Evento evento : jugador.getEventos()) {
                if (evento.getTipo() == TipoEvento.TARJETAAMARILLA ||
                    evento.getTipo() == TipoEvento.TARJETAROJA ||
                    evento.getTipo() == TipoEvento.DOBLEAMARILLA) {
                    System.out.println("- Jugador: " + jugador.getNombre() + ", " + evento.getTipo() + " en el minuto " + evento.getMinuto());
                }
            }
        }
    }
}
