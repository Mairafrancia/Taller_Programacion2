package MAIN;

import CLASES.*;
import EXCEPCIONES.JugadorDuplicadoException;
import EXCEPCIONES.ValoresNulosException;
import GESTION1.AdministracionDelegaciones;

public class CargadorDatos {

    public static Mundial cargar() {

        Mundial mundial = new Mundial(2026, "Migo", 20260611, 20260719);

        // =====================================================================
        // PAÍSES
        // =====================================================================
        Pais argentina = new Pais("Argentina", "arg.png", null);
        Pais brasil    = new Pais("Brasil",    "bra.png", null);
        Pais uruguay   = new Pais("Uruguay",   "uru.png", null);
        Pais colombia  = new Pais("Colombia",  "col.png", null);
        Pais francia   = new Pais("Francia",   "fra.png", null);
        Pais alemania  = new Pais("Alemania",  "ger.png", null);
        Pais espania   = new Pais("España",    "esp.png", null);

        // =====================================================================
        // SEDES
        // =====================================================================
        Sede sede1 = new Sede("Buenos Aires",   25.0f, "Templado", "GMT-3", argentina);
        Sede sede2 = new Sede("Rio de Janeiro", 30.0f, "Tropical", "GMT-3", brasil);
        Sede sede3 = new Sede("Montevideo",     22.0f, "Templado", "GMT-3", uruguay);
        Sede sede4 = new Sede("Bogota",         18.0f, "Frio",     "GMT-5", colombia);
        Sede sede5 = new Sede("Paris",          15.0f, "Frio",     "GMT+1", francia);
        Sede sede6 = new Sede("Berlin",         12.0f, "Frio",     "GMT+1", alemania);
        Sede sede7 = new Sede("Madrid",         18.0f, "Templado", "GMT+1", espania);

        for (Pais p : new Pais[]{argentina, brasil, uruguay, colombia, francia, alemania, espania}) {
            Sede sede = (p == argentina) ? sede1
                      : (p == brasil)    ? sede2
                      : (p == uruguay)   ? sede3
                      : (p == colombia)  ? sede4
                      : (p == francia)   ? sede5
                      : (p == alemania)  ? sede6
                      : sede7;
            p.agregarSede(sede);
            mundial.agregarSede(sede);
        }

        // =====================================================================
        // ESTADIOS
        // =====================================================================
        Estadio estadio1 = new Estadio("Monumental",       84567, sede1);
        Estadio estadio2 = new Estadio("Maracana",         78000, sede2);
        Estadio estadio3 = new Estadio("Centenario",       60000, sede3);
        Estadio estadio4 = new Estadio("El Campin",        45000, sede4);
        Estadio estadio5 = new Estadio("Stade de France",  80698, sede5);
        Estadio estadio6 = new Estadio("Olympiastadion",   74475, sede6);
        Estadio estadio7 = new Estadio("Santiago Bernabeu", 81044, sede7);

        sede1.agregarEstadio(estadio1);
        sede2.agregarEstadio(estadio2);
        sede3.agregarEstadio(estadio3);
        sede4.agregarEstadio(estadio4);
        sede5.agregarEstadio(estadio5);
        sede6.agregarEstadio(estadio6);
        sede7.agregarEstadio(estadio7);

        // =====================================================================
        // FASES
        // =====================================================================
        // IMPORTANTE: NombreFase debe estar ordenado de menor a mayor en el enum
        // para que TablaDeResultadosPorSeleccion.ordinal() funcione correctamente:
        // GRUPOS, OCTAVOS, CUARTOS, SEMIFINAL, FINAL

        Fase faseGrupos    = new Fase();  faseGrupos.setNombre(NombreFase.GRUPOS);
        Fase faseSemifinal = new Fase();  faseSemifinal.setNombre(NombreFase.SEMIFINAL);
        Fase faseFinal     = new Fase();  faseFinal.setNombre(NombreFase.FINAL);

        mundial.agregarFase(faseGrupos);
        mundial.agregarFase(faseSemifinal);
        mundial.agregarFase(faseFinal);

        // =====================================================================
        // GRUPOS
        // =====================================================================
        Grupo grupoA = new Grupo("A", "Grupo A", faseGrupos);
        Grupo grupoB = new Grupo("B", "Grupo B", faseGrupos);

        faseGrupos.agregarGrupo(grupoA);
        faseGrupos.agregarGrupo(grupoB);

        // =====================================================================
        // ÁRBITROS GLOBALES
        // =====================================================================
        Arbitro arbitro1 = new Arbitro("Roberto Tobar",    19750310, 15, colombia);
        Arbitro arbitro2 = new Arbitro("Clement Turpin",   19820118, 12, francia);
        Arbitro arbitro3 = new Arbitro("Felix Brych",      19750808, 18, alemania);
        Arbitro arbitro4 = new Arbitro("Daniele Orsato",   19750205, 20, argentina); // usamos arg como placeholder

        // =====================================================================
        // DELEGACIONES — GRUPO A
        // =====================================================================
        AdministracionDelegaciones ad = new AdministracionDelegaciones();

        // --- ARGENTINA ---
        DirectoresTecnicos dt_arg = new DirectoresTecnicos("Lionel Scaloni", 1978, 2018);
        Seleccion selArg = new Seleccion("AFA", "arg_kit.png", "arg_alt.png", false, 1, grupoA, argentina);
        selArg.agregarDirectoresTecnicos(dt_arg);
        argentina.setSeleccion(selArg);
        grupoA.agregarSeleccion(selArg);

        Jugador messi    = new Jugador("Lionel Messi",      19870624, 10, null, 0, 0, null);
        Jugador diMaria  = new Jugador("Angel Di Maria",    19880214, 11, null, 0, 0, null);
        Jugador martinez = new Jugador("Lautaro Martinez",  19971022, 22, null, 0, 0, null);
        Jugador romero   = new Jugador("Cristian Romero",   19980327,  2, null, 0, 0, null);
        Jugador dybala   = new Jugador("Paulo Dybala",      19931115, 21, null, 0, 0, null);

        for (Jugador j : new Jugador[]{messi, diMaria, martinez, romero, dybala})
            registrarJugador(ad, selArg, j);

        // --- BRASIL ---
        DirectoresTecnicos dt_bra = new DirectoresTecnicos("Carlo Ancelotti", 1959, 2024);
        Seleccion selBra = new Seleccion("CBF", "bra_kit.png", "bra_alt.png", false, 5, grupoA, brasil);
        selBra.agregarDirectoresTecnicos(dt_bra);
        brasil.setSeleccion(selBra);
        grupoA.agregarSeleccion(selBra);

        Jugador vinicius = new Jugador("Vinicius Junior", 20000712,  7, null, 0, 0, null);
        Jugador rodrygo  = new Jugador("Rodrygo",         20010109, 11, null, 0, 0, null);
        Jugador neymar   = new Jugador("Neymar",          19920205, 10, null, 0, 0, null);
        Jugador casemiro = new Jugador("Casemiro",        19920223,  5, null, 0, 0, null);
        Jugador raphinha = new Jugador("Raphinha",        19960614, 17, null, 0, 0, null);

        for (Jugador j : new Jugador[]{vinicius, rodrygo, neymar, casemiro, raphinha})
            registrarJugador(ad, selBra, j);

        // --- URUGUAY ---
        DirectoresTecnicos dt_uru = new DirectoresTecnicos("Marcelo Bielsa", 1955, 2023);
        Seleccion selUru = new Seleccion("AUF", "uru_kit.png", "uru_alt.png", false, 6, grupoA, uruguay);
        selUru.agregarDirectoresTecnicos(dt_uru);
        uruguay.setSeleccion(selUru);
        grupoA.agregarSeleccion(selUru);

        Jugador suarez   = new Jugador("Luis Suarez",     19870124,  9, null, 0, 0, null);
        Jugador cavani   = new Jugador("Edinson Cavani",  19870214, 21, null, 0, 0, null);
        Jugador valverde = new Jugador("Federico Valverde", 19980722, 8, null, 0, 0, null);
        Jugador bentancur = new Jugador("Rodrigo Bentancur", 19971025, 6, null, 0, 0, null);

        for (Jugador j : new Jugador[]{suarez, cavani, valverde, bentancur})
            registrarJugador(ad, selUru, j);

        // =====================================================================
        // DELEGACIONES — GRUPO B
        // =====================================================================

        // --- FRANCIA ---
        DirectoresTecnicos dt_fra = new DirectoresTecnicos("Didier Deschamps", 1968, 2012);
        Seleccion selFra = new Seleccion("FFF", "fra_kit.png", "fra_alt.png", false, 2, grupoB, francia);
        selFra.agregarDirectoresTecnicos(dt_fra);
        francia.setSeleccion(selFra);
        grupoB.agregarSeleccion(selFra);

        Jugador mbappe   = new Jugador("Kylian Mbappe",   19981220,  9, null, 0, 0, null);
        Jugador griezmann = new Jugador("Antoine Griezmann", 19910321, 7, null, 0, 0, null);
        Jugador tchouameni = new Jugador("Aurelien Tchouameni", 20000116, 8, null, 0, 0, null);
        Jugador kante    = new Jugador("N'Golo Kante",    19910329, 13, null, 0, 0, null);

        for (Jugador j : new Jugador[]{mbappe, griezmann, tchouameni, kante})
            registrarJugador(ad, selFra, j);

        // --- ALEMANIA ---
        DirectoresTecnicos dt_ger = new DirectoresTecnicos("Julian Nagelsmann", 1987, 2023);
        Seleccion selAle = new Seleccion("DFB", "ger_kit.png", "ger_alt.png", false, 4, grupoB, alemania);
        selAle.agregarDirectoresTecnicos(dt_ger);
        alemania.setSeleccion(selAle);
        grupoB.agregarSeleccion(selAle);

        Jugador mueller   = new Jugador("Thomas Mueller",  19891313, 25, null, 0, 0, null);
        Jugador sane      = new Jugador("Leroy Sane",      19960111, 19, null, 0, 0, null);
        Jugador kroos     = new Jugador("Toni Kroos",      19900104,  8, null, 0, 0, null);
        Jugador gnabry    = new Jugador("Serge Gnabry",    19950714, 10, null, 0, 0, null);

        for (Jugador j : new Jugador[]{mueller, sane, kroos, gnabry})
            registrarJugador(ad, selAle, j);

        // --- ESPAÑA ---
        // España no tiene sede propia en este ejemplo, pero igual participa
        DirectoresTecnicos dt_esp = new DirectoresTecnicos("Luis de la Fuente", 1966, 2022);
        Seleccion selEsp = new Seleccion("RFEF", "esp_kit.png", "esp_alt.png", false, 3, grupoB, espania);
        selEsp.agregarDirectoresTecnicos(dt_esp);
        espania.setSeleccion(selEsp);
        grupoB.agregarSeleccion(selEsp);

        Jugador yamal    = new Jugador("Lamine Yamal",   20070716, 22, null, 0, 0, null);
        Jugador morata   = new Jugador("Alvaro Morata",  19920223,  7, null, 0, 0, null);
        Jugador pedri    = new Jugador("Pedri",          20021125,  8, null, 0, 0, null);
        Jugador rodri    = new Jugador("Rodri",          19960622, 16, null, 0, 0, null);

        for (Jugador j : new Jugador[]{yamal, morata, pedri, rodri})
            registrarJugador(ad, selEsp, j);

        // =====================================================================
        // PARTIDOS — GRUPO A
        // =====================================================================

        // --- Partido 1: ARG vs BRA (Argentina gana 2-1) ---
        Partido partido1 = new Partido(20261101, 2000, 0, 0, estadio1, faseGrupos);
        estadio1.agregarPartido(partido1);
        faseGrupos.agregarPartido(partido1);

        agregarArbitraje(partido1, CategoriaArbitro.PRINCIPAL, arbitro1);

        Participacion p1Local    = new Participacion(true,  partido1, selArg);
        Participacion p1Visit    = new Participacion(false, partido1, selBra);
        selArg.agregarParticipacion(p1Local);
        selBra.agregarParticipacion(p1Visit);
        partido1.asignarParticipacionesSinExcepcion(p1Local, p1Visit);

        agregarEvento(partido1, messi,    TipoEvento.GOL,             23);
        agregarEvento(partido1, martinez, TipoEvento.GOL,             67);
        agregarEvento(partido1, vinicius, TipoEvento.GOL,             80);
        agregarEvento(partido1, diMaria,  TipoEvento.TARJETA_AMARILLA, 45);
        agregarEvento(partido1, neymar,   TipoEvento.TARJETA_ROJA,     70);

        // --- Partido 2: URU vs ARG (Empate 1-1) ---
        Partido partido2 = new Partido(20261108, 1800, 0, 0, estadio3, faseGrupos);
        estadio3.agregarPartido(partido2);
        faseGrupos.agregarPartido(partido2);

        agregarArbitraje(partido2, CategoriaArbitro.PRINCIPAL, arbitro2);

        Participacion p2Local = new Participacion(true,  partido2, selUru);
        Participacion p2Visit = new Participacion(false, partido2, selArg);
        selUru.agregarParticipacion(p2Local);
        selArg.agregarParticipacion(p2Visit);
        partido2.asignarParticipacionesSinExcepcion(p2Local, p2Visit);

        agregarEvento(partido2, suarez,   TipoEvento.GOL, 30);   // Uruguay marca
        agregarEvento(partido2, messi,    TipoEvento.GOL, 85);   // Argentina empata
        agregarEvento(partido2, valverde, TipoEvento.TARJETA_AMARILLA, 60);

        // --- Partido 3: BRA vs URU (Brasil gana 3-0) ---
        Partido partido3 = new Partido(20261115, 2100, 0, 0, estadio2, faseGrupos);
        estadio2.agregarPartido(partido3);
        faseGrupos.agregarPartido(partido3);

        agregarArbitraje(partido3, CategoriaArbitro.PRINCIPAL, arbitro3);

        Participacion p3Local = new Participacion(true,  partido3, selBra);
        Participacion p3Visit = new Participacion(false, partido3, selUru);
        selBra.agregarParticipacion(p3Local);
        selUru.agregarParticipacion(p3Visit);
        partido3.asignarParticipacionesSinExcepcion(p3Local, p3Visit);

        agregarEvento(partido3, vinicius, TipoEvento.GOL, 10);
        agregarEvento(partido3, rodrygo,  TipoEvento.GOL, 55);
        agregarEvento(partido3, raphinha, TipoEvento.GOL, 78);
        agregarEvento(partido3, cavani,   TipoEvento.TARJETA_AMARILLA, 40);
        agregarEvento(partido3, bentancur, TipoEvento.TARJETA_ROJA,    88);

        // =====================================================================
        // PARTIDOS — GRUPO B
        // =====================================================================

        // --- Partido 4: FRA vs ALE (Francia gana 2-0) ---
        Partido partido4 = new Partido(20261102, 2000, 0, 0, estadio5, faseGrupos);
        estadio5.agregarPartido(partido4);
        faseGrupos.agregarPartido(partido4);

        agregarArbitraje(partido4, CategoriaArbitro.PRINCIPAL, arbitro4);

        Participacion p4Local = new Participacion(true,  partido4, selFra);
        Participacion p4Visit = new Participacion(false, partido4, selAle);
        selFra.agregarParticipacion(p4Local);
        selAle.agregarParticipacion(p4Visit);
        partido4.asignarParticipacionesSinExcepcion(p4Local, p4Visit);

        agregarEvento(partido4, mbappe,    TipoEvento.GOL, 18);
        agregarEvento(partido4, griezmann, TipoEvento.GOL, 72);
        agregarEvento(partido4, kroos,     TipoEvento.TARJETA_AMARILLA, 55);

        // --- Partido 5: ESP vs ALE (Empate 1-1) ---
        Partido partido5 = new Partido(20261109, 1800, 0, 0, estadio6, faseGrupos);
        estadio6.agregarPartido(partido5);
        faseGrupos.agregarPartido(partido5);

        agregarArbitraje(partido5, CategoriaArbitro.PRINCIPAL, arbitro1);

        Participacion p5Local = new Participacion(true,  partido5, selEsp);
        Participacion p5Visit = new Participacion(false, partido5, selAle);
        selEsp.agregarParticipacion(p5Local);
        selAle.agregarParticipacion(p5Visit);
        partido5.asignarParticipacionesSinExcepcion(p5Local, p5Visit);

        agregarEvento(partido5, yamal,  TipoEvento.GOL, 25);    // España
        agregarEvento(partido5, sane,   TipoEvento.GOL, 90);    // Alemania empata
        agregarEvento(partido5, gnabry, TipoEvento.TARJETA_AMARILLA, 66);

        // --- Partido 6: FRA vs ESP (España gana 1-0) ---
        Partido partido6 = new Partido(20261116, 2100, 0, 0, estadio5, faseGrupos);
        estadio5.agregarPartido(partido6);
        faseGrupos.agregarPartido(partido6);

        agregarArbitraje(partido6, CategoriaArbitro.PRINCIPAL, arbitro2);

        Participacion p6Local = new Participacion(true,  partido6, selFra);
        Participacion p6Visit = new Participacion(false, partido6, selEsp);
        selFra.agregarParticipacion(p6Local);
        selEsp.agregarParticipacion(p6Visit);
        partido6.asignarParticipacionesSinExcepcion(p6Local, p6Visit);

        agregarEvento(partido6, morata,  TipoEvento.GOL,              61);
        agregarEvento(partido6, mbappe,  TipoEvento.TARJETA_AMARILLA, 34);
        agregarEvento(partido6, kante,   TipoEvento.TARJETA_AMARILLA, 78);
        agregarEvento(partido6, pedri,   TipoEvento.DOBLE_AMARILLA,   89);  // expulsado

        // =====================================================================
        // SEMIFINAL: ARG vs FRA
        // =====================================================================
        Partido semifinal1 = new Partido(20261201, 2000, 0, 0, estadio1, faseSemifinal);
        estadio1.agregarPartido(semifinal1);
        faseSemifinal.agregarPartido(semifinal1);

        agregarArbitraje(semifinal1, CategoriaArbitro.PRINCIPAL, arbitro3);

        Participacion sf1Local = new Participacion(true,  semifinal1, selArg);
        Participacion sf1Visit = new Participacion(false, semifinal1, selFra);
        selArg.agregarParticipacion(sf1Local);
        selFra.agregarParticipacion(sf1Visit);
        semifinal1.asignarParticipacionesSinExcepcion(sf1Local, sf1Visit);

        agregarEvento(semifinal1, messi,    TipoEvento.GOL, 45);
        agregarEvento(semifinal1, dybala,   TipoEvento.GOL, 77);
        agregarEvento(semifinal1, mbappe,   TipoEvento.GOL, 88);
        // Argentina gana 2-1

        // =====================================================================
        // SEMIFINAL: ESP vs BRA
        // =====================================================================
        Partido semifinal2 = new Partido(20261202, 2000, 0, 0, estadio2, faseSemifinal);
        estadio2.agregarPartido(semifinal2);
        faseSemifinal.agregarPartido(semifinal2);

        agregarArbitraje(semifinal2, CategoriaArbitro.PRINCIPAL, arbitro4);

        Participacion sf2Local = new Participacion(true,  semifinal2, selEsp);
        Participacion sf2Visit = new Participacion(false, semifinal2, selBra);
        selEsp.agregarParticipacion(sf2Local);
        selBra.agregarParticipacion(sf2Visit);
        semifinal2.asignarParticipacionesSinExcepcion(sf2Local, sf2Visit);

        agregarEvento(semifinal2, yamal,    TipoEvento.GOL, 33);
        agregarEvento(semifinal2, vinicius, TipoEvento.GOL, 70);
        agregarEvento(semifinal2, rodri,    TipoEvento.GOL, 95);
        // España gana 2-1

        // =====================================================================
        // FINAL: ARG vs ESP
        // =====================================================================
        Partido final1 = new Partido(20261215, 2000, 0, 0, estadio1, faseFinal);
        estadio1.agregarPartido(final1);
        faseFinal.agregarPartido(final1);

        agregarArbitraje(final1, CategoriaArbitro.PRINCIPAL, arbitro3);

        Participacion finLocal = new Participacion(true,  final1, selArg);
        Participacion finVisit = new Participacion(false, final1, selEsp);
        selArg.agregarParticipacion(finLocal);
        selEsp.agregarParticipacion(finVisit);
        final1.asignarParticipacionesSinExcepcion(finLocal, finVisit);

        agregarEvento(final1, messi,   TipoEvento.GOL, 38);
        agregarEvento(final1, morata,  TipoEvento.GOL, 67);
        agregarEvento(final1, dybala,  TipoEvento.GOL, 99);
        // Argentina campeón 2-1 en tiempo extra

        return mundial;
    }

    // =========================================================================
    // HELPERS PRIVADOS
    // =========================================================================

    private static void registrarJugador(AdministracionDelegaciones ad,
                                          Seleccion seleccion, Jugador jugador) {
        try {
            ad.registrarJugador(seleccion, jugador);
        } catch (JugadorDuplicadoException e) {
            System.out.println("Jugador duplicado: " + e.getMessage());
        } catch (ValoresNulosException e) {
            System.out.println("Datos nulos al registrar jugador: " + e.getMessage());
        }
    }

    /** Crea y agrega un Arbitraje al partido sin detener la carga si falla. */
    private static void agregarArbitraje(Partido partido,
                                          CategoriaArbitro categoria, Arbitro arbitro) {
        try {
            Arbitraje arbitraje = new Arbitraje(categoria, partido, arbitro);
            partido.agregarArbitraje(arbitraje);
        } catch (Exception e) {
            System.out.println("Error al asignar arbitro a partido " +
                               partido.getFecha() + ": " + e.getMessage());
        }
    }

    /** Crea un Evento y lo vincula al partido y al jugador. */
    private static void agregarEvento(Partido partido, Jugador jugador,
                                       TipoEvento tipo, int minuto) {
        Evento evento = new Evento(tipo, minuto, jugador);
        partido.getEventos().add(evento);
        jugador.agregarEvento(evento);
    }
}