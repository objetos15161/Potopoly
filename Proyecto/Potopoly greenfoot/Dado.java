import greenfoot.*;

/**
 * Write a description of class Dados here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Dado extends Actor
{
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
