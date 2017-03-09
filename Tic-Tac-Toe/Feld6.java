import greenfoot.*;

/**
 * Write a description of class Feld6 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Feld6 extends Felder
{
    /**
     * Act - do whatever the Feld6 wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */

    public Feld6()
    {

    }

    public void act() 
    {

        MouseInfo info = Greenfoot.getMouseInfo();

        if(info != null)
        {
            if(((info.getX()) == 2 && ((info.getY()) == 1)) && ((info.getButton()) == 1))
            {
                setImage("images/Kreuz.png");
                x6 = true;

            }
            else
            {
                if(((info.getX()) == 2 && ((info.getY()) == 1)) && ((info.getButton()) == 3))
                {
                    setImage("images/Kreis.png");
                    o6 = true;

                }
            }
        }    
    }

}
