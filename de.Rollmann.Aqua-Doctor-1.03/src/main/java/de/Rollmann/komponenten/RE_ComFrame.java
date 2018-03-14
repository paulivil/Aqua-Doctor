package de.Rollmann.komponenten;

import Aqua_Doctor.GUI.KonfPanel;
import Aqua_Doctor.kommunikation.DynThread;
import Aqua_Doctor.ressource.Sprache;
import de.Rollmann.kommunikation.ComTabellen.ComTabelle;
import de.Rollmann.kommunikation.Daten.DatenKlasse;
import de.Rollmann.kommunikation.REComSeriell;
import de.Rollmann.kommunikation.Runnable.MasterRunnable;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.lang.reflect.InvocationTargetException;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.Timer;

public abstract class RE_ComFrame
  extends JFrame
  implements ActionListener, WindowListener
{
  /**
	 * 
	 */
	private static final long serialVersionUID = 3995864515138939668L;
public String geraet;
  protected Timer t;
  private DatenKlasse d;
  public ComTabelle tabcom;
  private String classTabelle;
  protected REComSeriell comSer;
  protected Cursor cur = new Cursor(3);
  public Sprache spr;
  public KonfPanel konfPanel;
  
  public JPanel pnlMain = new JPanel();
  private JPanel pnlButton = new JPanel();
  private JButton butVerbindung;
  private JButton butLaden;
  private JButton butSpeichern;
  private JButton butBeenden = new JButton();
  protected JLabel lblVerbindung = new JLabel();
  protected DynThread dyn;
  public boolean comUnterbrochen = false;
  
  
  public RE_ComFrame(String tabelle, DatenKlasse c)
  {
    classTabelle = tabelle;
    
    d = c;
  }
  
  public void setzeButtonZuordnung(JButton verbindung, JButton laden, JButton speichern)
  {
    butVerbindung = verbindung;
    butLaden = laden;
    butSpeichern = speichern;
  }
  
  public void starteKommunikation()
  {

	  
    comUnterbrochen = false;
    comSer = new REComSeriell(spr);
    comSer.starteSeriell(this);
  }
  
  public ComTabelle erstelleComTabelle(MasterRunnable master)
  {
	
    try
    {
      Class<?> cl = Class.forName(classTabelle);
      tabcom = 
        ((ComTabelle)cl.getConstructor(new Class[] { MasterRunnable.class }).newInstance(new Object[] {master }));
    }
    catch (SecurityException e1) {} catch (NoSuchMethodException e2){} catch (InvocationTargetException e3){} catch (IllegalArgumentException e4){} catch (IllegalAccessException e5){} catch (InstantiationException e6){} catch (ClassNotFoundException e7){}
    lblVerbindung.setText(spr.VERBINDUNG_OK);
    lblVerbindung.setBackground(Color.GREEN);
    
    return tabcom;
  }
  
  public void erstesLaden()
  {
    setCursor(cur);
    JOptionPane.showMessageDialog(this, 
      spr.VERBINDUNG_OK + ", " + 
      
      spr.HINWEIS_KONFIGURATION_WIRD_VOM_HM_GELADEN);
    try
    {
      d.laden(tabcom);
      ladeEinstellung();
      if (!comUnterbrochen)
      {
        butVerbindung.setActionCommand("5");
        butVerbindung.setText(spr.VERBINDUNG_TRENNEN);
        butLaden.setEnabled(true);
        butSpeichern.setEnabled(true);
      }
    }
    catch (Exception e) {}
    setCursor(null);
  }
  
  public abstract DatenKlasse getDatenKlasse();
  
  public abstract void ladeEinstellung();
  
  public abstract void speicherEinstellung();
  
  public void actionPerformed(ActionEvent e)
  {
    switch (Integer.parseInt(e.getActionCommand()))
    {
    case 1: 
		
			starteKommunikation();
		
      break;
    case 2: 
      setCursor(cur);
      try
      {
        d.laden(tabcom);
      }
      catch (Exception e1) {}
      if (!comUnterbrochen) {
        ladeEinstellung();
      }
      setCursor(null);
      break;
    case 3: 
      setCursor(cur);
      
      speicherEinstellung();
      try
      {
        d.speichern(tabcom);
      }
      catch (Exception e1) {}
      if (!comUnterbrochen) {
        konfPanel.ladeEinstellungen();
      }
      setCursor(null);
      break;
    case 4: 
      stoppeKommunikation(true);
      beenden();
      
      break;
    case 5: 
      stoppeKommunikation(false);
      
      break;
    case 6: 
      try
      {
        t.stop();
        t = null;
        d.laden(tabcom);
        ladeEinstellung();
        if (!comUnterbrochen)
        {
          butVerbindung.setActionCommand("5");
          butVerbindung.setText(spr.VERBINDUNG_TRENNEN);
          butLaden.setEnabled(true);
          butSpeichern.setEnabled(true);
        }
      }
      catch (Exception e1) {}
      setCursor(null);
    }
  }
  
  public void KommunikationUnterbrochen()
  {
    setCursor(cur);
    comUnterbrochen = true;
    Beenden end = new Beenden(this);
  }
  
  public void KommunikationVollUnterbrochen()
  {
    comUnterbrochen = true;
    System.exit(0);
  }
  
  public void stoppeKommunikation(boolean bol)
  {
    if (!bol)
    {
      if (JOptionPane.showConfirmDialog(this, 
        spr.FRAGE_VERBINDUNG_TRENNEN, 
        spr.VERBINDUNG_TRENNEN, 
        0, 
        3) == 0)
      {
        setCursor(cur);
        
        dyn.beenden();
        comSer.stoppeSeriell(this);
        butVerbindung.setActionCommand("1");
        butVerbindung.setText(spr.VERBINDUNG_HERSTELLEN);
        butLaden.setEnabled(false);
        butSpeichern.setEnabled(false);
        
        lblVerbindung.setText(spr.KEINE_VERBINDUNG);
        lblVerbindung.setBackground(Color.RED);
        
        setCursor(null);
      }
    }
    else {
      try
      {
        comSer.stoppeSeriell(this);
        butVerbindung.setActionCommand("1");
        butVerbindung.setText(spr.VERBINDUNG_HERSTELLEN);
        butLaden.setEnabled(false);
        butSpeichern.setEnabled(false);
      }
      catch (Exception e) {}
    }
  }
  
  public void beenden()
  {
    if (JOptionPane.showConfirmDialog(this, 
      spr.FRAGE_SOFWARE_BEENDEN, 
      spr.BEENDEN, 
      0, 
      3) == 0) {
      System.exit(0);
    } else {
      setDefaultCloseOperation(0);
    }
  }
  
  private void jbInit()
    throws Exception
  {
    butVerbindung.setText(spr.VERBINDUNG_HERSTELLEN);
    butLaden.setText(spr.LADEN);
    butSpeichern.setText(spr.SPEICHERN);
    butBeenden.setText(spr.BEENDEN);
    
    butVerbindung.setActionCommand("1");
    butLaden.setActionCommand("2");
    butSpeichern.setActionCommand("3");
    butBeenden.setActionCommand("4");
    
    butVerbindung.addActionListener(this);
    butLaden.addActionListener(this);
    butSpeichern.addActionListener(this);
    butBeenden.addActionListener(this);
    
    butLaden.setEnabled(false);
    butSpeichern.setEnabled(false);
    
    addWindowListener(this);
    
    getContentPane().add(pnlMain, "Center");
    getContentPane().add(pnlButton, "South");
    pnlButton.add(butVerbindung);
    pnlButton.add(butLaden);
    pnlButton.add(butSpeichern);
    pnlButton.add(butBeenden);
    
    setVisible(true);
  }
  
  public void windowOpened(WindowEvent e) {}
  
  public void windowClosing(WindowEvent e)
  {
    stoppeKommunikation(true);
    beenden();
  }
  
  public void windowClosed(WindowEvent e) {}
  
  public void windowIconified(WindowEvent e) {}
  
  public void windowDeiconified(WindowEvent e) {}
  
  public void windowActivated(WindowEvent e) {}
  
  public void windowDeactivated(WindowEvent e) {}
  
  class Beenden
    implements Runnable
  {
    //Thread t;
    RE_ComFrame frame;
    
    public Beenden(RE_ComFrame f)
    {
      frame = f;
      Thread t = new Thread(this);
      t.start();
    }
    
    public void run()
    {
      comSer.stoppeSeriell(frame);
      butVerbindung.setActionCommand("1");
      butVerbindung.setText(spr.VERBINDUNG_HERSTELLEN);
      butLaden.setEnabled(false);
      butSpeichern.setEnabled(false);
      
      lblVerbindung.setText(spr.KEINE_VERBINDUNG);
      lblVerbindung.setBackground(Color.RED);
      JOptionPane.showMessageDialog(frame, 
        spr.HINWEIS_VERBINDUNG_UNTERBROCHEN, 
        spr.TITEL_VERBINDUNG_UNTERBROCHEN, 
        0);
      setCursor(null);
    }
  }
}
