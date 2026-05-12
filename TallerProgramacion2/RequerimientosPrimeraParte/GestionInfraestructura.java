package RequerimientosPrimeraParte;


import taller_programacion2.*;

public class GestionInfraestructura {

    // MÉTODO PARA REGISTRAR SEDE
    public void registrarSede(Mundial mundial, Sede nuevaSede) {
        // Se agrega la sede al mundial siguiendo el diagrama de clases
        mundial.getSedes().add(nuevaSede);
    }

    // MÉTODO PARA REGISTRAR ESTADIO CON CAPACIDAD
    public void registrarEstadioEnSede(Sede sede, String nombre, int capacidad) {
        Estadio nuevoEstadio = new Estadio();
        nuevoEstadio.setNombre(nombre);
        nuevoEstadio.setCapacidad(capacidad); // Requerimiento específico de capacidad
        nuevoEstadio.setSede(sede);
        
        // Se vincula según la relación 1..* del diagrama
        sede.getEstadios().add(nuevoEstadio);
    }
}