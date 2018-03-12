package de.Rollmann.kommunikation.ComTabellen;

import de.Rollmann.kommunikation.Runnable.Abstrakt.StandardRunnable;

import java.lang.Thread.UncaughtExceptionHandler;

import de.Rollmann.kommunikation.Runnable.MasterRunnable;
import de.Rollmann.komponenten.RE_ComFrame;
import de.Rollmann.tools.Konverter;
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
public abstract class ComTabelle
  extends StandardRunnable implements UncaughtExceptionHandler
{
  protected static final int FREI = 0;
  protected static final int LESEN = 1;
  protected static final int GELESEN = 2;
  protected static final int SCHREIBEN = 3;
  protected static final int GESCHRIEBEN = 4;
  protected static final boolean READ = false;
  protected static final boolean WRITE = true;
  public static int ADRESSE_RAM_START = 301;
  public static int ADRESSE_EXTERN_START  = 40;
  public static int EEPROM_ANZAHL  = 300;
  public static int RAM_ANZAHL  = 6;
  public static int EXTERN_ANZAHL = 0;

  protected static final int RAM_LESEN = 1;
  protected static final int RAM_SCHREIBEN = 2;
  protected static final int RAM_LESEN_WARTE = 3;
  protected static final int RAM_SCHREIBEN_WARTE = 4;
  protected static final int EEPROM_SCHREIBEN = 5;
  protected static final int EEPROM_LESEN = 6;
  protected static final int EEPROM_LESEN_WARTE = 7;
  protected static final int EEPROM_SCHREIBEN_WARTE = 8;
  protected boolean ramgeschrieben = false;
  protected boolean ramgelesen = false;
  protected boolean eepromgelesen = false;
  protected boolean eepromgeschrieben = false;
  public int aktion = 0;
  public int[][] EEProm;
  public int[][] Ram;
  public int[][] Extern;
  public MasterRunnable master;
  protected RE_ComFrame comFrame;
  
  public static int[] getAdresse(int i, boolean isRam, boolean isExtern)
  {
    int[] adr = new int[3];
    if (isRam) {
      adr[0] = ADRESSE_RAM_START;
    } else if (isExtern) {
      adr[0] = ADRESSE_EXTERN_START;
    } else {
      adr[0] = 0;
    }
    adr[1] = (i / 256);
    
    adr[2] = (i % 256);
    
    return adr;
  }
  
  public synchronized void run()
  {
	   while (!ende)
    {
      try
      {
        wait(10);
      }
      catch (InterruptedException e) {}
      try
      {
        wait(10);
      }
      catch (InterruptedException e) {}
      
    }
    beendet = true; 
    
  }
  
  public void KommunikationVollUnterbrochen()
  {
    comFrame.KommunikationVollUnterbrochen();
  }
  
  public void KommunikationUnterbrochen()
  {
    comFrame.KommunikationUnterbrochen();
  }
  
  public abstract void uncaughtException(Thread t, Throwable e);
  
  public boolean starteRamLesen()
    throws Exception
  {
    for (int i = 0; i < RAM_ANZAHL; i++) {
      if (Ram[i][10] == RAM_LESEN) {
        master.queueFrame(getAdresse(i, true, false), 0, 
          null, false);
      }
    }
    do
    {
      if (!master.send.t.isAlive()) {
        return false;
      }
    } while ((master.Zustand != 0) && (!ende));
    master.starteDatenuebertragung();
    while ((master.Zustand != 0) && (!ende)) {
      if (!master.send.t.isAlive()) {
        return false;
      }
    }
    for (int i = 0; i < RAM_ANZAHL; i++) {
      if (Ram[i][10] == RAM_SCHREIBEN) {
        Ram[i][10] = 0;
      }
    }
    if (checkRamLesen()) {
      aktion = FREI;
    }
    return true;
  }
  
  public boolean starteRamSchreiben()
    throws Exception
  {
    for (int i = 0; i < RAM_ANZAHL; i++) {
      if (Ram[i][10] == SCHREIBEN) {
        master.queueFrame(getAdresse(i, true, false), 0, 
          getDataRam(getAdresse(i, true, false)), true);
      }
    }
    do
    {
      if (!master.send.t.isAlive()) {
    	  
        return false;
      }
    } while ((master.Zustand != 0) && (!ende));
    master.starteDatenuebertragung();
    while ((master.Zustand != 0) && (!ende) && (
      master.t.isAlive())) {}
    for (int i = 0; i < RAM_ANZAHL; i++) {
      if (Ram[i][10] == RAM_SCHREIBEN_WARTE) {
        Ram[i][10] = 0;
      }
    }
    if (checkRamSchreiben()) {
      aktion = 0;
    }
    return true;
  }
  
  public boolean starteSchreiben()
    throws Exception
  {
    for (int i = 0; i < EEPROM_ANZAHL; i++) {
      if (EEProm[i][10] == SCHREIBEN) {
        master.queueFrame(getAdresse(i, false, false), 0, getDataEEProm(getAdresse(i, false, false)), true);
      }
    }
    for (int i = 0; i < RAM_ANZAHL; i++) {
      if (Ram[i][10] == SCHREIBEN) {
        master.queueFrame(getAdresse(i, true, false), 0, 
          getDataRam(getAdresse(i, true, false)), true);
      }
    }
    do
    {
      if (!master.send.t.isAlive()) {
        return false;
      }
    } while ((master.Zustand != 0) && (!ende));
    master.starteDatenuebertragung();
    while ((master.Zustand != 0) && (!ende) && (
      master.t.isAlive())) {}
    for (int i = 0; i < EEPROM_ANZAHL; i++) {
      if (EEProm[i][10] == GESCHRIEBEN) {
        EEProm[i][10] = 0;
      }
    }
    for (int i = 0; i < RAM_ANZAHL; i++) {
      if (Ram[i][10] == GESCHRIEBEN) {
        Ram[i][10] = 0;
      }
    }
    if (checkRamSchreiben()) {
      aktion = 0;
    }
    if (checkEEPromSchreiben()) {
      aktion = 0;
    }
    return true;
  }
  
  public boolean starteEEPromLesen()
    throws Exception
  {
    eepromgelesen = false;
    for (int i = 0; i < EEPROM_ANZAHL; i++) {
      if (EEProm[i][10] == LESEN) {
        try
        {
          master.queueFrame(getAdresse(i, false, false), 0, 
            null, false);
        }
        catch (Exception e) {}
      }
    }
    do
    {
      if (!master.send.t.isAlive()){
        return false;
      }
    } while ((master.Zustand != 0) && (!ende));
    master.starteDatenuebertragung();
    while ((master.Zustand != 0) && (!ende) && (
      master.t.isAlive())) {}
    for (int i = 0; i < EEPROM_ANZAHL; i++) {
      if (EEProm[i][10] == GELESEN) {
        EEProm[i][10] = 0;
      }
    }
    if (checkEEPromLesen()) {
      aktion = 0;
    }
    eepromgelesen = true;
    return true;
  }
  
  public boolean starteEEPromSchreiben()
    throws Exception
  {
    for (int i = 0; i < EEPROM_ANZAHL; i++) {
      if (EEProm[i][10] == SCHREIBEN) {
        master.queueFrame(getAdresse(i, false, false), 0, getDataEEProm(getAdresse(i, false, false)), true);
      }
    }
    do
    {
    	if  (!master.send.t.isAlive()) {
        return false;
      }
    } while ((master.Zustand != 0) && (!ende));
    master.starteDatenuebertragung();
    while ((master.Zustand != 0) && (!ende) && (
    		master.t.isAlive())) {}
    for (int i = 0; i < EEPROM_ANZAHL; i++) {
      if (EEProm[i][10] == GESCHRIEBEN) {
        EEProm[i][10] = 0;
      }
    }
    if (checkEEPromSchreiben()) {
      aktion = 0;
    }
    return true;
  }
  
  public boolean starteExternLesen()
    throws Exception
  {
    eepromgelesen = false;
    for (int i = 0; i < EXTERN_ANZAHL; i++) {
      if (Extern[i][10] == LESEN) {
        try
        {
          master.queueFrame(getAdresse(i, false, true), 0, 
            null, false);
        }
        catch (Exception e) {}
      }
    }
    do
    {
    	if (!master.send.t.isAlive()) {
        return false;
      }
    } while ((master.Zustand != 0) && (!ende));
    master.starteDatenuebertragung();
    while ((master.Zustand != 0) && (!ende) && (
      master.t.isAlive())) {}
    for (int i = 0; i < EXTERN_ANZAHL; i++) {
      if (Extern[i][10] == GELESEN) {
        Extern[i][10] = 0;
      }
    }
    if (checkEEPromLesen()) {
      aktion = 0;
    }
    eepromgelesen = true;
    return true;
  }
  
  protected boolean checkRamLesen()
  {
    for (int i = 0; i < RAM_ANZAHL; i++) {
      if ((Ram[i][10] == RAM_LESEN) || (Ram[i][10] == RAM_LESEN_WARTE)) {
        return false;
      }
    }
    return true;
  }
  
  protected boolean checkRamSchreiben()
  {
    for (int i = 0; i < RAM_ANZAHL; i++) {
      if ((Ram[i][10] == SCHREIBEN) || (Ram[i][10] == RAM_SCHREIBEN)) {
        return false;
      }
    }
    return true;
  }
  
  protected boolean checkEEPromLesen()
  {
    for (int i = 0; i < EEPROM_ANZAHL; i++) {
      if ((EEProm[i][10] == LESEN) || (EEProm[i][10] == GELESEN)) {
        return false;
      }
    }
    return true;
  }
  
  protected boolean checkEEPromSchreiben()
  {
    for (int i = 0; i < EEPROM_ANZAHL; i++) {
      if ((EEProm[i][10] == SCHREIBEN) || (EEProm[i][10] == GESCHRIEBEN)) {
        return false;
      }
    }
    return true;
  }
  
  protected boolean checkExternLesen()
  {
    for (int i = 0; i < EXTERN_ANZAHL; i++) {
      if ((Extern[i][10] == LESEN) || (Extern[i][10] == GELESEN)) {
        return false;
      }
    }
    return true;
  }
  
  public void setzeLesen(int[] Adresse)
  {
    if (Adresse[0] == ADRESSE_RAM_START) {
      Ram[(Adresse[1] * 256 + Adresse[2])][10] = RAM_LESEN;
    } else if (Adresse[0] == ADRESSE_EXTERN_START) {
      Extern[(Adresse[1] * 256 + Adresse[2])][10] = LESEN;
    } else {
      EEProm[(Adresse[1] * 256 + Adresse[2])][10] = LESEN;
    }
  }
  
  public void setzeSchreiben(int[] Adresse, int[] daten)
  {
    int x = daten.length;
    if (Adresse[0] == ADRESSE_RAM_START)
    {
      System.arraycopy(daten, 0, Ram[(Adresse[1] * 256 + Adresse[2])], 0, x);
      Ram[(Adresse[1] * 256 + Adresse[2])][10] = RAM_SCHREIBEN;
    }
    else if (!vergleichArrays(daten, getDataEEProm(Adresse)))
    {
      System.arraycopy(daten, 0, EEProm[(Adresse[1] * 256 + Adresse[2])], 0, x);
      EEProm[(Adresse[1] * 256 + Adresse[2])][10] = SCHREIBEN;
    }
  }
  
  public void setzeSchreiben(int[] Adresse, int Zelle, int Wert, boolean isInteger)
  {
    if (isInteger)
    {
      if (Adresse[0] == ADRESSE_RAM_START)
      {
        Ram[(Adresse[1] * 256 + Adresse[2])][Zelle] = Konverter.getHighByte(Wert);
        Ram[(Adresse[1] * 256 + Adresse[2])][(Zelle + 1)] = Konverter.getLowByte(Wert);
        Ram[(Adresse[1] * 256 + Adresse[2])][10] = RAM_SCHREIBEN;
      }
      else
      {
        EEProm[(Adresse[1] * 256 + Adresse[2])][Zelle] = Konverter.getHighByte(Wert);
        EEProm[(Adresse[1] * 256 + Adresse[2])][(Zelle + 1)] = Konverter.getLowByte(Wert);
        EEProm[(Adresse[1] * 256 + Adresse[2])][10] = SCHREIBEN;
      }
    }
    else if (Adresse[0] == ADRESSE_RAM_START)
    {
      Ram[(Adresse[1] * 256 + Adresse[2])][Zelle] = Wert;
      Ram[(Adresse[1] * 256 + Adresse[2])][10] = RAM_SCHREIBEN;
    }
    else
    {
      EEProm[(Adresse[1] * 256 + Adresse[2])][Zelle] = Wert;
      EEProm[(Adresse[1] * 256 + Adresse[2])][10] = SCHREIBEN;
    }
  }
  
  public void empfangen(int[] Adresse, int[] daten, boolean RW)
  {
    if (Adresse[0] == ADRESSE_RAM_START)
    {
      try
      {
        System.arraycopy(daten, 0, Ram[(Adresse[1] * 256 + Adresse[2])], 0, 
          10);
      }
      catch (Exception e) {}
      if (RW) {
        Ram[(Adresse[1] * 256 + Adresse[2])][10] = GESCHRIEBEN;
      } else {
        Ram[(Adresse[1] * 256 + Adresse[2])][10] = GELESEN;
      }
    }
    else if (Adresse[0] == ADRESSE_EXTERN_START)
    {
      try
      {
        System.arraycopy(daten, 0, Extern[(Adresse[1] * 256 + Adresse[2])], 0, 
          10);
      }
      catch (Exception e) {}
      if (RW) {
        Extern[(Adresse[1] * 256 + Adresse[2])][10] = GESCHRIEBEN;
      } else {
        Extern[(Adresse[1] * 256 + Adresse[2])][10] = GELESEN;
      }
    }
    else
    {
      System.arraycopy(daten, 0, EEProm[(Adresse[1] * 256 + Adresse[2])], 0, 10);
      if (RW) {
        EEProm[(Adresse[1] * 256 + Adresse[2])][10] = GESCHRIEBEN;
      } else {
        EEProm[(Adresse[1] * 256 + Adresse[2])][10] = GELESEN;
      }
    }
  }
  
  public int getDataRam(int[] Adresse, int Zelle, boolean isInteger)
  {
    int data;
    if (isInteger)
    {
      if (Adresse[0] == ADRESSE_RAM_START) {
        data = Konverter.getInt(Ram[(Adresse[1] * 256 + Adresse[2])][Zelle], 
          Ram[(Adresse[1] * 256 + Adresse[2])][(Zelle + 1)]);
      } else {
        data = Konverter.getInt(Ram[(Adresse[1] * 256 + Adresse[2])][Zelle], 
          Ram[(Adresse[1] * 256 + Adresse[2])][(Zelle + 1)]);
      }
    }
    else
    {
      if (Adresse[0] == ADRESSE_RAM_START) {
        data = Ram[(Adresse[1] * 256 + Adresse[2])][Zelle];
      } else {
        data = Ram[(Adresse[1] * 256 + Adresse[2])][Zelle];
      }
    }
    return data;
  }
  
  public int[] getDataRam(int[] Adresse)
  {
    int[] data = new int[10];
    if (Adresse[0] == ADRESSE_RAM_START) {
      System.arraycopy(Ram[(Adresse[1] * 256 + Adresse[2])], 0, data, 0, 10);
    } else {
      System.arraycopy(Ram[(Adresse[1] * 256 + Adresse[2])], 0, data, 0, 10);
    }
    return data;
  }
  
  public int[] getDataEEProm(int[] Adresse)
  {
    int[] data = new int[10];
    System.arraycopy(EEProm[(Adresse[1] * 256 + Adresse[2])], 0, data, 0, 10);
    
    return data;
  }
  
  public int getDataEEProm(int[] Adresse, int Zelle, boolean isInteger)
  {
    int data;
     if (isInteger) {
      data = Konverter.getInt(EEProm[(Adresse[1] * 256 + Adresse[2])][Zelle], 
        EEProm[(Adresse[1] * 256 + Adresse[2])][(Zelle + 1)]);
    } else {
      data = EEProm[(Adresse[1] * 256 + Adresse[2])][Zelle];
    }
    return data;
  }
  
  public int[] getDataExtern(int[] Adresse)
  {
    int[] data = new int[10];
    System.arraycopy(Extern[(Adresse[1] * 256 + Adresse[2])], 0, data, 0, 10);
    
    return data;
  }
  
  public int getDataExtern(int[] Adresse, int Zelle, boolean isInteger)
  {
    int data;
     if (isInteger) {
      data = Konverter.getInt(Extern[(Adresse[1] * 256 + Adresse[2])][Zelle], 
        Extern[(Adresse[1] * 256 + Adresse[2])][(Zelle + 1)]);
    } else {
      data = Extern[(Adresse[1] * 256 + Adresse[2])][Zelle];
    }
    return data;
  }
  
  private boolean vergleichArrays(int[] arrayA, int[] arrayB)
  {
    int x = arrayA.length;
    for (int i = 0; i < x; i++) {
      if (arrayA[i] != arrayB[i]) {
        return false;
      }
    }
    return true;
  }
  
  public int[][] getExternArray()
  {
    return Extern;
  }
}
