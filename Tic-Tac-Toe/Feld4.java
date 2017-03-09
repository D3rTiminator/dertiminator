import greenfoot.*;

/**
 * Write a description of class Feld here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Feld4 extends Felder
{
    /**
     * Act - do whatever the Feld wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */

    public Feld4()
    {

    }

    



    public void act() 
    {
        MouseInfo info = Greenfoot.getMouseInfo();
        if(info != null)
        {
            if(((info.getX()) == 0 && ((info.getY()) == 1)) && ((info.getButton()) == 1))

            {
                setImage("images/Kreuz.png");
                x4 = true;
            } 
            else

            if(((info.getX()) == 0 && ((info.getY()) == 1)) && ((info.getButton()) == 3))
            {
                setImage("images/Kreis.png");
                o4 = true;
            }
        }
       

       
    }
}
