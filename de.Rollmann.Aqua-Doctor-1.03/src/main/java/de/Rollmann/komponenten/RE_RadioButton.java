package de.Rollmann.komponenten;

import java.awt.event.ActionEvent;
import javax.swing.JRadioButton;

public class RE_RadioButton
  extends JRadioButton
{
  /**
	 * 
	 */
	private static final long serialVersionUID = -7115118027618215734L;

public void aktualisiere()
  {
    super.fireStateChanged();
    super.fireActionPerformed(new ActionEvent(this, 0, ""));
  }
}