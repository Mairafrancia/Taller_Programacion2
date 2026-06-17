package MAIN;

import CLASES.*;
import GESTION1.*;
import GESTION2.*;
import EXCEPCIONES.*;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * Clase principal de interaccion con el usuario para el sistema de gestion
 * del Torneo Mundial 2026. Provee un menu de consola con 11 opciones que
 * cubren la gestion de infraestructura, delegaciones, organizacion deportiva,
 * registro de eventos y generacion de reportes.
 *
 * <p>
 * Al iniciarse, carga automaticamente los datos del torneo mediante
 * {@link CargadorDatos} e instancia todos los modulos de gestion y reporte.
 * </p>
 *
 * @author Florencia Benitez
 * @author Agustina Barreto
 * @author Francia Maira
 * @author Gabriela Yañez
 */
public class SistemaInteractivo {

    /** Scanner para leer la entrada del usuario por consola. */
    private Scanner scanner;

    /** Objeto principal del torneo que contiene todas las entidades. */
    private Mundial mundial;

    /** Modulo de gestion de infraestructura (sedes y estadios). */
    private GestionInfraestructura gi;

    /**
     * Modulo de administracion de delegaciones (selecciones, jugadores, tecnicos).
     */
    private AdministracionDelegaciones ad;

    /** Modulo de organizacion deportiva (grupos, partidos, arbitrajes). */
    private OrganizacionDeportiva od;

    /** Modulo de registro de eventos de campo. */
    private RegistrosEventosCampos rec;

    /** Reporte: tabla de posiciones por grupo. */
    private TablaDePosicionesPorGrupo tablaPosiciones;

    /** Reporte: tabla de resultados por seleccion. */
    private TablaDeResultadosPorSeleccion tablaResultados;

    /** Reporte: ranking de goleadores por seleccion. */
    private RankingDeGoleadores rankingGoles;

    /** Reporte: informe disciplinario por seleccion o jugador. */
    private InformeDisciplinario informeCards;

    /** Reporte: ficha tecnica de un partido. */
    private FichaTecnicaDeUnPartido fichaTecnica;

    /** Reporte: estadisticas de partidos por estadio o ciudad. */
    private EstadisticasDeSedes estadisticasSedes;

    /** Lista de fases del torneo, obtenida del mundial al iniciar. */
    private ArrayList<Fase> fases;

    /**
     * Constructor. Inicializa todos los modulos del sistema y carga
     * los datos del torneo mediante {@link CargadorDatos#cargar()}.
     */
    public SistemaInteractivo() {
        this.scanner = new Scanner(System.in);
        this.mundial = CargadorDatos.cargar();
        this.gi = new GestionInfraestructura();
        this.ad = new AdministracionDelegaciones();
        this.od = new OrganizacionDeportiva();
        this.rec = new RegistrosEventosCampos();
        this.tablaPosiciones = new TablaDePosicionesPorGrupo();
        this.tablaResultados = new TablaDeResultadosPorSeleccion();
        this.rankingGoles = new RankingDeGoleadores();
        this.informeCards = new InformeDisciplinario();
        this.fichaTecnica = new FichaTecnicaDeUnPartido();
        this.estadisticasSedes = new EstadisticasDeSedes();
        this.fases = mundial.getFases();
    }

    /**
     * Inicia el bucle principal del sistema. Muestra el menu principal
     * y procesa la opcion del usuario hasta que se elige salir.
     */
    public void iniciar() {
        boolean salir = false;
        while (!salir) {
            mostrarMenuPrincipal();
            int opcion = leerOpcion();
            salir = procesarMenuPrincipal(opcion);
        }
        System.out.println("\n>>> Gracias por usar el sistema. Hasta luego!");
        scanner.close();
    }

    /**
     * Imprime el menu principal del sistema por consola.
     */
    private void mostrarMenuPrincipal() {
        System.out.print("\n+------------------------------------------------------------+\n"
                + "| SISTEMA DE GESTION DEL TORNEO MUNDIAL 2026                |\n"
                + "+------------------------------------------------------------+\n"
                + "| 1. Gestionar infraestructura                               |\n"
                + "| 2. Administrar delegaciones                                |\n"
                + "| 3. Organizar partidos                                      |\n"
                + "| 4. Registrar eventos de campo                              |\n"
                + "| 5. Tabla de posiciones por grupo                           |\n"
                + "| 6. Tabla de resultados por seleccion                       |\n"
                + "| 7. Ranking de goleadores                                   |\n"
                + "| 8. Informe disciplinario                                   |\n"
                + "| 9. Ficha tecnica de partido                                |\n"
                + "|10. Estadisticas de sedes                                   |\n"
                + "|11. Ver informacion del Mundial                             |\n"
                + "| 0. Salir                                                   |\n"
                + "+------------------------------------------------------------+\n"
                + "Seleccione una opcion: ");
    }

    /**
     * Procesa la opcion seleccionada en el menu principal y delega
     * al submenu o reporte correspondiente.
     *
     * @param opcion La opcion ingresada por el usuario.
     * @return True si el usuario eligio salir, false en caso contrario.
     */
    private boolean procesarMenuPrincipal(int opcion) {
        try {
            switch (opcion) {
                case 1:
                    menuInfraestructura();
                    break;
                case 2:
                    menuDelegaciones();
                    break;
                case 3:
                    menuOrganizacionDeportiva();
                    break;
                case 4:
                    menuRegistroEventos();
                    break;
                case 5:
                    reporteTablaPosiciones();
                    break;
                case 6:
                    reporteTablaResultados();
                    break;
                case 7:
                    reporteRankingGoleadores();
                    break;
                case 8:
                    reporteInformeDisciplinario();
                    break;
                case 9:
                    reporteFichaTecnica();
                    break;
                case 10:
                    reporteEstadisticasSedes();
                    break;
                case 11:
                    mostrarInfoMundial();
                    break;
                case 0:
                    return true;
                default:
                    System.out.println("Opcion no valida.");
            }
        } catch (Exception e) {
            System.err.println("Error: " + e.getMessage());
        }
        return false;
    }

    // -------------------------------------------------------------------------
    // MENUS
    // -------------------------------------------------------------------------

    /**
     * Muestra y gestiona el submenu de infraestructura en bucle
     * hasta que el usuario elige volver.
     */
    private void menuInfraestructura() {
        while (true) {
            System.out.print("\n| GESTION DE INFRAESTRUCTURA |\n"
                    + "1. Registrar Nueva Sede\n2. Registrar Estadio en Sede\n3. Ver Sedes Registradas\n0. Volver\nOpcion: ");
            switch (leerOpcion()) {
                case 1:
                    registrarSede();
                    break;
                case 2:
                    registrarEstadio();
                    break;
                case 3:
                    verSedes();
                    break;
                case 0:
                    return;
                default:
                    System.out.println("Opcion no valida.");
            }
        }
    }

    /**
     * Muestra y gestiona el submenu de delegaciones en bucle
     * hasta que el usuario elige volver.
     */
    private void menuDelegaciones() {
        while (true) {
            System.out.print("\n| ADMINISTRACION DELEGACIONES |\n"
                    + "1. Registrar Seleccion\n2. Registrar Jugador\n3. Registrar Director Tecnico\n"
                    + "4. Registrar Cuerpo Tecnico\n5. Ver Selecciones\n0. Volver\nOpcion: ");
            switch (leerOpcion()) {
                case 1:
                    registrarSeleccion();
                    break;
                case 2:
                    registrarJugador();
                    break;
                case 3:
                    registrarDirectorTecnico();
                    break;
                case 4:
                    registrarCuerpoTecnico();
                    break;
                case 5:
                    verSelecciones();
                    break;
                case 0:
                    return;
                default:
                    System.out.println("Opcion no valida.");
            }
        }
    }

    /**
     * Muestra y gestiona el submenu de organizacion deportiva en bucle
     * hasta que el usuario elige volver.
     */
    private void menuOrganizacionDeportiva() {
        while (true) {
            System.out.print("\n| ORGANIZACION DEPORTIVA |\n"
                    + "1. Registrar Grupo\n2. Planificar Partido\n3. Asignar Equipos a Partido\n4. Registrar Arbitraje\n0. Volver\nOpcion: ");
            switch (leerOpcion()) {
                case 1:
                    registrarGrupo();
                    break;
                case 2:
                    planificarPartido();
                    break;
                case 3:
                    asignarEquiposAPartido();
                    break;
                case 4:
                    registrarArbitraje();
                    break;
                case 0:
                    return;
                default:
                    System.out.println("Opcion no valida.");
            }
        }
    }

    /**
     * Muestra y gestiona el submenu de registro de eventos en bucle
     * hasta que el usuario elige volver.
     */
    private void menuRegistroEventos() {
        while (true) {
            System.out.print("\n| REGISTRO DE EVENTOS |\n"
                    + "1. Registrar Evento\n2. Ver Eventos de un Partido\n0. Volver\nOpcion: ");
            switch (leerOpcion()) {
                case 1:
                    registrarEvento();
                    break;
                case 2:
                    verEventosPartido();
                    break;
                case 0:
                    return;
                default:
                    System.out.println("Opcion no valida.");
            }
        }
    }

    // -------------------------------------------------------------------------
    // INFRAESTRUCTURA
    // -------------------------------------------------------------------------

    /**
     * Solicita los datos de una nueva sede al usuario, valida que la ciudad
     * no este duplicada y la registra en el mundial mediante
     * {@link GestionInfraestructura#registrarSede(Mundial, Sede, Pais)}.
     */
    private void registrarSede() {
        // Pedimos la ciudad primero para validar el duplicado cuanto antes
        String ciudad = leerNombre("Ciudad: ", "La ciudad solo puede contener letras.");

        for (Sede s : mundial.getSedes()) {
            if (s != null && s.getCiudad() != null && s.getCiudad().equalsIgnoreCase(ciudad)) {
                System.out.println("Error: ya existe una sede registrada para la ciudad de " + ciudad + ".");
                return;
            }
        }

        String nombrePais = leerNombre("Nombre del Pais: ",
                "El nombre del pais solo puede contener letras.");
        String bandera = leerArchivoImagen("Bandera (ej: arg.png): ",
                "Formato invalido. Use nombre.extension (ej: arg.png, ireland.jpg).");
        String clima = leerNombre("Clima: ",
                "El clima solo puede contener letras.");
        String zonaHoraria = leerZonaHoraria("Zona horaria (ej. GMT-3): ",
                "Formato invalido. Use GMT+N o GMT-N (ej: GMT-3, GMT+1).");
        try {
            Pais pais = new Pais();
            pais.setNombre(nombrePais);
            pais.setBandera(bandera);
            Sede sede = new Sede();
            sede.setCiudad(ciudad);
            sede.setClima(clima);
            sede.setZonaHoraria(zonaHoraria);
            gi.registrarSede(mundial, sede, pais);
            System.out.println("Sede registrada: " + ciudad);
            System.out.println("Total sedes ahora: " + mundial.getSedes().size());
        } catch (TorneoException e) {
            System.err.println("Error: " + e.getMessage());
        }
    }

    /**
     * Solicita los datos de un nuevo estadio, permite seleccionar la sede
     * y lo registra mediante
     * {@link GestionInfraestructura#registrarEstadioEnSede(Sede, Estadio, int)}.
     */
    private void registrarEstadio() {
        ArrayList<Sede> sedes = mundial.getSedes();
        if (sedes == null || sedes.isEmpty()) {
            System.out.println("No hay sedes registradas.");
            return;
        }

        String nombre = leerNombre("Nombre del Estadio: ",
                "El nombre solo puede contener letras.");
        int capacidad = leerEnteroValido("Capacidad: ", "La capacidad debe ser mayor a 0.", v -> v > 0);

        System.out.println("Sedes disponibles:");
        for (int i = 0; i < sedes.size(); i++)
            System.out.println((i + 1) + ". " + sedes.get(i).getCiudad());
        int index = leerEnteroValido("Seleccione sede: ", "Opcion invalida.", v -> v >= 1 && v <= sedes.size()) - 1;

        try {
            Estadio estadio = new Estadio();
            estadio.setNombre(nombre);
            gi.registrarEstadioEnSede(sedes.get(index), estadio, capacidad);
            System.out.println("Estadio registrado: " + nombre);
        } catch (TorneoException e) {
            System.err.println("Error: " + e.getMessage());
        }
    }

    /**
     * Muestra todas las sedes registradas con sus estadios y capacidades.
     */
    private void verSedes() {
        ArrayList<Sede> sedes = mundial.getSedes();
        if (sedes == null || sedes.isEmpty()) {
            System.out.println("No hay sedes registradas.");
            return;
        }
        System.out.println("\nSedes:");
        for (Sede sede : sedes) {
            System.out.println("- " + sede.getCiudad() + " (" + sede.getZonaHoraria() + ")");
            if (sede.getEstadios() != null)
                for (Estadio e : sede.getEstadios())
                    System.out.println("   * " + e.getNombre() + " - Capacidad: " + e.getCapacidad());
        }
    }

    // -------------------------------------------------------------------------
    // DELEGACIONES
    // -------------------------------------------------------------------------

    /**
     * Solicita los datos de una nueva seleccion, valida que el pais no tenga
     * ya una seleccion registrada y la vincula al grupo y pais seleccionados.
     */
    private void registrarSeleccion() {
        Grupo grupo = seleccionarGrupo("Seleccione el grupo:");
        if (grupo == null)
            return;
        Pais pais = seleccionarPais("Seleccione el pais:");
        if (pais == null)
            return;
        if (pais.getSeleccion() != null) {
            System.out.println("Error: " + pais.getNombre() + " ya tiene una seleccion registrada ("
                    + pais.getSeleccion().getNombreFederacion() + "). Un pais solo puede tener una seleccion.");
            return;
        }
        String nombre = leerNombre("Nombre de la federacion: ",
                "El nombre solo puede contener letras.");
        int ranking = leerEnteroValido("Ranking FIFA: ",
                "El ranking debe ser mayor a 0.",
                v -> v > 0);
        Seleccion sel = new Seleccion();
        sel.setNombreFederacion(nombre);
        sel.setRankingFIFA(ranking);
        try {
            ad.gestionarSeleccion(pais, sel, grupo);
            System.out.println("Seleccion registrada: " + nombre + " (Ranking FIFA: " + ranking + ")");
        } catch (TorneoException e) {
            System.err.println("Error: " + e.getMessage());
        }
    }

    /**
     * Solicita los datos de un nuevo jugador y lo registra en la seleccion
     * seleccionada mediante
     * {@link AdministracionDelegaciones#registrarJugador(Seleccion, Jugador)}.
     */
    private void registrarJugador() {
        Seleccion seleccion = seleccionarSeleccion("Seleccione la seleccion:");
        if (seleccion == null)
            return;

        String nombre = leerNombre("Nombre del jugador: ",
                "El nombre solo puede contener letras.");
        int dorsal;
        while (true) {
            // 1. Valida el rango (1 a 26) empleando tu predicado funcional
            dorsal = leerEnteroValido("Dorsal: ", "El dorsal debe ser mayor a 0 y menor o igual a 26.",
                    v -> v >= 1 && v <= 26);

            // 2. Valida si ya existe dentro de la selección seleccionada
            boolean duplicado = false;
            for (Jugador j : seleccion.getJugadores()) {
                if (j != null && j.getDorsal() == dorsal) {
                    System.out.println("Error: el dorsal " + dorsal + " ya esta asignado a "
                            + j.getNombre() + " en " + seleccion.getNombreFederacion() + ". Intente nuevamente.");
                    duplicado = true;
                    break; // Corta el "for" actual para regresar al inicio del "while"
                }
            }

            if (!duplicado) {
                break; // El dorsal es válido en rango y no está duplicado. Rompe el "while".
            }
        }

        // --- CONTROL DE FECHA CON CONSTANTE ---
        final int ANIO_LIMITE_18 = 2008; // En 2026, los de 2008 cumplen 18
        final int FECHA_MAX_PERMITIDA = (ANIO_LIMITE_18 * 10000) + 1231; // 20081231
        final int FECHA_FUTURA_LIMITE = 20261231; // Límite para evitar fechas del futuro
        int fecha;

        while (true) {
            fecha = leerFecha("Fecha nacimiento (YYYYMMDD): ");

            if (fecha > FECHA_FUTURA_LIMITE) {
                System.out.println("Error: La fecha de nacimiento no puede ser una fecha futura.");
            } else if (fecha > FECHA_MAX_PERMITIDA) {
                System.out.println(
                        "Error: El jugador debe tener al menos 18 años (nacido en " + ANIO_LIMITE_18 + " o antes).");
            } else {
                break; // Fecha válida, salimos del bucle
            }
        }
        // --------------------------------------------------

        Jugador jugador = new Jugador();
        jugador.setNombre(nombre);
        jugador.setDorsal(dorsal);
        jugador.setFecNacimiento(fecha); // Usa la fecha ya validada arriba

        try {
            ad.registrarJugador(seleccion, jugador);
            System.out.println("Jugador registrado: " + nombre);
        } catch (TorneoException e) {
            System.err.println("Error: " + e.getMessage());
        }
    }

    /**
     * Solicita los datos de un director tecnico y lo registra en la seleccion
     * seleccionada mediante
     * {@link AdministracionDelegaciones#registrarDirectorTecnico(Seleccion, DirectorTecnico)}.
     */
    private void registrarDirectorTecnico() {
        Seleccion seleccion = seleccionarSeleccion("Seleccione la seleccion:");
        if (seleccion == null)
            return;

        String nombre = leerNombre("Nombre DT: ",
                "El nombre solo puede contener letras.");

        // --- CONTROL DE FECHA PARA EL DT ---
        final int ANIO_LIMITE_18 = 2008; // En 2026, los de 2008 cumplen 18
        final int FECHA_MAX_PERMITIDA = (ANIO_LIMITE_18 * 10000) + 1231; // 20081231
        final int FECHA_FUTURA_LIMITE = 20261231; // Límite para evitar fechas del futuro
        int fechaNac;

        while (true) {
            fechaNac = leerFecha("Fecha de nacimiento (YYYYMMDD): ");

            if (fechaNac > FECHA_FUTURA_LIMITE) {
                System.out.println("Error: La fecha de nacimiento no puede ser una fecha futura.");
            } else if (fechaNac > FECHA_MAX_PERMITIDA) {
                System.out.println("Error: El director técnico debe tener al menos 18 años (nacido en " + ANIO_LIMITE_18
                        + " o antes).");
            } else {
                break; // Fecha válida, salimos del bucle
            }
        }
        // ------------------------------------

        DirectorTecnico dt = new DirectorTecnico(nombre, fechaNac, 20000101);

        try {
            ad.registrarDirectorTecnico(seleccion, dt);
            System.out.println("Director tecnico registrado: " + nombre);
        } catch (TorneoException e) {
            System.err.println("Error: " + e.getMessage());
        }
    }

    /**
     * Solicita los datos de un integrante del cuerpo tecnico y lo registra
     * en la seleccion seleccionada mediante
     * {@link AdministracionDelegaciones#registrarCuerpoTecnico(Seleccion, CuerpoTecnico)}.
     */
    private void registrarCuerpoTecnico() {
        Seleccion seleccion = seleccionarSeleccion("Seleccione la seleccion:");
        if (seleccion == null)
            return;

        String nombre = leerNombre("Nombre integrante: ",
                "El nombre solo puede contener letras.");

        // --- CONTROL DE FECHA PARA EL CUERPO TÉCNICO ---
        final int ANIO_LIMITE_18 = 2008; // En 2026, los de 2008 cumplen 18
        final int FECHA_MAX_PERMITIDA = (ANIO_LIMITE_18 * 10000) + 1231; // 20081231
        final int FECHA_FUTURA_LIMITE = 20261231; // Límite para evitar fechas del futuro
        int fechaNac;

        while (true) {
            fechaNac = leerFecha("Fecha de nacimiento (YYYYMMDD): ");

            if (fechaNac > FECHA_FUTURA_LIMITE) {
                System.out.println("Error: La fecha de nacimiento no puede ser una fecha futura.");
            } else if (fechaNac > FECHA_MAX_PERMITIDA) {
                System.out.println("Error: El integrante del cuerpo técnico debe tener al menos 18 años (nacido en "
                        + ANIO_LIMITE_18 + " o antes).");
            } else {
                break; // Fecha válida, salimos del bucle
            }
        }
        // -----------------------------------------------

        Rol rolElegido = null;
        while (rolElegido == null) {
            System.out.print("Rol (AYUDANTECAMPO, ENTRENADORARQUEROS, PREPARADORFISICO, MEDICO): ");
            String rol = scanner.nextLine().trim().toUpperCase();
            if (rol.isEmpty()) {
                System.out.println("Error: el rol no puede estar vacio. Intente nuevamente.");
                continue;
            }
            try {
                rolElegido = Rol.valueOf(rol);
            } catch (IllegalArgumentException e) {
                System.out.println("Rol no valido. Intente nuevamente.");
            }
        }

        try {
            CuerpoTecnico ct = new CuerpoTecnico();
            ct.setNombre(nombre);
            ct.setRol(rolElegido);
            ct.setFecNacimiento(fechaNac); // Asignamos la fecha ya validada

            ad.registrarCuerpoTecnico(seleccion, ct);
            System.out.println("Integrante creado: " + nombre);
        } catch (TorneoException e) {
            System.err.println("Error: " + e.getMessage());
        }
    }

    /**
     * Muestra todas las selecciones registradas con su pais, grupo y cantidad de
     * jugadores.
     */
    private void verSelecciones() {
        ArrayList<Seleccion> selecciones = obtenerTodasLasSelecciones();
        if (selecciones.isEmpty()) {
            System.out.println("No hay selecciones registradas.");
            return;
        }
        System.out.println("\nSelecciones:");
        for (Seleccion sel : selecciones) {
            String pais = sel.getPais() != null ? sel.getPais().getNombre() : "Sin pais";
            String grupo = sel.getGrupo() != null ? sel.getGrupo().getIdentificador() : "Sin grupo";
            int jugadores = sel.getJugadores() != null ? sel.getJugadores().size() : 0;
            System.out.println("- " + sel.getNombreFederacion() + " | Pais: " + pais + " | Grupo: " + grupo
                    + " | Jugadores: " + jugadores);
        }
    }

    // -------------------------------------------------------------------------
    // ORGANIZACION DEPORTIVA
    // -------------------------------------------------------------------------

    /**
     * Solicita los datos de un nuevo grupo y lo registra en la fase seleccionada
     * mediante {@link OrganizacionDeportiva#registrarGrupoEnFase(Fase, Grupo)}.
     */
    private void registrarGrupo() {
        Fase fase = seleccionarFase("Seleccione la fase:");
        if (fase == null)
            return;
        String id = leerNombre("Id grupo (ej: A, B): ", "El id del grupo solo puede contener letras.");
        String desc = leerNombre("Descripcion: ", "La descripcion solo puede contener letras.");
        Grupo grupo = new Grupo(id, desc, fase);
        try {
            od.registrarGrupoEnFase(fase, grupo);
            System.out.println("Grupo registrado: " + id);
        } catch (TorneoException e) {
            System.err.println("Error: " + e.getMessage());
        }
    }

    /**
     * Solicita los datos de un nuevo partido, valida que no exista otro con la
     * misma
     * fecha, horario y estadio, y lo planifica mediante
     * {@link OrganizacionDeportiva#planificarPartido(Partido, Fase, Estadio)}.
     */
    private void planificarPartido() {
        Fase fase = seleccionarFase("Seleccione la fase:");
        if (fase == null)
            return;
        Estadio estadio = seleccionarEstadio("Seleccione el estadio:");
        if (estadio == null)
            return;
        int fecha = leerFecha("Fecha (YYYYMMDD): ");
        int horario = leerEnteroValido("Horario (HHMM, ej: 2000): ",
                "Horario invalido. Use formato HHMM entre 0000 y 2359.",
                v -> v >= 0 && v <= 2359);
        for (Partido p : obtenerTodosLosPartidos()) {
            if (p != null && p.getFecha() == fecha && p.getHorario() == horario && p.getEstadio() == estadio) {
                System.out.println("Error: ya existe un partido en " + estadio.getNombre()
                        + " el " + fecha + " a las " + horario + ".");
                return;
            }
        }
        Partido partido = new Partido();
        partido.setFecha(fecha);
        partido.setHorario(horario);
        try {
            od.planificarPartido(partido, fase, estadio);
            fase.agregarPartido(partido);
            System.out.println("Partido planificado en " + estadio.getNombre());
        } catch (TorneoException e) {
            System.err.println("Error: " + e.getMessage());
        }
    }

    /**
     * Permite seleccionar un partido y asignarle las selecciones local y visitante
     * mediante
     * {@link OrganizacionDeportiva#asignarEquiposAPartido(Partido, Participacion, Participacion)}.
     */
    private void asignarEquiposAPartido() {
        Partido partido = seleccionarPartido("Seleccione el partido:");
        if (partido == null)
            return;
        ArrayList<Seleccion> selecciones = obtenerTodasLasSelecciones();
        if (selecciones.size() < 2) {
            System.out.println("Se necesitan al menos dos selecciones.");
            return;
        }
        System.out.println("Seleccione local:");
        Seleccion local = seleccionarSeleccionDeLista(selecciones);
        if (local == null)
            return;
        System.out.println("Seleccione visitante:");
        Seleccion visitante = seleccionarSeleccionDeLista(selecciones, local);
        if (visitante == null)
            return;
        Participacion pLocal = new Participacion();
        pLocal.setEsLocal(true);
        pLocal.setSeleccion(local);
        Participacion pVisitante = new Participacion();
        pVisitante.setEsLocal(false);
        pVisitante.setSeleccion(visitante);
        try {
            od.asignarEquiposAPartido(partido, pLocal, pVisitante);
            System.out.println(
                    "Equipos asignados: " + local.getNombreFederacion() + " vs " + visitante.getNombreFederacion());
        } catch (TorneoException e) {
            System.err.println("Error: " + e.getMessage());
        }
    }
    //cambios
    /**
     * Solicita los datos de un arbitro y su rol, valida que el rol y el arbitro
     * no esten duplicados en el partido, y registra el arbitraje.
     */
    private void registrarArbitraje() {
        Partido partido = seleccionarPartido("Seleccione el partido:");
        if (partido == null)
            return;

        String nombre = leerNombre("Nombre del arbitro: ",
                "El nombre solo puede contener letras.");

        // --- CONTROL DE FECHA PARA EL ÁRBITRO ---
        final int ANIO_LIMITE_18 = 2008; // En 2026, los de 2008 cumplen 18
        final int FECHA_MAX_PERMITIDA = (ANIO_LIMITE_18 * 10000) + 1231; // 20081231
        final int FECHA_FUTURA_LIMITE = 20261231; // Límite para evitar fechas del futuro
        int fecNacimiento;

        while (true) {
            fecNacimiento = leerFecha("Fecha nacimiento (YYYYMMDD): ");

            if (fecNacimiento > FECHA_FUTURA_LIMITE) {
                System.out.println("Error: La fecha de nacimiento no puede ser una fecha futura.");
            } else if (fecNacimiento > FECHA_MAX_PERMITIDA) {
                System.out.println(
                        "Error: El árbitro debe tener al menos 18 años (nacido en " + ANIO_LIMITE_18 + " o antes).");
            } else {
                break; // Fecha válida, salimos del bucle
            }
        }
        // ----------------------------------------

        int anios = leerEnteroValido("Anos de experiencia: ",
                "Los anos deben ser entre 0 y 50.",
                v -> v >= 0 && v <= 50);

        Pais paisArbitro = seleccionarPais("Seleccione el pais del arbitro:");
        if (paisArbitro == null)
            return;

        CategoriaArbitro rolElegido = null;
        while (rolElegido == null) {
            System.out.print("Rol (PRINCIPAL, ASISTENTE_1, ASISTENTE_2, CUARTO_ARBITRO, VAR_PRINCIPAL, VAR_ASISTENTE): ");
            String rol = scanner.nextLine().trim().toUpperCase();
            if (rol.isEmpty()) {
                System.out.println("Error: el rol no puede estar vacio. Intente nuevamente.");
                continue;
            }
            try {
                rolElegido = CategoriaArbitro.valueOf(rol);
            } catch (IllegalArgumentException e) {
                System.out.println("Rol no valido. Intente nuevamente.");
            }
        }

        for (Arbitraje a : partido.getArbitrajes()) {
            if (a != null && a.getRol() == rolElegido) {
                System.out.println("Error: el rol " + rolElegido + " ya esta asignado en este partido.");
                return;
            }
            if (a != null && a.getArbitro() != null
                    && a.getArbitro().getNombre() != null
                    && a.getArbitro().getNombre().equalsIgnoreCase(nombre)
                    && a.getArbitro().getFecNacimiento() == fecNacimiento) {
                System.out.println("Error: el arbitro " + nombre + " ya esta asignado a este partido.");
                return;
            }
        }

        try {
            Arbitro arbitro = new Arbitro(nombre, fecNacimiento, anios, paisArbitro);
            Arbitraje arbitraje = new Arbitraje(rolElegido, partido, arbitro);
            partido.agregarArbitraje(arbitraje);
            arbitro.agregarArbitraje(arbitraje);
            System.out.println(
                    "Arbitraje registrado: " + nombre + " (" + paisArbitro.getNombre() + ") como " + rolElegido);
            if (!partido.tieneEquipoArbitralValido())
                System.out.println("Nota: El partido aun no tiene equipo arbitral completo.");
        } catch (Exception e) {
            System.err.println("Error: " + e.getMessage());
        }
    }

    // -------------------------------------------------------------------------
    // REGISTRO DE EVENTOS
    // -------------------------------------------------------------------------

    /**
     * Permite seleccionar un partido y un jugador, solicita el tipo de evento
     * y el minuto, y lo registra mediante
     * {@link RegistrosEventosCampos#registrarEventoDeCampo(Partido, Jugador, Evento)}.
     */
    private void registrarEvento() {
        Partido partido = seleccionarPartido("Seleccione el partido:");
        if (partido == null)
            return;
        Jugador jugador = seleccionarJugadorDePartido(partido);
        if (jugador == null)
            return;

        TipoEvento tipoElegido = null;
        while (tipoElegido == null) {
            System.out.print("Tipo de evento (GOL, TARJETA_AMARILLA, TARJETA_ROJA, PENAL_COMETIDO, "
                    + "PENAL_CONVERTIDO, PENAL_ERRADO, DOBLE_AMARILLA, SUSTITUCION, LESION): ");
            String tipo = scanner.nextLine().trim().toUpperCase();
            if (tipo.isEmpty()) {
                System.out.println("Error: el tipo no puede estar vacio. Intente nuevamente.");
                continue;
            }
            try {
                tipoElegido = TipoEvento.valueOf(tipo);
            } catch (IllegalArgumentException e) {
                System.out.println("Tipo no valido. Intente nuevamente.");
            }
        }

        int minuto = leerEnteroValido("Minuto (1-120): ",
                "El minuto debe estar entre 1 y 120.",
                v -> v >= 1 && v <= 120);

        for (Evento e : partido.getEventos()) {
            if (e != null && e.getJugador() == jugador
                    && e.getTipo() == tipoElegido
                    && e.getMinuto() == minuto) {
                System.out.println("Error: ya existe un evento " + tipoElegido
                        + " para " + jugador.getNombre() + " en el minuto " + minuto + ".");
                return;
            }
        }
        try {
            Evento evento = new Evento(tipoElegido, minuto, jugador);
            rec.registrarEventoDeCampo(partido, jugador, evento);
            System.out.println("Evento registrado: " + tipoElegido);
        } catch (TorneoException e) {
            System.err.println("Error: " + e.getMessage());
        }
    }

    /**
     * Muestra todos los eventos registrados en un partido seleccionado.
     */
    private void verEventosPartido() {
        Partido partido = seleccionarPartido("Seleccione el partido:");
        if (partido == null)
            return;
        if (partido.getEventos() == null || partido.getEventos().isEmpty()) {
            System.out.println("No hay eventos registrados.");
            return;
        }
        System.out.println("Eventos:");
        for (Evento e : partido.getEventos())
            System.out.println("- " + e.getTipo() + " minuto " + e.getMinuto() + " | " + e.getJugador().getNombre());
    }

    // -------------------------------------------------------------------------
    // REPORTES
    // -------------------------------------------------------------------------

    /**
     * Imprime cada elemento de una lista de strings. Si la lista es nula o vacia,
     * muestra el mensaje de vacio provisto.
     *
     * @param lista    Lista de lineas a imprimir.
     * @param msgVacio Mensaje a mostrar si la lista no tiene datos.
     */
    private void imprimirLista(ArrayList<String> lista, String msgVacio) {
        if (lista == null || lista.isEmpty()) {
            System.out.println(msgVacio);
            return;
        }
        for (String l : lista)
            System.out.println(l);
    }

    /** Solicita un grupo y muestra su tabla de posiciones. */
    private void reporteTablaPosiciones() {
        Grupo grupo = seleccionarGrupo("Seleccione el grupo:");
        if (grupo == null)
            return;
        imprimirLista(tablaPosiciones.obtenerTablaPosiciones(grupo), "No hay datos para esta tabla.");
    }

    /**
     * Solicita una seleccion y muestra su tabla de resultados con instancia maxima
     * alcanzada.
     */
    private void reporteTablaResultados() {
        Seleccion seleccion = seleccionarSeleccion("Seleccione la seleccion:");
        if (seleccion == null)
            return;
        imprimirLista(tablaResultados.obtenerResultados(seleccion), "No hay resultados para esta seleccion.");
    }

    /**
     * Solicita una seleccion y muestra el ranking de sus goleadores ordenado de
     * mayor a menor.
     */
    private void reporteRankingGoleadores() {
        Seleccion seleccion = seleccionarSeleccion("Seleccione la seleccion:");
        if (seleccion == null)
            return;
        imprimirLista(rankingGoles.rankingPorSeleccion(seleccion), "No hay goleadores registrados.");
    }

    /**
     * Solicita si el informe es por seleccion o por jugador y muestra
     * el conteo de tarjetas amarillas, rojas y dobles amarillas.
     */
    private void reporteInformeDisciplinario() {
        int opcion = leerEnteroValido("\n1. Por seleccion\n2. Por jugador\nOpcion: ",
                "Opcion no valida.", v -> v == 1 || v == 2);
        if (opcion == 1) {
            Seleccion seleccion = seleccionarSeleccion("Seleccione la seleccion:");
            if (seleccion == null)
                return;
            imprimirLista(informeCards.informePorSeleccion(seleccion), "No hay datos disciplinarios.");
        } else {
            Seleccion seleccion = seleccionarSeleccion("Seleccione la seleccion del jugador:");
            if (seleccion == null)
                return;
            Jugador jugador = seleccionarJugador(seleccion);
            if (jugador == null)
                return;
            imprimirLista(informeCards.informePorJugador(jugador), "No hay datos disciplinarios.");
        }
    }

    /** Solicita un partido y muestra su ficha tecnica completa. */
    private void reporteFichaTecnica() {
        Partido partido = seleccionarPartido("Seleccione el partido:");
        if (partido == null)
            return;
        imprimirLista(fichaTecnica.obtenerFicha(partido), "No hay ficha tecnica disponible.");
    }

    /**
     * Solicita si la consulta es por estadio o por ciudad y muestra
     * la cantidad de partidos correspondiente.
     */
    private void reporteEstadisticasSedes() {
        int opcion = leerEnteroValido("\n1. Por estadio\n2. Por ciudad\nOpcion: ",
                "Opcion no valida.", v -> v == 1 || v == 2);
        if (opcion == 1) {
            Estadio estadio = seleccionarEstadio("Seleccione el estadio:");
            if (estadio == null)
                return;
            System.out.println(
                    "Partidos en " + estadio.getNombre() + ": " + estadisticasSedes.partidosPorEstadio(estadio));
        } else {
            String ciudad = leerNombre("Ciudad: ", "La ciudad solo puede contener letras.");
            System.out.println("Partidos en " + ciudad + ": " + estadisticasSedes.partidosPorCiudad(mundial, ciudad));
        }
    }

    /** Muestra el anio, mascota y cantidad de sedes del mundial. */
    private void mostrarInfoMundial() {
        System.out.println("\nInformacion del Mundial: \n" + "Año: " + mundial.getAnio() + "\n" + "Mascota: "
                + mundial.getMascota());
        if (mundial.getSedes() != null)
            System.out.println("Sedes registradas: " + mundial.getSedes().size());
    }

    // -------------------------------------------------------------------------
    // SELECTORES AUXILIARES
    // -------------------------------------------------------------------------

    /**
     * Muestra la lista de paises disponibles y retorna el seleccionado.
     *
     * @param prompt Texto a mostrar antes de la lista.
     * @return El pais seleccionado, o null si no hay paises.
     */
    private Pais seleccionarPais(String prompt) {
        ArrayList<Pais> paises = obtenerTodosLosPaises();
        if (paises.isEmpty()) {
            System.out.println("No hay paises disponibles.");
            return null;
        }
        System.out.println(prompt);
        for (int i = 0; i < paises.size(); i++)
            System.out.println((i + 1) + ". " + paises.get(i).getNombre());
        int opcion = leerEnteroValido("Opcion: ", "Opcion no valida.", v -> v >= 1 && v <= paises.size()) - 1;
        return paises.get(opcion);
    }

    /**
     * Muestra la lista de selecciones registradas y retorna la seleccionada.
     *
     * @param prompt Texto a mostrar antes de la lista.
     * @return La seleccion elegida, o null si no hay selecciones.
     */
    private Seleccion seleccionarSeleccion(String prompt) {
        ArrayList<Seleccion> selecciones = obtenerTodasLasSelecciones();
        if (selecciones.isEmpty()) {
            System.out.println("No hay selecciones registradas.");
            return null;
        }
        System.out.println(prompt);
        for (int i = 0; i < selecciones.size(); i++) {
            Seleccion sel = selecciones.get(i);
            String pais = sel.getPais() != null ? sel.getPais().getNombre() : "Sin pais";
            System.out.println((i + 1) + ". " + sel.getNombreFederacion() + " (" + pais + ")");
        }
        int opcion = leerEnteroValido("Opcion: ", "Opcion no valida.", v -> v >= 1 && v <= selecciones.size()) - 1;
        return selecciones.get(opcion);
    }

    /**
     * Muestra una lista de selecciones provista y retorna la elegida.
     *
     * @param selecciones Lista de selecciones a mostrar.
     * @return La seleccion elegida.
     */
    private Seleccion seleccionarSeleccionDeLista(ArrayList<Seleccion> selecciones) {
        for (int i = 0; i < selecciones.size(); i++) {
            Seleccion sel = selecciones.get(i);
            String pais = sel.getPais() != null ? sel.getPais().getNombre() : "Sin pais";
            System.out.println((i + 1) + ". " + sel.getNombreFederacion() + " (" + pais + ")");
        }
        int opcion = leerEnteroValido("Opcion: ", "Opcion no valida.", v -> v >= 1 && v <= selecciones.size()) - 1;
        return selecciones.get(opcion);
    }

    /**
     * Igual que {@link #seleccionarSeleccionDeLista(ArrayList)} pero excluye
     * una seleccion especifica de la lista (usada para evitar seleccionar
     * la misma seleccion como local y visitante).
     *
     * @param selecciones Lista original de selecciones.
     * @param excluir     Seleccion a excluir de la lista.
     * @return La seleccion elegida.
     */
    private Seleccion seleccionarSeleccionDeLista(ArrayList<Seleccion> selecciones, Seleccion excluir) {
        ArrayList<Seleccion> copia = new ArrayList<>();
        for (Seleccion sel : selecciones)
            if (sel != excluir)
                copia.add(sel);
        return seleccionarSeleccionDeLista(copia);
    }

    /**
     * Muestra la lista de grupos registrados y retorna el seleccionado.
     *
     * @param prompt Texto a mostrar antes de la lista.
     * @return El grupo elegido, o null si no hay grupos.
     */
    private Grupo seleccionarGrupo(String prompt) {
        ArrayList<Grupo> grupos = obtenerTodosLosGrupos();
        if (grupos.isEmpty()) {
            System.out.println("No hay grupos registrados.");
            return null;
        }
        System.out.println(prompt);
        for (int i = 0; i < grupos.size(); i++)
            System.out.println(
                    (i + 1) + ". " + grupos.get(i).getIdentificador() + " - " + grupos.get(i).getDescripcion());
        int opcion = leerEnteroValido("Opcion: ", "Opcion no valida.", v -> v >= 1 && v <= grupos.size()) - 1;
        return grupos.get(opcion);
    }

    /**
     * Muestra la lista de fases del torneo y retorna la seleccionada.
     *
     * @param prompt Texto a mostrar antes de la lista.
     * @return La fase elegida, o null si no hay fases.
     */
    private Fase seleccionarFase(String prompt) {
        if (fases == null || fases.isEmpty()) {
            System.out.println("No hay fases registradas.");
            return null;
        }
        System.out.println(prompt);
        for (int i = 0; i < fases.size(); i++)
            System.out.println((i + 1) + ". " + fases.get(i).getNombre());
        int opcion = leerEnteroValido("Opcion: ", "Opcion no valida.", v -> v >= 1 && v <= fases.size()) - 1;
        return fases.get(opcion);
    }

    /**
     * Muestra la lista de estadios registrados y retorna el seleccionado.
     *
     * @param prompt Texto a mostrar antes de la lista.
     * @return El estadio elegido, o null si no hay estadios.
     */
    private Estadio seleccionarEstadio(String prompt) {
        ArrayList<Estadio> estadios = obtenerTodosLosEstadios();
        if (estadios.isEmpty()) {
            System.out.println("No hay estadios registrados.");
            return null;
        }
        System.out.println(prompt);
        for (int i = 0; i < estadios.size(); i++) {
            Estadio e = estadios.get(i);
            String ciudad = e.getSede() != null ? e.getSede().getCiudad() : "Sin sede";
            System.out.println((i + 1) + ". " + e.getNombre() + " - " + ciudad);
        }
        int opcion = leerEnteroValido("Opcion: ", "Opcion no valida.", v -> v >= 1 && v <= estadios.size()) - 1;
        return estadios.get(opcion);
    }

    /**
     * Muestra la lista de partidos registrados y retorna el seleccionado.
     *
     * @param prompt Texto a mostrar antes de la lista.
     * @return El partido elegido, o null si no hay partidos.
     */
    private Partido seleccionarPartido(String prompt) {
        ArrayList<Partido> partidos = obtenerTodosLosPartidos();
        if (partidos.isEmpty()) {
            System.out.println("No hay partidos registrados.");
            return null;
        }
        System.out.println(prompt);
        for (int i = 0; i < partidos.size(); i++) {
            Partido p = partidos.get(i);
            String estadio = p.getEstadio() != null ? p.getEstadio().getNombre() : "Sin estadio";
            System.out.println((i + 1) + ". " + p.getFecha() + " " + p.getHorario() + " - " + estadio);
        }
        int opcion = leerEnteroValido("Opcion: ", "Opcion no valida.", v -> v >= 1 && v <= partidos.size()) - 1;
        return partidos.get(opcion);
    }

    /**
     * Muestra la lista de jugadores de una seleccion y retorna el seleccionado.
     *
     * @param seleccion La seleccion de la que se listan los jugadores.
     * @return El jugador elegido, o null si no hay jugadores.
     */
    private Jugador seleccionarJugador(Seleccion seleccion) {
        if (seleccion == null || seleccion.getJugadores() == null || seleccion.getJugadores().isEmpty()) {
            System.out.println("No hay jugadores en esta seleccion.");
            return null;
        }
        System.out.println("Seleccione jugador:");
        for (int i = 0; i < seleccion.getJugadores().size(); i++) {
            Jugador j = seleccion.getJugadores().get(i);
            System.out.println((i + 1) + ". " + j.getNombre() + " (" + j.getDorsal() + ")");
        }
        int opcion = leerEnteroValido("Opcion: ", "Opcion no valida.",
                v -> v >= 1 && v <= seleccion.getJugadores().size()) - 1;
        return seleccion.getJugadores().get(opcion);
    }

    /**
     * Reune todos los jugadores de ambas selecciones de un partido
     * y permite seleccionar uno.
     *
     * @param partido El partido del que se obtienen los jugadores.
     * @return El jugador elegido, o null si el partido no tiene jugadores.
     */
    private Jugador seleccionarJugadorDePartido(Partido partido) {
        if (partido == null || partido.getParticipaciones() == null) {
            System.out.println("El partido no tiene participaciones.");
            return null;
        }
        ArrayList<Jugador> jugadores = new ArrayList<>();
        for (Participacion p : partido.getParticipaciones())
            if (p != null && p.getSeleccion() != null && p.getSeleccion().getJugadores() != null)
                jugadores.addAll(p.getSeleccion().getJugadores());
        if (jugadores.isEmpty()) {
            System.out.println("No hay jugadores para este partido.");
            return null;
        }
        System.out.println("Seleccione jugador:");
        for (int i = 0; i < jugadores.size(); i++) {
            Jugador j = jugadores.get(i);
            System.out.println((i + 1) + ". " + j.getNombre() + " (" + j.getDorsal() + ")");
        }
        int opcion = leerEnteroValido("Opcion: ", "Opcion no valida.", v -> v >= 1 && v <= jugadores.size()) - 1;
        return jugadores.get(opcion);
    }

    // -------------------------------------------------------------------------
    // OBTENER LISTAS GLOBALES
    // -------------------------------------------------------------------------

    /**
     * Recorre las sedes del mundial y retorna una lista sin duplicados
     * de todos los paises registrados.
     *
     * @return Lista de paises unicos del mundial.
     */
    private ArrayList<Pais> obtenerTodosLosPaises() {
        ArrayList<Pais> paises = new ArrayList<>();
        if (mundial.getSedes() != null) {
            for (Sede s : mundial.getSedes()) {
                if (s != null && s.getPais() != null) {
                    Pais pais = s.getPais();
                    boolean existe = false;
                    for (Pais p : paises)
                        if (p.getNombre() != null && p.getNombre().equalsIgnoreCase(pais.getNombre())) {
                            existe = true;
                            break;
                        }
                    if (!existe)
                        paises.add(pais);
                }
            }
        }
        return paises;
    }

    /**
     * Recorre todas las fases y grupos del torneo y retorna una lista sin
     * duplicados de todas las selecciones registradas.
     *
     * @return Lista de selecciones unicas del torneo.
     */
    private ArrayList<Seleccion> obtenerTodasLasSelecciones() {
        ArrayList<Seleccion> selecciones = new ArrayList<>();
        for (Fase fase : fases) {
            if (fase != null && fase.getGrupos() != null) {
                for (Grupo grupo : fase.getGrupos()) {
                    if (grupo != null && grupo.getSelecciones() != null) {
                        for (Seleccion sel : grupo.getSelecciones())
                            if (sel != null && !selecciones.contains(sel))
                                selecciones.add(sel);
                    }
                }
            }
        }
        for (Pais pais : obtenerTodosLosPaises())
            if (pais.getSeleccion() != null && !selecciones.contains(pais.getSeleccion()))
                selecciones.add(pais.getSeleccion());
        return selecciones;
    }

    /**
     * Recorre todas las fases y retorna una lista sin duplicados de todos
     * los grupos registrados en el torneo.
     *
     * @return Lista de grupos unicos del torneo.
     */
    private ArrayList<Grupo> obtenerTodosLosGrupos() {
        ArrayList<Grupo> grupos = new ArrayList<>();
        for (Fase fase : fases)
            if (fase != null && fase.getGrupos() != null)
                for (Grupo grupo : fase.getGrupos())
                    if (grupo != null && !grupos.contains(grupo))
                        grupos.add(grupo);
        return grupos;
    }

    /**
     * Recorre todas las sedes del mundial y retorna una lista sin duplicados
     * de todos los estadios registrados.
     *
     * @return Lista de estadios unicos del torneo.
     */
    private ArrayList<Estadio> obtenerTodosLosEstadios() {
        ArrayList<Estadio> estadios = new ArrayList<>();
        if (mundial.getSedes() != null)
            for (Sede s : mundial.getSedes())
                if (s != null && s.getEstadios() != null)
                    for (Estadio e : s.getEstadios())
                        if (e != null && !estadios.contains(e))
                            estadios.add(e);
        return estadios;
    }

    /**
     * Recorre todas las fases del torneo y retorna una lista sin duplicados
     * de todos los partidos registrados.
     *
     * @return Lista de partidos unicos del torneo.
     */
    private ArrayList<Partido> obtenerTodosLosPartidos() {
        ArrayList<Partido> partidos = new ArrayList<>();
        for (Fase fase : fases)
            if (fase != null && fase.getPartidos() != null)
                for (Partido p : fase.getPartidos())
                    if (p != null && !partidos.contains(p))
                        partidos.add(p);
        return partidos;
    }

    // -------------------------------------------------------------------------
    // UTILIDADES
    // -------------------------------------------------------------------------

    /**
     * Lee una linea de consola e intenta parsearla como entero.
     *
     * @return El entero leido, o -1 si la entrada no es un numero valido.
     */
    private int leerOpcion() {
        try {
            return Integer.parseInt(scanner.nextLine().trim());
        } catch (NumberFormatException e) {
            return -1;
        }
    }

    /**
     * Solicita un nombre de archivo de imagen por consola, validando que tenga
     * el formato {@code nombre.extension} con extension de imagen conocida.
     * Reintenta hasta recibir un valor valido.
     *
     * @param prompt       Texto a mostrar al usuario.
     * @param mensajeError Mensaje a mostrar si el formato es invalido.
     * @return El nombre de archivo valido ingresado.
     */
    private String leerArchivoImagen(String prompt, String mensajeError) {
        while (true) {
            System.out.print(prompt);
            String texto = scanner.nextLine().trim();
            if (!texto.isEmpty() && texto.matches("[a-zA-Z0-9_\\-]+\\.(png|jpg|jpeg|gif|bmp|svg)"))
                return texto;
            System.out.println("Error: " + mensajeError + " Intente nuevamente.");
        }
    }

    /**
     * Solicita un nombre por consola aceptando solo letras, espacios, guiones
     * y apostrofes (incluyendo caracteres acentuados y enie).
     * Reintenta hasta recibir un valor valido.
     *
     * @param prompt       Texto a mostrar al usuario.
     * @param mensajeError Mensaje a mostrar si el valor contiene caracteres
     *                     invalidos.
     * @return El nombre valido ingresado.
     */
    private String leerNombre(String prompt, String mensajeError) {
        while (true) {
            System.out.print(prompt);
            String texto = scanner.nextLine().trim();
            if (!texto.isEmpty() && texto.matches("[a-zA-ZáéíóúÁÉÍÓÚüÜñÑàèìòùâêîôûäëïöü\\s\\-']+"))
                return texto;
            System.out.println("Error: " + mensajeError + " Intente nuevamente.");
        }
    }

    /**
     * Solicita una zona horaria por consola con formato {@code GMT+N} o
     * {@code GMT-N}.
     * Reintenta hasta recibir un valor valido.
     *
     * @param prompt       Texto a mostrar al usuario.
     * @param mensajeError Mensaje a mostrar si el formato es invalido.
     * @return La zona horaria valida ingresada.
     */
    private String leerZonaHoraria(String prompt, String mensajeError) {
        while (true) {
            System.out.print(prompt);
            String texto = scanner.nextLine().trim().toUpperCase();
            if (texto.matches("GMT[+-]\\d{1,2}"))
                return texto;
            System.out.println("Error: " + mensajeError + " Intente nuevamente.");
        }
    }

    /**
     * Solicita una fecha en formato {@code YYYYMMDD} validando que el mes
     * este entre 01-12 y el dia entre 01-31. Reintenta hasta recibir un valor
     * valido.
     *
     * @param prompt Texto a mostrar al usuario.
     * @return La fecha valida como entero en formato YYYYMMDD.
     */
    private int leerFecha(String prompt) {
        while (true) {
            System.out.print(prompt);
            String entrada = scanner.nextLine().trim();
            if (entrada.matches("\\d{8}")) {
                int mes = Integer.parseInt(entrada.substring(4, 6));
                int dia = Integer.parseInt(entrada.substring(6, 8));
                if (mes >= 1 && mes <= 12 && dia >= 1 && dia <= 31)
                    return Integer.parseInt(entrada);
            }
            System.out.println("Error: Fecha invalida. Use el formato YYYYMMDD (ej: 19901204). Intente nuevamente.");
        }
    }

    /**
     * Solicita un numero entero por consola y valida que cumpla la condicion
     * provista. Reintenta hasta recibir un valor valido.
     *
     * @param prompt       Texto a mostrar al usuario.
     * @param mensajeError Mensaje a mostrar si el valor no cumple la condicion.
     * @param condicion    Predicado que debe cumplir el valor ingresado.
     * @return El entero valido ingresado.
     */
    private int leerEnteroValido(String prompt, String mensajeError, java.util.function.IntPredicate condicion) {
        while (true) {
            System.out.print(prompt);
            String entrada = scanner.nextLine().trim();
            try {
                int valor = Integer.parseInt(entrada);
                if (condicion.test(valor))
                    return valor;
                System.out.println("Error: " + mensajeError + " Intente nuevamente.");
            } catch (NumberFormatException e) {
                System.out.println("Entrada no valida. " + mensajeError + " Intente nuevamente.");
            }
        }
    }
}