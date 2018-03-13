package Aqua_Doctor.GUI.panels;

import Aqua_Doctor.ressource.Daten;
import Aqua_Doctor.ressource.Sprache;
import de.Rollmann.komponenten.RE_CheckBox;
import de.Rollmann.komponenten.RE_ComboBox;
import de.Rollmann.komponenten.RE_TextField;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.TitledBorder;

public class PnlKonfVergleich
  extends KonfigPanel
{
  /**
	 * 
	 */
	private static final long serialVersionUID = 6710511080677836252L;
public JLabel lblName1 = new JLabel();
  public JLabel lblSensor1V1 = new JLabel();
  public JLabel lblSensor2V1 = new JLabel();
  public JLabel lblName2 = new JLabel();
  public JLabel lblSensor1V2 = new JLabel();
  public JLabel lblSensor2V2 = new JLabel();
  public JLabel lblName3 = new JLabel();
  public JLabel lblSensor1V3 = new JLabel();
  public JLabel lblSensor2V3 = new JLabel();
  public RE_TextField txtName1 = new RE_TextField(20);
  public RE_TextField txtName2 = new RE_TextField(20);
  public RE_TextField txtName3 = new RE_TextField(20);
  public RE_ComboBox cboSensor1V1 = new RE_ComboBox();
  public RE_ComboBox cboSensor2V1 = new RE_ComboBox();
  public RE_ComboBox cboSensor1V2 = new RE_ComboBox();
  public RE_ComboBox cboSensor2V2 = new RE_ComboBox();
  public RE_ComboBox cboSensor1V3 = new RE_ComboBox();
  public RE_ComboBox cboSensor2V3 = new RE_ComboBox();
  public RE_CheckBox chkVergleich1 = new RE_CheckBox();
  public RE_CheckBox chkVergleich2 = new RE_CheckBox();
  public RE_CheckBox chkVergleich3 = new RE_CheckBox();
  public JPanel pnlVergleich1 = new JPanel();
  public JPanel pnlVergleich2 = new JPanel();
  public JPanel pnlVergleich3 = new JPanel();
  public TitledBorder titledBorder1 = new TitledBorder("");
  public CheckListener chkLis = new CheckListener();
  public Daten cfg;
  public Sprache spr;
  
  public PnlKonfVergleich(Daten c, Sprache s)
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
  
  public void aktualisiere()
  {
    chkVergleich1.aktualisiere();
    chkVergleich2.aktualisiere();
    chkVergleich3.aktualisiere();
  }
  
  public void fuelleCombo()
  {
    cboSensor1V1.removeAllItems();
    cboSensor1V1.addItems(cfg.SENSOR_NAME);
    
    cboSensor2V1.removeAllItems();
    cboSensor2V1.addItems(cfg.SENSOR_NAME);
    
    cboSensor1V2.removeAllItems();
    cboSensor1V2.addItems(cfg.SENSOR_NAME);
    
    cboSensor2V2.removeAllItems();
    cboSensor2V2.addItems(cfg.SENSOR_NAME);
    
    cboSensor1V3.removeAllItems();
    cboSensor1V3.addItems(cfg.SENSOR_NAME);
    
    cboSensor2V3.removeAllItems();
    cboSensor2V3.addItems(cfg.SENSOR_NAME);
  }
  
  public void ladeEinstellung() {}
  
  public void ladeStandardEinstellung() {}
  
  public void removeListener()
  {
    chkVergleich1.removeActionListener(chkLis);
    chkVergleich2.removeActionListener(chkLis);
    chkVergleich3.removeActionListener(chkLis);
  }
  
  public void setzeKonfig(Daten c)
  {
    cfg = c;
  }
  
  public void setzeEinstellung()
  {
    txtName1.setText(cfg.TEMP_VERGLEICH_NAME[0]);
    txtName2.setText(cfg.TEMP_VERGLEICH_NAME[1]);
    txtName3.setText(cfg.TEMP_VERGLEICH_NAME[2]);
    
    chkVergleich1.setSelected(cfg.TEMP_VERGLEICH_AKTIV[0]);
    chkVergleich2.setSelected(cfg.TEMP_VERGLEICH_AKTIV[1]);
    chkVergleich3.setSelected(cfg.TEMP_VERGLEICH_AKTIV[2]);
    try
    {
      cboSensor1V1.setSelectedIndex(cfg.TEMP_VERGLEICH_SENSOR1[0] - 1);
    }
    catch (Exception ex)
    {
      cboSensor1V1.setSelectedIndex(0);
    }
    try
    {
      cboSensor1V2.setSelectedIndex(cfg.TEMP_VERGLEICH_SENSOR1[1] - 1);
    }
    catch (Exception ex)
    {
      cboSensor1V2.setSelectedIndex(0);
    }
    try
    {
      cboSensor1V3.setSelectedIndex(cfg.TEMP_VERGLEICH_SENSOR1[2] - 1);
    }
    catch (Exception ex)
    {
      cboSensor1V3.setSelectedIndex(0);
    }
    try
    {
      cboSensor2V1.setSelectedIndex(cfg.TEMP_VERGLEICH_SENSOR2[0] - 1);
    }
    catch (Exception ex)
    {
      cboSensor2V1.setSelectedIndex(0);
    }
    try
    {
      cboSensor2V2.setSelectedIndex(cfg.TEMP_VERGLEICH_SENSOR2[1] - 1);
    }
    catch (Exception ex)
    {
      cboSensor2V2.setSelectedIndex(0);
    }
    try
    {
      cboSensor2V3.setSelectedIndex(cfg.TEMP_VERGLEICH_SENSOR2[2] - 1);
    }
    catch (Exception ex)
    {
      cboSensor2V3.setSelectedIndex(0);
    }
  }
  
  public void setzeListener()
  {
    chkVergleich1.addActionListener(chkLis);
    chkVergleich2.addActionListener(chkLis);
    chkVergleich3.addActionListener(chkLis);
  }
  
  public void setzeSprache()
  {
    lblName1.setText(spr.NAME);
    lblName2.setText(spr.NAME);
    lblName3.setText(spr.NAME);
    
    lblSensor1V1.setText(spr.SENSOR1);
    lblSensor2V1.setText(spr.SENSOR2);
    
    lblSensor1V2.setText(spr.SENSOR1);
    lblSensor2V2.setText(spr.SENSOR2);
    
    lblSensor1V3.setText(spr.SENSOR1);
    lblSensor2V3.setText(spr.SENSOR2);
    
    chkVergleich1.setText(spr.AKTIVIERT);
    chkVergleich2.setText(spr.AKTIVIERT);
    chkVergleich3.setText(spr.AKTIVIERT);
    
    fuelleCombo();
    ladeEinstellung();
    setzeEinstellung();
    setzeListener();
    aktualisiere();
  }
  
  public void speicherEinstellung()
  {
    cfg.TEMP_VERGLEICH_NAME[0] = txtName1.getText();
    cfg.TEMP_VERGLEICH_NAME[1] = txtName2.getText();
    cfg.TEMP_VERGLEICH_NAME[2] = txtName3.getText();
    
    cfg.TEMP_VERGLEICH_AKTIV[0] = chkVergleich1.isSelected();
    cfg.TEMP_VERGLEICH_AKTIV[1] = chkVergleich2.isSelected();
    cfg.TEMP_VERGLEICH_AKTIV[2] = chkVergleich3.isSelected();
    
    cfg.TEMP_VERGLEICH_SENSOR1[0] = (cboSensor1V1.getSelectedIndex() + 1);
    cfg.TEMP_VERGLEICH_SENSOR1[1] = (cboSensor1V2.getSelectedIndex() + 1);
    cfg.TEMP_VERGLEICH_SENSOR1[2] = (cboSensor1V3.getSelectedIndex() + 1);
    
    cfg.TEMP_VERGLEICH_SENSOR2[0] = (cboSensor2V1.getSelectedIndex() + 1);
    cfg.TEMP_VERGLEICH_SENSOR2[1] = (cboSensor2V2.getSelectedIndex() + 1);
    cfg.TEMP_VERGLEICH_SENSOR2[2] = (cboSensor2V3.getSelectedIndex() + 1);
  }
  
  public void jbInit()
    throws Exception
  {
    lblName1.setBounds(new Rectangle(15, 50, 90, 14));
    lblName2.setBounds(new Rectangle(15, 50, 90, 14));
    lblName3.setBounds(new Rectangle(15, 50, 90, 14));
    
    lblSensor1V1.setBounds(new Rectangle(15, 80, 90, 14));
    lblSensor2V1.setBounds(new Rectangle(265, 80, 90, 14));
    
    lblSensor1V2.setBounds(new Rectangle(15, 80, 90, 14));
    lblSensor2V2.setBounds(new Rectangle(265, 80, 90, 14));
    
    lblSensor1V3.setBounds(new Rectangle(15, 80, 90, 14));
    lblSensor2V3.setBounds(new Rectangle(265, 80, 90, 14));
    
    txtName1.setBounds(new Rectangle(110, 47, 130, 20));
    txtName2.setBounds(new Rectangle(110, 47, 130, 20));
    txtName3.setBounds(new Rectangle(110, 47, 130, 20));
    
    cboSensor1V1.setBounds(new Rectangle(110, 77, 130, 22));
    cboSensor2V1.setBounds(new Rectangle(360, 77, 130, 22));
    
    cboSensor1V2.setBounds(new Rectangle(110, 77, 130, 22));
    cboSensor2V2.setBounds(new Rectangle(360, 77, 130, 22));
    
    cboSensor1V3.setBounds(new Rectangle(110, 77, 130, 22));
    cboSensor2V3.setBounds(new Rectangle(360, 77, 130, 22));
    
    chkVergleich1.setBounds(new Rectangle(15, 20, 200, 23));
    chkVergleich2.setBounds(new Rectangle(15, 20, 200, 23));
    chkVergleich3.setBounds(new Rectangle(15, 20, 200, 23));
    
    chkVergleich1.setActionCommand("1");
    chkVergleich2.setActionCommand("2");
    chkVergleich3.setActionCommand("3");
    
    pnlVergleich1.setBorder(titledBorder1);
    pnlVergleich1.setBounds(new Rectangle(16, 19, 518, 135));
    pnlVergleich1.setLayout(null);
    pnlVergleich1.add(txtName1);
    pnlVergleich1.add(cboSensor1V1);
    pnlVergleich1.add(lblSensor1V1);
    pnlVergleich1.add(lblSensor2V1);
    pnlVergleich1.add(cboSensor2V1);
    pnlVergleich1.add(lblName1);
    pnlVergleich1.add(chkVergleich1);
    
    pnlVergleich2.setBorder(titledBorder1);
    pnlVergleich2.setBounds(new Rectangle(16, 181, 518, 135));
    pnlVergleich2.setLayout(null);
    pnlVergleich2.add(chkVergleich2);
    pnlVergleich2.add(cboSensor1V2);
    pnlVergleich2.add(lblSensor1V2);
    pnlVergleich2.add(lblSensor2V2);
    pnlVergleich2.add(cboSensor2V2);
    pnlVergleich2.add(lblName2);
    pnlVergleich2.add(txtName2);
    
    pnlVergleich3.setBorder(titledBorder1);
    pnlVergleich3.setBounds(new Rectangle(16, 340, 518, 135));
    pnlVergleich3.setLayout(null);
    pnlVergleich3.add(txtName3);
    pnlVergleich3.add(lblName3);
    pnlVergleich3.add(cboSensor1V3);
    pnlVergleich3.add(lblSensor1V3);
    pnlVergleich3.add(lblSensor2V3);
    pnlVergleich3.add(cboSensor2V3);
    pnlVergleich3.add(chkVergleich3);
    
    setLayout(null);
    add(pnlVergleich1);
    add(pnlVergleich2);
    add(pnlVergleich3);
  }
  
  public void ladeKonfig() {}
  
  public class CheckListener
    implements ActionListener
  {
    public CheckListener() {}
    
    public void actionPerformed(ActionEvent e)
    {
      RE_CheckBox check = (RE_CheckBox)e.getSource();
      switch (Integer.parseInt(check.getActionCommand()))
      {
      case 1: 
        break;
      case 2: 
        break;
      }
    }
  }
}

