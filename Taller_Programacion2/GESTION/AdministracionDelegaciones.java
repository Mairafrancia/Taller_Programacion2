package GESTION;

import java.util.ArrayList;

import CLASES.*;

public class AdministracionDelegaciones {
    

    // Lista para controlar que no se repitan jugadores en todo el mundial
    private ArrayList<Jugador> jugadoresAsignados = new ArrayList<>();

    // Cambiamos el enfoque: El país se registra al crearlo,
    // pero se vincula al mundial a través de su Sede.

    // Vincula un país con una sede y asegura que esa sede esté registrada en el
    // Mundial.
    public void vincularPaisAlSistema(Mundial mundial, Sede sede, Pais pais) {
        // 1. Relacionamos Sede con Pais (Sede * --- 1 Pais)
        sede.setPais(pais);

        // 2. Si el Pais tiene una lista de sedes, lo agregamos
        pais.agregarSede(sede);

        // 3. Aseguramos que la sede esté en el mundial
        if (!mundial.getSedes().contains(sede)) {
            mundial.agregarSede(sede);
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

    // Añade un jugador a una selección si no ha sido asignado previamente a otra
    // selección.
    public void registrarJugador(Seleccion seleccion, Jugador nuevoJugador) {
        // Controlamos si el objeto ya está en nuestra lista global de control
        if (!jugadoresAsignados.contains(nuevoJugador)) {
            seleccion.getJugadores().add(nuevoJugador); // Agregamos a la colección
            jugadoresAsignados.add(nuevoJugador); // Marcamos como asignado
        } else {
            System.out.println("Error: El jugador " + nuevoJugador.getNombre() + " ya pertenece a una selección.");
        }
    }

    // Registra un integrante del cuerpo técnico en la selección correspondiente.
    public void registrarCuerpoTecnico(Seleccion seleccion, CuerpoTecnico integrante) {
        // La selección cuenta con una lista de integrantes del cuerpo técnico según el
        // diagrama
        // Usamos el método getter de la clase Seleccion para obtener la lista y añadir
        // al integrante
        seleccion.getCuerposTecnicos().add(integrante);

        // imprimir un mensaje de confirmación para el seguimiento del cargador
        System.out.println("Registrado: " + integrante.getNombre() + " como " + integrante.getRol()
                + " en la selección de " + seleccion.getPais().getNombre());
    }

}
