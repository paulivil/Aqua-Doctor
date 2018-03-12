package Aqua_Doctor.GUI.panels;

import Aqua_Doctor.listener.SliListener;
import Aqua_Doctor.ressource.Daten;
import Aqua_Doctor.ressource.Sprache;
import de.Rollmann.kommunikation.ComTabellen.ComTabelle;
import de.Rollmann.komponenten.RE_ComboBox;
import de.Rollmann.komponenten.RE_RadioButton;
import de.Rollmann.komponenten.RE_Slider;
import de.Rollmann.komponenten.RE_TextField;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JProgressBar;

public class PnlKonfWasStand
  extends KonfigPanel
{
  /**
	 * 
	 */
	private static final long serialVersionUID = 3229111793780655619L;
public JLabel lblTyp = new JLabel();
  public JLabel lblAusrichtung = new JLabel();
  public JLabel lblAlarm = new JLabel();
  public JLabel lblAlarmmarkeWert = new JLabel();
  public JLabel lblAktion = new JLabel();
  public JLabel lblName = new JLabel();
  public JLabel lblStatus = new JLabel();
  public RE_ComboBox cboTyp = new RE_ComboBox();
  public RE_ComboBox cboAktion = new RE_ComboBox();
  public RE_ComboBox cboStatus = new RE_ComboBox();
  public RE_TextField txtName = new RE_TextField(20);
  public JButton butKalibrier = new JButton();
  public RE_RadioButton rbtOben = new RE_RadioButton();
  public RE_RadioButton rbtUnten = new RE_RadioButton();
  public ButtonGroup butGroupAusrichtung = new ButtonGroup();
  public RE_Slider sliAlarmmarke = new RE_Slider();
  public JProgressBar pgbAlarmMarke = new JProgressBar();
  public StatusListener staLis = new StatusListener();
  public RE_ActionListener actLis = new RE_ActionListener();
  public SliListener alarmMarkeLis;
  public KalibrierListener kalLis = new KalibrierListener();
  public Daten cfg;
  public Sprache spr;
  public ComTabelle tab;
  
  public PnlKonfWasStand(Daten c, Sprache s)
  {
    cfg = c;
    spr = s;
    try
    {
      alarmMarkeLis = new SliListener(lblAlarmmarkeWert, 
        3, pgbAlarmMarke, 100, 
        0, false, spr, cfg);
      jbInit();
      setzeSprache();
    }
    catch (Exception e) {}
  }
  
  public void setzeKonfig(Daten c)
  {
    cfg = c;
  }
  
  public void setzeKalibrierLis(ComTabelle t)
  {
    tab = t;
    butKalibrier.addActionListener(kalLis);
  }
  
  public void removeKalibrierLis()
  {
    butKalibrier.removeActionListener(kalLis);
  }
  
  public void speicherEinstellung()
  {
    cfg.WASSERSTAND_NAME = txtName.getText();
    
    cfg.WASSERSTAND_STATUS = cboStatus.getSelectedIndex();
    
    cfg.WASSERSTAND_TYP = cboTyp.getSelectedIndex();
    cfg.WASSERSTAND_AKTION = cboAktion.getSelectedIndex();
    
    cfg.WASSERSTAND_OBEN = rbtOben.isSelected();
    cfg.WASSERSTAND_UNTEN = rbtUnten.isSelected();
    if (cfg.WASSERSTAND_TYP == 0) {
      cfg.WASSERSTAND_ALARMMARKE = pgbAlarmMarke.getValue();
    } else {
      cfg.WASSERSTAND_ALARMMARKE = 50;
    }
  }
  
  public void setzeEinstellung()
  {
    txtName.setText(cfg.WASSERSTAND_NAME);
    try
    {
      cboStatus.setSelectedIndex(cfg.WASSERSTAND_STATUS);
    }
    catch (Exception ex)
    {
      cboStatus.setSelectedIndex(0);
    }
    try
    {
      cboTyp.setSelectedIndex(cfg.WASSERSTAND_TYP);
    }
    catch (Exception ex)
    {
      cboTyp.setSelectedIndex(0);
    }
    try
    {
      cboAktion.setSelectedIndex(cfg.WASSERSTAND_AKTION);
    }
    catch (Exception ex)
    {
      cboAktion.setSelectedIndex(0);
    }
    rbtOben.setSelected(cfg.WASSERSTAND_OBEN);
    rbtUnten.setSelected(cfg.WASSERSTAND_UNTEN);
    
    sliAlarmmarke.setValue(cfg.WASSERSTAND_ALARMMARKE);
  }
  
  public void ladeEinstellung()
  {
    cfg.ladeLokalEinstellungenWasserStand();
  }
  
  public void ladeStandardEinstellung()
  {
    cfg.ladeLokalStandardEinstellungenWasserStand();
  }
  
  public void setzeSprache()
  {
    lblName.setText(spr.NAME);
    lblStatus.setText(spr.STATUS);
    lblTyp.setText(spr.TYP);
    lblAktion.setText(spr.AKTION_BEI_KRITISCHEM_WASSERSTAND);
    lblAusrichtung.setText(spr.AUSRICHTUNG);
    lblAlarm.setText(spr.ALARMMARKE);
    rbtOben.setText(spr.OBEN);
    rbtUnten.setText(spr.UNTEN);
    butKalibrier.setText(spr.SENSOR_JETZT_KALIBRIEREN);
    
    fuelleCombo();
    ladeEinstellung();
    setzeEinstellung();
    setzeListener();
    aktualisiere();
  }
  
  public void fuelleCombo()
  {
    cboStatus.removeAllItems();
    cboStatus.addItems(
      new String[] { spr.INAKTIV, spr.NICHT_VORHANDEN, 
      spr.AKTIV });
    
    cboTyp.removeAllItems();
    cboTyp.addItems(
      new String[] { spr.ANALOGSENSOR, spr.SCHWIMMSCHALTER });
    
    cboAktion.removeAllItems();
    cboAktion.addItems(
      new String[] { spr.KEINE, spr.WARNUNG, spr.ALARM, 
      spr.NOT_AUS });
  }
  
  public void setzeListener()
  {
    cboStatus.addActionListener(staLis);
    cboTyp.addActionListener(actLis);
    sliAlarmmarke.addChangeListener(alarmMarkeLis);
  }
  
  public void removeListener()
  {
    cboStatus.removeActionListener(staLis);
    cboTyp.removeActionListener(actLis);
    sliAlarmmarke.removeChangeListener(alarmMarkeLis);
  }
  
  public void aktualisiere()
  {
    cboTyp.aktualisiere();
    cboAktion.aktualisiere();
    cboStatus.aktualisiere();
    
    rbtOben.aktualisiere();
    rbtUnten.aktualisiere();
    
    sliAlarmmarke.aktualisiere();
  }
  
  public void jbInit()
    throws Exception
  {
    lblName.setBounds(new Rectangle(15, 20, 34, 14));
    lblStatus.setBounds(new Rectangle(15, 50, 34, 14));
    lblTyp.setBounds(new Rectangle(15, 80, 34, 15));
    lblAktion.setBounds(new Rectangle(15, 110, 176, 15));
    lblAusrichtung.setBounds(new Rectangle(15, 140, 82, 15));
    lblAlarm.setBounds(new Rectangle(15, 170, 90, 15));
    lblAlarmmarkeWert.setBounds(new Rectangle(90, 170, 40, 15));
    lblAlarmmarkeWert.setBorder(BorderFactory.createEtchedBorder());
    
    cboStatus.setBounds(new Rectangle(90, 47, 139, 22));
    cboTyp.setBounds(new Rectangle(90, 77, 248, 21));
    cboAktion.setBounds(new Rectangle(200, 107, 139, 21));
    
    txtName.setBounds(new Rectangle(90, 17, 142, 20));
    
    rbtOben.setActionCommand(spr.OBEN);
    rbtOben.setBounds(new Rectangle(80, 137, 63, 23));
    rbtUnten.setActionCommand(spr.UNTEN);
    rbtUnten.setBounds(new Rectangle(150, 137, 91, 23));
    
    butGroupAusrichtung.add(rbtOben);
    butGroupAusrichtung.add(rbtUnten);
    
    butKalibrier.setBounds(new Rectangle(15, 370, 333, 37));
    
    sliAlarmmarke.setOrientation(1);
    sliAlarmmarke.setBounds(new Rectangle(130, 185, 28, 140));
    
    pgbAlarmMarke.setOrientation(1);
    pgbAlarmMarke.setBounds(new Rectangle(90, 185, 40, 140));
    
    setLayout(null);
    add(lblTyp);
    add(cboTyp);
    add(lblAktion);
    add(cboAktion);
    add(lblAusrichtung);
    add(rbtOben);
    add(rbtUnten);
    add(lblAlarm);
    add(lblAlarmmarkeWert);
    add(pgbAlarmMarke);
    add(sliAlarmmarke);
    add(butKalibrier);
    add(lblName);
    add(txtName);
    add(lblStatus);
    add(cboStatus);
  }
  
  public void ladeKonfig()
  {
    ladenAktiv = true;
    
    removeListener();
    
    setzeSprache();
    ladenAktiv = false;
  }
  
  public class KalibrierListener
    implements ActionListener
  {
    public KalibrierListener() {}
    
    public void actionPerformed(ActionEvent e)
    {
      tab.setzeSchreiben(ComTabelle.getAdresse(4, true, false), 
        new int[] { 0, 0, 0, 0, 0, 0, 1, 255, 255, 
        cfg.DISPLAY_HELLIGKEIT });
      try
      {
        tab.starteRamSchreiben();
      }
      catch (Exception e1) {}
    }
  }
  
  public class StatusListener
    implements ActionListener
  {
    public StatusListener() {}
    
    public void actionPerformed(ActionEvent e)
    {
      RE_ComboBox combo = (RE_ComboBox)e.getSource();
      switch (combo.getSelectedIndex())
      {
      case 0: 
      case 1: 
        lblAusrichtung.setVisible(false);
        lblAlarm.setVisible(false);
        lblAlarmmarkeWert.setVisible(false);
        
        cboTyp.setEnabled(false);
        cboAktion.setEnabled(false);
        
        rbtOben.setVisible(false);
        rbtUnten.setVisible(false);
        butKalibrier.setVisible(false);
        
        sliAlarmmarke.setVisible(false);
        pgbAlarmMarke.setVisible(false);
        break;
      case 2: 
        lblAusrichtung.setVisible(true);
        lblAlarm.setVisible(true);
        lblAlarmmarkeWert.setVisible(true);
        
        cboTyp.setEnabled(true);
        cboAktion.setEnabled(true);
        
        rbtOben.setVisible(true);
        rbtUnten.setVisible(true);
        butKalibrier.setVisible(true);
        
        sliAlarmmarke.setVisible(true);
        pgbAlarmMarke.setVisible(true);
        cboTyp.aktualisiere();
      }
    }
  }
  
  public class RE_ActionListener
    implements ActionListener
  {
    public RE_ActionListener() {}
    
    public void actionPerformed(ActionEvent e)
    {
      RE_ComboBox combo = (RE_ComboBox)e.getSource();
      switch (combo.getSelectedIndex())
      {
      case 0: 
        lblAusrichtung.setVisible(true);
        lblAlarm.setVisible(true);
        lblAlarmmarkeWert.setVisible(true);
        
        cboAktion.setEnabled(true);
        
        rbtOben.setVisible(true);
        rbtUnten.setVisible(true);
        butKalibrier.setVisible(true);
        
        sliAlarmmarke.setVisible(true);
        pgbAlarmMarke.setVisible(true);
        
        break;
      case 1: 
        lblAusrichtung.setVisible(true);
        lblAlarm.setVisible(false);
        lblAlarmmarkeWert.setVisible(false);
        
        cboAktion.setEnabled(true);
        
        rbtOben.setVisible(true);
        rbtUnten.setVisible(true);
        butKalibrier.setVisible(false);
        
        sliAlarmmarke.setVisible(false);
        pgbAlarmMarke.setVisible(false);
      }
    }
  }
}

