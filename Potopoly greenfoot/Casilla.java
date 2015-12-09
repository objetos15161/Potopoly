/**
 * Esta clase se usa para representar las casillas del tablero
 * 
 * @author Equipo potopoly 
 * @version 26-Nov-15
 * 
 * @x Coordenada X de la casilla
 * @y Coordenada Y de la casilla
 * @costo Es el costo monetario de la casilla
 * @puntos El el valor en puntos de la casilla
 * @duenio Es el duenio de la casilla
 */
public class Casilla  
{
    private int x;
    private int y;
    private int costo;
    private int puntos;
    private int tipo;
    private Jugador duenio;
    
    /**
     * Constructor de la clase Casilla
     * 
     * @param c Costo de la casilla
     * @param p Puntos que otorga la casilla
     * @param cx Coordenada en X de la casilla
     * @param t Tipo de cromo
     * @param cy Coordenada en Y de la casilla
     * 
     */
    public Casilla(int c, int p, int t, int cx, int cy)
    {
        duenio = null;
        costo = c;
        puntos = p;
        tipo = t;
        x = cx;
        y = cy;
    }
    
    /**
     * Regresa el valor de la coordenada en X de la casilla
     * 
     * @return El valor de la coordenada
     * 
     */
    public int dameX()
    {
        return x;
    }
    
    /**
     * Regresa el valor de la coordenada en Y de la casilla
     * 
     * @return El valor de la coordenada
     * 
     */
    public int dameY()
    {
        return y;
    }
    
    /**
     * Regresa el costo de la casilla
     * 
     * @return El valor monetario de la casilla
     * 
     */
    public int dameCosto()
    {
        return costo;
    }
    
    /**
     * Regresa el puntuaje de la casilla
     * 
     * @return El valor en puntos de la casilla
     * 
     */
    public int damePuntos()
    {
        return puntos;
    }
    
    /**
     * Regresa el jugador dueño de la casilla
     * 
     * @return El jugador
     * 
     */
    public Jugador dameDuenio()
    {
        return duenio;
    }
    
    /**
     * Asigna un dueño a la casilla
     * 
     * @param D Es el jugador que poseera la casilla
     * 
     */
    public void tomaDuenio(Jugador D)
    {
        duenio = D;
    }
    
    /**
     * Regresa el tipo de cromo
     * 
     * @return El tipo
     * 
     */
    public int dameTipo()
    {
        return tipo;
    }
}
