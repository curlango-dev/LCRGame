
/**
 * Write a description of class Jugador here.
 *
 * @author (your name)
 * @version (a version number or a date)
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