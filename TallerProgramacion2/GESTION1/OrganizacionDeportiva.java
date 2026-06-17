package GESTION1;

import CLASES.*;
import EXCEPCIONES.*;

/**
 * Gestiona la organización deportiva de los encuentros del torneo mundial.
 * Se encarga de la distribución de grupos en fases, la planificación de partidos 
 * en estadios y la correcta asignación de equipos (participaciones) competidoras.
 * * @author Florencia Benitez
 * @author Agustina Barreto
 * @author Francia Maira
 * @author Gabriela Yañez
 */
public class OrganizacionDeportiva {

    /**
     * Vincula un Grupo a una Fase determinada del torneo.
     * Asegura la consistencia de la relación Fase 1 --- 1..* Grupo.
     * * @param fase  La Fase (ej. Grupos, Octavos, etc.) a la que pertenecerá el grupo.
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
     * * @param partido El Partido que se está planificando.
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
        fase.agregarPartido(partido);
        partido.setEstadio(estadio);

        // Consistencia bidireccional con Estadio: agregamos el partido a la lista del estadio
        if (estadio.getPartidos() != null && !estadio.getPartidos().contains(partido)) {
            estadio.agregarPartido(partido);
        }
    }

    /**
     * Establece los dos equipos (Participaciones) que se enfrentarán en un Partido ya planificado.
     * Utiliza el método de control interno del partido para validar localía/visitante.
     * * @param partido El Partido donde se jugarán las participaciones.
     * @param local La Participación del equipo que será local.
     * @param visitante La Participación del equipo que será visitante.
     * @throws ValoresNulosException si alguna participación o el partido es null.
     * @throws ParticipacionInvalidaException si ambas tienen la misma localía o el partido ya tiene equipos asignados.
     * @throws EquipoArbitralInvalidoException si se intenta asignar equipos sin que el partido cuente con un equipo de arbitraje válido.
     */
    public void asignarEquiposAPartido(Partido partido, Participacion local, Participacion visitante)
        throws ValoresNulosException, ParticipacionInvalidaException, EquipoArbitralInvalidoException {
        if (partido == null || local == null || visitante == null) {
            throw new ValoresNulosException("partido, local o visitante");
        }
        if (partido.getParticipacionLocal() != null || partido.getParticipacionVisitante() != null) {
            throw new ParticipacionInvalidaException("El partido ya tiene equipos asignados.");
        }
        if (!partido.tieneEquipoArbitralValido()) {
            throw new EquipoArbitralInvalidoException();
        }
        if (local.isEsLocal() == visitante.isEsLocal()) {
            throw new ParticipacionInvalidaException();
        }
        local.setPartido(partido);
        visitante.setPartido(partido);
        partido.asignarParticipaciones(local, visitante);
        if (local.getSeleccion() != null) local.getSeleccion().agregarParticipacion(local);
        if (visitante.getSeleccion() != null) visitante.getSeleccion().agregarParticipacion(visitante);
    }
}