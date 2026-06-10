package MAIN;

import CLASES.*;
import EXCEPCIONES.JugadorDuplicadoException;
import EXCEPCIONES.ValoresNulosException;
import GESTION1.AdministracionDelegaciones;

public class CargadorDatos {

    public static Mundial cargar() {

        Mundial mundial = new Mundial(2026, "Migo", 20260611, 20260719);

        // ===== PAÍSES =====
        Pais argentina = new Pais("Argentina", "arg.png", null);
        Pais brasil = new Pais("Brasil", "bra.png", null);

        // ===== SEDES =====
        Sede sede1 = new Sede("Buenos Aires", 25.0f, "Templado", "GMT-3", argentina);
        argentina.agregarSede(sede1);
        mundial.agregarSede(sede1);

        Sede sede2 = new Sede("Rio de Janeiro", 30.0f, "Tropical", "GMT-3", brasil);
        brasil.agregarSede(sede2);
        mundial.agregarSede(sede2);

        // ===== ESTADIOS =====
        Estadio estadio1 = new Estadio("Monumental", 84567, sede1);
        sede1.agregarEstadio(estadio1);

        Estadio estadio2 = new Estadio("Maracana", 78000, sede2);
        sede2.agregarEstadio(estadio2);

        // ===== FASE Y GRUPO =====
        Fase faseGrupos = new Fase();
        faseGrupos.setNombre(NombreFase.GRUPOS);
        mundial.agregarFase(faseGrupos);

        Grupo grupoA = new Grupo("A", "Grupo A", faseGrupos);
        faseGrupos.agregarGrupo(grupoA);

        // ===== SELECCIÓN ARGENTINA =====
        DirectoresTecnicos dt1 = new DirectoresTecnicos("Lionel Scaloni", 1978, 2018);

        Seleccion selArg = new Seleccion("AFA", "", "", false, 1, grupoA, argentina);
        selArg.agregarDirectoresTecnicos(dt1);
        argentina.setSeleccion(selArg);
        grupoA.agregarSeleccion(selArg);

        AdministracionDelegaciones ad = new AdministracionDelegaciones();

        Jugador messi = new Jugador("Lionel Messi", 19870624, 10, null, 0, 0, null);
        registrarJugador(ad, selArg, messi);

        Jugador diMaria = new Jugador("Angel Di Maria", 19880214, 11, null, 0, 0, null);
        registrarJugador(ad, selArg, diMaria);

        Jugador martinez = new Jugador("Lautaro Martinez", 19971022, 22, null, 0, 0, null);
        registrarJugador(ad, selArg, martinez);

        // ===== SELECCIÓN BRASIL =====
        DirectoresTecnicos dt2 = new DirectoresTecnicos("Carlo Ancelotti", 1959, 2024);

        Seleccion selBra = new Seleccion("CBF", "", "", false, 5, grupoA, brasil);
        selBra.agregarDirectoresTecnicos(dt2);
        brasil.setSeleccion(selBra);
        grupoA.agregarSeleccion(selBra);

        Jugador vinicius = new Jugador("Vinicius Junior", 20000712, 7, null, 0, 0, null);
        registrarJugador(ad, selBra, vinicius);

        Jugador rodrygo = new Jugador("Rodrygo", 20010109, 11, null, 0, 0, null);
        registrarJugador(ad, selBra, rodrygo);

        Jugador neymar = new Jugador("Neymar", 19920205, 10, null, 0, 0, null);
        registrarJugador(ad, selBra, neymar);

        // ===== PARTIDO 1: AFA vs CBF =====
        Partido partido1 = new Partido(20261101, 2000, 0, 0, estadio1, faseGrupos);
        estadio1.agregarPartido(partido1);
        faseGrupos.agregarPartido(partido1);

        Participacion pLocal1 = new Participacion(true, partido1, selArg);
        selArg.agregarParticipacion(pLocal1);

        Participacion pVisitante1 = new Participacion(false, partido1, selBra);
        selBra.agregarParticipacion(pVisitante1);

        partido1.asignarParticipacionesSinExcepcion(pLocal1, pVisitante1);

        // Eventos partido 1
        Evento gol1 = new Evento(TipoEvento.GOL, 23, messi);
        partido1.getEventos().add(gol1);
        messi.agregarEvento(gol1);

        Evento gol2 = new Evento(TipoEvento.GOL, 67, martinez);
        partido1.getEventos().add(gol2);
        martinez.agregarEvento(gol2);

        Evento gol3 = new Evento(TipoEvento.GOL, 80, vinicius);
        partido1.getEventos().add(gol3);
        vinicius.agregarEvento(gol3);

        Evento amarilla1 = new Evento(TipoEvento.TARJETA_AMARILLA, 45, diMaria);
        partido1.getEventos().add(amarilla1);
        diMaria.agregarEvento(amarilla1);

        Evento roja1 = new Evento(TipoEvento.TARJETA_ROJA, 70, neymar);
        partido1.getEventos().add(roja1);
        neymar.agregarEvento(roja1);

        // ===== PARTIDO 2: CBF vs AFA =====
        Partido partido2 = new Partido(20261115, 1800, 0, 0, estadio2, faseGrupos);
        estadio2.agregarPartido(partido2);
        faseGrupos.agregarPartido(partido2);

        Participacion pLocal2 = new Participacion(true, partido2, selBra);
        selBra.agregarParticipacion(pLocal2);

        Participacion pVisitante2 = new Participacion(false, partido2, selArg);
        selArg.agregarParticipacion(pVisitante2);

        partido2.asignarParticipacionesSinExcepcion(pLocal2, pVisitante2);

        // Eventos partido 2
        Evento gol4 = new Evento(TipoEvento.GOL, 10, messi);
        partido2.getEventos().add(gol4);
        messi.agregarEvento(gol4);

        Evento gol5 = new Evento(TipoEvento.GOL, 55, rodrygo);
        partido2.getEventos().add(gol5);
        rodrygo.agregarEvento(gol5);

        Evento amarilla2 = new Evento(TipoEvento.TARJETA_AMARILLA, 30, vinicius);
        partido2.getEventos().add(amarilla2);
        vinicius.agregarEvento(amarilla2);

        return mundial;
    }

    private static void registrarJugador(AdministracionDelegaciones ad, Seleccion seleccion, Jugador jugador) {
        try {
            ad.registrarJugador(seleccion, jugador);
        } catch (JugadorDuplicadoException e) {
            System.out.println("No se pudo registrar jugador duplicado: " + e.getMessage());
        } catch (ValoresNulosException e) {
            System.out.println("No se pudo registrar jugador por datos nulos: " + e.getMessage());
        }
    }
}