package de.Rollmann.kommunikation;

import de.Rollmann.tools.ByteKit;

public class REComDaten
{
  public int geprueft = 0;
  private static final int ADRESSE1 = 4;
  private static final int ADRESSE2 = 5;
  private static final int ADRESSE3 = 6;
  private static final int RW = 7;
  public static int[] suchFrame = {
    13, 0, 0, 0, 0, 0, 0, 82, 
    0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 82, 13 };
  public static int[] softInitFrame = {
    13, 0, 254, 0, 0, 0, 0, 82, 
    0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 336, 13 };
  public static int[] hardInitFrame = {
    13, 0, 255, 0, 0, 0, 0, 82, 
    0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 337, 13 };
  
  public static int[] getLeseFrame(int[] Adresse, int Ziel)
  {
    int[] frame = new int[20];
    
    frame[0] = 13;
    frame[1] = 0;
    frame[2] = Ziel;
    frame[3] = 0;
    frame[4] = Adresse[0];
    frame[5] = Adresse[1];
    frame[6] = Adresse[2];
    frame[7] = 82;
    frame[8] = 0;
    frame[9] = 0;
    frame[10] = 0;
    frame[11] = 0;
    frame[12] = 0;
    frame[13] = 0;
    frame[14] = 0;
    frame[15] = 0;
    frame[16] = 0;
    frame[17] = 0;
    frame[18] = makeChecksum(frame);
    frame[19] = 13;
    
    return frame;
  }
  
  public static int[] getSchreibenFrame(int[] Adresse, int Ziel, int[] Daten)
  {
    int[] frame = new int[20];
    
    frame[0] = 13;
    frame[1] = 0;
    frame[2] = Ziel;
    frame[3] = 0;
    frame[4] = Adresse[0];
    frame[5] = Adresse[1];
    frame[6] = Adresse[2];
    frame[7] = 87;
    frame[8] = Daten[0];
    frame[9] = Daten[1];
    frame[10] = Daten[2];
    frame[11] = Daten[3];
    frame[12] = Daten[4];
    frame[13] = Daten[5];
    frame[14] = Daten[6];
    frame[15] = Daten[7];
    frame[16] = Daten[8];
    frame[17] = Daten[9];
    frame[18] = makeChecksum(frame);
    frame[19] = 13;
    
    return frame;
  }
  
  public static boolean controllChecksum(int[] frame)
  {
    int checksum = 0;
    for (int i = 1; i < 18; i++) {
      checksum += frame[i];
    }
    checksum = ByteKit.toUnsignedInt((byte)checksum);
    if (checksum == frame[18]) {
      return true;
    }
    return false;
  }
  
  public static int[] getAdresse(int[] frame)
  {
    int[] Adresse = new int[3];
    
    Adresse[0] = frame[ADRESSE1];
    Adresse[1] = frame[ADRESSE2];
    Adresse[2] = frame[ADRESSE3];
    
    return Adresse;
  }
  
  public static int[] getDaten(int[] frame)
  {
    int[] daten = new int[10];
    
    System.arraycopy(frame, 8, daten, 0, 10);
    
    return daten;
  }
  
  public static boolean getRW(int[] frame)
  {
    if ((frame[RW] == 82) || (frame[RW] == 83)) {
      return false;
    }
    return true;
  }
  
  public static int makeChecksum(int[] frame)
  {
    int checksum = 0;
    for (int i = 1; i < 18; i++) {
      checksum += frame[i];
    }
    checksum = ByteKit.toUnsignedInt((byte)checksum);
    
    return checksum;
  }
}
