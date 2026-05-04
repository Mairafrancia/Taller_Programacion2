package organizacion_deportiva;
import taller_programacion2.*;

public class OrganizacionDeportiva {
    public void configurarFaseYGrupo(Mundial mundial, NombreFase nombre, String idGrupo, String desc) {
        // 1. Crear y configurar la Fase
        Fase nuevaFase = new Fase();
        nuevaFase.setNombre(nombre); // Ejemplo: NombreFase.GRUPOS
        
        // 2. Crear el Grupo y asociarlo a la Fase
        Grupo nuevoGrupo = new Grupo();
        nuevoGrupo.setIdentificador(idGrupo);
        nuevoGrupo.setDescripcion(desc);
        nuevoGrupo.setFase(nuevaFase);
        
        // 3. Vincular según el diagrama (Fase 1 --- * Grupo)
        nuevaFase.agregarGrupo(nuevoGrupo);
    }

    public void planificarPartido(Fase fase, Estadio estadio, Seleccion local, Seleccion visitante, int fecha, int horario) {
        // 1. Crear el Partido
        Partido partido = new Partido();
        
        // 2. Usar setters con tipos int (fecha y horario)
        partido.setFecha(fecha); 
        partido.setHorario(horario);
        partido.setEstadio(estadio);
        partido.setFase(fase);

        // 3. Crear los objetos Participacion
        Participacion pLocal = new Participacion();
        pLocal.setEsLocal(true);
        pLocal.setSeleccion(local);
        
        Participacion pVisitante = new Participacion();
        pVisitante.setEsLocal(false);
        pVisitante.setSeleccion(visitante);

        // 4. SOLUCIÓN AL ERROR DEL ARRAY:
        // En lugar de usar .add(), usamos el método que vos misma creaste en Partido.java
        partido.asignarParticipaciones(pLocal, pVisitante);

        // 5. Guardar el partido en la fase para que la fase conozca su calendario
        fase.agregarPartido(partido);
    }

    
}
    

