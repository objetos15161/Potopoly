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
        else {
            GreenfootImage imagen = new GreenfootImage("selector.png");
            setImage(imagen);
        }
    }
    
    /**
     * Ventana de gameover
     */
    public Ventana(char c)
    {
        GreenfootImage imagen;
        switch(c) {
            case '1':
                imagen = new GreenfootImage("win1.png");
                break;
            case '2':
                imagen = new GreenfootImage("win2.png");
                break;
            case '3':
                imagen = new GreenfootImage("win3.png");
                break;
            default:
                imagen = new GreenfootImage("win4.png");
                break;
        }
        setImage(imagen);
    }
    
    /**
     * Mueve el selector de lugar
     */
    public void muevete(int est)
    {
        int y;
        switch(est) {
            case 1:
                y = 100;
                break;
            case 2:
                y = 141;
                break;
            case 3:
                y = 182;
                break;
            default:
                y = 223;
                break;
        }
        setLocation(615,y);
    }
}