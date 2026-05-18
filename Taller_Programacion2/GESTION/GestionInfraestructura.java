// Declaración del nuevo paquete
package GESTION;

import CLASES.*;

public class GestionInfraestructura {

    // MÉTODO PARA REGISTRAR SEDE
    public void registrarSede(Mundial mundial, Sede nuevaSede) {

    if (mundial == null || nuevaSede == null) {
            System.out.println("Error: El mundial o la sede no pueden ser nulos.");
            return;
        }
        // Se agrega la sede al mundial siguiendo el diagrama de clases
        mundial.agregarSede(nuevaSede);
        System.out.println("Sede '" + nuevaSede.getCiudad() + "' registrada con éxito en el Mundial.");
    }

    // MÉTODO PARA REGISTRAR ESTADIO CON CAPACIDAD
    public void registrarEstadioEnSede(Sede sede, String nombre, int capacidad) {

        if (sede == null || nombre == null || nombre.isEmpty() || capacidad <= 0) {
            System.out.println("Error: Datos del estadio, sede o capacidad inválidos.");
            return;
        }
        //Creamos el objeto Estadio
        Estadio nuevoEstadio = new Estadio();
        nuevoEstadio.setNombre(nombre);
        nuevoEstadio.setCapacidad(capacidad); // Requerimiento específico de capacidad
        nuevoEstadio.setSede(sede);

        // Se vincula según la relación 1..* del diagrama
        //Usamos el métodetodo agregar de la clase Sede
        sede.agregarEstadio(nuevoEstadio);

        System.out.println("Estadio '" + nombre + "' (Capacidad: " + capacidad + ") registrado con éxito en la sede " + sede.getCiudad() + ".");
    }
}