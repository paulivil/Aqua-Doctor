package de.Rollmann.kommunikation;

import java.io.FileReader;
import java.io.FileWriter;
/**
 * <p>Überschrift: RE_Tools</p>
 *
 * <p>Beschreibung: Verschieden Tools</p>
 *
 * <p>Copyright: Copyright (c) 2007</p>
 *
 * <p>Organisation: Rollmann Elektronik</p>
 *
 * @author Manuel Krispin
 * @version 1.0
 */
public class Fifo
{
  private int length;
  public int[] queue;
  FileWriter ausgabeStrom;
  FileReader eingabeStrom;
  /** Erzeugt eine leere Schlange. */
  public Fifo(int length)
  {
	  this.length = length;
    queue = new int[length];
  }
  /** Fuegt ein Element x in die Schlange ein.
  @param x das einzufuegende Element */
  public void in(int x)
  {
	  // int i, j = 0;
    int[] tempQueue = new int[length];
    //   System.out.println(x);
    System.arraycopy(queue, 1, tempQueue, 0, 19);
    
    tempQueue[19] = x;
    
    queue = ((int[])tempQueue.clone());
  }
  
 
  public void setFrame(byte[] array)
  {
    for (int i = 0; i < 20; i++) {
      queue[i] = array[i];
    }
  }
  
  public int getWert(int pos)
  {
    return queue[pos];
  }
  
  public int[] getFrame()
  {
    return queue;
  }
  
  public boolean isFrame()
  {
    if ((queue[0] == 13) && (queue[(length - 1)] == 13) && (
      (queue[7] == 83) || (queue[7] == 88))) {
      return REComDaten.controllChecksum(queue);
    }
    return false;
  }
  
  public boolean isKeepalive()
  {
    if ((queue[0] == 13) && (queue[(length - 1)] == 13)) {
      if (queue[7] == 99) {
        return true;
      }
    }
    return false;
  }
}
