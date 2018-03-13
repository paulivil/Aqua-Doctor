package de.Rollmann.komponenten;

import java.awt.Color;
import java.awt.SystemColor;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.JTextField;

public class RE_TextField
  extends JTextField
  implements KeyListener
{
  /**
	 * 
	 */
	private static final long serialVersionUID = 2320988558485370414L;
private int count = 0;
  private int maxCount;
  
  public RE_TextField(int Anzahl)
  {
    maxCount = Anzahl;
    super.addKeyListener(this);
  }
  
  public int getMaxCount()
  {
    return maxCount;
  }
  
  public void setEnabled(boolean bol)
  {
    super.setEnabled(bol);
    if (bol) {
      setBackground(Color.WHITE);
    } else {
      setBackground(SystemColor.control);
    }
  }
  
  public void keyTyped(KeyEvent e)
  {
    count = getText().length();
    int keycode = e.getKeyCode();
    if (count >= maxCount)
    {
      switch (keycode)
      {
      case KeyEvent.VK_BACK_SPACE: 
      case KeyEvent.VK_ENTER: 
      case KeyEvent.VK_LEFT: 
      case KeyEvent.VK_RIGHT: 
      case KeyEvent.VK_DELETE: 
        return;
      }
      e.consume();
    }
  }
  
  public void keyPressed(KeyEvent e)
  {
    count = getText().length();
    int keycode = e.getKeyCode();
    if (count >= 20)
    {
      switch (keycode)
      {
      case KeyEvent.VK_BACK_SPACE: 
      case KeyEvent.VK_ENTER: 
      case KeyEvent.VK_LEFT: 
      case KeyEvent.VK_RIGHT: 
      case KeyEvent.VK_DELETE: 
        return;
      }
      e.consume();
    }
  }
  
  public void keyReleased(KeyEvent e)
  {
    count = getText().length();
    int keycode = e.getKeyCode();
    if (count >= 20)
    {
      switch (keycode)
      {
      case KeyEvent.VK_BACK_SPACE: 
      case KeyEvent.VK_ENTER: 
      case KeyEvent.VK_LEFT: 
      case KeyEvent.VK_RIGHT: 
      case KeyEvent.VK_DELETE: 
        return;
      }
      e.consume();
    }
  }
}
