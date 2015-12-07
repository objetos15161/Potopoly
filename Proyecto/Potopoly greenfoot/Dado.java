import greenfoot.*;

/**
 * Clase para los dados del juego
 * 
 * @author Potopoly team 
 * @version 26-Nov-15
 */
public class Dado extends Actor
{
    /**
     * Cambia la imagen del dado
     * 
     * @param valor El valor del dado
     * 
     */
    public void tomaValor(int valor)
    {
        if(valor == 0)
            setImage("Dado0.png");
        if(valor == 1)
            setImage("Dado1.png");
        if(valor == 2)
            setImage("Dado2.png");
        if(valor == 3)
            setImage("Dado3.png");
        if(valor == 4)
            setImage("Dado4.png");
        if(valor == 5)
            setImage("Dado5.png");
        if(valor == 6)
            setImage("Dado6.png");    
    }
}
