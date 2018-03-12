package Aqua_Doctor.GUI;

import Aqua_Doctor.GUI.panels.KonfigPanel;
import Aqua_Doctor.GUI.panels.WertePanel;
import Aqua_Doctor.kommunikation.DynDaten;
import Aqua_Doctor.kommunikation.DynThread;
import Aqua_Doctor.kommunikation.TabelleAqua_Doctor;
import Aqua_Doctor.ressource.Daten;
import Aqua_Doctor.ressource.Sprache;
import de.Rollmann.Dialoge.DialogLade;
import de.Rollmann.kommunikation.ComTabellen.ComTabelle;
import de.Rollmann.kommunikation.Daten.DatenKlasse;
import de.Rollmann.kommunikation.Runnable.MasterRunnable;
import de.Rollmann.komponenten.RE_ComFrame;
import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Cursor;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.RandomAccessFile;
import java.net.URL;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDesktopPane;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

public class MainFrame
  extends RE_ComFrame
{
  /**
	 * 
	 */
	private static final long serialVersionUID = 6663183477706554065L;
public WertePanel wPanel;
  public JDesktopPane desktopPane = new JDesktopPane();
  public Container contentPane = getContentPane();
  public Daten cfg;
  public Toolkit kit = Toolkit.getDefaultToolkit();
  //public URL Aqua_DoctorIconURL = ClassLoader.getSystemResource("drawable/icon3.png");
  public URL Aqua_DoctorIconURL = KonfPanel.Aqua_DoctorIconURL;
  public Cursor cursor;
  Icon Aqua_DoctorIcon;
  BorderLayout borderLayout2 = new BorderLayout();
  public DynDaten daten;
  JPanel pnlButton = new JPanel();
  JButton butVerbindung = new JButton();
  JButton butLaden = new JButton();
  JButton butSpeichern = new JButton();
  JButton butImport = new JButton();
  JButton butExport = new JButton();
  MainFrame mFrame;
  DialogLade dia;
  
  
  public MainFrame(Daten c, Sprache s)
  {
    super("Aqua_Doctor.kommunikation.TabelleAqua_Doctor", c);
    
    super.setzeButtonZuordnung(butVerbindung, butLaden, butSpeichern);
    
    geraet = s.MENU_HEATMASTER_2;
    
    mFrame = this;
    cursor = new Cursor(3);
    cfg = c;
    spr = s;
    try
    {
      init();
      jbInit();
     Aqua_DoctorIcon = new ImageIcon(Aqua_DoctorIconURL);
   
      daten = new DynDaten(cfg, spr, wPanel);
      
      setIconImage(kit.getImage(Aqua_DoctorIconURL));
      addWindowListener(this);
    }
    catch (Exception e) {}
  }
  
  public DatenKlasse getDatenKlasse()
  {
    return cfg;
  }
  
  public void init()
  {
    wPanel = new WertePanel(spr, cfg);
    konfPanel = new KonfPanel(cfg, spr, this);
  }
  
  public ComTabelle erstelleComTabelle(MasterRunnable master)
  {
    try
    {
      tabcom = new TabelleAqua_Doctor(master, this);
    }
    catch (Exception e) {}
    return tabcom;
  }
  
  public void exportiereKonfiguration()
  {
	  
	  ObjectOutputStream obj = null;
  
    try
    {
      KonfigPanel tab = (KonfigPanel)konfPanel.tpnKonf.getSelectedComponent();
      
      tab.speicherEinstellung();
      
      JFileChooser fc_dat = new JFileChooser();
      fc_dat.removeChoosableFileFilter(fc_dat.getFileFilter());
      fc_dat.setFileFilter(new HexFilter());
      
      int state = fc_dat.showSaveDialog(null);
      String Ziel = fc_dat.getSelectedFile().getAbsolutePath();
      if ((Ziel != "") && (state == 0))
      {
        if (!Ziel.endsWith(".dat")) {
          Ziel = Ziel + ".dat";
        }
        
       
          RandomAccessFile f = new RandomAccessFile(Ziel, "rw");
          
        FileOutputStream disk = new FileOutputStream(f.getFD());
        
        obj = new ObjectOutputStream(disk);
        obj.writeObject(cfg);
     
  				obj.close();
  			
      	      }   
      	        
        /*
        FileOutputStream disk = new FileOutputStream(Ziel);
        ObjectOutputStream obj = new ObjectOutputStream(disk);
        obj.writeObject(cfg);
        obj.close();
        */
        JOptionPane.showMessageDialog(mFrame, 
          spr.KONFIGURATION_GESPEICHERT);
      
    }
    catch (Exception ex)
    {
      JOptionPane.showMessageDialog(mFrame, spr.FEHLER);
    }
  }
  
  public void importiereKonfiguration()
  {
	  ObjectInputStream oi = null;
    try
    {
      JFileChooser fc_dat = new JFileChooser();
      fc_dat.removeChoosableFileFilter(fc_dat.getFileFilter());
      fc_dat.setFileFilter(new HexFilter());
      
      int state = fc_dat.showOpenDialog(null);
      String Quell = fc_dat.getSelectedFile().getAbsolutePath();
      if ((Quell != "") && (state == 0))
      {
    	  RandomAccessFile f = new RandomAccessFile(Quell, "rw");
          
          FileInputStream disk = new FileInputStream(f.getFD());
          
          oi = new ObjectInputStream(disk);
          Daten importcfg = (Daten)oi.readObject();
       
    				oi.close();
    			
    	  /*
        FileInputStream disk = new FileInputStream(Quell);
        ObjectInputStream oi = new ObjectInputStream(disk);
        Daten importcfg = (Daten)oi.readObject();
        oi.close();
        */
        cfg.importKonfiguration(importcfg);
        
        konfPanel.ladeEinstellungen();
        konfPanel.pnlAllgemein.cboSprache.aktualisiere();
        konfPanel.setVisible(true);
        
        JOptionPane.showMessageDialog(mFrame, spr.KONFIGURATION_GELADEN);
      }
    }
    catch (Exception ex)
    {
      JOptionPane.showMessageDialog(mFrame, spr.FEHLER);
    }
  }
  
  public void setzeSprache()
  {
    setTitle(spr.UEBERSCHRIFT_HAUPT_RAHMEN + " - V1.03");
    
    butSpeichern.setText(spr.SPEICHERN);
    butLaden.setText(spr.LADEN);
    butImport.setText(spr.KONFIGURATION_IMPORT);
    butExport.setText(spr.KONFIGURATION_EXPORT);
    if (butVerbindung.getActionCommand().equals("5")) {
      butVerbindung.setText(spr.VERBINDUNG_TRENNEN);
    } else {
      butVerbindung.setText(spr.VERBINDUNG_HERSTELLEN);
    }
  }
  
  public void beendeThreads()
  {
    try
    {
      dyn.beenden();
    }
    catch (Exception e) {}
    butVerbindung.setActionCommand("1");
    butVerbindung.setText(spr.VERBINDUNG_HERSTELLEN);
    butLaden.setEnabled(false);
    butSpeichern.setEnabled(false);
    konfPanel.PnlKonfLfter.removeLiveLis();
    konfPanel.pnlWasserstand.removeKalibrierLis();
    konfPanel.setVisible(false);
  }
  
  public void kommunikationUnterbrochen()
  {
    JOptionPane.showMessageDialog(this, spr.HINWEIS_VERBINDUNG_UNTERBROCHEN);
    beendeThreads();
  }
  
  public void jbInit()
    throws Exception
  {
    SwingUtilities.updateComponentTreeUI(this);
    
    contentPane.setLayout(borderLayout2);
    
    butVerbindung.setText(spr.VERBINDUNG_HERSTELLEN);
    butVerbindung.setActionCommand("1");
    butVerbindung.addActionListener(this);
    
    butLaden.setText(spr.LADEN);
    butLaden.setActionCommand("2");
    butLaden.addActionListener(this);
    butLaden.setEnabled(false);
    butImport.addActionListener(new ActionListener()
    {
      public void actionPerformed(ActionEvent e)
      {
        importiereKonfiguration();
      }
    });
    butExport.addActionListener(new ActionListener()
    {
      public void actionPerformed(ActionEvent e)
      {
        exportiereKonfiguration();
      }
    });
    butSpeichern.setText(spr.SPEICHERN);
    butSpeichern.setActionCommand("3");
    butSpeichern.addActionListener(this);
    butSpeichern.setEnabled(false);
    butImport.setText(spr.KONFIGURATION_IMPORT);
    butExport.setText(spr.KONFIGURATION_EXPORT);
    pnlButton.add(butExport);
    pnlButton.add(butImport);
    pnlButton.add(butSpeichern);
    pnlButton.add(butLaden);
    pnlButton.add(butVerbindung);
    contentPane.add(konfPanel, "East");
    contentPane.add(wPanel, "West");
    contentPane.add(pnlButton, "South");
    
    konfPanel.setVisible(false);
    
    setSize(1160, 800);
    
    SwingUtilities.updateComponentTreeUI(this);
    try
    {
      setzeSprache();
    }
    catch (Exception e) {}
    setVisible(true);
  }
  
  public void windowActivated(WindowEvent e) {}
  
  public void windowClosed(WindowEvent e) {}
  
  public void windowClosing(WindowEvent e)
  {
    if (JOptionPane.showConfirmDialog(null, spr.FRAGE_SOFWARE_BEENDEN, 
      spr.TITEL_SOFWARE_BEENDEN, 0, 
      3) == 0)
    {
    	 mFrame.setCursor(cur);
      stoppeKommunikation(true);
      try
      {
        try
        {
          beendeThreads();
        }
        catch (Exception e1) {}
        try
        {
          dispose();
        }
        catch (Exception e1) {}
      }
      catch (Exception e1) {}
      System.exit(0);
    }
    else
    {
      setDefaultCloseOperation(0);
    }
  }
  
  public void windowDeactivated(WindowEvent e) {}
  
  public void windowDeiconified(WindowEvent e) {}
  
  public void windowIconified(WindowEvent e) {}
  
  public void windowOpened(WindowEvent e) {}
  
  class ComThreadLade
    implements Runnable
  {
    public ComThreadLade()
    {
      Thread t = new Thread(this);
      t.start();
    }
  //synchronized
    public synchronized void run()
    {
      try
      {
        mFrame.setCursor(cursor);
        
        butSpeichern.setEnabled(false);
        butVerbindung.setEnabled(false);
        butLaden.setEnabled(false);
        try
        {
          cfg.laden(tabcom);
          konfPanel.ladeEinstellungen();
        }
        catch (Exception e) {}
        butSpeichern.setEnabled(true);
        butVerbindung.setEnabled(true);
        butLaden.setEnabled(true);
        
        JOptionPane.showMessageDialog(mFrame, spr.KONFIGURATION_GELADEN);
      }
      catch (Exception e)
      {
        JOptionPane.showMessageDialog(mFrame, 
          spr.KEIN_HEATMASTER_2_GEFUNDEN);
      }
      mFrame.setCursor(null);
    }
  }
  
  public void ladeEinstellung()
  {
    konfPanel.ladeEinstellungen();
    if (!comUnterbrochen)
    {
      JOptionPane.showMessageDialog(mFrame, spr.KONFIGURATION_GELADEN);
      
      dyn = new DynThread(this);
      konfPanel.PnlKonfLfter.setzeLiveLis(tabcom, daten);
      konfPanel.pnlWasserstand.setzeKalibrierLis(tabcom);
      
      butVerbindung.setActionCommand("5");
      butVerbindung.setText(spr.VERBINDUNG_TRENNEN);
      butLaden.setEnabled(true);
      butSpeichern.setEnabled(true);
      konfPanel.setVisible(true);
    }
  }
  
  public void speicherEinstellung()
  {
    KonfigPanel tab = (KonfigPanel)konfPanel.tpnKonf.getSelectedComponent();
    
    tab.speicherEinstellung();
    try
    {
      cfg.speichern(tabcom);
    }
    catch (Exception e)
    {
      kommunikationUnterbrochen();
      stoppeKommunikation(true);
    }
    if (!comUnterbrochen) {
      JOptionPane.showMessageDialog(mFrame, spr.KONFIGURATION_GESPEICHERT);
    }
  }
}
