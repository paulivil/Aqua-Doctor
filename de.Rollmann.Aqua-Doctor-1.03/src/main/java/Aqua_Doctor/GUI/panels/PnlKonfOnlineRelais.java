package Aqua_Doctor.GUI.panels;

import Aqua_Doctor.listener.SliListener;
import Aqua_Doctor.ressource.Daten;
import Aqua_Doctor.ressource.Sprache;
import de.Rollmann.komponenten.RE_CheckBox;
import de.Rollmann.komponenten.RE_ComboBox;
import de.Rollmann.komponenten.RE_Panel;
import de.Rollmann.komponenten.RE_RadioButton;
import de.Rollmann.komponenten.RE_Slider;
import de.Rollmann.komponenten.RE_TextField;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.TitledBorder;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class PnlKonfOnlineRelais
  extends KonfigPanel
{
  public JLabel lblRelais = new JLabel();
  public JLabel lblBezRelais = new JLabel();
  public JLabel lblNachlaufWert = new JLabel();
  public JLabel lblEin = new JLabel();
  public JLabel lblInter = new JLabel();
  public JLabel lblDauer = new JLabel();
  public JLabel lblDauerWert = new JLabel();
  public JLabel lblSensor = new JLabel();
  public JLabel lblTemp = new JLabel();
  public JLabel lblTempWert = new JLabel();
  public JLabel lblRichtung = new JLabel();
  public JLabel lblTaster = new JLabel();
  public JLabel lblFunktion = new JLabel();
  public JLabel lblTagDat = new JLabel();
  public RE_TextField txtBezRelais = new RE_TextField(20);
  public RE_ComboBox cboRelais = new RE_ComboBox();
  public RE_ComboBox cboSensor1 = new RE_ComboBox();
  public RE_ComboBox cboSensor2 = new RE_ComboBox();
  public RE_ComboBox cboTaster = new RE_ComboBox();
  public RE_ComboBox cboFunktion = new RE_ComboBox();
  public RE_CheckBox chkTempschalter = new RE_CheckBox();
  public RE_CheckBox chkNachlauf = new RE_CheckBox();
  public RE_CheckBox chkSoftSchalter = new RE_CheckBox();
  public RE_CheckBox chkRelais1 = new RE_CheckBox();
  public RE_CheckBox chkRelais2 = new RE_CheckBox();
  public RE_CheckBox chkRelais3 = new RE_CheckBox();
  public RE_RadioButton rbtUeber = new RE_RadioButton();
  public RE_RadioButton rbtUnter = new RE_RadioButton();
  public RE_RadioButton rbtRelais3 = new RE_RadioButton();
  public RE_RadioButton rbtRelais2 = new RE_RadioButton();
  public RE_RadioButton rbtRelais1 = new RE_RadioButton();
  public ButtonGroup butGrpRelTyp = new ButtonGroup();
  public ButtonGroup butGrpRelKonf = new ButtonGroup();
  public ButtonGroup butGroupRicht = new ButtonGroup();
  public RE_Slider sliNachlauf = new RE_Slider(0, 255);
  public RE_Slider sliTemp = new RE_Slider(0, 1000);
  public JPanel pnlTyp = new JPanel();
  public JPanel pnlTaster = new JPanel();
  public RE_Panel pnlTemp = new RE_Panel();
  public RE_Panel pnlRelKonf = new RE_Panel();
  public TitledBorder tbrRelais = new TitledBorder("");
  public TitledBorder tbrTimer = new TitledBorder("");
  public TitledBorder tbrTemp = new TitledBorder("");
  public TitledBorder tbrTaster = new TitledBorder("");
  public TitledBorder tbrTyp = new TitledBorder("");
  public TitledBorder tbrRelKonf = new TitledBorder("");
  public RelaisAuswahlListener relLis = new RelaisAuswahlListener();
  public TasterAuswahlListener tasLis = new TasterAuswahlListener();
  public NachlaufChangeListener nachLis = new NachlaufChangeListener();
  public Funktion2Listener fun2Lis = new Funktion2Listener();
  public RadioButtonListener rbtLis = new RadioButtonListener();
  public RelKonfListener rbtRelKonfLis = new RelKonfListener();
  public SliListener tempSliLis;
  public SliListener nachSliLis;
  public Daten cfg;
  public Sprache spr;
  
  public PnlKonfOnlineRelais(Daten c, Sprache s)
  {
    cfg = c;
    spr = s;
    try
    {
      tempSliLis = new SliListener(lblTempWert, 
        2, 
        1000, 0, false, spr, cfg);
      nachSliLis = new SliListener(lblNachlaufWert, 
        1, 
        255, 0, false, spr, cfg);
      
      jbInit();
      setzeSprache();
    }
    catch (Exception localException) {}
  }
  
  public void setzeKonfig(Daten c)
  {
    cfg = c;
  }
  
  public void setzeEinstellung()
  {
    try
    {
      cboTaster.setSelectedIndex(cfg.ONLINE_TASTER_AUSWAHL);
    }
    catch (Exception ex)
    {
      cboTaster.setSelectedIndex(0);
    }
    try
    {
      cboRelais.setSelectedIndex(cfg.ONLINE_RELAIS_AUSWAHL);
    }
    catch (Exception ex)
    {
      cboRelais.setSelectedIndex(0);
    }
    txtBezRelais.setText(cfg.ONLINE_RELAIS_NAME[cfg.ONLINE_RELAIS_AUSWAHL]);
    try
    {
      cboSensor1.setSelectedIndex(cfg.ONLINE_SENSOR1_WAHL[
        cfg.ONLINE_RELAIS_AUSWAHL]);
    }
    catch (Exception ex)
    {
      cboSensor1.setSelectedIndex(0);
    }
    try
    {
      cboSensor2.setSelectedIndex(cfg.ONLINE_SENSOR2_WAHL[
        cfg.ONLINE_RELAIS_AUSWAHL]);
    }
    catch (Exception ex)
    {
      cboSensor2.setSelectedIndex(0);
    }
    try
    {
      cboFunktion.setSelectedIndex(cfg.ONLINE_TASTER_FUNKTION[
        cfg.ONLINE_TASTER_AUSWAHL]);
    }
    catch (Exception ex)
    {
      cboFunktion.setSelectedIndex(0);
    }
    chkRelais1.setSelected(cfg.ONLINE_TASTER_RELAIS[cfg.ONLINE_TASTER_AUSWAHL][
      0]);
    chkRelais2.setSelected(cfg.ONLINE_TASTER_RELAIS[cfg.ONLINE_TASTER_AUSWAHL][
      1]);
    chkRelais3.setSelected(cfg.ONLINE_TASTER_RELAIS[cfg.ONLINE_TASTER_AUSWAHL][
      2]);
    
    chkTempschalter.setSelected(cfg.ONLINE_TEMPERATUR_SCHALTER[
      cfg.ONLINE_RELAIS_AUSWAHL]);
    
    chkNachlauf.setSelected(cfg.ONLINE_NACHLAUF[cfg.ONLINE_RELAIS_KONF_AUSWAHL][
      cfg.ONLINE_TASTER_AUSWAHL]);
    
    chkSoftSchalter.setSelected(cfg.ONLINE_SCHALTBAR_UEBER_SOFTWARE[
      cfg.ONLINE_RELAIS_KONF_AUSWAHL][
      cfg.ONLINE_TASTER_AUSWAHL]);
    
    sliNachlauf.setValue(cfg.ONLINE_NACHLAUF_WERT[
      cfg.ONLINE_RELAIS_KONF_AUSWAHL][cfg.ONLINE_TASTER_AUSWAHL]);
    
    sliTemp.setValue(cfg.ONLINE_SCHALTTEMPERATUR[
      cfg.ONLINE_RELAIS_AUSWAHL]);
    
    rbtUeber.setSelected(cfg.ONLINE_UEBERSCHREITEN[
      cfg.ONLINE_RELAIS_AUSWAHL]);
    rbtUnter.setSelected(cfg.ONLINE_UNTERSCHREITEN[
      cfg.ONLINE_RELAIS_AUSWAHL]);
  }
  
  public void ladeEinstellung() {}
  
  public void speicherEinstellung()
  {
    cfg.ONLINE_RELAIS_NAME[cfg.ONLINE_RELAIS_AUSWAHL] = txtBezRelais.getText();
    
    cfg.ONLINE_TEMPERATUR_SCHALTER[cfg.ONLINE_RELAIS_AUSWAHL] = 
      chkTempschalter.isSelected();
    
    cfg.ONLINE_NACHLAUF[cfg.ONLINE_RELAIS_KONF_AUSWAHL][
      cfg.ONLINE_TASTER_AUSWAHL] = 
      chkNachlauf.isSelected();
    
    cfg.ONLINE_NACHLAUF_WERT[cfg.ONLINE_RELAIS_KONF_AUSWAHL][
      cfg.ONLINE_TASTER_AUSWAHL] = 
      sliNachlauf.getValue();
    
    cfg.ONLINE_SCHALTBAR_UEBER_SOFTWARE[cfg.ONLINE_RELAIS_KONF_AUSWAHL][
      cfg.ONLINE_TASTER_AUSWAHL] = 
      chkSoftSchalter.isSelected();
    
    cfg.ONLINE_SENSOR1_WAHL[
      cfg.ONLINE_RELAIS_AUSWAHL] = cboSensor1.getSelectedIndex();
    cfg.ONLINE_SENSOR2_WAHL[
      cfg.ONLINE_RELAIS_AUSWAHL] = cboSensor2.getSelectedIndex();
    
    cfg.ONLINE_SCHALTTEMPERATUR[
      cfg.ONLINE_RELAIS_AUSWAHL] = sliTemp.getValue();
    
    cfg.ONLINE_UEBERSCHREITEN[
      cfg.ONLINE_RELAIS_AUSWAHL] = rbtUeber.isSelected();
    
    cfg.ONLINE_UNTERSCHREITEN[
      cfg.ONLINE_RELAIS_AUSWAHL] = rbtUnter.isSelected();
    
    cfg.ONLINE_TASTER_FUNKTION[
      cfg.ONLINE_TASTER_AUSWAHL] = cboFunktion.getSelectedIndex();
    
    cfg.ONLINE_TASTER_RELAIS[cfg.ONLINE_TASTER_AUSWAHL][0] = 
      chkRelais1.isSelected();
    cfg.ONLINE_TASTER_RELAIS[cfg.ONLINE_TASTER_AUSWAHL][1] = 
      chkRelais2.isSelected();
    cfg.ONLINE_TASTER_RELAIS[cfg.ONLINE_TASTER_AUSWAHL][2] = 
      chkRelais3.isSelected();
  }
  
  public void ladeStandardEinstellung()
  {
    cfg.ladeLokalStandardEinstellungenOnline();
  }
  
  public void setzeSprache()
  {
    lblRelais.setText(spr.RELAIS);
    lblBezRelais.setText(spr.BEZEICHNUNG);
    lblDauer.setText(spr.EINSCHALTDAUER);
    lblSensor.setText(spr.SENSOR);
    lblTemp.setText(spr.SCHALTTEMPERATUR);
    lblRichtung.setText(spr.SCHALTRICHTUNG);
    lblTaster.setText(spr.TASTER);
    lblFunktion.setText(spr.FUNKTION);
    
    rbtRelais1.setText(spr.RELAIS1);
    rbtRelais2.setText(spr.RELAIS2);
    rbtRelais3.setText(spr.RELAIS3);
    
    chkNachlauf.setText(spr.NACHLAUFZEIT);
    chkSoftSchalter.setText(spr.SCHALTBAR_UEBER_SOFTWARE);
    chkTempschalter.setText(spr.TEMPERATURSCHALTER);
    
    rbtUeber.setText(spr.UEBERSCHREITEN);
    rbtUnter.setText(spr.UNTERSCHREITEN);
    chkRelais1.setText(spr.RELAIS1);
    chkRelais2.setText(spr.RELAIS2);
    chkRelais3.setText(spr.RELAIS3);
    
    tbrRelais.setTitle(spr.RELAIS);
    tbrTimer.setTitle(spr.TIMER);
    tbrTemp.setTitle(spr.TEMPERATURSCHALTER);
    tbrTaster.setTitle(spr.TASTER);
    
    fuelleCombo();
    ladeEinstellung();
    setzeEinstellung();
    setzeListener();
    aktualisiere();
  }
  
  public void fuelleCombo()
  {
    cboRelais.removeAllItems();
    cboRelais.addItems(
      new String[] { spr.RELAIS1, spr.RELAIS2, spr.RELAIS3 });
    
    cboSensor1.removeAllItems();
    cboSensor1.addItems(cfg.SENSOR_NAME);
    
    cboSensor2.removeAllItems();
    cboSensor2.addItem(spr.KEINER);
    cboSensor2.addItems(cfg.SENSOR_NAME);
    
    cboTaster.removeAllItems();
    cboTaster.addItems(
      new String[] { spr.TASTER1, spr.TASTER2, 
      spr.TASTER3 });
    
    cboFunktion.removeAllItems();
    cboFunktion.addItems(
      new String[] { spr.RELAIS_SCHALTEN, 
      spr.BOOST_MODUS, 
      
      spr.STANDBY, 
      
      spr.NOT_AUS, 
      spr.ALLE_RELAIS_AUSSCHALTEN });
  }
  
  public void setzeListener()
  {
    cboRelais.addActionListener(relLis);
    cboTaster.addActionListener(tasLis);
    chkNachlauf.addChangeListener(nachLis);
    cboFunktion.addActionListener(fun2Lis);
    
    rbtRelais1.addActionListener(rbtRelKonfLis);
    rbtRelais2.addActionListener(rbtRelKonfLis);
    rbtRelais3.addActionListener(rbtRelKonfLis);
    
    chkTempschalter.addActionListener(rbtLis);
    
    sliTemp.addChangeListener(tempSliLis);
    sliNachlauf.addChangeListener(nachSliLis);
  }
  
  public void removeListener()
  {
    cboRelais.removeActionListener(relLis);
    cboTaster.removeActionListener(tasLis);
    chkNachlauf.removeChangeListener(nachLis);
    cboFunktion.removeActionListener(fun2Lis);
    
    rbtRelais1.removeActionListener(rbtRelKonfLis);
    rbtRelais2.removeActionListener(rbtRelKonfLis);
    rbtRelais3.removeActionListener(rbtRelKonfLis);
    
    chkTempschalter.removeActionListener(rbtLis);
    
    sliTemp.removeChangeListener(tempSliLis);
    sliNachlauf.removeChangeListener(nachSliLis);
  }
  
  public void aktualisiere()
  {
    cboRelais.aktualisiere();
    cboTaster.aktualisiere();
    cboFunktion.aktualisiere();
    
    chkNachlauf.aktualisiere();
    chkSoftSchalter.aktualisiere();
    
    rbtUeber.aktualisiere();
    rbtUnter.aktualisiere();
    
    chkTempschalter.aktualisiere();
    
    sliNachlauf.aktualisiere();
    sliTemp.aktualisiere();
  }
  
  public void jbInit()
    throws Exception
  {
    lblRelais.setBounds(new Rectangle(14, 22, 67, 15));
    lblBezRelais.setBounds(new Rectangle(14, 56, 80, 15));
    lblNachlaufWert.setBorder(BorderFactory.createEtchedBorder());
    lblNachlaufWert.setBounds(new Rectangle(126, 82, 50, 15));
    
    lblEin.setBounds(new Rectangle(15, 30, 83, 15));
    lblInter.setBounds(new Rectangle(15, 60, 87, 15));
    lblDauer.setBounds(new Rectangle(15, 90, 82, 15));
    lblDauerWert.setBorder(BorderFactory.createEtchedBorder());
    lblDauerWert.setBounds(new Rectangle(200, 90, 50, 15));
    lblTagDat.setBounds(new Rectangle(265, 60, 73, 15));
    
    lblSensor.setBounds(new Rectangle(15, 30, 44, 15));
    lblTemp.setBounds(new Rectangle(15, 60, 92, 15));
    lblTempWert.setBorder(BorderFactory.createEtchedBorder());
    lblTempWert.setBounds(new Rectangle(115, 60, 61, 15));
    lblRichtung.setBounds(new Rectangle(15, 90, 82, 15));
    
    lblTaster.setBounds(new Rectangle(15, 30, 52, 15));
    lblFunktion.setBounds(new Rectangle(15, 60, 48, 15));
    txtBezRelais.setBounds(new Rectangle(113, 52, 140, 21));
    
    cboRelais.setBounds(new Rectangle(113, 19, 140, 21));
    cboSensor1.setBounds(new Rectangle(115, 27, 140, 21));
    cboSensor2.setBounds(new Rectangle(260, 27, 140, 21));
    
    cboTaster.setBounds(new Rectangle(115, 27, 140, 21));
    cboFunktion.setBounds(new Rectangle(115, 57, 140, 21));
    
    chkNachlauf.setBounds(new Rectangle(18, 77, 94, 23));
    chkSoftSchalter.setBounds(new Rectangle(18, 41, 154, 23));
    chkRelais1.setBounds(new Rectangle(303, 25, 197, 23));
    chkRelais2.setBounds(new Rectangle(303, 57, 197, 23));
    chkRelais3.setBounds(new Rectangle(303, 90, 197, 23));
    
    chkRelais1.setActionCommand("1");
    chkRelais2.setActionCommand("2");
    chkRelais3.setActionCommand("3");
    
    rbtUeber.setBounds(new Rectangle(115, 87, 99, 23));
    rbtUnter.setBounds(new Rectangle(215, 87, 105, 23));
    pnlTyp.setBorder(tbrTyp);
    pnlTyp.setBounds(new Rectangle(12, 15, 510, 123));
    pnlTyp.setLayout(null);
    
    pnlRelKonf.setBorder(tbrRelKonf);
    pnlRelKonf.setBounds(new Rectangle(18, 122, 482, 124));
    pnlRelKonf.setLayout(null);
    rbtRelais3.setBounds(new Rectangle(325, 11, 152, 23));
    rbtRelais2.setBounds(new Rectangle(174, 11, 147, 23));
    rbtRelais1.setBounds(new Rectangle(18, 11, 153, 23));
    
    chkTempschalter.setBounds(new Rectangle(14, 83, 141, 22));
    butGrpRelKonf.add(rbtRelais3);
    butGrpRelKonf.add(rbtRelais1);
    butGrpRelKonf.add(rbtRelais2);
    butGroupRicht.add(rbtUeber);
    butGroupRicht.add(rbtUnter);
    
    rbtRelais1.setActionCommand("0");
    rbtRelais2.setActionCommand("1");
    rbtRelais3.setActionCommand("2");
    
    sliTemp.setBounds(new Rectangle(183, 56, 200, 24));
    sliNachlauf.setBounds(new Rectangle(176, 78, 200, 24));
    pnlTemp.add(lblSensor);
    pnlTemp.add(lblTemp);
    pnlTemp.add(lblTempWert);
    pnlTemp.add(lblRichtung);
    pnlTemp.add(rbtUeber);
    pnlTemp.add(rbtUnter);
    pnlTemp.add(cboSensor1);
    pnlTemp.add(cboSensor2);
    pnlTemp.add(sliTemp);
    add(pnlTaster);
    pnlTemp.setBorder(tbrTemp);
    pnlTemp.setBounds(new Rectangle(12, 144, 510, 125));
    pnlTemp.setLayout(null);
    
    pnlTaster.add(lblTaster);
    pnlTaster.add(cboTaster);
    pnlTaster.add(lblFunktion);
    pnlTaster.add(cboFunktion);
    pnlTaster.add(chkRelais1);
    pnlTaster.add(chkRelais2);
    pnlTaster.add(chkRelais3);
    pnlTaster.add(pnlRelKonf);
    
    pnlRelKonf.add(rbtRelais1);
    pnlRelKonf.add(rbtRelais3);
    pnlRelKonf.add(lblNachlaufWert);
    pnlRelKonf.add(chkNachlauf);
    pnlRelKonf.add(sliNachlauf);
    pnlRelKonf.add(rbtRelais2);
    add(pnlTemp);
    pnlTyp.add(lblRelais);
    pnlTyp.add(txtBezRelais);
    pnlTyp.add(lblBezRelais);
    pnlTyp.add(cboRelais);
    
    pnlTyp.add(chkTempschalter);
    pnlTaster.setBorder(tbrTaster);
    pnlTaster.setBounds(new Rectangle(12, 283, 510, 260));
    pnlTaster.setLayout(null);
    add(pnlTyp);
    setLayout(null);
  }
  
  public void ladeKonfig()
  {
    ladenAktiv = true;
    
    removeListener();
    
    setzeSprache();
    ladenAktiv = false;
  }
  
  public class RadioButtonListener
    implements ActionListener
  {
    public RadioButtonListener() {}
    
    public void actionPerformed(ActionEvent e)
    {
      RE_CheckBox check = (RE_CheckBox)e.getSource();
      
      pnlTemp.setEnabled(false);
      switch (cfg.ONLINE_RELAIS_AUSWAHL)
      {
      case 0: 
        if (check.isSelected())
        {
          pnlTemp.setEnabled(true);
        }
        else if (cboFunktion.getSelectedIndex() > 0)
        {
          chkRelais1.setEnabled(false);
          rbtRelais1.setEnabled(false);
        }
        else
        {
          chkRelais1.setEnabled(true);
          rbtRelais1.setEnabled(true);
        }
        break;
      case 1: 
        if (check.isSelected())
        {
          pnlTemp.setEnabled(true);
        }
        else if (cboFunktion.getSelectedIndex() > 0)
        {
          chkRelais2.setEnabled(false);
          rbtRelais2.setEnabled(false);
        }
        else
        {
          chkRelais2.setEnabled(true);
          rbtRelais2.setEnabled(true);
        }
        break;
      case 2: 
        if (check.isSelected())
        {
          pnlTemp.setEnabled(true);
        }
        else if (cboFunktion.getSelectedIndex() > 0)
        {
          chkRelais3.setEnabled(false);
          rbtRelais3.setEnabled(false);
        }
        else
        {
          chkRelais3.setEnabled(true);
          rbtRelais3.setEnabled(true);
        }
        break;
      }
    }
  }
  
  public class RelKonfListener
    implements ActionListener
  {
    public byte alteAuswahl = 0;
    public byte neueAuswahl = 0;
    
    public RelKonfListener() {}
    
    public void actionPerformed(ActionEvent e)
    {
      RE_RadioButton button = (RE_RadioButton)e.getSource();
      alteAuswahl = neueAuswahl;
      neueAuswahl = Byte.parseByte(button.getActionCommand());
      
      cfg.ONLINE_RELAIS_KONF_AUSWAHL = alteAuswahl;
      speicherEinstellung();
      
      cfg.ONLINE_RELAIS_KONF_AUSWAHL = neueAuswahl;
      removeListener();
      setzeSprache();
      switch (Integer.parseInt(button.getActionCommand()))
      {
      case 0: 
        break;
      case 1: 
        break;
      }
    }
  }
  
  public class NachlaufChangeListener
    implements ChangeListener
  {
    public NachlaufChangeListener() {}
    
    public void stateChanged(ChangeEvent e)
    {
      if (chkNachlauf.isSelected())
      {
        lblNachlaufWert.setVisible(true);
        sliNachlauf.setVisible(true);
      }
      else
      {
        lblNachlaufWert.setVisible(false);
        sliNachlauf.setVisible(false);
      }
    }
  }
  
  public class RelaisAuswahlListener
    implements ActionListener
  {
    public RelaisAuswahlListener() {}
    
    public void actionPerformed(ActionEvent e)
    {
      RE_ComboBox combo = (RE_ComboBox)e.getSource();
      if (combo.hasFocus())
      {
        combo.aktualisiereAltNeu();
        cfg.ONLINE_RELAIS_AUSWAHL = combo.getOldSelectedIndex();
        speicherEinstellung();
        cfg.ONLINE_RELAIS_AUSWAHL = combo.getSelectedIndex();
        removeListener();
        setzeSprache();
      }
    }
  }
  
  public class TasterAuswahlListener
    implements ActionListener
  {
    public TasterAuswahlListener() {}
    
    public void actionPerformed(ActionEvent e)
    {
      RE_ComboBox combo = (RE_ComboBox)e.getSource();
      if (combo.hasFocus())
      {
        combo.aktualisiereAltNeu();
        if (!ladenAktiv)
        {
          cboFunktion.aktualisiere();
          cfg.ONLINE_TASTER_AUSWAHL = combo.getOldSelectedIndex();
          speicherEinstellung();
        }
        cfg.ONLINE_TASTER_AUSWAHL = combo.getSelectedIndex();
        removeListener();
        setzeSprache();
      }
    }
  }
  
  public class Funktion2Listener
    implements ActionListener
  {
    public Funktion2Listener() {}
    
    public void actionPerformed(ActionEvent e)
    {
      RE_ComboBox combo = (RE_ComboBox)e.getSource();
      switch (combo.getSelectedIndex())
      {
      case 0: 
        chkRelais1.setEnabled(true);
        chkRelais2.setEnabled(true);
        chkRelais3.setEnabled(true);
        
        pnlRelKonf.setEnabled(true);
        
        break;
      default: 
        chkRelais1.setEnabled(false);
        chkRelais1.setSelected(false);
        chkRelais2.setEnabled(false);
        chkRelais2.setSelected(false);
        chkRelais3.setEnabled(false);
        chkRelais3.setSelected(false);
        
        chkNachlauf.setSelected(false);
        pnlRelKonf.setEnabled(false);
      }
    }
  }
}

