package GESTION1;

import java.util.ArrayList;

import CLASES.*;
import EXCEPCIONES.*;

/* Gestionar los Países participantes, sus
Selecciones, cuerpos técnicos y la lista de Jugadores. */

public class AdministracionDelegaciones {

    /**
     * Vincula una Selección a su correspondiente País y la asigna a un Grupo.
     * Asegura la consistencia bidireccional entre País y Selección.
     * @param pais El objeto Pais participante.
     * @param seleccion La Seleccion nacional que representa al país.
     * @param grupo El Grupo de la primera fase donde jugará la selección.
     * @throws ValoresNulosException si alguno de los parámetros es null.
     * @throws SeleccionYaRegistradaException si la selección ya está vinculada.
     */
    public void gestionarSeleccion(Pais pais, Seleccion seleccion, Grupo grupo) 
            throws ValoresNulosException, SeleccionYaRegistradaException {
        if (pais == null || seleccion == null || grupo == null) {
            throw new ValoresNulosException("pais, seleccion o grupo");
        }
        if (seleccion.getPais() != null || grupo.getSelecciones().contains(seleccion)) {
            throw new SeleccionYaRegistradaException(seleccion.getNombreFederacion());
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
    }

    // Lista de control global interna para asegurar que un jugador no se repita entodo el torneo
    private ArrayList<Jugador> jugadoresAsignadosGlobal = new ArrayList<>();

    /**
     * Añade un Jugador a la lista de una Selección, controlando que no esté
     * asignado a otra delegación del torneo.
     * @param seleccion La Selección a la que se integrará el jugador.
     * @param nuevoJugador El objeto Jugador que se desea registrar.
     * @throws ValoresNulosException si selección o jugador es null.
     * @throws JugadorDuplicadoException si el jugador ya está asignado a otra selección.
     */
    public void registrarJugador(Seleccion seleccion, Jugador nuevoJugador) 
            throws ValoresNulosException, JugadorDuplicadoException {
        if (seleccion == null || nuevoJugador == null) {
            throw new ValoresNulosException("seleccion o nuevoJugador");
        }

        // Recorremos y comparamos a mano para evitar use de contains
        for (Jugador j : jugadoresAsignadosGlobal) {
            if (j.getNombre() != null && j.getNombre().equalsIgnoreCase(nuevoJugador.getNombre()) &&
                    j.getFecNacimiento() == nuevoJugador.getFecNacimiento()) {
                throw new JugadorDuplicadoException(nuevoJugador.getNombre());
            }
        }

        // Si el for terminó y no encontró a nadie igual, recién ahí lo agregamos
        if (seleccion.getJugadores() != null) {
            seleccion.agregarJugador(nuevoJugador);
            jugadoresAsignadosGlobal.add(nuevoJugador);
        }
    }

    /**
     * Registra un Director Técnico en la lista de una Selección.
     * @param seleccion La Selección a la que se asignará el DT.
     * @param dt El objeto DirectorTecnico correspondiente.
     * @throws ValoresNulosException si selección o director es null.
     * @throws ElementoDuplicadoException si el director ya está registrado.
     */
    public void registrarDirectorTecnico(Seleccion seleccion, DirectoresTecnicos dt) 
            throws ValoresNulosException, ElementoDuplicadoException {
        if (seleccion == null || dt == null) {
            throw new ValoresNulosException("seleccion o director tecnico");
        }

        if (seleccion.getDirectoresTecnicos() != null && seleccion.getDirectoresTecnicos().contains(dt)) {
            throw new ElementoDuplicadoException("Director técnico " + dt.getNombre());
        }

        if (seleccion.getDirectoresTecnicos() != null) {
            seleccion.agregarDirectoresTecnicos(dt);
        }
    }

    /**
     * Registra un miembro del Cuerpo Técnico en una Selección.
     * @param seleccion La Selección donde cumplirá funciones el integrante.
     * @param integrante El miembro del CuerpoTecnico a incorporar.
     * @throws ValoresNulosException si selección o integrante es null.
     * @throws ElementoDuplicadoException si el integrante ya está registrado.
     */
    public void registrarCuerpoTecnico(Seleccion seleccion, CuerpoTecnico integrante) 
            throws ValoresNulosException, ElementoDuplicadoException {
        if (seleccion == null || integrante == null) {
            throw new ValoresNulosException("seleccion o integrante");
        }

        if (seleccion.getCuerposTecnicos() != null && seleccion.getCuerposTecnicos().contains(integrante)) {
            throw new ElementoDuplicadoException("Integrante " + integrante.getNombre());
        }

        if (seleccion.getCuerposTecnicos() != null) {
            seleccion.agregarCuerpoTecnico(integrante);
        }
    }

}
