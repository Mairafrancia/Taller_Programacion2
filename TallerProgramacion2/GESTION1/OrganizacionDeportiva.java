package GESTION1;

import CLASES.*;

public class OrganizacionDeportiva {
    
    public Fase crearFaseDeEliminacion(NombreFase nombre) { //Crea una fase de eliminación directa (Dieciseisavos, Octavos, Cuartos, Semifinal, Final).
        if (nombre == null || NombreFase.GRUPOS.equals(nombre)) { //no acepta NombreFase.GRUPOS porque esa fase se va a crear en crearFaseDeGrupos()
            return null; // o lanzar excepción
        }
        return new Fase(nombre);
    }

    
    public Fase crearFaseDeGrupos() { //creamos solo fases de tipo grupos
        return new Fase(NombreFase.GRUPOS);
    }

    
    public boolean agregarGrupoAFase(Fase faseExistente, String idGrupo, String desc) {
        if (faseExistente == null || idGrupo == null || idGrupo.isEmpty()) {
            return false;
        }
        if (!NombreFase.GRUPOS.equals(faseExistente.getNombre())) { //buaco que solo sea valido si la fase es de tipo GRUPOS
            return false;
        }
        Grupo nuevoGrupo = new Grupo(idGrupo, desc, faseExistente); 
        faseExistente.agregarGrupo(nuevoGrupo); //agrego el nuevo grupo a la fase pasada por parametro
        return true;
    }

    // Este método planifica un partido, validando datos y controlando duplicados.
    //controles agregados
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
    


