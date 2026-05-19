package GESTION1;

import CLASES.*;

public class OrganizacionDeportiva {
    // Separamos la creación de fases de la creación de grupos:
    // - crearFase() crea cualquier fase (grupos o eliminación).
    // - agregarGrupoAFase() solo agrega grupos si la fase es de GRUPOS.
    // Esto evita que una fase de eliminación reciba grupos y deja la lógica más clara.

    public Fase crearFase(NombreFase nombre) {
        return new Fase(nombre);
    }

    public boolean agregarGrupoAFase(Fase faseExistente, String idGrupo, String desc) {
        if (faseExistente == null || idGrupo == null || idGrupo.isEmpty()) {
            return false;
        }
        if (!NombreFase.GRUPOS.equals(faseExistente.getNombre())) {
            return false;
        }
        Grupo nuevoGrupo = new Grupo(idGrupo, desc, faseExistente);
        faseExistente.agregarGrupo(nuevoGrupo);
        return true;
    }

    // Este método planifica un partido, validando datos y controlando duplicados.
    public boolean planificarPartido(Fase fase, Estadio estadio, Seleccion local, Seleccion visitante, int fecha, int horario) {
        if (fase == null || estadio == null || local == null || visitante == null) {
            return false;
        }
        if (local == visitante) {
            return false;
        }
        if (fecha <= 0 || horario <= 0) {
            return false;
        }

        Partido partido = new Partido();
        partido.setFecha(fecha);
        partido.setHorario(horario);
        partido.setEstadio(estadio);
        partido.setFase(fase);

        if (fase.getPartidos().contains(partido) || estadio.getPartidos().contains(partido)) {
            return false;
        }

        Participacion pLocal = new Participacion();
        pLocal.setEsLocal(true);
        pLocal.setSeleccion(local);

        Participacion pVisitante = new Participacion();
        pVisitante.setEsLocal(false);
        pVisitante.setSeleccion(visitante);

        partido.asignarParticipaciones(pLocal, pVisitante);
        pLocal.setPartido(partido);
        pVisitante.setPartido(partido);
        estadio.agregarPartido(partido);
        fase.agregarPartido(partido);
        return true;
    }

    
}
    


