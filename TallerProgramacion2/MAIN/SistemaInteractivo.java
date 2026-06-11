package MAIN;

import CLASES.*;
import GESTION1.*;
import GESTION2.*;
import EXCEPCIONES.*;
import java.util.ArrayList;
import java.util.Scanner;

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
            int opcion = leerOpción();
            salir = procesarMenuPrincipal(opcion);
        }
        System.out.println("\n>>> Gracias por usar el sistema. Hasta luego!");
        scanner.close();
    }

    private void mostrarMenuPrincipal() {
        System.out.println("\n+------------------------------------------------------------+");
        System.out.println("| SISTEMA DE GESTION DEL TORNEO MUNDIAL 2026                |");
        System.out.println("+------------------------------------------------------------+");
        System.out.println("| 1. Gestionar infraestructura                               |");
        System.out.println("| 2. Administrar delegaciones                                |");
        System.out.println("| 3. Organizar partidos                                       |");
        System.out.println("| 4. Registrar eventos de campo                              |");
        System.out.println("| 5. Tabla de posiciones por grupo                           |");
        System.out.println("| 6. Tabla de resultados por selección                       |");
        System.out.println("| 7. Ranking de goleadores                                   |");
        System.out.println("| 8. Informe disciplinario                                   |");
        System.out.println("| 9. Ficha técnica de partido                                |");
        System.out.println("|10. Estadísticas de sedes                                   |");
        System.out.println("|11. Ver información del Mundial                              |");
        System.out.println("| 0. Salir                                                   |");
        System.out.println("+------------------------------------------------------------+");
        System.out.print("Seleccione una opcion: ");
    }

    private boolean procesarMenuPrincipal(int opcion) {
        try {
            switch (opcion) {
                case 1: menuInfraestructura(); break;
                case 2: menuDelegaciones(); break;
                case 3: menuOrganizacionDeportiva(); break;
                case 4: menuRegistroEventos(); break;
                case 5: reporteTablaPosiciones(); break;
                case 6: reporteTablaResultados(); break;
                case 7: reporteRankingGoleadores(); break;
                case 8: reporteInformeDisciplinario(); break;
                case 9: reporteFichaTecnica(); break;
                case 10: reporteEstadisticasSedes(); break;
                case 11: mostrarInfoMundial(); break;
                case 0: return true;
                default: System.out.println("Opción no valida.");
            }
        } catch (Exception e) {
            System.err.println("Error: " + e.getMessage());
        }
        return false;
    }

    private void menuInfraestructura() {
        System.out.println("\n+---------------------------+");
        System.out.println("| GESTION DE INFRAESTRUCTURA|");
        System.out.println("+---------------------------+");
        System.out.println("1. Registrar Nueva Sede");
        System.out.println("2. Registrar Estadio en Sede");
        System.out.println("3. Ver Sedes Registradas");
        System.out.println("0. Volver");
        System.out.print("Opción: ");
        int opcion = leerOpción();
        switch (opcion) {
            case 1: registrarSede(); break;
            case 2: registrarEstadio(); break;
            case 3: verSedes(); break;
            case 0: break;
            default: System.out.println("Opción no valida.");
        }
    }

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
            System.out.println("Error: ningún campo puede estar vacío.");
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
        if (sedes == null || sedes.isEmpty()) {
            System.out.println("No hay sedes registradas.");
            return;
        }
        System.out.print("Nombre del Estadio: ");
        String nombre = scanner.nextLine();
        if (nombre.trim().isEmpty()) {
            System.out.println("Error: el nombre del estadio no puede estar vacío.");
            return;
        }
        System.out.print("Capacidad: ");
        int capacidad = leerEntero();
        if (capacidad <= 0) {
            System.out.println("Error: la capacidad debe ser un número mayor a 0.");
            return;
        }
        System.out.println("Sedes disponibles:");
        for (int i = 0; i < sedes.size(); i++) {
            System.out.println((i + 1) + ". " + sedes.get(i).getCiudad());
        }
        System.out.print("Seleccione sede: ");
        int index = leerOpción() - 1;
        if (index < 0 || index >= sedes.size()) {
            System.out.println("Opción invalida.");
            return;
        }
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
        if (sedes == null || sedes.isEmpty()) {
            System.out.println("No hay sedes registradas.");
            return;
        }
        System.out.println("\nSedes:");
        for (Sede sede : sedes) {
            System.out.println("- " + sede.getCiudad() + " (" + sede.getZonaHoraria() + ")");
            if (sede.getEstadios() != null) {
                for (Estadio e : sede.getEstadios()) {
                    System.out.println("   * " + e.getNombre() + " - Capacidad: " + e.getCapacidad());
                }
            }
        }
    }

    private void menuDelegaciones() {
        System.out.println("\n+---------------------------+");
        System.out.println("| ADMINISTRACION DELEGACIONES|");
        System.out.println("+---------------------------+");
        System.out.println("1. Registrar Seleccion");
        System.out.println("2. Registrar Jugador");
        System.out.println("3. Registrar Director Tecnico");
        System.out.println("4. Registrar Cuerpo Técnico");
        System.out.println("5. Ver Selecciones");
        System.out.println("0. Volver");
        System.out.print("Opción: ");
        int opcion = leerOpción();
        switch (opcion) {
            case 1: registrarSeleccion(); break;
            case 2: registrarJugador(); break;
            case 3: registrarDirectorTecnico(); break;
            case 4: registrarCuerpoTecnico(); break;
            case 5: verSelecciones(); break;
            case 0: break;
            default: System.out.println("Opción no valida.");
        }
    }

    private void registrarSeleccion() {
        Grupo grupo = seleccionarGrupo("Seleccione el grupo:");
        if (grupo == null) return;
        Pais pais = seleccionarPais("Seleccione el país:");
        if (pais == null) return;
        System.out.print("Nombre de la federación: ");
        String nombre = scanner.nextLine();
        if (nombre.trim().isEmpty()) {
            System.out.println("Error: el nombre de la federación no puede estar vacío.");
            return;
        }
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
        Seleccion seleccion = seleccionarSeleccion("Seleccione la selección:");
        if (seleccion == null) return;
        System.out.print("Nombre del jugador: ");
        String nombre = scanner.nextLine();
        if (nombre.trim().isEmpty()) {
            System.out.println("Error: el nombre del jugador no puede estar vacío.");
            return;
        }
        System.out.print("Dorsal: ");
        int dorsal = leerEntero();
        if (dorsal <= 0) {
            System.out.println("Error: el dorsal debe ser un número mayor a 0.");
            return;
        }
        System.out.print("Fecha nacimiento (YYYYMMDD): ");
        int fecha = leerEntero();
        if (fecha <= 0) {
            System.out.println("Error: la fecha debe ser un número válido.");
            return;
        }
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
        Seleccion seleccion = seleccionarSeleccion("Seleccione la selección:");
        if (seleccion == null) return;
        System.out.print("Nombre DT: ");
        String nombre = scanner.nextLine();
        if (nombre.trim().isEmpty()) {
            System.out.println("Error: el nombre del DT no puede estar vacío.");
            return;
        }
        System.out.print("Año de nacimiento: ");
        int ano = leerEntero();
        if (ano <= 0) {
            System.out.println("Error: el año de nacimiento debe ser un número válido.");
            return;
        }
        DirectoresTecnicos dt = new DirectoresTecnicos(nombre, ano, 20000101);
        try {
            ad.registrarDirectorTecnico(seleccion, dt);
            System.out.println("Director técnico registrado: " + nombre);
        } catch (TorneoException e) {
            System.err.println("Error: " + e.getMessage());
        }
    }

    private void registrarCuerpoTecnico() {
        Seleccion seleccion = seleccionarSeleccion("Seleccione la selección:");
        if (seleccion == null) return;
        System.out.print("Nombre integrante: ");
        String nombre = scanner.nextLine();
        if (nombre.trim().isEmpty()) {
            System.out.println("Error: el nombre del integrante no puede estar vacío.");
            return;
        }
        System.out.print("Rol (AYUDANTECAMPO, ENTRENADORARQUEROS, PREPARADORFISICO, MEDICO): ");
        String rol = scanner.nextLine().trim().toUpperCase();
        if (rol.isEmpty()) {
            System.out.println("Error: el rol no puede estar vacío.");
            return;
        }
        try {
            CuerpoTecnico ct = new CuerpoTecnico();
            ct.setNombre(nombre);
            ct.setRol(Rol.valueOf(rol));
            ad.registrarCuerpoTecnico(seleccion, ct);
            System.out.println("Integrante creado: " + nombre);
        } catch (IllegalArgumentException e) {
            System.out.println("Rol no válido.");
        } catch (TorneoException e) {
            System.err.println("Error: " + e.getMessage());
        }
    }

    private void registrarArbitraje() {
        Partido partido = seleccionarPartido("Seleccione el partido:");
        if (partido == null) return;

        System.out.print("Nombre del árbitro: ");
        String nombre = scanner.nextLine();
        if (nombre.trim().isEmpty()) {
            System.out.println("Error: el nombre del árbitro no puede estar vacío.");
            return;
        }
        System.out.print("Año de nacimiento (YYYYMMDD): ");
        int fecNacimiento = leerEntero();
        if (fecNacimiento <= 0) {
            System.out.println("Error: el año de nacimiento debe ser un número válido.");
            return;
        }
        System.out.print("Años de experiencia: ");
        int anios = leerEntero();
        if (anios < 0) {
            System.out.println("Error: los años de experiencia no pueden ser negativos.");
            return;
        }
        Pais paisArbitro = seleccionarPais("Seleccione el país del árbitro:");
        if (paisArbitro == null) return;

        System.out.print("Rol (PRINCIPAL, ASISTENTE1, ASISTENTE2, CUARTOARBITRO, VARPRINCIPAL, VARASISTENTE): ");
        String rol = scanner.nextLine().trim().toUpperCase();
        if (rol.isEmpty()) {
            System.out.println("Error: el rol no puede estar vacío.");
            return;
        }
        try {
            Arbitro arbitro = new Arbitro(nombre, fecNacimiento, anios, paisArbitro);
            Arbitraje arbitraje = new Arbitraje(CategoriaArbitro.valueOf(rol), partido, arbitro);
            partido.agregarArbitraje(arbitraje);
            arbitro.agregarArbitraje(arbitraje);
            System.out.println("✓ Arbitraje registrado: " + nombre + " (" + paisArbitro.getNombre() + ") como " + rol);
            if (!partido.tieneEquipoArbitralValido()) {
                System.out.println("⚠ Nota: El partido aún no tiene equipo arbitral completo.");
            }
        } catch (IllegalArgumentException e) {
            System.out.println("Rol no válido.");
        } catch (Exception e) {
            System.err.println("Error: " + e.getMessage());
        }
    }

    private void verSelecciones() {
        ArrayList<Seleccion> selecciones = obtenerTodasLasSelecciones();
        if (selecciones.isEmpty()) {
            System.out.println("No hay selecciones registradas.");
            return;
        }
        System.out.println("\nSelecciones:");
        for (Seleccion sel : selecciones) {
            String pais = sel.getPais() != null ? sel.getPais().getNombre() : "Sin país";
            String grupo = sel.getGrupo() != null ? sel.getGrupo().getIdentificador() : "Sin grupo";
            int jugadores = sel.getJugadores() != null ? sel.getJugadores().size() : 0;
            System.out.println("- " + sel.getNombreFederacion() + " | Pais: " + pais + " | Grupo: " + grupo + " | Jugadores: " + jugadores);
        }
    }

    private void menuOrganizacionDeportiva() {
        System.out.println("\n+---------------------------+");
        System.out.println("| ORGANIZACION DEPORTIVA   |");
        System.out.println("+---------------------------+");
        System.out.println("1. Registrar Grupo");
        System.out.println("2. Planificar Partido");
        System.out.println("3. Asignar Equipos a Partido");
        System.out.println("4. Registrar Arbitraje");
        System.out.println("0. Volver");
        System.out.print("Opción: ");
        int opcion = leerOpción();
        switch (opcion) {
            case 1: registrarGrupo(); break;
            case 2: planificarPartido(); break;
            case 3: asignarEquiposAPartido(); break;
            case 4: registrarArbitraje(); break;
            case 0: break;
            default: System.out.println("Opción no valida.");
        }
    }

    private void registrarGrupo() {
        Fase fase = seleccionarFase("Seleccione la fase:");
        if (fase == null) return;
        System.out.print("Id grupo: ");
        String id = scanner.nextLine();
        if (id.trim().isEmpty()) {
            System.out.println("Error: el id del grupo no puede estar vacío.");
            return;
        }
        System.out.print("Descripción: ");
        String desc = scanner.nextLine();
        if (desc.trim().isEmpty()) {
            System.out.println("Error: la descripción no puede estar vacía.");
            return;
        }
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
        if (fecha <= 0) {
            System.out.println("Error: la fecha debe ser un número válido.");
            return;
        }
        System.out.print("Horario (HHMM): ");
        int horario = leerEntero();
        if (horario <= 0) {
            System.out.println("Error: el horario debe ser un número válido.");
            return;
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

    private void asignarEquiposAPartido() {
        Partido partido = seleccionarPartido("Seleccione el partido:");
        if (partido == null) return;
        ArrayList<Seleccion> selecciones = obtenerTodasLasSelecciones();
        if (selecciones.size() < 2) {
            System.out.println("Se necesitan al menos dos selecciones.");
            return;
        }
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

    private void menuRegistroEventos() {
        System.out.println("\n+---------------------------+");
        System.out.println("| REGISTRO DE EVENTOS      |");
        System.out.println("+---------------------------+");
        System.out.println("1. Registrar Evento");
        System.out.println("2. Ver Eventos de un Partido");
        System.out.println("0. Volver");
        System.out.print("Opción: ");
        int opcion = leerOpción();
        switch (opcion) {
            case 1: registrarEvento(); break;
            case 2: verEventosPartido(); break;
            case 0: break;
            default: System.out.println("Opción no valida.");
        }
    }

    private void registrarEvento() {
        Partido partido = seleccionarPartido("Seleccione el partido:");
        if (partido == null) return;
        Jugador jugador = seleccionarJugadorDePartido(partido);
        if (jugador == null) return;
        System.out.print("Tipo de evento: ");
        String tipo = scanner.nextLine().trim().toUpperCase();
        if (tipo.isEmpty()) {
            System.out.println("Error: el tipo de evento no puede estar vacío.");
            return;
        }
        System.out.print("Minuto: ");
        int minuto = leerEntero();
        if (minuto <= 0) {
            System.out.println("Error: el minuto debe ser un número mayor a 0.");
            return;
        }
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
            System.out.println("No hay eventos registrados.");
            return;
        }
        System.out.println("Eventos:");
        for (Evento e : partido.getEventos()) {
            System.out.println("- " + e.getTipo() + " minuto " + e.getMinuto() + " | " + e.getJugador().getNombre());
        }
    }

    private void reporteTablaPosiciones() {
        Grupo grupo = seleccionarGrupo("Seleccione el grupo:");
        if (grupo == null) return;
        ArrayList<String> tabla = tablaPosiciones.obtenerTablaPosiciones(grupo);
        if (tabla == null || tabla.isEmpty()) {
            System.out.println("No hay datos para esta tabla.");
            return;
        }
        for (String linea : tabla) {
            System.out.println(linea);
        }
    }

    private void reporteTablaResultados() {
        Seleccion seleccion = seleccionarSeleccion("Seleccione la selección:");
        if (seleccion == null) return;
        ArrayList<String> resultados = tablaResultados.obtenerResultados(seleccion);
        if (resultados == null || resultados.isEmpty()) {
            System.out.println("No hay resultados para esta seleccion.");
            return;
        }
        for (String linea : resultados) {
            System.out.println(linea);
        }
    }

    private void reporteRankingGoleadores() {
        Seleccion seleccion = seleccionarSeleccion("Seleccione la selección:");
        if (seleccion == null) return;
        ArrayList<String> ranking = rankingGoles.rankingPorSeleccion(seleccion);
        if (ranking == null || ranking.isEmpty()) {
            System.out.println("No hay goleadores registrados.");
            return;
        }
        for (String linea : ranking) {
            System.out.println(linea);
        }
    }

    private void reporteInformeDisciplinario() {
        System.out.println("\n1. Por selección");
        System.out.println("2. Por jugador");
        System.out.print("Opción: ");
        int opcion = leerOpción();
        if (opcion == 1) {
            Seleccion seleccion = seleccionarSeleccion("Seleccione la selección:");
            if (seleccion == null) return;
            ArrayList<String> informe = informeCards.informePorSeleccion(seleccion);
            if (informe == null || informe.isEmpty()) {
                System.out.println("No hay datos disciplinarios.");
                return;
            }
            for (String linea : informe) {
                System.out.println(linea);
            }
        } else if (opcion == 2) {
            Seleccion seleccion = seleccionarSeleccion("Seleccione la selección del jugador:");
            if (seleccion == null) return;
            Jugador jugador = seleccionarJugador(seleccion);
            if (jugador == null) return;
            ArrayList<String> informe = informeCards.informePorJugador(jugador);
            if (informe == null || informe.isEmpty()) {
                System.out.println("No hay datos disciplinarios.");
                return;
            }
            for (String linea : informe) {
                System.out.println(linea);
            }
        } else {
            System.out.println("Opción no válida.");
        }
    }

    private void reporteFichaTecnica() {
        Partido partido = seleccionarPartido("Seleccione el partido:");
        if (partido == null) return;
        ArrayList<String> ficha = fichaTecnica.obtenerFicha(partido);
        if (ficha == null || ficha.isEmpty()) {
            System.out.println("No hay ficha técnica disponible.");
            return;
        }
        for (String linea : ficha) {
            System.out.println(linea);
        }
    }

    private void reporteEstadisticasSedes() {
        System.out.println("\n1. Por estadio");
        System.out.println("2. Por ciudad");
        System.out.print("Opción: ");
        int opcion = leerOpción();
        if (opcion == 1) {
            Estadio estadio = seleccionarEstadio("Seleccione el estadio:");
            if (estadio == null) return;
            int partidos = estadisticasSedes.partidosPorEstadio(estadio);
            System.out.println("Partidos en " + estadio.getNombre() + ": " + partidos);
        } else if (opcion == 2) {
            System.out.print("Ciudad: ");
            String ciudad = scanner.nextLine().trim();
            int partidos = estadisticasSedes.partidosPorCiudad(mundial, ciudad);
            System.out.println("Partidos en " + ciudad + ": " + partidos);
        } else {
            System.out.println("Opción no válida.");
        }
    }

    private void mostrarInfoMundial() {
        System.out.println("\nInformación del Mundial:");
        System.out.println("Año: " + mundial.getAnio());
        System.out.println("Mascota: " + mundial.getMascota());
        if (mundial.getSedes() != null) {
            System.out.println("Sedes registradas: " + mundial.getSedes().size());
        }
    }

    private Pais seleccionarPais(String prompt) {
        ArrayList<Pais> paises = obtenerTodosLosPaises();
        if (paises.isEmpty()) {
            System.out.println("No hay países disponibles.");
            return null;
        }
        System.out.println(prompt);
        for (int i = 0; i < paises.size(); i++) {
            System.out.println((i + 1) + ". " + paises.get(i).getNombre());
        }
        System.out.print("Opción: ");
        int opcion = leerOpción() - 1;
        if (opcion >= 0 && opcion < paises.size()) {
            return paises.get(opcion);
        }
        System.out.println("Opción no valida.");
        return null;
    }

    private Seleccion seleccionarSeleccion(String prompt) {
        ArrayList<Seleccion> selecciones = obtenerTodasLasSelecciones();
        if (selecciones.isEmpty()) {
            System.out.println("No hay selecciones registradas.");
            return null;
        }
        System.out.println(prompt);
        for (int i = 0; i < selecciones.size(); i++) {
            Seleccion sel = selecciones.get(i);
            String pais = sel.getPais() != null ? sel.getPais().getNombre() : "Sin país";
            System.out.println((i + 1) + ". " + sel.getNombreFederacion() + " (" + pais + ")");
        }
        System.out.print("Opción: ");
        int opcion = leerOpción() - 1;
        if (opcion >= 0 && opcion < selecciones.size()) {
            return selecciones.get(opcion);
        }
        System.out.println("Opción no valida.");
        return null;
    }

    private Seleccion seleccionarSeleccionDeLista(ArrayList<Seleccion> selecciones) {
        for (int i = 0; i < selecciones.size(); i++) {
            Seleccion sel = selecciones.get(i);
            String pais = sel.getPais() != null ? sel.getPais().getNombre() : "Sin país";
            System.out.println((i + 1) + ". " + sel.getNombreFederacion() + " (" + pais + ")");
        }
        System.out.print("Opción: ");
        int opcion = leerOpción() - 1;
        if (opcion >= 0 && opcion < selecciones.size()) {
            return selecciones.get(opcion);
        }
        System.out.println("Opción no valida.");
        return null;
    }

    private Seleccion seleccionarSeleccionDeLista(ArrayList<Seleccion> selecciones, Seleccion excluir) {
        ArrayList<Seleccion> copia = new ArrayList<>();
        for (Seleccion sel : selecciones) {
            if (sel != excluir) {
                copia.add(sel);
            }
        }
        return seleccionarSeleccionDeLista(copia);
    }

    private Grupo seleccionarGrupo(String prompt) {
        ArrayList<Grupo> grupos = obtenerTodosLosGrupos();
        if (grupos.isEmpty()) {
            System.out.println("No hay grupos registrados.");
            return null;
        }
        System.out.println(prompt);
        for (int i = 0; i < grupos.size(); i++) {
            System.out.println((i + 1) + ". " + grupos.get(i).getIdentificador() + " - " + grupos.get(i).getDescripcion());
        }
        System.out.print("Opción: ");
        int opcion = leerOpción() - 1;
        if (opcion >= 0 && opcion < grupos.size()) {
            return grupos.get(opcion);
        }
        System.out.println("Opción no valida.");
        return null;
    }

    private Fase seleccionarFase(String prompt) {
        if (fases == null || fases.isEmpty()) {
            System.out.println("No hay fases registradas.");
            return null;
        }
        System.out.println(prompt);
        for (int i = 0; i < fases.size(); i++) {
            System.out.println((i + 1) + ". " + fases.get(i).getNombre());
        }
        System.out.print("Opción: ");
        int opcion = leerOpción() - 1;
        if (opcion >= 0 && opcion < fases.size()) {
            return fases.get(opcion);
        }
        System.out.println("Opción no valida.");
        return null;
    }

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
        System.out.print("Opción: ");
        int opcion = leerOpción() - 1;
        if (opcion >= 0 && opcion < estadios.size()) {
            return estadios.get(opcion);
        }
        System.out.println("Opción no valida.");
        return null;
    }

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
        System.out.print("Opción: ");
        int opcion = leerOpción() - 1;
        if (opcion >= 0 && opcion < partidos.size()) {
            return partidos.get(opcion);
        }
        System.out.println("Opción no valida.");
        return null;
    }

    private Jugador seleccionarJugador(Seleccion seleccion) {
        if (seleccion == null || seleccion.getJugadores() == null || seleccion.getJugadores().isEmpty()) {
            System.out.println("No hay jugadores en esta selección.");
            return null;
        }
        System.out.println("Seleccione jugador:");
        for (int i = 0; i < seleccion.getJugadores().size(); i++) {
            Jugador j = seleccion.getJugadores().get(i);
            System.out.println((i + 1) + ". " + j.getNombre() + " (" + j.getDorsal() + ")");
        }
        System.out.print("Opción: ");
        int opcion = leerOpción() - 1;
        if (opcion >= 0 && opcion < seleccion.getJugadores().size()) {
            return seleccion.getJugadores().get(opcion);
        }
        System.out.println("Opción no valida.");
        return null;
    }

    private Jugador seleccionarJugadorDePartido(Partido partido) {
        if (partido == null || partido.getParticipaciones() == null) {
            System.out.println("El partido no tiene participaciones.");
            return null;
        }
        ArrayList<Jugador> jugadores = new ArrayList<>();
        for (Participacion p : partido.getParticipaciones()) {
            if (p != null && p.getSeleccion() != null && p.getSeleccion().getJugadores() != null) {
                jugadores.addAll(p.getSeleccion().getJugadores());
            }
        }
        if (jugadores.isEmpty()) {
            System.out.println("No hay jugadores para este partido.");
            return null;
        }
        System.out.println("Seleccione jugador:");
        for (int i = 0; i < jugadores.size(); i++) {
            Jugador j = jugadores.get(i);
            System.out.println((i + 1) + ". " + j.getNombre() + " (" + j.getDorsal() + ")");
        }
        System.out.print("Opción: ");
        int opcion = leerOpción() - 1;
        if (opcion >= 0 && opcion < jugadores.size()) {
            return jugadores.get(opcion);
        }
        System.out.println("Opción no valida.");
        return null;
    }

    private ArrayList<Pais> obtenerTodosLosPaises() {
        ArrayList<Pais> paises = new ArrayList<>();
        if (mundial.getSedes() != null) {
            for (Sede s : mundial.getSedes()) {
                if (s != null && s.getPais() != null) {
                    Pais pais = s.getPais();
                    boolean existe = false;
                    for (Pais p : paises) {
                        if (p.getNombre() != null && p.getNombre().equalsIgnoreCase(pais.getNombre())) {
                            existe = true;
                            break;
                        }
                    }
                    if (!existe) {
                        paises.add(pais);
                    }
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
                        for (Seleccion sel : grupo.getSelecciones()) {
                            if (sel != null && !selecciones.contains(sel)) {
                                selecciones.add(sel);
                            }
                        }
                    }
                }
            }
        }
        for (Pais pais : obtenerTodosLosPaises()) {
            if (pais.getSeleccion() != null && !selecciones.contains(pais.getSeleccion())) {
                selecciones.add(pais.getSeleccion());
            }
        }
        return selecciones;
    }

    private ArrayList<Grupo> obtenerTodosLosGrupos() {
        ArrayList<Grupo> grupos = new ArrayList<>();
        for (Fase fase : fases) {
            if (fase != null && fase.getGrupos() != null) {
                for (Grupo grupo : fase.getGrupos()) {
                    if (grupo != null && !grupos.contains(grupo)) {
                        grupos.add(grupo);
                    }
                }
            }
        }
        return grupos;
    }

    private ArrayList<Estadio> obtenerTodosLosEstadios() {
        ArrayList<Estadio> estadios = new ArrayList<>();
        if (mundial.getSedes() != null) {
            for (Sede s : mundial.getSedes()) {
                if (s != null && s.getEstadios() != null) {
                    for (Estadio e : s.getEstadios()) {
                        if (e != null && !estadios.contains(e)) {
                            estadios.add(e);
                        }
                    }
                }
            }
        }
        return estadios;
    }

    private ArrayList<Partido> obtenerTodosLosPartidos() {
        ArrayList<Partido> partidos = new ArrayList<>();
        for (Fase fase : fases) {
            if (fase != null && fase.getPartidos() != null) {
                for (Partido p : fase.getPartidos()) {
                    if (p != null && !partidos.contains(p)) {
                        partidos.add(p);
                    }
                }
            }
        }
        return partidos;
    }

    private int leerOpción() {
        try {
            return Integer.parseInt(scanner.nextLine().trim());
        } catch (NumberFormatException e) {
            return -1;
        }
    }

    private int leerEntero() {
        try {
            return Integer.parseInt(scanner.nextLine().trim());
        } catch (NumberFormatException e) {
            System.out.println("Entrada no válida.");
            return 0;
        }
    }
}