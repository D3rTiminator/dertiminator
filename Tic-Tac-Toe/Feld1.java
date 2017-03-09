import greenfoot.*;

/*
 * Write a description of class Hindernis here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Feld1 extends Felder
{

    /*
     * Act - do whatever the Hindernis wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */

    public Feld1()
    {

    }

    public void act() 
    {

        MouseInfo info = Greenfoot.getMouseInfo();

        if(info != null)
        {
            if(((info.getX()) == 0 && ((info.getY()) == 2)) && ((info.getButton()) == 1))
            {
                setImage("images/Kreuz.png"); 
                x1 = true;

            }    
            else
            {
                if(((info.getX()) == 0 && ((info.getY()) == 2)) && ((info.getButton()) == 3))
                {
                    setImage("images/Kreis.png");
                    o1 = true;

                }

            }

        }
    }
}
