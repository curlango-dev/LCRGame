
/**
 * Juego Left-Center-Write.
 *
 * Esta versión se desarrolló en el salón de clase.
 * 
 * @author (Cecilia Curlango Rosas)
 * @version (1.0 agosto 2025)
 */
public class LCRGame
{
    private DadoLCR dado1, dado2, dado3;
    private Jugador jugador1, jugador2, jugador3;

    /**
     * Configura el juego a su estado inicial.
     * Crea los dados y los jugadores.
     */
    public LCRGame() {
        dado1 = new DadoLCR();
        dado2 = new DadoLCR();
        dado3 = new DadoLCR();

        jugador1 = new Jugador();
        jugador2 = new Jugador();
        jugador3 = new Jugador();
    }

    /**
     * Método de prueba que simula un juego.
     * 
     */
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

    /**
     * Simula la creación de los jugadores. 
     * Le asigna un nombre predeterminado a cada uno.
     */
    public void crearJugadores() {
        jugador1.setNombre("uno");
        jugador2.setNombre("dos");
        jugador3.setNombre("tres");
    }

    /**
     * Determina por suerte cuál de los tres
     * jugadores iniciará el juego. Lanza los
     * tres dados para cada jugador y el que
     * tenga la mayor cantidad de puntos es el 
     * que empieza el juego.
     * @return el número del jugador que iniciará (1-3).
     */
    public int encontrarPrimerJugador() {
        // turno del primer jugador
        int primerJugador = 1;
        lanzar3Dados();
        int cuantosPuntosHay = contarPuntos();

        // turno del segundo jugador
        lanzar3Dados();
        if (cuantosPuntosHay < contarPuntos()) {
            primerJugador = 2;
            cuantosPuntosHay = contarPuntos();
        }

        // turno del tercer jugador
        lanzar3Dados();
        if (cuantosPuntosHay < contarPuntos()) {
            primerJugador = 3;
            cuantosPuntosHay = contarPuntos();
        }

        return primerJugador;
    }

    /**
     * Cuenta cuantos dados caen en punto.
     * @return cantidad de dados que tienen un punto.
     */
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

    /**
     * Lanza los 3 dados.
     */
    public void lanzar3Dados() {
        dado1.lanzar();
        dado2.lanzar();
        dado3.lanzar();
    }
}