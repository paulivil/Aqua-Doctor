package Aqua_Doctor.GUI;

import Aqua_Doctor.GUI.panels.KonfigPanel;
import Aqua_Doctor.GUI.panels.PnlKonfAllgemein;
import Aqua_Doctor.GUI.panels.PnlKonfDisplay;
import Aqua_Doctor.GUI.panels.PnlKonfLuefter;
import Aqua_Doctor.GUI.panels.PnlKonfOfflineRelais;
import Aqua_Doctor.GUI.panels.PnlKonfOnlineRelais;
import Aqua_Doctor.GUI.panels.PnlKonfSensor;
import Aqua_Doctor.GUI.panels.PnlKonfVergleich;
import Aqua_Doctor.GUI.panels.PnlKonfWasFluß;
import Aqua_Doctor.GUI.panels.PnlKonfWasStand;
import Aqua_Doctor.ressource.Daten;
import Aqua_Doctor.ressource.Sprache;
import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectOutputStream;
import java.io.RandomAccessFile;
import java.net.URL;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

import javax.swing.BorderFactory;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class KonfPanel
  extends JPanel
{
  /**
	 * 
	 */
	private static final long serialVersionUID = -5154757643909006323L;
public JTabbedPane tpnKonf = new JTabbedPane();
  public PnlKonfDisplay pnlDisplay;
  public PnlKonfLuefter PnlKonfLfter;
  public PnlKonfSensor pnlNTC;
  public PnlKonfAllgemein pnlAllgemein;
  public PnlKonfWasStand pnlWasserstand;
  public PnlKonfWasFluß pnlPumpWasFluß;
  public PnlKonfOnlineRelais pnlOnline;
  public PnlKonfOfflineRelais pnlOffline;
  public PnlKonfVergleich pnlVergleich;
  public JPanel pnlButtons = new JPanel();
  public JButton butSpeichern = new JButton();
  public JButton butZurueck = new JButton();
  public JButton butAbbrechen = new JButton();
  public static Daten cfg;
  public Sprache spr;
  public static URL Aqua_DoctorIconURL = ClassLoader.getSystemResource("drawable/icon3.png");
  
  public Toolkit kit = Toolkit.getDefaultToolkit();
  Icon ico;
  public MainFrame mFrame;
  
  public ButtonListener butLis = new ButtonListener();
  BorderLayout borderLayout1 = new BorderLayout();
  
  public KonfPanel(Daten c, Sprache s, MainFrame m)
  {
    cfg = c;
    spr = s;
    mFrame = m;
    try
    {
      ico = new ImageIcon(Aqua_DoctorIconURL);
      jbInit();
      
      setzeSprache();
    }
    catch (Exception e) {}
  }
  
  public void setzeSprache()
  {
    butSpeichern.setText(spr.SPEICHERN);
    butSpeichern.setActionCommand(spr.SPEICHERN);
    butZurueck.setText(spr.STANDARD);
    butZurueck.setActionCommand(spr.STANDARD);
    
    butAbbrechen.setText(spr.ABBRECHEN);
    butAbbrechen.setActionCommand(spr.ABBRECHEN);
    
    tpnKonf.setTitleAt(0, spr.TAB_ALLGEMEIN);
    tpnKonf.setTitleAt(1, spr.TAB_DISPLAY);
    tpnKonf.setTitleAt(2, spr.TAB_LUEFTER);
    tpnKonf.setTitleAt(3, spr.TAB_NTC);
    tpnKonf.setTitleAt(4, spr.TAB_PUMPE);
    tpnKonf.setTitleAt(5, spr.TAB_WASSERSTAND);
    tpnKonf.setTitleAt(6, spr.TAB_ONLINE);
    tpnKonf.setTitleAt(7, spr.TAB_OFFLINE);
    tpnKonf.setTitleAt(8, spr.TAB_VERGLEICH);
  }
  
  public void aktualisiere()
  {
    Component[] comp = tpnKonf.getComponents();
    for (int i = 0; i < comp.length; i++)
    {
      KonfigPanel tab = (KonfigPanel)comp[i];
      tab.aktualisiere();
    }
  }
  
  public void ladeEinstellungen()
  {
    try
    {
      Component[] comp = tpnKonf.getComponents();
      try
      {
        tpnKonf.removeChangeListener(tpnKonf.getChangeListeners()[0]);
      }
      catch (Exception e) {}
      for (int i = 0; i < comp.length; i++)
      {
        KonfigPanel tab = (KonfigPanel)comp[i];
        tab.ladenAktiv = true;
        tab.ladeKonfig();
      }
      tpnKonf.addChangeListener(new tabListener());
    }
    catch (Exception e) {}
  }
  
  public void ladeStandard(boolean bol)
  {
    Component[] comp = tpnKonf.getComponents();
    KonfigPanel tab = null;
    if (bol) {
      for (int i = 0; i < comp.length; i++)
      {
        tab = (KonfigPanel)comp[i];
        if (tab == (KonfigPanel)tpnKonf.getSelectedComponent())
        {
          tab.ladeStandardEinstellung();
          tab.removeListener();
          tab.fuelleCombo();
          tab.setzeEinstellung();
          tab.setzeListener();
          tab.aktualisiere();
        }
      }
    } else {
      for (int i = 0; i < comp.length; i++)
      {
        tab = (KonfigPanel)comp[i];
        tab.ladeStandardEinstellung();
        tab.removeListener();
        tab.fuelleCombo();
        tab.setzeEinstellung();
        tab.setzeListener();
        tab.aktualisiere();
      }
    }
  }
  
  public void SpracheAendern()
  {
    try
    {
      Component[] comp = tpnKonf.getComponents();
      
      setzeSprache();
      
      mFrame.wPanel.setzeSprache();
      for (int i = 0; i < comp.length; i++)
      {
        KonfigPanel tab = (KonfigPanel)comp[i];
        tab.removeListener();
        tab.setzeSprache();
      }
    }
    catch (Exception e) {}
    repaint();
  }
  
  public void jbInit()
    throws Exception
  {
    pnlDisplay = new PnlKonfDisplay(spr, cfg);
    PnlKonfLfter = new PnlKonfLuefter(cfg, spr, mFrame);
    pnlNTC = new PnlKonfSensor(cfg, spr);
    pnlAllgemein = new PnlKonfAllgemein(spr, cfg, mFrame);
    pnlWasserstand = new PnlKonfWasStand(cfg, spr);
    pnlPumpWasFluß = new PnlKonfWasFluß(cfg, spr);
    pnlOnline = new PnlKonfOnlineRelais(cfg, spr);
    pnlOffline = new PnlKonfOfflineRelais(cfg, spr);
    pnlVergleich = new PnlKonfVergleich(cfg, spr);
    
    setLayout(borderLayout1);
    setBorder(BorderFactory.createEtchedBorder());
    setMaximumSize(new Dimension(570, 578));
    setMinimumSize(new Dimension(570, 578));
    setPreferredSize(new Dimension(570, 578));
    pnlButtons.add(butSpeichern);
    pnlButtons.add(butZurueck);
    pnlButtons.add(butAbbrechen);
    butSpeichern.addActionListener(butLis);
    butZurueck.addActionListener(butLis);
    butAbbrechen.addActionListener(butLis);
    
    tpnKonf.add(pnlAllgemein, "pnlAllgemein");
    tpnKonf.add(pnlDisplay, "pnlDisplay");
    tpnKonf.add(PnlKonfLfter, "PnlKonfLfter");
    tpnKonf.add(pnlNTC, "pnlNTC");
    tpnKonf.add(pnlPumpWasFluß, "pnlPumpWasFluß");
    tpnKonf.add(pnlWasserstand, "pnlWasserstand");
    tpnKonf.add(pnlOnline, "pnlOnline");
    tpnKonf.add(pnlOffline, "pnlOffline");
    tpnKonf.add(pnlVergleich, "pnlVergleich");
    add(tpnKonf, "Center");
    
    setVisible(true);
    setSize(new Dimension(400, 508));
  }
  
  public class SpeichernThread
    implements Runnable
  {
    public Thread t = new Thread(this);
    
    public SpeichernThread(KonfPanel konfPanel)
    {
      t.start();
    }
    
    public void run()
    {
      KonfigPanel tab = (KonfigPanel)tpnKonf.getSelectedComponent();
      tab.removeListener();
      tab.speicherEinstellung();
      ObjectOutputStream obj = null;
      try
      {
        RandomAccessFile f = new RandomAccessFile("Profil.dat", "rw");
        
      FileOutputStream disk = new FileOutputStream(f.getFD());
      
      obj = new ObjectOutputStream(disk);
      obj.writeObject(KonfPanel.cfg);
      } catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} finally {
    	    if (obj != null) {
    	      try {
				obj.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
    	      
    	    }      
        //if (disk.) {
        //  disk.delete();
        //}
        //FileOutputStream disk = new FileOutputStream(f);
        //ObjectOutputStream obj = new ObjectOutputStream(disk);
        //obj.writeObject(KonfPanel.cfg);
        //obj.close();
      }
      //catch (Exception e) {e.printStackTrace();}
      KonfPanel.cfg.schreibeKonfig();
      
      tab.setzeEinstellung();
      tab.setzeListener();
      tab.aktualisiere();
    }
  }
  
  public class tabListener
    implements ChangeListener
  {
    public tabListener() {}
    
    public void stateChanged(ChangeEvent e)
    {
      Component[] comp = tpnKonf.getComponents();
      for (int i = 0; i < comp.length; i++)
      {
        KonfigPanel tab = (KonfigPanel)comp[i];
        tab.speicherEinstellung();
      }
     KonfPanel.this.repaint();
    }
  }
  
  public class ButtonListener
    implements ActionListener
  {
    public ButtonListener() {}
    
    public void actionPerformed(ActionEvent e)
    {
      JButton button = (JButton)e.getSource();
      if (button.getActionCommand().equals(spr.SPEICHERN))
      {
        if (JOptionPane.showConfirmDialog(null, spr.FRAGE_SPEICHERN, spr.TITEL_SPEICHERN, 0, 3) == 0)
        {KonfPanel.SpeichernThread st = new KonfPanel.SpeichernThread(KonfPanel.this);
        }
      }
      else if (button.getActionCommand().equals(spr.STANDARD))
      {
        int x = 
          JOptionPane.showConfirmDialog(button.getParent(), 
          spr.FRAGE_ALLE_STANDARD, 
          spr.TITEL_ALLE_STANDARD, 
          1, 
          3);
        if (x == 0) {
          KonfPanel.this.ladeStandard(false);
        } else if (x == 1) {
          KonfPanel.this.ladeStandard(true);
        }
      }
      else
      {
        button.getActionCommand().equals(spr.ABBRECHEN);
      }
    }
  }
}
