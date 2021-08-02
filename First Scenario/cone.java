import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Esta clase permite que aparezcan conos los cuales son obstáculos mientras Messi siga vivo.
 * 
 * @author (Josué Morales 21116) 
 * @version (22072021)
 */
public class cone extends Actor
{
    private boolean inicio = true;
    private boolean pelota = false;
    private boolean pelotaAlta = true;
    private int ubicacionPelota = 300;
    private int contador = 0;
    public void act()
    {
        if(Messi.vivo)
        {
            contador++;
            if(inicio)
            {
                inicio = false;
                setLocation(599, 300);
                if(Greenfoot.getRandomNumber(7)==0)
                {
                    if(Greenfoot.getRandomNumber(3)==0)
                    {
                        setLocation(599,270);
                        ubicacionPelota = 270;
                    }
                    else if(Greenfoot.getRandomNumber(2)==0)
                    {
                        setLocation(599, 240);
                        ubicacionPelota = 240;
                    }
                    else
                    {
                        setLocation(599, 287);
                        ubicacionPelota = 287;
                    }
                    setImage("images/ball.png");
                    pelota=true;
                }
                else if(Greenfoot.getRandomNumber(5)==0)
                {
                    setImage("images/cones.png");
                }
                else if(Greenfoot.getRandomNumber(4)==0)
                {
                    setImage("images/cones.png");
                    setLocation(599, 294);
                }
                else if(Greenfoot.getRandomNumber(2)==0)
                {
                    setImage("images/cones.png");
                }
                else if(Greenfoot.getRandomNumber(1)==0)
                {
                    setImage("images/cones.png");
                }
                else
                {
                    setImage("images/cones.png");
                }
            }
            move(-6-MyWorld.dificultad);
            if(pelota)
            {
                if(contador>=3)
                {
                    contador=0;
                    if(pelotaAlta)
                    {
                        pelotaAlta=false;
                        setImage("images/ball.png");
                        setLocation(getX(), ubicacionPelota+7);
                    }
                    else
                    {
                        pelotaAlta=true;
                        setImage("images/ball.png");
                        setLocation(getX(), ubicacionPelota);
                    }
                }
            }
            if(isAtEdge())
            {
                getWorld().removeObject(this);
            }
        }
        else
        {
            getWorld().addObject(new Reinicio(), 0,0);
        }
    }
}
