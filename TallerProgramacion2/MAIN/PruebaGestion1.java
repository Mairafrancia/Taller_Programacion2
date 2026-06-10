package MAIN;

import CLASES.*;
import GESTION1.*;
import EXCEPCIONES.*;

/**
 * Clase de prueba para demostrar todos los métodos de GESTION1.
 * Gestiona infraestructura, delegaciones, organización deportiva y registro de eventos.
 */
public class PruebaGestion1 {
    public static void main(String[] args) {
        try {
            Mundial mundial = CargadorDatos.cargar();

            GestionInfraestructura gi = new GestionInfraestructura();
            AdministracionDelegaciones ad = new AdministracionDelegaciones();
            OrganizacionDeportiva od = new OrganizacionDeportiva();
            RegistrosEventosCampos rec = new RegistrosEventosCampos();

            Fase faseGrupos = new Fase(NombreFase.GRUPOS);

            System.out.println("=== PRUEBA GESTIÓN DE INFRAESTRUCTURA ===\n");

            try {
                // Registrar sede 1 (Argentina)
                Pais pais1 = new Pais();
                pais1.setNombre("Argentina");
                pais1.setBandera("Bandera Argentina");

                Sede sede1 = new Sede();
                sede1.setCiudad("Buenos Aires");
                sede1.setClima("Templado");
                sede1.setZonaHoraria("UTC-3");

                gi.registrarSede(mundial, sede1, pais1);
                System.out.println("✓ Sede Buenos Aires registrada");

                Estadio estadio1 = new Estadio("Estadio Monumental", 85018, sede1);
                gi.registrarEstadioEnSede(sede1, estadio1, 85018);
                System.out.println("✓ Estadio Monumental registrado (capacidad: 85018)");

                Estadio estadio2 = new Estadio("Estadio Libertadores de América", 48000, sede1);
                gi.registrarEstadioEnSede(sede1, estadio2, 48000);
                System.out.println("✓ Estadio Libertadores registrado (capacidad: 48000)");

                // Registrar sede 2 (Brasil)
                Pais pais2 = new Pais();
                pais2.setNombre("Brasil");
                pais2.setBandera("Bandera Brasil");

                Sede sede2 = new Sede();
                sede2.setCiudad("Río de Janeiro");
                sede2.setClima("Tropical");
                sede2.setZonaHoraria("GMT-3");

                gi.registrarSede(mundial, sede2, pais2);
                System.out.println("✓ Sede Río de Janeiro registrada");

                Estadio estadio3 = new Estadio("Maracaná", 78000, sede2);
                gi.registrarEstadioEnSede(sede2, estadio3, 78000);
                System.out.println("✓ Estadio Maracaná registrado (capacidad: 78000)");

                System.out.println("\nResumen Infraestructura:");
                System.out.println("  Sedes registradas: " + mundial.getSedes().size());
                System.out.println("  Estadios en Buenos Aires: " + sede1.getEstadios().size());
                System.out.println("  Estadios en Río de Janeiro: " + sede2.getEstadios().size());

                System.out.println("\n=== PRUEBA ADMINISTRACIÓN DE DELEGACIONES ===\n");

                // Crear grupos
                Grupo grupo1 = new Grupo("A", "Grupo A", faseGrupos);
                od.registrarGrupoEnFase(faseGrupos, grupo1);
                System.out.println("✓ Grupo A registrado");

                od.registrarGrupoEnFase(faseGrupos, new Grupo("B", "Grupo B", faseGrupos));
                od.registrarGrupoEnFase(faseGrupos, new Grupo("C", "Grupo C", faseGrupos));
                od.registrarGrupoEnFase(faseGrupos, new Grupo("D", "Grupo D", faseGrupos));
                System.out.println("✓ Grupos B, C, D registrados");

                // Crear selección 1 (Argentina)
                Seleccion seleccion1 = new Seleccion();
                seleccion1.setNombreFederacion("AFA");
                ad.gestionarSeleccion(pais1, seleccion1, grupo1);
                System.out.println("✓ Selección AFA (Argentina) registrada en Grupo A");

                // Registrar jugadores
                Jugador jugador1 = new Jugador("Lionel Messi", 0, 10, null, 0, 0, null);
                ad.registrarJugador(seleccion1, jugador1);
                System.out.println("✓ Jugador: Lionel Messi (dorsal 10)");

                Jugador jugador2 = new Jugador("Ángel Di María", 0, 11, null, 0, 0, null);
                ad.registrarJugador(seleccion1, jugador2);
                System.out.println("✓ Jugador: Ángel Di María (dorsal 11)");

                // Registrar director técnico
                DirectoresTecnicos dt1 = new DirectoresTecnicos("Lionel Scaloni", 1972, 20221101);
                ad.registrarDirectorTecnico(seleccion1, dt1);
                System.out.println("✓ Director Técnico: Lionel Scaloni");

                // Registrar cuerpo técnico
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
                System.out.println("✓ Cuerpo técnico: 5 integrantes registrados");

                // Crear selección 2 (Brasil)
                Seleccion seleccion2 = new Seleccion();
                seleccion2.setNombreFederacion("CBF");
                ad.gestionarSeleccion(pais2, seleccion2, grupo1);
                System.out.println("✓ Selección CBF (Brasil) registrada en Grupo A");

                Jugador jugador3 = new Jugador();
                jugador3.setNombre("Neymar");
                jugador3.setDorsal(10);
                ad.registrarJugador(seleccion2, jugador3);
                System.out.println("✓ Jugador: Neymar (dorsal 10)");

                DirectoresTecnicos dt2 = new DirectoresTecnicos("Carlos Ancelotti", 1959, 20220601);
                ad.registrarDirectorTecnico(seleccion2, dt2);
                System.out.println("✓ Director Técnico: Carlos Ancelotti");

                CuerpoTecnico ctB = new CuerpoTecnico();
                ctB.setNombre("Tite");
                ctB.setRol(Rol.ENTRENADORARQUEROS);
                ad.registrarCuerpoTecnico(seleccion2, ctB);
                System.out.println("✓ Cuerpo técnico Brasil: registrado");

                System.out.println("\nResumen Delegaciones:");
                System.out.println("  Jugadores AFA: " + seleccion1.getJugadores().size());
                System.out.println("  Cuerpo técnico AFA: " + seleccion1.getCuerposTecnicos().size());
                System.out.println("  Jugadores CBF: " + seleccion2.getJugadores().size());
                System.out.println("  Cuerpo técnico CBF: " + seleccion2.getCuerposTecnicos().size());

                System.out.println("\n=== PRUEBA ORGANIZACIÓN DEPORTIVA ===\n");

                // Crear partido 1
                Partido partido1 = new Partido(20261101, 2000, 0, 0, estadio1, faseGrupos);
                od.planificarPartido(partido1, faseGrupos, estadio1);
                System.out.println("✓ Partido 1 planificado en Monumental (01/11/2026 20:00)");

                Participacion pLocal1 = new Participacion(true, partido1, seleccion1);

                Participacion pVisitante1 = new Participacion(false, partido1, seleccion2);

                od.asignarEquiposAPartido(partido1, pLocal1, pVisitante1);
                faseGrupos.agregarPartido(partido1);
                System.out.println("✓ Equipos asignados: AFA (Local) vs CBF (Visitante)");

                // Crear partido 2
                Partido partido2 = new Partido(20261105, 1800, 0, 0, estadio3, faseGrupos);
                od.planificarPartido(partido2, faseGrupos, estadio3);
                System.out.println("✓ Partido 2 planificado en Maracaná (05/11/2026 18:00)");

                Participacion pLocal2 = new Participacion(true, partido2, seleccion2);

                Participacion pVisitante2 = new Participacion(false, partido2, seleccion1);

                od.asignarEquiposAPartido(partido2, pLocal2, pVisitante2);
                faseGrupos.agregarPartido(partido2);
                System.out.println("✓ Equipos asignados: CBF (Local) vs AFA (Visitante)");

                System.out.println("\nResumen Organización:");
                System.out.println("  Partidos en fase de grupos: " + faseGrupos.getPartidos().size());

                System.out.println("\n=== PRUEBA REGISTRO DE EVENTOS ===\n");

                // Registrar eventos en partido 1
                Evento evento1 = new Evento(TipoEvento.GOL, 45, jugador1);
                rec.registrarEventoDeCampo(partido1, jugador1, evento1);
                System.out.println("✓ Evento: Gol de Messi (min 45)");

                Evento evento2 = new Evento(TipoEvento.TARJETA_AMARILLA, 67, jugador2);
                rec.registrarEventoDeCampo(partido1, jugador2, evento2);
                System.out.println("✓ Evento: Tarjeta amarilla a Di María (min 67)");

                Evento evento3 = new Evento(TipoEvento.PENAL_COMETIDO, 78, jugador3);
                rec.registrarEventoDeCampo(partido1, jugador3, evento3);
                System.out.println("✓ Evento: Penal cometido por Neymar (min 78)");

                // Registrar eventos en partido 2
                Evento evento4 = new Evento(TipoEvento.GOL, 23, jugador3);
                rec.registrarEventoDeCampo(partido2, jugador3, evento4);
                System.out.println("✓ Evento: Gol de Neymar (min 23)");

                Evento evento5 = new Evento(TipoEvento.SUSTITUCION, 60, jugador1);
                rec.registrarEventoDeCampo(partido2, jugador1, evento5);
                System.out.println("✓ Evento: Sustitución de Messi (min 60)");

                System.out.println("\nResumen Eventos:");
                System.out.println("  Eventos en partido 1: " + partido1.getEventos().size());
                System.out.println("  Eventos en partido 2: " + partido2.getEventos().size());

                System.out.println("\n=== PRUEBA GESTION 1 COMPLETADA EXITOSAMENTE ===");

            } catch (TorneoException e) {
                System.err.println("❌ Error en el torneo: " + e.getMessage());
            } catch (Exception e) {
                System.err.println("❌ Error inesperado: " + e.getMessage());
            }

        } catch (Exception e) {
            System.err.println("❌ Error crítico: No se pudieron cargar los datos del mundial");
            System.err.println("Razón: " + e.getMessage());
        }
    }
}
