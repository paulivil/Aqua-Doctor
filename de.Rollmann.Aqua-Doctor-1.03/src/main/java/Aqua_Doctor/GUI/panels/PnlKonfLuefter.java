package Aqua_Doctor.GUI.panels;

import Aqua_Doctor.GUI.MainFrame;
import Aqua_Doctor.dialoge.DialogLuefterKali;
import Aqua_Doctor.kommunikation.DynDaten;
import Aqua_Doctor.listener.LiveSlilistener;
import Aqua_Doctor.listener.SliListener;
import Aqua_Doctor.ressource.Daten;
import Aqua_Doctor.ressource.Sprache;
import de.Rollmann.kommunikation.ComTabellen.ComTabelle;
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
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class PnlKonfLuefter
  extends KonfigPanel
  implements ActionListener
{
  /**
	 * 
	 */
	private static final long serialVersionUID = 3388819153925757856L;
public JLabel lblLuefterAuswahl = new JLabel();
  public JLabel lblBezeichnung = new JLabel();
  public JLabel lblStatus = new JLabel();
  public JLabel lblAktionAusfall = new JLabel();
  public JLabel lblManLuefterSpWert = new JLabel();
  public JLabel lblRegelung = new JLabel();
  public JLabel lblMaxDrehermit = new JLabel();
  public JLabel lblMinDreh = new JLabel();
  public JLabel lblMaxDreh = new JLabel();
  public JLabel lblSensorA = new JLabel();
  public JLabel lblDrehFunkt = new JLabel();
  public JLabel lblTachoFaktor = new JLabel();
  public JLabel lblSensorB = new JLabel();
  public JLabel lblTyp = new JLabel();
  public JLabel lblRegelungEinheit = new JLabel();
  public JLabel lblStartTemp = new JLabel();
  public JLabel lblStartTempWert = new JLabel();
  public JLabel lblSollMaxTemp = new JLabel();
  public JLabel lblSolMaxTempWert = new JLabel();
  public JLabel lblStartWert = new JLabel();
  public JLabel lblStartWertWert = new JLabel();
  public JLabel lblMaxWert = new JLabel();
  public JLabel lblMaxWertWert = new JLabel();
  public JLabel lblHysterese = new JLabel();
  public JLabel lblHystereseWert = new JLabel();
  public RE_TextField txtBezeichnung = new RE_TextField(20);
  public RE_ComboBox cboLuefterAuswahl = new RE_ComboBox();
  public RE_ComboBox cboAktionAusfall = new RE_ComboBox();
  public RE_ComboBox cboStatus = new RE_ComboBox();
  public RE_ComboBox cboSensorA = new RE_ComboBox();
  public RE_ComboBox cboDrehFunkt = new RE_ComboBox();
  public RE_ComboBox cboMaxDrehEr = new RE_ComboBox();
  public RE_ComboBox cboTachoFaktor = new RE_ComboBox();
  public RE_ComboBox cboSensorB = new RE_ComboBox();
  public RE_ComboBox cboTyp = new RE_ComboBox();
  public RE_ComboBox cboRegelungEinheit = new RE_ComboBox();
  public RE_ComboBox cboManuellAuto = new RE_ComboBox();
  public RE_RadioButton rbtManLuefterSp = new RE_RadioButton();
  public RE_RadioButton rbtManLuefterDr = new RE_RadioButton();
  public JButton butDrehzahl = new JButton();
  public RE_Slider sliDrehzahl = new RE_Slider(0, 200);
  public RE_Slider sliSpannung = new RE_Slider(50, 200);
  public RE_Slider sliHysterese = new RE_Slider(5, 100);
  public RE_Slider sliSollMaxTemp = new RE_Slider(0, 1000);
  public RE_Slider sliStartTemp = new RE_Slider(0, 1000);
  public RE_Slider sliStartVolt = new RE_Slider(50, 200);
  public RE_Slider sliStartDreh = new RE_Slider(0, 200);
  public RE_Slider sliMaxVolt = new RE_Slider(50, 200);
  public RE_Slider sliMaxDreh = new RE_Slider(0, 200);
  public JPanel pnlManuell = new JPanel();
  public JPanel pnlAutoSteuer = new JPanel();
  public RE_CheckBox chkAbschalt = new RE_CheckBox();
  public RE_CheckBox chkLivelis = new RE_CheckBox();
  public ButtonGroup buttonGroup1 = new ButtonGroup();
  public ButtonGroup buttonGroup2 = new ButtonGroup();
  public SliListener hystereseLis;
  public SliListener maxTemp;
  public SliListener startTemp;
  public SliListener spanDrehLis;
  public SliListener spanProLis;
  public SliListener spanVoltLis;
  public SliListener maxDrehDrehLis;
  public SliListener maxDrehSpanLis;
  public SliListener startWertDrehLis;
  public SliListener startWertSpanLis;
  AktivLiveListener aktLiveLis = new AktivLiveListener();
  public ManSpanDrehlistener manSpanDrehLis;
  public ButtonListener butLis;
  public LiveSlilistener liveLis;
  public int drehMax = 0;
  public Daten cfg;
  public Sprache spr;
  public ComTabelle comTab;
  public MainFrame mFrame;
  public DynDaten daten;
  public PnlKonfLuefter panel = this;
  
  public PnlKonfLuefter(Daten c, Sprache s, MainFrame m)
  {
    mFrame = m;
    cfg = c;
    spr = s;
    try
    {
      hystereseLis = new SliListener(lblHystereseWert, 
        2, 100, 5, false, spr, 
        cfg, true);
      
      maxTemp = new SliListener(lblSolMaxTempWert, 
        2, 1000, 0, false, spr, cfg);
      
      startTemp = new SliListener(lblStartTempWert, 
        2, 
        sliSollMaxTemp, 990, 0, false, false, spr, 
        cfg);
      
      spanDrehLis = new SliListener(lblManLuefterSpWert, 
        12, 200, 0, 
        cfg.LUEFTER_MAXLUEFTER_DREHZAHL[
        cfg.LUEFTER_AUSWAHL], 
        cfg.LUEFTER_MINLUEFTER_DREHZAHL[
        cfg.LUEFTER_AUSWAHL], false, spr, cfg);
      
      spanProLis = new SliListener(lblManLuefterSpWert, 
        11, 200, 50, true, 
        spr, cfg);
      
      spanVoltLis = new SliListener(lblManLuefterSpWert, 6, 
        200, 50, true, spr, cfg);
      
      maxDrehDrehLis = new SliListener(lblMaxWertWert, 
        12, 200, 0, 
        cfg.LUEFTER_MAXLUEFTER_DREHZAHL[
        cfg.LUEFTER_AUSWAHL], 
        cfg.LUEFTER_MINLUEFTER_DREHZAHL[
        cfg.LUEFTER_AUSWAHL], false, spr, cfg);
      
      maxDrehSpanLis = new SliListener(lblMaxWertWert, 6, 
        200, 0, false, spr, cfg);
      
      startWertDrehLis = new SliListener(lblStartWertWert, 
        12, 
        sliMaxDreh, 200, 0, 
        cfg.LUEFTER_MAXLUEFTER_DREHZAHL[
        cfg.LUEFTER_AUSWAHL], 
        cfg.LUEFTER_MINLUEFTER_DREHZAHL[
        cfg.LUEFTER_AUSWAHL], false, spr, cfg);
      
      startWertSpanLis = new SliListener(lblStartWertWert, 
        6, sliMaxVolt, 200, 
        50, false, false, spr, cfg);
      
      manSpanDrehLis = new ManSpanDrehlistener();
      
      butLis = new ButtonListener();
      
      jbInit();
    }
    catch (Exception e) {}
  }
  
  public void setzeLiveLis(ComTabelle tab, DynDaten d)
  {
    liveLis = new LiveSlilistener(cboStatus, cfg, tab, chkLivelis);
    comTab = tab;
    daten = d;
  }
  
  public void removeLiveLis()
  {
    try
    {
      sliDrehzahl.removeChangeListener(liveLis);
    }
    catch (Exception e) {}
    try
    {
      sliSpannung.removeChangeListener(liveLis);
    }
    catch (Exception e) {}
    try
    {
      sliDrehzahl.removeMouseListener(liveLis);
    }
    catch (Exception e) {}
    try
    {
      sliSpannung.removeMouseListener(liveLis);
    }
    catch (Exception e) {}
  }
  
  public void setzeKonfig(Daten c)
  {
    cfg = c;
  }
  
  public void fuelleCombo()
  {
    try
    {
      cboLuefterAuswahl.removeAllItems();
      cboLuefterAuswahl.addItems(
        new String[] { spr.LUEFTER1, spr.LUEFTER2, spr.LUEFTER3, 
        spr.LUEFTER4, spr.LUEFTER5, spr.LUEFTER6 });
      
      cboAktionAusfall.removeAllItems();
      cboAktionAusfall.addItems(
        new String[] { spr.KEINE, 
        spr.STUMMER_ALARM, 
        spr.ALARM, spr.RUNTERFAHREN, 
        spr.NOTABSCHALT });
      
      cboStatus.removeAllItems();
      cboStatus.addItems(
        new String[] { spr.INAKTIV, spr.NICHT_VORHANDEN, 
        spr.AKTIV });
      
      cboSensorA.removeAllItems();
      cboSensorA.addItem(spr.KEINER);
      cboSensorA.addItems(cfg.SENSOR_NAME);
      
      cboSensorB.removeAllItems();
      cboSensorB.addItem(spr.KEINER);
      cboSensorB.addItems(cfg.SENSOR_NAME);
      
      cboDrehFunkt.removeAllItems();
      cboDrehFunkt.addItems(
        new String[] { spr.INAKTIV, 
        spr.NICHT_VORHANDEN, 
        spr.AKTIV });
      
      cboMaxDrehEr.removeAllItems();
      cboMaxDrehEr.addItems(
        new String[] { spr.NIE, 
        spr.SYSTEMSTART });
      cboTachoFaktor.removeAllItems();
      cboTachoFaktor.addItems(
        new String[] { "1", "2", "3", 
        "4", "5", "6", "7", "8", "9", "10" });
      cboTyp.removeAllItems();
      cboTyp.addItems(
        new String[] { spr.LINEAR, spr.SOLLWERTREGELUNG, 
        spr.PROGRESSIV });
      
      cboRegelungEinheit.removeAllItems();
      cboRegelungEinheit.addItems(
        new String[] { spr.AUTOFAN, 
        spr.VOLT, spr.EINHEIT_UMDREHUNG });
      
      cboManuellAuto.removeAllItems();
      cboManuellAuto.addItems(
        new String[] { spr.MANUELL, 
        spr.AUTOMATISCH });
    }
    catch (Exception e) {}
  }
  
  public void setzeListener()
  {
    cboRegelungEinheit.addActionListener(this);
    cboLuefterAuswahl.addActionListener(this);
    cboStatus.addActionListener(this);
    cboDrehFunkt.addActionListener(this);
    cboTyp.addActionListener(this);
    cboManuellAuto.addActionListener(this);
    cboSensorA.addActionListener(this);
    cboSensorB.addActionListener(this);
    
    sliHysterese.addChangeListener(hystereseLis);
    sliSpannung.addChangeListener(spanVoltLis);
    try
    {
      if (comTab.toString() != "")
      {
        sliSpannung.addChangeListener(liveLis);
        sliDrehzahl.addChangeListener(liveLis);
        
        sliSpannung.addMouseListener(liveLis);
        sliDrehzahl.addMouseListener(liveLis);
      }
    }
    catch (Exception e) {}
    sliSollMaxTemp.addChangeListener(maxTemp);
    sliStartTemp.addChangeListener(startTemp);
    
    butDrehzahl.addActionListener(butLis);
    rbtManLuefterDr.addChangeListener(manSpanDrehLis);
    rbtManLuefterSp.addChangeListener(manSpanDrehLis);
    
    chkLivelis.addActionListener(aktLiveLis);
  }
  
  public void removeListener()
  {
    rbtManLuefterDr.removeChangeListener(manSpanDrehLis);
    rbtManLuefterSp.removeChangeListener(manSpanDrehLis);
    
    sliHysterese.removeChangeListener(hystereseLis);
    try
    {
      sliSollMaxTemp.removeChangeListener(maxTemp);
    }
    catch (Exception e) {}
    try
    {
      sliStartTemp.removeChangeListener(startTemp);
    }
    catch (Exception e) {}
    try
    {
      sliDrehzahl.removeChangeListener(liveLis);
    }
    catch (Exception e) {}
    try
    {
      sliSpannung.removeChangeListener(liveLis);
    }
    catch (Exception e) {}
    try
    {
      sliDrehzahl.removeMouseListener(liveLis);
    }
    catch (Exception e) {}
    try
    {
      sliSpannung.removeMouseListener(liveLis);
    }
    catch (Exception e) {}
    sliSpannung.removeChangeListener(spanVoltLis);
    
    cboLuefterAuswahl.removeActionListener(this);
    cboStatus.removeActionListener(this);
    cboSensorA.removeActionListener(this);
    cboSensorB.removeActionListener(this);
    cboDrehFunkt.removeActionListener(this);
    
    cboRegelungEinheit.removeActionListener(this);
    
    cboTyp.removeActionListener(this);
    cboManuellAuto.removeActionListener(this);
    
    butDrehzahl.removeActionListener(butLis);
    try
    {
      sliDrehzahl.removeAllSliListeners();
    }
    catch (Exception e) {}
    try
    {
      sliMaxVolt.removeAllSliListeners();
    }
    catch (Exception e) {}
    try
    {
      sliMaxDreh.removeAllSliListeners();
    }
    catch (Exception e) {}
    try
    {
      sliStartVolt.removeAllSliListeners();
    }
    catch (Exception e) {}
    try
    {
      sliStartDreh.removeAllSliListeners();
    }
    catch (Exception e) {}
    try
    {
      chkLivelis.removeActionListener(aktLiveLis);
    }
    catch (Exception e) {}
  }
  
  public void setzeEinstellung()
  {
    try
    {
      cboLuefterAuswahl.setSelectedIndex(cfg.LUEFTER_AUSWAHL);
    }
    catch (Exception e) {}
    try
    {
      lblMinDreh.setText(spr.MIN + " :" + 
        String.valueOf(cfg.LUEFTER_MINLUEFTER_DREHZAHL[
        cfg.LUEFTER_AUSWAHL]));
    }
    catch (Exception e)
    {
      lblMinDreh.setText(spr.MIN + " :");
    }
    try
    {
      lblMaxDreh.setText(spr.MAX + " :" + 
        String.valueOf(cfg.LUEFTER_MAXLUEFTER_DREHZAHL[
        cfg.LUEFTER_AUSWAHL]));
    }
    catch (Exception e)
    {
      lblMaxDreh.setText(spr.MAX + " :");
    }
    try
    {
      txtBezeichnung.setText(cfg.LUEFTER_NAME[
        cfg.LUEFTER_AUSWAHL]);
    }
    catch (Exception e)
    {
      txtBezeichnung.setText("No Name");
    }
    try
    {
      sliHysterese.setValue(cfg.LUEFTER_HYSTERESE[cfg.LUEFTER_AUSWAHL]);
    }
    catch (Exception e)
    {
      sliHysterese.setValue(2);
    }
    try
    {
      cboStatus.setSelectedIndex(cfg.LUEFTER_STATUS[cfg.LUEFTER_AUSWAHL]);
    }
    catch (Exception e)
    {
      cboStatus.setSelectedIndex(0);
    }
    try
    {
      cboDrehFunkt.setSelectedIndex(cfg.LUEFTER_DREHZAHLFUNK[
        cfg.LUEFTER_AUSWAHL]);
    }
    catch (Exception e)
    {
      cboDrehFunkt.setSelectedIndex(0);
    }
    try
    {
      chkAbschalt.setSelected(cfg.LUEFTER_ABSCHALT_BEI_AUSFALL[
        cfg.LUEFTER_AUSWAHL]);
    }
    catch (Exception e)
    {
      chkAbschalt.setSelected(true);
    }
    try
    {
      cboAktionAusfall.setSelectedIndex(cfg.LUEFTER_AKTION_AUSFALL[
        cfg.LUEFTER_AUSWAHL]);
    }
    catch (Exception e)
    {
      cboAktionAusfall.setSelectedIndex(0);
    }
    try
    {
      cboMaxDrehEr.setSelectedIndex(cfg.LUEFTER_DREHZAHL_ERMITT[
        cfg.LUEFTER_AUSWAHL]);
    }
    catch (Exception e)
    {
      cboMaxDrehEr.setSelectedIndex(0);
    }
    try
    {
      cboTachoFaktor.setSelectedIndex(cfg.LUEFTER_TACHO_FAKTOR[
        cfg.LUEFTER_AUSWAHL] - 1);
    }
    catch (Exception e)
    {
      cboTachoFaktor.setSelectedIndex(0);
    }
    try
    {
      cboSensorA.setSelectedIndex(cfg.LUEFTER_SENSOR_A[cfg.LUEFTER_AUSWAHL]);
    }
    catch (Exception e)
    {
      cboSensorA.setSelectedIndex(0);
    }
    try
    {
      cboSensorB.setSelectedIndex(cfg.LUEFTER_SENSOR_B[cfg.LUEFTER_AUSWAHL]);
    }
    catch (Exception e)
    {
      cboSensorB.setSelectedIndex(0);
    }
    try
    {
      cboManuellAuto.setSelectedIndex(cfg.LUEFTER_MANUELL_AUTO[
        cfg.LUEFTER_AUSWAHL]);
    }
    catch (Exception e) {}
    try
    {
      sliStartTemp.setValue(cfg.LUEFTER_STARTTEMP[cfg.LUEFTER_AUSWAHL]);
    }
    catch (Exception e) {}
    try
    {
      sliSollMaxTemp.setValue(cfg.LUEFTER_SOLLTEMP[cfg.LUEFTER_AUSWAHL]);
    }
    catch (Exception e) {}
    try
    {
      cboRegelungEinheit.setSelectedIndex(cfg.LUEFTER_REGELUNG_EINHEIT[
        cfg.LUEFTER_AUSWAHL]);
    }
    catch (Exception e)
    {
      cboRegelungEinheit.setSelectedIndex(0);
    }
    switch (cboRegelungEinheit.getSelectedIndex())
    {
    case 0: 
      break;
    case 1: 
      sliMaxVolt.setValue(cfg.LUEFTER_MAX_SPANNUNG[cfg.LUEFTER_AUSWAHL]);
      sliStartVolt.setValue(cfg.LUEFTER_STARTWERT_SPANNUNG[
        cfg.LUEFTER_AUSWAHL]);
      break;
    case 2: 
      sliMaxDreh.setValue(cfg.LUEFTER_MAX_DREHZAHL[cfg.LUEFTER_AUSWAHL]);
      sliStartDreh.setValue(cfg.LUEFTER_STARTWERT_DREHZAHL[
        cfg.LUEFTER_AUSWAHL]);
    }
    try
    {
      sliHysterese.setValue(cfg.LUEFTER_HYSTERESE[cfg.LUEFTER_AUSWAHL]);
    }
    catch (Exception e) {}
    try
    {
      rbtManLuefterSp.setSelected(cfg.LUEFTER_MAN_SPANNUNG[
        cfg.LUEFTER_AUSWAHL]);
    }
    catch (Exception e) {}
    try
    {
      rbtManLuefterDr.setSelected(cfg.LUEFTER_MAN_DREHZAHL[
        cfg.LUEFTER_AUSWAHL]);
    }
    catch (Exception e) {}
    try
    {
      cboTyp.setSelectedIndex(cfg.LUEFTER_TYP[cfg.LUEFTER_AUSWAHL]);
    }
    catch (Exception e)
    {
      cboTyp.setSelectedIndex(0);
    }
    try
    {
      sliSpannung.setValue(cfg.LUEFTER_MANUELL_SPANNUNG[cfg.LUEFTER_AUSWAHL]);
    }
    catch (Exception e) {}
    try
    {
      sliDrehzahl.setValue(cfg.LUEFTER_MANUELL_DREHZAHL[cfg.LUEFTER_AUSWAHL]);
    }
    catch (Exception e) {}
    if (cfg.LUEFTER_STATUS[cfg.LUEFTER_AUSWAHL] != 2)
    {
      pnlManuell.setVisible(false);
      pnlAutoSteuer.setVisible(false);
    }
  }
  
  public void ladeEinstellung()
  {
    try
    {
      drehMax = cfg.LUEFTER_MAXLUEFTER_DREHZAHL[cfg.LUEFTER_AUSWAHL];
    }
    catch (Exception e)
    {
      drehMax = cfg.LUEFTER_MAXLUEFTER_DREHZAHL[cfg.LUEFTER_AUSWAHL];
    }
  }
  
  public void ladeStandardEinstellung()
  {
    cfg.ladeLokalStandardEinstellungenLuefter();
  }
  
  public void speicherEinstellung()
  {
    cfg.LUEFTER_NAME[cfg.LUEFTER_AUSWAHL] = txtBezeichnung.getText();
    
    cfg.LUEFTER_STATUS[cfg.LUEFTER_AUSWAHL] = cboStatus.getSelectedIndex();
    cfg.LUEFTER_DREHZAHLFUNK[cfg.LUEFTER_AUSWAHL] = 
      cboDrehFunkt.getSelectedIndex();
    
    cfg.LUEFTER_ABSCHALT_BEI_AUSFALL[cfg.LUEFTER_AUSWAHL] = 
      chkAbschalt.isSelected();
    
    cfg.LUEFTER_AKTION_AUSFALL[cfg.LUEFTER_AUSWAHL] = 
      cboAktionAusfall.getSelectedIndex();
    cfg.LUEFTER_DREHZAHL_ERMITT[cfg.LUEFTER_AUSWAHL] = 
      cboMaxDrehEr.getSelectedIndex();
    cfg.LUEFTER_TACHO_FAKTOR[cfg.LUEFTER_AUSWAHL] = (
      cboTachoFaktor.getSelectedIndex() + 1);
    cfg.LUEFTER_SENSOR_A[cfg.LUEFTER_AUSWAHL] = 
      cboSensorA.getSelectedIndex();
    cfg.LUEFTER_SENSOR_B[cfg.LUEFTER_AUSWAHL] = 
      cboSensorB.getSelectedIndex();
    
    cfg.LUEFTER_MANUELL_AUTO[cfg.LUEFTER_AUSWAHL] = 
      cboManuellAuto.getSelectedIndex();
    
    cfg.LUEFTER_STARTTEMP[cfg.LUEFTER_AUSWAHL] = sliStartTemp.getValue();
    
    cfg.LUEFTER_SOLLTEMP[cfg.LUEFTER_AUSWAHL] = sliSollMaxTemp.getValue();
    
    cfg.LUEFTER_MAXTEMP[cfg.LUEFTER_AUSWAHL] = sliSollMaxTemp.getValue();
    
    cfg.LUEFTER_REGELUNG_EINHEIT[cfg.LUEFTER_AUSWAHL] = 
      cboRegelungEinheit
      .getSelectedIndex();
    switch (cfg.LUEFTER_REGELUNG_EINHEIT[cfg.LUEFTER_AUSWAHL])
    {
    case 0: 
      break;
    case 1: 
      cfg.LUEFTER_STARTWERT_SPANNUNG[cfg.LUEFTER_AUSWAHL] = 
        sliStartVolt
        .getValue();
      cfg.LUEFTER_MAX_SPANNUNG[cfg.LUEFTER_AUSWAHL] = 
        sliMaxVolt.getValue();
      break;
    case 2: 
      cfg.LUEFTER_STARTWERT_DREHZAHL[cfg.LUEFTER_AUSWAHL] = 
        sliStartDreh.getValue();
      cfg.LUEFTER_MAX_DREHZAHL[cfg.LUEFTER_AUSWAHL] = 
        sliMaxDreh.getValue();
    }
    cfg.LUEFTER_HYSTERESE[cfg.LUEFTER_AUSWAHL] = sliHysterese.getValue();
    if (cboManuellAuto.getSelectedIndex() == 0)
    {
      cfg.LUEFTER_MAN_SPANNUNG[cfg.LUEFTER_AUSWAHL] = 
        rbtManLuefterSp.isSelected();
      cfg.LUEFTER_MAN_DREHZAHL[cfg.LUEFTER_AUSWAHL] = 
        rbtManLuefterDr.isSelected();
    }
    else
    {
      cfg.LUEFTER_MAN_SPANNUNG[cfg.LUEFTER_AUSWAHL] = false;
      cfg.LUEFTER_MAN_DREHZAHL[cfg.LUEFTER_AUSWAHL] = false;
    }
    cfg.LUEFTER_TYP[cfg.LUEFTER_AUSWAHL] = cboTyp.getSelectedIndex();
    
    cfg.LUEFTER_MANUELL_SPANNUNG[cfg.LUEFTER_AUSWAHL] = 
      sliSpannung.getValue();
    
    cfg.LUEFTER_MANUELL_DREHZAHL[cfg.LUEFTER_AUSWAHL] = 
      sliDrehzahl.getValue();
    
    cboManuellAuto.aktualisiere();
  }
  
  public void setzeSprache()
  {
    lblLuefterAuswahl.setText(spr.LUEFTER);
    lblBezeichnung.setText(spr.BEZEICHNUNG);
    lblStatus.setText(spr.STATUS);
    lblDrehFunkt.setText(spr.DREHZAHLFUNKTION);
    lblAktionAusfall.setText(spr.AKTION_LUEFTER_AUSFALL);
    lblMaxDrehermit.setText(spr.MINMAX_DREHZAHL_ERMITTELN);
    lblTachoFaktor.setToolTipText(spr.TOOLTIP_TACHO_FAKTOR);
    lblTachoFaktor.setText(spr.TACHO_FAKTOR);
    lblRegelung.setText(spr.REGELUNG);
    lblMinDreh.setText(spr.MIN + " : ");
    lblMaxDreh.setText(spr.MAX + " : ");
    lblSensorA.setText(spr.SENSOR_A);
    lblSensorB.setText(spr.SENSOR_B);
    
    lblTyp.setText(spr.TYP);
    lblRegelungEinheit.setText(spr.REGELUNG_EINHEIT);
    
    lblStartTemp.setText(spr.STARTTEMP);
    lblSollMaxTemp.setText(spr.MAXTEMP);
    
    lblStartWert.setText(spr.STARTWERT);
    lblMaxWert.setText(spr.MAXDREHZAHL);
    
    lblHysterese.setText(spr.HYSTERESE);
    
    chkAbschalt.setText(spr.LUEFTER_ABSCHALTEN_BEI_AUSFALL);
    
    chkLivelis.setText(spr.LIVEREGELUNG_AKTIV);
    
    rbtManLuefterDr.setText(spr.LUEFTERDREHZAHL);
    rbtManLuefterSp.setText(spr.LUEFTERSPANNUNG);
    butDrehzahl.setText(spr.JETZT);
    
    fuelleCombo();
    
    ladeEinstellung();
    
    setzeEinstellung();
    
    setzeListener();
    
    aktualisiere();
  }
  
  public void aktualisiere()
  {
    cboAktionAusfall.aktualisiere();
    cboStatus.aktualisiere();
    cboSensorA.aktualisiere();
    cboDrehFunkt.aktualisiere();
    cboMaxDrehEr.aktualisiere();
    cboTachoFaktor.aktualisiere();
    cboSensorB.aktualisiere();
    cboTyp.aktualisiere();
    cboRegelungEinheit.aktualisiere();
    
    rbtManLuefterSp.aktualisiere();
    rbtManLuefterDr.aktualisiere();
    
    chkAbschalt.aktualisiere();
    
    sliHysterese.aktualisiere();
    sliSollMaxTemp.aktualisiere();
    sliStartTemp.aktualisiere();
    
    sliStartVolt.aktualisiere();
    sliStartDreh.aktualisiere();
    sliMaxVolt.aktualisiere();
    sliMaxDreh.aktualisiere();
  }
  
  public void setzeNullDrehzahl()
  {
    cfg.LUEFTER_MAXLUEFTER_DREHZAHL[cfg.LUEFTER_AUSWAHL] = 0;
    cfg.LUEFTER_MINLUEFTER_DREHZAHL[cfg.LUEFTER_AUSWAHL] = 0;
    
    lblMaxDreh.setText(spr.MAX + " : 0");
    lblMinDreh.setText(spr.MIN + " : 0");
  }
  
  public void errechneMinDrehzahl()
  {
    float f = 30 * cfg.LUEFTER_MAXLUEFTER_DREHZAHL[cfg.LUEFTER_AUSWAHL] / 100;
    
    cfg.LUEFTER_MINLUEFTER_DREHZAHL[cfg.LUEFTER_AUSWAHL] = ((int)f);
    
    lblMinDreh.setText(spr.MIN + " : " + 
      cfg.LUEFTER_MINLUEFTER_DREHZAHL[cfg.LUEFTER_AUSWAHL]);
    
    spanDrehLis.neueDrehzahlen = true;
    maxDrehDrehLis.neueDrehzahlen = true;
    startWertDrehLis.neueDrehzahlen = true;
    
    sliDrehzahl.aktualisiere();
    if ((cboManuellAuto.getSelectedIndex() == 1) && 
      (cboRegelungEinheit.getSelectedIndex() == 2))
    {
      sliStartDreh.aktualisiere();
      sliMaxDreh.aktualisiere();
    }
  }
  
  public void setzeMaxDrehzahl(int dreh)
  {
    drehMax = dreh;
    cfg.LUEFTER_MAXLUEFTER_DREHZAHL[cfg.LUEFTER_AUSWAHL] = dreh;
    lblMaxDreh.setText(spr.MAX + " : " + 
      cfg.LUEFTER_MAXLUEFTER_DREHZAHL[cfg.LUEFTER_AUSWAHL]);
  }
  
  public void setzeMinDrehzahl(int dreh)
  {
    cfg.LUEFTER_MINLUEFTER_DREHZAHL[cfg.LUEFTER_AUSWAHL] = dreh;
    
    lblMinDreh.setText(spr.MIN + "   :  " + 
      cfg.LUEFTER_MINLUEFTER_DREHZAHL[cfg.LUEFTER_AUSWAHL]);
    
    spanDrehLis.neueDrehzahlen = true;
    maxDrehDrehLis.neueDrehzahlen = true;
    startWertDrehLis.neueDrehzahlen = true;
    
    sliDrehzahl.aktualisiere();
    if ((cboManuellAuto.getSelectedIndex() == 1) && 
      (cboRegelungEinheit.getSelectedIndex() == 2))
    {
      sliStartDreh.aktualisiere();
      sliMaxDreh.aktualisiere();
    }
  }
  
  public void jbInit()
    throws Exception
  {
    lblLuefterAuswahl.setBounds(new Rectangle(15, 20, 189, 15));
    lblBezeichnung.setBounds(new Rectangle(15, 50, 189, 15));
    lblStatus.setBounds(new Rectangle(15, 80, 189, 15));
    lblDrehFunkt.setBounds(new Rectangle(15, 110, 189, 15));
    lblAktionAusfall.setBounds(new Rectangle(15, 180, 189, 15));
    lblMaxDrehermit.setBounds(new Rectangle(15, 210, 189, 15));
    lblTachoFaktor.setBounds(new Rectangle(15, 240, 189, 15));
    lblRegelung.setBounds(new Rectangle(15, 300, 176, 15));
    
    lblMinDreh.setBounds(new Rectangle(450, 205, 75, 15));
    lblMaxDreh.setBounds(new Rectangle(450, 220, 75, 15));
    
    lblMinDreh.setBorder(BorderFactory.createEtchedBorder());
    lblMaxDreh.setBorder(BorderFactory.createEtchedBorder());
    
    lblSensorA.setBounds(new Rectangle(15, 270, 169, 15));
    lblSensorB.setBounds(new Rectangle(340, 270, 169, 15));
    
    lblManLuefterSpWert.setBorder(BorderFactory.createEtchedBorder());
    lblManLuefterSpWert.setBounds(new Rectangle(150, 76, 60, 15));
    
    lblTyp.setBounds(new Rectangle(10, 20, 150, 15));
    
    lblRegelungEinheit.setBounds(new Rectangle(10, 50, 150, 15));
    
    lblStartTemp.setBounds(new Rectangle(10, 80, 150, 15));
    lblStartTempWert.setBorder(BorderFactory.createEtchedBorder());
    lblStartTempWert.setBounds(new Rectangle(150, 79, 60, 15));
    
    lblSollMaxTemp.setBounds(new Rectangle(10, 110, 150, 15));
    lblSolMaxTempWert.setBorder(BorderFactory.createEtchedBorder());
    lblSolMaxTempWert.setBounds(new Rectangle(150, 109, 60, 15));
    
    lblStartWert.setBounds(new Rectangle(10, 140, 150, 15));
    lblStartWertWert.setBorder(BorderFactory.createEtchedBorder());
    lblStartWertWert.setBounds(new Rectangle(150, 140, 60, 15));
    
    lblMaxWert.setBounds(new Rectangle(10, 170, 150, 15));
    lblMaxWertWert.setBorder(BorderFactory.createEtchedBorder());
    lblMaxWertWert.setBounds(new Rectangle(150, 169, 60, 15));
    
    lblHysterese.setBounds(new Rectangle(10, 200, 150, 15));
    
    lblHystereseWert.setBorder(BorderFactory.createEtchedBorder());
    lblHystereseWert.setHorizontalAlignment(4);
    
    lblHystereseWert.setBounds(new Rectangle(150, 200, 60, 15));
    
    txtBezeichnung.setBounds(new Rectangle(200, 47, 130, 21));
    
    cboLuefterAuswahl.setBounds(new Rectangle(200, 17, 130, 21));
    cboLuefterAuswahl.setActionCommand("0");
    cboStatus.setBounds(new Rectangle(200, 77, 130, 21));
    cboStatus.setActionCommand("1");
    
    cboDrehFunkt.setBounds(new Rectangle(200, 107, 130, 21));
    cboDrehFunkt.setActionCommand("2");
    cboAktionAusfall.setBounds(new Rectangle(200, 177, 130, 21));
    cboMaxDrehEr.setBounds(new Rectangle(200, 207, 130, 21));
    
    cboTachoFaktor.setBounds(new Rectangle(200, 237, 130, 21));
    cboSensorA.setBounds(new Rectangle(200, 267, 130, 21));
    cboSensorA.setActionCommand("6");
    cboSensorB.setBounds(new Rectangle(400, 267, 130, 21));
    cboSensorB.setActionCommand("6");
    
    cboManuellAuto.setBounds(new Rectangle(200, 299, 130, 22));
    cboManuellAuto.setActionCommand("8");
    
    cboTyp.setBounds(new Rectangle(150, 17, 140, 21));
    cboTyp.setActionCommand("9");
    
    cboRegelungEinheit.setBounds(new Rectangle(150, 47, 66, 21));
    cboRegelungEinheit.setActionCommand("10");
    
    chkAbschalt.setHorizontalAlignment(2);
    chkAbschalt.setHorizontalTextPosition(10);
    chkAbschalt.setBounds(new Rectangle(13, 141, 275, 23));
    
    rbtManLuefterDr.setBounds(new Rectangle(10, 90, 104, 15));
    rbtManLuefterDr.setActionCommand("1");
    rbtManLuefterSp.setBounds(new Rectangle(10, 60, 117, 15));
    rbtManLuefterSp.setActionCommand("0");
    chkLivelis.setBounds(new Rectangle(10, 10, 457, 21));
    
    buttonGroup2.add(rbtManLuefterDr);
    buttonGroup2.add(rbtManLuefterSp);
    
    butDrehzahl.setBounds(new Rectangle(332, 208, 100, 21));
    butDrehzahl.setActionCommand("6");
    
    sliStartTemp.setBounds(new Rectangle(210, 76, 200, 24));
    sliSollMaxTemp.setBounds(new Rectangle(210, 106, 200, 24));
    sliStartVolt.setBounds(new Rectangle(210, 136, 200, 24));
    sliMaxVolt.setBounds(new Rectangle(210, 166, 200, 24));
    sliStartDreh.setBounds(new Rectangle(210, 136, 200, 24));
    sliMaxDreh.setBounds(new Rectangle(210, 166, 200, 24));
    sliHysterese.setBounds(new Rectangle(210, 196, 200, 24));
    
    sliSpannung.setBounds(new Rectangle(210, 72, 200, 24));
    sliDrehzahl.setBounds(new Rectangle(210, 72, 200, 24));
    
    pnlManuell.setBorder(BorderFactory.createEtchedBorder());
    pnlManuell.add(rbtManLuefterSp);
    
    pnlManuell.add(sliSpannung);
    pnlManuell.add(sliDrehzahl);
    pnlManuell.add(rbtManLuefterDr);
    pnlManuell.add(lblManLuefterSpWert);
    pnlManuell.add(chkLivelis);
    
    pnlManuell.setBounds(new Rectangle(6, 330, 550, 240));
    pnlManuell.setLayout(null);
    
    pnlAutoSteuer.add(lblTyp);
    pnlAutoSteuer.add(lblRegelungEinheit);
    pnlAutoSteuer.add(lblStartTemp);
    pnlAutoSteuer.add(lblMaxWert);
    pnlAutoSteuer.add(lblStartWert);
    pnlAutoSteuer.add(lblSollMaxTemp);
    pnlAutoSteuer.add(lblHysterese);
    pnlAutoSteuer.add(cboTyp);
    pnlAutoSteuer.add(cboRegelungEinheit);
    pnlAutoSteuer.add(lblStartTempWert);
    pnlAutoSteuer.add(lblSolMaxTempWert);
    pnlAutoSteuer.add(sliStartTemp);
    pnlAutoSteuer.add(sliSollMaxTemp);
    pnlAutoSteuer.add(lblHystereseWert);
    pnlAutoSteuer.add(sliHysterese);
    pnlAutoSteuer.add(lblStartWertWert);
    pnlAutoSteuer.add(sliStartVolt);
    pnlAutoSteuer.add(sliMaxVolt);
    pnlAutoSteuer.add(sliStartDreh);
    pnlAutoSteuer.add(sliMaxDreh);
    pnlAutoSteuer.add(lblMaxWertWert);
    pnlAutoSteuer.setBounds(new Rectangle(6, 330, 550, 240));
    pnlAutoSteuer.setLayout(null);
    pnlAutoSteuer.setBorder(BorderFactory.createEtchedBorder());
    
    add(lblAktionAusfall);
    add(cboAktionAusfall);
    add(lblMaxDrehermit);
    add(cboMaxDrehEr);
    add(lblTachoFaktor);
    add(lblSensorA);
    add(lblRegelung);
    add(cboSensorA);
    add(cboTachoFaktor);
    add(lblMaxDreh);
    add(cboSensorB);
    add(lblSensorB);
    add(chkAbschalt);
    add(lblDrehFunkt);
    add(lblLuefterAuswahl);
    add(lblBezeichnung);
    add(lblStatus);
    add(cboLuefterAuswahl);
    add(txtBezeichnung);
    add(cboStatus);
    add(cboDrehFunkt);
    add(pnlAutoSteuer);
    add(lblMinDreh);
    add(butDrehzahl);
    add(pnlManuell);
    add(cboManuellAuto);
    setLayout(null);
  }
  
  public void actionPerformed(ActionEvent e)
  {
    RE_ComboBox combo = (RE_ComboBox)e.getSource();
    switch (Integer.parseInt(combo.getActionCommand()))
    {
    case 0: 
      combo.aktualisiereAltNeu();
      
      cfg.LUEFTER_AUSWAHL = combo.getOldSelectedIndex();
      speicherEinstellung();
      
      cfg.LUEFTER_AUSWAHL = combo.getSelectedIndex();
      removeListener();
      setzeSprache();
      
      break;
    case 1: 
      switch (combo.getSelectedIndex())
      {
      case 0: 
      case 1: 
        pnlAutoSteuer.setEnabled(false);
        pnlManuell.setEnabled(false);
        
        cboAktionAusfall.setEnabled(false);
        cboDrehFunkt.setEnabled(false);
        cboMaxDrehEr.setEnabled(false);
        cboSensorA.setEnabled(false);
        cboSensorB.setEnabled(false);
        cboTachoFaktor.setEnabled(false);
        cboRegelungEinheit.setEnabled(false);
        cboTyp.setEnabled(false);
        cboManuellAuto.setEnabled(false);
        
        chkAbschalt.setEnabled(false);
        
        sliSpannung.setEnabled(false);
        sliHysterese.setEnabled(false);
        sliStartTemp.setEnabled(false);
        sliSollMaxTemp.setEnabled(false);
        sliStartVolt.setEnabled(false);
        sliStartDreh.setEnabled(false);
        sliHysterese.setEnabled(false);
        sliMaxVolt.setEnabled(false);
        sliMaxDreh.setEnabled(false);
        
        rbtManLuefterDr.setEnabled(false);
        rbtManLuefterSp.setEnabled(false);
        
        butDrehzahl.setVisible(false);
        
        pnlManuell.setVisible(false);
        pnlAutoSteuer.setVisible(false);
        
        break;
      case 2: 
        sliSpannung.setEnabled(true);
        cboDrehFunkt.setEnabled(true);
        cboSensorA.setEnabled(true);
        
        cboManuellAuto.setEnabled(true);
        rbtManLuefterSp.setEnabled(true);
        if (cfg.LUEFTER_MANUELL_AUTO[cfg.LUEFTER_AUSWAHL] == 1)
        {
          pnlAutoSteuer.setVisible(true);
          pnlManuell.setVisible(false);
        }
        else
        {
          pnlAutoSteuer.setVisible(false);
          pnlManuell.setVisible(true);
        }
        break;
      }
      break;
    case 2: 
      if (combo.isEnabled()) {
        switch (combo.getSelectedIndex())
        {
        case 0: 
        case 1: 
          cboAktionAusfall.setEnabled(false);
          cboMaxDrehEr.setEnabled(false);
          cboTachoFaktor.setEnabled(false);
          
          cboRegelungEinheit.aktualisiere();
          chkAbschalt.setEnabled(false);
          chkAbschalt.setSelected(false);
          
          rbtManLuefterDr.setEnabled(false);
          rbtManLuefterSp.setSelected(true);
          butDrehzahl.setVisible(false);
          
          break;
        case 2: 
          cboAktionAusfall.setEnabled(true);
          cboMaxDrehEr.setEnabled(true);
          cboTachoFaktor.setEnabled(true);
          
          cboSensorA.setEnabled(true);
          cboSensorB.setEnabled(true);
          
          chkAbschalt.setEnabled(true);
          
          rbtManLuefterDr.setEnabled(true);
          
          butDrehzahl.setVisible(true);
        }
      }
      break;
    case 3: 
      break;
    case 4: 
      break;
    case 5: 
      break;
    case 6: 
      if (cboStatus.getSelectedIndex() == 2) {
        if ((cboSensorA.getSelectedIndex() == 0) && 
          (cboSensorB.getSelectedIndex() == 0))
        {
          pnlAutoSteuer.setEnabled(false);
          
          cboSensorB.setEnabled(false);
          cboTyp.setEnabled(false);
          cboRegelungEinheit.setEnabled(false);
          
          sliHysterese.setEnabled(false);
          sliStartTemp.setEnabled(false);
          sliSollMaxTemp.setEnabled(false);
          sliStartVolt.setEnabled(false);
          sliStartDreh.setEnabled(false);
          sliHysterese.setEnabled(false);
          sliMaxVolt.setEnabled(false);
          sliMaxDreh.setEnabled(false);
          
          cboManuellAuto.setSelectedIndex(0);
          cboManuellAuto.setEnabled(false);
        }
        else
        {
          pnlAutoSteuer.setEnabled(true);
          
          cboSensorB.setEnabled(true);
          cboTyp.setEnabled(true);
          cboRegelungEinheit.setEnabled(true);
          
          sliHysterese.setEnabled(true);
          sliSpannung.setEnabled(true);
          sliHysterese.setEnabled(true);
          sliStartTemp.setEnabled(true);
          sliSollMaxTemp.setEnabled(true);
          sliStartVolt.setEnabled(true);
          sliMaxVolt.setEnabled(true);
          sliStartDreh.setEnabled(true);
          sliMaxDreh.setEnabled(true);
          
          cboManuellAuto.setEnabled(true);
        }
      }
      break;
    case 7: 
      break;
    case 8: 
      if (cboStatus.getSelectedIndex() == 2)
      {
        cfg.LUEFTER_MANUELL_AUTO[cfg.LUEFTER_AUSWAHL] = 
          combo.getSelectedIndex();
        switch (combo.getSelectedIndex())
        {
        case 0: 
          pnlAutoSteuer.setVisible(false);
          pnlManuell.setVisible(true);
          
          break;
        case 1: 
          pnlAutoSteuer.setVisible(true);
          pnlManuell.setVisible(false);
        }
      }
      break;
    case 9: 
      switch (combo.getSelectedIndex())
      {
      case 0: 
      case 2: 
        lblSollMaxTemp.setText(spr.MAXTEMP);
        sliSollMaxTemp.setValue(cfg.LUEFTER_MAXTEMP[cfg.LUEFTER_AUSWAHL]);
        break;
      case 1: 
        lblSollMaxTemp.setText(spr.SOLLTEMP);
        sliSollMaxTemp.setValue(cfg.LUEFTER_SOLLTEMP[cfg.LUEFTER_AUSWAHL]);
      }
      break;
    case 10: 
      if ((drehMax == 0) && (combo.getSelectedIndex() == 2))
      {
        combo.setSelectedIndex(1);
        return;
      }
      if (cboDrehFunkt.getSelectedIndex() != 2)
      {
        combo.setSelectedIndex(1);
        combo.setEnabled(false);
      }
      else
      {
        combo.setEnabled(true);
      }
      switch (combo.getSelectedIndex())
      {
      case 0: 
        lblStartWert.setVisible(false);
        lblStartWertWert.setVisible(false);
        lblMaxWert.setVisible(false);
        lblMaxWertWert.setVisible(false);
        sliStartVolt.setVisible(false);
        sliMaxVolt.setVisible(false);
        sliStartDreh.setVisible(false);
        sliMaxDreh.setVisible(false);
        break;
      case 1: 
        lblStartWert.setVisible(true);
        lblStartWertWert.setVisible(true);
        lblMaxWert.setVisible(true);
        lblMaxWertWert.setVisible(true);
        sliStartVolt.setVisible(true);
        sliMaxVolt.setVisible(true);
        sliStartDreh.setVisible(false);
        sliMaxDreh.setVisible(false);
        try
        {
          sliStartVolt.removeAllSliListeners();
          sliMaxVolt.removeAllSliListeners();
        }
        catch (Exception localException) {}
        sliStartVolt.addChangeListener(startWertSpanLis);
        sliStartVolt.setValue(cfg.LUEFTER_STARTWERT_SPANNUNG[
          cfg.LUEFTER_AUSWAHL]);
        sliStartVolt.aktualisiere();
        sliMaxVolt.addChangeListener(maxDrehSpanLis);
        sliMaxVolt.setValue(cfg.LUEFTER_MAX_SPANNUNG[cfg.LUEFTER_AUSWAHL]);
        sliMaxVolt.aktualisiere();
        
        break;
      case 2: 
        lblStartWert.setVisible(true);
        lblStartWertWert.setVisible(true);
        lblMaxWert.setVisible(true);
        lblMaxWertWert.setVisible(true);
        sliStartVolt.setVisible(false);
        sliMaxVolt.setVisible(false);
        sliStartDreh.setVisible(true);
        sliMaxDreh.setVisible(true);
        if (drehMax > 0)
        {
          try
          {
            sliStartDreh.removeAllSliListeners();
            sliMaxDreh.removeAllSliListeners();
          }
          catch (Exception localException1) {}
          sliStartDreh.addChangeListener(startWertDrehLis);
          sliStartDreh.setValue(cfg.LUEFTER_STARTWERT_DREHZAHL[
            cfg.LUEFTER_AUSWAHL]);
          sliMaxDreh.addChangeListener(maxDrehDrehLis);
          sliMaxDreh.setValue(cfg.LUEFTER_MAX_DREHZAHL[cfg.LUEFTER_AUSWAHL]);
        }
        else
        {
          combo.setSelectedIndex(1);
        }
        break;
      }
      break;
    }
  }
  
  public void ladeKonfig()
  {
    ladenAktiv = true;
    
    removeListener();
    
    setzeSprache();
    ladenAktiv = false;
  }
  
  public class LuefterWahlListener
    implements ActionListener
  {
    public LuefterWahlListener() {}
    
    public void actionPerformed(ActionEvent e)
    {
      RE_ComboBox combo = (RE_ComboBox)e.getSource();
      
      combo.aktualisiereAltNeu();
      
      cfg.LUEFTER_AUSWAHL = combo.getOldSelectedIndex();
      speicherEinstellung();
      cfg.LUEFTER_AUSWAHL = combo.getSelectedIndex();
      setzeEinstellung();
      if (cboManuellAuto.getSelectedIndex() == 0) {
        rbtManLuefterSp.aktualisiere();
      }
    }
  }
  
  public class ManuellAutoListener
    implements ChangeListener
  {
    public ManuellAutoListener() {}
    
    public void stateChanged(ChangeEvent e)
    {
      JRadioButton radio = (JRadioButton)e.getSource();
      if ((radio.isEnabled()) && (cboStatus.getSelectedIndex() == 2) && 
        (radio.hasFocus())) {
        if ((radio.getActionCommand().equals(spr.MANUELL)) && 
          (radio.isSelected()))
        {
          pnlAutoSteuer.setVisible(false);
          pnlManuell.setVisible(true);
        }
        else if ((radio.getActionCommand().equals(spr.AUTOMATISCH)) && 
          (radio.isSelected()))
        {
          pnlManuell.setVisible(false);
          pnlAutoSteuer.setVisible(true);
        }
      }
    }
  }
  
  public class ManSpanDrehlistener
    implements ChangeListener
  {
    public ManSpanDrehlistener() {}
    
    public void stateChanged(ChangeEvent e)
    {
      JRadioButton radio = (JRadioButton)e.getSource();
      if ((radio.isEnabled()) && (cboStatus.getSelectedIndex() == 2) && 
        (radio.isSelected())) {
        switch (Integer.parseInt(radio.getActionCommand()))
        {
        case 0: 
          sliSpannung.setVisible(true);
          sliSpannung.aktualisiere();
          sliDrehzahl.setVisible(false);
          chkLivelis.setEnabled(true);
          break;
        case 1: 
          sliSpannung.setVisible(false);
          sliDrehzahl.setVisible(true);
          if (cfg.isLuefterManuell(cboLuefterAuswahl.getSelectedIndex()))
          {
            chkLivelis.setText(spr.LIVEREGELUNG_AKTIV);
            chkLivelis.setEnabled(true);
          }
          else
          {
            chkLivelis.setText(spr.LIVEREGELUNG_AKTIV_SPEICHERN);
            chkLivelis.setEnabled(false);
          }
          if (drehMax > 0)
          {
            try
            {
              sliDrehzahl.removeAllSliOhneLive();
            }
            catch (Exception e1) {}
            sliDrehzahl.addChangeListener(spanDrehLis);
          }
          else
          {
            try
            {
              sliDrehzahl.removeAllSliOhneLive();
            }
            catch (Exception e1) {}
            sliDrehzahl.addChangeListener(spanProLis);
          }
          sliDrehzahl.aktualisiere();
        }
      }
    }
  }
  
  public class CboTypListener
    implements ActionListener
  {
    public CboTypListener() {}
    
    public void actionPerformed(ActionEvent e)
    {
      RE_ComboBox combo = (RE_ComboBox)e.getSource();
      
      cfg.LUEFTER_TYP[cfg.LUEFTER_AUSWAHL] = combo.getSelectedIndex();
      switch (combo.getOldSelectedIndex())
      {
      case 0: 
      case 2: 
        cfg.LUEFTER_MAXTEMP[cfg.LUEFTER_AUSWAHL] = 
          sliSollMaxTemp.getValue();
        break;
      case 1: 
        cfg.LUEFTER_SOLLTEMP[cfg.LUEFTER_AUSWAHL] = 
          sliSollMaxTemp.getValue();
      }
      switch (combo.getSelectedIndex())
      {
      case 0: 
      case 2: 
        lblSollMaxTemp.setText(spr.MAXTEMP);
        sliSollMaxTemp.setValue(cfg.LUEFTER_MAXTEMP[cfg.LUEFTER_AUSWAHL]);
        break;
      case 1: 
        lblSollMaxTemp.setText(spr.SOLLTEMP);
        sliSollMaxTemp.setValue(cfg.LUEFTER_SOLLTEMP[cfg.LUEFTER_AUSWAHL]);
      }
    }
  }
  
  public class RegelungEinheitListener
    implements ActionListener
  {
    public RegelungEinheitListener() {}
    
    public void actionPerformed(ActionEvent e)
    {
      RE_ComboBox combo = (RE_ComboBox)e.getSource();
      
      cfg.LUEFTER_REGELUNG_EINHEIT[cfg.LUEFTER_AUSWAHL] = 
        combo.getSelectedIndex();
      if ((drehMax == 0) && (combo.getSelectedIndex() == 2))
      {
        combo.setSelectedIndex(1);
        return;
      }
      switch (combo.getOldSelectedIndex())
      {
      case 0: 
        break;
      case 1: 
        cfg.LUEFTER_STARTWERT_SPANNUNG[
          cfg.LUEFTER_AUSWAHL] = sliStartVolt.getValue();
        cfg.LUEFTER_MAX_SPANNUNG[cfg.LUEFTER_AUSWAHL] = 
          sliMaxVolt.getValue();
        
        break;
      case 2: 
        cfg.LUEFTER_STARTWERT_DREHZAHL[
          cfg.LUEFTER_AUSWAHL] = sliStartDreh.getValue();
        cfg.LUEFTER_MAX_DREHZAHL[cfg.LUEFTER_AUSWAHL] = 
          sliMaxDreh.getValue();
      }
      if (cboDrehFunkt.getSelectedIndex() != 2)
      {
        combo.setSelectedIndex(1);
        combo.setEnabled(false);
      }
      else
      {
        combo.setEnabled(true);
      }
      switch (combo.getSelectedIndex())
      {
      case 0: 
        lblStartWert.setVisible(false);
        lblStartWertWert.setVisible(false);
        lblMaxWert.setVisible(false);
        lblMaxWertWert.setVisible(false);
        sliStartVolt.setVisible(false);
        sliMaxVolt.setVisible(false);
        sliStartDreh.setVisible(false);
        sliMaxDreh.setVisible(false);
        break;
      case 1: 
        lblStartWert.setVisible(true);
        lblStartWertWert.setVisible(true);
        lblMaxWert.setVisible(true);
        lblMaxWertWert.setVisible(true);
        sliStartVolt.setVisible(true);
        sliMaxVolt.setVisible(true);
        sliStartDreh.setVisible(false);
        sliMaxDreh.setVisible(false);
        try
        {
          sliStartVolt.removeAllSliListeners();
          sliMaxVolt.removeAllSliListeners();
        }
        catch (Exception e1) {}
        sliStartVolt.addChangeListener(startWertSpanLis);
        sliStartVolt.setValue(cfg.LUEFTER_STARTWERT_SPANNUNG[
          cfg.LUEFTER_AUSWAHL]);
        sliMaxVolt.addChangeListener(maxDrehSpanLis);
        sliMaxVolt.setValue(cfg.LUEFTER_MAX_SPANNUNG[cfg.LUEFTER_AUSWAHL]);
        
        break;
      case 2: 
        lblStartWert.setVisible(true);
        lblStartWertWert.setVisible(true);
        lblMaxWert.setVisible(true);
        lblMaxWertWert.setVisible(true);
        sliStartVolt.setVisible(false);
        sliMaxVolt.setVisible(false);
        sliStartDreh.setVisible(true);
        sliMaxDreh.setVisible(true);
        if (drehMax > 0)
        {
          try
          {
            sliStartDreh.removeAllSliListeners();
            sliMaxDreh.removeAllSliListeners();
          }
          catch (Exception e1) {}
          sliStartDreh.addChangeListener(startWertDrehLis);
          sliStartDreh.setValue(cfg.LUEFTER_STARTWERT_DREHZAHL[
            cfg.LUEFTER_AUSWAHL]);
          sliMaxDreh.addChangeListener(maxDrehDrehLis);
          sliMaxDreh.setValue(cfg.LUEFTER_MAX_DREHZAHL[cfg.LUEFTER_AUSWAHL]);
        }
        else
        {
          combo.setSelectedIndex(1);
        }
        break;
      }
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
        pnlAutoSteuer.setEnabled(false);
        pnlManuell.setEnabled(false);
        
        cboAktionAusfall.setEnabled(false);
        cboDrehFunkt.setEnabled(false);
        cboMaxDrehEr.setEnabled(false);
        cboSensorA.setEnabled(false);
        cboSensorB.setEnabled(false);
        cboTachoFaktor.setEnabled(false);
        cboRegelungEinheit.setEnabled(false);
        cboTyp.setEnabled(false);
        
        chkAbschalt.setEnabled(false);
        
        sliSpannung.setEnabled(false);
        sliHysterese.setEnabled(false);
        sliStartTemp.setEnabled(false);
        sliSollMaxTemp.setEnabled(false);
        sliStartVolt.setEnabled(false);
        sliStartDreh.setEnabled(false);
        sliHysterese.setEnabled(false);
        sliMaxVolt.setEnabled(false);
        sliMaxDreh.setEnabled(false);
        
        rbtManLuefterDr.setEnabled(false);
        rbtManLuefterSp.setEnabled(false);
        
        butDrehzahl.setVisible(false);
        
        break;
      case 2: 
        sliSpannung.setEnabled(true);
        cboDrehFunkt.setEnabled(true);
        cboSensorA.setEnabled(true);
        
        rbtManLuefterSp.setEnabled(true);
      }
    }
  }
  
  public class DrehzahlFunktionListener
    implements ActionListener
  {
    public DrehzahlFunktionListener() {}
    
    public void actionPerformed(ActionEvent e)
    {
      RE_ComboBox combo = (RE_ComboBox)e.getSource();
      if (combo.isEnabled()) {
        switch (combo.getSelectedIndex())
        {
        case 0: 
        case 1: 
          cboAktionAusfall.setEnabled(false);
          cboMaxDrehEr.setEnabled(false);
          cboTachoFaktor.setEnabled(false);
          
          cboRegelungEinheit.aktualisiere();
          chkAbschalt.setEnabled(false);
          
          rbtManLuefterDr.setEnabled(false);
          rbtManLuefterSp.setSelected(true);
          butDrehzahl.setVisible(false);
          
          break;
        case 2: 
          cboAktionAusfall.setEnabled(true);
          cboMaxDrehEr.setEnabled(true);
          cboTachoFaktor.setEnabled(true);
          
          cboSensorA.setEnabled(true);
          cboSensorB.setEnabled(true);
          
          chkAbschalt.setEnabled(true);
          
          rbtManLuefterDr.setEnabled(true);
          
          butDrehzahl.setVisible(true);
        }
      }
    }
  }
  
  public class SensorAListener
    implements ActionListener
  {
    public SensorAListener() {}
    
    public void actionPerformed(ActionEvent e)
    {
      if (cboStatus.getSelectedIndex() == 2)
      {
        pnlAutoSteuer.setEnabled(true);
        
        cboSensorB.setEnabled(true);
        cboTyp.setEnabled(true);
        cboRegelungEinheit.setEnabled(true);
        
        sliHysterese.setEnabled(true);
        sliSpannung.setEnabled(true);
        sliHysterese.setEnabled(true);
        sliStartTemp.setEnabled(true);
        sliSollMaxTemp.setEnabled(true);
        sliStartVolt.setEnabled(true);
        sliMaxVolt.setEnabled(true);
        sliStartDreh.setEnabled(true);
        sliMaxDreh.setEnabled(true);
      }
    }
  }
  
  public class AktivLiveListener
    implements ActionListener
  {
    public AktivLiveListener() {}
    
    public void actionPerformed(ActionEvent e)
    {
      RE_CheckBox check = (RE_CheckBox)e.getSource();
      if (!check.isSelected())
      {
        byte b = 63;
        
        int[] array = 
          {
          250, 250, 250, 250, 250, 250, b };
        comTab.setzeSchreiben(ComTabelle.getAdresse(1, true, false), array);
        try
        {
          comTab.starteRamSchreiben();
        }
        catch (Exception e1) {}
      }
    }
  }
  
  public class ButtonListener
    implements ActionListener
  {
    public ButtonListener() {}
    
    public void actionPerformed(ActionEvent e)
    {
      cfg.LUEFTER_AUSWAHL = cboLuefterAuswahl.getSelectedIndex();
      DialogLuefterKali dialog = new DialogLuefterKali(mFrame, 
        panel,comTab, daten, spr, cfg, comTab.master);
    }
  }
}

