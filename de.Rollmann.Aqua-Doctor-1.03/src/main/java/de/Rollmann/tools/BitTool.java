package de.Rollmann.tools;

import java.util.BitSet;
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
  
  public static int setzeBit(int wert, int pos, boolean setzen)
  {
    if (setzen) {
      return setBit(wert, pos);
    }
    return clearBit(wert, pos);
  }
  
  public static boolean testBit(int n, int pos)
  {
    int mask = 1 << pos;
    
    return (n & mask) == mask;
  }
  
  public static int getBit(int n, int pos)
  {
    BitSet bs = new BitSet(8);
    
    bs.set(n);
    if (bs.get(pos)) {
      return 1;
    }
    return 0;
    // alternativ: return (n & 1<<pos)!=0;
  }
  // Returns a bitset containing the values in bytes.
  // The byte-ordering of bytes must be big-endian which means the most significant bit is in element 0.
  /* public static BitSet fromByteArray(byte[] bytes) {
     BitSet bits = new BitSet();
     for (int i = 0; i < bytes.length * 8; i++) {
       if ( (bytes[bytes.length - i / 8 - 1] & (1 << (i % 8))) > 0) {
         bits.set(i);
       }
     }
     return bits;
   }
   */
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
  // Returns a byte array of at least length 1.
  // The most significant bit in the result is guaranteed not to be a 1
  // (since BitSet does not support sign extension).
  // The byte-ordering of the result is big-endian which means the most significant bit is in element 0.
  // The bit at index 0 of the bit set is assumed to be the least significant bit.
  /* public static byte[] toByteArray(BitSet bits) {
     byte[] bytes = new byte[bits.length() / 8 + 1];
     for (int i = 0; i < bits.length(); i++) {
       if (bits.get(i)) {
         bytes[bytes.length - i / 8 - 1] |= 1 << (i % 8);
       }
     }
     return bytes;
   }
   */
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

