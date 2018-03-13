package de.Rollmann.Dialoge.Abstract;

import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JProgressBar;

public abstract class DialogFortschritt
  extends JDialog
  implements Runnable
{
  /**
	 * 
	 */
	private static final long serialVersionUID = 6187564147428564505L;
protected JLabel lblText = new JLabel();
  protected JLabel lblWert = new JLabel();
  protected Thread t = new Thread(this);
  protected int Wert;
  protected int aktWert = 0;
  protected JFrame frame;
  protected boolean ende = false;
  protected JProgressBar pgbFortschritt = new JProgressBar();
  
  public void aktualisiere(int x)
  {
    aktWert = x;
    int z = 100 * aktWert / Wert;
    
    pgbFortschritt.setValue(z);
    lblWert.setText(z + " %");
  }
  
  public void setzeWert(int x)
  {
    Wert = x;
  }
  
  public void fertig()
  {
    lblWert.setText("100 %");
    pgbFortschritt.setValue(pgbFortschritt.getMaximum());
  }
  
  public void beenden()
  {
    ende = true;
    t.interrupt();
  }
}