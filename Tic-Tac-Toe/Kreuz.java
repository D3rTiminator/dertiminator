import greenfoot.*;

/**
 * Write a description of class Kreuz here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Kreuz extends Actor
{
    private String bezeichnung;
   
    public Kreuz()
    {
        bezeichnung = "Kreuz";
        setRotation(0);
    }
    public void datenAusgeben()
    {
        int x = getX();
        
        int y = getY();
        System.out.println(x + "->" + y + "->" );
    }
}
