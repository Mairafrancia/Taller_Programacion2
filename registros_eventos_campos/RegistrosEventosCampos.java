package registros_eventos_campos;
import taller_programacion2.*;

public class RegistrosEventosCampos {

    public void registrarEventoDeCampo(Partido partido, TipoEvento tipo, int minuto, Jugador jugador) {
        // 1. Crear la instancia del Evento
        Evento nuevoEvento = new Evento();
        // 2. Configurar los datos (minuto, tipo y jugador)
        nuevoEvento.setTipo(tipo); 
        nuevoEvento.setMinuto(minuto);
        nuevoEvento.setJugador(jugador);
        // 3. Vincular el evento al partido
        // Como es composición, el partido lo guarda en su lista interna
        partido.agregarEvento(nuevoEvento);
        System.out.println("Evento registrado en el partido: " + tipo + " - Minuto: " + minuto);
    }
}
