import greenfoot.*;
import java.lang.Object;
/**
 * Write a description of class Hindernis here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Hindernis extends Actor
{

     
    /**
     * Act - do whatever the Hindernis wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
                 
            if(Greenfoot.getX() == 1 && MouseInfo.getY() == 1 && MouseInfo.getClickCount() == 1 )
            {
                setImage("image/Tic.png");
            
        }
    }   

    public Hindernis()
    {
    }

}
