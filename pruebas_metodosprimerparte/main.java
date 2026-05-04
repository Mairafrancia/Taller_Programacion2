package pruebas_metodosprimerparte;


import taller_programacion2.*;
import administracion_delegaciones.AdministracionDelegaciones;
import organizacion_deportiva.OrganizacionDeportiva;
import gestion_infraestructura.GestionInfraestructura;
import registros_eventos_campos.RegistrosEventosCampos;
import java.util.ArrayList;

public class main{
    public static void main(String[] args) {
        // Crear instancia del Mundial
        Mundial mundial = new Mundial();
        mundial.setAnio(2026);
        mundial.setMascota("Mascota Mundial");

        // Instancias de las clases de gestión
        GestionInfraestructura gi = new GestionInfraestructura();
        AdministracionDelegaciones ad = new AdministracionDelegaciones();
        OrganizacionDeportiva od = new OrganizacionDeportiva();
        RegistrosEventosCampos rec = new RegistrosEventosCampos();

        // Prueba 1: Gestión de Infraestructura (Ampliada)
        System.out.println("=== PRUEBA GESTIÓN DE INFRAESTRUCTURA ===");
        
        // Primera sede
        Sede sede1 = new Sede();
        sede1.setCiudad("Buenos Aires");
        sede1.setClima("Templado");
        sede1.setZonaHoraria("GMT-3");
        gi.registrarSede(mundial, sede1);

        Estadio estadio1 = new Estadio();
        estadio1.setNombre("Estadio Monumental");
        estadio1.setCapacidad(70000);
        gi.registrarEstadioEnSede(sede1, "Estadio Monumental", 70000);

        Estadio estadio2 = new Estadio();
        estadio2.setNombre("Estadio Libertadores de América");
        estadio2.setCapacidad(48000);
        gi.registrarEstadioEnSede(sede1, "Estadio Libertadores de América", 48000);

        // Segunda sede
        Sede sede2 = new Sede();
        sede2.setCiudad("Río de Janeiro");
        sede2.setClima("Tropical");
        sede2.setZonaHoraria("GMT-3");
        gi.registrarSede(mundial, sede2);

        Estadio estadio3 = new Estadio();
        estadio3.setNombre("Maracaná");
        estadio3.setCapacidad(78000);
        gi.registrarEstadioEnSede(sede2, "Maracaná", 78000);

        System.out.println("Sedes registradas: " + mundial.getSedes().size());
        System.out.println("Estadios en sede1: " + sede1.getEstadios().size());
        System.out.println("Estadios en sede2: " + sede2.getEstadios().size());

        // Prueba 2: Administración de Delegaciones (Ampliada)
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

        Jugador jugador1 = new Jugador();
        jugador1.setNombre("Lionel Messi");
        jugador1.setDorsal(10);
        ad.registrarJugador(seleccion1, jugador1);

        Jugador jugador2 = new Jugador();
        jugador2.setNombre("Ángel Di María");
        jugador2.setDorsal(11);
        ad.registrarJugador(seleccion1, jugador2);

        CuerpoTecnico ct1 = new CuerpoTecnico();
        ct1.setNombre("Lionel Scaloni");
        ct1.setRol(Rol.AYUDANTECAMPO);
        ad.registrarCuerpoTecnico(seleccion1, ct1);

        // País 2: Brasil
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

        CuerpoTecnico ct2 = new CuerpoTecnico();
        ct2.setNombre("Tite");
        ct2.setRol(Rol.ENTRENADORARQUEROS);
        ad.registrarCuerpoTecnico(seleccion2, ct2);

        System.out.println("Jugadores en selección Argentina: " + seleccion1.getJugadores().size());
        System.out.println("Cuerpo técnico en selección Argentina: " + seleccion1.getCuerposTecnicos().size());
        System.out.println("Jugadores en selección Brasil: " + seleccion2.getJugadores().size());
        System.out.println("Cuerpo técnico en selección Brasil: " + seleccion2.getCuerposTecnicos().size());

        // Prueba 3: Organización Deportiva (Ampliada)
        System.out.println("\n=== PRUEBA ORGANIZACIÓN DEPORTIVA ===");
        
        // Fase de Grupos
        Fase faseGrupos = new Fase();
        faseGrupos.setNombre(NombreFase.GRUPOS);
        od.configurarFaseYGrupo(mundial, NombreFase.GRUPOS, "Grupo A", "Grupo de primera fase");
        od.configurarFaseYGrupo(mundial, NombreFase.GRUPOS, "Grupo B", "Grupo de primera fase");

        // Fase de Eliminatorias
        Fase faseEliminatorias = new Fase();
        faseEliminatorias.setNombre(NombreFase.CUARTOS);
        od.configurarFaseYGrupo(mundial, NombreFase.CUARTOS, "Cuartos", "Fase de eliminación");

        // Planificar partidos
        od.planificarPartido(faseGrupos, estadio1, seleccion1, seleccion2, 20261101, 2000);
        od.planificarPartido(faseGrupos, estadio3, seleccion2, seleccion1, 20261105, 1800);

        System.out.println("Grupos en fase de grupos: " + faseGrupos.getGrupos().size());
        System.out.println("Partidos en fase de grupos: " + faseGrupos.getPartidos().size());
        System.out.println("Grupos en fase de eliminatorias: " + faseEliminatorias.getGrupos().size());

        // Prueba 4: Registro de Eventos (Ampliada)
        System.out.println("\n=== PRUEBA REGISTRO DE EVENTOS ===");
        Partido partido1 = faseGrupos.getPartidos().get(0); // Partido 1
        rec.registrarEventoDeCampo(partido1, TipoEvento.GOL, 45, jugador1);
        rec.registrarEventoDeCampo(partido1, TipoEvento.TARJETAAMARILLA, 67, jugador2);
        rec.registrarEventoDeCampo(partido1, TipoEvento.PENALCOMETIDO, 78, jugador3);

        Partido partido2 = faseGrupos.getPartidos().get(1); // Partido 2
        rec.registrarEventoDeCampo(partido2, TipoEvento.GOL, 23, jugador3);
        rec.registrarEventoDeCampo(partido2, TipoEvento.SUSTITUCION, 60, jugador1);

        System.out.println("Eventos en partido 1: " + partido1.getEventos().size());
        System.out.println("Eventos en partido 2: " + partido2.getEventos().size());

        System.out.println("\n=== TODAS LAS PRUEBAS COMPLETADAS ===");
    }
}