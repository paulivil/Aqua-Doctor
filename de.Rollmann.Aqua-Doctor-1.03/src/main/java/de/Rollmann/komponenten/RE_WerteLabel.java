package de.Rollmann.komponenten;

import javax.swing.BorderFactory;
import javax.swing.JLabel;

public class RE_WerteLabel
  extends JLabel
{
  /**
	 * 
	 */
	private static final long serialVersionUID = 4121501398623908664L;

public RE_WerteLabel()
  {
    setHorizontalAlignment(4);
    setHorizontalTextPosition(4);
    setBorder(BorderFactory.createEtchedBorder());
    setText("");
  }
}