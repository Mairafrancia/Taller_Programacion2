package GESTION1;

import java.util.ArrayList;

import CLASES.*;
/* Gestionar los Países participantes, sus
Selecciones, cuerpos técnicos y la lista de Jugadores. */

public class AdministracionDelegaciones {

    /**
     * Vincula una Selección a su correspondiente País y la asigna a un Grupo
     * inicial.
     * Asegura la consistencia bidireccional entre País y Selección.
     * * @param pais El objeto Pais participante.
     * 
     * @param seleccion La Seleccion nacional que representa al país.
     * @param grupo     El Grupo de la primera fase donde jugará la selección.
     * @return true si se gestionó la selección con éxito; false si hubo valores
     *         nulos.
     */

    public boolean gestionarSeleccion(Pais pais, Seleccion seleccion, Grupo grupo) {
        if (pais == null || seleccion == null || grupo == null) {
            return false;
        }
        if (seleccion.getPais() != null || grupo.getSelecciones().contains(seleccion)) {
            return false;
        }

        // Relación bidireccional entre País y Selección
        pais.setSeleccion(seleccion);
        seleccion.setPais(pais);

        // Asignar la selección a un grupo (Relación * a 1)
        seleccion.setGrupo(grupo);

        // Agregamos la selección a la lista interna del grupo si no estaba
        if (grupo.getSelecciones() != null && !grupo.getSelecciones().contains(seleccion)) {
            grupo.agregarSeleccion(seleccion);
        }

        return true;

    }

    // Lista de control global interna para asegurar que un jugador no se repita entodo el torneo
    private ArrayList<Jugador> jugadoresAsignadosGlobal = new ArrayList<>();

    /**
     * Añade un Jugador a la lista de una Selección, controlando rigurosamente
     * mediante lógica tradicional que no haya sido asignado a otra delegación del
     * torneo.
     * * @param seleccion La Selección a la que se integrará el jugador.
     * 
     * @param nuevoJugador El objeto Jugador que se desea registrar.
     * @return true si el jugador se registró con éxito; false si ya pertenecía a
     *         otra selección o hubo nulos.
     */

    public boolean registrarJugador(Seleccion seleccion, Jugador nuevoJugador) {
        if (seleccion == null || nuevoJugador == null) {
            return false;
        }

        // if (seleccion.getJugadores().contains(nuevoJugador)) {
        // return false; // El jugador ya está registrado en la misma selección
        // }

        // NO USAMOS CONTAINS. Recorremos y comparamos a mano:
        for (Jugador j : jugadoresAsignadosGlobal) {
            if (j.getNombre() != null && j.getNombre().equalsIgnoreCase(nuevoJugador.getNombre()) &&
                    j.getFecNacimiento() == nuevoJugador.getFecNacimiento()) {

                return false; // Si coincide el nombre y la fecha, ya existe en el mundial. Corta acá.
            }
        }

        // Si el for terminó y no encontró a nadie igual, recién ahí lo agregamos
        if (seleccion.getJugadores() != null) {
            seleccion.agregarJugador(nuevoJugador); // Usamos el método de la clase Selección
            jugadoresAsignadosGlobal.add(nuevoJugador); // Lo guardamos en el control global
            return true;
        }

        return false;

        // seleccion.agregarJugador(nuevoJugador);
        // return true;
    }

    // Registra un integrante del cuerpo técnico en la selección correspondiente.
    // control agregado
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
