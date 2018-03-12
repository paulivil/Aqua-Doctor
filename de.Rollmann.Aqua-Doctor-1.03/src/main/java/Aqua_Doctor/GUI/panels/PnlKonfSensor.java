package Aqua_Doctor.GUI.panels;

import Aqua_Doctor.listener.SliListener;
import Aqua_Doctor.ressource.Daten;
import Aqua_Doctor.ressource.Sprache;
import de.Rollmann.komponenten.RE_ComboBox;
import de.Rollmann.komponenten.RE_Slider;
import de.Rollmann.komponenten.RE_TextField;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.TitledBorder;

public class PnlKonfSensor
  extends KonfigPanel
{
  public JLabel lblSensor = new JLabel();
  public JLabel lblBezeichnung = new JLabel();
  public JLabel lblStatus = new JLabel();
  public JLabel lblNotAusStatus = new JLabel();
  public JLabel lblTyp = new JLabel();
  public JLabel lblKorrektur = new JLabel();
  public JLabel lblKorrekturWert = new JLabel();
  public JLabel lblMaster = new JLabel();
  public JLabel lblWarnwert = new JLabel();
  public JLabel lblWarnung = new JLabel();
  public JLabel lblAlarm = new JLabel();
  public JLabel lblAlarmWert = new JLabel();
  public JLabel lblNotAus = new JLabel();
  public JLabel lblNotAusWert = new JLabel();
  public RE_TextField txtBezeichnung = new RE_TextField(20);
  public RE_ComboBox cboSensor = new RE_ComboBox();
  public RE_ComboBox cboStatus = new RE_ComboBox();
  public RE_ComboBox cboTyp = new RE_ComboBox();
  public RE_ComboBox cboMaster = new RE_ComboBox();
  public RE_Slider sliKorrektur = new RE_Slider(50, 150);
  public RE_Slider sliWarnung = new RE_Slider(0, 1000);
  public RE_Slider sliAlarm = new RE_Slider(0, 1000);
  public RE_Slider sliNotAus = new RE_Slider(0, 1000);
  public JButton butUebernahme = new JButton();
  public JPanel pnlWerte = new JPanel();
  public JPanel pnlEinstellung = new JPanel();
  public TitledBorder tbrNTC = new TitledBorder("");
  public TitledBorder tbrEin = new TitledBorder("");
  public NotAuslistener notAusLis = new NotAuslistener();
  public SensorWahlListener senLis = new SensorWahlListener();
  public RE_ComboListener comLis = new RE_ComboListener();
  public SliListener warnLis;
  public SliListener alarmLis;
  public SliListener notLis;
  public SliListener korrekturLis;
  public ButtonListener butLis = new ButtonListener();
  public Daten cfg;
  public Sprache spr;
  RE_ComboBox cboNotAus = new RE_ComboBox();
  
  public PnlKonfSensor(Daten c, Sprache s)
  {
    cfg = c;
    spr = s;
    try
    {
      warnLis = new SliListener(lblWarnwert, 
        2, sliAlarm, 
        990, 0, false, false, spr, cfg);
      alarmLis = new SliListener(lblAlarmWert, 
        2, sliNotAus, 
        995, 0, false, false, spr, cfg);
      notLis = new SliListener(lblNotAusWert, 
        2, 1000, 0, false, spr, cfg);
      korrekturLis = new SliListener(lblKorrekturWert, 
        13, 150, 50, false, 
        spr, cfg);
      
      jbInit();
      setzeSprache();
    }
    catch (Exception localException) {}
  }
  
  public void setzeKonfig(Daten c)
  {
    cfg = c;
  }
  
  public void fuelleCombo()
  {
    cboSensor.removeAllItems();
    cboSensor.addItems(
      new String[] { spr.SENSOR1, spr.SENSOR2, 
      spr.SENSOR3, spr.SENSOR4, spr.SENSOR5, 
      spr.SENSOR6 });
    
    cboStatus.removeAllItems();
    cboStatus.addItems(
      new String[] { spr.AUS, spr.NICHT_VORHANDEN, 
      spr.AN });
    
    cboTyp.removeAllItems();
    cboTyp.addItems(
      new String[] { spr.ANALOG, spr.DIGITAL });
    
    cboMaster.removeAllItems();
    cboMaster.addItems(
      new String[] { spr.STANDARD, spr.EIGENER });
    
    cboNotAus.removeAllItems();
    cboNotAus.addItems(
      new String[] { spr.AUS, spr.AN });
  }
  
  public void setzeSprache()
  {
    lblSensor.setText(spr.SENSOR);
    lblBezeichnung.setText(spr.BEZEICHNUNG);
    lblStatus.setText(spr.STATUS);
    lblNotAusStatus.setText(spr.NOT_AUS);
    lblTyp.setText(spr.TYP);
    lblKorrektur.setText(spr.KORREKTUR_WERT);
    lblMaster.setText(spr.NTC_TABELLE);
    lblWarnung.setText(spr.WARNUNG);
    lblAlarm.setText(spr.ALARM);
    lblNotAus.setText(spr.NOT_AUS);
    
    butUebernahme.setText(spr.EINSTELLUNG_UEBERTRAGEN);
    tbrNTC.setTitle(spr.TEMPERATUR_WERTE);
    tbrEin.setTitle(spr.EINSTELLUNG);
    
    fuelleCombo();
    ladeEinstellung();
    setzeEinstellung();
    setzeListener();
    aktualisiere();
  }
  
  public void ladeEinstellung() {}
  
  public void ladeStandardEinstellung()
  {
    cfg.ladeLokalStandardEinstellungenSensor();
  }
  
  public void setzeEinstellung()
  {
    try
    {
      cboSensor.setSelectedIndex(cfg.SENSOR_AUSWAHL);
    }
    catch (Exception ex)
    {
      cboSensor.setSelectedIndex(0);
    }
    txtBezeichnung.setText(cfg.SENSOR_NAME[cfg.SENSOR_AUSWAHL]);
    try
    {
      cboStatus.setSelectedIndex(cfg.SENSOR_STATUS[cfg.SENSOR_AUSWAHL]);
    }
    catch (Exception ex)
    {
      cboStatus.setSelectedIndex(0);
    }
    try
    {
      cboTyp.setSelectedIndex(cfg.SENSOR_TYP[cfg.SENSOR_AUSWAHL]);
    }
    catch (Exception ex)
    {
      cboTyp.setSelectedIndex(0);
    }
    sliKorrektur.setValue(cfg.SENSOR_KORREKTUR[cfg.SENSOR_AUSWAHL]);
    try
    {
      cboMaster.setSelectedIndex(cfg.SENSOR_NTCTABELLE[cfg.SENSOR_AUSWAHL]);
    }
    catch (Exception ex)
    {
      cboMaster.setSelectedIndex(0);
    }
    cboNotAus.setSelectedIndex(cfg.SENSOR_NOTAUS[cfg.SENSOR_AUSWAHL]);
    
    sliWarnung.setValue(cfg.SENSOR_WARNWERT[cfg.SENSOR_AUSWAHL]);
    sliAlarm.setValue(cfg.SENSOR_ALARMWERT[cfg.SENSOR_AUSWAHL]);
    if (cfg.SENSOR_NOTAUS[cfg.SENSOR_AUSWAHL] == 0)
    {
      sliNotAus.setVisible(false);
      lblNotAus.setVisible(false);
      lblNotAusWert.setVisible(false);
    }
    sliNotAus.setValue(cfg.SENSOR_NOTAUSWERT[cfg.SENSOR_AUSWAHL]);
  }
  
  public void speicherEinstellung()
  {
    cfg.SENSOR_NAME[cfg.SENSOR_AUSWAHL] = txtBezeichnung.getText();
    
    cfg.SENSOR_STATUS[cfg.SENSOR_AUSWAHL] = cboStatus.getSelectedIndex();
    
    cfg.SENSOR_TYP[cfg.SENSOR_AUSWAHL] = cboTyp.getSelectedIndex();
    cfg.SENSOR_KORREKTUR[cfg.SENSOR_AUSWAHL] = sliKorrektur.getValue();
    cfg.SENSOR_NTCTABELLE[cfg.SENSOR_AUSWAHL] = 
      cboMaster.getSelectedIndex();
    
    cfg.SENSOR_NOTAUS[cfg.SENSOR_AUSWAHL] = cboNotAus.getSelectedIndex();
    
    cfg.SENSOR_WARNWERT[cfg.SENSOR_AUSWAHL] = sliWarnung.getValue();
    cfg.SENSOR_ALARMWERT[cfg.SENSOR_AUSWAHL] = sliAlarm.getValue();
    cfg.SENSOR_NOTAUSWERT[cfg.SENSOR_AUSWAHL] = sliNotAus.getValue();
  }
  
  public void setzeListener()
  {
    cboSensor.addActionListener(senLis);
    cboStatus.addActionListener(comLis);
    
    cboNotAus.addActionListener(notAusLis);
    
    sliWarnung.addChangeListener(warnLis);
    sliAlarm.addChangeListener(alarmLis);
    sliNotAus.addChangeListener(notLis);
    sliKorrektur.addChangeListener(korrekturLis);
    butUebernahme.addActionListener(butLis);
  }
  
  public void removeListener()
  {
    cboSensor.removeActionListener(senLis);
    cboStatus.removeActionListener(comLis);
    
    cboNotAus.removeActionListener(notAusLis);
    
    sliWarnung.removeChangeListener(warnLis);
    sliAlarm.removeChangeListener(alarmLis);
    sliNotAus.removeChangeListener(notLis);
    sliKorrektur.removeChangeListener(korrekturLis);
    butUebernahme.removeActionListener(butLis);
  }
  
  public void aktualisiere()
  {
    cboStatus.aktualisiere();
    cboTyp.aktualisiere();
    cboMaster.aktualisiere();
    
    cboNotAus.aktualisiere();
    
    sliKorrektur.setValue(cfg.SENSOR_KORREKTUR[cfg.SENSOR_AUSWAHL]);
    sliWarnung.setValue(cfg.SENSOR_WARNWERT[cfg.SENSOR_AUSWAHL]);
    sliAlarm.setValue(cfg.SENSOR_ALARMWERT[cfg.SENSOR_AUSWAHL]);
    sliNotAus.setValue(cfg.SENSOR_NOTAUSWERT[cfg.SENSOR_AUSWAHL]);
    
    sliKorrektur.aktualisiere();
    sliWarnung.aktualisiere();
    sliAlarm.aktualisiere();
    sliNotAus.aktualisiere();
  }
  
  public void ueberTrageNTCEinstellung()
  {
    int Typ = cboTyp.getSelectedIndex();
    int Korrektur = sliKorrektur.getValue();
    int NTCTabelle = cboMaster.getSelectedIndex();
    for (int i = 0; i < 6; i++)
    {
      cfg.SENSOR_TYP[i] = Typ;
      cfg.SENSOR_KORREKTUR[i] = Korrektur;
      cfg.SENSOR_NTCTABELLE[i] = NTCTabelle;
    }
  }
  
  public void jbInit()
    throws Exception
  {
    lblSensor.setBounds(new Rectangle(15, 20, 55, 15));
    lblBezeichnung.setBounds(new Rectangle(15, 50, 73, 15));
    lblStatus.setBounds(new Rectangle(15, 80, 34, 15));
    lblNotAusStatus.setBounds(new Rectangle(15, 110, 55, 15));
    lblTyp.setBounds(new Rectangle(11, 25, 55, 15));
    lblKorrektur.setBounds(new Rectangle(11, 55, 101, 15));
    lblKorrekturWert.setBorder(BorderFactory.createEtchedBorder());
    lblKorrekturWert.setBounds(new Rectangle(121, 55, 51, 16));
    lblMaster.setBounds(new Rectangle(11, 85, 97, 15));
    lblWarnung.setBounds(new Rectangle(27, 34, 54, 15));
    lblWarnwert.setBorder(BorderFactory.createEtchedBorder());
    lblWarnwert.setBounds(new Rectangle(92, 34, 50, 15));
    lblAlarm.setBounds(new Rectangle(27, 74, 34, 15));
    lblAlarmWert.setBorder(BorderFactory.createEtchedBorder());
    lblAlarmWert.setBounds(new Rectangle(92, 74, 50, 15));
    lblNotAus.setBounds(new Rectangle(27, 114, 55, 15));
    lblNotAusWert.setBorder(BorderFactory.createEtchedBorder());
    lblNotAusWert.setBounds(new Rectangle(92, 114, 50, 15));
    
    txtBezeichnung.setBounds(new Rectangle(120, 47, 140, 21));
    
    cboSensor.setBounds(new Rectangle(120, 17, 140, 21));
    cboStatus.setBounds(new Rectangle(120, 77, 140, 21));
    cboTyp.setBounds(new Rectangle(116, 22, 140, 21));
    
    cboMaster.setBounds(new Rectangle(116, 82, 140, 21));
    
    butUebernahme.setBounds(new Rectangle(11, 118, 248, 25));
    cboNotAus.setBounds(new Rectangle(120, 107, 140, 22));
    
    sliKorrektur.setBounds(new Rectangle(180, 52, 200, 24));
    
    sliWarnung.setBounds(new Rectangle(152, 29, 200, 24));
    sliWarnung.setValue(0);
    
    sliAlarm.setBounds(new Rectangle(152, 69, 200, 24));
    sliAlarm.setValue(1);
    
    sliNotAus.setBounds(new Rectangle(152, 109, 200, 24));
    sliNotAus.setValue(2);
    
    pnlWerte.setBorder(tbrNTC);
    pnlWerte.setBounds(new Rectangle(9, 311, 399, 166));
    pnlWerte.setLayout(null);
    pnlWerte.add(sliWarnung);
    pnlWerte.add(lblWarnwert);
    pnlWerte.add(lblWarnung);
    pnlWerte.add(lblAlarm);
    pnlWerte.add(lblAlarmWert);
    pnlWerte.add(sliAlarm);
    pnlWerte.add(sliNotAus);
    pnlWerte.add(lblNotAusWert);
    pnlWerte.add(lblNotAus);
    pnlEinstellung.add(lblTyp);
    pnlEinstellung.add(cboTyp);
    pnlEinstellung.add(lblKorrektur);
    
    pnlEinstellung.add(lblMaster);
    pnlEinstellung.add(cboMaster);
    
    pnlEinstellung.add(butUebernahme);
    pnlEinstellung.add(lblKorrekturWert);
    pnlEinstellung.add(sliKorrektur);
    pnlEinstellung.setBorder(tbrEin);
    pnlEinstellung.setBounds(new Rectangle(11, 143, 397, 159));
    pnlEinstellung.setLayout(null);
    
    add(pnlEinstellung);
    setLayout(null);
    add(lblSensor);
    add(lblBezeichnung);
    add(cboSensor);
    add(txtBezeichnung);
    add(lblStatus);
    add(cboStatus);
    add(lblNotAusStatus);
    
    add(pnlWerte);
    add(cboNotAus);
  }
  
  public void ladeKonfig()
  {
    ladenAktiv = true;
    
    removeListener();
    
    setzeSprache();
    ladenAktiv = false;
  }
  
  public class NotAuslistener
    implements ActionListener
  {
    public NotAuslistener() {}
    
    public void actionPerformed(ActionEvent e)
    {
      RE_ComboBox combo = (RE_ComboBox)e.getSource();
      if (combo.isEnabled()) {
        switch (combo.getSelectedIndex())
        {
        case 0: 
          sliNotAus.setEnabled(false);
          sliNotAus.setVisible(false);
          lblNotAus.setVisible(false);
          lblNotAusWert.setVisible(false);
          break;
        case 1: 
          sliNotAus.setEnabled(true);
          sliNotAus.setVisible(true);
          lblNotAus.setVisible(true);
          lblNotAusWert.setVisible(true);
        }
      }
    }
  }
  
  public class RE_ComboListener
    implements ActionListener
  {
    public RE_ComboListener() {}
    
    public void actionPerformed(ActionEvent e)
    {
      RE_ComboBox combo = (RE_ComboBox)e.getSource();
      if ((combo.getSelectedIndex() == 0) || 
        (combo.getSelectedIndex() == 1))
      {
        cboTyp.setEnabled(false);
        sliKorrektur.setEnabled(false);
        cboMaster.setEnabled(false);
        
        cboNotAus.setEnabled(false);
        
        sliWarnung.setEnabled(false);
        sliAlarm.setEnabled(false);
        sliNotAus.setEnabled(false);
        
        butUebernahme.setEnabled(false);
      }
      else
      {
        cboTyp.setEnabled(true);
        sliKorrektur.setEnabled(true);
        cboMaster.setEnabled(true);
        
        cboNotAus.setEnabled(true);
        
        sliWarnung.setEnabled(true);
        sliAlarm.setEnabled(true);
        sliNotAus.setEnabled(true);
        
        butUebernahme.setEnabled(true);
      }
    }
  }
  
  public class SensorWahlListener
    implements ActionListener
  {
    public SensorWahlListener() {}
    
    public void actionPerformed(ActionEvent e)
    {
      RE_ComboBox combo = (RE_ComboBox)e.getSource();
      
      combo.aktualisiereAltNeu();
      
      cfg.SENSOR_AUSWAHL = combo.getOldSelectedIndex();
      speicherEinstellung();
      cfg.SENSOR_AUSWAHL = combo.getSelectedIndex();
      removeListener();
      setzeSprache();
    }
  }
  
  public class ButtonListener
    implements ActionListener
  {
    public ButtonListener() {}
    
    public void actionPerformed(ActionEvent e)
    {
      if (JOptionPane.showConfirmDialog((JButton)e.getSource(), 
        spr.FRAGE_SENSOR_DATEN_UEBERTRAGEN, 
        spr.TITEL_EINSTELLUNGEN_UEBERNEHMEN, 
        0, 
        3) == 0)
      {
        ueberTrageNTCEinstellung();
        JOptionPane.showMessageDialog((JButton)e.getSource(), 
          spr.INFO_SENSOR_DATEN_UEBERTRAGEN, 
          spr.TITEL_EINSTELLUNGEN_UEBERNEHMEN, 
          1);
      }
    }
  }
}