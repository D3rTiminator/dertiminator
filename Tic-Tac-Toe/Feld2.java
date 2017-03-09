import greenfoot.*;

/**
 * Write a description of class Feld2 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Feld2 extends Felder
{
    /**
     * Act - do whatever the Feld2 wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */

    public Feld2()
    {

    }

    public void act() 
    {

        MouseInfo info = Greenfoot.getMouseInfo();

        if(info != null)
        {
            if(((info.getX()) == 1 && ((info.getY()) == 2)) && ((info.getButton()) == 1))
            {
                setImage("images/Kreuz.png");
                x2 = true;

            } 
            else
            {
                if(((info.getX()) == 1 && ((info.getY()) == 2)) && ((info.getButton()) == 3))
                {
                    setImage("images/Kreis.png");
                    o2 = true;

                }
            }
        }    

    }
}
