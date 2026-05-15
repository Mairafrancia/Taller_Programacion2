package RequerimientosPrimeraParte;




import taller_programacion2.*;

public class AdministracionDelegaciones {

    // Cambiamos el enfoque: El país se registra al crearlo, 
    // pero se vincula al mundial a través de su Sede.

    // Vincula un país con una sede y asegura que esa sede esté registrada en el Mundial.
    public void vincularPaisAlSistema(Mundial mundial, Sede sede, Pais pais) {
        // 1. Relacionamos Sede con Pais (Sede * --- 1 Pais)
        sede.setPais(pais);
        
        // 2. Si el Pais tiene una lista de sedes, lo agregamos
        pais.getSedes().add(sede);
        
        // 3. Aseguramos que la sede esté en el mundial 
        if (!mundial.getSedes().contains(sede)) {
            mundial.getSedes().add(sede);
        }
    }

    // Asocia una selección a un país y la asigna al grupo correspondiente.
    public void gestionarSeleccion(Pais pais, Seleccion seleccion, Grupo grupo) {
        // Vincular la selección con el país (Relación 1 a 1)
        pais.setSeleccion(seleccion);
        seleccion.setPais(pais);
        
        // Asignar la selección a un grupo (Relación * a 1)
        seleccion.setGrupo(grupo);
        grupo.agregarSeleccion(seleccion);
    }

    
   

    // Añade un jugador a una selección si no ha sido asignado previamente a otra selección del grupo.
    public boolean registrarJugador(Seleccion seleccion, Jugador nuevoJugador) {
        // Verificar si el jugador ya está en otra selección del mismo grupo
        Grupo grupo = seleccion.getGrupo();
        if (grupo != null) {
            for (Seleccion sel : grupo.getSelecciones()) {
                if (sel.getJugadores().contains(nuevoJugador)) {
                    return false; // El jugador ya está registrado en otra selección
                }
            }
        }
        // Si no está en ninguna selección del grupo, lo registramos
        seleccion.getJugadores().add(nuevoJugador);
        return true;
    }

    // Registra un integrante del cuerpo técnico en la selección correspondiente.
    public boolean registrarCuerpoTecnico(Seleccion seleccion, CuerpoTecnico integrante) {
        // La selección cuenta con una lista de integrantes del cuerpo técnico según el diagrama
        // Usamos el método getter de la clase Seleccion para obtener la lista y añadir al integrante
        seleccion.getCuerposTecnicos().add(integrante);
        return true;
    }


    
}
