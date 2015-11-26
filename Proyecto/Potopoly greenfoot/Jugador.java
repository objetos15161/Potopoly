import greenfoot.*;
import java.lang.Math;

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
    private int casillaAct;
    private int numCromos;
    
    Tablero thisTablero;
    
    Cromo[] cromos = new Cromo[9];
    
    /**
     * Constructor de Jugador
     */
    public Jugador(int imagen)
    {
        GreenfootImage sprite;
        casillaAct = 0;
        numCromos = 0;
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
        setRotation(180);
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
        if(casillaAct == 11)
            setRotation(270);
        if(casillaAct == 21)
            setRotation(0);
        if(casillaAct == 31)
            setRotation(90);
        if(casillaAct == 40)
            casillaAct = 0;
        if(casillaAct == 1)
            setRotation(180);
        move(Math.abs(getX()-(thisTablero.dameX(casillaAct)+saltoX))+Math.abs(getY()-(thisTablero.dameY(casillaAct)+saltoY)));
    }
}
