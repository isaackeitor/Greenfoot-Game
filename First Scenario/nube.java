import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class nube here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class nube extends Actor
{
    /**
     * Act - do whatever the nube wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act()
    {
        if(Messi.vivo)
        {
            move(-1);
            if(isAtEdge())
            {
                getWorld().removeObject(this);
            }
        }
    }
    public nube()
    {
        setLocation(599, 100);
        setImage("images/nube.png");
    }
}
