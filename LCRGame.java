
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
    private Jugador jugadorActual, jugadorIzquierda, jugadorDerecha;
    private Jugador jugadorGanador;
    private int turno;
    private Centro centro;

    /**
     * Configura el juego a su estado inicial.
     * Crea los dados y los jugadores.
     */
    public LCRGame() {
        dado1 = new DadoLCR();
        dado2 = new DadoLCR();
        dado3 = new DadoLCR();
        centro = new Centro();

        jugador1 = new Jugador();
        jugador2 = new Jugador();
        jugador3 = new Jugador();
    }

    public boolean esFinDeJuego() {
        int jugadoresEnCero = 0;
        boolean seTermino = false;
        if (jugador1.getFichas()==0) {
            jugadoresEnCero++;
        } else{
            jugadorGanador = jugador1;
        }
        if (jugador2.getFichas()==0) {
            jugadoresEnCero++;
        } else {
            jugadorGanador = jugador2;
        }
        if (jugador3.getFichas()==0) {
            jugadoresEnCero++;
        } else {
            jugadorGanador = jugador3;
        }
        if (jugadoresEnCero==2) {
            seTermino = true;
        }
        return seTermino;
    }
    public Jugador getGanador() {
        if (!esFinDeJuego()) {
            return null;
        }
        return jugadorGanador;
    }
    public void procesarResultados() {
        int cuantosDados = jugadorActual.getFichas();
        char cara;
        switch(cuantosDados) {
            case 0:
                break;
            case 1:
                cara = dado1.getValor();
                procesarCara(cara);
                break;
            case 2:
                cara = dado1.getValor();
                procesarCara(cara);
                cara = dado2.getValor();
                procesarCara(cara);
                break;
            default:
                cara = dado1.getValor();
                procesarCara(cara);
                cara = dado2.getValor();
                procesarCara(cara);
                cara = dado3.getValor();
                procesarCara(cara);
                break;    
        }
    }

    
    private void procesarCara(char cara){
        switch(cara) {
            case 'C':
                jugadorActual.retirarFichas(1);
                centro.agregarFichas(1);
                break;
            case 'L':
                jugadorActual.retirarFichas(1);
                jugadorIzquierda.agregarFichas(1);
                break;
            case 'R':
                jugadorActual.retirarFichas(1);
                jugadorDerecha.agregarFichas(1);
                break;
        }
    }

    public void cambiarTurno() {
        turno++;
        if (turno==4) {
            turno = 1;
        }
    }

    public void establecerJugadores() {
        switch (turno) {
            case 1:
                jugadorActual = jugador1;
                jugadorIzquierda = jugador3;
                jugadorDerecha = jugador2;
                break;
            case 2:
                jugadorActual = jugador2;
                jugadorIzquierda = jugador1;
                jugadorDerecha = jugador3;
                break;
            case 3:
                jugadorActual = jugador3;
                jugadorIzquierda = jugador2;
                jugadorDerecha = jugador1;
                break;
        }
    }

    public void lanzarDados() {
        int fichas = jugadorActual.getFichas();
        switch (fichas) {
            case 0: 
                break;
            case 1:
                lanzar1Dado();
                break;
            case 2:
                lanzar2Dados();
                break;
            default:
                lanzar3Dados();
        }
    }

    /**
     * Método de prueba que simula un juego.
     * 
     */
    private String jugar() {
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
        jugadorActual = jugador1;
        lanzar3Dados();
        int cuantosPuntosHay = contarPuntos();

        // turno del segundo jugador
        lanzar3Dados();
        if (cuantosPuntosHay < contarPuntos()) {
            primerJugador = 2;
            jugadorActual = jugador2;
            cuantosPuntosHay = contarPuntos();
        }

        // turno del tercer jugador
        lanzar3Dados();
        if (cuantosPuntosHay < contarPuntos()) {
            primerJugador = 3;
            jugadorActual = jugador3;
            cuantosPuntosHay = contarPuntos();
        }
        turno = primerJugador;
        establecerJugadores();
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
     * Lanza los 1 dado.
     */
    private void lanzar1Dado() {
        dado1.lanzar();
    }

    /**
     * Lanza los 2 dados.
     */
    private void lanzar2Dados() {
        dado1.lanzar();
        dado2.lanzar();
    }

    /**
     * Lanza los 3 dados.
     */
    private void lanzar3Dados() {
        dado1.lanzar();
        dado2.lanzar();
        dado3.lanzar();
    }
    public Jugador getJugador1() {
        return jugador1;
    }
    public Jugador getJugador2() {
        return jugador2;
    }
    public Jugador getJugador3() {
        return jugador3;
    }
    public DadoLCR getDado1() {
        return dado1;
    }
    public DadoLCR getDado2() {
        return dado2;
    }
    public DadoLCR getDado3() {
        return dado3;
    }
    public Centro getCentro() {
        return centro;
    }
    
}