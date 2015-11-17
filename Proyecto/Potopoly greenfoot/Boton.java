import greenfoot.*;
import java.awt.Color;
import java.awt.Font;

/**
 * Esta clase permite crear botones para seleccion de opciones
 * 
 * @Carlos Gutiérrez
 * @version 13/11/15 01:47 am
 */
public class Boton extends Actor
{
    public Boton(int anchura, int altura, java.lang.String texto)
    {
        GreenfootImage imagen = new GreenfootImage(anchura,altura);
        Font miFuente = new Font("Courier",Font.BOLD,20);
        imagen.setFont(miFuente);
        imagen.setColor(Color.gray);
        imagen.fill();
        imagen.setColor(Color.black);
        imagen.drawRect(0,0,anchura-1,altura-1);
        imagen.drawString(texto, 45, 30);
        setImage(imagen);
    }
}
