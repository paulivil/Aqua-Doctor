package de.Rollmann.Dialoge.Abstract;

import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;

public abstract class DialogStandard
  extends JDialog
  implements Runnable
{
  /**
	 * 
	 */
	private static final long serialVersionUID = 7125967270218557891L;
protected JLabel lblText = new JLabel();
  protected Thread t = new Thread(this);
  protected JFrame frame;
  protected boolean ende = false;
  
  public void beenden()
  {
    ende = true;
    t.interrupt();
  }
}

