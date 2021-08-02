import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
/**
 * Write a description of class MyWorld here.
 * 
 * @author (Josué Morales 21116) 
 * @version (22072021)
 */
public class MyWorld extends World
{
    private int contador = 0;
    private int contadorNube = 0;
    private int contadorDificultad = 0;
    private int velocidadMyWorld = 45;
    private int randomNumero;
    static public int dificultad = 0;
    private boolean startTime = true;
    GreenfootSound backgroundMusic = new GreenfootSound("juego.mp3");
    public void act()
    {
        backgroundMusic.play();
        backgroundMusic.setVolume(25);
        contador++;
        contadorNube++;
        contadorDificultad++;
        if(startTime)
        {
            dificultad=0;
            if(contador>=100)
            {
                contador=0;
                randomNumero=Greenfoot.getRandomNumber(15);
                startTime = false;
                addObject(new cone(), 580, 300);
            }
        }
        else if(contador>=(40+randomNumero)-(int)(1.7*(double)dificultad))
        {
            contador=0;
            randomNumero=Greenfoot.getRandomNumber(15);
            addObject(new cone(), 580, 300);
        }
        if(contadorDificultad>=500)
        {
            dificultad++;
            if(dificultad>7)
            {
                dificultad=7;
            }
            contadorDificultad=0;
        }
        if(contadorNube>=300)
        {
            contadorNube=0;
            addObject(new nube(), 599, 100);
        }
    }
    public MyWorld()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(600, 400, 1); 
        addObject(new Messi(), 120, 300);
        addObject(new Puntaje(), 550, 30);
        addObject(new nube(), 350, 100);
        Greenfoot.setSpeed(velocidadMyWorld);
        setPaintOrder(Reinicio.class, cone.class, MyWorld.class, Messi.class, Puntaje.class, nube.class);
    }
}
