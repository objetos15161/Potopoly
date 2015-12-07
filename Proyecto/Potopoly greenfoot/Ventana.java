import greenfoot.*;
import java.awt.Font;
import java.awt.Color;

/**
 * Clase usada para crear una ventana
 * 
 * @author Potopoly team 
 * @version 26-Nov-15
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
    
    /**
     * Constructor alternativo de la ventana
     * 
     * @param num comparador
     */
    public Ventana(int num)
    {
        if(num == 1) {
            GreenfootImage imagen = new GreenfootImage("ayuda.png");
            setImage(imagen);
        }
        else if(num == 2) {
            GreenfootImage imagen = new GreenfootImage("selector.png");
            setImage(imagen);
        }
        else{
            GreenfootImage imagen = new GreenfootImage("winner.png");
            setImage(imagen);
        }
    }
}
