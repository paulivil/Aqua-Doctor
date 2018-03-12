package de.Rollmann.komponenten;

import de.Rollmann.listener.SliListener;
import javax.swing.BoundedRangeModel;
import javax.swing.JSlider;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.event.EventListenerList;

public class RE_Slider
  extends JSlider
{
  /**
	 * 
	 */
	private static final long serialVersionUID = 1153048823401748019L;

public RE_Slider() {}
  
  public RE_Slider(int Min, int Max)
  {
    super.getModel().setMinimum(Min);
    super.setMaximum(Max);
  }
  
  public void addChangeListener(ChangeListener l)
  {
    listenerList.add(ChangeListener.class, l);
    l.stateChanged(new ChangeEvent(this));
  }
  
  public void aktualisiere()
  {
    super.fireStateChanged();
  }
  
  public void removeAllSliOhneLive()
  {
    ChangeListener[] c = getChangeListeners();
    for (int i = 0; i < c.length; i++) {
      if (c[i].getClass().equals(SliListener.class)) {
        removeChangeListener(c[i]);
      }
    }
  }
  
  public void removeAllSliListeners()
  {
    ChangeListener[] c = getChangeListeners();
    for (int i = 0; i < c.length; i++) {
      removeChangeListener(c[i]);
    }
  }
}