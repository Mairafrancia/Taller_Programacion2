package MAIN;


import CLASES.DirectorTecnico;
import CLASES.Estadio;
import CLASES.Fase;
import CLASES.Grupo;
import CLASES.Partido;
import CLASES.Rol;
import CLASES.Arbitro;
import CLASES.CategoriaArbitro;
import CLASES.CuerpoTecnico;
import CLASES.Arbitraje;
import CLASES.Jugador;
import CLASES.Mundial;
import CLASES.NombreFase;
import CLASES.Pais;
import CLASES.Sede;
import CLASES.Seleccion;
import CLASES.TipoEvento;
import GESTION.AdministracionDelegaciones;
import GESTION.GestionInfraestructura;
import GESTION.OrganizacionDeportiva;
import GESTION.RegistrosEventosCampos;
//import java.util.ArrayList;

public class prueba{
    public static void main(String[] args) {
        // Crear instancia del Mundial
        Mundial mundial = new Mundial();
        mundial.setAnio(2026);
        mundial.setMascota("Zayu");
        mundial.setFechaDesde(20260611); // Fecha desde
        mundial.setFechaHasta(20260719); // Fecha hasta

        // Instanciamos  clases de gestión
        GestionInfraestructura gi = new GestionInfraestructura();
        AdministracionDelegaciones ad = new AdministracionDelegaciones();
        OrganizacionDeportiva od = new OrganizacionDeportiva();
        RegistrosEventosCampos rec = new RegistrosEventosCampos();

        //--------------------------------------
        // Prueba 1: Gestión de Infraestructura (Ampliada)
        System.out.println("=== PRUEBA GESTIÓN DE INFRAESTRUCTURA ===");
        
        // Primera sede
        Sede sede1 = new Sede();
        sede1.setCiudad("Buenos Aires");
        sede1.setClima("Templado");
        sede1.setZonaHoraria("UTC-3");

        //CUMPLIMIENTO DEL PRIMER METODO DE LA CLASE GESTION INFRAESTRUCTURA
        gi.registrarSede(mundial, sede1);

        //REGISTRAR (2)ESTADIOS EN (1)SEDE - CUMPLIMIENTO DEL SEGUNDO METODO DE LA CLASE GESTION INFRAESTRUCTURA

        Estadio estadio1 = new Estadio();
        estadio1.setNombre("Estadio Monumental");
        estadio1.setCapacidad(85018);
        gi.registrarEstadioEnSede(sede1, "Estadio Monumental", 85018);

        Estadio estadio2 = new Estadio();
        estadio2.setNombre("Estadio Libertadores de América");
        estadio2.setCapacidad(48000);
        gi.registrarEstadioEnSede(sede1, "Estadio Libertadores de América", 48000);

        // RECUPERAMOS LOS ESTADIOS REALES:
        // Hacemos esto para asegurarnos de que la variable 'estadio1' sea EL MISMO objeto 
        // que se guardó en la sede. Si no lo hacemos, podríamos estar trabajando con 
        // una "copia" y los partidos no aparecerían después en la lista de la sede.

        estadio1 = sede1.getEstadios().get(0); 
        estadio2 = sede1.getEstadios().get(1);


        // Segunda sede y su estadio
        Sede sede2 = new Sede();
        sede2.setCiudad("Río de Janeiro");
        sede2.setClima("Tropical");
        sede2.setZonaHoraria("GMT-3");
        gi.registrarSede(mundial, sede2);

        Estadio estadio3 = new Estadio();
        estadio3.setNombre("Maracaná");
        estadio3.setCapacidad(78000);
        gi.registrarEstadioEnSede(sede2, "Maracaná", 78000);

        estadio3 = sede2.getEstadios().get(0);

        System.out.println("Sedes registradas: " + mundial.getSedes().size());
        System.out.println("Estadios en sede1: " + sede1.getEstadios().size());
        System.out.println("Estadios en sede2: " + sede2.getEstadios().size());

        //----------------------------------------------
        // Prueba 2: Administración de Delegaciones 
        System.out.println("\n=== PRUEBA ADMINISTRACIÓN DE DELEGACIONES ===");
        
        // País 1: Argentina
        Pais pais1 = new Pais();
        pais1.setNombre("Argentina");
        pais1.setBandera("Bandera Argentina");

        Seleccion seleccion1 = new Seleccion();
        seleccion1.setNombreFederacion("AFA");

        Grupo grupo1 = new Grupo();
        grupo1.setIdentificador("A");

        ad.vincularPaisAlSistema(mundial, sede1, pais1);
        ad.gestionarSeleccion(pais1, seleccion1, grupo1);

        //REGISTRO DE JUGADORES 
        Jugador jugador1 = new Jugador();
        jugador1.setNombre("Lionel Messi");
        jugador1.setDorsal(10);
        

        Jugador jugador2 = new Jugador();
        jugador2.setNombre("Ángel Di María");
        jugador2.setDorsal(11);
        
        ad.registrarJugador(seleccion1, jugador1);
        ad.registrarJugador(seleccion1, jugador2);

        //REGISTRO DE DIRECTOR TECNICO Y EQUIPO TECNICO
        DirectorTecnico dt1 = new DirectorTecnico("Lionel Scaloni", 1972, 20221101);
        seleccion1.setDirectorTecnico(dt1); // Asignar como director técnico

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
        //--------------

        //REGISTRAR SEGUNDO PAIS, SELECCION Y JUGADOR
        Pais pais2 = new Pais();
        pais2.setNombre("Brasil");
        pais2.setBandera("Bandera Brasil");

        Seleccion seleccion2 = new Seleccion();
        seleccion2.setNombreFederacion("CBF");

        ad.vincularPaisAlSistema(mundial, sede2, pais2);
        ad.gestionarSeleccion(pais2, seleccion2, grupo1);

        Jugador jugador3 = new Jugador();
        jugador3.setNombre("Neymar");
        jugador3.setDorsal(10);
        ad.registrarJugador(seleccion2, jugador3);

        DirectorTecnico dt2 = new DirectorTecnico("Carlos Ancelotti", 1959, 20220601);
        seleccion2.setDirectorTecnico(dt2); // Asignar como director técnico

        CuerpoTecnico ctB = new CuerpoTecnico();
        ctB.setNombre("Tite");
        ctB.setRol(Rol.ENTRENADORARQUEROS);
        ad.registrarCuerpoTecnico(seleccion2, ctB);

        //IMPRIMIR LA CANTIDAD DE JUGADORES Y CUERPO TECNICO EN CADA SELECCION PARA VERIFICAR Q SE REGISTRARON BIEN

        System.out.println("Jugadores en selección Argentina: " + seleccion1.getJugadores().size());
        System.out.println("Cuerpo técnico en selección Argentina: " + seleccion1.getCuerposTecnicos().size());
        System.out.println("Jugadores en selección Brasil: " + seleccion2.getJugadores().size());
        System.out.println("Cuerpo técnico en selección Brasil: " + seleccion2.getCuerposTecnicos().size());

        //------------------------------

        // Prueba 3: Organización Deportiva (Ampliada)
        System.out.println("\n=== PRUEBA ORGANIZACIÓN DEPORTIVA ===");
        
        // Fase de Grupos - Capturar la fase y agregar múltiples grupos
        Fase faseGrupos = od.configurarFaseYGrupo(mundial, NombreFase.GRUPOS, "A", "Grupo de primera fase");
        od.configurarGrupoEnFase(faseGrupos, "B", "Grupo de primera fase");
        od.configurarGrupoEnFase(faseGrupos, "C", "Grupo de primera fase");
        od.configurarGrupoEnFase(faseGrupos, "D", "Grupo de primera fase");

        // Fase de Eliminatorias - Capturar la fase
        Fase faseEliminatorias = od.configurarFaseYGrupo(mundial, NombreFase.CUARTOS, "Cuartos", "Fase de eliminación");

        // Planificar partidos
        od.planificarPartido(faseGrupos, estadio1, seleccion1, seleccion2, 20261101, 2000);
        od.planificarPartido(faseGrupos, estadio3, seleccion2, seleccion1, 20261105, 1800);

        // Crear y asignar árbitros a los partidos
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

        // Asignar árbitros al primer partido
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

        // Asignar árbitros al segundo partido
        Partido partido2 = faseGrupos.getPartidos().get(1);
        Arbitraje arbitrajePrincipal2 = new Arbitraje(CategoriaArbitro.PRINCIPAL, partido2, arbitro2);
        Arbitraje arbitrajeAsistente3 = new Arbitraje(CategoriaArbitro.ASISTENTE_1, partido2, arbitro1);
        
        partido2.agregarArbitraje(arbitrajePrincipal2);
        partido2.agregarArbitraje(arbitrajeAsistente3);
        
        arbitro2.agregarArbitraje(arbitrajePrincipal2);
        arbitro1.agregarArbitraje(arbitrajeAsistente3);

        System.out.println("Grupos en fase de grupos: " + faseGrupos.getGrupos().size());
        System.out.println("Partidos en fase de grupos: " + faseGrupos.getPartidos().size());
        System.out.println("Grupos en fase de eliminatorias: " + faseEliminatorias.getGrupos().size());
        System.out.println("Árbitros en partido 1: " + partido1.getArbitrajes().size());
        System.out.println("Árbitros en partido 2: " + partido2.getArbitrajes().size());

        // Prueba 4: Registro de Eventos (Ampliada)
        System.out.println("\n=== PRUEBA REGISTRO DE EVENTOS ===");
        rec.registrarEventoDeCampo(partido1, TipoEvento.GOL, 45, jugador1);
        rec.registrarEventoDeCampo(partido1, TipoEvento.TARJETA_AMARILLA, 67, jugador2);
        rec.registrarEventoDeCampo(partido1, TipoEvento.PENAL_COMETIDO, 78, jugador3);

        rec.registrarEventoDeCampo(partido2, TipoEvento.GOL, 23, jugador3);
        rec.registrarEventoDeCampo(partido2, TipoEvento.SUSTITUCION, 60, jugador1);

        System.out.println("Eventos en partido 1: " + partido1.getEventos().size());
        System.out.println("Eventos en partido 2: " + partido2.getEventos().size());

        System.out.println("\n=== TODAS LAS PRUEBAS COMPLETADAS ===");
    }
}