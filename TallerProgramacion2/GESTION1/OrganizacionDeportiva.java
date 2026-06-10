package GESTION1;

import CLASES.*;
import EXCEPCIONES.*;

public class OrganizacionDeportiva {

    /**
     * Vincula un Grupo a una Fase determinada del torneo.
     * Asegura la consistencia de la relación Fase 1 --- 1..* Grupo.
     * 
     * @param fase  La Fase (ej. Grupos, Octavos, etc.) a la que pertenecerá el grupo.
     * @param grupo El Grupo que se desea registrar en la fase.
     * @throws ValoresNulosException si fase o grupo es null.
     * @throws ElementoDuplicadoException si el grupo ya está registrado en la fase.
     */
    public void registrarGrupoEnFase(Fase fase, Grupo grupo) 
            throws ValoresNulosException, ElementoDuplicadoException {
        if (fase == null || grupo == null) {
            throw new ValoresNulosException("fase o grupo");
        }

        // Verificamos si la fase ya tiene un grupo con el mismo identificador
        if (fase.getGrupos() != null) {
            for (Grupo g : fase.getGrupos()) {
                if (g != null && g.getIdentificador() != null && grupo.getIdentificador() != null
                        && g.getIdentificador().equalsIgnoreCase(grupo.getIdentificador())) {
                    throw new ElementoDuplicadoException("Grupo " + grupo.getIdentificador());
                }
            }
        }

        // Relación bidireccional: el grupo conoce su fase
        grupo.setFase(fase);

        // La fase incorpora el grupo a su lista interna utilizando el método de Fase
        if (fase.getGrupos() != null) {
            fase.agregarGrupo(grupo);
        }
    }

    /**
     * Planifica un Partido asignándole su Fase de competencia y el Estadio donde se jugará.
     * Al mismo tiempo, vincula el partido a la lista de partidos programados en ese Estadio.
     * @param partido El Partido que se está planificando.
     * @param fase La Fase a la que corresponde el encuentro.
     * @param estadio El Estadio donde se disputará.
     * @throws ValoresNulosException si alguno de los parámetros es null.
     */
    public void planificarPartido(Partido partido, Fase fase, Estadio estadio) 
            throws ValoresNulosException {
        if (partido == null || fase == null || estadio == null) {
            throw new ValoresNulosException("partido, fase o estadio");
        }

        // Asignamos la fase y el estadio al partido
        partido.setFase(fase);
        partido.setEstadio(estadio);

        // Consistencia bidireccional con Estadio: agregamos el partido a la lista del estadio
        if (estadio.getPartidos() != null && !estadio.getPartidos().contains(partido)) {
            estadio.agregarPartido(partido);
        }
    }

    /**
     * Establece los dos equipos (Participaciones) que se enfrentarán en un Partido ya planificado.
     * Utiliza el método de control interno del partido para validar localía/visitante.
     * @param partido El Partido donde se jugarán las participaciones.
     * @param local La Participación del equipo que será local.
     * @param visitante La Participación del equipo que será visitante.
     * @throws ValoresNulosException si alguna participación es null.
     * @throws ParticipacionInvalidaException si ambas tienen la misma localía.
     */
    public void asignarEquiposAPartido(Partido partido, Participacion local, Participacion visitante) 
            throws ValoresNulosException, ParticipacionInvalidaException {
        if (partido == null || local == null || visitante == null) {
            throw new ValoresNulosException("partido, local o visitante");
        }

        // Controlamos que cumplan las condiciones antes de asignar: uno debe ser local y el otro no
        if (local.isEsLocal() == visitante.isEsLocal()) {
            throw new ParticipacionInvalidaException();
        }

        // Seteamos de forma bidireccional en las participaciones el partido que van a jugar
        local.setPartido(partido);
        visitante.setPartido(partido);

        // Usamos el método de la clase Partido para asignarlas en el array de tamaño 2
        partido.asignarParticipaciones(local, visitante);

         if (local.getSeleccion() != null) {
            local.getSeleccion().agregarParticipacion(local);
        }
        if (visitante.getSeleccion() != null) {
            visitante.getSeleccion().agregarParticipacion(visitante);
        }
    }
}

//     public Fase crearFaseDeEliminacion(NombreFase nombre) { // Crea una fase de eliminación directa (Dieciseisavos,
//                                                             // Octavos, Cuartos, Semifinal, Final).
//         if (nombre == null || NombreFase.GRUPOS.equals(nombre)) { // no acepta NombreFase.GRUPOS porque esa fase se va a
//                                                                   // crear en crearFaseDeGrupos()
//             return null; // o lanzar excepción
//         }
//         return new Fase(nombre);
//     }

//     public Fase crearFaseDeGrupos() { // creamos solo fases de tipo grupos
//         return new Fase(NombreFase.GRUPOS);
//     }

//     public boolean agregarGrupoAFase(Fase faseExistente, String idGrupo, String desc) {
//         if (faseExistente == null || idGrupo == null || idGrupo.isEmpty()) {
//             return false;
//         }
//         if (!NombreFase.GRUPOS.equals(faseExistente.getNombre())) { // buaco que solo sea valido si la fase es de tipo
//                                                                     // GRUPOS
//             return false;
//         }
//         Grupo nuevoGrupo = new Grupo(idGrupo, desc, faseExistente);
//         faseExistente.agregarGrupo(nuevoGrupo); // agrego el nuevo grupo a la fase pasada por parametro
//         return true;
//     }

//     // Este método planifica un partido, validando datos y controlando duplicados.
//     // controles agregados
//     public boolean planificarPartido(Fase fase, Estadio estadio, Seleccion local, Seleccion visitante, int fecha,
//             int horario) {
//         if (fase == null || estadio == null || local == null || visitante == null) {
//             return false;
//         }
//         if (local == visitante) {
//             return false;
//         }
//         if (fecha <= 0 || horario <= 0) {
//             return false;
//         }

//         Partido partido = new Partido();
//         partido.setFecha(fecha);
//         partido.setHorario(horario);
//         partido.setEstadio(estadio);
//         partido.setFase(fase);

//         if (fase.getPartidos().contains(partido) || estadio.getPartidos().contains(partido)) {
//             return false;
//         }

//         Participacion pLocal = new Participacion();
//         pLocal.setEsLocal(true);
//         pLocal.setSeleccion(local);

//         Participacion pVisitante = new Participacion();
//         pVisitante.setEsLocal(false);
//         pVisitante.setSeleccion(visitante);

//         partido.asignarParticipaciones(pLocal, pVisitante);
//         pLocal.setPartido(partido);
//         pVisitante.setPartido(partido);
//         estadio.agregarPartido(partido);
//         fase.agregarPartido(partido);
//         return true;
//     }

// }
