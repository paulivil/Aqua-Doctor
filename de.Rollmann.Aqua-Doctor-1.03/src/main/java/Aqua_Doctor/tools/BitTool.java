package Aqua_Doctor.tools;

import java.util.BitSet;

public class BitTool
{
  public static int setBit(int n, int pos)
  {
    return n | 1 << pos;
  }
  
  public static int clearBit(int n, int pos)
  {
	  return n & ~(1 << pos);
  }
  
  public static int flipBit(int n, int pos)
  {
    return n ^ 1 << pos;
  }
  
  public static boolean testBit(int n, int pos)
  {
    int mask = 1 << pos;
    
    return (n & mask) == mask;
  }
  
  public static int byteToInt(byte b)
  {
    return b & 0xFF;
  }
  
  public static byte getLowByte(int i)
  {
    return (byte)(i % 256);
  }
  
  public static byte getHighByte(int i)
  {
    return (byte)(i / 256);
  }
  
  public static int getInt(int High, int Low)
  {
    return High * 256 + Low;
  }
  
  public static BitSet fromByte(byte b)
  {
    BitSet bits = new BitSet(8);
    int x;
     if (b < 0) {
      x = b + 256;
    } else {
      x = b;
    }
    int wert = 128;
    for (int i = 7; i >= 0; i--)
    {
      if (x - wert >= 0)
      {
        bits.set(i, true);
        x -= wert;
      }
      wert /= 2;
    }
    return bits;
  }
  
  public static byte toByte(BitSet bits)
  {
    int Rueckgabe = 0;
    int bitWert = 1;
    for (int i = 0; i < 8; i++)
    {
      if (bits.get(i)) {
        Rueckgabe += bitWert;
      }
      bitWert *= 2;
    }
    return (byte)Rueckgabe;
  }
}
