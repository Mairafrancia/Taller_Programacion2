package MAIN;

import CLASES.*;
import GESTION1.*;
import GESTION2.*;
import EXCEPCIONES.*;
import java.util.ArrayList;

/**
 * Clase de prueba para demostrar todos los reportes de GESTION2.
 * Genera: Tablas de posiciones, resultados, ranking de goleadores, 
 * disciplina, fichas técnicas y estadísticas de sedes.
 */
public class PruebaGestion2 {
    public static void main(String[] args) {
        try {
            // Cargar datos del mundial completo
            Mundial mundial = CargadorDatos.cargar();

            // Instancias de gestión
            GestionInfraestructura gi = new GestionInfraestructura();
            AdministracionDelegaciones ad = new AdministracionDelegaciones();
            OrganizacionDeportiva od = new OrganizacionDeportiva();
            RegistrosEventosCampos rec = new RegistrosEventosCampos();

            // Instancias de reportes (GESTION2)
            TablaDePosicionesPorGrupo tablaPosiciones = new TablaDePosicionesPorGrupo();
            TablaDeResultadosPorSeleccion tablaResultados = new TablaDeResultadosPorSeleccion();
            RankingDeGoleadores rankingGoles = new RankingDeGoleadores();
            InformeDisciplinario informeCards = new InformeDisciplinario();
            FichaTecnicaDeUnPartido fichaTecnica = new FichaTecnicaDeUnPartido();
            EstadisticasDeSedes estadisticasSedes = new EstadisticasDeSedes();

            System.out.println("=== PRUEBA GESTION 2 - REPORTES Y ESTADÍSTICAS ===\n");

            try {
                // ============ SETUP: Crear datos de prueba ============
                Fase faseGrupos = new Fase(NombreFase.GRUPOS);

                // Crear sedes y estadios
                Pais pais1 = new Pais();
                pais1.setNombre("Argentina");
                Sede sede1 = new Sede();
                sede1.setCiudad("Buenos Aires");
                gi.registrarSede(mundial, sede1, pais1);

                Estadio estadio1 = new Estadio("Estadio Monumental", 85018, sede1);
                gi.registrarEstadioEnSede(sede1, estadio1, 85018);

                Pais pais2 = new Pais();
                pais2.setNombre("Brasil");
                Sede sede2 = new Sede();
                sede2.setCiudad("Río de Janeiro");
                gi.registrarSede(mundial, sede2, pais2);

                Estadio estadio2 = new Estadio("Maracaná", 78000, sede2);
                gi.registrarEstadioEnSede(sede2, estadio2, 78000);

                // Crear grupos y selecciones
                Grupo grupo1 = new Grupo("A", "Grupo A", faseGrupos);
                od.registrarGrupoEnFase(faseGrupos, grupo1);

                Seleccion sel1 = new Seleccion();
                sel1.setNombreFederacion("AFA");
                ad.gestionarSeleccion(pais1, sel1, grupo1);

                Seleccion sel2 = new Seleccion();
                sel2.setNombreFederacion("CBF");
                ad.gestionarSeleccion(pais2, sel2, grupo1);

                // Crear jugadores
                Jugador jug1 = new Jugador("Lionel Messi", 0, 10, null, 0, 0, null);
                ad.registrarJugador(sel1, jug1);

                Jugador jug2 = new Jugador("Ángel Di María", 0, 11, null, 0, 0, null);
                ad.registrarJugador(sel1, jug2);

                Jugador jug3 = new Jugador("Neymar", 0, 10, null, 0, 0, null);
                ad.registrarJugador(sel2, jug3);

                Jugador jug4 = new Jugador("Vinicius Junior", 0, 7, null, 0, 0, null);
                ad.registrarJugador(sel2, jug4);

                // Crear partidos con participaciones y eventos
                Partido partido1 = new Partido();
                partido1.setFecha(20261101);
                partido1.setHorario(2000);
                od.planificarPartido(partido1, faseGrupos, estadio1);

                Participacion pLocal1 = new Participacion(true, partido1, sel1);

                Participacion pVisitante1 = new Participacion(false, partido1, sel2);

                od.asignarEquiposAPartido(partido1, pLocal1, pVisitante1);
                faseGrupos.agregarPartido(partido1);

                // Registrar eventos del partido 1
                Evento gol1 = new Evento(TipoEvento.GOL, 15, jug1);
                rec.registrarEventoDeCampo(partido1, jug1, gol1);

                Evento gol2 = new Evento(TipoEvento.GOL, 45, jug3);
                rec.registrarEventoDeCampo(partido1, jug3, gol2);

                Evento tarjeta = new Evento(TipoEvento.TARJETA_AMARILLA, 70, jug2);
                rec.registrarEventoDeCampo(partido1, jug2, tarjeta);

                // Crear segundo partido
                Partido partido2 = new Partido();
                partido2.setFecha(20261105);
                partido2.setHorario(1800);
                od.planificarPartido(partido2, faseGrupos, estadio2);

                Participacion pLocal2 = new Participacion(true, partido2, sel2);

                Participacion pVisitante2 = new Participacion(false, partido2, sel1);

                od.asignarEquiposAPartido(partido2, pLocal2, pVisitante2);
                faseGrupos.agregarPartido(partido2);

                // Registrar eventos del partido 2
                Evento gol3 = new Evento(TipoEvento.GOL, 30, jug1);
                rec.registrarEventoDeCampo(partido2, jug1, gol3);

                Evento gol4 = new Evento(TipoEvento.GOL, 55, jug4);
                rec.registrarEventoDeCampo(partido2, jug4, gol4);

                Evento tarjeta2 = new Evento(TipoEvento.TARJETA_ROJA, 80, jug3);
                rec.registrarEventoDeCampo(partido2, jug3, tarjeta2);

                System.out.println("✓ Setup completado: 2 selecciones, 2 partidos, múltiples eventos\n");

                // ============ REPORTE 1: TABLA DE POSICIONES POR GRUPO ============
                System.out.println("=== REPORTE 1: TABLA DE POSICIONES DEL GRUPO A ===");
                ArrayList<String> tablaPosicionesStr = tablaPosiciones.obtenerTablaPosiciones(grupo1);
                if (tablaPosicionesStr != null && !tablaPosicionesStr.isEmpty()) {
                    for (String linea : tablaPosicionesStr) {
                        System.out.println(linea);
                    }
                } else {
                    System.out.println("No hay datos de posiciones");
                }

                // ============ REPORTE 2: TABLA DE RESULTADOS POR SELECCIÓN ============
                System.out.println("\n=== REPORTE 2: RESULTADOS SELECCIÓN AFA ===");
                ArrayList<String> resultadosAFA = tablaResultados.obtenerResultados(sel1);
                if (resultadosAFA != null) {
                    for (String linea : resultadosAFA) {
                        System.out.println(linea);
                    }
                } else {
                    System.out.println("No hay datos");
                }

                System.out.println("\n=== REPORTE 2: RESULTADOS SELECCIÓN CBF ===");
                ArrayList<String> resultadosCBF = tablaResultados.obtenerResultados(sel2);
                if (resultadosCBF != null) {
                    for (String linea : resultadosCBF) {
                        System.out.println(linea);
                    }
                } else {
                    System.out.println("No hay datos");
                }

                // ============ REPORTE 3: RANKING DE GOLEADORES ============
                System.out.println("\n=== REPORTE 3: RANKING DE GOLEADORES - AFA ===");
                ArrayList<String> rankingAFA = rankingGoles.rankingPorSeleccion(sel1);
                if (rankingAFA != null && !rankingAFA.isEmpty()) {
                    for (String linea : rankingAFA) {
                        System.out.println(linea);
                    }
                } else {
                    System.out.println("No hay goleadores registrados");
                }

                System.out.println("\n=== REPORTE 3: RANKING DE GOLEADORES - CBF ===");
                ArrayList<String> rankingCBF = rankingGoles.rankingPorSeleccion(sel2);
                if (rankingCBF != null && !rankingCBF.isEmpty()) {
                    for (String linea : rankingCBF) {
                        System.out.println(linea);
                    }
                } else {
                    System.out.println("No hay goleadores registrados");
                }

                // ============ REPORTE 4: INFORME DISCIPLINARIO ============
                System.out.println("\n=== REPORTE 4: DISCIPLINA - SELECCIÓN AFA ===");
                ArrayList<String> disciplinaAFA = informeCards.informePorSeleccion(sel1);
                if (disciplinaAFA != null) {
                    for (String linea : disciplinaAFA) {
                        System.out.println(linea);
                    }
                } else {
                    System.out.println("Sin tarjetas registradas");
                }

                System.out.println("\n=== REPORTE 4: DISCIPLINA - SELECCIÓN CBF ===");
                ArrayList<String> disciplinaCBF = informeCards.informePorSeleccion(sel2);
                if (disciplinaCBF != null) {
                    for (String linea : disciplinaCBF) {
                        System.out.println(linea);
                    }
                } else {
                    System.out.println("Sin tarjetas registradas");
                }

                System.out.println("\n=== REPORTE 4: DISCIPLINA INDIVIDUAL - MESSI ===");
                ArrayList<String> disciplinaMessi = informeCards.informePorJugador(jug1);
                if (disciplinaMessi != null) {
                    for (String linea : disciplinaMessi) {
                        System.out.println(linea);
                    }
                } else {
                    System.out.println("Sin tarjetas registradas");
                }

                // ============ REPORTE 5: FICHA TÉCNICA DE PARTIDO ============
                System.out.println("\n=== REPORTE 5: FICHA TÉCNICA - PARTIDO 1 ===");
                ArrayList<String> ficha1 = fichaTecnica.obtenerFicha(partido1);
                if (ficha1 != null) {
                    for (String linea : ficha1) {
                        System.out.println(linea);
                    }
                } else {
                    System.out.println("No hay ficha disponible");
                }

                System.out.println("\n=== REPORTE 5: FICHA TÉCNICA - PARTIDO 2 ===");
                ArrayList<String> ficha2 = fichaTecnica.obtenerFicha(partido2);
                if (ficha2 != null) {
                    for (String linea : ficha2) {
                        System.out.println(linea);
                    }
                } else {
                    System.out.println("No hay ficha disponible");
                }

                // ============ REPORTE 6: ESTADÍSTICAS DE SEDES ============
                System.out.println("\n=== REPORTE 6: ESTADÍSTICAS DE SEDES ===");
                int partidosMonumental = estadisticasSedes.partidosPorEstadio(estadio1);
                System.out.println("Partidos en Estadio Monumental: " + partidosMonumental);

                int partidosMaracana = estadisticasSedes.partidosPorEstadio(estadio2);
                System.out.println("Partidos en Maracaná: " + partidosMaracana);

                int partidosBsAs = estadisticasSedes.partidosPorCiudad(mundial, "Buenos Aires");
                System.out.println("Partidos en Buenos Aires: " + partidosBsAs);

                int partidosRio = estadisticasSedes.partidosPorCiudad(mundial, "Río de Janeiro");
                System.out.println("Partidos en Río de Janeiro: " + partidosRio);

                System.out.println("\n=== PRUEBA GESTION 2 COMPLETADA EXITOSAMENTE ===");

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
