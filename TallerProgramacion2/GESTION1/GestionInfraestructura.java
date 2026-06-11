package GESTION1;

import CLASES.*;
import EXCEPCIONES.*;

//CORREGIDA, SE AÑADIO FALSE EN LOS RETURNS LOS METODOS
public class GestionInfraestructura {

    /**
     * Registra una Sede vinculándola al Mundial y al País correspondiente.
     * Asegura la consistencia bidireccional de las relaciones y evita duplicados en el mundial.
     * @param mundial El objeto Mundial donde se registrará la sede.
     * @param nuevaSede La Sede que se desea incorporar al sistema.
     * @param pais El País al que pertenece geográficamente la sede.
     * @throws ValoresNulosException si mundial, nuevaSede o pais es null.
     * @throws ElementoDuplicadoException si la sede ya existe en el mundial.
     */
    public void registrarSede(Mundial mundial, Sede nuevaSede, Pais pais)
            throws ValoresNulosException, ElementoDuplicadoException {

        if (mundial == null || nuevaSede == null || pais == null) {
            throw new ValoresNulosException("mundial, nuevaSede o pais");
        }

        // Primero validar duplicado, antes de modificar nada
        if (mundial.getSedes().contains(nuevaSede)) {
            throw new ElementoDuplicadoException("Sede " + nuevaSede.getCiudad());
        }

        // Recién después vincular todo
        nuevaSede.setPais(pais);
        if (pais.getSedes() != null && !pais.getSedes().contains(nuevaSede)) {
            pais.agregarSede(nuevaSede);
        }
        mundial.agregarSede(nuevaSede);
    }


    /**
     * Registra un Estadio dentro de una Sede específica, asignando su capacidad máxima.
     * Asegura la consistencia bidireccional y evita duplicados en la sede.
     * @param sede La Sede donde se ubica el estadio.
     * @param nuevoEstadio El objeto Estadio a registrar.
     * @param capacidad La capacidad de espectadores del estadio.
     * @throws ValoresNulosException si sede o estadio es null.
     * @throws ElementoDuplicadoException si el estadio ya está registrado en la sede.
     * @throws IllegalArgumentException si la capacidad no es válida (menor o igual a 0).
     */
    public void registrarEstadioEnSede(Sede sede, Estadio nuevoEstadio, int capacidad) 
            throws ValoresNulosException, ElementoDuplicadoException {
        if (sede == null || nuevoEstadio == null) {
            throw new ValoresNulosException("sede o nuevoEstadio");
        }

        if (sede.getEstadios() != null && sede.getEstadios().contains(nuevoEstadio)) {
            throw new ElementoDuplicadoException("Estadio " + nuevoEstadio.getNombre());
        }

        // Validar capacidad del estadio
        if (capacidad <= 0) {
            throw new IllegalArgumentException("La capacidad del estadio debe ser mayor a 0");
        }
        nuevoEstadio.setCapacidad(capacidad);

        // estadio pasa a conocer a qué sede pertenece
        nuevoEstadio.setSede(sede);

        // la sede incorpora el estadio a su lista interna
        if (sede.getEstadios() != null) {
            sede.agregarEstadio(nuevoEstadio);
        }
    }

}