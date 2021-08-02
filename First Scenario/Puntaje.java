import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
public class Puntaje extends Actor
{
    public int puntaje = 0;
    static public int puntajeActual = 0;
    private int puntajeAnterior;
    static public int puntajeAlto = 0;
    public void act()
    {
       if(Messi.vivo)
        {
            puntaje++;
            puntajeActual = puntaje;
            if(puntajeActual<0)
            {
                puntajeActual = 0;
                setImage(new GreenfootImage("Mejor record: " +puntajeAlto + "     "+ puntajeActual, 24, Color.WHITE, Color.ORANGE));
            }
            puntajeActual = puntajeActual/5;
            if(puntajeAnterior!=puntajeActual)
            {
                print(puntajeActual+"");
                setImage(new GreenfootImage("Mejor record: " +puntajeAlto + "     "+ puntajeActual, 24, Color.WHITE, Color.ORANGE));
            }
            puntajeAnterior = puntajeActual;
        }
    }
    public void print(String pText)
    {
        clear();
        getImage().drawImage(new GreenfootImage(pText, 20, Color.BLACK, new Color(1, 1, 1, 1)),10,10);
    }
    public void clear()
    {
        getImage().clear();
        setImage("images/puntaje.png");
    }
    protected void addedToWorld(World world)
    {
        setLocation(475, 30);
        setImage("images/puntaje.png");
        setImage(new GreenfootImage("Mejor record: " +puntajeAlto + "     "+ "0", 24, Color.WHITE, Color.ORANGE));
    }
}
