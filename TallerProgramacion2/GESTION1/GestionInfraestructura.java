package GESTION1;

import CLASES.*;

//CORREGIDA, SE AÑADIO FALSE EN LOS RETURNS LOS METODOS
public class GestionInfraestructura {

    /**
     * Registra una Sede vinculándola al Mundial y al País correspondiente.
     * Asegura la consistencia bidireccional de las relaciones y evita duplicados en
     * el mundial.
     * * @param mundial El objeto Mundial donde se registrará la sede.
     * 
     * @param nuevaSede La Sede que se desea incorporar al sistema.
     * @param pais      El País al que pertenece geográficamente la sede.
     * @return true si la sede se registró con éxito; false si ya existía en el
     *         mundial o hubo valores nulos.
     */

    public boolean registrarSede(Mundial mundial, Sede nuevaSede, Pais pais) {
        if (mundial == null || nuevaSede == null || pais == null) {
            return false;
        }
        // Vinculamos la Sede con su País
        nuevaSede.setPais(pais);
        // mundial.agregarSede(nuevaSede);
        // El País maneja una lista de sus sedes, lo agregamos para mantener la
        // consistencia
        if (pais.getSedes() != null && !pais.getSedes().contains(nuevaSede)) {
            pais.agregarSede(nuevaSede);
        }

        // Añadimos la sede al Mundial (Relación Mundial 1 --- 1..* Sede)
        if (mundial.getSedes() != null && !mundial.getSedes().contains(nuevaSede)) {
            mundial.agregarSede(nuevaSede);
            return true; // Se registró con éxito
        }
        return false;
    }

    /**
     * Registra un Estadio dentro de una Sede específica, asignando su capacidad
     * máxima.
     * Asegura la consistencia bidireccional y evita duplicados en la sede.
     * * @param sede La Sede donde se ubica el estadio.
     * 
     * @param nuevoEstadio El objeto Estadio a registrar.
     * @param capacidad    La capacidad de espectadores del estadio.
     * @return true si el estadio se registró con éxito; false si ya existía o hubo
     *         nulos.
     */

    public boolean registrarEstadioEnSede(Sede sede, Estadio nuevoEstadio, int capacidad) {
        if (sede == null || nuevoEstadio == null) {
            return false;
        }

        if (sede.getEstadios() != null && sede.getEstadios().contains(nuevoEstadio)) {
            return false;
        }

        // le damos la capacidad al estadio, requisito específico del método
        if (capacidad <= 0) {
            return false;
        }
        nuevoEstadio.setCapacidad(capacidad);

        // estadio pasa a conocer a qué sede pertenece
        nuevoEstadio.setSede(sede);

        // la sede incorpora el estadio a su lista interna
        if (sede.getEstadios() != null) {
            sede.agregarEstadio(nuevoEstadio);
            return true;
        }

        return false;
    }

}