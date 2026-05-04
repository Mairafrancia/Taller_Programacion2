package taller_programacion2;

import java.util.ArrayList;


public class CargadorDatos {
    public static Mundial cargar() {
        // acá van todos los objetos
        //crear mundial vacio
        Mundial mundial = new Mundial(2026, "nombre mascota", 1, 30, new ArrayList<>());
        //crear un país
        Pais argentina = new Pais();
        argentina.setNombre("Argentina");
        argentina.setBandera("arg.png");
        //crear una Sede y asociaral al Pais
        Sede sede1 = new Sede("Buenos Aires", 25.0f, "templado", "GMT-3", argentina, new ArrayList<>());
        argentina.agregarSede(sede1);
        mundial.agregarSede(sede1);
        //Crear un Estadio y asociar
        Estadio estadio1 = new Estadio();
        estadio1.setNombre("Monumental");
        estadio1.setCapacidad(84567);
        estadio1.setSede(sede1);
        sede1.agregarEstadio(estadio1);
        //Crear Fase y grupo(necesario para Selecciones)
        Fase faseGrupos = new Fase();
        faseGrupos.setNombre(NombreFase.GRUPOS);

        Grupo grupoA = new Grupo();
        grupoA.setIdentificador("A");
        grupoA.setFase(faseGrupos);
        faseGrupos.agregarGrupo(grupoA);
        //Crear Director Tecnico y Selección:
        DirectorTecnico dt1 = new DirectorTecnico("Lionel Scaloni", 1978, 2018);

        Seleccion selArg = new Seleccion();
        selArg.setNombreFederacion("AFA");
        selArg.setPais(argentina);
        selArg.setGrupo(grupoA);
        selArg.setRankingFIFA(1);
        selArg.setDirectorTecnico(dt1);

        argentina.setSeleccion(selArg);
        grupoA.agregarSeleccion(selArg);

        return mundial;
    }
}
