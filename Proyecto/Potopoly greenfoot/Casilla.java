/**
 * Write a description of class Propiedad here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Casilla  
{
    private int x;
    private int y;
    private int costo;
    private int puntos;
    private Jugador duenio;

    public Casilla(int c, int p, int cx, int cy)
    {
        duenio = null;
        costo = c;
        puntos = p;
        x = cx;
        y = cy;
    }
    
    public int dameX()
    {
        return x;
    }
    
    public int dameY()
    {
        return y;
    }
    
    public int dameCosto()
    {
        return costo;
    }
    
    public int damePuntos()
    {
        return puntos;
    }
    
    public Jugador dameDuenio()
    {
        return duenio;
    }
    
    public void tomaDuenio(Jugador D)
    {
        duenio = D;
    }
}
