import greenfoot.*;

/**
 * Write a description of class Feld3 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Feld3 extends Felder
{

   
    public Feld3()
    {
        
    }

    public void act() 
    {
        
        MouseInfo info = Greenfoot.getMouseInfo();
  
        if(info != null)
        {
            if(((info.getX()) == 2 && ((info).getY() == 2)) && ((info.getButton()) == 1))
            {
                setImage("images/Kreuz.png");
                x3 = true;
              
            } 
            else
            {
                if(((info.getX()) == 2 && ((info.getY()) == 2)) && ((info.getButton()) == 3))
                {
                    setImage("images/Kreis.png");  
                    o3 = true;
                 
                }
            }
        }  
    
}
}
