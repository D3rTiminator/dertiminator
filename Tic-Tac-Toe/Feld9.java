import greenfoot.*;

/**
 * Write a description of class Feld9 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Feld9 extends Felder
{
    /**
     * Act - do whatever the Feld9 wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */

    public Feld9()
    {

    }

    public void act() 
    {   

        MouseInfo info = Greenfoot.getMouseInfo();

        if(info != null)
        {
            if(((info.getX()) == 2 && ((info.getY()) == 0)) && ((info.getButton()) == 1))
            {
                setImage("images/Kreuz.png");
                x9 = true;
               
            }
            else
            {
                if(((info.getX()) == 2 && ((info.getY()) == 0)) && ((info.getButton()) == 3))
                {
                    setImage("images/Kreis.png");
                    o9 = true;
                   
                }
            }

        }

    }
}
