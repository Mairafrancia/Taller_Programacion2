package GESTION1;
import CLASES.*;
//CORREGIDA, SE AÑADIO FALSE EN LOS RETURNS LOS METODOS
public class GestionInfraestructura {

    // MÉTODO PARA REGISTRAR SEDE
    public boolean registrarSede(Mundial mundial, Sede nuevaSede) {
        if (mundial == null || nuevaSede == null) {
            return false;
        }

        mundial.agregarSede(nuevaSede);
        return true;
    }

    // Asigna un país a una sede y asegura que la sede esté registrada en el mundial.
    // Esta lógica pertenece a infraestructura, no a la gestión de delegaciones.
    //Vincular pais al sistema pasa a llamarse asignarPaisASede
    public void asignarPaisASede(Mundial mundial, Sede sede, Pais pais) {
        if (mundial == null || sede == null || pais == null) {
            return;
        }

        sede.setPais(pais);
        pais.agregarSede(sede);

        if (!mundial.getSedes().contains(sede)) {
            mundial.agregarSede(sede);
        }
    }

    // MÉTODO PARA REGISTRAR ESTADIO CON CAPACIDAD
    public boolean registrarEstadioEnSede(Sede sede, String nombre, int capacidad) {
        if (sede == null || nombre == null || nombre.trim().isEmpty() || capacidad <= 0) {
            return false;
        }

        Estadio nuevoEstadio = new Estadio();
        nuevoEstadio.setNombre(nombre);
        nuevoEstadio.setCapacidad(capacidad); // Requerimiento específico de capacidad
        nuevoEstadio.setSede(sede);

        // Se vincula según la relación 1..* del diagrama
        sede.agregarEstadio(nuevoEstadio);
        return true;
    }
}