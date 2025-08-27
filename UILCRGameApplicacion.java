
/**
 * Write a description of class UILCRGameApplicacion here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class UILCRGameApplicacion
{
    private LCRGame juego;

    public UILCRGameApplicacion() {
        juego = new LCRGame();
    }

    public void jugar() {
        juego.crearJugadores();
        juego.encontrarPrimerJugador();

        do {
            juego.lanzarDados();
            juego.procesarResultados();
            System.out.println("Primer jugador tiene " + juego.getJugador1().getFichas());
            System.out.println("Segundo jugador tiene " + juego.getJugador2().getFichas());
            System.out.println("Tercer jugador tiene " + juego.getJugador3().getFichas());
            juego.cambiarTurno();
            juego.establecerJugadores();
        }while(!juego.esFinDeJuego());

        // mostrar ganador
        System.out.println("Ganador " + juego.getGanador().getNombre());
    }
}

