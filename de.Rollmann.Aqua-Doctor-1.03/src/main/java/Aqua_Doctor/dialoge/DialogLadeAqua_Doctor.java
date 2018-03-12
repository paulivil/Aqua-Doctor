package Aqua_Doctor.dialoge;

import Aqua_Doctor.dialoge.Abstract.DialogAquaFortschritt;
import Aqua_Doctor.ressource.Sprache;
import java.awt.Rectangle;
import javax.swing.JFrame;

public class DialogLadeAqua_Doctor
  extends DialogAquaFortschritt
{
  /**
	 * 
	 */
	private static final long serialVersionUID = 5870444780535346715L;
public Sprache spr;
  
  public DialogLadeAqua_Doctor(JFrame f, int x, Sprache s)
  {
    try
    {
      spr = s;
      Wert = x;
      frame = f;
      jbInit();
      t.start();
    }
    catch (Exception e) {}
  }
  
  public void jbInit()
    throws Exception
  {
    lblText.setText(spr.HINWEIS_KONFIGURATION_WIRD_VOM_HM_GELADEN);
    lblText.setBounds(new Rectangle(40, 10, 217, 19));
    
    lblWert.setBounds(new Rectangle(257, 10, 100, 14));
    lblWert.setHorizontalAlignment(4);
    lblWert.setHorizontalTextPosition(4);
    lblWert.setText("0 %");
    
    setDefaultCloseOperation(0);
    getContentPane().setLayout(null);
    setSize(395, 110);
    setLocationRelativeTo(frame);
    setTitle(spr.DATENUEBERTRAGUNG);
    pgbFortschritt.setBounds(new Rectangle(40, 34, 303, 30));
    getContentPane().add(pgbFortschritt);
    getContentPane().add(lblText);
    getContentPane().add(lblWert);
  }
  
  public void run()
  {
    setModal(true);
    setVisible(true);
    setAlwaysOnTop(true);
    
    setVisible(false);
    dispose();
  }
}