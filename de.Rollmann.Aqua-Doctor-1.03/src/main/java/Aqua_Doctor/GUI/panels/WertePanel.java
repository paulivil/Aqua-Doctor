package Aqua_Doctor.GUI.panels;

import Aqua_Doctor.ressource.Daten;
import Aqua_Doctor.ressource.Sprache;
import Aqua_Doctor.tools.UmrechnungTool;
import de.Rollmann.komponenten.RE_WerteLabel;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DateFormat;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
import javax.swing.BorderFactory;
import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JProgressBar;
import javax.swing.border.EtchedBorder;
import javax.swing.border.TitledBorder;

public class WertePanel
  extends JPanel
{
  /**
	 * 
	 */
	private static final long serialVersionUID = -7107066648372943018L;
public JLabel lblDatum = new JLabel();
  public JLabel lblUhrzeit = new JLabel();
  public JLabel lblName1 = new JLabel();
  public JLabel lblName2 = new JLabel();
  public JLabel lblName3 = new JLabel();
  public JLabel lblL1 = new JLabel();
  public RE_WerteLabel lblL1Dreh = new RE_WerteLabel();
  public JLabel lblL2 = new JLabel();
  public RE_WerteLabel lblL2Dreh = new RE_WerteLabel();
  public JLabel lblL3 = new JLabel();
  public RE_WerteLabel lblL3Dreh = new RE_WerteLabel();
  public JLabel lblL4 = new JLabel();
  public RE_WerteLabel lblL4Dreh = new RE_WerteLabel();
  public JLabel lblL5 = new JLabel();
  public RE_WerteLabel lblL5Dreh = new RE_WerteLabel();
  public JLabel lblL6 = new JLabel();
  public RE_WerteLabel lblL6Dreh = new RE_WerteLabel();
  public JLabel lblNTC1 = new JLabel();
  public RE_WerteLabel lblNTC1Temp = new RE_WerteLabel();
  public JLabel lblNTC2 = new JLabel();
  public RE_WerteLabel lblNTC2Temp = new RE_WerteLabel();
  public JLabel lblNTC3 = new JLabel();
  public RE_WerteLabel lblNTC3Temp = new RE_WerteLabel();
  public JLabel lblNTC4 = new JLabel();
  public RE_WerteLabel lblNTC4Temp = new RE_WerteLabel();
  public JLabel lblNTC5 = new JLabel();
  public RE_WerteLabel lblNTC5Temp = new RE_WerteLabel();
  public JLabel lblNTC6 = new JLabel();
  public RE_WerteLabel lblNTC6Temp = new RE_WerteLabel();
  public JLabel lblW1 = new JLabel();
  public RE_WerteLabel lblW1Fluß = new RE_WerteLabel();
  public JLabel lblW2 = new JLabel();
  public RE_WerteLabel lblW2Fluß = new RE_WerteLabel();
  public JLabel lblW3 = new JLabel();
  public RE_WerteLabel lblW3Fluß = new RE_WerteLabel();
  public RE_WerteLabel lblWert1 = new RE_WerteLabel();
  public RE_WerteLabel lblWert2 = new RE_WerteLabel();
  public RE_WerteLabel lblWert3 = new RE_WerteLabel();
  public JLabel lblWasStandNAme = new JLabel();
  public JLabel lblWasStandPro = new JLabel();
  public JLabel lbl1 = new JLabel();
  public TitledBorder titledBorder1 = new TitledBorder("");
  public TitledBorder titledBorder2 = new TitledBorder("");
  public TitledBorder titledBorder3 = new TitledBorder("");
  public TitledBorder titledBorder4 = new TitledBorder("");
  public TitledBorder titledBorder5 = new TitledBorder("");
  public TitledBorder titledBorder6 = new TitledBorder("");
  public JProgressBar proBarWasStand = new JProgressBar();
  public JPanel pnlLuefter = new JPanel();
  public JPanel pnlTemp = new JPanel();
  public JPanel pnlPumpWasFluß = new JPanel();
  public JPanel pnlWasStand = new JPanel();
  public JPanel pnlVergleich = new JPanel();
  public ueLis ueLis = new ueLis();
  public DatumUhr datUhr;
  public Calendar cal;
  public DecimalFormat df = new DecimalFormat("###0.0");
  public Sprache spr;
  public Daten cfg;
  JPanel jPanel1 = new JPanel();
  GridLayout gridLayout1 = new GridLayout();
  JLabel lblPWM6 = new JLabel();
  JLabel lblPWM5 = new JLabel();
  JLabel lblPWM4 = new JLabel();
  JLabel lblPWM3 = new JLabel();
  JLabel lblPWM2 = new JLabel();
  JLabel lblPWM1 = new JLabel();
  private final JPanel pnlVersion = new JPanel();
  private final JLabel lblSerienNr = new JLabel();
  private final JLabel lblSerienNrWert = new JLabel();
  private final JLabel lblSWVersion = new JLabel();
  private final JLabel lblSWVersionWert = new JLabel();
  private final JLabel lblHWVersion = new JLabel();
  private final JLabel lblHWVersionWert = new JLabel();
  private final JLabel lblFehler = new JLabel();
  
  public WertePanel(Sprache s, Daten c)
  {
    try
    {
      spr = s;
      cfg = c;
      jbInit();
      datUhr = new DatumUhr();
    }
    catch (Exception e) {}
  }
  
  public void setzeFehlerLabel(String s)
  {
    lblFehler.setText(s);
  }
  
  public void setzeÜberwachung(boolean bol) {}
  
  public void enableÜberwachung(boolean bol) {}
  
  public void aktualisiere(int[] array)
  {
    setzeSprache();
    NumberFormat nf = NumberFormat.getInstance();
    nf.setMinimumIntegerDigits(6);
    nf.setMaximumIntegerDigits(10);
    
    DecimalFormat dFormat = new DecimalFormat("0,000");
    if (cfg.SERIEN_NR > 0L) {
      lblSerienNrWert.setText(nf.format(cfg.SERIEN_NR));
    }
    if (cfg.SW_VERSION > 0) {
      lblSWVersionWert.setText("V" + dFormat.format(cfg.SW_VERSION));
    }
    if (cfg.HW_VERSION > 0) {
      lblHWVersionWert.setText("V" + String.valueOf(cfg.HW_VERSION));
    }
    for (int i = 0; i < 6; i++)
    {
      String Anzeige = "";
      switch (cfg.LUEFTER_STATUS[i])
      {
      case 0: 
        Anzeige = spr.AUS;
        break;
      case 1: 
        Anzeige = spr.NV;
        break;
      case 2: 
        if (cfg.LUEFTER_DREHZAHLFUNK[i] == 2) {
          Anzeige = 
            Integer.toString(array[i]) + " " + spr.EINHEIT_UMDREHUNG;
        } else {
          Anzeige = spr.KEINE_DREHZAHL_FUNKTION;
        }
        break;
      }
      switch (i)
      {
      case 0: 
        checkLuefter(lblL1Dreh, i, array[i], array[(i + 16)]);
        lblL1Dreh.setText(Anzeige);
        break;
      case 1: 
        checkLuefter(lblL2Dreh, i, array[i], array[(i + 16)]);
        lblL2Dreh.setText(Anzeige);
        break;
      case 2: 
        checkLuefter(lblL3Dreh, i, array[i], array[(i + 16)]);
        lblL3Dreh.setText(Anzeige);
        break;
      case 3: 
        checkLuefter(lblL4Dreh, i, array[i], array[(i + 16)]);
        lblL4Dreh.setText(Anzeige);
        break;
      case 4: 
        checkLuefter(lblL5Dreh, i, array[i], array[(i + 16)]);
        lblL5Dreh.setText(Anzeige);
        break;
      case 5: 
        checkLuefter(lblL6Dreh, i, array[i], array[(i + 16)]);
        lblL6Dreh.setText(Anzeige);
      }
    }
    for (int i = 6; i < 12; i++)
    {
      String Anzeige = "";
      switch (cfg.SENSOR_STATUS[(i - 6)])
      {
      case 0: 
        Anzeige = spr.AUS;
        break;
      case 1: 
        Anzeige = spr.NV;
        break;
      case 2: 
        if ((array[i] >= 10000) || (array[i] == 0)) {
          Anzeige = spr.ERROR;
        } else {
          Anzeige = 
          
            df.format(UmrechnungTool.convertTemp(array[i] / 10.0F - 100.0F, cfg, false)) + " " + spr.EINHEIT_TEMPERATUR;
        }
        break;
      }
      switch (i)
      {
      case 6: 
        checkSensor(lblNTC1Temp, 0, array[i]);
        lblNTC1Temp.setText(Anzeige);
        break;
      case 7: 
        checkSensor(lblNTC2Temp, 1, array[i]);
        lblNTC2Temp.setText(Anzeige);
        break;
      case 8: 
        checkSensor(lblNTC3Temp, 2, array[i]);
        lblNTC3Temp.setText(Anzeige);
        break;
      case 9: 
        checkSensor(lblNTC4Temp, 3, array[i]);
        lblNTC4Temp.setText(Anzeige);
        break;
      case 10: 
        checkSensor(lblNTC5Temp, 4, array[i]);
        lblNTC5Temp.setText(Anzeige);
        break;
      case 11: 
        checkSensor(lblNTC6Temp, 5, array[i]);
        lblNTC6Temp.setText(Anzeige);
      }
    }
    if (cfg.WASSERFLUSS_STATUS[0] == 2)
    {
      checkPumpe(lblW1Fluß, 0, array[12]);
      lblW1Fluß.setText(Integer.toString(UmrechnungTool.convertDurchfluß(array[12], 0, cfg)) + 
        " " + cfg.WASSERFLUSS_SENSOR_EINEIT_STRING[0]);
    }
    else
    {
      if (cfg.WASSERFLUSS_STATUS[0] == 1) {
        lblW1Fluß.setText(spr.NV);
      } else {
        lblW1Fluß.setText(spr.AUS);
      }
      lblW1Fluß.setBackground(null);
      lblW1Fluß.setForeground(null);
    }
    if (cfg.WASSERFLUSS_STATUS[1] == 2)
    {
      checkPumpe(lblW2Fluß, 1, array[13]);
      lblW2Fluß.setText(Integer.toString(UmrechnungTool.convertDurchfluß(array[13], 1, cfg)) + 
        " " + cfg.WASSERFLUSS_SENSOR_EINEIT_STRING[1]);
    }
    else
    {
      if (cfg.WASSERFLUSS_STATUS[1] == 1) {
        lblW2Fluß.setText(spr.NV);
      } else {
        lblW2Fluß.setText(spr.AUS);
      }
      lblW2Fluß.setBackground(null);
      lblW2Fluß.setForeground(null);
    }
    if (cfg.WASSERFLUSS_STATUS[2] == 2)
    {
      checkPumpe(lblW3Fluß, 2, array[14]);
      lblW3Fluß.setText(Integer.toString(UmrechnungTool.convertDurchfluß(array[14], 2, cfg)) + 
        " " + cfg.WASSERFLUSS_SENSOR_EINEIT_STRING[2]);
    }
    else
    {
      if (cfg.WASSERFLUSS_STATUS[2] == 1) {
        lblW3Fluß.setText(spr.NV);
      } else {
        lblW3Fluß.setText(spr.AUS);
      }
      lblW3Fluß.setBackground(null);
      lblW3Fluß.setForeground(null);
    }
    if (cfg.WASSERSTAND_STATUS == 2) {
      switch (cfg.WASSERSTAND_TYP)
      {
      case 0: 
        lbl1.setVisible(true);
        proBarWasStand.setVisible(true);
        if (array[15] > 100)
        {
          lblWasStandPro.setText(spr.AUS);
          proBarWasStand.setValue(0);
        }
        else
        {
          lblWasStandPro.setText(Integer.toString(array[15]));
          proBarWasStand.setValue(array[15]);
        }
        break;
      case 1: 
        lbl1.setVisible(false);
        proBarWasStand.setVisible(false);
        if (array[15] >= 100) {
          lblWasStandPro.setText(spr.OK);
        } else {
          lblWasStandPro.setText(spr.ERROR);
        }
        break;
      }
    } else {
      lblWasStandPro.setText(spr.AUS);
    }
    lblName1.setText(cfg.TEMP_VERGLEICH_NAME[0]);
    lblName2.setText(cfg.TEMP_VERGLEICH_NAME[1]);
    lblName3.setText(cfg.TEMP_VERGLEICH_NAME[2]);
    for (int i = 0; i < 3; i++)
    {
      String s = new String ();
       if (cfg.TEMP_VERGLEICH_AKTIV[i] != false)
      {
        float wert1 = array[(cfg.TEMP_VERGLEICH_SENSOR1[i] + 5)] / 10.0F - 100.0F - (
          array[(cfg.TEMP_VERGLEICH_SENSOR2[i] + 5)] / 10.0F - 100.0F);
         if ((cfg.SENSOR_STATUS[(cfg.TEMP_VERGLEICH_SENSOR1[i] - 1)] != 2) || 
          (cfg.SENSOR_STATUS[(cfg.TEMP_VERGLEICH_SENSOR2[i] - 1)] != 2)) {
          s = spr.ERROR;
        } else {
          s = 
            df.format(wert1) + " " + spr.EINHEIT_TEMPERATUR;
        }
      }
      else
      {
        s = spr.AUS;
      }
      switch (i)
      {
      case 0: 
        lblWert1.setText(s);
        break;
      case 1: 
        lblWert2.setText(s);
        break;
      case 2: 
        lblWert3.setText(s);
      }
    }
    lblPWM1.setText(String.valueOf(array[16]));
    lblPWM2.setText(String.valueOf(array[17]));
    lblPWM3.setText(String.valueOf(array[18]));
    lblPWM4.setText(String.valueOf(array[19]));
    lblPWM5.setText(String.valueOf(array[20]));
    lblPWM6.setText(String.valueOf(array[21]));
  }
  
  public void setzeSprache()
  {
    lblL1.setText(cfg.LUEFTER_NAME[0]);
    lblL2.setText(cfg.LUEFTER_NAME[1]);
    lblL3.setText(cfg.LUEFTER_NAME[2]);
    lblL4.setText(cfg.LUEFTER_NAME[3]);
    lblL5.setText(cfg.LUEFTER_NAME[4]);
    lblL6.setText(cfg.LUEFTER_NAME[5]);
    
    lblNTC1.setText(cfg.SENSOR_NAME[0]);
    lblNTC2.setText(cfg.SENSOR_NAME[1]);
    lblNTC3.setText(cfg.SENSOR_NAME[2]);
    lblNTC4.setText(cfg.SENSOR_NAME[3]);
    lblNTC5.setText(cfg.SENSOR_NAME[4]);
    lblNTC6.setText(cfg.SENSOR_NAME[5]);
    
    lblW1.setText(cfg.WASSERFLUSS_NAME[0]);
    lblW2.setText(cfg.WASSERFLUSS_NAME[1]);
    lblW3.setText(cfg.WASSERFLUSS_NAME[2]);
    
    lblWasStandNAme.setText(cfg.WASSERSTAND_NAME);
    
    titledBorder1.setTitle(spr.TAB_LUEFTER);
    titledBorder2.setTitle(spr.TAB_NTC);
    titledBorder3.setTitle(spr.TAB_PUMPE);
    titledBorder4.setTitle(spr.TAB_WASSERSTAND);
    titledBorder5.setTitle(spr.TAB_VERGLEICH);
    titledBorder6.setTitle(spr.TAB_INFO);
    
    lblSerienNr.setText(spr.SERIEN_NR);
    lblHWVersion.setText(spr.HW_VERSION);
    lblSWVersion.setText(spr.SW_VERSION);
    
    repaint();
  }
  
  public void addUeLis() {}
  
  public void removeUeLis() {}
  
  public void jbInit()
    throws Exception
  {
    titledBorder1.setTitleFont(new Font("Dialog", 1, 11));
    titledBorder2.setTitleFont(new Font("Dialog", 1, 11));
    titledBorder3.setTitleFont(new Font("Dialog", 1, 11));
    titledBorder4.setTitleFont(new Font("Dialog", 1, 11));
    titledBorder5.setTitleFont(new Font("Dialog", 1, 11));
    titledBorder6.setTitleFont(new Font("Dialog", 1, 11));
    
    lblL1.setBounds(new Rectangle(7, 20, 166, 25));
    lblL1Dreh.setBorder(BorderFactory.createEtchedBorder());
    lblL1Dreh.setBounds(new Rectangle(179, 20, 75, 25));
    
    lblL2.setBounds(new Rectangle(7, 50, 166, 25));
    lblL2Dreh.setBorder(BorderFactory.createEtchedBorder());
    lblL2Dreh.setBounds(new Rectangle(179, 50, 75, 25));
    
    lblL3.setBounds(new Rectangle(7, 80, 166, 25));
    lblL3Dreh.setBorder(BorderFactory.createEtchedBorder());
    lblL3Dreh.setBounds(new Rectangle(179, 80, 75, 25));
    
    lblL4.setBounds(new Rectangle(7, 110, 166, 25));
    lblL4Dreh.setBorder(BorderFactory.createEtchedBorder());
    lblL4Dreh.setBounds(new Rectangle(179, 110, 75, 25));
    
    lblL5.setBounds(new Rectangle(7, 140, 166, 25));
    lblL5Dreh.setBorder(BorderFactory.createEtchedBorder());
    lblL5Dreh.setBounds(new Rectangle(179, 140, 75, 25));
    
    lblL6.setBounds(new Rectangle(7, 170, 166, 25));
    lblL6Dreh.setBorder(BorderFactory.createEtchedBorder());
    lblL6Dreh.setBounds(new Rectangle(179, 170, 75, 25));
    
    lblNTC1.setBounds(new Rectangle(6, 20, 167, 25));
    lblNTC1Temp.setBorder(BorderFactory.createEtchedBorder());
    lblNTC1Temp.setBounds(new Rectangle(179, 20, 75, 25));
    
    lblNTC2.setBounds(new Rectangle(6, 50, 167, 25));
    lblNTC2Temp.setBorder(BorderFactory.createEtchedBorder());
    lblNTC2Temp.setBounds(new Rectangle(179, 51, 75, 25));
    
    lblNTC3.setBounds(new Rectangle(6, 80, 167, 25));
    lblNTC3Temp.setBorder(BorderFactory.createEtchedBorder());
    lblNTC3Temp.setBounds(new Rectangle(179, 82, 75, 25));
    
    lblNTC4.setBounds(new Rectangle(6, 110, 167, 25));
    lblNTC4Temp.setBorder(BorderFactory.createEtchedBorder());
    lblNTC4Temp.setBounds(new Rectangle(179, 113, 75, 25));
    
    lblNTC5.setBounds(new Rectangle(6, 140, 167, 25));
    lblNTC5Temp.setBorder(BorderFactory.createEtchedBorder());
    lblNTC5Temp.setBounds(new Rectangle(179, 144, 75, 25));
    
    lblNTC6.setBounds(new Rectangle(6, 170, 167, 25));
    lblNTC6Temp.setBorder(BorderFactory.createEtchedBorder());
    lblNTC6Temp.setBounds(new Rectangle(179, 175, 75, 25));
    
    lblW1.setBounds(new Rectangle(15, 20, 158, 25));
    lblW1Fluß.setBorder(BorderFactory.createEtchedBorder());
    lblW1Fluß.setBounds(new Rectangle(179, 20, 75, 25));
    
    lblW2.setBounds(new Rectangle(15, 50, 158, 25));
    lblW2Fluß.setBorder(BorderFactory.createEtchedBorder());
    lblW2Fluß.setBounds(new Rectangle(180, 50, 75, 25));
    
    lblW3.setBounds(new Rectangle(15, 80, 158, 25));
    lblW3Fluß.setBorder(BorderFactory.createEtchedBorder());
    lblW3Fluß.setBounds(new Rectangle(179, 80, 75, 25));
    
    lblWasStandNAme.setBounds(new Rectangle(11, 20, 243, 24));
    lblWasStandPro.setFont(new Font("Dialog", 0, 30));
    lblWasStandPro.setHorizontalAlignment(0);
    lblWasStandPro.setHorizontalTextPosition(0);
    lblWasStandPro.setBounds(new Rectangle(10, 50, 67, 54));
    
    lbl1.setFont(new Font("Dialog", 0, 20));
    lbl1.setText("%");
    lbl1.setBounds(new Rectangle(79, 52, 25, 44));
    
    lblName1.setBounds(new Rectangle(15, 20, 158, 25));
    lblName2.setBounds(new Rectangle(15, 50, 158, 25));
    lblName3.setBounds(new Rectangle(15, 80, 158, 25));
    
    lblWert1.setBorder(BorderFactory.createEtchedBorder());
    lblWert2.setBorder(BorderFactory.createEtchedBorder());
    lblWert3.setBorder(BorderFactory.createEtchedBorder());
    
    lblWert1.setBounds(new Rectangle(179, 20, 75, 25));
    lblWert2.setBounds(new Rectangle(179, 50, 75, 25));
    lblWert3.setBounds(new Rectangle(179, 80, 75, 25));
    pnlLuefter.setBorder(titledBorder1);
    pnlLuefter.setBounds(new Rectangle(19, 60, 264, 207));
    pnlLuefter.setLayout(null);
    
    pnlTemp.setBorder(titledBorder2);
    pnlTemp.setBounds(new Rectangle(289, 60, 264, 207));
    pnlTemp.setLayout(null);
    
    pnlPumpWasFluß.setBorder(titledBorder3);
    pnlPumpWasFluß.setBounds(new Rectangle(19, 276, 264, 117));
    pnlPumpWasFluß.setLayout(null);
    
    pnlWasStand.setBorder(titledBorder4);
    pnlWasStand.setBounds(new Rectangle(289, 276, 264, 117));
    pnlWasStand.setLayout(null);
    
    pnlVergleich.setBorder(titledBorder5);
    pnlVergleich.setBounds(new Rectangle(19, 406, 264, 117));
    pnlVergleich.setLayout(null);
    
    lblDatum.setBorder(null);
    lblDatum.setBounds(new Rectangle(26, 19, 131, 15));
    lblUhrzeit.setBorder(null);
    lblUhrzeit.setBounds(new Rectangle(210, 19, 147, 15));
    setBorder(BorderFactory.createEtchedBorder());
    setMaximumSize(new Dimension(570, 578));
    setPreferredSize(new Dimension(570, 578));
    jPanel1.setBorder(titledBorder1);
    jPanel1.setMinimumSize(new Dimension(220, 50));
    jPanel1.setPreferredSize(new Dimension(220, 50));
    jPanel1.setBounds(new Rectangle(19, 534, 391, 37));
    jPanel1.setLayout(gridLayout1);
    lblPWM6.setBorder(null);
    lblPWM6.setText("jLabel1");
    lblPWM5.setText("jLabel2");
    lblPWM4.setText("jLabel3");
    lblPWM3.setText("jLabel4");
    lblPWM2.setText("jLabel5");
    lblPWM1.setText("jLabel6");
    
    pnlLuefter.add(lblL1);
    pnlLuefter.add(lblL2);
    pnlLuefter.add(lblL3);
    pnlLuefter.add(lblL4);
    pnlLuefter.add(lblL5);
    pnlLuefter.add(lblL6);
    pnlLuefter.add(lblL1Dreh);
    pnlLuefter.add(lblL2Dreh);
    pnlLuefter.add(lblL3Dreh);
    pnlLuefter.add(lblL4Dreh);
    pnlLuefter.add(lblL5Dreh);
    pnlLuefter.add(lblL6Dreh);
    pnlTemp.add(lblNTC1);
    pnlTemp.add(lblNTC1Temp);
    pnlTemp.add(lblNTC2);
    pnlTemp.add(lblNTC2Temp);
    pnlTemp.add(lblNTC3);
    pnlTemp.add(lblNTC3Temp);
    pnlTemp.add(lblNTC4);
    pnlTemp.add(lblNTC4Temp);
    pnlTemp.add(lblNTC5);
    pnlTemp.add(lblNTC5Temp);
    pnlTemp.add(lblNTC6);
    pnlTemp.add(lblNTC6Temp);
    
    pnlPumpWasFluß.add(lblW1);
    pnlPumpWasFluß.add(lblW2);
    pnlPumpWasFluß.add(lblW3);
    pnlPumpWasFluß.add(lblW1Fluß);
    pnlPumpWasFluß.add(lblW2Fluß);
    pnlPumpWasFluß.add(lblW3Fluß);
    pnlWasStand.add(lblWasStandNAme);
    pnlWasStand.add(proBarWasStand);
    pnlWasStand.add(lbl1);
    pnlWasStand.add(lblWasStandPro);
    
    pnlVergleich.add(lblName1);
    pnlVergleich.add(lblName2);
    pnlVergleich.add(lblName3);
    pnlVergleich.add(lblWert1);
    pnlVergleich.add(lblWert2);
    pnlVergleich.add(lblWert3);
    add(pnlWasStand);
    add(pnlTemp);
    
    proBarWasStand.setOrientation(1);
    proBarWasStand.setBounds(new Rectangle(108, 44, 32, 64));
    add(lblUhrzeit);
    add(pnlLuefter);
    add(lblDatum);
    add(pnlPumpWasFluß);
    add(pnlVergleich);
    
    jPanel1.add(lblPWM1);
    jPanel1.add(lblPWM2);
    jPanel1.add(lblPWM3);
    jPanel1.add(lblPWM4);
    jPanel1.add(lblPWM5);
    jPanel1.add(lblPWM6);
    
    setLayout(null);
    setVisible(true);
    setMinimumSize(new Dimension(570, 578));
    setzeSprache();
    requestFocus();
    repaint();
    
    add(pnlVersion);
    pnlVersion.setLayout(null);
    pnlVersion.setBounds(289, 406, 264, 117);
    
    pnlVersion.setBorder(titledBorder6);
    
    pnlVersion.add(lblSerienNr);
    lblSerienNr.setBounds(15, 20, 114, 25);
    
    pnlVersion.add(lblSerienNrWert);
    lblSerienNrWert.setBounds(130, 20, 114, 25);
    
    pnlVersion.add(lblSWVersion);
    lblSWVersion.setBounds(15, 50, 114, 25);
    
    pnlVersion.add(lblSWVersionWert);
    lblSWVersionWert.setBounds(130, 50, 114, 25);
    
    pnlVersion.add(lblHWVersion);
    lblHWVersion.setBounds(15, 80, 114, 25);
    
    pnlVersion.add(lblHWVersionWert);
    lblHWVersionWert.setBounds(130, 81, 114, 25);
    
    add(lblFehler);
    lblFehler.setBorder(new EtchedBorder(1));
    lblFehler.setFont(new Font("Arial", 0, 12));
    lblFehler.setBounds(19, 552, 534, 25);
  }
  
  public void checkLuefter(RE_WerteLabel label, int luefter, int wert, int pwm)
  {
    if ((cfg.LUEFTER_STATUS[luefter] == 2) && 
      (cfg.LUEFTER_DREHZAHLFUNK[luefter] == 2))
    {
      float help = wert / 10.0F - 100.0F;
      if ((pwm > 0) && (wert == 0))
      {
        label.setBackground(Color.RED);
        label.setForeground(Color.RED);
      }
      else
      {
        label.setBackground(null);
        label.setForeground(null);
      }
    }
    else
    {
      label.setBackground(null);
      label.setForeground(null);
    }
  }
  
  public void checkSensor(RE_WerteLabel label, int sensor, int wert)
  {
    if (cfg.SENSOR_STATUS[sensor] == 2)
    {
      float help = wert / 10.0F - 100.0F;
      if (help >= cfg.SENSOR_ALARMWERT[sensor] / 10.0F)
      {
        label.setBackground(Color.RED);
        label.setForeground(Color.RED);
      }
      else if (help >= cfg.SENSOR_WARNWERT[sensor] / 10.0F)
      {
        label.setBackground(Color.ORANGE);
      }
      else
      {
        label.setBackground(null);
        label.setForeground(null);
      }
    }
    else
    {
      label.setBackground(null);
      label.setForeground(null);
    }
  }
  
  public void checkPumpe(RE_WerteLabel label, int pumpe, int wert)
  {
    if (cfg.WASSERFLUSS_STATUS[pumpe] == 2)
    {
      if (cfg.WASSERFLUSS_TYP_PUMPE[pumpe] !=false)
      {
        if (wert <= cfg.WASSERFLUSS_PUMPE_MIN_DREHZAHL[pumpe])
        {
          label.setBackground(Color.RED);
          label.setForeground(Color.RED);
        }
        else
        {
          label.setBackground(null);
          label.setForeground(null);
        }
      }
      else if (wert <= cfg.WASSERFLUSS_SENSOR_ALARMMARKE[pumpe])
      {
        label.setBackground(Color.RED);
        label.setForeground(Color.RED);
      }
      else if (wert <= cfg.WASSERFLUSS_SENSOR_WARNMARKE[pumpe])
      {
        label.setBackground(Color.ORANGE);
      }
      else
      {
        label.setBackground(null);
        label.setForeground(null);
      }
    }
    else
    {
      label.setBackground(null);
      label.setForeground(null);
    }
  }
  
  public void beendeThread()
  {
    datUhr.ende = true;
  }
  
  class ueLis
    implements ActionListener
  {
    public ueLis() {}
    
    public void actionPerformed(ActionEvent e)
    {
      JCheckBox check = (JCheckBox)e.getSource();
    }
  }
  
  class DatumUhr
    implements Runnable
  {
    public boolean ende = false;
    public DateFormat dateFormatter = DateFormat.getDateInstance();
    public DateFormat timeFormatter = DateFormat.getTimeInstance();
    
    public DatumUhr()
    {
      cal = Calendar.getInstance(Locale.getDefault());
      Thread t = new Thread(this);
      t.start();
    }
  //synchronized?
    public void run()
    {
      try
      {
        while (!ende)
        {
          cal.setTimeInMillis(System.currentTimeMillis());
          Date date = cal.getTime();
          
          lblDatum.setText(dateFormatter.format(date));
          lblUhrzeit.setText(spr.SYSTEM_ZEIT + 
            timeFormatter.format(date));
          
          Thread.sleep(1000);
        }
      }
      catch (InterruptedException ex) {ex.printStackTrace();}
    }
  }
}

