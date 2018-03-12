package Aqua_Doctor.dialoge;

import Aqua_Doctor.GUI.MainFrame;
import Aqua_Doctor.dialoge.Abstract.DialogStandardAqua;
import Aqua_Doctor.ressource.Sprache;
import java.awt.Rectangle;
import javax.swing.JFrame;

public class DialogSucheAqua_Doctor
  extends DialogStandardAqua
{
  /**
	 * 
	 */
	private static final long serialVersionUID = -6813555181085274504L;
public Sprache spr;
  public MainFrame frame;
  
  public DialogSucheAqua_Doctor(JFrame f)
  {
    try
    {
      frame = ((MainFrame)f);
      jbInit();
      t.start();
    }
    catch (Exception e) {}
  }
  
  public void jbInit()
    throws Exception
  {
    lblText.setText(spr.MITTWOCH);
    lblText.setBounds(new Rectangle(40, 10, 217, 19));
    
    setDefaultCloseOperation(0);
    getContentPane().setLayout(null);
    setSize(395, 110);
    setLocationRelativeTo(frame);
    setTitle(spr.DATENUEBERTRAGUNG);
    
    getContentPane().add(lblText);
    setVisible(true);
  }
  
  public void run()
  {
    setModal(true);
    setAlwaysOnTop(true);
    
    dispose();
  }
}