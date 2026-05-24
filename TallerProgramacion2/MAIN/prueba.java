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

        Fase faseGrupos = od.crearFase(NombreFase.GRUPOS);
        Fase faseGrupos = od.crearFaseDeGrupos(NombreFase.GRUPOS);

        System.out.println("=== PRUEBA GESTIÓN DE INFRAESTRUCTURA ===");

        Sede sede1 = new Sede();
        sede1.setCiudad("Buenos Aires");
        sede1.setClima("Templado");
        sede1.setZonaHoraria("UTC-3");

        gi.registrarSede(mundial, sede1);
        gi.registrarEstadioEnSede(sede1, "Estadio Monumental", 85018);
        gi.registrarEstadioEnSede(sede1, "Estadio Libertadores de América", 48000);

        Estadio estadio1 = null;
        Estadio estadio2 = null;
        if (sede1.getEstadios().size() > 0) {
            estadio1 = sede1.getEstadios().get(0);
        }
        if (sede1.getEstadios().size() > 1) {
            estadio2 = sede1.getEstadios().get(1);
        }

        Sede sede2 = new Sede();
        sede2.setCiudad("Río de Janeiro");
        sede2.setClima("Tropical");
        sede2.setZonaHoraria("GMT-3");
        gi.registrarSede(mundial, sede2);
        gi.registrarEstadioEnSede(sede2, "Maracaná", 78000);

        Estadio estadio3 = null;
        if (sede2.getEstadios().size() > 0) {
            estadio3 = sede2.getEstadios().get(0);
        }

        System.out.println("Sedes registradas: " + mundial.getSedes().size());
        System.out.println("Estadios en sede1: " + sede1.getEstadios().size());
        System.out.println("Estadios en sede2: " + sede2.getEstadios().size());

        System.out.println("\n=== PRUEBA ADMINISTRACIÓN DE DELEGACIONES ===");

        Pais pais1 = new Pais();
        pais1.setNombre("Argentina");
        pais1.setBandera("Bandera Argentina");

        Seleccion seleccion1 = new Seleccion();
        seleccion1.setNombreFederacion("AFA");

        Grupo grupo1 = null;
        if (faseGrupos.getGrupos().size() > 0) {
            grupo1 = faseGrupos.getGrupos().get(0);
        }

        gi.asignarPaisASede(mundial, sede1, pais1);
        if (grupo1 != null) {
            ad.gestionarSeleccion(pais1, seleccion1, grupo1);
        }

        Jugador jugador1 = new Jugador();
        jugador1.setNombre("Lionel Messi");
        jugador1.setDorsal(10);

        Jugador jugador2 = new Jugador();
        jugador2.setNombre("Ángel Di María");
        jugador2.setDorsal(11);

        ad.registrarJugador(seleccion1, jugador1);
        ad.registrarJugador(seleccion1, jugador2);

        DirectorTecnico dt1 = new DirectorTecnico("Lionel Scaloni", 1972, 20221101);
        seleccion1.agregarDirectorTecnico(dt1);

        CuerpoTecnico ct1 = new CuerpoTecnico();
        ct1.setNombre("Pablo Aimar");
        ct1.setRol(Rol.AYUDANTECAMPO);

        CuerpoTecnico ct2 = new CuerpoTecnico();
        ct2.setNombre("Walter Samuel");
        ct2.setRol(Rol.AYUDANTECAMPO);

        CuerpoTecnico ct3 = new CuerpoTecnico();
        ct3.setNombre("Roberto Ayala");
        ct3.setRol(Rol.AYUDANTECAMPO);

        CuerpoTecnico ct4 = new CuerpoTecnico();
        ct4.setNombre("Martin Tocalli");
        ct4.setRol(Rol.ENTRENADORARQUEROS);

        CuerpoTecnico ct5 = new CuerpoTecnico();
        ct5.setNombre("Luis Martin");
        ct5.setRol(Rol.PREPARADORFISICO);

        ad.registrarCuerpoTecnico(seleccion1, ct1);
        ad.registrarCuerpoTecnico(seleccion1, ct2);
        ad.registrarCuerpoTecnico(seleccion1, ct3);
        ad.registrarCuerpoTecnico(seleccion1, ct4);
        ad.registrarCuerpoTecnico(seleccion1, ct5);

        Pais pais2 = new Pais();
        pais2.setNombre("Brasil");
        pais2.setBandera("Bandera Brasil");

        Seleccion seleccion2 = new Seleccion();
        seleccion2.setNombreFederacion("CBF");

        gi.asignarPaisASede(mundial, sede2, pais2);
        if (grupo1 != null) {
            ad.gestionarSeleccion(pais2, seleccion2, grupo1);
        }

        Jugador jugador3 = new Jugador();
        jugador3.setNombre("Neymar");
        jugador3.setDorsal(10);
        ad.registrarJugador(seleccion2, jugador3);

        DirectorTecnico dt2 = new DirectorTecnico("Carlos Ancelotti", 1959, 20220601);
        seleccion2.agregarDirectorTecnico(dt2);

        CuerpoTecnico ctB = new CuerpoTecnico();
        ctB.setNombre("Tite");
        ctB.setRol(Rol.ENTRENADORARQUEROS);
        ad.registrarCuerpoTecnico(seleccion2, ctB);

        System.out.println("Jugadores en selección Argentina: " + seleccion1.getJugadores().size());
        System.out.println("Cuerpo técnico en selección Argentina: " + seleccion1.getCuerposTecnicos().size());
        System.out.println("Jugadores en selección Brasil: " + seleccion2.getJugadores().size());
        System.out.println("Cuerpo técnico en selección Brasil: " + seleccion2.getCuerposTecnicos().size());

        System.out.println("\n=== PRUEBA ORGANIZACIÓN DEPORTIVA ===");
        od.agregarGrupoAFase(faseGrupos, "B", "Grupo de primera fase");
        od.agregarGrupoAFase(faseGrupos, "C", "Grupo de primera fase");
        od.agregarGrupoAFase(faseGrupos, "D", "Grupo de primera fase");

        Fase faseEliminatorias = od.crearFase(NombreFase.CUARTOS);

        if (estadio1 != null && seleccion1 != null && seleccion2 != null) {
            od.planificarPartido(faseGrupos, estadio1, seleccion1, seleccion2, 20261101, 2000);
        }
        if (estadio3 != null && seleccion1 != null && seleccion2 != null) {
            od.planificarPartido(faseGrupos, estadio3, seleccion2, seleccion1, 20261105, 1800);
        }

        Arbitro arbitro1 = new Arbitro();
        arbitro1.setNombre("Pierluigi Collina");
        arbitro1.setFecNacimiento(1960);
        arbitro1.setAniosExperiencia(30);
        arbitro1.setPais(pais1);

        Arbitro arbitro2 = new Arbitro();
        arbitro2.setNombre("Cesar Ramos");
        arbitro2.setFecNacimiento(1975);
        arbitro2.setAniosExperiencia(20);
        arbitro2.setPais(pais2);

        Arbitro arbitro3 = new Arbitro();
        arbitro3.setNombre("Wilmar Roldán");
        arbitro3.setFecNacimiento(1978);
        arbitro3.setAniosExperiencia(18);
        arbitro3.setPais(pais1);

        if (faseGrupos.getPartidos().size() > 0) {
            Partido partido1 = faseGrupos.getPartidos().get(0);
            Arbitraje arbitrajePrincipal1 = new Arbitraje(CategoriaArbitro.PRINCIPAL, partido1, arbitro1);
            Arbitraje arbitrajeAsistente1 = new Arbitraje(CategoriaArbitro.ASISTENTE_1, partido1, arbitro2);
            Arbitraje arbitrajeAsistente2 = new Arbitraje(CategoriaArbitro.ASISTENTE_2, partido1, arbitro3);
            partido1.agregarArbitraje(arbitrajePrincipal1);
            partido1.agregarArbitraje(arbitrajeAsistente1);
            partido1.agregarArbitraje(arbitrajeAsistente2);
            arbitro1.agregarArbitraje(arbitrajePrincipal1);
            arbitro2.agregarArbitraje(arbitrajeAsistente1);
            arbitro3.agregarArbitraje(arbitrajeAsistente2);
        }

        if (faseGrupos.getPartidos().size() > 1) {
            Partido partido2 = faseGrupos.getPartidos().get(1);
            Arbitraje arbitrajePrincipal2 = new Arbitraje(CategoriaArbitro.PRINCIPAL, partido2, arbitro2);
            Arbitraje arbitrajeAsistente3 = new Arbitraje(CategoriaArbitro.ASISTENTE_1, partido2, arbitro1);
            partido2.agregarArbitraje(arbitrajePrincipal2);
            partido2.agregarArbitraje(arbitrajeAsistente3);
            arbitro2.agregarArbitraje(arbitrajePrincipal2);
            arbitro1.agregarArbitraje(arbitrajeAsistente3);
        }

        System.out.println("Grupos en fase de grupos: " + faseGrupos.getGrupos().size());
        System.out.println("Partidos en fase de grupos: " + faseGrupos.getPartidos().size());
        System.out.println("Grupos en fase de eliminatorias: " + faseEliminatorias.getGrupos().size());
        if (faseGrupos.getPartidos().size() > 0) {
            System.out.println("Árbitros en partido 1: " + faseGrupos.getPartidos().get(0).getArbitrajes().size());
        }
        if (faseGrupos.getPartidos().size() > 1) {
            System.out.println("Árbitros en partido 2: " + faseGrupos.getPartidos().get(1).getArbitrajes().size());
        }

        System.out.println("\n=== PRUEBA REGISTRO DE EVENTOS ===");
        if (faseGrupos.getPartidos().size() > 0) {
            Partido partido1 = faseGrupos.getPartidos().get(0);
            rec.registrarEventoDeCampo(partido1, TipoEvento.GOL, 45, jugador1);
            rec.registrarEventoDeCampo(partido1, TipoEvento.TARJETA_AMARILLA, 67, jugador2);
            rec.registrarEventoDeCampo(partido1, TipoEvento.PENAL_COMETIDO, 78, jugador3);
        }
        if (faseGrupos.getPartidos().size() > 1) {
            Partido partido2 = faseGrupos.getPartidos().get(1);
            rec.registrarEventoDeCampo(partido2, TipoEvento.GOL, 23, jugador3);
            rec.registrarEventoDeCampo(partido2, TipoEvento.SUSTITUCION, 60, jugador1);
        }

        if (faseGrupos.getPartidos().size() > 0) {
            System.out.println("Eventos en partido 1: " + faseGrupos.getPartidos().get(0).getEventos().size());
        }
        if (faseGrupos.getPartidos().size() > 1) {
            System.out.println("Eventos en partido 2: " + faseGrupos.getPartidos().get(1).getEventos().size());
        }

        System.out.println("\n=== TODAS LAS PRUEBAS COMPLETADAS ===");
    }
}
