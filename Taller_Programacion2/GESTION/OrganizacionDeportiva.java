package GESTION;
import CLASES.*;

public class OrganizacionDeportiva {

    public Fase configurarFaseYGrupo(Mundial mundial, NombreFase nombre, String idGrupo, String desc) {
        if (mundial == null || nombre == null) {
            System.out.println("Error: Datos de la fase inválidos.");
            return null;
        }
        // 1. Crear y configurar la Fase
        Fase nuevaFase = new Fase();
        nuevaFase.setNombre(nombre); // Ejemplo: NombreFase.GRUPOS
        
        // 2. Reutilizar la lógica de configuración de grupo
        configurarGrupoEnFase(nuevaFase, idGrupo, desc);
        
        // 3. Devolver la fase para poder agregar más grupos después
        return nuevaFase;
    }

    public void configurarGrupoEnFase(Fase faseExistente, String idGrupo, String desc) {
        if (faseExistente == null || idGrupo == null || idGrupo.isEmpty()) {
            System.out.println("Error: No se pudo configurar el grupo. Datos insuficientes.");
            return;
        }
        // 1. Crear el Grupo
        Grupo nuevoGrupo = new Grupo();
        nuevoGrupo.setIdentificador(idGrupo);
        nuevoGrupo.setDescripcion(desc);
        
        // 2. Vincular el grupo con la fase existente (Relación * --- 1)
        nuevoGrupo.setFase(faseExistente);
        
        // 3. Agregar el grupo a la lista de la fase (Relación 1 --- *)
        faseExistente.agregarGrupo(nuevoGrupo);
    }

    public void planificarPartido(Fase fase, Estadio estadio, Seleccion local, Seleccion visitante, int fecha, int horario) {
        
        if (fase == null || estadio == null || local == null || visitante == null) {
            System.out.println("Error: No se puede planificar el partido. Faltan datos esenciales.");
            return;
        }

        if (local == visitante) {
            System.out.println("Error: Una selección no puede jugar contra sí misma.");
            return;
        }

        // 1. Crear el Partido
        Partido partido = new Partido();
        // Usar setters con tipos int (fecha y horario)
        partido.setFecha(fecha); 
        partido.setHorario(horario);
        partido.setEstadio(estadio);
        partido.setFase(fase);

        // 2. Crear los objetos Participacion vinculando Selección Y Partido (Bidireccional)
        Participacion pLocal = new Participacion();
        pLocal.setEsLocal(true);
        pLocal.setSeleccion(local);
        pLocal.setPartido(partido); // <--- CRÍTICO: Ahora la participación sabe qué partido es
        
        Participacion pVisitante = new Participacion();
        pVisitante.setEsLocal(false);
        pVisitante.setSeleccion(visitante);
        pVisitante.setPartido(partido); // <--- CRÍTICO: Ahora la participación sabe qué partido es

        // 3. Asignar las participaciones al partido
        partido.asignarParticipaciones(pLocal, pVisitante);

        // 5. Guardar el partido en la fase para que la fase conozca su calendario
        fase.agregarPartido(partido);
        estadio.agregarPartido(partido);    // El estadio conoce el partido
        local.agregarParticipacion(pLocal); // La selección local registra que jugó
        visitante.agregarParticipacion(pVisitante); // La selección visitante registra que jugó
        
        System.out.println("Partido planificado: " + local.getNombreFederacion() + " vs " + visitante.getNombreFederacion() + " en el estadio " + estadio.getNombre());
    }

    
}
    

