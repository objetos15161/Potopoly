import greenfoot.*;
import java.awt.Font;
import java.awt.Color;

/**
 * Write a description of class Ventana here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Ventana extends Actor
{
    protected int altura = 450;
    protected int anchura = 450;
    
    /**
     * Constructor de la clase Ventana
     */
    public Ventana()
    {
        GreenfootImage imagen = new GreenfootImage(anchura,altura);
        Font miFuente = new Font("Courier",Font.BOLD,20);
        imagen.setFont(miFuente);
        imagen.setColor(Color.white);
        imagen.fill();
        imagen.setColor(Color.black);
        imagen.drawRect(0,0,anchura,altura);
        imagen.drawString("¿Numero de jugadores?",112,40);
        
        setImage(imagen);
    }
}
