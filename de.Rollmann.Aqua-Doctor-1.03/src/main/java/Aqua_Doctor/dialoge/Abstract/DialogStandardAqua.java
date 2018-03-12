package Aqua_Doctor.dialoge.Abstract;

import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;

public abstract class DialogStandardAqua
  extends JDialog
  implements Runnable
{
  /**
	 * 
	 */
	private static final long serialVersionUID = 8500244068152389424L;
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

