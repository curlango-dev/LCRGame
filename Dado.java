import java.util.Random;

/**
 * Modela un dado. Por default es un dado
 * de 6 lados. Se puede crear un dado con
 * una cantidad de lados específica.
 *
 * @author (Cecy Curlango Rosas)
 * @version (1.0 agosto 2025)
 */
public class Dado
{
    private int caras;
    private int valor;

    /**
     * Crea un dado de 6 lados.
     */
    public Dado()
    {
        caras = 6;
        valor = 1;
    }

    /**
     * Crea un dado con la cantidad de lados
     * especificada.
     * @param Cantidad de lados que tendrá el dado.
     */
    public Dado(int lados) {
        caras = lados;
        valor = 1;
    }
    /**
     * 
     */
    public int getValor() {
        return valor;
    }
    
    public void setValor(int nuevoValor) {
        valor = nuevoValor;
    }
    
    public int getCaras() {
        return caras;
    }
    public void setCaras(int caras) {
        this.caras = caras;
    }
    public int lanzar() {
        Random aleatorio;
        aleatorio = new Random();
        
        valor = aleatorio.nextInt(caras) +1;
        return valor;
    }
    
}