package MAIN;

import CLASES.*;
import EXCEPCIONES.JugadorDuplicadoException;
import EXCEPCIONES.ValoresNulosException;
import GESTION1.AdministracionDelegaciones;

public class CargadorDatos {

    public static Mundial cargar() {

        Mundial mundial = new Mundial(2026, "Migo", 20260611, 20260719);

        // ===== PAÍSES =====
        Pais argentina = new Pais();
        argentina.setNombre("Argentina");
        argentina.setBandera("arg.png");

        Pais brasil = new Pais();
        brasil.setNombre("Brasil");
        brasil.setBandera("bra.png");

        // ===== SEDES =====
        Sede sede1 = new Sede("Buenos Aires", 25.0f, "Templado", "GMT-3", argentina);
        argentina.agregarSede(sede1);
        mundial.agregarSede(sede1);

        Sede sede2 = new Sede("Rio de Janeiro", 30.0f, "Tropical", "GMT-3", brasil);
        brasil.agregarSede(sede2);
        mundial.agregarSede(sede2);

        // ===== ESTADIOS =====
        Estadio estadio1 = new Estadio();
        estadio1.setNombre("Monumental");
        estadio1.setCapacidad(84567);
        estadio1.setSede(sede1);
        sede1.agregarEstadio(estadio1);

        Estadio estadio2 = new Estadio();
        estadio2.setNombre("Maracana");
        estadio2.setCapacidad(78000);
        estadio2.setSede(sede2);
        sede2.agregarEstadio(estadio2);

        // ===== FASE Y GRUPO =====
        Fase faseGrupos = new Fase();
        faseGrupos.setNombre(NombreFase.GRUPOS);
        mundial.agregarFase(faseGrupos);

        Grupo grupoA = new Grupo();
        grupoA.setIdentificador("A");
        grupoA.setDescripcion("Grupo A");
        grupoA.setFase(faseGrupos);
        faseGrupos.agregarGrupo(grupoA);

        // ===== SELECCIÓN ARGENTINA =====
        DirectoresTecnicos dt1 = new DirectoresTecnicos("Lionel Scaloni", 1978, 2018);

        Seleccion selArg = new Seleccion();
        selArg.setNombreFederacion("AFA");
        selArg.setPais(argentina);
        selArg.setGrupo(grupoA);
        selArg.setRankingFIFA(1);
        selArg.agregarDirectoresTecnicos(dt1);
        argentina.setSeleccion(selArg);
        grupoA.agregarSeleccion(selArg);

        AdministracionDelegaciones ad = new AdministracionDelegaciones();

        Jugador messi = new Jugador();
        messi.setNombre("Lionel Messi");
        messi.setDorsal(10);
        messi.setFecNacimiento(19870624);
        registrarJugador(ad, selArg, messi);

        Jugador diMaria = new Jugador();
        diMaria.setNombre("Angel Di Maria");
        diMaria.setDorsal(11);
        diMaria.setFecNacimiento(19880214);
        registrarJugador(ad, selArg, diMaria);

        Jugador martinez = new Jugador();
        martinez.setNombre("Lautaro Martinez");
        martinez.setDorsal(22);
        martinez.setFecNacimiento(19971022);
        registrarJugador(ad, selArg, martinez);


        // ===== SELECCIÓN BRASIL =====
        DirectoresTecnicos dt2 = new DirectoresTecnicos("Carlo Ancelotti", 1959, 2024);

        Seleccion selBra = new Seleccion();
        selBra.setNombreFederacion("CBF");
        selBra.setPais(brasil);
        selBra.setGrupo(grupoA);
        selBra.setRankingFIFA(5);
        selBra.agregarDirectoresTecnicos(dt2);
        brasil.setSeleccion(selBra);
        grupoA.agregarSeleccion(selBra);

        Jugador vinicius = new Jugador();
        vinicius.setNombre("Vinicius Junior");
        vinicius.setDorsal(7);
        vinicius.setFecNacimiento(20000712);
        registrarJugador(ad, selBra, vinicius);

        Jugador rodrygo = new Jugador();
        rodrygo.setNombre("Rodrygo");
        rodrygo.setDorsal(11);
        rodrygo.setFecNacimiento(20010109);
        registrarJugador(ad, selBra, rodrygo);

        Jugador neymar = new Jugador();
        neymar.setNombre("Neymar");
        neymar.setDorsal(10);
        neymar.setFecNacimiento( 19920205);
        registrarJugador(ad, selBra, neymar);

        // ===== PARTIDO 1: AFA vs CBF =====
        Partido partido1 = new Partido();
        partido1.setFecha(20261101);
        partido1.setHorario(2000);
        partido1.setFase(faseGrupos);
        partido1.setEstadio(estadio1);
        estadio1.agregarPartido(partido1);
        faseGrupos.agregarPartido(partido1);

        Participacion pLocal1 = new Participacion();
        pLocal1.setEsLocal(true);
        pLocal1.setSeleccion(selArg);
        pLocal1.setPartido(partido1);
        selArg.agregarParticipacion(pLocal1);

        Participacion pVisitante1 = new Participacion();
        pVisitante1.setEsLocal(false);
        pVisitante1.setSeleccion(selBra);
        pVisitante1.setPartido(partido1);
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
        Partido partido2 = new Partido();
        partido2.setFecha(20261115);
        partido2.setHorario(1800);
        partido2.setFase(faseGrupos);
        partido2.setEstadio(estadio2);
        estadio2.agregarPartido(partido2);
        faseGrupos.agregarPartido(partido2);

        Participacion pLocal2 = new Participacion();
        pLocal2.setEsLocal(true);
        pLocal2.setSeleccion(selBra);
        pLocal2.setPartido(partido2);
        selBra.agregarParticipacion(pLocal2);

        Participacion pVisitante2 = new Participacion();
        pVisitante2.setEsLocal(false);
        pVisitante2.setSeleccion(selArg);
        pVisitante2.setPartido(partido2);
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