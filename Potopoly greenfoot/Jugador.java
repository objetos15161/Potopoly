import greenfoot.*;
import java.lang.Math;

/**
 * Clase para crear a los jugadores
 * 
 * @author Potopoly team 
 * @version 26-Nov-15
 */
public class Jugador extends Actor
{
    private int saltoX;  /** Cambio de posicion en X **/
    private int saltoY;  /** Cambio de posicion en X **/
    private int casillaAct;  /** Numero de casilla en la que se encuentra el jugador **/
    private int numCromos;  /** Numero de cromos que posee el jugador **/
    private int dinero;  /** Cantidad de dinero que tiene el jugador **/
    private boolean enCarcel;  /** Bandera que indica si el jugador se encuentra encarcelado **/
    private boolean tieneCarta; /** Bandera que indica si el jugador tiene una carta para salir de la carcel **/
    private Torre torre;  /** La torre del jugador **/
    Tablero thisTablero;  /** El tablero de juego **/
    
    Cromo[] cromos;  /** Los cromos que posee el jugador **/
    
    /**
     * Constructor de Jugador
     * 
     * @param imagen Selecciona la imagen del jugador
     * @param t Torre del jugador
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
     * @param cas El valor de casilla a tomar
     * 
     */
    public void tomaCasilla(int cas)
    {
        casillaAct = cas;
    }
    
    /**
     * Aumenta (o disminuye) el dinero del jugador
     * 
     * @param cantidad La cantidad a incrementar o decrementar
     * 
     */
    public void deltaDinero(int cantidad)
    {
        dinero += cantidad;
    }
    
    /**
     * Asigna un valor booleano al estado tieneCarta
     * 
     * @param valor El valor logico que tomara
     * 
     */
    public void tomaCarta(boolean valor)
    {
        tieneCarta = valor;
    }
    
    /**
     * Asigna una cantidad como el monto de dinero del jugador
     * 
     * @param n La cantidad de dinero
     * 
     */
    public void tomaDinero(int n)
    {
        dinero = n;
    }
    
    /**
     * Simula haber pagado una cantidad de dinero a otro jugador
     * 
     * @param jug Jugador al que se le pagara
     * @param cantidad La cantidad a pagar
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
     * @param jug Jugador al que se le cobrara
     * @param cantidad La cantidad a ser cobrada
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
    
    /**
     * Regresa un cromo del jugador
     * 
     * @param pos El numero de cromo solicitado
     * @return El cromo en si
     * 
     */
    public Cromo dameCromo(int pos)
    {
        return cromos[pos];
    }
    
    /**
     * Aumenta la cantidad de cromos que posee el jugador en una cierta cantidad
     * 
     * @param cant La cantidad de cromos a añadir
     * 
     */
    public void tomaCromos(int cant)
    {
        numCromos += cant;
    }
    
    /**
     * Da el cambio en X
     * 
     * @return El cambio en X
     */
    public int dameSX()
    {
        return saltoX;
    }
    
    /**
     * Da el cambio en Y
     * 
     * @return El cambio en Y
     */
    public int dameSY()
    {
        return saltoY;
    }
    
    /**
     * Asigna un valor a la bandera enCarcel
     * 
     * @param n El nuevo valor de la bandera
     * 
     */
    public void cambiaCarcel(boolean n)
    {
        enCarcel = n;
    }
    
    /**
     * Da el valor de la bandera enCarcel
     * 
     * @return El valor de la bandera enCarcel
     * 
     */
    public boolean daCarcel()
    {
        return enCarcel;
    }
    
    /**
     * Da el valor de la bandera tieneCarta
     * 
     * @return El valor de la bandera tieneCarta
     * 
     */
    public boolean dameCarta()
    {
        return tieneCarta;
    }
}
