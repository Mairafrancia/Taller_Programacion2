package MAIN;
import CLASES.*; import GESTION1.*; import GESTION2.*; import EXCEPCIONES.*; import java.util.ArrayList;import java.util.Scanner;
/**
 * Sistema interactivo para la gestión del Torneo Mundial 2026.
 * Permite al usuario:
 * - Gestionar infraestructura, delegaciones y organizacion deportiva
 * - Registrar eventos en tiempo real
 * - Consultar reportes de gestion
 */
public class SistemaInteractivo {
    private Scanner scanner;
    private Mundial mundial;
    private GestionInfraestructura gi;
    private AdministracionDelegaciones ad;
    private OrganizacionDeportiva od;
    private RegistrosEventosCampos rec;
    private TablaDePosicionesPorGrupo tablaPosiciones;
    private TablaDeResultadosPorSeleccion tablaResultados;
    private RankingDeGoleadores rankingGoles;
    private InformeDisciplinario informeCards;
    private FichaTecnicaDeUnPartido fichaTecnica;
    private EstadisticasDeSedes estadisticasSedes;
    private ArrayList<Fase> fases;

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

    private boolean procesarMenuPrincipal(int opcion) {
        try {
            switch (opcion) {
                case 1:  menuInfraestructura(); break;
                case 2:  menuDelegaciones(); break;
                case 3:  menuOrganizacionDeportiva(); break;
                case 4:  menuRegistroEventos(); break;
                case 5:  reporteTablaPosiciones(); break;
                case 6:  reporteTablaResultados(); break;
                case 7:  reporteRankingGoleadores(); break;
                case 8:  reporteInformeDisciplinario(); break;
                case 9:  reporteFichaTecnica(); break;
                case 10: reporteEstadisticasSedes(); break;
                case 11: mostrarInfoMundial(); break;
                case 0:  return true;
                default: System.out.println("Opcion no valida.");
            }
        } catch (Exception e) {
            System.err.println("Error: " + e.getMessage());
        }
        return false;
    }

    // -------------------------------------------------------------------------
    // MENUS
    // -------------------------------------------------------------------------

    private void menuInfraestructura() {
        System.out.print("\n| GESTION DE INFRAESTRUCTURA |\n"
            + "1. Registrar Nueva Sede\n2. Registrar Estadio en Sede\n3. Ver Sedes Registradas\n0. Volver\nOpcion: ");
        switch (leerOpcion()) {
            case 1: registrarSede(); break;
            case 2: registrarEstadio(); break;
            case 3: verSedes(); break;
            case 0: break;
            default: System.out.println("Opcion no valida.");
        }
    }

    private void menuDelegaciones() {
        System.out.print("\n| ADMINISTRACION DELEGACIONES |\n"
            + "1. Registrar Seleccion\n2. Registrar Jugador\n3. Registrar Director Tecnico\n"
            + "4. Registrar Cuerpo Tecnico\n5. Ver Selecciones\n0. Volver\nOpcion: ");
        switch (leerOpcion()) {
            case 1: registrarSeleccion(); break;
            case 2: registrarJugador(); break;
            case 3: registrarDirectorTecnico(); break;
            case 4: registrarCuerpoTecnico(); break;
            case 5: verSelecciones(); break;
            case 0: break;
            default: System.out.println("Opcion no valida.");
        }
    }

    private void menuOrganizacionDeportiva() {
        System.out.print("\n| ORGANIZACION DEPORTIVA |\n"
            + "1. Registrar Grupo\n2. Planificar Partido\n3. Asignar Equipos a Partido\n4. Registrar Arbitraje\n0. Volver\nOpcion: ");
        switch (leerOpcion()) {
            case 1: registrarGrupo(); break;
            case 2: planificarPartido(); break;
            case 3: asignarEquiposAPartido(); break;
            case 4: registrarArbitraje(); break;
            case 0: break;
            default: System.out.println("Opcion no valida.");
        }
    }

    private void menuRegistroEventos() {
        System.out.print("\n| REGISTRO DE EVENTOS |\n"
            + "1. Registrar Evento\n2. Ver Eventos de un Partido\n0. Volver\nOpcion: ");
        switch (leerOpcion()) {
            case 1: registrarEvento(); break;
            case 2: verEventosPartido(); break;
            case 0: break;
            default: System.out.println("Opcion no valida.");
        }
    }

    // -------------------------------------------------------------------------
    // INFRAESTRUCTURA
    // -------------------------------------------------------------------------

    private void registrarSede() {
        System.out.print("Nombre del Pais: ");
        String nombrePais = scanner.nextLine();
        System.out.print("Bandera: ");
        String bandera = scanner.nextLine();
        System.out.print("Ciudad: ");
        String ciudad = scanner.nextLine();
        System.out.print("Clima: ");
        String clima = scanner.nextLine();
        System.out.print("Zona horaria: ");
        String zonaHoraria = scanner.nextLine();

        if (nombrePais.trim().isEmpty() || ciudad.trim().isEmpty()
                || clima.trim().isEmpty() || zonaHoraria.trim().isEmpty()) {
            System.out.println("Error: ningun campo puede estar vacio.");
            return;
        }
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

    private void registrarEstadio() {
        ArrayList<Sede> sedes = mundial.getSedes();
        if (sedes == null || sedes.isEmpty()) { System.out.println("No hay sedes registradas."); return; }
        System.out.print("Nombre del Estadio: ");
        String nombre = scanner.nextLine();
        if (nombre.trim().isEmpty()) { System.out.println("Error: el nombre no puede estar vacio."); return; }
        System.out.print("Capacidad: ");
        int capacidad = leerEntero();
        if (capacidad <= 0) { System.out.println("Error: la capacidad debe ser mayor a 0."); return; }
        System.out.println("Sedes disponibles:");
        for (int i = 0; i < sedes.size(); i++) System.out.println((i + 1) + ". " + sedes.get(i).getCiudad());
        System.out.print("Seleccione sede: ");
        int index = leerOpcion() - 1;
        if (index < 0 || index >= sedes.size()) { System.out.println("Opcion invalida."); return; }
        try {
            Estadio estadio = new Estadio();
            estadio.setNombre(nombre);
            gi.registrarEstadioEnSede(sedes.get(index), estadio, capacidad);
            System.out.println("Estadio registrado: " + nombre);
        } catch (TorneoException e) {
            System.err.println("Error: " + e.getMessage());
        }
    }

    private void verSedes() {
        ArrayList<Sede> sedes = mundial.getSedes();
        if (sedes == null || sedes.isEmpty()) { System.out.println("No hay sedes registradas."); return; }
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

    private void registrarSeleccion() {
        Grupo grupo = seleccionarGrupo("Seleccione el grupo:");
        if (grupo == null) return;
        Pais pais = seleccionarPais("Seleccione el pais:");
        if (pais == null) return;
        System.out.print("Nombre de la federacion: ");
        String nombre = scanner.nextLine();
        if (nombre.trim().isEmpty()) { System.out.println("Error: el nombre no puede estar vacio."); return; }
        Seleccion sel = new Seleccion();
        sel.setNombreFederacion(nombre);
        sel.setRankingFIFA(0);
        try {
            ad.gestionarSeleccion(pais, sel, grupo);
            System.out.println("Seleccion registrada: " + nombre);
        } catch (TorneoException e) {
            System.err.println("Error: " + e.getMessage());
        }
    }

    private void registrarJugador() {
        Seleccion seleccion = seleccionarSeleccion("Seleccione la seleccion:");
        if (seleccion == null) return;
        System.out.print("Nombre del jugador: ");
        String nombre = scanner.nextLine();
        if (nombre.trim().isEmpty()) { System.out.println("Error: el nombre no puede estar vacio."); return; }
        System.out.print("Dorsal: ");
        int dorsal = leerEntero();
        if (dorsal <= 0) { System.out.println("Error: el dorsal debe ser mayor a 0."); return; }
        System.out.print("Fecha nacimiento (YYYYMMDD): ");
        int fecha = leerEntero();
        if (fecha <= 0) { System.out.println("Error: fecha invalida."); return; }
        Jugador jugador = new Jugador();
        jugador.setNombre(nombre);
        jugador.setDorsal(dorsal);
        jugador.setFecNacimiento(fecha);
        try {
            ad.registrarJugador(seleccion, jugador);
            System.out.println("Jugador registrado: " + nombre);
        } catch (TorneoException e) {
            System.err.println("Error: " + e.getMessage());
        }
    }

    private void registrarDirectorTecnico() {
        Seleccion seleccion = seleccionarSeleccion("Seleccione la seleccion:");
        if (seleccion == null) return;
        System.out.print("Nombre DT: ");
        String nombre = scanner.nextLine();
        if (nombre.trim().isEmpty()) { System.out.println("Error: el nombre no puede estar vacio."); return; }
        System.out.print("Año de nacimiento: ");
        int ano = leerEntero();
        if (ano <= 0) { System.out.println("Error: año invalido."); return; }
        DirectoresTecnicos dt = new DirectoresTecnicos(nombre, ano, 20000101);
        try {
            ad.registrarDirectorTecnico(seleccion, dt);
            System.out.println("Director tecnico registrado: " + nombre);
        } catch (TorneoException e) {
            System.err.println("Error: " + e.getMessage());
        }
    }

    private void registrarCuerpoTecnico() {
        Seleccion seleccion = seleccionarSeleccion("Seleccione la seleccion:");
        if (seleccion == null) return;
        System.out.print("Nombre integrante: ");
        String nombre = scanner.nextLine();
        if (nombre.trim().isEmpty()) { System.out.println("Error: el nombre no puede estar vacio."); return; }
        System.out.print("Rol (AYUDANTECAMPO, ENTRENADORARQUEROS, PREPARADORFISICO, MEDICO): ");
        String rol = scanner.nextLine().trim().toUpperCase();
        if (rol.isEmpty()) { System.out.println("Error: el rol no puede estar vacio."); return; }
        try {
            CuerpoTecnico ct = new CuerpoTecnico();
            ct.setNombre(nombre);
            ct.setRol(Rol.valueOf(rol));
            ad.registrarCuerpoTecnico(seleccion, ct);
            System.out.println("Integrante creado: " + nombre);
        } catch (IllegalArgumentException e) {
            System.out.println("Rol no valido.");
        } catch (TorneoException e) {
            System.err.println("Error: " + e.getMessage());
        }
    }

    private void verSelecciones() {
        ArrayList<Seleccion> selecciones = obtenerTodasLasSelecciones();
        if (selecciones.isEmpty()) { System.out.println("No hay selecciones registradas."); return; }
        System.out.println("\nSelecciones:");
        for (Seleccion sel : selecciones) {
            String pais = sel.getPais() != null ? sel.getPais().getNombre() : "Sin pais";
            String grupo = sel.getGrupo() != null ? sel.getGrupo().getIdentificador() : "Sin grupo";
            int jugadores = sel.getJugadores() != null ? sel.getJugadores().size() : 0;
            System.out.println("- " + sel.getNombreFederacion() + " | Pais: " + pais + " | Grupo: " + grupo + " | Jugadores: " + jugadores);
        }
    }

    // -------------------------------------------------------------------------
    // ORGANIZACION DEPORTIVA
    // -------------------------------------------------------------------------

    private void registrarGrupo() {
        Fase fase = seleccionarFase("Seleccione la fase:");
        if (fase == null) return;
        System.out.print("Id grupo: ");
        String id = scanner.nextLine();
        if (id.trim().isEmpty()) { System.out.println("Error: el id no puede estar vacio."); return; }
        System.out.print("Descripcion: ");
        String desc = scanner.nextLine();
        if (desc.trim().isEmpty()) { System.out.println("Error: la descripcion no puede estar vacia."); return; }
        Grupo grupo = new Grupo(id, desc, fase);
        try {
            od.registrarGrupoEnFase(fase, grupo);
            System.out.println("Grupo registrado: " + id);
        } catch (TorneoException e) {
            System.err.println("Error: " + e.getMessage());
        }
    }

    private void planificarPartido() {
        Fase fase = seleccionarFase("Seleccione la fase:");
        if (fase == null) return;
        Estadio estadio = seleccionarEstadio("Seleccione el estadio:");
        if (estadio == null) return;
        System.out.print("Fecha (YYYYMMDD): ");
        int fecha = leerEntero();
        if (fecha <= 0) { System.out.println("Error: fecha invalida."); return; }
        System.out.print("Horario (HHMM): ");
        int horario = leerEntero();
        if (horario <= 0) { System.out.println("Error: horario invalido."); return; }
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

    private void asignarEquiposAPartido() {
        Partido partido = seleccionarPartido("Seleccione el partido:");
        if (partido == null) return;
        ArrayList<Seleccion> selecciones = obtenerTodasLasSelecciones();
        if (selecciones.size() < 2) { System.out.println("Se necesitan al menos dos selecciones."); return; }
        System.out.println("Seleccione local:");
        Seleccion local = seleccionarSeleccionDeLista(selecciones);
        if (local == null) return;
        System.out.println("Seleccione visitante:");
        Seleccion visitante = seleccionarSeleccionDeLista(selecciones, local);
        if (visitante == null) return;
        Participacion pLocal = new Participacion();
        pLocal.setEsLocal(true);
        pLocal.setSeleccion(local);
        Participacion pVisitante = new Participacion();
        pVisitante.setEsLocal(false);
        pVisitante.setSeleccion(visitante);
        try {
            od.asignarEquiposAPartido(partido, pLocal, pVisitante);
            System.out.println("Equipos asignados: " + local.getNombreFederacion() + " vs " + visitante.getNombreFederacion());
        } catch (TorneoException e) {
            System.err.println("Error: " + e.getMessage());
        }
    }

    private void registrarArbitraje() {
        Partido partido = seleccionarPartido("Seleccione el partido:");
        if (partido == null) return;
        System.out.print("Nombre del arbitro: ");
        String nombre = scanner.nextLine();
        if (nombre.trim().isEmpty()) { System.out.println("Error: el nombre no puede estar vacio."); return; }
        System.out.print("Fecha nacimiento (YYYYMMDD): ");
        int fecNacimiento = leerEntero();
        if (fecNacimiento <= 0) { System.out.println("Error: fecha invalida."); return; }
        System.out.print("Anos de experiencia: ");
        int anios = leerEntero();
        if (anios < 0) { System.out.println("Error: los anos no pueden ser negativos."); return; }
        Pais paisArbitro = seleccionarPais("Seleccione el pais del arbitro:");
        if (paisArbitro == null) return;
        System.out.print("Rol (PRINCIPAL, ASISTENTE1, ASISTENTE2, CUARTOARBITRO, VARPRINCIPAL, VARASISTENTE): ");
        String rol = scanner.nextLine().trim().toUpperCase();
        if (rol.isEmpty()) { System.out.println("Error: el rol no puede estar vacio."); return; }
        try {
            Arbitro arbitro = new Arbitro(nombre, fecNacimiento, anios, paisArbitro);
            Arbitraje arbitraje = new Arbitraje(CategoriaArbitro.valueOf(rol), partido, arbitro);
            partido.agregarArbitraje(arbitraje);
            arbitro.agregarArbitraje(arbitraje);
            System.out.println("Arbitraje registrado: " + nombre + " (" + paisArbitro.getNombre() + ") como " + rol);
            if (!partido.tieneEquipoArbitralValido())
                System.out.println("Nota: El partido aun no tiene equipo arbitral completo.");
        } catch (IllegalArgumentException e) {
            System.out.println("Rol no valido.");
        } catch (Exception e) {
            System.err.println("Error: " + e.getMessage());
        }
    }

    // -------------------------------------------------------------------------
    // REGISTRO DE EVENTOS
    // -------------------------------------------------------------------------

    private void registrarEvento() {
        Partido partido = seleccionarPartido("Seleccione el partido:");
        if (partido == null) return;
        Jugador jugador = seleccionarJugadorDePartido(partido);
        if (jugador == null) return;
        System.out.print("Tipo de evento: ");
        String tipo = scanner.nextLine().trim().toUpperCase();
        if (tipo.isEmpty()) { System.out.println("Error: el tipo no puede estar vacio."); return; }
        System.out.print("Minuto: ");
        int minuto = leerEntero();
        if (minuto <= 0) { System.out.println("Error: el minuto debe ser mayor a 0."); return; }
        try {
            Evento evento = new Evento(TipoEvento.valueOf(tipo), minuto, jugador);
            rec.registrarEventoDeCampo(partido, jugador, evento);
            System.out.println("Evento registrado: " + tipo);
        } catch (IllegalArgumentException e) {
            System.out.println("Tipo no valido.");
        } catch (TorneoException e) {
            System.err.println("Error: " + e.getMessage());
        }
    }

    private void verEventosPartido() {
        Partido partido = seleccionarPartido("Seleccione el partido:");
        if (partido == null) return;
        if (partido.getEventos() == null || partido.getEventos().isEmpty()) {
            System.out.println("No hay eventos registrados."); return;
        }
        System.out.println("Eventos:");
        for (Evento e : partido.getEventos())
            System.out.println("- " + e.getTipo() + " minuto " + e.getMinuto() + " | " + e.getJugador().getNombre());
    }

    // -------------------------------------------------------------------------
    // REPORTES
    // -------------------------------------------------------------------------

    private void imprimirLista(ArrayList<String> lista, String msgVacio) {
        if (lista == null || lista.isEmpty()) { System.out.println(msgVacio); return; }
        for (String l : lista) System.out.println(l);
    }

    private void reporteTablaPosiciones() {
        Grupo grupo = seleccionarGrupo("Seleccione el grupo:");
        if (grupo == null) return;
        imprimirLista(tablaPosiciones.obtenerTablaPosiciones(grupo), "No hay datos para esta tabla.");
    }

    private void reporteTablaResultados() {
        Seleccion seleccion = seleccionarSeleccion("Seleccione la seleccion:");
        if (seleccion == null) return;
        imprimirLista(tablaResultados.obtenerResultados(seleccion), "No hay resultados para esta seleccion.");
    }

    private void reporteRankingGoleadores() {
        Seleccion seleccion = seleccionarSeleccion("Seleccione la seleccion:");
        if (seleccion == null) return;
        imprimirLista(rankingGoles.rankingPorSeleccion(seleccion), "No hay goleadores registrados.");
    }

    private void reporteInformeDisciplinario() {
        System.out.print("\n1. Por seleccion\n2. Por jugador\nOpcion: ");
        int opcion = leerOpcion();
        if (opcion == 1) {
            Seleccion seleccion = seleccionarSeleccion("Seleccione la seleccion:");
            if (seleccion == null) return;
            imprimirLista(informeCards.informePorSeleccion(seleccion), "No hay datos disciplinarios.");
        } else if (opcion == 2) {
            Seleccion seleccion = seleccionarSeleccion("Seleccione la seleccion del jugador:");
            if (seleccion == null) return;
            Jugador jugador = seleccionarJugador(seleccion);
            if (jugador == null) return;
            imprimirLista(informeCards.informePorJugador(jugador), "No hay datos disciplinarios.");
        } else {
            System.out.println("Opcion no valida.");
        }
    }

    private void reporteFichaTecnica() {
        Partido partido = seleccionarPartido("Seleccione el partido:");
        if (partido == null) return;
        imprimirLista(fichaTecnica.obtenerFicha(partido), "No hay ficha tecnica disponible.");
    }

    private void reporteEstadisticasSedes() {
        System.out.print("\n1. Por estadio\n2. Por ciudad\nOpcion: ");
        int opcion = leerOpcion();
        if (opcion == 1) {
            Estadio estadio = seleccionarEstadio("Seleccione el estadio:");
            if (estadio == null) return;
            System.out.println("Partidos en " + estadio.getNombre() + ": " + estadisticasSedes.partidosPorEstadio(estadio));
        } else if (opcion == 2) {
            System.out.print("Ciudad: ");
            String ciudad = scanner.nextLine().trim();
            System.out.println("Partidos en " + ciudad + ": " + estadisticasSedes.partidosPorCiudad(mundial, ciudad));
        } else {
            System.out.println("Opcion no valida.");
        }
    }

    private void mostrarInfoMundial() {
        System.out.println("\nInformacion del Mundial:");
        System.out.println("Año: " + mundial.getAnio());
        System.out.println("Mascota: " + mundial.getMascota());
        if (mundial.getSedes() != null) System.out.println("Sedes registradas: " + mundial.getSedes().size());
    }

    // -------------------------------------------------------------------------
    // SELECTORES AUXILIARES
    // -------------------------------------------------------------------------

    private Pais seleccionarPais(String prompt) {
        ArrayList<Pais> paises = obtenerTodosLosPaises();
        if (paises.isEmpty()) { System.out.println("No hay paises disponibles."); return null; }
        System.out.println(prompt);
        for (int i = 0; i < paises.size(); i++) System.out.println((i + 1) + ". " + paises.get(i).getNombre());
        System.out.print("Opcion: ");
        int opcion = leerOpcion() - 1;
        if (opcion >= 0 && opcion < paises.size()) return paises.get(opcion);
        System.out.println("Opcion no valida."); return null;
    }

    private Seleccion seleccionarSeleccion(String prompt) {
        ArrayList<Seleccion> selecciones = obtenerTodasLasSelecciones();
        if (selecciones.isEmpty()) { System.out.println("No hay selecciones registradas."); return null; }
        System.out.println(prompt);
        for (int i = 0; i < selecciones.size(); i++) {
            Seleccion sel = selecciones.get(i);
            String pais = sel.getPais() != null ? sel.getPais().getNombre() : "Sin pais";
            System.out.println((i + 1) + ". " + sel.getNombreFederacion() + " (" + pais + ")");
        }
        System.out.print("Opcion: ");
        int opcion = leerOpcion() - 1;
        if (opcion >= 0 && opcion < selecciones.size()) return selecciones.get(opcion);
        System.out.println("Opcion no valida."); return null;
    }

    private Seleccion seleccionarSeleccionDeLista(ArrayList<Seleccion> selecciones) {
        for (int i = 0; i < selecciones.size(); i++) {
            Seleccion sel = selecciones.get(i);
            String pais = sel.getPais() != null ? sel.getPais().getNombre() : "Sin pais";
            System.out.println((i + 1) + ". " + sel.getNombreFederacion() + " (" + pais + ")");
        }
        System.out.print("Opcion: ");
        int opcion = leerOpcion() - 1;
        if (opcion >= 0 && opcion < selecciones.size()) return selecciones.get(opcion);
        System.out.println("Opcion no valida."); return null;
    }

    private Seleccion seleccionarSeleccionDeLista(ArrayList<Seleccion> selecciones, Seleccion excluir) {
        ArrayList<Seleccion> copia = new ArrayList<>();
        for (Seleccion sel : selecciones) if (sel != excluir) copia.add(sel);
        return seleccionarSeleccionDeLista(copia);
    }

    private Grupo seleccionarGrupo(String prompt) {
        ArrayList<Grupo> grupos = obtenerTodosLosGrupos();
        if (grupos.isEmpty()) { System.out.println("No hay grupos registrados."); return null; }
        System.out.println(prompt);
        for (int i = 0; i < grupos.size(); i++)
            System.out.println((i + 1) + ". " + grupos.get(i).getIdentificador() + " - " + grupos.get(i).getDescripcion());
        System.out.print("Opcion: ");
        int opcion = leerOpcion() - 1;
        if (opcion >= 0 && opcion < grupos.size()) return grupos.get(opcion);
        System.out.println("Opcion no valida."); return null;
    }

    private Fase seleccionarFase(String prompt) {
        if (fases == null || fases.isEmpty()) { System.out.println("No hay fases registradas."); return null; }
        System.out.println(prompt);
        for (int i = 0; i < fases.size(); i++) System.out.println((i + 1) + ". " + fases.get(i).getNombre());
        System.out.print("Opcion: ");
        int opcion = leerOpcion() - 1;
        if (opcion >= 0 && opcion < fases.size()) return fases.get(opcion);
        System.out.println("Opcion no valida."); return null;
    }

    private Estadio seleccionarEstadio(String prompt) {
        ArrayList<Estadio> estadios = obtenerTodosLosEstadios();
        if (estadios.isEmpty()) { System.out.println("No hay estadios registrados."); return null; }
        System.out.println(prompt);
        for (int i = 0; i < estadios.size(); i++) {
            Estadio e = estadios.get(i);
            String ciudad = e.getSede() != null ? e.getSede().getCiudad() : "Sin sede";
            System.out.println((i + 1) + ". " + e.getNombre() + " - " + ciudad);
        }
        System.out.print("Opcion: ");
        int opcion = leerOpcion() - 1;
        if (opcion >= 0 && opcion < estadios.size()) return estadios.get(opcion);
        System.out.println("Opcion no valida."); return null;
    }

    private Partido seleccionarPartido(String prompt) {
        ArrayList<Partido> partidos = obtenerTodosLosPartidos();
        if (partidos.isEmpty()) { System.out.println("No hay partidos registrados."); return null; }
        System.out.println(prompt);
        for (int i = 0; i < partidos.size(); i++) {
            Partido p = partidos.get(i);
            String estadio = p.getEstadio() != null ? p.getEstadio().getNombre() : "Sin estadio";
            System.out.println((i + 1) + ". " + p.getFecha() + " " + p.getHorario() + " - " + estadio);
        }
        System.out.print("Opcion: ");
        int opcion = leerOpcion() - 1;
        if (opcion >= 0 && opcion < partidos.size()) return partidos.get(opcion);
        System.out.println("Opcion no valida."); return null;
    }

    private Jugador seleccionarJugador(Seleccion seleccion) {
        if (seleccion == null || seleccion.getJugadores() == null || seleccion.getJugadores().isEmpty()) {
            System.out.println("No hay jugadores en esta seleccion."); return null;
        }
        System.out.println("Seleccione jugador:");
        for (int i = 0; i < seleccion.getJugadores().size(); i++) {
            Jugador j = seleccion.getJugadores().get(i);
            System.out.println((i + 1) + ". " + j.getNombre() + " (" + j.getDorsal() + ")");
        }
        System.out.print("Opcion: ");
        int opcion = leerOpcion() - 1;
        if (opcion >= 0 && opcion < seleccion.getJugadores().size()) return seleccion.getJugadores().get(opcion);
        System.out.println("Opcion no valida."); return null;
    }

    private Jugador seleccionarJugadorDePartido(Partido partido) {
        if (partido == null || partido.getParticipaciones() == null) {
            System.out.println("El partido no tiene participaciones."); return null;
        }
        ArrayList<Jugador> jugadores = new ArrayList<>();
        for (Participacion p : partido.getParticipaciones())
            if (p != null && p.getSeleccion() != null && p.getSeleccion().getJugadores() != null)
                jugadores.addAll(p.getSeleccion().getJugadores());
        if (jugadores.isEmpty()) { System.out.println("No hay jugadores para este partido."); return null; }
        System.out.println("Seleccione jugador:");
        for (int i = 0; i < jugadores.size(); i++) {
            Jugador j = jugadores.get(i);
            System.out.println((i + 1) + ". " + j.getNombre() + " (" + j.getDorsal() + ")");
        }
        System.out.print("Opcion: ");
        int opcion = leerOpcion() - 1;
        if (opcion >= 0 && opcion < jugadores.size()) return jugadores.get(opcion);
        System.out.println("Opcion no valida."); return null;
    }

    // -------------------------------------------------------------------------
    // OBTENER LISTAS GLOBALES
    // -------------------------------------------------------------------------

    private ArrayList<Pais> obtenerTodosLosPaises() {
        ArrayList<Pais> paises = new ArrayList<>();
        if (mundial.getSedes() != null) {
            for (Sede s : mundial.getSedes()) {
                if (s != null && s.getPais() != null) {
                    Pais pais = s.getPais();
                    boolean existe = false;
                    for (Pais p : paises)
                        if (p.getNombre() != null && p.getNombre().equalsIgnoreCase(pais.getNombre())) { existe = true; break; }
                    if (!existe) paises.add(pais);
                }
            }
        }
        return paises;
    }

    private ArrayList<Seleccion> obtenerTodasLasSelecciones() {
        ArrayList<Seleccion> selecciones = new ArrayList<>();
        for (Fase fase : fases) {
            if (fase != null && fase.getGrupos() != null) {
                for (Grupo grupo : fase.getGrupos()) {
                    if (grupo != null && grupo.getSelecciones() != null) {
                        for (Seleccion sel : grupo.getSelecciones())
                            if (sel != null && !selecciones.contains(sel)) selecciones.add(sel);
                    }
                }
            }
        }
        for (Pais pais : obtenerTodosLosPaises())
            if (pais.getSeleccion() != null && !selecciones.contains(pais.getSeleccion()))
                selecciones.add(pais.getSeleccion());
        return selecciones;
    }

    private ArrayList<Grupo> obtenerTodosLosGrupos() {
        ArrayList<Grupo> grupos = new ArrayList<>();
        for (Fase fase : fases)
            if (fase != null && fase.getGrupos() != null)
                for (Grupo grupo : fase.getGrupos())
                    if (grupo != null && !grupos.contains(grupo)) grupos.add(grupo);
        return grupos;
    }

    private ArrayList<Estadio> obtenerTodosLosEstadios() {
        ArrayList<Estadio> estadios = new ArrayList<>();
        if (mundial.getSedes() != null)
            for (Sede s : mundial.getSedes())
                if (s != null && s.getEstadios() != null)
                    for (Estadio e : s.getEstadios())
                        if (e != null && !estadios.contains(e)) estadios.add(e);
        return estadios;
    }

    private ArrayList<Partido> obtenerTodosLosPartidos() {
        ArrayList<Partido> partidos = new ArrayList<>();
        for (Fase fase : fases)
            if (fase != null && fase.getPartidos() != null)
                for (Partido p : fase.getPartidos())
                    if (p != null && !partidos.contains(p)) partidos.add(p);
        return partidos;
    }

    // -------------------------------------------------------------------------
    // UTILIDADES
    // -------------------------------------------------------------------------

    private int leerOpcion() {
        try { return Integer.parseInt(scanner.nextLine().trim()); }
        catch (NumberFormatException e) { return -1; }
    }

    private int leerEntero() {
        try { return Integer.parseInt(scanner.nextLine().trim()); }
        catch (NumberFormatException e) { System.out.println("Entrada no valida."); return 0; }
    }
}