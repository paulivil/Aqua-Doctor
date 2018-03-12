package de.Rollmann.tools;

public class Konverter
{
  public static byte[] intArrayTobyteArray(int[] array)
  {
    int b = array.length;
    
    byte[] ba = new byte[b];
    for (int i = 0; i < b; i++) {
      ba[i] = intTobyte(array[i]);
    }
    return ba;
  }
  
  public static int byteToInt(int b)
  {
    return b & 0xFF;
  }
  
  public static int byteToInt(byte b)
  {
    return b & 0xFF;
  }
  
  public static byte intTobyte(int i)
  {
    if (i > 127) {
      i -= 256;
    }
    return (byte)i;
  }
  
  public static int makePositiv(int i)
  {
    int wert = i;
    if (i < 0) {
      wert = i + 256;
    }
    return wert;
  }
  
  public static int getInt(int High, int Low)
  {
    return High * 256 + Low;
  }
  
  public static short byteToShort(byte b)
  {
    short r = b;
    if (r < 0) {
      r = (short)(r + 256);
    }
    return r;
  }
  
  public static byte getLowByte(int i)
  {
    return (byte)(i % 256);
  }
  
  public static byte getHighByte(int i)
  {
    return (byte)(i / 256);
  }
  
  public static short getShort(short High, short Low)
  {
    return (short)(High * 256 + Low);
  }
  
  public static boolean getBoolean(int x)
  {
    if (x > 0) {
      return true;
    }
    return false;
  }
  
  public static int getInteger(boolean x)
  {
    if (x) {
      return 1;
    }
    return 0;
  }
}
