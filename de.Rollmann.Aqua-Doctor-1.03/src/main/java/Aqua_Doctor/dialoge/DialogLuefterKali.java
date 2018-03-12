package Aqua_Doctor.dialoge;

import Aqua_Doctor.GUI.MainFrame;
import Aqua_Doctor.GUI.panels.PnlKonfLuefter;
import Aqua_Doctor.kommunikation.DynDaten;
import Aqua_Doctor.ressource.Daten;
import Aqua_Doctor.ressource.Sprache;
import Aqua_Doctor.tools.BitTool;
import de.Rollmann.kommunikation.ComTabellen.ComTabelle;
import de.Rollmann.kommunikation.Runnable.MasterRunnable;
import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DecimalFormat;
import java.util.BitSet;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;

public class DialogLuefterKali
  extends JDialog
  implements Runnable, ActionListener
{
  /**
	 * 
	 */
	private static final long serialVersionUID = -4893689337640682492L;
public JLabel lblStatus = new JLabel();
  public JTextArea tarHinweis = new JTextArea();
  public JButton butStarten = new JButton();
  public JButton butAbbrechen = new JButton();
  public PnlKonfLuefter panel;
  public Daten cfg;
 public Thread t = new Thread(this);
  public Sprache spr;
  byte b = 63;
  public BitSet bs = BitTool.fromByte(b);
  public int[] array = {250, 250, 250, 250, 250, 250, b };
  public int error = 0;
  public BorderLayout borderLayout1 = new BorderLayout();
  public JPanel pnlButtons = new JPanel();
  public int minDreh = 0;
  public int maxDreh = 0;
  public ComTabelle comtab;
  public DynDaten daten;
  public MasterRunnable master;
  public MainFrame mFrame;
  JPanel pnlCenter = new JPanel();
  BorderLayout borderLayout2 = new BorderLayout();
  JLabel lblVolt = new JLabel();
  
  public DialogLuefterKali(JFrame f, PnlKonfLuefter pnl, ComTabelle tab, DynDaten d, Sprache s, Daten c, MasterRunnable m)
  {
    super(f);
    comtab = tab;
    daten = d;
    panel = pnl;
    spr = s;
    cfg = c;
    master = m;
    mFrame = ((MainFrame)f);
    try
    {
      jbInit();
    }
    catch (Exception e) {}
  }
//synchronized
  public synchronized void run()
  {
    try
    {
      todo();
    }
    catch (Exception ex)
    {
      mFrame.kommunikationUnterbrochen();
      dispose();
    }
  }
  
  public boolean todo()
    throws Exception
  {
    butAbbrechen.setEnabled(false);
    
    array[6] = 0;
    
    array[cfg.LUEFTER_AUSWAHL] = 200;
    
    comtab.setzeSchreiben(ComTabelle.getAdresse(1, true, false), array);
    comtab.starteRamSchreiben();
    
    daten.kalibrierung = true;
    if (!ermittleMax()) {
      error = 1;
    }
    if ((error == 0) && 
      (!ermittleMin())) {
      error = 2;
    }
    butStarten.setEnabled(true);
    
    butAbbrechen.setText(spr.FERTIG);
    butAbbrechen.setEnabled(true);
    switch (error)
    {
    case 0: 
      lblStatus.setText(spr.DREHZAHLEN_WURDEN_ERMITTELT);
      
      cfg.LUEFTER_MAXLUEFTER_DREHZAHL[cfg.LUEFTER_AUSWAHL] = maxDreh;
      cfg.LUEFTER_MINLUEFTER_DREHZAHL[cfg.LUEFTER_AUSWAHL] = minDreh;
      panel.setzeMaxDrehzahl(maxDreh);
      panel.setzeMinDrehzahl(minDreh);
      break;
    case 1: 
      panel.errechneMinDrehzahl();
      lblStatus.setText(spr.LUEFTER_BESITZ_KEINE_DREHZAHLFUNKTION);
      break;
    case 2: 
      panel.setzeMinDrehzahl(0);
      lblStatus.setText(spr.MINDREHZAHL_KANN_NICHT_ERMITTELT_WERDEN);
    }
    array[6] = b;
    
    array[cfg.LUEFTER_AUSWAHL] = 250;
    
    comtab.setzeSchreiben(ComTabelle.getAdresse(1, true, false), array);
    comtab.starteRamSchreiben();
    
    return true;
  }
//synchronized?
  public  boolean ermittleMax()
  {
    lblStatus.setText(spr.ERMITTLE_MAXIMALE_DREHZAHL);
    lblVolt.setText(getVolt(200));
    while (daten.LuefterKali[cfg.LUEFTER_AUSWAHL] != 200) {}
    try
    {
      Thread.sleep(10000);
    }
    catch (InterruptedException ex)
    {ex.printStackTrace();
      return false;
    }
    if (daten.LuefterKali[cfg.LUEFTER_AUSWAHL] == 0) {
      return false;
    }
    maxDreh = daten.array[cfg.LUEFTER_AUSWAHL];
    return true;
  }
  //synchronized?
  public  boolean ermittleMin()
    throws Exception
  {
    try
    {
      int minPWM = 60;
      
      array[cfg.LUEFTER_AUSWAHL] = minPWM;
      comtab.setzeSchreiben(ComTabelle.getAdresse(1, true, false), array);
      comtab.starteRamSchreiben();
      
      lblStatus.setText(spr.ERMITTLE_MINIMALE_DREHZAHL);
      while ((daten.LuefterKali[cfg.LUEFTER_AUSWAHL] != minPWM) && (
       t.isAlive())) {}
      lblVolt.setText(getVolt(minPWM));
      Thread.sleep(10000);
      do
      {
        minPWM += 5;
        array[cfg.LUEFTER_AUSWAHL] = minPWM;
        comtab.setzeSchreiben(ComTabelle.getAdresse(1, true, false), 
          array);
        comtab.starteRamSchreiben();
        
        lblVolt.setText(getVolt(minPWM));
        while ((daten.LuefterKali[cfg.LUEFTER_AUSWAHL] != minPWM) && (
          t.isAlive())) {
          if (minPWM >= 200) {
            return false;
          }
        }
        Thread.sleep(100);
        if (daten.array[cfg.LUEFTER_AUSWAHL] != 0) {
          break;
        }
      } while (t.isAlive());
    }
    catch (InterruptedException ex)
    {ex.printStackTrace();
      return false;
    }
    minDreh = daten.array[cfg.LUEFTER_AUSWAHL];
    return true;
  }
  
  public String getVolt(int pwm)
  {
    double Volt = 0.0D;
    DecimalFormat df = new DecimalFormat("###0.0");
    
    Volt = 12 * pwm / 200.0D;
    
    return "Aktuelle Spannung : " + df.format(Volt) + "V";
  }
  
  public void jbInit()
    throws Exception
  {
    lblStatus.setHorizontalAlignment(0);
    lblStatus.setHorizontalTextPosition(0);
    
    tarHinweis.setBackground(SystemColor.activeCaptionBorder);
    tarHinweis.setFont(new Font("Tahoma", 0, 11));
    tarHinweis.setLineWrap(true);
    tarHinweis.setText(spr.HINWEIS_LUEFTER_DREHZAHL_ERKENNUNG);
    
    butAbbrechen.setText(spr.ABBRECHEN);
    butAbbrechen.setActionCommand("1");
    butAbbrechen.addActionListener(this);
    butStarten.setText(spr.STARTEN);
    butStarten.setActionCommand("0");
    butStarten.addActionListener(this);
    pnlCenter.setLayout(borderLayout2);
    lblVolt.setHorizontalAlignment(0);
    lblVolt.setHorizontalTextPosition(0);
    lblVolt.setText(spr.AKTUELLE_LUEFTERSPANNUNG + " : ");
    pnlButtons.add(butStarten);
    pnlButtons.add(butAbbrechen);
    
    getContentPane().setLayout(borderLayout1);
    getContentPane().add(pnlButtons, "South");
    getContentPane().add(pnlCenter, "Center");
    pnlCenter.add(lblStatus, "Center");
    pnlCenter.add(tarHinweis, "North");
    pnlCenter.add(lblVolt, "South");
    setSize(350, 150);
    setTitle(spr.TITEL_LUEFTER_DREHZAHL_ERKENNEN);
    setAlwaysOnTop(true);
    setLocation(500, 400);
    setModal(true);
    setVisible(true);
  }
  
  public void actionPerformed(ActionEvent e)
  {
    JButton button = (JButton)e.getSource();
    //Thread t = new Thread(this);
    switch (Integer.parseInt(button.getActionCommand()))
    {
    case 0: 
      butStarten.setEnabled(false);
      
      t.start();
      break;
    case 1: 
      try
      {
        if (t.isAlive()) {
          t.interrupt();
        } else {
          dispose();
        }
      }
      catch (Exception ex)
      {
        dispose();
      }
    }
  }
}