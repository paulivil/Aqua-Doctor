package Aqua_Doctor.dialoge;

import Aqua_Doctor.ressource.Sprache;
import java.awt.Font;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.InputStreamReader;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JProgressBar;

public class DialogFirmware
  extends JDialog
  implements Runnable, ActionListener
{
  /**
	 * 
	 */
	private static final long serialVersionUID = -2722516447201639718L;
public JLabel lblTitel = new JLabel();
  public JLabel lblWert = new JLabel();
  public JPanel pnlMain = new JPanel();
  public JProgressBar prgFirmware = new JProgressBar();
  public JLabel lblWarnung = new JLabel();
  public Thread t = new Thread(this);
  public JButton butBeenden = new JButton();
  public Sprache spr;
  
  public DialogFirmware(Sprache s)
  {
    spr = s;
    try
    {
      jbInit();
      t.start();
    }
    catch (Exception e) {}
  }
  
  public void aktualisiere(String s)
  {
    int x = 0;
    if (s.contains("%"))
    {
      x = s.indexOf("%");
      
      String sub = s.substring(x - 3, x);
      
      x = 0;
      if (sub.charAt(0) == '1')
      {
        x = 100;
        x += Integer.parseInt(String.valueOf(sub.charAt(1))) * 10;
        x += Integer.parseInt(String.valueOf(sub.charAt(2)));
        lblWarnung.setText(spr.UPDATE_WAR_ERFOLGREICH);
        butBeenden.setEnabled(true);
      }
      else
      {
        try
        {
          x = x + Integer.parseInt(String.valueOf(sub.charAt(1))) * 10;
        }
        catch (NumberFormatException e) {}
        x += Integer.parseInt(String.valueOf(sub.charAt(2)));
      }
      prgFirmware.setValue(x);
      lblWert.setText(Integer.toString(x) + " %");
    }
  }
  
  public void jbInit()
    throws Exception
  {
    lblTitel.setFont(new Font("Arial", 1, 16));
    lblTitel.setHorizontalAlignment(0);
    lblTitel.setText(spr.FIRMWARE_UPDATE);
    lblTitel.setBounds(new Rectangle(40, 36, 235, 20));
    lblWert.setBorder(BorderFactory.createEtchedBorder());
    lblWert.setHorizontalAlignment(4);
    lblWert.setBounds(new Rectangle(222, 79, 53, 16));
    lblWarnung.setHorizontalAlignment(0);
    lblWarnung.setText(spr.WARNUNG_HEATMASTER_2_NICHT_AUSSCHALTEN);
    lblWarnung.setBounds(new Rectangle(40, 118, 235, 14));
    
    butBeenden.setBounds(new Rectangle(52, 156, 207, 26));
    butBeenden.setText(spr.SCHLIESSEN);
    butBeenden.setEnabled(false);
    butBeenden.addActionListener(this);
    
    prgFirmware.setBounds(new Rectangle(40, 79, 174, 16));
    
    pnlMain.setLayout(null);
    
    pnlMain.add(lblTitel);
    pnlMain.add(prgFirmware);
    pnlMain.add(lblWert);
    pnlMain.add(lblWarnung);
    pnlMain.add(butBeenden);
    
    prgFirmware.setValue(0);
    lblWert.setText(Integer.toString(0) + " %");
    
    setTitle(spr.FIRMWARE_UPDATE);
    setSize(310, 210);
    setLocation(500, 400);
    getContentPane().add(pnlMain, "Center");
  }
  
  public void run()
  {
    try
    {
      File f = new File(".");
      
      Process p = Runtime.getRuntime().exec(
        f.getCanonicalPath() + "\\Firmware\\" + 
        "update.exe example.enc -");
      
      setAlwaysOnTop(true);
      setVisible(true);
      
      BufferedReader in = new BufferedReader(new InputStreamReader(
        p.getInputStream()));
      String s;
      while ((s = in.readLine()) != null)
      {
       aktualisiere(s);
      }
      p.destroy();
    }
    catch (Exception e) {}
  }
  
  public void actionPerformed(ActionEvent e)
  {
    setVisible(false);
    dispose();
  }
}