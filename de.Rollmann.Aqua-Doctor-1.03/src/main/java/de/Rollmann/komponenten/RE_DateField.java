package de.Rollmann.komponenten;

import java.awt.Color;
import java.awt.ComponentOrientation;
import java.awt.SystemColor;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.GregorianCalendar;
import javax.swing.JFormattedTextField;
import javax.swing.text.MaskFormatter;

public class RE_DateField
  extends JFormattedTextField
  implements KeyListener
{
  /**
	 * 
	 */
	private static final long serialVersionUID = -3668671637202218351L;
protected int maxCount = 10;
  protected int count = 0;
  public boolean bol = false;
  private MaskFormatter dateFormat = new MaskFormatter();
  
  public RE_DateField()
  {
    try
    {
      dateFormat.setMask("##:##");
    }
    catch (ParseException localParseException) {}
    setFormatter(dateFormat);
    setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
    setHorizontalAlignment(4);
    
    addKeyListener(this);
    getCaretPosition();
  }
  
  public boolean isValidTime()
  {
    return true;
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
    count = getCaretPosition();
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
    else if (count == 5)
    {
      String str;
      try
      {
        GregorianCalendar d = new GregorianCalendar();
        SimpleDateFormat df = new SimpleDateFormat("HH:mm");
        Date dd;
        try
        {
          dd = df.parse(getText());
        }
        catch (ParseException ex6)
        {
          dd = new Date();
        }
        str = df.format(Long.valueOf(dd.getTime()));
      }
      catch (NumberFormatException localNumberFormatException) {}
    }
  }
  
  public void keyPressed(KeyEvent e)
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
  
  public void keyReleased(KeyEvent e)
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
}