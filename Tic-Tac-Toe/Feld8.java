import greenfoot.*;

/**
 * Write a description of class Feld8 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Feld8 extends Felder
{
    /**
     * Act - do whatever the Feld8 wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
  
    public Feld8()
    {
        
    }

    public void act() 
    {
        
        MouseInfo info = Greenfoot.getMouseInfo();
   
        if(info != null)
        {
            if(((info.getX()) == 1 && ((info.getY()) == 0)) && ((info.getButton()) == 1))
            {
                setImage("images/Kreuz.png");
                x8 = true;

            } 
            else
            {
                if(((info.getX()) == 1 && ((info.getY()) == 0)) && ((info.getButton()) == 3))
                {
                    setImage("images/Kreis.png");
                    o8 = true;

                }
            }
            
    }
}
}