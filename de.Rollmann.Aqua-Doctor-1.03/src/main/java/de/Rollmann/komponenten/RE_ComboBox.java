package de.Rollmann.komponenten;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import javax.swing.JComboBox;

public class RE_ComboBox
  extends JComboBox<Object>
{
  /**
	 * 
	 */
	private static final long serialVersionUID = 7242763375240326344L;
private boolean selectable = true;
  private int index;
  private MyActionListener myActLis = null;
  private int alteAuswahl = 0;
  private int neueAuswahl = 0;
  
  public void actionPerformed(ActionEvent e)
  {
    super.actionPerformed(e);
  }
  
  public void reset()
  {
    alteAuswahl = 0;
    neueAuswahl = 0;
  }
  
  public int getOldSelectedIndex()
  {
    return alteAuswahl;
  }
  
  public void addItems(String[] str)
  {
    for (int i = 0; i < str.length; i++) {
      addItem(str[i]);
    }
  }
  
  public void setSelectAble()
  {
    removeActionListener(myActLis);
  }
  
  public void setSelectAble(boolean bol, int i)
  {
    try
    {
      removeActionListener(myActLis);
    }
    catch (Exception e) {}
    selectable = bol;
    if (!bol)
    {
      index = i;
      myActLis = new MyActionListener(null);
      addActionListener(myActLis);
    }
    else
    {
      removeActionListener(myActLis);
    }
  }
  
  public void aktualisiere()
  {
    super.fireActionEvent();
  }
  
  private void setValue()
  {
    setSelectedIndex(index);
  }
  
  public void setEnabled(boolean b)
  {
    super.setEnabled(b);
    if (b) {
      super.fireActionEvent();
    }
  }
  
  public void aktualisiereAltNeu()
  {
    alteAuswahl = neueAuswahl;
    neueAuswahl = super.getSelectedIndex();
  }
  
  private class MyActionListener
    implements ActionListener
  {
    private MyActionListener(Object object) {}
    
    public void actionPerformed(ActionEvent e)
    {
      try
      {
        RE_ComboBox.this.setValue();
      }
      catch (Exception e1) {}
    }
  }
  
  public boolean isSelectable()
  {
    return selectable;
  }
  
  public void setSelectable(boolean selectable)
  {
    this.selectable = selectable;
  }
  
  private void readObject(ObjectInputStream ois)
    throws IOException, ClassNotFoundException
  {
    ois.defaultReadObject();
    

  }
  
  private void writeObject(ObjectOutputStream oos)
    throws IOException
  {
    oos.defaultWriteObject();
    

  }
}
