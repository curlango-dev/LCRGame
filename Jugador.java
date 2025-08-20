
/**
 * Jugador de Left-Center-Right.
 *
 * @author (Cecilia Curlango Rosas)
 * @version (1.0 agosto 2025)
 */
public class Jugador
{
    private int fichas;
    private String nombre;
    
    public Jugador() {
        fichas = 3;
    }
    
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    
    public String getNombre() {
        return nombre;
    }
    
    public int getFichas() {
        return fichas;
    }
}