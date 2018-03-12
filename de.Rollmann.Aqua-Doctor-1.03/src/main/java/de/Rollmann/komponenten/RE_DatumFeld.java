package de.Rollmann.komponenten;

import java.awt.Color;
import java.awt.SystemColor;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.BorderFactory;
import javax.swing.JFormattedTextField;
import javax.swing.border.Border;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.text.Document;

public class RE_DatumFeld
  extends JFormattedTextField
  implements KeyListener, DocumentListener, FocusListener
{
  /**
	 * 
	 */
	private static final long serialVersionUID = -8446610517844037708L;
protected int maxCount = 5;
  protected int count = 0;
  public boolean bol = false;
  Border myBorder = getBorder();
  
  public RE_DatumFeld()
  {
    getDocument().addDocumentListener(this);
    
    addKeyListener(this);
    addFocusListener(this);
  }
  
  public void aktualisiere()
  {
    checkDatum();
    update();
  }
  
  public void update()
  {
    Color color;
    if (isValidTime()) {
      color = Color.GREEN;
    } else {
      color = Color.RED;
    }
    if (getText().endsWith("Uhr")) {
      setBorder(myBorder);
    } else {
      setBorder(BorderFactory.createLineBorder(color));
    }
  }
  
  public boolean isValidTime()
  {
    if (getText().trim().length() == 0) {
      return true;
    }
    if (getText().trim().length() < 3) {
      return false;
    }
    if (getText().trim().length() > 5) {
      return false;
    }
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
  
  private void checkDatum()
  {
    String str = "";
    
    SimpleDateFormat df = new SimpleDateFormat("HH:mm");
    try
    {
      str = getText();
      
      str = str.replaceAll(":", "");
      if (str.endsWith(" Uhr")) {
        str = str.substring(0, 4);
      }
      if (str.trim().length() > 2)
      {
        try
        {
          if (str.trim().length() == 3) {
            str = "0" + str;
          }
          str = str.substring(0, 2) + ":" + str.substring(2);
        }
        catch (Exception localException) {}
        Date dd;
        try
        {
          dd = df.parse(str);
        }
        catch (ParseException ex6)
        {
          dd = new Date();
        }
        str = df.format(Long.valueOf(dd.getTime())) + " Uhr";
      }
      else
      {
        Date dd = new Date();
        str = df.format(Long.valueOf(dd.getTime()));
      }
    }
    catch (NumberFormatException localNumberFormatException) {}
    setText(str);
    
    setBorder(myBorder);
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
  
  public void changedUpdate(DocumentEvent e) {}
  
  public void insertUpdate(DocumentEvent e) {}
  
  public void removeUpdate(DocumentEvent e) {}
  
  public void focusGained(FocusEvent e) {}
  
  public void focusLost(FocusEvent e) {}
}

