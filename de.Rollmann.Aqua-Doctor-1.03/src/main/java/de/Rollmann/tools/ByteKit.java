package de.Rollmann.tools;
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
/**
 * ByteKit
 *
 * Einfache Klasse zur Umwandlung zwischen int, char und
 * vorzeichenlosen Bytes.
 */
public class ByteKit
{
	/**
     * Wandelt value (0 <= value <= 255) in ein byte um.
     */
  public static byte fromUnsignedInt(int value)
  {
    return (byte)value;
  }
  /**
   * Wandelt c in ein byte um. Das High-Byte wird ignoriert.
   */
  public static byte fromChar(char c)
  {
    return (byte)(c & 0xFF);
  }
  /**
   * Betrachtet value als vorzeichenloses byte und wandelt
   * es in eine Ganzzahl im Bereich 0..255 um.
   */
  public static int toUnsignedInt(byte value)
  {
    return (value & 0x7F) + (value < 0 ? 128 : 0);
  }
  /**
   * Betrachtet value als vorzeichenloses byte und wandelt
   * es in ein Unicode-Zeichen mit High-Byte 0 um.
   */
  public static char toChar(byte value)
  {
    return (char)toUnsignedInt(value);
  }
  /**
   * Liefert die Binaerdarstellung von value.
   */
  public static String toBitString(byte value)
  {
    char[] chars = new char[8];
    int mask = 1;
    for (int i = 0; i < 8; i++)
    {
      chars[(7 - i)] = ((value & mask) != 0 ? 49 : '0');
      mask <<= 1;
    }
    return new String(chars);
  }
  
  public static byte BitStringToByte(String s)
  {
    char[] chars = s.toCharArray();
    int mask = 1;
    byte b = 0;
    for (int i = 0; i < 8; i++) {
      if (chars[(7 - i)] == '1') {
        b = (byte)(int)(b + Math.pow(2.0D, i));
      }
    }
    return b;
  }
}
