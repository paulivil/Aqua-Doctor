package Aqua_Doctor.GUI.panels;

import Aqua_Doctor.listener.SliListener;
import Aqua_Doctor.ressource.Daten;
import Aqua_Doctor.ressource.Sprache;
import de.Rollmann.komponenten.RE_CheckBox;
import de.Rollmann.komponenten.RE_ComboBox;
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

public class PnlKonfWasFluß
  extends KonfigPanel
{
  /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

public class Ein
  implements ChangeListener
  {
    Ein(PnlKonfWasFluß pnlPumpWasFluß) {}
    
    public void stateChanged(ChangeEvent e)
    {
      RE_Slider slider = (RE_Slider)e.getSource();
      
      lblFaktor2Wert.setHorizontalTextPosition(4);
      lblFaktor2Wert.setHorizontalAlignment(4);
      lblFaktor2Wert.setText(String.valueOf(slider.getValue()));
      try
      {
        cfg.WASSERFLUSS_SENSOR_EINHEIT_FAKTOR[cfg.WASSERFLUSS_AUSWAHL] = 
          slider.getValue();
      }
      catch (Exception e1) {}
      sliWarnmarke.aktualisiere();
      sliAlarm.aktualisiere();
      sliNotAus.aktualisiere();
    }
  }

public class EinheitListener
  implements ActionListener
  {
    public EinheitListener(PnlKonfWasFluß pnlPumpWasFluß) {}
    
    public void actionPerformed(ActionEvent e)
    {
      switch (cboEinheit.getSelectedIndex())
      {
      case 0: 
        lblFaktor2.setVisible(false);
        lblFaktor2Wert.setVisible(false);
        sliFaktor2.setVisible(false);
        break;
      case 1: 
      case 2: 
        lblFaktor2.setVisible(true);
        lblFaktor2Wert.setVisible(true);
        sliFaktor2.setVisible(true);
        sliFaktor2.aktualisiere();
      }
      sliWarnmarke.aktualisiere();
      sliAlarm.aktualisiere();
      sliNotAus.aktualisiere();
    }
  }

public class UeberWachungListener
  implements ChangeListener
  {
	  public UeberWachungListener(PnlKonfWasFluß pnlPumpWasFluß) {}
	  
	  public void stateChanged(ChangeEvent e)
	  {
	    if (!chkUeberWach.isSelected())
	    {
	      sliWarnmarke.setEnabled(false);
	      sliAlarm.setEnabled(false);
	      sliNotAus.setEnabled(false);
	    }
	    else
	    {
	      sliWarnmarke.setEnabled(true);
	      sliAlarm.setEnabled(true);
	      sliNotAus.setEnabled(true);
	    }
	  }
	}

public class AuswahlListener
implements ActionListener
{
	  public AuswahlListener(PnlKonfWasFluß pnlPumpWasFluß) {}
	  
	  public void actionPerformed(ActionEvent e)
	  {
	    RE_ComboBox combo = (RE_ComboBox)e.getSource();
	    
	    combo.aktualisiereAltNeu();
	    
	    cfg.WASSERFLUSS_AUSWAHL = combo.getOldSelectedIndex();
	    speicherEinstellung();
	    cfg.WASSERFLUSS_AUSWAHL = combo.getSelectedIndex();
	    removeListener();
	    setzeSprache();
	  }
	}

  public class TypListener
  implements ChangeListener
{
  public TypListener(PnlKonfWasFluß pnlPumpWasFluß) {}
  
  public void stateChanged(ChangeEvent e)
  {
    if (cboStatus.getSelectedIndex() == 2) {
      if (rbtPumpe.isSelected())
      {
        pnlDurchfluß.setVisible(false);
        pnlPumpe.setVisible(true);
      }
      else if (rbtSensor.isSelected())
      {
        pnlPumpe.setVisible(false);
        pnlDurchfluß.setVisible(true);
      }
    }
  }
}

  public class StatusListener
  implements ActionListener
{
  public StatusListener(PnlKonfWasFluß pnlPumpWasFluß) {}
  
  public void actionPerformed(ActionEvent e)
  {
    if ((cboStatus.getSelectedIndex() == 0) || 
      (cboStatus.getSelectedIndex() == 1))
    {
      cboFaktor.setEnabled(false);
      pnlDurchfluß.setVisible(false);
      pnlPumpe.setVisible(false);
      rbtPumpe.setEnabled(false);
      rbtSensor.setEnabled(false);
    }
    else
    {
      cboFaktor.setEnabled(true);
      pnlPumpe.setVisible(true);
      pnlDurchfluß.setVisible(true);
      rbtPumpe.setEnabled(true);
      rbtSensor.setEnabled(true);
    }
  }
}

public JLabel lblBezeichnung = new JLabel();
  public JLabel lblStatus = new JLabel();
  public JLabel lblFaktor = new JLabel();
  public JLabel lblWarnmarke = new JLabel();
  public JLabel lblAlarm = new JLabel();
  public JLabel lblNotAus = new JLabel();
  public JLabel lblPumpeAus = new JLabel();
  public JLabel lblPumpe = new JLabel();
  public JLabel lblEinheit = new JLabel();
  public JLabel lblTyp = new JLabel();
  public JLabel lblMinDreh = new JLabel();
  public JLabel lblMinDrehWert = new JLabel();
  public JLabel lblWarnWert = new JLabel();
  public JLabel lblAlarmWert = new JLabel();
  public JLabel lblNotAusWert = new JLabel();
  public JLabel lblFaktor2 = new JLabel();
  public JLabel lblFaktor2Wert = new JLabel();
  public RE_TextField txtBezeichnung = new RE_TextField(20);
  public RE_Slider sliMinDreh = new RE_Slider(0, 2000);
  public RE_Slider sliWarnmarke = new RE_Slider(2, 2000);
  public RE_Slider sliAlarm = new RE_Slider(1, 2000);
  public RE_Slider sliNotAus = new RE_Slider(0, 2000);
  public RE_Slider sliFaktor2 = new RE_Slider(1, 255);
  public RE_ComboBox cboPumpe = new RE_ComboBox();
  public RE_ComboBox cboStatus = new RE_ComboBox();
  public RE_ComboBox cboEinheit = new RE_ComboBox();
  public RE_ComboBox cboFaktor = new RE_ComboBox();
  public RE_ComboBox cboPumpeAus = new RE_ComboBox();
  public JPanel pnlPumpe = new JPanel();
  public JPanel pnlDurchfluß = new JPanel();
  public TitledBorder tbrPumpe = new TitledBorder("");
  public TitledBorder tbrSensor = new TitledBorder("");
  public RE_RadioButton rbtPumpe = new RE_RadioButton();
  public RE_RadioButton rbtSensor = new RE_RadioButton();
  public ButtonGroup bgr1 = new ButtonGroup();
  public RE_CheckBox chkUeberWach = new RE_CheckBox();
  public PnlKonfWasFluß.TypListener typLis = new PnlKonfWasFluß.TypListener(this);
  public PnlKonfWasFluß.AuswahlListener ausLis = new PnlKonfWasFluß.AuswahlListener(this);
  public PnlKonfWasFluß.UeberWachungListener ueberWachLis = new PnlKonfWasFluß.UeberWachungListener(this);
  public PnlKonfWasFluß.StatusListener statusLis = new PnlKonfWasFluß.StatusListener(this);
  public SliListener drehLis;
  public SliListener warnLis;
  public SliListener alarmLis;
  public SliListener notAusLis;
  public PnlKonfWasFluß.EinheitListener einheitLis = new PnlKonfWasFluß.EinheitListener(this);
  public ChangeListener faktorLis = new PnlKonfWasFluß.Ein(this);
  public Daten cfg;
  public Sprache spr;
  
  public PnlKonfWasFluß(Daten c, Sprache s)
  {
    cfg = c;
    spr = s;
    try
    {
      drehLis = new SliListener(lblMinDrehWert, 
        5, 2000, 0, false, spr, cfg);
      
      warnLis = new SliListener(lblWarnWert, 
        15, sliAlarm, 
        2000, 2, false, true, spr, cboEinheit);
      alarmLis = new SliListener(lblAlarmWert, 
        15, 
        sliNotAus, 2000, 1, false, true, spr, 
        cboEinheit);
      notAusLis = new SliListener(lblNotAusWert, 
        15, 2000, 0, false, 
        spr, 
        cboEinheit);
      
      jbInit();
      setzeSprache();
    }
    catch (Exception e) {}
  }
  
  public void setzeKonfig(Daten c)
  {
    cfg = c;
  }
  
  public void speicherEinstellung()
  {
    cfg.WASSERFLUSS_NAME[cfg.WASSERFLUSS_AUSWAHL] = txtBezeichnung.getText();
    
    cfg.WASSERFLUSS_STATUS[cfg.WASSERFLUSS_AUSWAHL] = 
      cboStatus.getSelectedIndex();
    
    cfg.WASSERFLUSS_TYP_PUMPE[cfg.WASSERFLUSS_AUSWAHL] = 
      rbtPumpe.isSelected();
    
    cfg.WASSERFLUSS_TYP_SENSOR[cfg.WASSERFLUSS_AUSWAHL] = 
      rbtSensor.isSelected();
    
    cfg.WASSERFLUSS_SENSOR_FAKTOR[cfg.WASSERFLUSS_AUSWAHL] = (
      cboFaktor.getSelectedIndex() + 1);
    
    cfg.WASSERFLUSS_SENSOR_EINHEIT[cfg.WASSERFLUSS_AUSWAHL] = 
      cboEinheit.getSelectedIndex();
    
    cfg.WASSERFLUSS_SENSOR_EINHEIT_FAKTOR[cfg.WASSERFLUSS_AUSWAHL] = 
      sliFaktor2.getValue();
    
    cfg.WASSERFLUSS_SENSOR_EINEIT_STRING[cfg.WASSERFLUSS_AUSWAHL] = 
      cboEinheit.getSelectedItem().toString();
    
    cfg.WASSERFLUSS_SENSOR_WARNMARKE[cfg.WASSERFLUSS_AUSWAHL] = 
      sliWarnmarke.getValue();
    cfg.WASSERFLUSS_SENSOR_ALARMMARKE[cfg.WASSERFLUSS_AUSWAHL] = 
      sliAlarm.getValue();
    cfg.WASSERFLUSS_SENSOR_NOTAUSMARKE[cfg.WASSERFLUSS_AUSWAHL] = 
      sliNotAus.getValue();
    
    cfg.WASSERFLUSS_PUMPE_MIN_DREHZAHL[cfg.WASSERFLUSS_AUSWAHL] = 
      sliMinDreh.getValue();
    
    cfg.WASSERFLUSS_PUMPE_ALARM_AKTION[cfg.WASSERFLUSS_AUSWAHL] = 
      cboPumpeAus.getSelectedIndex();
    
    cfg.WASSERFLUSS_SENSOR_UEBERWACHUNG[cfg.WASSERFLUSS_AUSWAHL] = 
      chkUeberWach.isSelected();
  }
  
  public void setzeEinstellung()
  {
    try
    {
      cboPumpe.setSelectedIndex(cfg.WASSERFLUSS_AUSWAHL);
    }
    catch (Exception ex)
    {
      cboPumpe.setSelectedIndex(0);
    }
    txtBezeichnung.setText(cfg.WASSERFLUSS_NAME[cfg.WASSERFLUSS_AUSWAHL]);
    try
    {
      cboStatus.setSelectedIndex(cfg.WASSERFLUSS_STATUS[
        cfg.WASSERFLUSS_AUSWAHL]);
    }
    catch (Exception ex)
    {
      cboStatus.setSelectedIndex(0);
    }
    rbtPumpe.setSelected(cfg.WASSERFLUSS_TYP_PUMPE[
      cfg.WASSERFLUSS_AUSWAHL]);
    rbtSensor.setSelected(cfg.WASSERFLUSS_TYP_SENSOR[
      cfg.WASSERFLUSS_AUSWAHL]);
    
    sliFaktor2.setValue(cfg.WASSERFLUSS_SENSOR_EINHEIT_FAKTOR[
      cfg.WASSERFLUSS_AUSWAHL]);
    try
    {
      cboFaktor.setSelectedIndex(cfg.WASSERFLUSS_SENSOR_FAKTOR[
        cfg.WASSERFLUSS_AUSWAHL] - 1);
    }
    catch (Exception ex)
    {
      cboFaktor.setSelectedIndex(0);
    }
    try
    {
      cboEinheit.setSelectedIndex(cfg.WASSERFLUSS_SENSOR_EINHEIT[
        cfg.WASSERFLUSS_AUSWAHL]);
    }
    catch (Exception ex)
    {
      cboEinheit.setSelectedIndex(0);
    }
    sliWarnmarke.setValue(cfg.WASSERFLUSS_SENSOR_WARNMARKE[
      cfg.WASSERFLUSS_AUSWAHL]);
    sliAlarm.setValue(cfg.WASSERFLUSS_SENSOR_ALARMMARKE[
      cfg.WASSERFLUSS_AUSWAHL]);
    sliNotAus.setValue(cfg.WASSERFLUSS_SENSOR_NOTAUSMARKE[
      cfg.WASSERFLUSS_AUSWAHL]);
    
    sliMinDreh.setValue(cfg.WASSERFLUSS_PUMPE_MIN_DREHZAHL[
      cfg.WASSERFLUSS_AUSWAHL]);
    try
    {
      cboPumpeAus.setSelectedIndex(cfg.WASSERFLUSS_PUMPE_ALARM_AKTION[
        cfg.WASSERFLUSS_AUSWAHL]);
    }
    catch (Exception ex)
    {
      cboPumpeAus.setSelectedIndex(0);
    }
    chkUeberWach.setSelected(
      cfg.WASSERFLUSS_SENSOR_UEBERWACHUNG[cfg.WASSERFLUSS_AUSWAHL]);
    
    setzeEinheiten();
  }
  
  public void setzeEinheiten()
  {
    for (int i = 0; i < 3; i++) {
      if (cfg.WASSERFLUSS_TYP_PUMPE[i] != false) {
        cfg.WASSERFLUSS_SENSOR_EINEIT_STRING[i] = 
          spr.EINHEIT_UMDREHUNG;
      } else {
        switch (cfg.WASSERFLUSS_SENSOR_EINHEIT[i])
        {
        case 0: 
          cfg.WASSERFLUSS_SENSOR_EINEIT_STRING[i] = spr.EINHEIT_UMDREHUNG;
          break;
        case 1: 
          cfg.WASSERFLUSS_SENSOR_EINEIT_STRING[i] = 
            spr.EINHEIT_LITER_PRO_STUNDE;
          break;
        case 2: 
          cfg.WASSERFLUSS_SENSOR_EINEIT_STRING[i] = 
            spr.EINHEIT_GALONE_PRO_STUNDE_US;
          break;
        case 3: 
          cfg.WASSERFLUSS_SENSOR_EINEIT_STRING[i] = 
            spr.EINHEIT_GALONE_PRO_STUNDE_IMP;
        }
      }
    }
  }
  
  public void ladeEinstellung()
  {
    cfg.ladeLokalEinstellungenWasserFluss();
  }
  
  public void ladeStandardEinstellung()
  {
    cfg.ladeLokalStandardEinstellungenWasserFluss();
  }
  
  public void setzeSprache()
  {
    lblPumpe.setText(spr.PUMPE_DURCHFLUSSSENSOR);
    lblBezeichnung.setText(spr.BEZEICHNUNG);
    lblStatus.setText(spr.STATUS);
    lblTyp.setText(spr.TYP);
    lblFaktor.setText(spr.FAKTOR);
    lblMinDreh.setText(spr.MINDEST_DREHZAHL);
    lblPumpeAus.setText(spr.AKTION_PUMPEN_AUSFALL);
    
    lblFaktor2.setText(spr.PULSE_PRO_1000_ML);
    
    lblEinheit.setText(spr.EINHEIT_FUER_WARNWERTE);
    
    lblWarnmarke.setText(spr.WARNMARKE);
    lblAlarm.setText(spr.ALARMMARKE);
    lblNotAus.setText(spr.NOT_AUS_MARKE);
    
    chkUeberWach.setText(spr.UEBERWACHUNG_AKTIV);
    
    rbtPumpe.setText(spr.PUMPE);
    rbtSensor.setText(spr.DURCHFLUSSSENSOR);
    
    tbrPumpe.setTitle(spr.PUMPE);
    tbrSensor.setTitle(spr.DURCHFLUSSSENSOR);
    
    fuelleCombo();
    ladeEinstellung();
    setzeEinstellung();
    setzeListener();
    aktualisiere();
  }
  
  public void fuelleCombo()
  {
    cboPumpe.removeAllItems();
    cboPumpe.addItems(
      new String[] { spr.PUMPE_SENSOR1, spr.PUMPE_SENSOR2, spr.PUMPE_SENSOR3 });
    
    cboStatus.removeAllItems();
    cboStatus.addItems(
      new String[] { spr.UEBERWACHEN_AUS, spr.NICHT_VORHANDEN, 
      spr.UEBERWACHEN_AN });
    
    cboEinheit.removeAllItems();
    cboEinheit.addItems(
      new String[] { spr.EINHEIT_UMDREHUNG, 
      spr.EINHEIT_LITER_PRO_STUNDE, 
      spr.EINHEIT_GALONE_PRO_STUNDE_US, 
      spr.EINHEIT_GALONE_PRO_STUNDE_IMP });
    
    cboFaktor.removeAllItems();
    cboFaktor.addItems(
      new String[] { "1", "2", "3", "4", "5", 
      "6", "7", "8", 
      "9", "10" });
    
    cboPumpeAus.removeAllItems();
    cboPumpeAus.addItems(
      new String[] { spr.KEINE, spr.WARNUNG, spr.NOT_AUS });
  }
  
  public void setzeListener()
  {
    chkUeberWach.addChangeListener(ueberWachLis);
    
    cboPumpe.addActionListener(ausLis);
    
    cboStatus.addActionListener(statusLis);
    
    cboEinheit.addActionListener(einheitLis);
    
    rbtPumpe.addChangeListener(typLis);
    rbtSensor.addChangeListener(typLis);
    
    sliMinDreh.addChangeListener(drehLis);
    
    sliFaktor2.addChangeListener(faktorLis);
    
    sliWarnmarke.addChangeListener(warnLis);
    sliAlarm.addChangeListener(alarmLis);
    sliNotAus.addChangeListener(notAusLis);
  }
  
  public void removeListener()
  {
    chkUeberWach.removeChangeListener(ueberWachLis);
    
    cboPumpe.removeActionListener(ausLis);
    
    cboStatus.removeActionListener(statusLis);
    
    cboEinheit.removeActionListener(einheitLis);
    
    rbtPumpe.removeChangeListener(typLis);
    rbtSensor.removeChangeListener(typLis);
    
    sliMinDreh.removeChangeListener(drehLis);
    
    sliFaktor2.removeChangeListener(faktorLis);
    
    sliWarnmarke.removeChangeListener(warnLis);
    sliAlarm.removeChangeListener(alarmLis);
    sliNotAus.removeChangeListener(notAusLis);
  }
  
  public void aktualisiere()
  {
    chkUeberWach.aktualisiere();
    
    cboStatus.aktualisiere();
    cboEinheit.aktualisiere();
    cboPumpeAus.aktualisiere();
    cboFaktor.aktualisiere();
    
    rbtPumpe.aktualisiere();
    rbtSensor.aktualisiere();
    
    sliFaktor2.setValue(cfg.WASSERFLUSS_SENSOR_EINHEIT_FAKTOR[
      cfg.WASSERFLUSS_AUSWAHL]);
    sliWarnmarke.setValue(cfg.WASSERFLUSS_SENSOR_WARNMARKE[
      cfg.WASSERFLUSS_AUSWAHL]);
    sliAlarm.setValue(cfg.WASSERFLUSS_SENSOR_ALARMMARKE[
      cfg.WASSERFLUSS_AUSWAHL]);
    sliNotAus.setValue(cfg.WASSERFLUSS_SENSOR_NOTAUSMARKE[
      cfg.WASSERFLUSS_AUSWAHL]);
    sliMinDreh.setValue(cfg.WASSERFLUSS_PUMPE_MIN_DREHZAHL[
      cfg.WASSERFLUSS_AUSWAHL]);
  }
  
  public void jbInit()
    throws Exception
  {
    lblPumpe.setBounds(new Rectangle(15, 20, 140, 15));
    lblBezeichnung.setBounds(new Rectangle(15, 50, 140, 15));
    lblStatus.setBounds(new Rectangle(15, 80, 140, 15));
    lblTyp.setBounds(new Rectangle(15, 120, 140, 15));
    lblFaktor.setBounds(new Rectangle(15, 155, 140, 15));
    
    lblMinDreh.setBounds(new Rectangle(15, 30, 89, 15));
    lblMinDrehWert.setBorder(BorderFactory.createEtchedBorder());
    lblMinDrehWert.setBounds(new Rectangle(154, 31, 60, 15));
    lblPumpeAus.setBounds(new Rectangle(15, 71, 124, 15));
    
    lblEinheit.setBounds(new Rectangle(15, 31, 125, 15));
    lblWarnWert.setBorder(BorderFactory.createEtchedBorder());
    lblWarnWert.setBounds(new Rectangle(145, 140, 57, 15));
    lblAlarmWert.setBorder(BorderFactory.createEtchedBorder());
    lblAlarmWert.setBounds(new Rectangle(145, 171, 57, 15));
    lblNotAusWert.setBorder(BorderFactory.createEtchedBorder());
    lblNotAusWert.setBounds(new Rectangle(145, 201, 57, 15));
    lblWarnmarke.setBounds(new Rectangle(15, 141, 125, 15));
    lblAlarm.setBounds(new Rectangle(15, 171, 125, 15));
    lblNotAus.setBounds(new Rectangle(15, 201, 125, 15));
    lblFaktor2.setBounds(new Rectangle(15, 64, 125, 15));
    lblFaktor2Wert.setBorder(BorderFactory.createEtchedBorder());
    lblFaktor2Wert.setBounds(new Rectangle(145, 65, 57, 15));
    
    txtBezeichnung.setBounds(new Rectangle(160, 47, 140, 21));
    
    sliMinDreh.setBounds(new Rectangle(220, 27, 200, 24));
    sliWarnmarke.setBounds(new Rectangle(203, 136, 200, 24));
    sliAlarm.setBounds(new Rectangle(203, 166, 200, 24));
    sliNotAus.setBounds(new Rectangle(203, 196, 200, 24));
    sliFaktor2.setBounds(new Rectangle(203, 60, 200, 24));
    
    rbtPumpe.setBounds(new Rectangle(155, 115, 91, 23));
    rbtSensor.setBounds(new Rectangle(242, 115, 134, 23));
    
    chkUeberWach.setBounds(new Rectangle(15, 109, 273, 19));
    
    bgr1.add(rbtPumpe);
    bgr1.add(rbtSensor);
    
    cboPumpe.setBounds(new Rectangle(160, 17, 140, 21));
    cboFaktor.setBounds(new Rectangle(160, 149, 140, 21));
    cboStatus.setBounds(new Rectangle(160, 77, 140, 21));
    
    cboPumpeAus.setBounds(new Rectangle(154, 65, 140, 21));
    cboEinheit.setBounds(new Rectangle(145, 27, 140, 21));
    
    pnlPumpe.setBorder(tbrPumpe);
    pnlPumpe.setBounds(new Rectangle(15, 200, 500, 244));
    pnlPumpe.setLayout(null);
    pnlPumpe.add(lblMinDreh);
    pnlPumpe.add(sliMinDreh);
    pnlPumpe.add(lblMinDrehWert);
    pnlPumpe.add(cboPumpeAus);
    pnlPumpe.add(lblPumpeAus);
    add(lblTyp);
    
    pnlDurchfluß.setBorder(tbrSensor);
    pnlDurchfluß.setBounds(new Rectangle(15, 200, 500, 244));
    pnlDurchfluß.setLayout(null);
    pnlDurchfluß.add(lblWarnWert);
    pnlDurchfluß.add(lblWarnmarke);
    pnlDurchfluß.add(lblAlarm);
    pnlDurchfluß.add(lblNotAus);
    pnlDurchfluß.add(lblAlarmWert);
    pnlDurchfluß.add(lblNotAusWert);
    pnlDurchfluß.add(sliWarnmarke);
    pnlDurchfluß.add(sliAlarm);
    pnlDurchfluß.add(sliNotAus);
    pnlDurchfluß.add(lblEinheit);
    pnlDurchfluß.add(cboEinheit);
    pnlDurchfluß.add(lblFaktor2Wert);
    pnlDurchfluß.add(chkUeberWach);
    pnlDurchfluß.add(sliFaktor2);
    pnlDurchfluß.add(lblFaktor2);
    add(txtBezeichnung);
    setLayout(null);
    add(lblBezeichnung);
    add(lblPumpe);
    add(cboPumpe);
    add(cboFaktor);
    add(lblFaktor);
    add(lblStatus);
    add(cboStatus);
    add(rbtPumpe);
    add(pnlDurchfluß);
    add(rbtSensor);
    add(pnlPumpe);
  }
  
  public void ladeKonfig()
  {
    ladenAktiv = true;
    
    removeListener();
    
    setzeSprache();
    ladenAktiv = false;
  }
}
