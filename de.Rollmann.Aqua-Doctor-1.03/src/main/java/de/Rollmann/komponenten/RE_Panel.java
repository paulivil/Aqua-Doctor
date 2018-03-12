package de.Rollmann.komponenten;

import java.awt.Component;
import javax.swing.JPanel;

public class RE_Panel
  extends JPanel
{
  /**
	 * 
	 */
	private static final long serialVersionUID = 945776307023664295L;

public void setEnabled(boolean bol)
  {
    for (int i = 0; i < getComponentCount(); i++) {
      getComponent(i).setEnabled(bol);
    }
  }
}

