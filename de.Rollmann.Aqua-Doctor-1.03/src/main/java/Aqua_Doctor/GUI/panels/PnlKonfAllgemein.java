package Aqua_Doctor.GUI.panels;

import Aqua_Doctor.GUI.MainFrame;
import Aqua_Doctor.listener.SliListener;
import Aqua_Doctor.ressource.Daten;
import Aqua_Doctor.ressource.Sprache;
import de.Rollmann.komponenten.RE_ComboBox;
import de.Rollmann.komponenten.RE_Slider;
import de.Rollmann.komponenten.RE_TextField;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.logging.Logger;
import java.util.logging.Level;

import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.TitledBorder;

public class PnlKonfAllgemein
  extends KonfigPanel
{
  /**
	 * 
	 */
	private static final long serialVersionUID = 4238703169589366363L;
public JLabel lblName = new JLabel();
  public JLabel lblEinheit = new JLabel();
  public JLabel lblSprache = new JLabel();
  public JLabel lblProfil = new JLabel();
  public JLabel lblAbschaltWert = new JLabel();
  public JLabel lblAbschalt = new JLabel();
  public JLabel lblAbschaltBes = new JLabel();
  public JLabel lblIntervall = new JLabel();
  public RE_TextField txtName = new RE_TextField(20);
  public RE_ComboBox cboEinheit = new RE_ComboBox();
  public RE_ComboBox cboSprache = new RE_ComboBox();
  public RE_ComboBox cboProfil = new RE_ComboBox();
  public RE_ComboBox cboIntervall = new RE_ComboBox();
  public RE_Slider sliAbschalt = new RE_Slider();
  public JPanel pnlAbschalt = new JPanel();
  public TitledBorder titledBorder1 = new TitledBorder("");
  public EinheitListener einLis = new EinheitListener();
  public SliListener schaltLis;
  public SprachenListener sprLis = new SprachenListener();
  public Daten cfg;
  public Sprache spr;
  public MainFrame mFrame;
  
  public PnlKonfAllgemein(Sprache s, Daten c, MainFrame m)
  {
    cfg = c;
    spr = s;
    mFrame = m;
    
    fuelleCombo();
    try
    {
      schaltLis = new SliListener(lblAbschaltWert, 4, 20, 4, false, spr, cfg);
      jbInit();
      getName();
      setzeSprache();
    }
    catch (Exception e) {}
  }
  
  public void setzeKonfig(Daten c)
  {
    cfg = c;
  }
  
  public void setzeSprache()
  {
    lblName.setText(spr.NAME);
    lblEinheit.setText(spr.TEMPERATUR_EINHEIT);
    lblSprache.setText(spr.SPRACHE);
    lblProfil.setText(spr.PROFIL);
    lblAbschalt.setText(spr.SCHALTZEIT);
    lblIntervall.setText(spr.ABFRAGE_INTERVALL);
    lblAbschaltBes.setText(spr.BESCHREIBUNG_ABSCHALT_ZEIT);
    fuelleCombo();
    ladeEinstellung();
    setzeEinstellung();
    setzeListener();
    aktualisiere();
  }
  
  public void ladeEinstellung() {}
  
  public void ladeStandardEinstellung() {}
  
  public void speicherEinstellung()
  {
    cfg.ALLGEMEIN_NAME = txtName.getText();
    cfg.ALLGEMEIN_ATX_ABSCHALT_ZEIT = sliAbschalt.getValue();
    cfg.ALLGEMEIN_TEMP_EINHEIT = cboEinheit.getSelectedIndex();
    cfg.ALLGEMEIN_ABFRAGE_INTERVALL = (cboIntervall.getSelectedIndex() + 1);
    cfg.SPRACHE = cboSprache.getSelectedIndex();
  }
  
  public void setzeEinstellung()
  {
    txtName.setText(cfg.ALLGEMEIN_NAME);
    sliAbschalt.setValue(cfg.ALLGEMEIN_ATX_ABSCHALT_ZEIT);
    try
    {
      cboEinheit.setSelectedIndex(cfg.ALLGEMEIN_TEMP_EINHEIT);
    }
    catch (Exception ex)
    {
      cboEinheit.setSelectedIndex(0);
    }
    try
    {
      cboIntervall.setSelectedIndex(cfg.ALLGEMEIN_ABFRAGE_INTERVALL - 1);
    }
    catch (Exception ex1)
    {
      cboIntervall.setSelectedIndex(0);
      
      cboIntervall.setSelectedIndex(0);
    }
    try
    {
      cboSprache.setSelectedIndex(cfg.SPRACHE);
    }
    catch (Exception ex2)
    {
      cboSprache.setSelectedIndex(0);
    }
  }
  
  public void setzeListener()
  {
    cboEinheit.addActionListener(einLis);
    sliAbschalt.addChangeListener(schaltLis);
    cboSprache.addActionListener(sprLis);
  }
  
  public void removeListener()
  {
    cboEinheit.removeActionListener(einLis);
    sliAbschalt.removeChangeListener(schaltLis);
    cboSprache.removeActionListener(sprLis);
  }
  
  public void aktualisiere()
  {
    cboEinheit.aktualisiere();
  }
  
  public void fuelleCombo()
  {
    cboEinheit.removeAllItems();
    cboEinheit.addItems(
      new String[] { spr.EINHEIT_GRAD_CELSIUS, 
      spr.EINHEIT_KELVIN });
    cboSprache.removeAllItems();
    try
    {
      cboSprache.addItems(spr.Sprachen);
    }
    catch (Exception ex3)
    {
      cboSprache.addItem("Deutsch");
    }
    cboIntervall.removeAllItems();
    cboIntervall.addItems(
      new String[] { "1 sec", "2 sec", "3 sec", "4 sec", 
      "5 sec", "6 sec", "7 sec", "8 sec", "9 sec", "10 sec", 
      "11 sec", "12 sec", "13 sec", "14 sec", "15 sec" });
  }
  
  public void jbInit()
    throws Exception
  {
    lblName.setBounds(new Rectangle(15, 27, 127, 15));
    lblEinheit.setBounds(new Rectangle(15, 57, 127, 15));
    lblSprache.setBounds(new Rectangle(15, 87, 127, 15));
    lblProfil.setBounds(new Rectangle(15, 117, 99, 15));
    lblAbschaltWert.setBorder(BorderFactory.createEtchedBorder());
    lblAbschaltWert.setBounds(new Rectangle(150, 62, 60, 15));
    lblAbschalt.setBounds(new Rectangle(20, 62, 121, 15));
    lblAbschaltBes.setVerticalAlignment(1);
    lblAbschaltBes.setBounds(new Rectangle(15, 13, 495, 38));
    lblIntervall.setBounds(new Rectangle(15, 116, 127, 15));
    
    txtName.setBounds(new Rectangle(150, 24, 141, 21));
    
    cboEinheit.setBounds(new Rectangle(150, 54, 141, 21));
    cboEinheit.setEnabled(true);
    cboSprache.setBounds(new Rectangle(150, 84, 141, 21));
    cboSprache.setEnabled(true);
    cboProfil.setBounds(new Rectangle(150, 114, 105, 21));
    cboIntervall.setBounds(new Rectangle(150, 114, 141, 21));
    
    sliAbschalt.setBounds(new Rectangle(215, 57, 200, 24));
    
    pnlAbschalt.setLayout(null);
    pnlAbschalt.add(lblAbschalt);
    pnlAbschalt.add(lblAbschaltBes);
    pnlAbschalt.add(sliAbschalt);
    pnlAbschalt.add(lblAbschaltWert);
    pnlAbschalt.setBorder(titledBorder1);
    pnlAbschalt.setBounds(new Rectangle(15, 183, 526, 100));
    
    setLayout(null);
    
    add(lblName);
    add(lblEinheit);
    add(cboEinheit);
    add(lblSprache);
    add(cboSprache);
    add(pnlAbschalt);
    add(cboIntervall);
    add(lblIntervall);
    add(txtName);
  }
  
  public void ladeKonfig()
  {
    ladenAktiv = true;
    
    removeListener();
    
    setzeSprache();
    ladenAktiv = false;
  }
  
  public class SprachenListener
    implements ActionListener
  {
    public SprachenListener() {}
    
    public void actionPerformed(ActionEvent e)
    {
      spr.SpracheAendern(cboSprache.getSelectedIndex(), mFrame);
      cfg.SPRACHE = cboSprache.getSelectedIndex();
      cfg.saveConfigFile();
    }
  }
  
  public class EinheitListener
    implements ActionListener
  {
	  Logger logger = Logger.getAnonymousLogger();
    public EinheitListener() {}
    
    public void actionPerformed(ActionEvent e)
    {
      cfg.ALLGEMEIN_TEMP_EINHEIT = cboEinheit.getSelectedIndex();
      spr.EINHEIT_TEMPERATUR = ((String)cboEinheit.getSelectedItem());
      try
      {
        if (!ladenAktiv) {
          mFrame.konfPanel.aktualisiere();
        }
      }
      catch (Exception e1) {logger.log(Level.FINEST, "an exception was thrown", e1);}
    }
  }
}