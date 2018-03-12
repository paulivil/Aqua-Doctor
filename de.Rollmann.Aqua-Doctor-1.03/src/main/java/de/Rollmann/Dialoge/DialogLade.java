package de.Rollmann.Dialoge;

import de.Rollmann.Dialoge.Abstract.DialogStandard;
import java.awt.Container;
import java.awt.Rectangle;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class DialogLade
  extends DialogStandard
{
  /**
	 * 
	 */
	private static final long serialVersionUID = -7186307277112683378L;

public DialogLade(JFrame f)
  {
    try
    {
      frame = f;
      t.start();
    }
    catch (Exception e) {}
  }
  
  public void jbInit()
    throws Exception
  {
    lblText.setBounds(new Rectangle(40, 10, 217, 19));
    
    setDefaultCloseOperation(0);
    getContentPane().setLayout(null);
    setSize(395, 110);
    try
    {
      setLocationRelativeTo(frame);
    }
    catch (Exception e) {}
    setTitle("Aqua-Doc");
    
    getContentPane().add(lblText);
  }
//synchronized
  public  void run()
  {
    try
    {
      jbInit();
    }
    catch (Exception e) {}
    setVisible(true);
    setAlwaysOnTop(true);
    while (!ende) {
      try
      {
        wait(10);
      }
      catch (InterruptedException e)
      {
        ende = true;
      }
    }
    setAlwaysOnTop(false);
    setVisible(false);
    dispose();
  }
}

