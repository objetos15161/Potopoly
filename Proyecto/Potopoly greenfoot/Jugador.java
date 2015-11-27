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
    private int dinero;
    private boolean enCarcel;
    private boolean tieneCarta;
    private Torre torre;
    Tablero thisTablero;
    
    Cromo[] cromos;
    
    /**
     * Constructor de Jugador
     * 
     * @imagen Selecciona la imagen del jugador
     * @t Torre del jugador
     * 
     */
    public Jugador(int imagen, Torre t)
    {
        int i;
        GreenfootImage sprite;
        casillaAct = 0;
        numCromos = 0;
        dinero = 500;
        tieneCarta = false;
        enCarcel = false;
        cromos = new Cromo[9];
        torre = t;
        if(imagen == 1) {
            sprite = new GreenfootImage("Sprite1.png");
            saltoX = -13;
            saltoY = -13;
        }
        else if(imagen == 2) {
            sprite = new GreenfootImage("Sprite2.png");
            saltoX = 13;
            saltoY = -13;
        }
        else if(imagen == 3) {
            sprite = new GreenfootImage("Sprite3.png");
            saltoX = -13;
            saltoY = 13;
        }
        else  {
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
    
    protected void addedToWorld(World world) {
        thisTablero = (Tablero) world;
    }
    
    /**
     * Avanza al jugador en una casilla
     */
    public void moveOnce() {
        casillaAct = casillaAct + 1;
        if(casillaAct == 11) {
            setRotation(270);
        }
        if(casillaAct == 21) {
            setRotation(0);
        }
        if(casillaAct == 31) {
            setRotation(90);
        }
        if(casillaAct == 40) {
            casillaAct = 0;
            dinero += 200;
            thisTablero.actConts();
        }
        if(casillaAct == 1) {
            setRotation(180);
        }
        move(Math.abs(getX() - (thisTablero.dameX(casillaAct) + saltoX)) + Math.abs(getY() - (thisTablero.dameY(casillaAct) + saltoY)));
    }
    
    /** Regresa la casilla en la que se encuentra el jugador
     * 
     * @return El numero de la casilla
     * 
     */
    public int dameCasilla()
    {
        return casillaAct;
    }
    
    /**
     * Regresa el monto de dinero que posee el jugador
     * 
     * @return La cantidad de dinero
     * 
     */
    public int dameDinero()
    {
        return dinero;
    }
    
    /**
     * Asigna un valor a la casilla actual
     * 
     * @cas El valor de casilla a tomar
     * 
     */
    public void tomaCasilla(int cas)
    {
        casillaAct = cas;
    }
    
    /**
     * Aumenta (o disminuye) el dinero del jugador
     * 
     * @cantidad La cantidad a incrementar o decrementar
     * 
     */
    public void deltaDinero(int cantidad)
    {
        dinero += cantidad;
    }
    
    /**
     * Asigna un valor booleano al estado tieneCarta
     * 
     * @valor El valor logico que tomara
     * 
     */
    public void tomaCarta(boolean valor)
    {
        tieneCarta = valor;
    }
    
    /**
     * Asigna una cantidad como el monto de dinero del jugador
     * 
     * @n La cantidad de dinero
     * 
     */
    public void tomaDinero(int n)
    {
        dinero = n;
    }
    
    /**
     * Simula haber pagado una cantidad de dinero a otro jugador
     * 
     * @jug Jugador al que se le pagara
     * @cantidad La cantidad a pagar
     * 
     */
    public void paga(Jugador jug, int cantidad)
    {
        jug.deltaDinero(cantidad);
        dinero=(dinero>=cantidad?dinero-cantidad:0);
    }
    
    /**
     * Simula el cobro de una cantidad a otro jugador
     * 
     * @jug Jugador al que se le cobrara
     * @cantidad La cantidad a ser cobrada
     * 
     */
    public void cobra(Jugador jug, int cantidad)
    {
        dinero+=cantidad;
        jug.deltaDinero(jug.dameDinero()>=cantidad?(cantidad*-1):jug.dameDinero());
    }
    
    /**
     * Regresa el numero de cromos del jugador
     * 
     * @return El numero de cromos
     * 
     */
    public int dameCromos()
    {
        return numCromos;
    }
    
    /**
     * Regresa la torre correspondiente al jugador
     * 
     * @return La torre del jugador
     * 
     */
    public Torre dameTorre()
    {
        return torre;
    }
    
    public Cromo dameCromo(int pos)
    {
        return cromos[pos];
    }
    
    public void tomaCromos(int cant)
    {
        numCromos += cant;
    }
    
    public int dameSX()
    {
        return saltoX;
    }
    
    public int dameSY()
    {
        return saltoY;
    }
    
    public void cambiaCarcel(boolean n)
    {
        enCarcel = n;
    }
    
    public boolean daCarcel()
    {
        return enCarcel;
    }
    
    public boolean dameCarta()
    {
        return tieneCarta;
    }
}
