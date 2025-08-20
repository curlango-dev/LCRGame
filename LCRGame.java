
/**
 * Write a description of class LCRGame here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class LCRGame
{
    private DadoLCR dado1, dado2, dado3;
    private Jugador jugador1, jugador2, jugador3;

    public LCRGame() {
        dado1 = new DadoLCR();
        dado2 = new DadoLCR();
        dado3 = new DadoLCR();

        jugador1 = new Jugador();
        jugador2 = new Jugador();
        jugador3 = new Jugador();
    }

    public String jugar() {
        crearJugadores();
        Jugador inicial = null;
        switch (encontrarPrimerJugador()) {
            case 1:
                inicial = jugador1;
                break;
            case 2:
                inicial = jugador2;
                break;
            case 3:
                inicial = jugador3;
                break;
        }
        return inicial.getNombre();

    }

    private void crearJugadores() {
        jugador1.setNombre("uno");
        jugador2.setNombre("dos");
        jugador3.setNombre("tres");
    }

    private int encontrarPrimerJugador() {
        // turno del primer jugador
        int primerJugador = 1;
        lanzarDados();
        int cuantosPuntosHay = contarPuntos();

        // turno del segundo jugador
        lanzarDados();
        if (cuantosPuntosHay < contarPuntos()) {
            primerJugador = 2;
            cuantosPuntosHay = contarPuntos();
        }

        // turno del tercer jugador
        lanzarDados();
        if (cuantosPuntosHay < contarPuntos()) {
            primerJugador = 3;
            cuantosPuntosHay = contarPuntos();
        }

        return primerJugador;
    }

    private int contarPuntos() {
        int contador = 0;
        if (dado1.getValor() == '*') {
            contador++;
        }
        if (dado2.getValor() == '*') {
            contador++;
        }
        if (dado3.getValor() == '*') {
            contador++;
        }
        return contador;
    }

    private void lanzarDados() {
        dado1.lanzar();
        dado2.lanzar();
        dado3.lanzar();
    }
}