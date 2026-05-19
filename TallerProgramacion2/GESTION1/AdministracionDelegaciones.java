package GESTION1;

import CLASES.*;
/* Gestionar los Países participantes, sus
Selecciones, cuerpos técnicos y la lista de Jugadores. */

public class AdministracionDelegaciones {

    // Cambiamos el enfoque: El país se registra al crearlo,
    // pero se vincula al mundial a través de su Sede.

    // Vincula un país con una sede y asegura que esa sede esté registrada en el
    // Mundial.

    // Asocia una selección a un país y la asigna al grupo correspondiente.
    public void gestionarSeleccion(Pais pais, Seleccion seleccion, Grupo grupo) {
        if (pais == null || seleccion == null || grupo == null) {
            return;
        }
        if (seleccion.getPais() != null || grupo.getSelecciones().contains(seleccion)) {
            return;
        }

        // Vincular la selección con el país (Relación 1 a 1)
        pais.setSeleccion(seleccion);
        seleccion.setPais(pais);

        // Asignar la selección a un grupo (Relación * a 1)
        seleccion.setGrupo(grupo);
        grupo.agregarSeleccion(seleccion);
    }

    // Añade un jugador a una selección si no está ya presente en esa selección.
    // Verifica solo la selección actual para evitar duplicar el mismo jugador
    // dentro de la misma selección.

    public boolean registrarJugador(Seleccion seleccion, Jugador nuevoJugador) {
        if (seleccion == null || nuevoJugador == null) {
            return false;
        }

        if (seleccion.getJugadores().contains(nuevoJugador)) {
            return false; // El jugador ya está registrado en la misma selección
        }

        seleccion.agregarJugador(nuevoJugador);
        return true;
    }

    // Registra un integrante del cuerpo técnico en la selección correspondiente.
    //control agregado 
    public boolean registrarCuerpoTecnico(Seleccion seleccion, CuerpoTecnico integrante) {
        if (seleccion == null || integrante == null) {
            return false;
        }

        if (seleccion.getCuerposTecnicos().contains(integrante)) {
            return false; // El integrante ya está registrado en la selección
        }

        seleccion.agregarCuerpoTecnico(integrante);
        return true;
    }

}
