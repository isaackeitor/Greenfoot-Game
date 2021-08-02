import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Reinicio here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Reinicio extends Actor
{
    private int contador = 0;
    public void act()
    {
        contador++;
        if(contador<20)
        {}
        else if(Greenfoot.isKeyDown("up")||Greenfoot.isKeyDown("down")||Greenfoot.isKeyDown("space")||Greenfoot.mouseClicked(null))
        {
            Greenfoot.setWorld(new MyWorld());
        }
    }
    public Reinicio()
    {
        setLocation(300, 200);
    }
    protected void addedToWorld(World world)
    {
        setLocation(300, 200);
        if(Puntaje.puntajeActual>Puntaje.puntajeAlto)
        {
            Puntaje.puntajeAlto = Puntaje.puntajeActual;
        }
    }
}
