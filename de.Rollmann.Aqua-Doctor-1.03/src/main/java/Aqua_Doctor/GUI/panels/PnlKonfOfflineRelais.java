package Aqua_Doctor.GUI.panels;

import Aqua_Doctor.listener.SliListener;
import Aqua_Doctor.ressource.Daten;
import Aqua_Doctor.ressource.Sprache;
import de.Rollmann.komponenten.RE_CheckBox;
import de.Rollmann.komponenten.RE_ComboBox;
import de.Rollmann.komponenten.RE_Slider;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.TitledBorder;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class PnlKonfOfflineRelais
  extends KonfigPanel
{
  public JLabel lblStandardSchema = new JLabel();
  public JLabel lblVerz1 = new JLabel();
  public JLabel lblVerz1Wert = new JLabel();
  public JLabel lblSchalt1 = new JLabel();
  public JLabel lblSchalt1Wert = new JLabel();
  public JLabel lblSchalt2Wert = new JLabel();
  public JLabel lblSchalt2 = new JLabel();
  public JLabel lblVerz2 = new JLabel();
  public JLabel lblVerz2Wert = new JLabel();
  public JLabel lblVerz3 = new JLabel();
  public JLabel lblVerz3Wert = new JLabel();
  public JLabel lblSchalt3 = new JLabel();
  public JLabel lblSchalt3Wert = new JLabel();
  public JLabel lblVerzHoch = new JLabel();
  public JLabel lblHoch = new JLabel();
  public JLabel lblTaster = new JLabel();
  public RE_ComboBox cboStandardSchema = new RE_ComboBox();
  public RE_ComboBox cboVerz = new RE_ComboBox();
  public RE_ComboBox cboSchalt1 = new RE_ComboBox();
  public RE_ComboBox cboSchalt2 = new RE_ComboBox();
  public RE_ComboBox cboVerz2 = new RE_ComboBox();
  public RE_ComboBox cboVerz3 = new RE_ComboBox();
  public RE_ComboBox cboSchalt3 = new RE_ComboBox();
  public RE_ComboBox cboTaster = new RE_ComboBox();
  public RE_CheckBox chkRelais1 = new RE_CheckBox();
  public RE_CheckBox chkRelais2 = new RE_CheckBox();
  public RE_CheckBox chkRelais3 = new RE_CheckBox();
  public RE_CheckBox chkStatus = new RE_CheckBox();
  public RE_Slider sliSchalt1 = new RE_Slider();
  public RE_Slider sliVerz1 = new RE_Slider();
  public RE_Slider sliSchalt2 = new RE_Slider();
  public RE_Slider sliVerz2 = new RE_Slider();
  public RE_Slider sliSchalt3 = new RE_Slider();
  public RE_Slider sliVerz3 = new RE_Slider();
  public RE_Slider sliHoch = new RE_Slider();
  public JPanel pnlEinschaltung = new JPanel();
  public JPanel pnlRelais1 = new JPanel();
  public JPanel pnlRelais2 = new JPanel();
  public JPanel pnlRelais3 = new JPanel();
  public TitledBorder tbrRahmen = new TitledBorder("");
  public TitledBorder tbrRelais1 = new TitledBorder("");
  public TitledBorder tbrRelais2 = new TitledBorder("");
  public TitledBorder tbrRelais3 = new TitledBorder("");
  public SliListener verz1Lis;
  public SliListener verz2Lis;
  public SliListener verz3Lis;
  public SliListener schalt1Lis;
  public SliListener schalt2Lis;
  public SliListener schalt3Lis;
  public SliListener hochLis;
  public Verz1Listener cboVerz1Lis = new Verz1Listener();
  public Verz2Listener cboVerz2Lis = new Verz2Listener();
  public Verz3Listener cboVerz3Lis = new Verz3Listener();
  public Schalt1Listener cboSchalt1Lis = new Schalt1Listener();
  public Schalt2Listener cboSchalt2Lis = new Schalt2Listener();
  public Schalt3Listener cboSchalt3Lis = new Schalt3Listener();
  public CheckBoxListener chkLis = new CheckBoxListener();
  public TasterListener tasterLis = new TasterListener();
  public Daten cfg;
  public Sprache spr;
  
  public PnlKonfOfflineRelais(Daten c, Sprache s)
  {
    spr = s;
    cfg = c;
    try
    {
      verz1Lis = new SliListener(lblVerz1Wert, 
        1, 600, 
        10, false, spr, cfg);
      verz2Lis = new SliListener(lblVerz2Wert, 
        1, 600, 
        10, false, spr, cfg);
      verz3Lis = new SliListener(lblVerz3Wert, 
        1, 600, 
        10, false, spr, cfg);
      schalt1Lis = new SliListener(lblSchalt1Wert, 
        1, 600, 
        10, false, spr, cfg);
      schalt2Lis = new SliListener(lblSchalt2Wert, 
        1, 600, 
        10, false, spr, cfg);
      schalt3Lis = new SliListener(lblSchalt3Wert, 
        1, 600, 
        10, false, spr, cfg);
      hochLis = new SliListener(lblVerzHoch, 
        1, 600, 0, false, spr, cfg);
      
      jbInit();
      setzeSprache();
    }
    catch (Exception localException) {}
  }
  
  public void setzeKonfig(Daten c)
  {
    cfg = c;
  }
  
  public void aktualisiere()
  {
    cboVerz.aktualisiere();
    cboSchalt1.aktualisiere();
    cboSchalt2.aktualisiere();
    cboVerz2.aktualisiere();
    cboVerz3.aktualisiere();
    cboSchalt3.aktualisiere();
    cboTaster.aktualisiere();
    
    chkRelais1.aktualisiere();
    chkRelais2.aktualisiere();
    chkRelais3.aktualisiere();
    chkStatus.aktualisiere();
    
    sliSchalt1.aktualisiere();
    sliVerz1.aktualisiere();
    sliSchalt2.aktualisiere();
    sliVerz2.aktualisiere();
    sliSchalt3.aktualisiere();
    sliVerz3.aktualisiere();
    sliHoch.aktualisiere();
  }
  
  public void setzeEinstellung()
  {
    chkStatus.setSelected(cfg.OFFLINE_AQUA_DOCTOR_PC_START[
      cfg.OFFLINE_TASTER_AUSWAHL]);
    
    sliHoch.setValue(cfg.OFFLINE_PC_START_VERZ[cfg.OFFLINE_TASTER_AUSWAHL]);
    
    chkRelais1.setSelected(cfg.OFFLINE_RELAIS[cfg.OFFLINE_TASTER_AUSWAHL][0]);
    chkRelais2.setSelected(cfg.OFFLINE_RELAIS[cfg.OFFLINE_TASTER_AUSWAHL][1]);
    chkRelais3.setSelected(cfg.OFFLINE_RELAIS[cfg.OFFLINE_TASTER_AUSWAHL][2]);
    try
    {
      cboTaster.setSelectedIndex(cfg.OFFLINE_TASTER_AUSWAHL);
    }
    catch (Exception ex)
    {
      cboTaster.setSelectedIndex(0);
    }
    try
    {
      cboStandardSchema.setSelectedIndex(cfg.OFFLINE_STANDARD_SCHEMA);
    }
    catch (Exception ex)
    {
      cboStandardSchema.setSelectedIndex(0);
    }
    try
    {
      cboVerz.setSelectedIndex(cfg.OFFLINE_RELAIS_VERZ_ART[
        cfg.OFFLINE_TASTER_AUSWAHL][0]);
    }
    catch (Exception ex)
    {
      cboVerz.setSelectedIndex(0);
    }
    try
    {
      cboVerz2.setSelectedIndex(cfg.OFFLINE_RELAIS_VERZ_ART[
        cfg.OFFLINE_TASTER_AUSWAHL][1]);
    }
    catch (Exception ex)
    {
      cboVerz2.setSelectedIndex(0);
    }
    try
    {
      cboVerz3.setSelectedIndex(cfg.OFFLINE_RELAIS_VERZ_ART[
        cfg.OFFLINE_TASTER_AUSWAHL][2]);
    }
    catch (Exception ex)
    {
      cboVerz3.setSelectedIndex(0);
    }
    sliVerz1.setValue(cfg.OFFLINE_RELAIS_VERZ_WERT[
      cfg.OFFLINE_TASTER_AUSWAHL][0]);
    sliVerz2.setValue(cfg.OFFLINE_RELAIS_VERZ_WERT[
      cfg.OFFLINE_TASTER_AUSWAHL][1]);
    sliVerz3.setValue(cfg.OFFLINE_RELAIS_VERZ_WERT[
      cfg.OFFLINE_TASTER_AUSWAHL][2]);
    try
    {
      cboSchalt1.setSelectedIndex(cfg.OFFLINE_RELAIS_SCHALT_ART[
        cfg.OFFLINE_TASTER_AUSWAHL][0]);
    }
    catch (Exception ex)
    {
      cboSchalt1.setSelectedIndex(0);
    }
    try
    {
      cboSchalt2.setSelectedIndex(cfg.OFFLINE_RELAIS_SCHALT_ART[
        cfg.OFFLINE_TASTER_AUSWAHL][1]);
    }
    catch (Exception ex)
    {
      cboSchalt2.setSelectedIndex(0);
    }
    try
    {
      cboSchalt3.setSelectedIndex(cfg.OFFLINE_RELAIS_SCHALT_ART[
        cfg.OFFLINE_TASTER_AUSWAHL][2]);
    }
    catch (Exception ex)
    {
      cboSchalt3.setSelectedIndex(0);
    }
    sliSchalt1.setValue(cfg.OFFLINE_RELAIS_SCHALT_WERT[
      cfg.OFFLINE_TASTER_AUSWAHL][0]);
    sliSchalt2.setValue(cfg.OFFLINE_RELAIS_SCHALT_WERT[
      cfg.OFFLINE_TASTER_AUSWAHL][1]);
    sliSchalt3.setValue(cfg.OFFLINE_RELAIS_SCHALT_WERT[
      cfg.OFFLINE_TASTER_AUSWAHL][2]);
  }
  
  public void ladeEinstellung() {}
  
  public void ladeStandardEinstellung()
  {
    cfg.ladeLokalStandardEinstellungenOffline();
  }
  
  public void speicherEinstellung()
  {
    cfg.OFFLINE_AQUA_DOCTOR_PC_START[cfg.OFFLINE_TASTER_AUSWAHL] = 
      chkStatus.isSelected();
    
    cfg.OFFLINE_PC_START_VERZ[cfg.OFFLINE_TASTER_AUSWAHL] = 
      sliHoch.getValue();
    
    cfg.OFFLINE_STANDARD_SCHEMA = cboStandardSchema.getSelectedIndex();
    
    cfg.OFFLINE_RELAIS[cfg.OFFLINE_TASTER_AUSWAHL][0] = chkRelais1.isSelected();
    cfg.OFFLINE_RELAIS[cfg.OFFLINE_TASTER_AUSWAHL][1] = chkRelais2.isSelected();
    cfg.OFFLINE_RELAIS[cfg.OFFLINE_TASTER_AUSWAHL][2] = chkRelais3.isSelected();
    
    cfg.OFFLINE_RELAIS_VERZ_ART[
      cfg.OFFLINE_TASTER_AUSWAHL][0] = cboVerz.getSelectedIndex();
    cfg.OFFLINE_RELAIS_VERZ_ART[
      cfg.OFFLINE_TASTER_AUSWAHL][1] = cboVerz2.getSelectedIndex();
    cfg.OFFLINE_RELAIS_VERZ_ART[
      cfg.OFFLINE_TASTER_AUSWAHL][2] = cboVerz3.getSelectedIndex();
    
    cfg.OFFLINE_RELAIS_VERZ_WERT[
      cfg.OFFLINE_TASTER_AUSWAHL][0] = sliVerz1.getValue();
    cfg.OFFLINE_RELAIS_VERZ_WERT[
      cfg.OFFLINE_TASTER_AUSWAHL][1] = sliVerz2.getValue();
    cfg.OFFLINE_RELAIS_VERZ_WERT[
      cfg.OFFLINE_TASTER_AUSWAHL][2] = sliVerz3.getValue();
    
    cfg.OFFLINE_RELAIS_SCHALT_ART[
      cfg.OFFLINE_TASTER_AUSWAHL][0] = cboSchalt1.getSelectedIndex();
    cfg.OFFLINE_RELAIS_SCHALT_ART[
      cfg.OFFLINE_TASTER_AUSWAHL][1] = cboSchalt2.getSelectedIndex();
    cfg.OFFLINE_RELAIS_SCHALT_ART[
      cfg.OFFLINE_TASTER_AUSWAHL][2] = cboSchalt3.getSelectedIndex();
    
    cfg.OFFLINE_RELAIS_SCHALT_WERT[
      cfg.OFFLINE_TASTER_AUSWAHL][0] = sliSchalt1.getValue();
    cfg.OFFLINE_RELAIS_SCHALT_WERT[
      cfg.OFFLINE_TASTER_AUSWAHL][1] = sliSchalt2.getValue();
    cfg.OFFLINE_RELAIS_SCHALT_WERT[
      cfg.OFFLINE_TASTER_AUSWAHL][2] = sliSchalt3.getValue();
  }
  
  public void fuelleCombo()
  {
    cboVerz.removeAllItems();
    cboVerz.addItems(
      new String[] { spr.KEINE, spr.ZEIT });
    
    cboVerz2.removeAllItems();
    cboVerz2.addItems(
      new String[] { spr.KEINE, spr.ZEIT });
    
    cboVerz3.removeAllItems();
    cboVerz3.addItems(
      new String[] { spr.KEINE, spr.ZEIT });
    
    cboSchalt1.removeAllItems();
    cboSchalt1.addItems(
      new String[] { spr.ENDLOS, spr.ZEIT, 
      spr.BIS_ERNEUTEM_TASTENDRUCK, 
      spr.BIS_RECHNER_HOCHFAEHRT });
    
    cboSchalt2.removeAllItems();
    cboSchalt2.addItems(
      new String[] { spr.ENDLOS, spr.ZEIT, 
      spr.BIS_ERNEUTEM_TASTENDRUCK, 
      spr.BIS_RECHNER_HOCHFAEHRT });
    
    cboSchalt3.removeAllItems();
    cboSchalt3.addItems(
      new String[] { spr.ENDLOS, spr.ZEIT, 
      spr.BIS_ERNEUTEM_TASTENDRUCK, 
      spr.BIS_RECHNER_HOCHFAEHRT });
    
    cboTaster.removeAllItems();
    cboTaster.addItems(
      new String[] { spr.TASTER1, spr.TASTER2, 
      spr.TASTER3 });
    
    cboStandardSchema.removeAllItems();
    cboStandardSchema.addItems(
      new String[] { spr.TASTER1, spr.TASTER2, 
      spr.TASTER3 });
  }
  
  public void setzeSprache()
  {
    lblStandardSchema.setText(spr.STARTSCHEMA);
    lblTaster.setText(spr.TASTER);
    
    lblHoch.setText(spr.VERZOEGERUNG);
    
    lblVerz1.setText(spr.VERZOEGERUNG);
    lblVerz2.setText(spr.VERZOEGERUNG);
    lblVerz3.setText(spr.VERZOEGERUNG);
    
    lblSchalt1.setText(spr.SCHALTZEIT);
    lblSchalt2.setText(spr.SCHALTZEIT);
    lblSchalt3.setText(spr.SCHALTZEIT);
    
    chkStatus.setText(spr.HEATMASTER_2_KANN_PC_STARTEN);
    chkRelais1.setText(spr.RELAIS1);
    chkRelais2.setText(spr.RELAIS2);
    chkRelais3.setText(spr.RELAIS3);
    
    tbrRelais1.setTitle(spr.RELAIS1);
    tbrRelais2.setTitle(spr.RELAIS2);
    tbrRelais3.setTitle(spr.RELAIS3);
    tbrRahmen.setTitle(spr.OFFLINE_RAHMEN);
    
    fuelleCombo();
    ladeEinstellung();
    setzeEinstellung();
    setzeListener();
    aktualisiere();
  }
  
  public void setzeListener()
  {
    cboTaster.addActionListener(tasterLis);
    
    sliVerz1.addChangeListener(verz1Lis);
    sliVerz2.addChangeListener(verz2Lis);
    sliVerz3.addChangeListener(verz3Lis);
    sliSchalt1.addChangeListener(schalt1Lis);
    sliSchalt2.addChangeListener(schalt2Lis);
    sliSchalt3.addChangeListener(schalt3Lis);
    sliHoch.addChangeListener(hochLis);
    
    cboVerz.addActionListener(cboVerz1Lis);
    cboVerz2.addActionListener(cboVerz2Lis);
    cboVerz3.addActionListener(cboVerz3Lis);
    
    cboSchalt1.addActionListener(cboSchalt1Lis);
    cboSchalt2.addActionListener(cboSchalt2Lis);
    cboSchalt3.addActionListener(cboSchalt3Lis);
    
    chkRelais1.addChangeListener(chkLis);
    chkRelais2.addChangeListener(chkLis);
    chkRelais3.addChangeListener(chkLis);
  }
  
  public void removeListener()
  {
    cboTaster.removeActionListener(tasterLis);
    
    sliVerz1.removeChangeListener(verz1Lis);
    sliVerz2.removeChangeListener(verz2Lis);
    sliVerz3.removeChangeListener(verz3Lis);
    sliSchalt1.removeChangeListener(schalt1Lis);
    sliSchalt2.removeChangeListener(schalt2Lis);
    sliSchalt3.removeChangeListener(schalt3Lis);
    sliHoch.removeChangeListener(hochLis);
    
    cboVerz.removeActionListener(cboVerz1Lis);
    cboVerz2.removeActionListener(cboVerz2Lis);
    cboVerz3.removeActionListener(cboVerz3Lis);
    
    cboSchalt1.removeActionListener(cboSchalt1Lis);
    cboSchalt2.removeActionListener(cboSchalt2Lis);
    cboSchalt3.removeActionListener(cboSchalt3Lis);
    
    chkRelais1.removeChangeListener(chkLis);
    chkRelais2.removeChangeListener(chkLis);
    chkRelais3.removeChangeListener(chkLis);
  }
  
  public void jbInit()
    throws Exception
  {
    lblStandardSchema.setBounds(new Rectangle(20, 11, 81, 15));
    lblTaster.setBounds(new Rectangle(15, 30, 81, 15));
    
    lblVerzHoch.setBorder(BorderFactory.createEtchedBorder());
    lblVerzHoch.setHorizontalAlignment(4);
    lblVerzHoch.setHorizontalTextPosition(4);
    lblVerzHoch.setBounds(new Rectangle(284, 98, 60, 15));
    lblHoch.setBounds(new Rectangle(198, 98, 80, 15));
    
    lblVerz1.setBounds(new Rectangle(15, 30, 86, 15));
    lblVerz1Wert.setBorder(BorderFactory.createEtchedBorder());
    lblVerz1Wert.setHorizontalAlignment(4);
    lblVerz1Wert.setHorizontalTextPosition(4);
    lblVerz1Wert.setBounds(new Rectangle(260, 30, 60, 15));
    
    lblSchalt1.setBounds(new Rectangle(15, 60, 66, 15));
    lblSchalt1Wert.setBorder(BorderFactory.createEtchedBorder());
    lblSchalt1Wert.setHorizontalAlignment(4);
    lblSchalt1Wert.setHorizontalTextPosition(4);
    lblSchalt1Wert.setBounds(new Rectangle(260, 60, 60, 15));
    
    lblSchalt2.setBounds(new Rectangle(15, 60, 66, 15));
    lblSchalt2Wert.setBorder(BorderFactory.createEtchedBorder());
    lblSchalt2Wert.setHorizontalAlignment(4);
    lblSchalt2Wert.setHorizontalTextPosition(4);
    lblSchalt2Wert.setBounds(new Rectangle(260, 60, 60, 15));
    
    lblVerz2.setBounds(new Rectangle(15, 30, 86, 15));
    lblVerz2Wert.setBorder(BorderFactory.createEtchedBorder());
    lblVerz2Wert.setHorizontalAlignment(4);
    lblVerz2Wert.setHorizontalTextPosition(4);
    lblVerz2Wert.setBounds(new Rectangle(260, 30, 60, 15));
    
    lblVerz3.setBounds(new Rectangle(15, 30, 86, 15));
    lblVerz3Wert.setBorder(BorderFactory.createEtchedBorder());
    lblVerz3Wert.setHorizontalAlignment(4);
    lblVerz3Wert.setHorizontalTextPosition(4);
    lblVerz3Wert.setBounds(new Rectangle(260, 30, 60, 15));
    
    lblSchalt3.setBounds(new Rectangle(15, 60, 66, 15));
    lblSchalt3Wert.setBorder(BorderFactory.createEtchedBorder());
    lblSchalt3Wert.setHorizontalAlignment(4);
    lblSchalt3Wert.setHorizontalTextPosition(4);
    lblSchalt3Wert.setBounds(new Rectangle(260, 60, 60, 15));
    
    chkStatus.setBounds(new Rectangle(10, 94, 182, 23));
    chkRelais1.setBounds(new Rectangle(10, 63, 150, 23));
    chkRelais2.setBounds(new Rectangle(170, 63, 150, 23));
    chkRelais3.setBounds(new Rectangle(330, 63, 150, 23));
    
    chkRelais1.setActionCommand("1");
    chkRelais2.setActionCommand("2");
    chkRelais3.setActionCommand("3");
    
    cboStandardSchema.setBounds(new Rectangle(116, 11, 139, 21));
    cboVerz.setBounds(new Rectangle(105, 27, 140, 21));
    cboSchalt1.setBounds(new Rectangle(105, 57, 140, 21));
    cboVerz2.setBounds(new Rectangle(105, 27, 140, 21));
    cboSchalt2.setBounds(new Rectangle(105, 57, 140, 21));
    cboVerz3.setBounds(new Rectangle(105, 27, 140, 21));
    cboSchalt3.setBounds(new Rectangle(105, 57, 140, 21));
    cboTaster.setBounds(new Rectangle(106, 29, 139, 21));
    
    sliVerz1.setBounds(new Rectangle(330, 26, 200, 24));
    sliSchalt1.setBounds(new Rectangle(330, 56, 200, 24));
    sliVerz2.setBounds(new Rectangle(330, 26, 200, 24));
    sliSchalt2.setBounds(new Rectangle(330, 56, 200, 24));
    sliVerz3.setBounds(new Rectangle(330, 26, 200, 24));
    sliSchalt3.setBounds(new Rectangle(330, 56, 200, 24));
    sliHoch.setBounds(new Rectangle(348, 94, 200, 24));
    pnlRelais1.add(sliSchalt1);
    pnlRelais1.add(lblVerz1);
    pnlRelais1.add(lblVerz1Wert);
    pnlRelais1.add(lblSchalt1);
    pnlRelais1.add(lblSchalt1Wert);
    pnlRelais1.add(sliVerz1);
    pnlRelais1.add(cboVerz);
    pnlRelais1.add(cboSchalt1);
    pnlRelais1.setBorder(tbrRelais1);
    pnlRelais1.setBounds(new Rectangle(10, 192, 555, 100));
    pnlRelais1.setLayout(null);
    
    pnlRelais2.setBorder(tbrRelais2);
    pnlRelais2.setBounds(new Rectangle(10, 306, 555, 100));
    pnlRelais2.setLayout(null);
    pnlRelais2.add(cboSchalt2);
    pnlRelais2.add(sliSchalt2);
    pnlRelais2.add(cboVerz2);
    pnlRelais2.add(sliVerz2);
    pnlRelais2.add(lblVerz2Wert);
    pnlRelais2.add(lblSchalt2Wert);
    pnlRelais2.add(lblSchalt2);
    pnlRelais2.add(lblVerz2);
    
    pnlRelais3.add(sliSchalt3);
    pnlRelais3.add(lblVerz3);
    pnlRelais3.add(lblVerz3Wert);
    pnlRelais3.add(cboVerz3);
    pnlRelais3.add(lblSchalt3);
    pnlRelais3.add(lblSchalt3Wert);
    pnlRelais3.add(cboSchalt3);
    pnlRelais3.add(sliVerz3);
    add(cboStandardSchema);
    add(lblStandardSchema);
    pnlRelais3.setLayout(null);
    pnlRelais3.setBorder(tbrRelais3);
    pnlRelais3.setBounds(new Rectangle(10, 421, 555, 100));
    
    pnlEinschaltung.setBorder(tbrRahmen);
    pnlEinschaltung.setBounds(new Rectangle(10, 47, 555, 143));
    pnlEinschaltung.setLayout(null);
    pnlEinschaltung.add(cboTaster);
    pnlEinschaltung.add(lblTaster);
    pnlEinschaltung.add(chkRelais1);
    pnlEinschaltung.add(chkRelais2);
    pnlEinschaltung.add(chkRelais3);
    pnlEinschaltung.add(chkStatus);
    add(pnlEinschaltung);
    add(pnlRelais1);
    add(pnlRelais2);
    add(pnlRelais3);
    pnlEinschaltung.add(sliHoch);
    pnlEinschaltung.add(lblHoch);
    pnlEinschaltung.add(lblVerzHoch);
    setLayout(null);
  }
  
  public void ladeKonfig()
  {
    ladenAktiv = true;
    
    removeListener();
    
    setzeSprache();
    ladenAktiv = false;
  }
  
  public class TasterListener
    implements ActionListener
  {
    public TasterListener() {}
    
    public void actionPerformed(ActionEvent e)
    {
      RE_ComboBox combo = (RE_ComboBox)e.getSource();
      
      combo.aktualisiereAltNeu();
      if (combo.hasFocus())
      {
        if (!ladenAktiv)
        {
          cfg.OFFLINE_TASTER_AUSWAHL = combo.getOldSelectedIndex();
          speicherEinstellung();
        }
        cfg.OFFLINE_TASTER_AUSWAHL = combo.getSelectedIndex();
        removeListener();
        setzeSprache();
      }
    }
  }
  
  public class CheckBoxListener
    implements ChangeListener
  {
    public CheckBoxListener() {}
    
    public void stateChanged(ChangeEvent e)
    {
      RE_CheckBox check = (RE_CheckBox)e.getSource();
      switch (Integer.parseInt(check.getActionCommand()))
      {
      case 1: 
        pnlRelais1.setVisible(check.isSelected());
        break;
      case 2: 
        pnlRelais2.setVisible(check.isSelected());
        break;
      case 3: 
        pnlRelais3.setVisible(check.isSelected());
      }
    }
  }
  
  public class Verz1Listener
    implements ActionListener
  {
    public Verz1Listener() {}
    
    public void actionPerformed(ActionEvent e)
    {
      if (cboVerz.getSelectedIndex() == 1)
      {
        lblVerz1Wert.setVisible(true);
        sliVerz1.setVisible(true);
      }
      else
      {
        lblVerz1Wert.setVisible(false);
        sliVerz1.setVisible(false);
      }
    }
  }
  
  public class Verz2Listener
    implements ActionListener
  {
    public Verz2Listener() {}
    
    public void actionPerformed(ActionEvent e)
    {
      if (cboVerz2.getSelectedIndex() == 1)
      {
        lblVerz2Wert.setVisible(true);
        sliVerz2.setVisible(true);
      }
      else
      {
        lblVerz2Wert.setVisible(false);
        sliVerz2.setVisible(false);
      }
    }
  }
  
  public class Verz3Listener
    implements ActionListener
  {
    public Verz3Listener() {}
    
    public void actionPerformed(ActionEvent e)
    {
      if (cboVerz3.getSelectedIndex() == 1)
      {
        lblVerz3Wert.setVisible(true);
        sliVerz3.setVisible(true);
      }
      else
      {
        lblVerz3Wert.setVisible(false);
        sliVerz3.setVisible(false);
      }
    }
  }
  
  public class Schalt1Listener
    implements ActionListener
  {
    public Schalt1Listener() {}
    
    public void actionPerformed(ActionEvent e)
    {
      if (cboSchalt1.getSelectedIndex() == 1)
      {
        lblSchalt1Wert.setVisible(true);
        sliSchalt1.setVisible(true);
      }
      else
      {
        lblSchalt1Wert.setVisible(false);
        sliSchalt1.setVisible(false);
      }
    }
  }
  
  public class Schalt2Listener
    implements ActionListener
  {
    public Schalt2Listener() {}
    
    public void actionPerformed(ActionEvent e)
    {
      if (cboSchalt2.getSelectedIndex() == 1)
      {
        lblSchalt2Wert.setVisible(true);
        sliSchalt2.setVisible(true);
      }
      else
      {
        lblSchalt2Wert.setVisible(false);
        sliSchalt2.setVisible(false);
      }
    }
  }
  
  public class Schalt3Listener
    implements ActionListener
  {
    public Schalt3Listener() {}
    
    public void actionPerformed(ActionEvent e)
    {
      if (cboSchalt3.getSelectedIndex() == 1)
      {
        lblSchalt3Wert.setVisible(true);
        sliSchalt3.setVisible(true);
      }
      else
      {
        lblSchalt3Wert.setVisible(false);
        sliSchalt3.setVisible(false);
      }
    }
  }
}

