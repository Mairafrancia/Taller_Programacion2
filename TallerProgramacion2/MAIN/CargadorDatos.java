package MAIN;

import CLASES.*;
import EXCEPCIONES.JugadorDuplicadoException;
import EXCEPCIONES.ValoresNulosException;
import GESTION1.AdministracionDelegaciones;

/**
 * Clase utilitaria encargada de precargar todos los datos iniciales del torneo
 * Mundial 2026.
 * <p>
 * Crea y vincula entre sí todos los objetos del modelo: países, sedes,
 * estadios, fases,
 * grupos, árbitros, selecciones, cuerpos técnicos, jugadores, partidos,
 * participaciones
 * y eventos. Al finalizar, devuelve un objeto {@link Mundial} completamente
 * inicializado
 * y listo para ser usado por el {@link SistemaInteractivo}.
 * </p>
 * <p>
 * La carga abarca:
 * <ul>
 * <li>16 países participantes con sus respectivas sedes y estadios.</li>
 * <li>6 fases del torneo: Grupos, Octavos, Cuartos, Semifinal, Tercer Puesto y
 * Final.</li>
 * <li>4 grupos (A, B, C, D) con 4 selecciones cada uno.</li>
 * <li>7 árbitros internacionales.</li>
 * <li>16 selecciones con directores técnicos, cuerpos técnicos y
 * jugadores.</li>
 * <li>33 partidos con árbitros, participaciones y eventos (goles y
 * tarjetas).</li>
 * </ul>
 * </p>
 */
public class CargadorDatos {

    /**
     * Carga y devuelve el objeto {@link Mundial} con todos los datos precargados
     * del torneo.
     * <p>
     * Este método es el punto de entrada principal de la clase. Construye toda la
     * estructura
     * del torneo de forma secuencial: primero los países y sedes, luego los
     * estadios, las
     * fases, los grupos, los árbitros, las delegaciones (por grupo) y finalmente
     * los partidos
     * de cada fase con sus eventos asociados.
     * </p>
     *
     * @return Un objeto {@link Mundial} completamente inicializado con todos los
     *         datos del torneo 2026.
     */
    public static Mundial cargar() {

        Mundial mundial = new Mundial(2026, "Migo", 20260611, 20260719);

        // =====================================================================
        // PAÍSES
        // =====================================================================
        Pais argentina = new Pais("Argentina", "arg.png", null);
        Pais brasil = new Pais("Brasil", "bra.png", null);
        Pais uruguay = new Pais("Uruguay", "uru.png", null);
        Pais colombia = new Pais("Colombia", "col.png", null);
        Pais francia = new Pais("Francia", "fra.png", null);
        Pais alemania = new Pais("Alemania", "ger.png", null);
        Pais espania = new Pais("Espania", "esp.png", null);
        Pais mexico = new Pais("Mexico", "mex.png", null);
        Pais portugal = new Pais("Portugal", "por.png", null);
        Pais italia = new Pais("Italia", "ita.png", null);
        Pais inglaterra = new Pais("Inglaterra", "eng.png", null);
        Pais holanda = new Pais("Holanda", "ned.png", null);
        Pais croatia = new Pais("Croacia", "cro.png", null);
        Pais senegal = new Pais("Senegal", "sen.png", null);
        Pais japon = new Pais("Japon", "jpn.png", null);
        Pais marruecos = new Pais("Marruecos", "mar.png", null);
        // Polonia: país del árbitro Szymon Marciniak; no tiene sede en el torneo.
        Pais polonia = new Pais("Polonia", "pol.png", null);

        // =====================================================================
        // SEDES — cada país participante tiene una sede asociada
        // =====================================================================
        Sede sede1 = new Sede("Buenos Aires", 25.0f, "Templado", "GMT-3", argentina);
        Sede sede2 = new Sede("Rio de Janeiro", 30.0f, "Tropical", "GMT-3", brasil);
        Sede sede3 = new Sede("Montevideo", 22.0f, "Templado", "GMT-3", uruguay);
        Sede sede4 = new Sede("Bogota", 18.0f, "Frio", "GMT-5", colombia);
        Sede sede5 = new Sede("Paris", 15.0f, "Frio", "GMT+1", francia);
        Sede sede6 = new Sede("Berlin", 12.0f, "Frio", "GMT+1", alemania);
        Sede sede7 = new Sede("Madrid", 18.0f, "Templado", "GMT+1", espania);
        Sede sede8 = new Sede("Ciudad de Mexico", 20.0f, "Templado", "GMT-6", mexico);
        Sede sede9 = new Sede("Lisboa", 19.0f, "Templado", "GMT+0", portugal);
        Sede sede10 = new Sede("Roma", 22.0f, "Templado", "GMT+1", italia);
        Sede sede11 = new Sede("Londres", 14.0f, "Nublado", "GMT+0", inglaterra);
        Sede sede12 = new Sede("Amsterdam", 13.0f, "Nublado", "GMT+1", holanda);
        Sede sede13 = new Sede("Zagreb", 17.0f, "Templado", "GMT+1", croatia);
        Sede sede14 = new Sede("Dakar", 28.0f, "Tropical", "GMT+0", senegal);
        Sede sede15 = new Sede("Tokio", 22.0f, "Templado", "GMT+9", japon);
        Sede sede16 = new Sede("Casablanca", 24.0f, "Templado", "GMT+1", marruecos);

        Pais[] todosPaises = { argentina, brasil, uruguay, colombia, francia, alemania,
                espania, mexico, portugal, italia, inglaterra,
                holanda, croatia, senegal, japon, marruecos };
        Sede[] todasSedes = { sede1, sede2, sede3, sede4, sede5, sede6,
                sede7, sede8, sede9, sede10, sede11,
                sede12, sede13, sede14, sede15, sede16 };

        for (int i = 0; i < todosPaises.length; i++) {
            todosPaises[i].agregarSede(todasSedes[i]);
            mundial.agregarSede(todasSedes[i]);
        }

        // =====================================================================
        // ESTADIOS — uno por sede
        // =====================================================================
        Estadio estadio1 = new Estadio("Monumental", 84567, sede1);
        Estadio estadio2 = new Estadio("Maracana", 78000, sede2);
        Estadio estadio3 = new Estadio("Centenario", 60000, sede3);
        Estadio estadio4 = new Estadio("El Campin", 45000, sede4);
        Estadio estadio5 = new Estadio("Stade de France", 80698, sede5);
        Estadio estadio6 = new Estadio("Olympiastadion", 74475, sede6);
        Estadio estadio7 = new Estadio("Santiago Bernabeu", 81044, sede7);
        Estadio estadio8 = new Estadio("Estadio Azteca", 87523, sede8);
        Estadio estadio9 = new Estadio("Estadio da Luz", 64642, sede9);
        Estadio estadio10 = new Estadio("Estadio Olimpico", 70634, sede10);
        Estadio estadio11 = new Estadio("Wembley", 90000, sede11);
        Estadio estadio12 = new Estadio("Johan Cruyff Arena", 54990, sede12);
        Estadio estadio13 = new Estadio("Estadio Maksimir", 35123, sede13);
        Estadio estadio14 = new Estadio("Estadio Leopold Sedar", 60000, sede14);
        Estadio estadio15 = new Estadio("Estadio Nacional", 68000, sede15);
        Estadio estadio16 = new Estadio("Grand Stade de Casablanca", 93000, sede16);

        sede1.agregarEstadio(estadio1);
        sede2.agregarEstadio(estadio2);
        sede3.agregarEstadio(estadio3);
        sede4.agregarEstadio(estadio4);
        sede5.agregarEstadio(estadio5);
        sede6.agregarEstadio(estadio6);
        sede7.agregarEstadio(estadio7);
        sede8.agregarEstadio(estadio8);
        sede9.agregarEstadio(estadio9);
        sede10.agregarEstadio(estadio10);
        sede11.agregarEstadio(estadio11);
        sede12.agregarEstadio(estadio12);
        sede13.agregarEstadio(estadio13);
        sede14.agregarEstadio(estadio14);
        sede15.agregarEstadio(estadio15);
        sede16.agregarEstadio(estadio16);

        // =====================================================================
        // FASES del torneo en orden ascendente de instancia
        // IMPORTANTE: el orden en NombreFase determina la instancia máxima
        // alcanzada mediante ordinal() en TablaDeResultadosPorSeleccion.
        // =====================================================================
        Fase faseGrupos = new Fase();
        faseGrupos.setNombre(NombreFase.GRUPOS);
        Fase faseOctavos = new Fase();
        faseOctavos.setNombre(NombreFase.OCTAVOS_DE_FINAL);
        Fase faseCuartos = new Fase();
        faseCuartos.setNombre(NombreFase.CUARTOS_DE_FINAL);
        Fase faseSemi = new Fase();
        faseSemi.setNombre(NombreFase.SEMIFINAL);
        Fase faseTercero = new Fase();
        faseTercero.setNombre(NombreFase.TERCER_PUESTO);
        Fase faseFinal = new Fase();
        faseFinal.setNombre(NombreFase.FINAL);

        mundial.agregarFase(faseGrupos);
        mundial.agregarFase(faseOctavos);
        mundial.agregarFase(faseCuartos);
        mundial.agregarFase(faseSemi);
        mundial.agregarFase(faseTercero);
        mundial.agregarFase(faseFinal);

        // =====================================================================
        // GRUPOS de la fase de grupos
        // =====================================================================
        Grupo grupoA = new Grupo("A", "Grupo A", faseGrupos);
        Grupo grupoB = new Grupo("B", "Grupo B", faseGrupos);
        Grupo grupoC = new Grupo("C", "Grupo C", faseGrupos);
        Grupo grupoD = new Grupo("D", "Grupo D", faseGrupos);

        faseGrupos.agregarGrupo(grupoA);
        faseGrupos.agregarGrupo(grupoB);
        faseGrupos.agregarGrupo(grupoC);
        faseGrupos.agregarGrupo(grupoD);

        // =====================================================================
        // ÁRBITROS internacionales del torneo
        // =====================================================================
        Arbitro arbitro1 = new Arbitro("Roberto Tobar", 19750310, 15, colombia);
        Arbitro arbitro2 = new Arbitro("Clement Turpin", 19820118, 12, francia);
        Arbitro arbitro3 = new Arbitro("Felix Brych", 19750808, 18, alemania);
        Arbitro arbitro4 = new Arbitro("Daniele Orsato", 19750205, 20, italia);
        Arbitro arbitro5 = new Arbitro("Szymon Marciniak", 19810117, 10, polonia);
        Arbitro arbitro6 = new Arbitro("Anthony Taylor", 19790920, 14, inglaterra);
        Arbitro arbitro7 = new Arbitro("Raphael Claus", 19800312, 9, brasil);

        // =====================================================================
        // DELEGACIONES — se usa AdministracionDelegaciones para registrar jugadores
        // con control de duplicados a nivel global del torneo.
        // =====================================================================
        AdministracionDelegaciones ad = new AdministracionDelegaciones();

        // =====================================================================
        // GRUPO A: Argentina, Brasil, Mexico, Senegal
        // =====================================================================

        // --- ARGENTINA ---
        DirectoresTecnicos dt_arg = new DirectoresTecnicos("Lionel Scaloni", 19780516, 20180101);
        Seleccion selArg = new Seleccion("AFA", "argkit.png", "argalt.png", true, 1, grupoA, argentina);
        selArg.agregarDirectoresTecnicos(dt_arg);
        argentina.setSeleccion(selArg);
        grupoA.agregarSeleccion(selArg);

        CuerpoTecnico ct_arg1 = new CuerpoTecnico();
        ct_arg1.setNombre("Pablo Aimar");
        ct_arg1.setRol(Rol.AYUDANTECAMPO);
        CuerpoTecnico ct_arg2 = new CuerpoTecnico();
        ct_arg2.setNombre("Luis Islas");
        ct_arg2.setRol(Rol.ENTRENADORARQUEROS);
        CuerpoTecnico ct_arg3 = new CuerpoTecnico();
        ct_arg3.setNombre("Ricardo Vacchi");
        ct_arg3.setRol(Rol.PREPARADORFISICO);
        selArg.agregarCuerpoTecnico(ct_arg1);
        selArg.agregarCuerpoTecnico(ct_arg2);
        selArg.agregarCuerpoTecnico(ct_arg3);

        Jugador messi = new Jugador("Lionel Messi", 19870624, 10, null, 0, 0, null);
        Jugador diMaria = new Jugador("Angel Di Maria", 19880214, 11, null, 0, 0, null);
        Jugador martinez = new Jugador("Lautaro Martinez", 19971022, 22, null, 0, 0, null);
        Jugador romero = new Jugador("Cristian Romero", 19980327, 2, null, 0, 0, null);
        Jugador dybala = new Jugador("Paulo Dybala", 19931115, 21, null, 0, 0, null);
        Jugador depaul = new Jugador("Rodrigo De Paul", 19940524, 7, null, 0, 0, null);
        Jugador molina = new Jugador("Nahuel Molina", 19980406, 26, null, 0, 0, null);
        Jugador emiliano = new Jugador("Emiliano Martinez", 19920902, 1, null, 0, 0, null);

        for (Jugador j : new Jugador[] { messi, diMaria, martinez, romero, dybala, depaul, molina, emiliano })
            registrarJugador(ad, selArg, j);

        // --- BRASIL ---
        DirectoresTecnicos dt_bra = new DirectoresTecnicos("Carlo Ancelotti", 19590610, 20240101);
        Seleccion selBra = new Seleccion("CBF", "brakit.png", "braalt.png", false, 3, grupoA, brasil);
        selBra.agregarDirectoresTecnicos(dt_bra);
        brasil.setSeleccion(selBra);
        grupoA.agregarSeleccion(selBra);

        CuerpoTecnico ct_bra1 = new CuerpoTecnico();
        ct_bra1.setNombre("Davide Ancelotti");
        ct_bra1.setRol(Rol.AYUDANTECAMPO);
        CuerpoTecnico ct_bra2 = new CuerpoTecnico();
        ct_bra2.setNombre("Taffarel");
        ct_bra2.setRol(Rol.ENTRENADORARQUEROS);
        selBra.agregarCuerpoTecnico(ct_bra1);
        selBra.agregarCuerpoTecnico(ct_bra2);

        Jugador vinicius = new Jugador("Vinicius Junior", 20000712, 7, null, 0, 0, null);
        Jugador rodrygo = new Jugador("Rodrygo", 20010109, 11, null, 0, 0, null);
        Jugador neymar = new Jugador("Neymar", 19920205, 10, null, 0, 0, null);
        Jugador casemiro = new Jugador("Casemiro", 19920223, 5, null, 0, 0, null);
        Jugador raphinha = new Jugador("Raphinha", 19960614, 17, null, 0, 0, null);
        Jugador militao = new Jugador("Eder Militao", 19980118, 3, null, 0, 0, null);
        Jugador paqueta = new Jugador("Lucas Paqueta", 19970827, 20, null, 0, 0, null);
        Jugador endrick = new Jugador("Endrick", 20060721, 9, null, 0, 0, null);

        for (Jugador j : new Jugador[] { vinicius, rodrygo, neymar, casemiro, raphinha, militao, paqueta, endrick })
            registrarJugador(ad, selBra, j);

        // --- MEXICO ---
        DirectoresTecnicos dt_mex = new DirectoresTecnicos("Javier Aguirre", 19580101, 20230101);
        Seleccion selMex = new Seleccion("FMF", "mexkit.png", "mexalt.png", false, 15, grupoA, mexico);
        selMex.agregarDirectoresTecnicos(dt_mex);
        mexico.setSeleccion(selMex);
        grupoA.agregarSeleccion(selMex);

        Jugador lozano = new Jugador("Hirving Lozano", 19950730, 22, null, 0, 0, null);
        Jugador chicharito = new Jugador("Javier Hernandez", 19840601, 14, null, 0, 0, null);
        Jugador guardado = new Jugador("Andres Guardado", 19860928, 8, null, 0, 0, null);
        Jugador ochoa = new Jugador("Guillermo Ochoa", 19850713, 1, null, 0, 0, null);
        Jugador alvarez = new Jugador("Edson Alvarez", 19971024, 6, null, 0, 0, null);
        Jugador corona = new Jugador("Jesus Corona", 19930106, 23, null, 0, 0, null);

        for (Jugador j : new Jugador[] { lozano, chicharito, guardado, ochoa, alvarez, corona })
            registrarJugador(ad, selMex, j);

        // --- SENEGAL ---
        DirectoresTecnicos dt_sen = new DirectoresTecnicos("Aliou Cisse", 19760824, 20150101);
        Seleccion selSen = new Seleccion("FSF", "senkit.png", "senalt.png", false, 20, grupoA, senegal);
        selSen.agregarDirectoresTecnicos(dt_sen);
        senegal.setSeleccion(selSen);
        grupoA.agregarSeleccion(selSen);

        Jugador mane = new Jugador("Sadio Mane", 19920410, 10, null, 0, 0, null);
        Jugador diallo = new Jugador("Abdou Diallo", 19960404, 5, null, 0, 0, null);
        Jugador gueye = new Jugador("Idrissa Gueye", 19891126, 6, null, 0, 0, null);
        Jugador mendy = new Jugador("Edouard Mendy", 19920301, 1, null, 0, 0, null);
        Jugador dia = new Jugador("Boulaye Dia", 19961116, 11, null, 0, 0, null);

        for (Jugador j : new Jugador[] { mane, diallo, gueye, mendy, dia })
            registrarJugador(ad, selSen, j);

        // =====================================================================
        // GRUPO B: Francia, Alemania, Portugal, Marruecos
        // =====================================================================

        // --- FRANCIA ---
        DirectoresTecnicos dt_fra = new DirectoresTecnicos("Didier Deschamps", 19681015, 20120101);
        Seleccion selFra = new Seleccion("FFF", "frakit.png", "fraalt.png", true, 2, grupoB, francia);
        selFra.agregarDirectoresTecnicos(dt_fra);
        francia.setSeleccion(selFra);
        grupoB.agregarSeleccion(selFra);

        CuerpoTecnico ct_fra1 = new CuerpoTecnico();
        ct_fra1.setNombre("Guy Stephan");
        ct_fra1.setRol(Rol.AYUDANTECAMPO);
        CuerpoTecnico ct_fra2 = new CuerpoTecnico();
        ct_fra2.setNombre("Franck Raviot");
        ct_fra2.setRol(Rol.ENTRENADORARQUEROS);
        selFra.agregarCuerpoTecnico(ct_fra1);
        selFra.agregarCuerpoTecnico(ct_fra2);

        Jugador mbappe = new Jugador("Kylian Mbappe", 19981220, 9, null, 0, 0, null);
        Jugador griezmann = new Jugador("Antoine Griezmann", 19910321, 7, null, 0, 0, null);
        Jugador tchouameni = new Jugador("Aurelien Tchouameni", 20000116, 8, null, 0, 0, null);
        Jugador kante = new Jugador("NGolo Kante", 19910329, 13, null, 0, 0, null);
        Jugador maignan = new Jugador("Mike Maignan", 19950726, 1, null, 0, 0, null);
        Jugador theo = new Jugador("Theo Hernandez", 19971006, 22, null, 0, 0, null);
        Jugador camavinga = new Jugador("Eduardo Camavinga", 20030110, 29, null, 0, 0, null);

        for (Jugador j : new Jugador[] { mbappe, griezmann, tchouameni, kante, maignan, theo, camavinga })
            registrarJugador(ad, selFra, j);

        // --- ALEMANIA ---
        DirectoresTecnicos dt_ger = new DirectoresTecnicos("Julian Nagelsmann", 19870723, 20230101);
        Seleccion selAle = new Seleccion("DFB", "gerkit.png", "geralt.png", false, 4, grupoB, alemania);
        selAle.agregarDirectoresTecnicos(dt_ger);
        alemania.setSeleccion(selAle);
        grupoB.agregarSeleccion(selAle);

        Jugador mueller = new Jugador("Thomas Mueller", 19891213, 25, null, 0, 0, null);
        Jugador sane = new Jugador("Leroy Sane", 19960111, 19, null, 0, 0, null);
        Jugador kroos = new Jugador("Toni Kroos", 19900104, 8, null, 0, 0, null);
        Jugador gnabry = new Jugador("Serge Gnabry", 19950714, 10, null, 0, 0, null);
        Jugador ter = new Jugador("Marc ter Stegen", 19920430, 1, null, 0, 0, null);
        Jugador rudiger = new Jugador("Antonio Rudiger", 19930303, 2, null, 0, 0, null);
        Jugador musiala = new Jugador("Jamal Musiala", 20030226, 14, null, 0, 0, null);

        for (Jugador j : new Jugador[] { mueller, sane, kroos, gnabry, ter, rudiger, musiala })
            registrarJugador(ad, selAle, j);

        // --- PORTUGAL ---
        DirectoresTecnicos dt_por = new DirectoresTecnicos("Roberto Martinez", 19730213, 20230101);
        Seleccion selPor = new Seleccion("FPF", "porkit.png", "poralt.png", false, 6, grupoB, portugal);
        selPor.agregarDirectoresTecnicos(dt_por);
        portugal.setSeleccion(selPor);
        grupoB.agregarSeleccion(selPor);

        Jugador ronaldo = new Jugador("Cristiano Ronaldo", 19850205, 7, null, 0, 0, null);
        Jugador felix = new Jugador("Joao Felix", 19991110, 11, null, 0, 0, null);
        Jugador bernardo = new Jugador("Bernardo Silva", 19940810, 10, null, 0, 0, null);
        Jugador cancelo = new Jugador("Joao Cancelo", 19940527, 2, null, 0, 0, null);
        Jugador dias = new Jugador("Ruben Dias", 19970514, 4, null, 0, 0, null);
        Jugador vitinha = new Jugador("Vitinha", 20010213, 8, null, 0, 0, null);

        for (Jugador j : new Jugador[] { ronaldo, felix, bernardo, cancelo, dias, vitinha })
            registrarJugador(ad, selPor, j);

        // --- MARRUECOS ---
        DirectoresTecnicos dt_mar = new DirectoresTecnicos("Walid Regragui", 19750811, 20220101);
        Seleccion selMar = new Seleccion("FRMF", "markit.png", "maralt.png", false, 13, grupoB, marruecos);
        selMar.agregarDirectoresTecnicos(dt_mar);
        marruecos.setSeleccion(selMar);
        grupoB.agregarSeleccion(selMar);

        Jugador ziyech = new Jugador("Hakim Ziyech", 19921019, 22, null, 0, 0, null);
        Jugador ennesyri = new Jugador("Youssef En Nesyri", 19970101, 9, null, 0, 0, null);
        Jugador hakimi = new Jugador("Achraf Hakimi", 19981104, 2, null, 0, 0, null);
        Jugador amrabat = new Jugador("Sofyan Amrabat", 19960821, 4, null, 0, 0, null);
        Jugador bounou = new Jugador("Yassine Bounou", 19910405, 1, null, 0, 0, null);

        for (Jugador j : new Jugador[] { ziyech, ennesyri, hakimi, amrabat, bounou })
            registrarJugador(ad, selMar, j);

        // =====================================================================
        // GRUPO C: España, Italia, Croacia, Japon
        // =====================================================================

        // --- ESPAÑA ---
        DirectoresTecnicos dt_esp = new DirectoresTecnicos("Luis de la Fuente", 19661225, 20220101);
        Seleccion selEsp = new Seleccion("RFEF", "espkit.png", "espalt.png", true, 5, grupoC, espania);
        selEsp.agregarDirectoresTecnicos(dt_esp);
        espania.setSeleccion(selEsp);
        grupoC.agregarSeleccion(selEsp);

        CuerpoTecnico ct_esp1 = new CuerpoTecnico();
        ct_esp1.setNombre("Mikel Etxarri");
        ct_esp1.setRol(Rol.AYUDANTECAMPO);
        CuerpoTecnico ct_esp2 = new CuerpoTecnico();
        ct_esp2.setNombre("Jose Manzanera");
        ct_esp2.setRol(Rol.ENTRENADORARQUEROS);
        CuerpoTecnico ct_esp3 = new CuerpoTecnico();
        ct_esp3.setNombre("Rafael Pol");
        ct_esp3.setRol(Rol.PREPARADORFISICO);
        selEsp.agregarCuerpoTecnico(ct_esp1);
        selEsp.agregarCuerpoTecnico(ct_esp2);
        selEsp.agregarCuerpoTecnico(ct_esp3);

        Jugador yamal = new Jugador("Lamine Yamal", 20070716, 22, null, 0, 0, null);
        Jugador morata = new Jugador("Alvaro Morata", 19920223, 7, null, 0, 0, null);
        Jugador pedri = new Jugador("Pedri", 20021125, 8, null, 0, 0, null);
        Jugador rodri = new Jugador("Rodri", 19960622, 16, null, 0, 0, null);
        Jugador carvajal = new Jugador("Dani Carvajal", 19920111, 2, null, 0, 0, null);
        Jugador olmo = new Jugador("Dani Olmo", 19980507, 10, null, 0, 0, null);
        Jugador simon = new Jugador("Unai Simon", 19970604, 1, null, 0, 0, null);

        for (Jugador j : new Jugador[] { yamal, morata, pedri, rodri, carvajal, olmo, simon })
            registrarJugador(ad, selEsp, j);

        // --- ITALIA ---
        DirectoresTecnicos dt_ita = new DirectoresTecnicos("Luciano Spalletti", 19590307, 20230101);
        Seleccion selIta = new Seleccion("FIGC", "itakit.png", "itaalt.png", false, 9, grupoC, italia);
        selIta.agregarDirectoresTecnicos(dt_ita);
        italia.setSeleccion(selIta);
        grupoC.agregarSeleccion(selIta);

        Jugador chiesa = new Jugador("Federico Chiesa", 19970325, 14, null, 0, 0, null);
        Jugador barella = new Jugador("Nicolo Barella", 19971107, 18, null, 0, 0, null);
        Jugador verratti = new Jugador("Marco Verratti", 19920105, 6, null, 0, 0, null);
        Jugador donnarumma = new Jugador("Gianluigi Donnarumma", 19990225, 1, null, 0, 0, null);
        Jugador bonucci = new Jugador("Leonardo Bonucci", 19870101, 19, null, 0, 0, null);
        Jugador immobile = new Jugador("Ciro Immobile", 19900220, 17, null, 0, 0, null);

        for (Jugador j : new Jugador[] { chiesa, barella, verratti, donnarumma, bonucci, immobile })
            registrarJugador(ad, selIta, j);

        // --- CROACIA ---
        DirectoresTecnicos dt_cro = new DirectoresTecnicos("Zlatko Dalic", 19661026, 20170101);
        Seleccion selCro = new Seleccion("HNS", "crokit.png", "croalt.png", false, 10, grupoC, croatia);
        selCro.agregarDirectoresTecnicos(dt_cro);
        croatia.setSeleccion(selCro);
        grupoC.agregarSeleccion(selCro);

        Jugador modric = new Jugador("Luka Modric", 19850909, 10, null, 0, 0, null);
        Jugador kovacic = new Jugador("Mateo Kovacic", 19940606, 8, null, 0, 0, null);
        Jugador perisic = new Jugador("Ivan Perisic", 19890202, 4, null, 0, 0, null);
        Jugador gvardiol = new Jugador("Josko Gvardiol", 20020123, 24, null, 0, 0, null);
        Jugador livakovic = new Jugador("Dominik Livakovic", 19950109, 1, null, 0, 0, null);

        for (Jugador j : new Jugador[] { modric, kovacic, perisic, gvardiol, livakovic })
            registrarJugador(ad, selCro, j);

        // --- JAPON ---
        DirectoresTecnicos dt_jpn = new DirectoresTecnicos("Hajime Moriyasu", 19680823, 20180101);
        Seleccion selJpn = new Seleccion("JFA", "jpnkit.png", "jpnalt.png", false, 18, grupoC, japon);
        selJpn.agregarDirectoresTecnicos(dt_jpn);
        japon.setSeleccion(selJpn);
        grupoC.agregarSeleccion(selJpn);

        Jugador kubo = new Jugador("Takefusa Kubo", 20010104, 11, null, 0, 0, null);
        Jugador doan = new Jugador("Ritsu Doan", 19980316, 21, null, 0, 0, null);
        Jugador minamino = new Jugador("Takumi Minamino", 19950116, 10, null, 0, 0, null);
        Jugador tanaka = new Jugador("Ao Tanaka", 19981112, 8, null, 0, 0, null);
        Jugador gonda = new Jugador("Shuichi Gonda", 19890301, 1, null, 0, 0, null);

        for (Jugador j : new Jugador[] { kubo, doan, minamino, tanaka, gonda })
            registrarJugador(ad, selJpn, j);

        // =====================================================================
        // GRUPO D: Inglaterra, Holanda, Colombia, Uruguay
        // =====================================================================

        // --- INGLATERRA ---
        DirectoresTecnicos dt_eng = new DirectoresTecnicos("Gareth Southgate", 19700903, 20160101);
        Seleccion selEng = new Seleccion("FA", "engkit.png", "engalt.png", true, 7, grupoD, inglaterra);
        selEng.agregarDirectoresTecnicos(dt_eng);
        inglaterra.setSeleccion(selEng);
        grupoD.agregarSeleccion(selEng);

        CuerpoTecnico ct_eng1 = new CuerpoTecnico();
        ct_eng1.setNombre("Steve Holland");
        ct_eng1.setRol(Rol.AYUDANTECAMPO);
        CuerpoTecnico ct_eng2 = new CuerpoTecnico();
        ct_eng2.setNombre("Martyn Margetson");
        ct_eng2.setRol(Rol.ENTRENADORARQUEROS);
        selEng.agregarCuerpoTecnico(ct_eng1);
        selEng.agregarCuerpoTecnico(ct_eng2);

        Jugador bellingham = new Jugador("Jude Bellingham", 20030629, 10, null, 0, 0, null);
        Jugador saka = new Jugador("Bukayo Saka", 20010905, 7, null, 0, 0, null);
        Jugador kane = new Jugador("Harry Kane", 19931128, 9, null, 0, 0, null);
        Jugador trippier = new Jugador("Kieran Trippier", 19900919, 2, null, 0, 0, null);
        Jugador pickford = new Jugador("Jordan Pickford", 19940307, 1, null, 0, 0, null);
        Jugador foden = new Jugador("Phil Foden", 20000528, 11, null, 0, 0, null);
        Jugador rice = new Jugador("Declan Rice", 19990114, 4, null, 0, 0, null);

        for (Jugador j : new Jugador[] { bellingham, saka, kane, trippier, pickford, foden, rice })
            registrarJugador(ad, selEng, j);

        // --- HOLANDA ---
        DirectoresTecnicos dt_ned = new DirectoresTecnicos("Ronald Koeman", 19630323, 20230101);
        Seleccion selNed = new Seleccion("KNVB", "nedkit.png", "nedalt.png", false, 8, grupoD, holanda);
        selNed.agregarDirectoresTecnicos(dt_ned);
        holanda.setSeleccion(selNed);
        grupoD.agregarSeleccion(selNed);

        Jugador depay = new Jugador("Memphis Depay", 19940213, 9, null, 0, 0, null);
        Jugador dumfries = new Jugador("Denzel Dumfries", 19960418, 2, null, 0, 0, null);
        Jugador deligt = new Jugador("Matthijs de Ligt", 19990812, 4, null, 0, 0, null);
        Jugador gakpo = new Jugador("Cody Gakpo", 19990507, 11, null, 0, 0, null);
        Jugador flekken = new Jugador("Mark Flekken", 19930313, 1, null, 0, 0, null);

        for (Jugador j : new Jugador[] { depay, dumfries, deligt, gakpo, flekken })
            registrarJugador(ad, selNed, j);

        // --- COLOMBIA ---
        DirectoresTecnicos dt_col = new DirectoresTecnicos("Nestor Lorenzo", 19660227, 20220101);
        Seleccion selCol = new Seleccion("FCF", "colkit.png", "colalt.png", false, 12, grupoD, colombia);
        selCol.agregarDirectoresTecnicos(dt_col);
        colombia.setSeleccion(selCol);
        grupoD.agregarSeleccion(selCol);

        Jugador james = new Jugador("James Rodriguez", 19910712, 10, null, 0, 0, null);
        Jugador cuadrado = new Jugador("Juan Cuadrado", 19880526, 11, null, 0, 0, null);
        Jugador falcao = new Jugador("Radamel Falcao", 19860210, 9, null, 0, 0, null);
        Jugador munoz = new Jugador("Daniel Munoz", 19960120, 2, null, 0, 0, null);
        Jugador ospina = new Jugador("David Ospina", 19880831, 1, null, 0, 0, null);

        for (Jugador j : new Jugador[] { james, cuadrado, falcao, munoz, ospina })
            registrarJugador(ad, selCol, j);

        // --- URUGUAY ---
        DirectoresTecnicos dt_uru = new DirectoresTecnicos("Marcelo Bielsa", 19550725, 20230101);
        Seleccion selUru = new Seleccion("AUF", "urukit.png", "urualt.png", false, 11, grupoD, uruguay);
        selUru.agregarDirectoresTecnicos(dt_uru);
        uruguay.setSeleccion(selUru);
        grupoD.agregarSeleccion(selUru);

        Jugador suarez = new Jugador("Luis Suarez", 19870124, 9, null, 0, 0, null);
        Jugador cavani = new Jugador("Edinson Cavani", 19870214, 21, null, 0, 0, null);
        Jugador valverde = new Jugador("Federico Valverde", 19980722, 8, null, 0, 0, null);
        Jugador bentancur = new Jugador("Rodrigo Bentancur", 19971025, 6, null, 0, 0, null);
        Jugador araujo = new Jugador("Ronald Araujo", 19990307, 4, null, 0, 0, null);
        Jugador nunez = new Jugador("Darwin Nunez", 19990624, 11, null, 0, 0, null);

        for (Jugador j : new Jugador[] { suarez, cavani, valverde, bentancur, araujo, nunez })
            registrarJugador(ad, selUru, j);

        // =====================================================================
        // PARTIDOS — GRUPO A
        // Cada bloque crea el partido, asigna árbitro, participaciones y eventos.
        // Convención de resultados: los goles cargados determinan el marcador final.
        // =====================================================================

        // ARG vs BRA — Argentina gana 2-1
        Partido gA1 = new Partido(20260615, 2000, 0, 0, estadio1, faseGrupos);
        estadio1.agregarPartido(gA1);
        faseGrupos.agregarPartido(gA1);
        agregarArbitraje(gA1, CategoriaArbitro.PRINCIPAL, arbitro1);
        Participacion gA1L = new Participacion(true, gA1, selArg);
        Participacion gA1V = new Participacion(false, gA1, selBra);
        selArg.agregarParticipacion(gA1L);
        selBra.agregarParticipacion(gA1V);
        gA1.asignarParticipacionesSinExcepcion(gA1L, gA1V);
        agregarEvento(gA1, messi, TipoEvento.GOL, 23);
        agregarEvento(gA1, martinez, TipoEvento.GOL, 67);
        agregarEvento(gA1, vinicius, TipoEvento.GOL, 80);
        agregarEvento(gA1, diMaria, TipoEvento.TARJETA_AMARILLA, 45);
        agregarEvento(gA1, neymar, TipoEvento.TARJETA_ROJA, 70);

        // MEX vs SEN — Mexico gana 1-0
        Partido gA2 = new Partido(20260615, 1800, 0, 0, estadio8, faseGrupos);
        estadio8.agregarPartido(gA2);
        faseGrupos.agregarPartido(gA2);
        agregarArbitraje(gA2, CategoriaArbitro.PRINCIPAL, arbitro7);
        Participacion gA2L = new Participacion(true, gA2, selMex);
        Participacion gA2V = new Participacion(false, gA2, selSen);
        selMex.agregarParticipacion(gA2L);
        selSen.agregarParticipacion(gA2V);
        gA2.asignarParticipacionesSinExcepcion(gA2L, gA2V);
        agregarEvento(gA2, lozano, TipoEvento.GOL, 55);
        agregarEvento(gA2, mane, TipoEvento.TARJETA_AMARILLA, 70);

        // ARG vs MEX — Argentina gana 2-0
        Partido gA3 = new Partido(20260619, 2100, 0, 0, estadio1, faseGrupos);
        estadio1.agregarPartido(gA3);
        faseGrupos.agregarPartido(gA3);
        agregarArbitraje(gA3, CategoriaArbitro.PRINCIPAL, arbitro2);
        Participacion gA3L = new Participacion(true, gA3, selArg);
        Participacion gA3V = new Participacion(false, gA3, selMex);
        selArg.agregarParticipacion(gA3L);
        selMex.agregarParticipacion(gA3V);
        gA3.asignarParticipacionesSinExcepcion(gA3L, gA3V);
        agregarEvento(gA3, dybala, TipoEvento.GOL, 33);
        agregarEvento(gA3, messi, TipoEvento.GOL, 87);

        // BRA vs SEN — Brasil gana 3-1
        Partido gA4 = new Partido(20260619, 1800, 0, 0, estadio2, faseGrupos);
        estadio2.agregarPartido(gA4);
        faseGrupos.agregarPartido(gA4);
        agregarArbitraje(gA4, CategoriaArbitro.PRINCIPAL, arbitro3);
        Participacion gA4L = new Participacion(true, gA4, selBra);
        Participacion gA4V = new Participacion(false, gA4, selSen);
        selBra.agregarParticipacion(gA4L);
        selSen.agregarParticipacion(gA4V);
        gA4.asignarParticipacionesSinExcepcion(gA4L, gA4V);
        agregarEvento(gA4, vinicius, TipoEvento.GOL, 11);
        agregarEvento(gA4, rodrygo, TipoEvento.GOL, 45);
        agregarEvento(gA4, mane, TipoEvento.GOL, 60);
        agregarEvento(gA4, raphinha, TipoEvento.GOL, 88);

        // ARG vs SEN — Argentina gana 1-0
        Partido gA5 = new Partido(20260623, 2000, 0, 0, estadio1, faseGrupos);
        estadio1.agregarPartido(gA5);
        faseGrupos.agregarPartido(gA5);
        agregarArbitraje(gA5, CategoriaArbitro.PRINCIPAL, arbitro4);
        Participacion gA5L = new Participacion(true, gA5, selArg);
        Participacion gA5V = new Participacion(false, gA5, selSen);
        selArg.agregarParticipacion(gA5L);
        selSen.agregarParticipacion(gA5V);
        gA5.asignarParticipacionesSinExcepcion(gA5L, gA5V);
        agregarEvento(gA5, martinez, TipoEvento.GOL, 72);
        agregarEvento(gA5, gueye, TipoEvento.TARJETA_AMARILLA, 55);

        // BRA vs MEX — Brasil gana 2-0
        Partido gA6 = new Partido(20260623, 2000, 0, 0, estadio2, faseGrupos);
        estadio2.agregarPartido(gA6);
        faseGrupos.agregarPartido(gA6);
        agregarArbitraje(gA6, CategoriaArbitro.PRINCIPAL, arbitro6);
        Participacion gA6L = new Participacion(true, gA6, selBra);
        Participacion gA6V = new Participacion(false, gA6, selMex);
        selBra.agregarParticipacion(gA6L);
        selMex.agregarParticipacion(gA6V);
        gA6.asignarParticipacionesSinExcepcion(gA6L, gA6V);
        agregarEvento(gA6, endrick, TipoEvento.GOL, 30);
        agregarEvento(gA6, vinicius, TipoEvento.GOL, 78);
        agregarEvento(gA6, chicharito, TipoEvento.TARJETA_AMARILLA, 50);

        // =====================================================================
        // PARTIDOS — GRUPO B
        // =====================================================================

        // FRA vs ALE — Francia gana 2-0
        Partido gB1 = new Partido(20260616, 2000, 0, 0, estadio5, faseGrupos);
        estadio5.agregarPartido(gB1);
        faseGrupos.agregarPartido(gB1);
        agregarArbitraje(gB1, CategoriaArbitro.PRINCIPAL, arbitro5);
        Participacion gB1L = new Participacion(true, gB1, selFra);
        Participacion gB1V = new Participacion(false, gB1, selAle);
        selFra.agregarParticipacion(gB1L);
        selAle.agregarParticipacion(gB1V);
        gB1.asignarParticipacionesSinExcepcion(gB1L, gB1V);
        agregarEvento(gB1, mbappe, TipoEvento.GOL, 18);
        agregarEvento(gB1, griezmann, TipoEvento.GOL, 72);
        agregarEvento(gB1, kroos, TipoEvento.TARJETA_AMARILLA, 55);

        // POR vs MAR — Portugal gana 2-1
        Partido gB2 = new Partido(20260616, 1800, 0, 0, estadio9, faseGrupos);
        estadio9.agregarPartido(gB2);
        faseGrupos.agregarPartido(gB2);
        agregarArbitraje(gB2, CategoriaArbitro.PRINCIPAL, arbitro1);
        Participacion gB2L = new Participacion(true, gB2, selPor);
        Participacion gB2V = new Participacion(false, gB2, selMar);
        selPor.agregarParticipacion(gB2L);
        selMar.agregarParticipacion(gB2V);
        gB2.asignarParticipacionesSinExcepcion(gB2L, gB2V);
        agregarEvento(gB2, ronaldo, TipoEvento.GOL, 25);
        agregarEvento(gB2, felix, TipoEvento.GOL, 66);
        agregarEvento(gB2, ennesyri, TipoEvento.GOL, 80);

        // FRA vs POR — Empate 1-1
        Partido gB3 = new Partido(20260620, 2100, 0, 0, estadio5, faseGrupos);
        estadio5.agregarPartido(gB3);
        faseGrupos.agregarPartido(gB3);
        agregarArbitraje(gB3, CategoriaArbitro.PRINCIPAL, arbitro4);
        Participacion gB3L = new Participacion(true, gB3, selFra);
        Participacion gB3V = new Participacion(false, gB3, selPor);
        selFra.agregarParticipacion(gB3L);
        selPor.agregarParticipacion(gB3V);
        gB3.asignarParticipacionesSinExcepcion(gB3L, gB3V);
        agregarEvento(gB3, mbappe, TipoEvento.GOL, 40);
        agregarEvento(gB3, ronaldo, TipoEvento.GOL, 85);
        agregarEvento(gB3, bernardo, TipoEvento.TARJETA_AMARILLA, 60);

        // ALE vs MAR — Alemania gana 3-0
        Partido gB4 = new Partido(20260620, 1800, 0, 0, estadio6, faseGrupos);
        estadio6.agregarPartido(gB4);
        faseGrupos.agregarPartido(gB4);
        agregarArbitraje(gB4, CategoriaArbitro.PRINCIPAL, arbitro7);
        Participacion gB4L = new Participacion(true, gB4, selAle);
        Participacion gB4V = new Participacion(false, gB4, selMar);
        selAle.agregarParticipacion(gB4L);
        selMar.agregarParticipacion(gB4V);
        gB4.asignarParticipacionesSinExcepcion(gB4L, gB4V);
        agregarEvento(gB4, musiala, TipoEvento.GOL, 20);
        agregarEvento(gB4, sane, TipoEvento.GOL, 55);
        agregarEvento(gB4, gnabry, TipoEvento.GOL, 78);

        // FRA vs MAR — Francia gana 1-0
        Partido gB5 = new Partido(20260624, 2000, 0, 0, estadio5, faseGrupos);
        estadio5.agregarPartido(gB5);
        faseGrupos.agregarPartido(gB5);
        agregarArbitraje(gB5, CategoriaArbitro.PRINCIPAL, arbitro3);
        Participacion gB5L = new Participacion(true, gB5, selFra);
        Participacion gB5V = new Participacion(false, gB5, selMar);
        selFra.agregarParticipacion(gB5L);
        selMar.agregarParticipacion(gB5V);
        gB5.asignarParticipacionesSinExcepcion(gB5L, gB5V);
        agregarEvento(gB5, camavinga, TipoEvento.GOL, 61);
        agregarEvento(gB5, ziyech, TipoEvento.TARJETA_AMARILLA, 44);

        // POR vs ALE — Portugal gana 2-1
        Partido gB6 = new Partido(20260624, 2000, 0, 0, estadio9, faseGrupos);
        estadio9.agregarPartido(gB6);
        faseGrupos.agregarPartido(gB6);
        agregarArbitraje(gB6, CategoriaArbitro.PRINCIPAL, arbitro2);
        Participacion gB6L = new Participacion(true, gB6, selPor);
        Participacion gB6V = new Participacion(false, gB6, selAle);
        selPor.agregarParticipacion(gB6L);
        selAle.agregarParticipacion(gB6V);
        gB6.asignarParticipacionesSinExcepcion(gB6L, gB6V);
        agregarEvento(gB6, ronaldo, TipoEvento.GOL, 10);
        agregarEvento(gB6, vitinha, TipoEvento.GOL, 70);
        agregarEvento(gB6, mueller, TipoEvento.GOL, 88);
        agregarEvento(gB6, kroos, TipoEvento.TARJETA_AMARILLA, 45);

        // =====================================================================
        // PARTIDOS — GRUPO C
        // =====================================================================

        // ESP vs ITA — España gana 2-1
        Partido gC1 = new Partido(20260617, 2000, 0, 0, estadio7, faseGrupos);
        estadio7.agregarPartido(gC1);
        faseGrupos.agregarPartido(gC1);
        agregarArbitraje(gC1, CategoriaArbitro.PRINCIPAL, arbitro6);
        Participacion gC1L = new Participacion(true, gC1, selEsp);
        Participacion gC1V = new Participacion(false, gC1, selIta);
        selEsp.agregarParticipacion(gC1L);
        selIta.agregarParticipacion(gC1V);
        gC1.asignarParticipacionesSinExcepcion(gC1L, gC1V);
        agregarEvento(gC1, yamal, TipoEvento.GOL, 25);
        agregarEvento(gC1, olmo, TipoEvento.GOL, 71);
        agregarEvento(gC1, chiesa, TipoEvento.GOL, 88);
        agregarEvento(gC1, barella, TipoEvento.TARJETA_AMARILLA, 55);

        // CRO vs JPN — Empate 1-1
        Partido gC2 = new Partido(20260617, 1800, 0, 0, estadio13, faseGrupos);
        estadio13.agregarPartido(gC2);
        faseGrupos.agregarPartido(gC2);
        agregarArbitraje(gC2, CategoriaArbitro.PRINCIPAL, arbitro1);
        Participacion gC2L = new Participacion(true, gC2, selCro);
        Participacion gC2V = new Participacion(false, gC2, selJpn);
        selCro.agregarParticipacion(gC2L);
        selJpn.agregarParticipacion(gC2V);
        gC2.asignarParticipacionesSinExcepcion(gC2L, gC2V);
        agregarEvento(gC2, modric, TipoEvento.GOL, 45);
        agregarEvento(gC2, minamino, TipoEvento.GOL, 80);

        // ESP vs CRO — España gana 3-0
        Partido gC3 = new Partido(20260621, 2000, 0, 0, estadio7, faseGrupos);
        estadio7.agregarPartido(gC3);
        faseGrupos.agregarPartido(gC3);
        agregarArbitraje(gC3, CategoriaArbitro.PRINCIPAL, arbitro5);
        Participacion gC3L = new Participacion(true, gC3, selEsp);
        Participacion gC3V = new Participacion(false, gC3, selCro);
        selEsp.agregarParticipacion(gC3L);
        selCro.agregarParticipacion(gC3V);
        gC3.asignarParticipacionesSinExcepcion(gC3L, gC3V);
        agregarEvento(gC3, morata, TipoEvento.GOL, 15);
        agregarEvento(gC3, pedri, TipoEvento.GOL, 50);
        agregarEvento(gC3, yamal, TipoEvento.GOL, 90);
        agregarEvento(gC3, perisic, TipoEvento.TARJETA_ROJA, 75);

        // ITA vs JPN — Italia gana 2-0
        Partido gC4 = new Partido(20260621, 1800, 0, 0, estadio10, faseGrupos);
        estadio10.agregarPartido(gC4);
        faseGrupos.agregarPartido(gC4);
        agregarArbitraje(gC4, CategoriaArbitro.PRINCIPAL, arbitro7);
        Participacion gC4L = new Participacion(true, gC4, selIta);
        Participacion gC4V = new Participacion(false, gC4, selJpn);
        selIta.agregarParticipacion(gC4L);
        selJpn.agregarParticipacion(gC4V);
        gC4.asignarParticipacionesSinExcepcion(gC4L, gC4V);
        agregarEvento(gC4, immobile, TipoEvento.GOL, 30);
        agregarEvento(gC4, chiesa, TipoEvento.GOL, 65);

        // ESP vs JPN — España gana 1-0
        Partido gC5 = new Partido(20260625, 2000, 0, 0, estadio7, faseGrupos);
        estadio7.agregarPartido(gC5);
        faseGrupos.agregarPartido(gC5);
        agregarArbitraje(gC5, CategoriaArbitro.PRINCIPAL, arbitro2);
        Participacion gC5L = new Participacion(true, gC5, selEsp);
        Participacion gC5V = new Participacion(false, gC5, selJpn);
        selEsp.agregarParticipacion(gC5L);
        selJpn.agregarParticipacion(gC5V);
        gC5.asignarParticipacionesSinExcepcion(gC5L, gC5V);
        agregarEvento(gC5, rodri, TipoEvento.GOL, 58);
        agregarEvento(gC5, kubo, TipoEvento.TARJETA_AMARILLA, 70);

        // ITA vs CRO — Empate 0-0 (sin goles, Italia avanza por diferencia)
        Partido gC6 = new Partido(20260625, 2000, 0, 0, estadio10, faseGrupos);
        estadio10.agregarPartido(gC6);
        faseGrupos.agregarPartido(gC6);
        agregarArbitraje(gC6, CategoriaArbitro.PRINCIPAL, arbitro4);
        Participacion gC6L = new Participacion(true, gC6, selIta);
        Participacion gC6V = new Participacion(false, gC6, selCro);
        selIta.agregarParticipacion(gC6L);
        selCro.agregarParticipacion(gC6V);
        gC6.asignarParticipacionesSinExcepcion(gC6L, gC6V);
        agregarEvento(gC6, kovacic, TipoEvento.TARJETA_AMARILLA, 40);
        agregarEvento(gC6, barella, TipoEvento.TARJETA_AMARILLA, 78);

        // =====================================================================
        // PARTIDOS — GRUPO D
        // =====================================================================

        // ENG vs NED — Inglaterra gana 2-1
        Partido gD1 = new Partido(20260618, 2000, 0, 0, estadio11, faseGrupos);
        estadio11.agregarPartido(gD1);
        faseGrupos.agregarPartido(gD1);
        agregarArbitraje(gD1, CategoriaArbitro.PRINCIPAL, arbitro3);
        Participacion gD1L = new Participacion(true, gD1, selEng);
        Participacion gD1V = new Participacion(false, gD1, selNed);
        selEng.agregarParticipacion(gD1L);
        selNed.agregarParticipacion(gD1V);
        gD1.asignarParticipacionesSinExcepcion(gD1L, gD1V);
        agregarEvento(gD1, kane, TipoEvento.GOL, 35);
        agregarEvento(gD1, bellingham, TipoEvento.GOL, 70);
        agregarEvento(gD1, gakpo, TipoEvento.GOL, 82);

        // COL vs URU — Uruguay gana 2-1
        Partido gD2 = new Partido(20260618, 1800, 0, 0, estadio4, faseGrupos);
        estadio4.agregarPartido(gD2);
        faseGrupos.agregarPartido(gD2);
        agregarArbitraje(gD2, CategoriaArbitro.PRINCIPAL, arbitro5);
        Participacion gD2L = new Participacion(true, gD2, selCol);
        Participacion gD2V = new Participacion(false, gD2, selUru);
        selCol.agregarParticipacion(gD2L);
        selUru.agregarParticipacion(gD2V);
        gD2.asignarParticipacionesSinExcepcion(gD2L, gD2V);
        agregarEvento(gD2, james, TipoEvento.GOL, 20);
        agregarEvento(gD2, nunez, TipoEvento.GOL, 55);
        agregarEvento(gD2, suarez, TipoEvento.GOL, 88);
        agregarEvento(gD2, falcao, TipoEvento.TARJETA_AMARILLA, 40);

        // ENG vs COL — Inglaterra gana 3-0
        Partido gD3 = new Partido(20260622, 2000, 0, 0, estadio11, faseGrupos);
        estadio11.agregarPartido(gD3);
        faseGrupos.agregarPartido(gD3);
        agregarArbitraje(gD3, CategoriaArbitro.PRINCIPAL, arbitro1);
        Participacion gD3L = new Participacion(true, gD3, selEng);
        Participacion gD3V = new Participacion(false, gD3, selCol);
        selEng.agregarParticipacion(gD3L);
        selCol.agregarParticipacion(gD3V);
        gD3.asignarParticipacionesSinExcepcion(gD3L, gD3V);
        agregarEvento(gD3, saka, TipoEvento.GOL, 22);
        agregarEvento(gD3, kane, TipoEvento.GOL, 58);
        agregarEvento(gD3, foden, TipoEvento.GOL, 79);
        agregarEvento(gD3, cuadrado, TipoEvento.TARJETA_ROJA, 65);

        // NED vs URU — Empate 1-1
        Partido gD4 = new Partido(20260622, 1800, 0, 0, estadio12, faseGrupos);
        estadio12.agregarPartido(gD4);
        faseGrupos.agregarPartido(gD4);
        agregarArbitraje(gD4, CategoriaArbitro.PRINCIPAL, arbitro6);
        Participacion gD4L = new Participacion(true, gD4, selNed);
        Participacion gD4V = new Participacion(false, gD4, selUru);
        selNed.agregarParticipacion(gD4L);
        selUru.agregarParticipacion(gD4V);
        gD4.asignarParticipacionesSinExcepcion(gD4L, gD4V);
        agregarEvento(gD4, depay, TipoEvento.GOL, 44);
        agregarEvento(gD4, cavani, TipoEvento.GOL, 77);
        agregarEvento(gD4, valverde, TipoEvento.TARJETA_AMARILLA, 60);

        // ENG vs URU — Inglaterra gana 1-0
        Partido gD5 = new Partido(20260626, 2000, 0, 0, estadio11, faseGrupos);
        estadio11.agregarPartido(gD5);
        faseGrupos.agregarPartido(gD5);
        agregarArbitraje(gD5, CategoriaArbitro.PRINCIPAL, arbitro4);
        Participacion gD5L = new Participacion(true, gD5, selEng);
        Participacion gD5V = new Participacion(false, gD5, selUru);
        selEng.agregarParticipacion(gD5L);
        selUru.agregarParticipacion(gD5V);
        gD5.asignarParticipacionesSinExcepcion(gD5L, gD5V);
        agregarEvento(gD5, rice, TipoEvento.GOL, 63);
        agregarEvento(gD5, araujo, TipoEvento.TARJETA_AMARILLA, 55);

        // NED vs COL — Holanda gana 2-0
        Partido gD6 = new Partido(20260626, 2000, 0, 0, estadio12, faseGrupos);
        estadio12.agregarPartido(gD6);
        faseGrupos.agregarPartido(gD6);
        agregarArbitraje(gD6, CategoriaArbitro.PRINCIPAL, arbitro2);
        Participacion gD6L = new Participacion(true, gD6, selNed);
        Participacion gD6V = new Participacion(false, gD6, selCol);
        selNed.agregarParticipacion(gD6L);
        selCol.agregarParticipacion(gD6V);
        gD6.asignarParticipacionesSinExcepcion(gD6L, gD6V);
        agregarEvento(gD6, gakpo, TipoEvento.GOL, 30);
        agregarEvento(gD6, depay, TipoEvento.GOL, 75);
        agregarEvento(gD6, ospina, TipoEvento.TARJETA_AMARILLA, 88);

        // =====================================================================
        // OCTAVOS DE FINAL
        // =====================================================================

        // ARG vs POR — Argentina gana 2-1
        Partido oct1 = new Partido(20260629, 2000, 0, 0, estadio1, faseOctavos);
        estadio1.agregarPartido(oct1);
        faseOctavos.agregarPartido(oct1);
        agregarArbitraje(oct1, CategoriaArbitro.PRINCIPAL, arbitro2);
        Participacion oct1L = new Participacion(true, oct1, selArg);
        Participacion oct1V = new Participacion(false, oct1, selPor);
        selArg.agregarParticipacion(oct1L);
        selPor.agregarParticipacion(oct1V);
        oct1.asignarParticipacionesSinExcepcion(oct1L, oct1V);
        agregarEvento(oct1, messi, TipoEvento.GOL, 30);
        agregarEvento(oct1, depaul, TipoEvento.GOL, 78);
        agregarEvento(oct1, ronaldo, TipoEvento.GOL, 90);

        // FRA vs BRA — Francia gana 1-0
        Partido oct2 = new Partido(20260630, 2000, 0, 0, estadio5, faseOctavos);
        estadio5.agregarPartido(oct2);
        faseOctavos.agregarPartido(oct2);
        agregarArbitraje(oct2, CategoriaArbitro.PRINCIPAL, arbitro5);
        Participacion oct2L = new Participacion(true, oct2, selFra);
        Participacion oct2V = new Participacion(false, oct2, selBra);
        selFra.agregarParticipacion(oct2L);
        selBra.agregarParticipacion(oct2V);
        oct2.asignarParticipacionesSinExcepcion(oct2L, oct2V);
        agregarEvento(oct2, mbappe, TipoEvento.GOL, 55);
        agregarEvento(oct2, neymar, TipoEvento.TARJETA_AMARILLA, 70);
        agregarEvento(oct2, casemiro, TipoEvento.TARJETA_ROJA, 88);

        // ESP vs NED — España gana 2-0
        Partido oct3 = new Partido(20260701, 2000, 0, 0, estadio7, faseOctavos);
        estadio7.agregarPartido(oct3);
        faseOctavos.agregarPartido(oct3);
        agregarArbitraje(oct3, CategoriaArbitro.PRINCIPAL, arbitro4);
        Participacion oct3L = new Participacion(true, oct3, selEsp);
        Participacion oct3V = new Participacion(false, oct3, selNed);
        selEsp.agregarParticipacion(oct3L);
        selNed.agregarParticipacion(oct3V);
        oct3.asignarParticipacionesSinExcepcion(oct3L, oct3V);
        agregarEvento(oct3, olmo, TipoEvento.GOL, 40);
        agregarEvento(oct3, morata, TipoEvento.GOL, 85);
        agregarEvento(oct3, dumfries, TipoEvento.TARJETA_AMARILLA, 60);

        // ENG vs ITA — Inglaterra gana 2-1
        Partido oct4 = new Partido(20260702, 2000, 0, 0, estadio11, faseOctavos);
        estadio11.agregarPartido(oct4);
        faseOctavos.agregarPartido(oct4);
        agregarArbitraje(oct4, CategoriaArbitro.PRINCIPAL, arbitro3);
        Participacion oct4L = new Participacion(true, oct4, selEng);
        Participacion oct4V = new Participacion(false, oct4, selIta);
        selEng.agregarParticipacion(oct4L);
        selIta.agregarParticipacion(oct4V);
        oct4.asignarParticipacionesSinExcepcion(oct4L, oct4V);
        agregarEvento(oct4, kane, TipoEvento.GOL, 22);
        agregarEvento(oct4, chiesa, TipoEvento.GOL, 60);
        agregarEvento(oct4, bellingham, TipoEvento.GOL, 95);
        agregarEvento(oct4, bonucci, TipoEvento.TARJETA_AMARILLA, 78);

        // =====================================================================
        // CUARTOS DE FINAL
        // =====================================================================

        // ARG vs FRA — Argentina gana 1-0
        Partido cuar1 = new Partido(20260705, 2000, 0, 0, estadio1, faseCuartos);
        estadio1.agregarPartido(cuar1);
        faseCuartos.agregarPartido(cuar1);
        agregarArbitraje(cuar1, CategoriaArbitro.PRINCIPAL, arbitro6);
        Participacion cuar1L = new Participacion(true, cuar1, selArg);
        Participacion cuar1V = new Participacion(false, cuar1, selFra);
        selArg.agregarParticipacion(cuar1L);
        selFra.agregarParticipacion(cuar1V);
        cuar1.asignarParticipacionesSinExcepcion(cuar1L, cuar1V);
        agregarEvento(cuar1, dybala, TipoEvento.GOL, 67);
        agregarEvento(cuar1, mbappe, TipoEvento.TARJETA_AMARILLA, 50);
        agregarEvento(cuar1, griezmann, TipoEvento.TARJETA_AMARILLA, 80);

        // ESP vs ENG — España gana 2-1
        Partido cuar2 = new Partido(20260706, 2000, 0, 0, estadio7, faseCuartos);
        estadio7.agregarPartido(cuar2);
        faseCuartos.agregarPartido(cuar2);
        agregarArbitraje(cuar2, CategoriaArbitro.PRINCIPAL, arbitro7);
        Participacion cuar2L = new Participacion(true, cuar2, selEsp);
        Participacion cuar2V = new Participacion(false, cuar2, selEng);
        selEsp.agregarParticipacion(cuar2L);
        selEng.agregarParticipacion(cuar2V);
        cuar2.asignarParticipacionesSinExcepcion(cuar2L, cuar2V);
        agregarEvento(cuar2, yamal, TipoEvento.GOL, 33);
        agregarEvento(cuar2, kane, TipoEvento.GOL, 60);
        agregarEvento(cuar2, pedri, TipoEvento.GOL, 88);
        agregarEvento(cuar2, trippier, TipoEvento.TARJETA_AMARILLA, 75);

        // =====================================================================
        // SEMIFINAL: ARG vs ESP — Argentina gana 2-1
        // =====================================================================
        Partido semi1 = new Partido(20260709, 2000, 0, 0, estadio1, faseSemi);
        estadio1.agregarPartido(semi1);
        faseSemi.agregarPartido(semi1);
        agregarArbitraje(semi1, CategoriaArbitro.PRINCIPAL, arbitro5);
        Participacion semi1L = new Participacion(true, semi1, selArg);
        Participacion semi1V = new Participacion(false, semi1, selEsp);
        selArg.agregarParticipacion(semi1L);
        selEsp.agregarParticipacion(semi1V);
        semi1.asignarParticipacionesSinExcepcion(semi1L, semi1V);
        agregarEvento(semi1, messi, TipoEvento.GOL, 45);
        agregarEvento(semi1, dybala, TipoEvento.GOL, 77);
        agregarEvento(semi1, morata, TipoEvento.GOL, 88);
        agregarEvento(semi1, rodri, TipoEvento.TARJETA_AMARILLA, 60);

        // =====================================================================
        // TERCER PUESTO: FRA vs ENG — Francia gana 2-1
        // =====================================================================
        Partido tercero = new Partido(20260712, 1800, 0, 0, estadio5, faseTercero);
        estadio5.agregarPartido(tercero);
        faseTercero.agregarPartido(tercero);
        agregarArbitraje(tercero, CategoriaArbitro.PRINCIPAL, arbitro1);
        Participacion terL = new Participacion(true, tercero, selFra);
        Participacion terV = new Participacion(false, tercero, selEng);
        selFra.agregarParticipacion(terL);
        selEng.agregarParticipacion(terV);
        tercero.asignarParticipacionesSinExcepcion(terL, terV);
        agregarEvento(tercero, mbappe, TipoEvento.GOL, 20);
        agregarEvento(tercero, griezmann, TipoEvento.GOL, 55);
        agregarEvento(tercero, kane, TipoEvento.GOL, 70);
        agregarEvento(tercero, theo, TipoEvento.TARJETA_AMARILLA, 88);

        // =====================================================================
        // FINAL: ARG vs ESP — Argentina campeón 2-1
        // =====================================================================
        Partido final1 = new Partido(20260719, 2000, 0, 0, estadio1, faseFinal);
        estadio1.agregarPartido(final1);
        faseFinal.agregarPartido(final1);
        agregarArbitraje(final1, CategoriaArbitro.PRINCIPAL, arbitro3);
        Participacion finL = new Participacion(true, final1, selArg);
        Participacion finV = new Participacion(false, final1, selEsp);
        selArg.agregarParticipacion(finL);
        selEsp.agregarParticipacion(finV);
        final1.asignarParticipacionesSinExcepcion(finL, finV);
        agregarEvento(final1, messi, TipoEvento.GOL, 38);
        agregarEvento(final1, morata, TipoEvento.GOL, 67);
        agregarEvento(final1, dybala, TipoEvento.GOL, 99);
        agregarEvento(final1, carvajal, TipoEvento.TARJETA_AMARILLA, 55);

        return mundial;
    }

    // =========================================================================
    // HELPERS PRIVADOS
    // =========================================================================

    /**
     * Registra un jugador en una selección usando
     * {@link AdministracionDelegaciones}.
     * Captura y muestra por consola las excepciones de jugador duplicado o datos
     * nulos,
     * sin interrumpir la carga del resto de los datos.
     *
     * @param ad        Instancia de {@link AdministracionDelegaciones} que gestiona
     *                  el registro.
     * @param seleccion La selección a la que se integrará el jugador.
     * @param jugador   El jugador a registrar.
     */
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

    /**
     * Crea un {@link Arbitraje} y lo asigna al partido indicado.
     * Captura y muestra por consola cualquier excepción sin interrumpir la carga.
     *
     * @param partido   El partido al que se asigna el arbitraje.
     * @param categoria La categoría del árbitro según {@link CategoriaArbitro}.
     * @param arbitro   El árbitro que officiará el partido.
     */
    private static void agregarArbitraje(Partido partido,
            CategoriaArbitro categoria, Arbitro arbitro) {
        try {
            Arbitraje arbitraje = new Arbitraje(categoria, partido, arbitro);
            partido.agregarArbitraje(arbitraje);
        } catch (Exception e) {
            System.out.println("Error al asignar arbitro: " + e.getMessage());
        }
    }

    /**
     * Crea un {@link Evento} y lo registra tanto en el partido como en el jugador,
     * manteniendo la consistencia bidireccional de la asociación.
     *
     * @param partido El partido donde ocurre el evento.
     * @param jugador El jugador protagonista del evento.
     * @param tipo    El tipo de evento según {@link TipoEvento}.
     * @param minuto  El minuto del partido en que ocurrió el evento.
     */
    private static void agregarEvento(Partido partido, Jugador jugador,
            TipoEvento tipo, int minuto) {
        Evento evento = new Evento(tipo, minuto, jugador);
        partido.getEventos().add(evento);
        jugador.agregarEvento(evento);
    }
}