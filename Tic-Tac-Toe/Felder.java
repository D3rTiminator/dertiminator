import greenfoot.*;

/**
 * Write a description of class Felder here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Felder extends Actor
{
    /**
     * Act - do whatever the Felder wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
   public boolean x1;
    public boolean x2;
    public boolean x3;
    public boolean x4;
    public boolean x5;
    public boolean x6;
    public boolean x7;
    public boolean x8;
    public boolean x9;
    public boolean o1;
    public boolean o2;
    public boolean o3;
    public boolean o4;
    public boolean o5;
    public boolean o6;
    public boolean o7;
    public boolean o8;
    public boolean o9;
    
   
   
    public void act() 
    {
        if((o7 == true && o4 ==true && o1 == true) || (o8 == true && o5 ==true && o2 == true) || (o9 == true && o6 ==true && o3 == true) || (o7 == true && o8 ==true && o9 == true) || (o4 == true && o5 ==true && o6 == true) || (o1 == true && o2 ==true && o3 == true) || (o1 == true && o5 ==true && o9 == true) || (o7 == true && o5 ==true && o3 == true))
        {
            setImage("images/O(gewinnt)");
        }
        else 

        if((x7 == true && x4 ==true && x1 == true) || (x8 == true && x5 ==true && x2 == true) || (x9 == true && x6 ==true && x3 == true) || (x7 == true && x8 ==true && x9 == true) || (x4 == true && x5 ==true && x6 == true) || (x1 == true && x2 ==true && x3 == true) || (x1 == true && x5 ==true && x9 == true) || (x7 == true && x5 ==true && x3 == true))
        {
            setImage("images/X(gewinnt)");
        }
    }
    
    public Felder()
    {

    }
}
