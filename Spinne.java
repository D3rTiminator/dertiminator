import greenfoot.*;  // (World, Actor, GreenfootImage, and Greenfoot)
import java.util.List;
import javax.swing.JOptionPane;
//import java.io.*;
/**
 * Klasse für Objekte vom Typ Spinne.
 * @author P. Schlez
 * @version 17.02.2015
 */
public class Spinne extends Actor
{

    private int aktionenProSekunde;
    private int fliegen;
    private boolean nachrichten;
    private boolean geklatscht;
    private boolean fehler;
    
    /**
     * Erzeugt ein Spinne-Objekt ohne Fliegen mit 4 Aktionen pro Sekunde.
     */
    public Spinne()
    {
        aktionenProSekunde = 1;
        fliegen = 0;
        nachrichten = true;
        geklatscht = false;
        fehler = false;
    }
    
    /**
     * Erzeugt ein Spinne-Objekt mit einer gegebenen Anzahl Fliegen und 4 Aktionen pro Sekunde.
     * @param fliegen die Anzahl der gefressenen Fliegen
     */
    public Spinne(int fliegen)
    {
        aktionenProSekunde = 200;
        if(fliegen < 0) {
            fliegen = 0;
        }
        this.fliegen = fliegen;
        nachrichten = true;
        geklatscht = false;
        fehler = false;
    }
    
    /**
     * Die Spinne dreht sich um 90° entgegen dem Uhrzeigersinn. Wirkungslos bei geklatschter Spinne.
     */
    public void linksDrehen()
    {
        if(!geklatscht && !fehler)
        {
            pause();
            setRotation( (getRotation()+270) % 360);
            pause();
        }
    }
    
    /**
     * Die Spinne dreht sich um 90° im Uhrzeigersinn. Wirkungslos bei geklatschter Spinne.
     */
    public void rechtsDrehen()
    {
        if(!geklatscht && !fehler)
        {
            pause();
            setRotation((getRotation()+90) % 360);
            pause();
        }
    }
    
    /**
     * Die Spinne geht einen Schritt in Blickrichtung, wenn sie nicht vor einem Hindernis steht. Wirkungslos bei geklatschter Spinne.
     * Läuft sie dabei auf eine Klatsche, wird sie geklatscht.
     */
    public void schritt()
    {
        if(!geklatscht && !fehler)
        {
            pause();
            boolean kv = klatscheVorn();
            int richtung = getRotation();
            int x = 0;
            int y = 0;
            switch(richtung)
            {
                case 0:
                    x = getX() + 1;
                    y = getY();
                    break;
                case 90:
                    x = getX();
                    y = getY()+1;
                    break;
                case 180:
                    x = getX()-1;
                    y = getY();
                    break;
                case 270:
                    x = getX();
                    y = getY()-1;
                    break;
            }
            if(!hindernisVorn())
            {
                setLocation(x,y);
                if(kv)
                {
                    geklatscht = true;
                    setImage("images/thekla_geklatscht.png");
                    warten(500);
                    if(nachrichten)
                    {
                        JOptionPane.showMessageDialog(null,"Die Spinne wurde geklatscht.","Fehler",JOptionPane.ERROR_MESSAGE);
                    }
                }
                pause();
            }
            else
            {
                if(nachrichten)
                {
                    fehler = true;
                    JOptionPane.showMessageDialog(null,"Vor der Spinne liegt ein Hindernis.","Fehler",JOptionPane.ERROR_MESSAGE);
                }
            }
        }
    }
    
    /**
     * Die Spinne frisst eine Fliege, falls mindestens eine auf dem Platz liegt. Wirkungslos bei geklatschter Spinne.
     */
    public void fliegeFressen()
    {
        if(!geklatscht && !fehler)
        {
            pause();
            Actor fliege = getOneObjectAtOffset(0,0,Fliege.class);
            if(fliege != null)
            {
                fliegen++;
                getWorld().removeObject(fliege);
                pause();
            }
            else
            {
                if(nachrichten)
                {
                    fehler = true;
                    JOptionPane.showMessageDialog(null,"Auf dem Platz liegt keine Fliege.","Fehler",JOptionPane.ERROR_MESSAGE);
                }
            }
        }
    }
    
    /**
     * Die Spinne wird mit anzahl zusätzlichen Fliegen gefüttert. Wirkungslos bei geklatschter Spinne.
     */
    public void fliegenFuettern(int anzahl)
    {
        if(!geklatscht && !fehler)
        {
            fliegen = fliegen + anzahl;
        }
    }
    
    /**
     * Die Spinne spuckt eine Fliege aus, falls sie mindestens eine gefressen hat. Wirkungslos bei geklatschter Spinne.
     */
    public void fliegeAusspucken()
    {
        if(!geklatscht && !fehler) {
            pause();
            if(fliegen>0)
            {
                getWorld().addObject(new Fliege(),getX(),getY());
                setLocation(getX(),getY());
                fliegen--;
                pause();
            }
            else
            {
                if(nachrichten) 
                {
                    fehler = true;
                    JOptionPane.showMessageDialog(null,"Die Spinne hat keine Fliege gefressen.","Fehler",JOptionPane.ERROR_MESSAGE);
                }
            }
        }
    }
        
    /**
     * Prüft, ob auf dem Platz vor der Spinne eine Klatsche lauert. 
     * @return true: Klatsche; false: keine Klatsche; bei geklatschter Spinne: immer false
     */
    public boolean klatscheVorn()
    {
        if(!geklatscht && !fehler)
        {
            int dx = 0;
            int dy = 0;
            int richtung = getRotation();
            switch(richtung)
            {
                case 0:
                    dx = 1; break;
                case 90:
                    dy = 1; break;
                case 180:
                    dx = -1; break;
                case 270:
                    dy = -1; break;
            }
            Actor klatsche = getOneObjectAtOffset(dx,dy,Klatsche.class);
            return klatsche != null;
        }
        else
        {
            return false;
        }
    }
    
    /**
     * Prüft, ob auf dem Platz vor der Spinne ein Hindernis liegt.
     * @return true: Hindernis; false: kein Hindernis; bei geklatschter Spinne: immer false
     */
    public boolean hindernisVorn()
    {
        if(!geklatscht && !fehler)
        {
            int dx = 0;
            int dy = 0;
            int richtung = getRotation();
            switch(richtung)
            {
                case 0:
                    dx = 1; break;
                case 90:
                    dy = 1; break;
                case 180:
                    dx = -1; break;
                case 270:
                    dy = -1; break;
            }
            Actor klatsche = getOneObjectAtOffset(dx,dy,Hindernis.class);
            return klatsche != null;
        }
        else
        {
            return false;
        }
    }
    
    /**
     * Prft, ob rechts neben der Spinne ein Hindernis liegt.
     * @return true: Hindernis; false: kein Hindernis; bei geklatschter Spinne: immer false
     */
    public boolean hindernisRechts()
    {
        if(!geklatscht && !fehler)
        {
            int dx = 0;
            int dy = 0;
            int richtung = getRotation();
            switch(richtung)
            {
                case 0:
                    dy = 1; break;
                case 90:
                    dx = -1; break;
                case 180:
                    dy = -1; break;
                case 270:
                    dx = 1; break;
            }
            Actor klatsche = getOneObjectAtOffset(dx,dy,Hindernis.class);
            return klatsche != null;
        }
        else
        {
            return false;
        }
    }
    
    /**
     * Prüft, ob links neben der Spinne ein Hindernis liegt.
     * @return true: Hindernis; false: kein Hindernis; bei geklatschter Spinne: immer false
     */
    public boolean hindernisLinks()
    {
        if(!geklatscht && !fehler)
        {
            int dx = 0;
            int dy = 0;
            int richtung = getRotation();
            switch(richtung)
            {
                case 0:
                    dy = -1; break;
                case 90:
                    dx = 1; break;
                case 180:
                    dy = 1; break;
                case 270:
                    dx = -1; break;
            }
            Actor klatsche = getOneObjectAtOffset(dx,dy,Hindernis.class);
            return klatsche != null;
        }
        else
        {
            return false;
        }
    }
    
    /**
     * Prüft, ob auf dem Platz der Spinne mindestens eine Fliege liegt.
     * @return true: Fliege(n) am Platz, false: keine Fliegen am Platz; bei geklatschter Fliege: immer false
     */
    public boolean fliegeAmPlatz()
    {
        if(!geklatscht && !fehler)
        {
            Actor fliege = getOneObjectAtOffset(0,0,Fliege.class);
            return fliege != null;
        }
        else
        {
            return false;
        }
    }
    
    /**
     * Liefert die Anzahl der Fliegen auf dem Platz der Spinne.
     * @return die Anzahl der Fliegen auf Platz der Spinne; bei geklatschter Spinne: immer 0
     */
    public int fliegenAmPlatz()
    {
        if(!geklatscht && !fehler)
        {
            List fliegen = getObjectsAtOffset(0,0,Fliege.class);
            return fliegen.size();
        }
        else
        {
            return 0;
        }
    }
    
    /**
     * Prüft, ob die Spinne mindestens eine Fliege gefressen hat.
     * @return true: Fliege(n) gefressen; false: keine Fliege gefressen; bei geklatschter Spinne: immer false
     */
    public boolean fliegeGefressen()
    {
        if(!geklatscht && !fehler)
        {
            return fliegen > 0;
        }
        else
        {
            return false;
        }
    }
    
    /**
     * Liefert die Anzahl der Fliegen, die die Spinne gefressen hat.
     * @return die Anzahl der Fliegen; die die Spinne gefressen hat; bei geklatschter Spinne: immer 0
     */
    public int fliegenGefressen()
    {
        if(!geklatscht && !fehler)
        {
            return fliegen;
        }
        else
        {
            return 0;
        }
    }

    /**
     * Schaltet die Anzeige von Fehlern und Warnungen ein.
     */
    public void nachrichtenZeigen()
    {
        if(!geklatscht && !fehler)
        {
            nachrichten = true;
        }
    }
    
    /**
     * Schaltet die Anzeige von Fehlern und Warnungen aus.
     */
    public void nachrichtenVerbergen()
    {
        if(!geklatscht && !fehler)
        {
            nachrichten = false;
        }
    }
    
    /**
     * Legt das Tempo der Programmausführung fest.
     * @param die Anzahl der Aktionen pro Sekunde
     */
    public void tempo(int aktionenProSekunde) 
    {
        this.aktionenProSekunde = aktionenProSekunde;
    }
    
    /**
     * Die Spinne unterbricht die Programmausführung für eine gegebene Zeit.
     * @param die Länge der Unterbrechung in Millisekunden
     */
    public void warten(int milliSekunden)
    {
        try {
            Thread.sleep(milliSekunden);
            getWorld().repaint();
        }
        catch(InterruptedException ie) { }
    }
    
    private void pause() {
        try {
            Thread.sleep(100/aktionenProSekunde);
            getWorld().repaint();
        }
        catch(InterruptedException ie) { }
    }
    
   /* public void weltSpeichern(String name) 
        throws FileNotFoundException,IOException {
            FileOutputStream fos = new FileOutputStream(name);
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(getWorld());
    }*/
    
   /* public void weltLesen(String name) 
        throws FileNotFoundException,IOException,ClassNotFoundException {
            FileInputStream fos = new FileInputStream(name);
            ObjectInputStream oos = new ObjectInputStream(fos);
            SpinnenWelt temp = (SpinnenWelt)oos.readObject();
            super.setWorld(null);
    }*/
    
    public void act() {
    }
    
}