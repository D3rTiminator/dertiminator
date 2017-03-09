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

    
    
    public TicTacToeWelt()
    {    
        super(3, 3, 101);
        setBackground("images/Tic.png");
        
        platteSetzen();
        prepare();
    }
    public void platteSetzen()
    {
            addObject(new Feld7(),0,0);
            addObject(new Feld5(),1,1);
            addObject(new Feld3(),2,2);
            addObject(new Feld4(),0,1);
            addObject(new Feld1(),0,2);
            addObject(new Feld8(),1,0);
            addObject(new Feld2(),1,2);
            addObject(new Feld9(),2,0);
            addObject(new Feld6(),2,1);
            
    }
    
    private void prepare()
    {

    }
    
}
