import greenfoot.*;

/**
 * Write a description of class Jugador1 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Jugador extends Actor
{
    private int saltoX;
    private int saltoY;
    
    private int casillaAct = 0;
    
    Tablero thisTablero;
    
    /**
     * Constructor de Jugador
     */
    public Jugador(int imagen)
    {
        GreenfootImage sprite;
        if(imagen == 1)
        {
            sprite = new GreenfootImage("Sprite1.png");
            saltoX = -13;
            saltoY = -13;
        }
        else if(imagen == 2)
        {
            sprite = new GreenfootImage("Sprite2.png");
            saltoX = 13;
            saltoY = -13;
        }
        else if(imagen == 3)
        {
            sprite = new GreenfootImage("Sprite3.png");
            saltoX = -13;
            saltoY = 13;
        }
        else
        {
            sprite = new GreenfootImage("Sprite4.png");
            saltoX = 13;
            saltoY = 13;
        }
        setImage(sprite);
    }
    
    public void act() 
    {
        // Add your action code here.
    }
    
    protected void addedToWorld(World world)
    {
        thisTablero = (Tablero) world;
    }
    
    /**
     * Avanza al jugador en una casilla
     */
    public void moveOnce()
    {
        casillaAct = casillaAct + 1;
        if(casillaAct == 40)
            casillaAct = 0;
        setLocation(thisTablero.dameX(casillaAct),thisTablero.dameY(casillaAct));
    }
}
