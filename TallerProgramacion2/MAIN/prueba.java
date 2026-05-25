package MAIN;

import CLASES.*;
import GESTION1.*;

public class prueba {
    public static void main(String[] args) {
        Mundial mundial = CargadorDatos.cargar();

        GestionInfraestructura gi = new GestionInfraestructura();
        AdministracionDelegaciones ad = new AdministracionDelegaciones();
        OrganizacionDeportiva od = new OrganizacionDeportiva();
        RegistrosEventosCampos rec = new RegistrosEventosCampos();

        Fase faseGrupos = new Fase(NombreFase.GRUPOS);

        System.out.println("=== PRUEBA GESTIÓN DE INFRAESTRUCTURA ===");

        Pais pais1 = new Pais();
        pais1.setNombre("Argentina");
        pais1.setBandera("Bandera Argentina");

        Sede sede1 = new Sede();
        sede1.setCiudad("Buenos Aires");
        sede1.setClima("Templado");
        sede1.setZonaHoraria("UTC-3");

        gi.registrarSede(mundial, sede1, pais1);

        Estadio estadio1 = new Estadio();
        estadio1.setNombre("Estadio Monumental");
        gi.registrarEstadioEnSede(sede1, estadio1, 85018);

        Estadio estadio2 = new Estadio();
        estadio2.setNombre("Estadio Libertadores de América");
        gi.registrarEstadioEnSede(sede1, estadio2, 48000);

        Pais pais2 = new Pais();
        pais2.setNombre("Brasil");
        pais2.setBandera("Bandera Brasil");

        Sede sede2 = new Sede();
        sede2.setCiudad("Río de Janeiro");
        sede2.setClima("Tropical");
        sede2.setZonaHoraria("GMT-3");

        gi.registrarSede(mundial, sede2, pais2);

        Estadio estadio3 = new Estadio();
        estadio3.setNombre("Maracaná");
        gi.registrarEstadioEnSede(sede2, estadio3, 78000);

        System.out.println("Sedes registradas: " + mundial.getSedes().size());
        System.out.println("Estadios en sede1: " + sede1.getEstadios().size());
        System.out.println("Estadios en sede2: " + sede2.getEstadios().size());

        System.out.println("\n=== PRUEBA ADMINISTRACIÓN DE DELEGACIONES ===");

        Grupo grupo1 = new Grupo("A", "Grupo A", faseGrupos);
        od.registrarGrupoEnFase(faseGrupos, grupo1);
        od.registrarGrupoEnFase(faseGrupos, new Grupo("B", "Grupo de primera fase", faseGrupos));
        od.registrarGrupoEnFase(faseGrupos, new Grupo("C", "Grupo de primera fase", faseGrupos));
        od.registrarGrupoEnFase(faseGrupos, new Grupo("D", "Grupo de primera fase", faseGrupos));

        Seleccion seleccion1 = new Seleccion();
        seleccion1.setNombreFederacion("AFA");
        ad.gestionarSeleccion(pais1, seleccion1, grupo1);

        Jugador jugador1 = new Jugador();
        jugador1.setNombre("Lionel Messi");
        jugador1.setDorsal(10);
        ad.registrarJugador(seleccion1, jugador1);

        Jugador jugador2 = new Jugador();
        jugador2.setNombre("Ángel Di María");
        jugador2.setDorsal(11);
        ad.registrarJugador(seleccion1, jugador2);

        DirectoresTecnicos dt1 = new DirectoresTecnicos("Lionel Scaloni", 1972, 20221101);
        ad.registrarDirectorTecnico(seleccion1, dt1);

        CuerpoTecnico ct1 = new CuerpoTecnico();
        ct1.setNombre("Pablo Aimar");
        ct1.setRol(Rol.AYUDANTECAMPO);
        ad.registrarCuerpoTecnico(seleccion1, ct1);

        CuerpoTecnico ct2 = new CuerpoTecnico();
        ct2.setNombre("Walter Samuel");
        ct2.setRol(Rol.AYUDANTECAMPO);
        ad.registrarCuerpoTecnico(seleccion1, ct2);

        CuerpoTecnico ct3 = new CuerpoTecnico();
        ct3.setNombre("Roberto Ayala");
        ct3.setRol(Rol.AYUDANTECAMPO);
        ad.registrarCuerpoTecnico(seleccion1, ct3);

        CuerpoTecnico ct4 = new CuerpoTecnico();
        ct4.setNombre("Martin Tocalli");
        ct4.setRol(Rol.ENTRENADORARQUEROS);
        ad.registrarCuerpoTecnico(seleccion1, ct4);

        CuerpoTecnico ct5 = new CuerpoTecnico();
        ct5.setNombre("Luis Martin");
        ct5.setRol(Rol.PREPARADORFISICO);
        ad.registrarCuerpoTecnico(seleccion1, ct5);

        Seleccion seleccion2 = new Seleccion();
        seleccion2.setNombreFederacion("CBF");
        ad.gestionarSeleccion(pais2, seleccion2, grupo1);

        Jugador jugador3 = new Jugador();
        jugador3.setNombre("Neymar");
        jugador3.setDorsal(10);
        ad.registrarJugador(seleccion2, jugador3);

        DirectoresTecnicos dt2 = new DirectoresTecnicos("Carlos Ancelotti", 1959, 20220601);
        ad.registrarDirectorTecnico(seleccion2, dt2);

        CuerpoTecnico ctB = new CuerpoTecnico();
        ctB.setNombre("Tite");
        ctB.setRol(Rol.ENTRENADORARQUEROS);
        ad.registrarCuerpoTecnico(seleccion2, ctB);

        System.out.println("Jugadores en selección Argentina: " + seleccion1.getJugadores().size());
        System.out.println("Cuerpo técnico en selección Argentina: " + seleccion1.getCuerposTecnicos().size());
        System.out.println("Jugadores en selección Brasil: " + seleccion2.getJugadores().size());
        System.out.println("Cuerpo técnico en selección Brasil: " + seleccion2.getCuerposTecnicos().size());

        System.out.println("\n=== PRUEBA ORGANIZACIÓN DEPORTIVA ===");

        if (estadio1 != null && seleccion1 != null && seleccion2 != null) {
            Partido partido1 = new Partido();
            partido1.setFecha(20261101);
            partido1.setHorario(2000);
            od.planificarPartido(partido1, faseGrupos, estadio1);

            Participacion pLocal1 = new Participacion();
            pLocal1.setEsLocal(true);
            pLocal1.setSeleccion(seleccion1);

            Participacion pVisitante1 = new Participacion();
            pVisitante1.setEsLocal(false);
            pVisitante1.setSeleccion(seleccion2);

            od.asignarEquiposAPartido(partido1, pLocal1, pVisitante1);
            faseGrupos.agregarPartido(partido1);

            Partido partido2 = new Partido();
            partido2.setFecha(20261105);
            partido2.setHorario(1800);
            od.planificarPartido(partido2, faseGrupos, estadio3);

            Participacion pLocal2 = new Participacion();
            pLocal2.setEsLocal(true);
            pLocal2.setSeleccion(seleccion2);

            Participacion pVisitante2 = new Participacion();
            pVisitante2.setEsLocal(false);
            pVisitante2.setSeleccion(seleccion1);

            od.asignarEquiposAPartido(partido2, pLocal2, pVisitante2);
            faseGrupos.agregarPartido(partido2);

            System.out.println("Partidos planificados en fase de grupos: " + faseGrupos.getPartidos().size());

            System.out.println("\n=== PRUEBA REGISTRO DE EVENTOS ===");
            Evento evento1 = new Evento(TipoEvento.GOL, 45, jugador1);
            rec.registrarEventoDeCampo(partido1, jugador1, evento1);

            Evento evento2 = new Evento(TipoEvento.TARJETA_AMARILLA, 67, jugador2);
            rec.registrarEventoDeCampo(partido1, jugador2, evento2);

            Evento evento3 = new Evento(TipoEvento.PENAL_COMETIDO, 78, jugador3);
            rec.registrarEventoDeCampo(partido1, jugador3, evento3);

            Evento evento4 = new Evento(TipoEvento.GOL, 23, jugador3);
            rec.registrarEventoDeCampo(partido2, jugador3, evento4);

            Evento evento5 = new Evento(TipoEvento.SUSTITUCION, 60, jugador1);
            rec.registrarEventoDeCampo(partido2, jugador1, evento5);

            System.out.println("Eventos en partido 1: " + partido1.getEventos().size());
            System.out.println("Eventos en partido 2: " + partido2.getEventos().size());
        }

        System.out.println("\n=== TODAS LAS PRUEBAS DE GESTIÓN 1 COMPLETADAS ===");
    }
}