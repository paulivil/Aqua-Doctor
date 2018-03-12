package de.Rollmann.komponenten;

import java.awt.event.ActionEvent;
import javax.swing.JCheckBox;

public class RE_CheckBox
  extends JCheckBox
{
  public void aktualisiere()
  {
    super.fireActionPerformed(new ActionEvent(this, 0, 
      getActionCommand()));
    super.fireStateChanged();
  }
}