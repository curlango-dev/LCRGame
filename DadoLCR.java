
/**
 * Write a description of class DadoLCR here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class DadoLCR
{
    private Dado dado;

    public DadoLCR() {
        dado = new Dado();
    }

    public char getValor() {
        char valor = 'C';
        int elValorQueTieneElDado = dado.getValor();

        switch (elValorQueTieneElDado) {
            case 1:
            case 2:
            case 3:
                valor = '*';
                break;
            case 4:
                valor = 'L';
                break;
            case 5:
                valor = 'C';
                break;
            case 6:
                valor = 'R';
                break;
        }
        return valor;
    }
    public char lanzar() {
        char valor = 'C';

        dado.lanzar();
        valor = getValor();
        
        return valor;
    }
}