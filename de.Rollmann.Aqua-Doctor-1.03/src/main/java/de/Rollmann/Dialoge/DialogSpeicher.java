package de.Rollmann.Dialoge;

import de.Rollmann.Dialoge.Abstract.DialogFortschritt;
import java.awt.Container;
import java.awt.Rectangle;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JProgressBar;

public class DialogSpeicher
  extends DialogFortschritt
{
  /**
	 * 
	 */
	private static final long serialVersionUID = -541778333241832536L;

public DialogSpeicher(JFrame f, int x)
  {
    try
    {
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
    lblText.setText("Konfiguration wird gespeichert");
    lblText.setBounds(new Rectangle(40, 10, 217, 19));
    
    lblWert.setBounds(new Rectangle(257, 10, 100, 14));
    lblWert.setHorizontalAlignment(4);
    lblWert.setHorizontalTextPosition(4);
    lblWert.setText("0 %");
    
    setDefaultCloseOperation(0);
    getContentPane().setLayout(null);
    setSize(395, 110);
    setLocationRelativeTo(frame);
    setTitle("Konfiguration speichern");
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
    while (!ende) {
      try
      {
        wait(1000);
      }
      catch (InterruptedException e) {}
    }
    setVisible(false);
    dispose();
  }
}