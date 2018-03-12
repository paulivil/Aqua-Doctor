package Aqua_Doctor.GUI.panels;

import Aqua_Doctor.listener.SliListener;
import Aqua_Doctor.ressource.Daten;
import Aqua_Doctor.ressource.Sprache;
import de.Rollmann.komponenten.RE_Slider;
import java.awt.Rectangle;
import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.border.TitledBorder;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class PnlKonfDisplay
  extends KonfigPanel
{
  /**
	 * 
	 */
	private static final long serialVersionUID = 3596750137367775739L;
public JLabel lblSleepHelligkeit = new JLabel();
  public JLabel lblHelligkeit = new JLabel();
  public JLabel lblSleepHelligkeitWert = new JLabel();
  public JLabel lblHelligkeitWert = new JLabel();
  public JLabel lblStandbyHelligkeitWert = new JLabel();
  public JLabel lblStandbyZeitWert = new JLabel();
  public JLabel lblStandbyZeit = new JLabel();
  public JLabel lblStandbyHelligkeit = new JLabel();
  public RE_Slider sliSleepHelligkeit = new RE_Slider(0, 255);
  public RE_Slider sliHelligkeit = new RE_Slider(0, 255);
  public RE_Slider sliStandbyHelligkeit = new RE_Slider(0, 255);
  public RE_Slider sliStandbyZeit = new RE_Slider(10, 255);
  public JPanel pnlStandby = new JPanel();
  public JPanel pnlHelligkeit = new JPanel();
  public JPanel pnlSleep = new JPanel();
  public TitledBorder tbrStandByBel = new TitledBorder("");
  public TitledBorder tbrBetriebBel = new TitledBorder("");
  public TitledBorder tbrSleepBel = new TitledBorder("");
  public LiveBeleuchtungsSlilistener belLis = new LiveBeleuchtungsSlilistener();
  public SliListener sleepLis;
  public SliListener stanbyHellLis;
  public SliListener helligkeitLis;
  public SliListener standbyTimeLis;
  public Daten cfg;
  public Sprache spr;
  
  public PnlKonfDisplay(Sprache s, Daten c)
  {
    cfg = c;
    spr = s;
    try
    {
      jbInit();
      setzeSprache();
    }
    catch (Exception e) {}
  }
  
  public void setzeKonfig(Daten c)
  {
    cfg = c;
  }
  
  public void setzeEinstellung()
  {
    sliHelligkeit.setValue(cfg.DISPLAY_HELLIGKEIT);
    sliSleepHelligkeit.setValue(cfg.DISPLAY_HELLIGKEIT_SLEEP);
    sliStandbyHelligkeit.setValue(cfg.DISPLAY_HELLIGKEIT_STANDBY);
    sliStandbyZeit.setValue(cfg.DISPLAY_ZEIT_STANDBY);
  }
  
  public void ladeEinstellung() {}
  
  public void ladeStandardEinstellung()
  {
    cfg.ladeLokalStandardEinstellungenDisplay();
  }
  
  public void speicherEinstellung()
  {
    cfg.DISPLAY_HELLIGKEIT = 
      sliHelligkeit.getValue();
    cfg.DISPLAY_HELLIGKEIT_SLEEP = 
      sliSleepHelligkeit.getValue();
    cfg.DISPLAY_HELLIGKEIT_STANDBY = 
      sliStandbyHelligkeit.getValue();
    cfg.DISPLAY_ZEIT_STANDBY = 
      sliStandbyZeit.getValue();
  }
  
  public void setzeSprache()
  {
    lblSleepHelligkeit.setText(spr.HELLIGKEIT);
    lblHelligkeit.setText(spr.HELLIGKEIT);
    lblStandbyZeit.setText(spr.STANDBY_ZEIT);
    lblStandbyHelligkeit.setText(spr.HELLIGKEIT);
    
    tbrStandByBel.setTitle(spr.STANDBY_BELEUCHTUNG);
    tbrBetriebBel.setTitle(spr.BETRIEB_BELEUCHTUNG_MIT_VORSCHAU);
    tbrSleepBel.setTitle(spr.SLEEP_BELEUCHTUNG);
    
    fuelleCombo();
    ladeEinstellung();
    setzeEinstellung();
    setzeListener();
    aktualisiere();
  }
  
  public void fuelleCombo() {}
  
  public void setzeListener()
  {
    sleepLis = new SliListener(lblSleepHelligkeitWert, 
      11, 255, 0, false, spr, cfg);
    
    stanbyHellLis = new SliListener(lblStandbyHelligkeitWert, 
      11, 255, 0, false, spr, cfg);
    helligkeitLis = new SliListener(lblHelligkeitWert, 
      11, 255, 0, false, spr, cfg);
    standbyTimeLis = new SliListener(lblStandbyZeitWert, 
      1, 255, 0, false, spr, cfg);
    
    sliSleepHelligkeit.addChangeListener(sleepLis);
    sliStandbyHelligkeit.addChangeListener(stanbyHellLis);
    sliStandbyZeit.addChangeListener(standbyTimeLis);
    sliHelligkeit.addChangeListener(helligkeitLis);
    sliHelligkeit.addChangeListener(belLis);
  }
  
  public void removeListener()
  {
    sliSleepHelligkeit.removeChangeListener(stanbyHellLis);
    
    sliHelligkeit.removeChangeListener(helligkeitLis);
    sliHelligkeit.removeChangeListener(belLis);
  }
  
  public void aktualisiere() {}
  
  public void jbInit()
    throws Exception
  {
    lblStandbyZeitWert.setBorder(BorderFactory.createEtchedBorder());
    lblStandbyZeitWert.setBounds(new Rectangle(170, 70, 50, 15));
    lblStandbyZeit.setBounds(new Rectangle(15, 70, 147, 15));
    
    lblStandbyHelligkeit.setBounds(new Rectangle(15, 30, 147, 15));
    lblStandbyHelligkeitWert.setBorder(BorderFactory.createEtchedBorder());
    lblStandbyHelligkeitWert.setBounds(new Rectangle(170, 30, 50, 15));
    
    lblSleepHelligkeit.setBounds(new Rectangle(15, 30, 152, 15));
    lblSleepHelligkeitWert.setBorder(BorderFactory.createEtchedBorder());
    lblSleepHelligkeitWert.setBounds(new Rectangle(170, 30, 50, 15));
    
    lblHelligkeit.setBounds(new Rectangle(15, 30, 152, 15));
    lblHelligkeitWert.setBorder(BorderFactory.createEtchedBorder());
    lblHelligkeitWert.setBounds(new Rectangle(170, 30, 50, 15));
    
    sliSleepHelligkeit.setBounds(new Rectangle(230, 27, 200, 24));
    sliHelligkeit.setBounds(new Rectangle(230, 27, 200, 24));
    sliStandbyHelligkeit.setBounds(new Rectangle(230, 27, 200, 24));
    sliStandbyZeit.setBounds(new Rectangle(230, 67, 200, 24));
    
    pnlHelligkeit.setBorder(tbrBetriebBel);
    pnlHelligkeit.setBounds(new Rectangle(13, 20, 453, 69));
    pnlHelligkeit.setLayout(null);
    pnlHelligkeit.add(lblHelligkeitWert);
    pnlHelligkeit.add(lblHelligkeit);
    pnlHelligkeit.add(sliHelligkeit);
    
    pnlSleep.setBorder(tbrSleepBel);
    pnlSleep.setBounds(new Rectangle(13, 95, 453, 69));
    pnlSleep.setLayout(null);
    pnlSleep.add(lblSleepHelligkeitWert);
    pnlSleep.add(lblSleepHelligkeit);
    pnlSleep.add(sliSleepHelligkeit);
    add(pnlStandby);
    
    pnlStandby.setBorder(tbrStandByBel);
    pnlStandby.setBounds(new Rectangle(13, 164, 453, 115));
    pnlStandby.setLayout(null);
    pnlStandby.add(lblStandbyZeit);
    pnlStandby.add(lblStandbyHelligkeit);
    pnlStandby.add(lblStandbyZeitWert);
    pnlStandby.add(sliStandbyZeit);
    pnlStandby.add(lblStandbyHelligkeitWert);
    pnlStandby.add(sliStandbyHelligkeit);
    add(pnlSleep);
    add(pnlHelligkeit);
    setLayout(null);
  }
  
  public void ladeKonfig()
  {
    ladenAktiv = true;
    
    removeListener();
    
    setzeSprache();
    ladenAktiv = false;
  }
  
  public class LiveBeleuchtungsSlilistener
    implements ChangeListener
  {
    public LiveBeleuchtungsSlilistener() {}
    
    public void stateChanged(ChangeEvent e)
    {
      RE_Slider slider = (RE_Slider)e.getSource();
      
      cfg.DISPLAY_HELLIGKEIT = slider.getValue();
      int[] arrayOfInt = 
        {
        0, 0, 0, 0, 0, 0, 0, 255, 255, 
        cfg.DISPLAY_HELLIGKEIT };
    }
  }
  
  public class AnAusListener
    implements ChangeListener
  {
    public AnAusListener() {}
    
    public void stateChanged(ChangeEvent e)
    {
      JRadioButton radio = (JRadioButton)e.getSource();
      if ((radio.getActionCommand().equals(spr.AUS)) && (radio.isSelected()))
      {
        sliSleepHelligkeit.setEnabled(false);
        sliHelligkeit.setEnabled(false);
      }
      else if ((radio.getActionCommand().equals(spr.AN)) && (radio.isSelected()))
      {
        sliSleepHelligkeit.setEnabled(true);
        sliHelligkeit.setEnabled(true);
      }
    }
  }
}

