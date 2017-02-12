import greenfoot.*;
import java.util.List;
import javax.swing.JOptionPane;

/**
 * Write a description of class TicTacToeWelt here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class TicTacToeWelt extends World
{

    /**
     * Constructor for objects of class TicTacToeWelt.
     * 
     */
    public TicTacToeWelt()
    {    
        super(3, 3, 101
        );
        setBackground("images/Tic.png");
        
        platteSetzen();
        prepare();
    }
    public void platteSetzen()
    {
            addObject(new Hindernis(),0,0);
            addObject(new Hindernis(),1,1);
            addObject(new Hindernis(),2,2);
            addObject(new Hindernis(),0,1);
            addObject(new Hindernis(),0,2);
            addObject(new Hindernis(),1,0);
            addObject(new Hindernis(),1,2);
            addObject(new Hindernis(),2,0);
            addObject(new Hindernis(),2,1);
    }
    
    private void prepare()
    {

    }
    
}
