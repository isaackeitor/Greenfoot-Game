import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
public class Messi extends Actor
{
    private int contador = 0;
    private int contadorSalto = 0;
    private int contadorMin = 0;
    private boolean enTierra = true;
    private boolean messiParado = true;
    private boolean saltandoPresionando = false;
    private boolean inicio = true;
    private boolean presionado;
    private boolean agachado;
    static public boolean vivo = true;
    private int velocidadSalto;
    public void act()
    {
        if(inicio)
        {
            vivo=true;
            inicio=false;
        }
        if (presionado && (Greenfoot.mouseDragEnded(null) || Greenfoot.mouseClicked(null))){presionado = false;}
        if (!presionado && Greenfoot.mousePressed(null)) {presionado= true;}
        if(vivo||Greenfoot.isKeyDown("a")&&Greenfoot.isKeyDown("s"))
        {
            if(enTierra)
            {
                contador++;
                contadorSalto=0;
                contadorMin=0;
                if(contador>=3)
                {
                    contador=0;
                    if(messiParado)
                    {
                        messiParado=false;
                    }
                    else
                    {
                        messiParado=true;
                    }
                }
                if(Greenfoot.isKeyDown("down"))
                {
                    setLocation(120,308);
                    agachado=true;
                    if(messiParado)
                    {
                        setImage("images/Messiacostado.png");
                    }
                    else
                    {
                        setImage("images/Messiacostado.png");
                    }
                }
                else
                {
                    agachado=false;
                    setLocation(120,300);
                    if(jumpButton()&&!saltandoPresionando)
                    {
                        setImage("images/Messirecortado.png");
                        setLocation(120,295);
                        move(5);
                        velocidadSalto = 5;
                        enTierra=false;
                        saltandoPresionando = true;
                    }
                    else
                    {
                        if(!jumpButton())
                        {
                            saltandoPresionando=false;
                        }
                        if(messiParado)
                        {
                            setImage("images/Messirecortado.png");
                        }
                        else
                        {
                            setImage("images/Messirecortado.png");
                        }
                    }
                }
            }
            else
            {
                contadorMin++;
                if((saltandoPresionando&&jumpButton()&&contadorSalto<=12)||contadorMin<8)
                {
                    contadorSalto++;
                    move(6);
                }
                else
                {
                    contadorSalto = 20;
                    velocidadSalto--;
                    move(velocidadSalto);
                    if(getY()>=295)
                    {
                        setLocation(120,300);
                        enTierra=true;
                    }
                }
            }
            if(getOneIntersectingObject(cone.class)!=null&&!Greenfoot.isKeyDown("a"))
            {
                getWorld().addObject(new Reinicio(), 120, 300);
                vivo = false;
            }
            else
            {
                vivo=true;
            }
        }
        else
        {
            getWorld().addObject(new Reinicio(), 0, 0);
        }
        if(!vivo)
        {
            if(agachado)
            {
                setImage("images/Messirecortado.png");
            }
            else
            {
                setImage("images/Messirecortado.png");
            }
        }
    }
    private boolean jumpButton()
    {
        if(Greenfoot.isKeyDown("up")||Greenfoot.isKeyDown("space")||Greenfoot.mousePressed(null))
        {
            return true;
        }
        if(presionado){return true;}
        return false;
    }
    public Messi()
    {
        setImage("images/Messirecortado.png");
        setLocation(74,237);
        setRotation(270);
    }
}
