package Aqua_Doctor.ressource;

import Aqua_Doctor.tools.BitTool;
import de.Rollmann.kommunikation.ComTabellen.ComTabelle;
import de.Rollmann.kommunikation.Daten.DatenKlasse;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Serializable;
import java.util.BitSet;
import java.util.Properties;

public class Daten
  extends DatenKlasse
  implements Serializable
{
  /**
	 * 
	 */
	private static final long serialVersionUID = 14253454121435824L;
public String ALLGEMEIN_NAME;
  public int ALLGEMEIN_TEMP_EINHEIT;
  public int ALLGEMEIN_PROFIL;
  public int ALLGEMEIN_ATX_ABSCHALT_ZEIT;
  public int ALLGEMEIN_ABFRAGE_INTERVALL;
  public int LUEFTER_AUSWAHL;
  public String[] LUEFTER_NAME;
  public int[] LUEFTER_STATUS;
  public int[] LUEFTER_DREHZAHLFUNK;
  public boolean[] LUEFTER_ABSCHALT_BEI_AUSFALL;
  public int[] LUEFTER_AKTION_AUSFALL;
  public int[] LUEFTER_DREHZAHL_ERMITT;
  public int[] LUEFTER_TACHO_FAKTOR;
  public int[] LUEFTER_SENSOR_A;
  public int[] LUEFTER_SENSOR_B;
  public int[] LUEFTER_MANUELL_AUTO;
  public int[] LUEFTER_STARTTEMP;
  public int[] LUEFTER_SOLLTEMP;
  public int[] LUEFTER_MAXTEMP;
  public int[] LUEFTER_REGELUNG_EINHEIT;
  public int[] LUEFTER_STARTWERT_SPANNUNG;
  public int[] LUEFTER_STARTWERT_DREHZAHL;
  public int[] LUEFTER_MAX_SPANNUNG;
  public int[] LUEFTER_MAX_DREHZAHL;
  public int[] LUEFTER_HYSTERESE;
  public boolean[] LUEFTER_MAN_SPANNUNG;
  public boolean[] LUEFTER_MAN_DREHZAHL;
  public int[] LUEFTER_TYP;
  public int[] LUEFTER_MANUELL_SPANNUNG;
  public int[] LUEFTER_MANUELL_DREHZAHL;
  public int[] LUEFTER_MAXLUEFTER_DREHZAHL;
  public int[] LUEFTER_MINLUEFTER_DREHZAHL;
  public int SENSOR_AUSWAHL;
  public String[] SENSOR_NAME;
  public int[] SENSOR_STATUS;
  public int[] SENSOR_NOTAUS;
  public int[] SENSOR_TYP;
  public int[] SENSOR_KORREKTUR;
  public int[] SENSOR_NTCTABELLE;
  public int[] SENSOR_WARNWERT;
  public int[] SENSOR_ALARMWERT;
  public int[] SENSOR_NOTAUSWERT;
  public boolean[] OFFLINE_AQUA_DOCTOR_PC_START;
  public int[] OFFLINE_PC_START_VERZ;
  public int OFFLINE_STANDARD_SCHEMA;
  public int OFFLINE_TASTER_AUSWAHL;
  public boolean[][] OFFLINE_RELAIS;
  public int[][] OFFLINE_RELAIS_VERZ_ART;
  public int[][] OFFLINE_RELAIS_VERZ_WERT;
  public int[][] OFFLINE_RELAIS_SCHALT_ART;
  public int[][] OFFLINE_RELAIS_SCHALT_WERT;
  public int ONLINE_RELAIS_AUSWAHL;
  public String[] ONLINE_RELAIS_NAME;
  public boolean[][] ONLINE_NACHLAUF;
  public int[][] ONLINE_NACHLAUF_WERT;
  public boolean[][] ONLINE_SCHALTBAR_UEBER_SOFTWARE;
  public boolean[] ONLINE_TEMPERATUR_SCHALTER;
  public int[] ONLINE_SENSOR1_WAHL;
  public int[] ONLINE_SENSOR2_WAHL;
  public int[] ONLINE_SCHALTTEMPERATUR;
  public boolean[] ONLINE_UEBERSCHREITEN;
  public boolean[] ONLINE_UNTERSCHREITEN;
  public int ONLINE_TASTER_AUSWAHL;
  public int[] ONLINE_TASTER_FUNKTION;
  public boolean[][] ONLINE_TASTER_RELAIS;
  public int ONLINE_RELAIS_KONF_AUSWAHL;
  public int DISPLAY_HELLIGKEIT;
  public int DISPLAY_HELLIGKEIT_SLEEP;
  public int DISPLAY_HELLIGKEIT_STANDBY;
  public int DISPLAY_ZEIT_STANDBY;
  public String WASSERSTAND_NAME;
  public int WASSERSTAND_STATUS;
  public int WASSERSTAND_TYP;
  public int WASSERSTAND_AKTION;
  public boolean WASSERSTAND_OBEN;
  public boolean WASSERSTAND_UNTEN;
  public int WASSERSTAND_ALARMMARKE;
  public int WASSERFLUSS_AUSWAHL;
  public String[] WASSERFLUSS_NAME;
  public int[] WASSERFLUSS_STATUS;
  public boolean[] WASSERFLUSS_TYP_PUMPE;
  public boolean[] WASSERFLUSS_TYP_SENSOR;
  public boolean[] WASSERFLUSS_SENSOR_UEBERWACHUNG;
  public int[] WASSERFLUSS_SENSOR_FAKTOR;
  public int[] WASSERFLUSS_SENSOR_EINHEIT;
  public int[] WASSERFLUSS_SENSOR_EINHEIT_FAKTOR;
  public int[] WASSERFLUSS_SENSOR_WARNMARKE;
  public int[] WASSERFLUSS_SENSOR_ALARMMARKE;
  public int[] WASSERFLUSS_SENSOR_NOTAUSMARKE;
  public int[] WASSERFLUSS_PUMPE_MIN_DREHZAHL;
  public int[] WASSERFLUSS_PUMPE_ALARM_AKTION;
  public String[] WASSERFLUSS_SENSOR_EINEIT_STRING;
  public String[] TEMP_VERGLEICH_NAME;
  public boolean[] TEMP_VERGLEICH_AKTIV;
  public int[] TEMP_VERGLEICH_SENSOR1;
  public int[] TEMP_VERGLEICH_SENSOR2;
  public int SPRACHE;
  public static String CONFIG_STRING_ALLGEMEIN = "Allgemein";
  public static String CONFIG_STRING_LUEFTER = "Luefter";
  public static String CONFIG_STRING_SENSOR = "Sensor";
  public static String CONFIG_STRING_OFFLINE = "Offline Relais/Taster";
  public static String CONFIG_STRING_ONLINE = "Online Relais/Taster";
  public static String CONFIG_STRING_DISPLAY = "Display";
  public static String CONFIG_STRING_WASSERSTAND = "Wasserstand";
  public static String CONFIG_STRING_WASSERFLUSS = "Wasserfluss";
  public static String CONFIG_STRING_WAKE_ON = "Wake On Aqua Doctor";
  public Code code;
  public RelaisOnline relaisOnline = new RelaisOnline();
  public RelaisOffline relaisOffline = new RelaisOffline();
  public static int[] ar = new int[0];
  public long SERIEN_NR = 0;
  public int SW_VERSION = 0;
  public int HW_VERSION = 0;
  
  public Daten()
  {
    byte b = -1;
    
    BitSet p = BitTool.fromByte(b);
    
    code = new Code();
  }
  
  public void ladeAqua_DoctorEinstellungen()
  {
    starteDekodierung();
    
    ladeAqua_DoctorEinstellungenAllgemein();
    ladeAqua_DoctorEinstellungenDisplay();
    ladeAqua_DoctorEinstellungenLuefter();
    ladeAqua_DoctorEinstellungenSensor();
    ladeAqua_DoctorEinstellungenWasserFluss();
    ladeAqua_DoctorEinstellungenWasserStand();
    ladeAqua_DoctorEinstellungenOnline();
    ladeAqua_DoctorEinstellungenOffline();
    ladeAqua_DoctorEinstellungenVergleich();
    ladeAqua_DoctorEinstellungenWakeOn();
  }
  
  public void ladeAqua_DoctorEinstellungenAllgemein()
  {
    ALLGEMEIN_NAME = getName(241, 20);
    ALLGEMEIN_ATX_ABSCHALT_ZEIT = getInteger(124, 0);
    ALLGEMEIN_TEMP_EINHEIT = getInteger(124, 1);
    ALLGEMEIN_ABFRAGE_INTERVALL = getInteger(243, 0);
  }
  
  public void ladeAqua_DoctorEinstellungenDisplay()
  {
    DISPLAY_HELLIGKEIT = getInteger(100, 0);
    DISPLAY_HELLIGKEIT_SLEEP = getInteger(229, 0);
    DISPLAY_HELLIGKEIT_STANDBY = getInteger(209, 4);
    DISPLAY_ZEIT_STANDBY = getInteger(209, 0);
  }
  
  public void ladeAqua_DoctorEinstellungenLuefter()
  {
    LUEFTER_NAME = getNamen(1, 6, 20);
    
    LUEFTER_STATUS = code.LuefterStatus;
    LUEFTER_DREHZAHLFUNK = code.DrehzahlFunktion;
    
    LUEFTER_ABSCHALT_BEI_AUSFALL = code.AbschaltBeiAusfall;
    
    LUEFTER_AKTION_AUSFALL = code.AktionBeiAusfall;
    LUEFTER_DREHZAHL_ERMITT = code.DrehzahlErmitteln;
    LUEFTER_TACHO_FAKTOR = getIntegerArray(13, 0, 6, false);
    
    LUEFTER_SENSOR_A = code.SensorA;
    LUEFTER_SENSOR_B = code.SensorB;
    
    LUEFTER_MANUELL_AUTO = code.Manuell;
    
    LUEFTER_STARTTEMP = getLowHighIntegerArray(20, 8, 6, true);
    
    LUEFTER_SOLLTEMP = getLowHighIntegerArray(48, 0, 6, true);
    LUEFTER_MAXTEMP = getLowHighIntegerArray(25, 6, 6, true);
    
    LUEFTER_REGELUNG_EINHEIT = code.EinheitRegelung;
    
    LUEFTER_STARTWERT_SPANNUNG = getIntegerArray(30, 4, 6, true);
    LUEFTER_STARTWERT_DREHZAHL = getIntegerArray(32, 8, 6, true);
    
    LUEFTER_MAX_SPANNUNG = getIntegerArray(35, 2, 6, true);
    LUEFTER_MAX_DREHZAHL = getIntegerArray(37, 6, 6, true);
    
    LUEFTER_HYSTERESE = getIntegerArray(44, 8, 6, true);
    
    LUEFTER_MAN_SPANNUNG = code.Spannung;
    LUEFTER_MAN_DREHZAHL = code.Drehzahl;
    
    LUEFTER_TYP = code.RegelungArt;
    
    LUEFTER_MANUELL_SPANNUNG = getIntegerArray(16, 0, 6, true);
    LUEFTER_MANUELL_DREHZAHL = getIntegerArray(18, 4, 6, true);
    
    LUEFTER_MAXLUEFTER_DREHZAHL = 
      getLowHighIntegerArray(13, 6, 6, false);
    LUEFTER_MINLUEFTER_DREHZAHL = 
      getLowHighIntegerArray(14, 8, 6, false);
  }
  
  public void ladeAqua_DoctorEinstellungenSensor()
  {
    SENSOR_NAME = getNamen(56, 6, 20);
    
    SENSOR_STATUS = code.SensorStatus;
    
    SENSOR_NOTAUS = code.NotAus;
    
    SENSOR_TYP = code.SensorArt;
    
    SENSOR_KORREKTUR = getIntegerArray(84, 8, 6, false);
    
    SENSOR_NTCTABELLE = code.Tabelle;
    
    SENSOR_WARNWERT = getLowHighIntegerArray(68, 0, 6, true);
    SENSOR_ALARMWERT = getLowHighIntegerArray(72, 8, 6, true);
    SENSOR_NOTAUSWERT = getLowHighIntegerArray(77, 6, 6, true);
  }
  
  public void ladeAqua_DoctorEinstellungenOnline()
  {
    ONLINE_RELAIS_NAME = getNamen(130, 3, 20);
    ONLINE_SENSOR1_WAHL = new int[3];
    ONLINE_SENSOR2_WAHL = new int[3];
    
    ONLINE_TEMPERATUR_SCHALTER = new boolean[3];
    
    ONLINE_NACHLAUF = new boolean[3][3];
    
    ONLINE_NACHLAUF_WERT = new int[3][3];
    
    ONLINE_SCHALTTEMPERATUR = new int[3];
    
    ONLINE_UEBERSCHREITEN = new boolean[] { true, true, true };
    ONLINE_UNTERSCHREITEN = new boolean[3];
    
    ONLINE_TASTER_FUNKTION = new int[3];
    
    ONLINE_TASTER_RELAIS = new boolean[3][3];
    
    ONLINE_SCHALTBAR_UEBER_SOFTWARE = new boolean[3][3];
    
    relaisOnline.leseKonfig();
  }
  
  public void ladeAqua_DoctorEinstellungenOffline()
  {
    OFFLINE_STANDARD_SCHEMA = getInteger(193, 6);
    
    OFFLINE_AQUA_DOCTOR_PC_START = new boolean[3];
    
    OFFLINE_PC_START_VERZ = new int[3];
    
    OFFLINE_RELAIS = new boolean[3][3];
    
    OFFLINE_RELAIS_VERZ_ART = new int[3][3];
    
    OFFLINE_RELAIS_VERZ_WERT = new int[3][3];
    
    OFFLINE_RELAIS_SCHALT_ART = new int[3][3];
    
    OFFLINE_RELAIS_SCHALT_WERT = new int[3][3];
    
    relaisOffline.leseKonfig();
  }
  
  public void ladeAqua_DoctorEinstellungenWasserStand()
  {
    WASSERSTAND_NAME = getName(149, 20);
    
    WASSERSTAND_STATUS = code.WasserStatus;
    
    WASSERSTAND_TYP = code.WasserArt;
    WASSERSTAND_AKTION = code.WasserAktion;
    if (getInteger(151, 0) == 0)
    {
      WASSERSTAND_OBEN = true;
      WASSERSTAND_UNTEN = false;
    }
    else
    {
      WASSERSTAND_OBEN = false;
      WASSERSTAND_UNTEN = true;
    }
    WASSERSTAND_ALARMMARKE = getInteger(151, 5);
  }
  
  public void ladeAqua_DoctorEinstellungenWasserFluss()
  {
    WASSERFLUSS_NAME = getNamen(136, 3, 20);
    
    WASSERFLUSS_STATUS = code.PumpeStatus;
    
    WASSERFLUSS_TYP_PUMPE = code.PumpeTyp;
    
    WASSERFLUSS_TYP_SENSOR = code.DurchTyp;
    
    WASSERFLUSS_SENSOR_UEBERWACHUNG = code.PumpeUeberwachung;
    
    WASSERFLUSS_SENSOR_FAKTOR = getIntegerArray(143, 2, 3, false);
    
    WASSERFLUSS_SENSOR_EINHEIT_FAKTOR = 
      getIntegerArray(143, 5, 3, false);
    
    WASSERFLUSS_SENSOR_EINHEIT = code.SensorEinheit;
    
    WASSERFLUSS_SENSOR_WARNMARKE = 
      getLowHighIntegerArray(230, 0, 3, true);
    WASSERFLUSS_SENSOR_ALARMMARKE = 
      getLowHighIntegerArray(232, 4, 3, true);
    WASSERFLUSS_SENSOR_NOTAUSMARKE = 
      getLowHighIntegerArray(234, 8, 3, true);
    
    WASSERFLUSS_PUMPE_MIN_DREHZAHL = 
      getLowHighIntegerArray(145, 2, 3, true);
    
    WASSERFLUSS_PUMPE_ALARM_AKTION = code.PumpeAktionAusfall;
  }
  
  public void ladeAqua_DoctorEinstellungenWakeOn() {}
  
  public void ladeAqua_DoctorEinstellungenVergleich()
  {
    TEMP_VERGLEICH_NAME = getNamen(160, 3, 80);
    
    TEMP_VERGLEICH_AKTIV = code.VergleichStatus;
    
    TEMP_VERGLEICH_SENSOR1 = getIntegerArray(155, 0, 3, true);
    TEMP_VERGLEICH_SENSOR2 = getIntegerArray(156, 2, 3, true);
  }
  
  public void schreibeKonfig()
  {
    code.kodiere();
    
    schreibeAqua_DoctorEinstellungenAllgemein();
    schreibeAqua_DoctorEinstellungenLuefter();
    schreibeAqua_DoctorEinstellungenSensor();
    schreibeAqua_DoctorEinstellungenWasserFluss();
    schreibeAqua_DoctorEinstellungenWasserStand();
    schreibeAqua_DoctorEinstellungenDisplay();
    schreibeAqua_DoctorEinstellungenVergleich();
    schreibeAqua_DoctorEinstellungenOnline();
    schreibeAqua_DoctorEinstellungenOffline();
  }
  
  public void schreibeAqua_DoctorEinstellungenAllgemein()
  {
    setName(ALLGEMEIN_NAME, 241);
    setInteger(ALLGEMEIN_ATX_ABSCHALT_ZEIT, 124, 0);
    setInteger(ALLGEMEIN_TEMP_EINHEIT, 124, 1);
    setInteger(ALLGEMEIN_ABFRAGE_INTERVALL, 243, 0);
  }
  
  public void schreibeAqua_DoctorEinstellungenLuefter()
  {
    setNamen(LUEFTER_NAME, 1, 6, 20);
    
    setIntegerArray(LUEFTER_TACHO_FAKTOR, 13, 0, 6, false);
    
    setLowHighIntegerArray(LUEFTER_STARTTEMP, 20, 8, 6, true);
    setLowHighIntegerArray(LUEFTER_SOLLTEMP, 48, 0, 6, true);
    setLowHighIntegerArray(LUEFTER_MAXTEMP, 25, 6, 6, true);
    
    setIntegerArray(LUEFTER_STARTWERT_SPANNUNG, 30, 4, 6, true);
    setIntegerArray(LUEFTER_STARTWERT_DREHZAHL, 32, 8, 6, true);
    
    setIntegerArray(LUEFTER_MAX_SPANNUNG, 35, 2, 6, true);
    setIntegerArray(LUEFTER_MAX_DREHZAHL, 37, 6, 6, true);
    
    setIntegerArray(LUEFTER_HYSTERESE, 44, 8, 6, true);
    
    setIntegerArray(LUEFTER_MANUELL_SPANNUNG, 16, 0, 6, true);
    setIntegerArray(LUEFTER_MANUELL_DREHZAHL, 18, 4, 6, true);
    
    setLowHighIntegerArray(LUEFTER_MAXLUEFTER_DREHZAHL, 13, 6, 6, 
      false);
    setLowHighIntegerArray(LUEFTER_MINLUEFTER_DREHZAHL, 14, 8, 6, 
      false);
  }
  
  public void schreibeAqua_DoctorEinstellungenSensor()
  {
    setNamen(SENSOR_NAME, 56, 6, 20);
    
    setIntegerArray(SENSOR_KORREKTUR, 84, 8, 6, false);
    
    setLowHighIntegerArray(SENSOR_WARNWERT, 68, 0, 6, true);
    setLowHighIntegerArray(SENSOR_ALARMWERT, 72, 8, 6, true);
    setLowHighIntegerArray(SENSOR_NOTAUSWERT, 77, 6, 6, true);
  }
  
  public void schreibeAqua_DoctorEinstellungenWasserFluss()
  {
    setNamen(WASSERFLUSS_NAME, 136, 3, 20);
    
    setIntegerArray(WASSERFLUSS_SENSOR_FAKTOR, 143, 2, 3, false);
    
    setIntegerArray(WASSERFLUSS_SENSOR_EINHEIT_FAKTOR, 143, 5, 3, 
      false);
    
    setLowHighIntegerArray(WASSERFLUSS_SENSOR_WARNMARKE, 230, 0, 3, 
      true);
    setLowHighIntegerArray(WASSERFLUSS_SENSOR_ALARMMARKE, 232, 4, 3, 
      true);
    setLowHighIntegerArray(WASSERFLUSS_SENSOR_NOTAUSMARKE, 234, 8, 3, 
      true);
    
    setLowHighIntegerArray(WASSERFLUSS_PUMPE_MIN_DREHZAHL, 145, 2, 3, 
      true);
  }
  
  public void schreibeAqua_DoctorEinstellungenWasserStand()
  {
    setName(WASSERSTAND_NAME, 149);
    int x;
     if (WASSERSTAND_OBEN) {
      x = 0;
    } else {
      x = 1;
    }
    setInteger(x, 151, 0);
    
    setInteger(WASSERSTAND_ALARMMARKE, 151, 5);
  }
  
  public void schreibeAqua_DoctorEinstellungenDisplay()
  {
    setInteger(DISPLAY_HELLIGKEIT, 100, 0);
    setInteger(DISPLAY_HELLIGKEIT_SLEEP, 229, 0);
    setInteger(DISPLAY_HELLIGKEIT_STANDBY, 209, 4);
    setInteger(DISPLAY_ZEIT_STANDBY, 209, 0);
  }
  
  public void schreibeAqua_DoctorEinstellungenOnline()
  {
    setNamen(ONLINE_RELAIS_NAME, 130, 3, 20);
    
    relaisOnline.schreibeKonfig();
  }
  
  public void schreibeAqua_DoctorEinstellungenOffline()
  {
    setInteger(OFFLINE_STANDARD_SCHEMA, 193, 6);
    
    relaisOffline.schreibeKonfig();
  }
  
  public void schreibeAqua_DoctorEinstellungenVergleich()
  {
    setNamen(TEMP_VERGLEICH_NAME, 160, 3, 80);
    
    setIntegerArray(TEMP_VERGLEICH_SENSOR1, 155, 0, 3, true);
    setIntegerArray(TEMP_VERGLEICH_SENSOR2, 156, 2, 3, true);
  }
  
  public String[] getNamen(int Zeile, int Anzahl, int Offset)
  {
    String[] s = new String[Anzahl];
    
    Zeile *= 10;
    
    char[] c1 = new char[20];
    for (int i = 0; i < Anzahl; i++)
    {
      for (int j = 0; j < 20; j++) {
        switch (ar[(j + Zeile)])
        {
        case 129: 
            c1[j] = 'ü';
            break;
          case 132: 
          	c1[j] = 'ä';
            break;
          case 148: 
          	c1[j] = 'ö';
            break;
          case 142: 
          	c1[j] = 'Ä';
            break;
          case 153: 
          	c1[j] = 'Ö';
            break;
          case 154: 
          	c1[j] = 'Ü';
          break;
        default: 
          c1[j] = ((char)ar[(j + Zeile)]);
        }
      }
      Zeile += Offset;
      
      int x = 20;
      do
      {
        x--;
        if (x < 0)
        {
          x = 0;
          break;
        }
      } while (c1[x] == Anzahl);
      s[i] = String.copyValueOf(c1, 0, x + 1);
    }
    return s;
  }
  
  public String getName(int Zeile, int Laenge)
  {
    String s = new String();
    
    Zeile *= 10;
    
    char[] c1 = new char[Laenge];
    for (int j = 0; j < Laenge; j++) {
      switch (ar[(j + Zeile)])
      {
        case 129: 
            c1[j] = 'ü';
            break;
          case 132: 
          	c1[j] = 'ä';
            break;
          case 148: 
          	c1[j] = 'ö';
            break;
          case 142: 
          	c1[j] = 'Ä';
            break;
          case 153: 
          	c1[j] = 'Ö';
            break;
          case 154: 
          	c1[j] = 'Ü';
        break;
      default: 
        c1[j] = ((char)ar[(j + Zeile)]);
      }
    }
    s = new String(c1);
    
    return s;
  }
  
  public static int[] getIntegerArray(int Zeile, int StartWert, int Anzahl, boolean profil)
  {
    Zeile *= 10;
    
    int[] array = new int[Anzahl];
    int x = Zeile + StartWert;
    for (int i = 0; i < Anzahl; i++)
    {
      array[i] = ar[x];
      if (profil) {
        x += 4;
      } else {
        x++;
      }
    }
    return array;
  }
  
  public int getInteger(int Zeile, int StartWert)
  {
    Zeile *= 10;
    
    int x = Zeile + StartWert;
    int array = ar[x];
    return array;
  }
  
  public long getSerienNr()
  {
    long snr = 0L;
    
    snr = (long) (ar[6] * Math.pow(2.0D, 24.0D));
    snr += (ar[7] * Math.pow(2.0D, 16.0D));
    snr += (ar[8] * Math.pow(2.0D, 8.0D));
    snr += ar[9];
    
    return snr;
  }
  
  public int getSWVersion()
  {
    int swv = 0;
    
    swv = ar[3] * 1000;
    swv += ar[4];
    
    return swv;
  }
  
  public int getHWVersion()
  {
    int hwv = 0;
    
    hwv = ar[2];
    
    return hwv;
  }
  
  public int getInt(int Zeile, int StartWert)
  {
    Zeile *= 10;
    return ar[(Zeile + StartWert)];
  }
  
  public int[] getLowHighIntegerArray(int Zeile, int StartWert, int Anzahl, boolean profil)
  {
    Zeile *= 10;
    
    int[] array = new int[Anzahl];
    int x = Zeile + StartWert;
    for (int i = 0; i < Anzahl; i++)
    {
      array[i] = BitTool.getInt(ar[x], ar[(x + 1)]);
      if (profil) {
        x += 8;
      } else {
        x += 2;
      }
    }
    return array;
  }
  
  public int getLowHighInteger(int Zeile, int StartWert)
  {
    Zeile *= 10;
    
    int x = Zeile + StartWert;
    
    int array = BitTool.getInt(ar[x], ar[(x + 1)]);
    
    return array;
  }
  
  public void setNamen(String[] str, int Zeile, int Anzahl, int Offset)
  {
    Zeile *= 10;
    for (int i = 0; i < Anzahl; i++)
    {
      char[] c1 = str[i].toCharArray();
      
      int x = c1.length;
      for (int j = 0; j < 20; j++) {
        if (j < x)
        {
          switch (c1[j])
          {
          case 'ü': 
              c1[j] = 129;
              break;
            case 'ä': 
            	c1[j] = 132;
              break;
            case 'ö': 
            	c1[j] = 148;
              break;
            case 'Ü': 
            	c1[j] = 153;
              break;
            case 'Ö': 
            	c1[j] = 154;
              break;
            case 'Ä': 
            	c1[j] = 142;
          }
          ar[(j + Zeile)] = c1[j];
        }
        else
        {
          ar[(j + Zeile)] = 32;
        }
      }
      Zeile += Offset;
    }
  }
  
  public void setName(String str, int Zeile)
  {
    Zeile *= 10;
    
    char[] c1 = str.toCharArray();
    int x = c1.length;
    for (int j = 0; j < 20; j++) {
      if (j < x)
      {
        switch (c1[j])
        {
        case 'ü': 
              c1[j] = 129;
              break;
            case 'ä': 
            	c1[j] = 132;
              break;
            case 'ö': 
            	c1[j] = 148;
              break;
            case 'Ü': 
            	c1[j] = 153;
              break;
            case 'Ö': 
            	c1[j] = 154;
              break;
            case 'Ä': 
            	c1[j] = 142;
        }
        ar[(j + Zeile)] = c1[j];
      }
      else
      {
        ar[(j + Zeile)] = 32;
      }
    }
  }
  
  public static void setIntegerArray(int[] array, int Zeile, int StartWert, int Anzahl, boolean profil)
  {
    Zeile *= 10;
    
    int x = Zeile + StartWert;
    for (int i = 0; i < Anzahl; i++)
    {
     ar[x] = array[i];
      if (profil) {
        x += 4;
      } else {
        x++;
      }
    }
  }
  
  public void setInteger(int array, int Zeile, int StartWert)
  {
    Zeile *= 10;
    
    int x = Zeile + StartWert;
    ar[x] = array;
  }
  
  public void setLowHighIntegerArray(int[] array, int Zeile, int StartWert, int Anzahl, boolean profil)
  {
    Zeile *= 10;
    
    int x = Zeile + StartWert;
    for (int i = 0; i < Anzahl; i++)
    {
      ar[x] = BitTool.getHighByte(array[i]);
      ar[(x + 1)] = BitTool.getLowByte(array[i]);
      if (profil) {
        x += 8;
      } else {
        x += 2;
      }
    }
  }
  
  public void setLowHighInteger(int array, int Zeile, int StartWert)
  {
    Zeile *= 10;
    
    int x = Zeile + StartWert;
    
    ar[x] = BitTool.getHighByte(array);
    ar[(x + 1)] = BitTool.getLowByte(array);
  }
  
  public void schreibeKonfig(String datei) {}
  
  public void ladeLokalEinstellungenAllgemein() {}
  
  public void ladeLokalEinstellungenLuefter() {}
  
  public void ladeLokalEinstellungenOffline() {}
  
  public void ladeLokalEinstellungenSensor() {}
  
  public void ladeLokalEinstellungenOnline() {}
  
  public void ladeLokalEinstellungenDisplay() {}
  
  public void ladeLokalEinstellungenWasserStand() {}
  
  public void ladeLokalEinstellungenWasserFluss() {}
  
  public void ladeLokalEinstellungenVergleich() {}
  
  public boolean ladeLokalEinstellungen()
  {
    boolean bol = true;
    try
    {
      ladeLokalEinstellungenDisplay();
      ladeLokalEinstellungenOffline();
      ladeLokalEinstellungenOnline();
      ladeLokalEinstellungenSensor();
      ladeLokalEinstellungenWasserFluss();
      ladeLokalEinstellungenWasserStand();
      ladeLokalEinstellungenLuefter();
      ladeLokalEinstellungenAllgemein();
      ladeLokalEinstellungenVergleich();
    }
    catch (Exception ex)
    {
      bol = false;
    }
    return bol;
  }
  
  public  Properties configFile = new Properties();
  
  public void readConfigFile()
  {
    try
    {
      configFile.load(new FileInputStream("hm.cfg"));
    }
    catch (IOException e1)
    {
      File file = new File("hm.cfg");
     
    }
    try
    {
      SPRACHE = Integer.parseInt(configFile.getProperty("SPRACHE"));
    }
    catch (Exception e)
    {
      configFile.setProperty("SPRACHE", "0");
      //SPRACHE = 0;
    }
  }
  
  public void saveConfigFile()
  {
    try
    {
      configFile.store(new FileWriter("hm.cfg"), 
        "Heatmaster Settingsfile");
    }
    catch (IOException e1)
    {
      e1.printStackTrace();
    }
    readConfigFile();
  }
  
  public void ladeLokalStandardEinstellungenAllgemein()
  {
    ALLGEMEIN_NAME = "Heatmaster";
    ALLGEMEIN_TEMP_EINHEIT = 0;
    ALLGEMEIN_PROFIL = 0;
    ALLGEMEIN_ATX_ABSCHALT_ZEIT = 8;
    ALLGEMEIN_ABFRAGE_INTERVALL = 1;
    
    readConfigFile();
  }
  
  public void ladeLokalStandardEinstellungenLuefter()
  {
    LUEFTER_AUSWAHL = 0;
    
    LUEFTER_NAME = new String[] { "Lüfter 1", "Lüfter 2", "Lüfter 3", 
      "Lüfter 4", "Lüfter 5", "Lüfter 6" };
    LUEFTER_STATUS = new int[6];
    LUEFTER_DREHZAHLFUNK = new int[6];
    LUEFTER_ABSCHALT_BEI_AUSFALL = new boolean[] { true, true, true, true, 
      true, true };
    LUEFTER_AKTION_AUSFALL = new int[6];
    LUEFTER_DREHZAHL_ERMITT = new int[6];
    LUEFTER_TACHO_FAKTOR = new int[] { 2, 2, 2, 2, 2, 2 };
    LUEFTER_SENSOR_A = new int[6];
    LUEFTER_SENSOR_B = new int[6];
    LUEFTER_MANUELL_AUTO = new int[6];
    
    LUEFTER_STARTTEMP = new int[6];
    LUEFTER_SOLLTEMP = new int[6];
    LUEFTER_MAXTEMP = new int[6];
    LUEFTER_REGELUNG_EINHEIT = new int[6];
    LUEFTER_STARTWERT_SPANNUNG = new int[6];
    LUEFTER_STARTWERT_DREHZAHL = new int[6];
    LUEFTER_MAX_SPANNUNG = new int[6];
    LUEFTER_MAX_DREHZAHL = new int[6];
    LUEFTER_HYSTERESE = new int[6];
    LUEFTER_MAN_SPANNUNG = new boolean[] { true, true, true, true, true, 
      true };
    LUEFTER_MAN_DREHZAHL = new boolean[6];
    
    LUEFTER_TYP = new int[6];
    LUEFTER_MANUELL_SPANNUNG = new int[] { 100, 100, 100, 100, 100, 100 };
    LUEFTER_MANUELL_DREHZAHL = new int[] { 100, 100, 100, 100, 100, 100 };
    LUEFTER_MAXLUEFTER_DREHZAHL = new int[6];
    LUEFTER_MINLUEFTER_DREHZAHL = new int[6];
  }
  
  public void ladeLokalStandardEinstellungenSensor()
  {
    SENSOR_AUSWAHL = 0;
    SENSOR_NAME = new String[] { "Sensor 1", "Sensor 2", "Sensor 3", 
      "Sensor 4", "Sensor 5", "Sensor 6" };
    SENSOR_STATUS = new int[6];
    SENSOR_NOTAUS = new int[6];
    
    SENSOR_TYP = new int[6];
    SENSOR_KORREKTUR = new int[] { 100, 100, 100, 100, 100, 100 };
    SENSOR_NTCTABELLE = new int[6];
    SENSOR_WARNWERT = new int[6];
    SENSOR_ALARMWERT = new int[] { 1, 1, 1, 1, 1, 1 };
    SENSOR_NOTAUSWERT = new int[] { 2, 2, 2, 2, 2, 2 };
  }
  
  public void ladeLokalStandardEinstellungenOffline()
  {
    OFFLINE_AQUA_DOCTOR_PC_START = new boolean[3];
    
    OFFLINE_PC_START_VERZ = new int[3];
    
    OFFLINE_STANDARD_SCHEMA = 0;
    OFFLINE_TASTER_AUSWAHL = 0;
    
    OFFLINE_RELAIS = new boolean[][] { new boolean[3], 
      new boolean[3], new boolean[3] };
    
    OFFLINE_RELAIS_VERZ_ART = new int[][] { new int[3], new int[3], 
      new int[3] };
    
    OFFLINE_RELAIS_VERZ_WERT = new int[][] { new int[3], new int[3], 
      new int[3] };
    
    OFFLINE_RELAIS_SCHALT_ART = new int[][] { new int[3], new int[3], 
      new int[3] };
    
    OFFLINE_RELAIS_SCHALT_WERT = new int[][] { new int[3], new int[3], 
      new int[3] };
  }
  
  public void ladeLokalStandardEinstellungenOnline()
  {
    ONLINE_RELAIS_AUSWAHL = 0;
    
    ONLINE_RELAIS_NAME = new String[] { "Relais 1", "Relais 2", "Relais 3" };
    
    ONLINE_NACHLAUF = new boolean[][] { new boolean[3], 
      new boolean[3], new boolean[3] };
    
    ONLINE_NACHLAUF_WERT = new int[][] { { 10, 10, 10 }, { 10, 10, 10 }, 
      { 10, 10, 10 } };
    
    ONLINE_SCHALTBAR_UEBER_SOFTWARE = new boolean[][] {
      new boolean[3], new boolean[3], 
      new boolean[3] };
    
    ONLINE_TEMPERATUR_SCHALTER = new boolean [3];
    
    ONLINE_SENSOR1_WAHL = new int[3];
    ONLINE_SENSOR2_WAHL = new int[3];
    ONLINE_SCHALTTEMPERATUR = new int[3];
    
    ONLINE_UEBERSCHREITEN = new boolean[] { true, true, true };
    ONLINE_UNTERSCHREITEN = new boolean[3];
    
    ONLINE_TASTER_AUSWAHL = 0;
    ONLINE_TASTER_FUNKTION = new int[3];
    
    ONLINE_TASTER_RELAIS = new boolean[][] { new boolean[3], 
      new boolean[3], new boolean[3] };
    
    ONLINE_RELAIS_KONF_AUSWAHL = 0;
  }
  
  public void ladeLokalStandardEinstellungenDisplay()
  {
    DISPLAY_HELLIGKEIT = 200;
    DISPLAY_HELLIGKEIT_SLEEP = 0;
    DISPLAY_HELLIGKEIT_STANDBY = 100;
    DISPLAY_ZEIT_STANDBY = 60;
  }
  
  public void ladeLokalStandardEinstellungenWasserStand()
  {
    WASSERSTAND_NAME = "Füllstand";
    
    WASSERSTAND_STATUS = 0;
    
    WASSERSTAND_TYP = 0;
    WASSERSTAND_AKTION = 0;
    
    WASSERSTAND_OBEN = false;
    WASSERSTAND_UNTEN = true;
    
    WASSERSTAND_ALARMMARKE = 70;
  }
  
  public void ladeLokalStandardEinstellungenWasserFluss()
  {
    WASSERFLUSS_AUSWAHL = 0;
    
    WASSERFLUSS_NAME = new String[] { "Was/Pumpe 1", "Was/Pumpe 2", 
      "Was/Pumpe 3" };
    
    WASSERFLUSS_STATUS = new int[3];
    
    WASSERFLUSS_TYP_PUMPE = new boolean[] { true, true, true };
    WASSERFLUSS_TYP_SENSOR = new boolean[3];
    
    WASSERFLUSS_SENSOR_UEBERWACHUNG = new boolean[3];
    
    WASSERFLUSS_SENSOR_FAKTOR = new int[] { 1, 1, 1 };
    WASSERFLUSS_SENSOR_EINHEIT = new int[3];
    
    WASSERFLUSS_SENSOR_EINHEIT_FAKTOR = new int[] { 100, 100, 100 };
    
    WASSERFLUSS_SENSOR_WARNMARKE = new int[] { 50, 50, 50 };
    WASSERFLUSS_SENSOR_ALARMMARKE = new int[] { 60, 60, 60 };
    WASSERFLUSS_SENSOR_NOTAUSMARKE = new int[] { 70, 70, 70 };
    WASSERFLUSS_PUMPE_MIN_DREHZAHL = new int[] { 1000, 1000, 1000 };
    WASSERFLUSS_PUMPE_ALARM_AKTION = new int[3];
    
    WASSERFLUSS_SENSOR_EINEIT_STRING = new String[] { "", "", "" };
  }
  
  public void ladeLokalStandardEinstellungenVergleich()
  {
    TEMP_VERGLEICH_NAME = new String[] { "Vergleich 1", "Vergleich 2", 
      "Vergleich 3" };
    
    TEMP_VERGLEICH_AKTIV = new boolean[3];
    
    TEMP_VERGLEICH_SENSOR1 = new int[] { 1, 1, 1 };
    TEMP_VERGLEICH_SENSOR2 = new int[] { 2, 2, 2 };
  }
  
  public void ladeLokalStandard()
  {
    ladeLokalStandardEinstellungenAllgemein();
    ladeLokalStandardEinstellungenDisplay();
    ladeLokalStandardEinstellungenOffline();
    ladeLokalStandardEinstellungenOnline();
    ladeLokalStandardEinstellungenSensor();
    ladeLokalStandardEinstellungenWasserFluss();
    ladeLokalStandardEinstellungenWasserStand();
    ladeLokalStandardEinstellungenLuefter();
    ladeLokalStandardEinstellungenVergleich();
  }
  
  public void starteDekodierung()
  {
    code.dekodiere();
  }
  
  public boolean isLuefterManuell(int Luefter)
  {
    switch (Luefter)
    {
    case 0: 
      return !BitTool.testBit(getInt(42, 4), 1);
    case 1: 
      return !BitTool.testBit(getInt(42, 8), 1);
    case 2: 
      return !BitTool.testBit(getInt(43, 2), 1);
    case 3: 
      return !BitTool.testBit(getInt(43, 6), 1);
    case 4: 
      return !BitTool.testBit(getInt(44, 0), 1);
    case 5: 
      return !BitTool.testBit(getInt(44, 4), 1);
    }
    return false;
  }
  
  public class Code
    implements Serializable
  {
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public int[] LuefterStatus = new int[6];
    public int[] DrehzahlFunktion = new int[6];
    public boolean[] AbschaltBeiAusfall = new boolean[6];
    public int[] AktionBeiAusfall = new int[6];
    public int[] DrehzahlErmitteln = new int[6];
    public int[] Manuell = new int[6];
    public boolean[] Spannung = new boolean[6];
    public boolean[] Drehzahl = new boolean[6];
    public int[] RegelungArt = new int[6];
    public int[] EinheitRegelung = new int[6];
    public int[] SensorA = new int[6];
    public int[] SensorB = new int[6];
    public int[] SensorStatus = new int[6];
    public int[] SensorArt = new int[6];
    public int[] Tabelle = new int[6];
    public int[] NotAus = new int[6];
    public int[] PumpeStatus = new int[3];
    public boolean[] PumpeTyp = new boolean[3];
    public boolean[] DurchTyp = new boolean[3];
    public int[] PumpeAktionAusfall = new int[3];
    public boolean[] PumpeUeberwachung = new boolean[3];
    public int[] SensorEinheit = new int[3];
    public int WasserStatus;
    public int WasserArt;
    public int WasserAktion;
    public boolean[] VergleichStatus = new boolean[3];
    
    public Code() {}
    
    public void dekodiere()
    {
      dekodiereErstesLuefter();
      dekodiereZweitesLuefter();
      dekodiereLuefterSensorZuweisung();
      dekodiereNTC();
      dekodierePumpe();
      dekodiereWasserStand();
      dekodiereVergleich();
    }
    
    public void kodiere()
    {
      kodiereErstesLuefter();
      kodiereZweitesLuefter();
      kodiereLuefterSensorZuweisung();
      kodiereNTC();
      kodierePumpe();
      kodiereWasserStand();
      kodiereVergleich();
    }
    
    public void dekodiereLuefterSensorZuweisung()
    {
      int[] array = Daten.getIntegerArray(53, 0, 6, true);
      for (int i = 0; i < 6; i++)
      {
        byte b = (byte)array[i];
        
        BitSet p = BitTool.fromByte(b);
        
        int x = 0;
        for (int j = 0; j < 6; j++) {
          if (p.get(j))
          {
            if (x == 0) {
              SensorA[i] = (j + 1);
            } else {
              SensorB[i] = (j + 1);
            }
            x++;
          }
        }
      }
    }
    
    public void dekodiereErstesLuefter()
    {
      int[] array = Daten.getIntegerArray(40, 0, 6, true);
      for (int i = 0; i < 6; i++)
      {
        byte b = (byte)array[i];
        BitSet p = BitTool.fromByte(b);
        
        BitSet hilf = new BitSet(2);
        hilf.set(0, p.get(0));
        hilf.set(1, p.get(1));
        
        byte b1 = BitTool.toByte(hilf);
        LuefterStatus[i] = b1;
        
        hilf = new BitSet(2);
        hilf.set(0, p.get(2));
        hilf.set(1, p.get(3));
        
        b1 = BitTool.toByte(hilf);
        DrehzahlFunktion[i] = b1;
        
        AbschaltBeiAusfall[i] = p.get(4);
        
        hilf = new BitSet(3);
        hilf.set(0, p.get(5));
        hilf.set(1, p.get(6));
        hilf.set(2, p.get(7));
        
        b1 = BitTool.toByte(hilf);
        switch (b1)
        {
        case 0: 
          AktionBeiAusfall[i] = 0;
          break;
        case 1: 
          AktionBeiAusfall[i] = 1;
          break;
        case 3: 
          AktionBeiAusfall[i] = 2;
          break;
        case 4: 
          AktionBeiAusfall[i] = 3;
          break;
        case 5: 
          AktionBeiAusfall[i] = 4;
        }
      }
    }
    
    public void dekodiereZweitesLuefter()
    {
      int[] array = Daten.getIntegerArray(42, 4, 6, true);
      for (int i = 0; i < 6; i++)
      {
        byte b = (byte)array[i];
        BitSet p = BitTool.fromByte(b);
        
        BitSet hilf = new BitSet(1);
        hilf.set(0, p.get(0));
        
        byte b1 = BitTool.toByte(hilf);
        DrehzahlErmitteln[i] = b1;
        if (p.get(1)) {
          Manuell[i] = 1;
        } else {
          Manuell[i] = 0;
        }
        if (p.get(2))
        {
          Drehzahl[i] = true;
          Spannung[i] = false;
        }
        else
        {
          Drehzahl[i] = false;
          Spannung[i] = true;
        }
        hilf = new BitSet(2);
        hilf.set(0, p.get(3));
        hilf.set(1, p.get(4));
        
        b1 = BitTool.toByte(hilf);
        RegelungArt[i] = b1;
        
        hilf = new BitSet(2);
        hilf.set(0, p.get(5));
        hilf.set(1, p.get(6));
        
        b1 = BitTool.toByte(hilf);
        EinheitRegelung[i] = b1;
      }
    }
    
    public void dekodiereNTC()
    {
      int[] array = Daten.getIntegerArray(82, 4, 6, true);
      for (int i = 0; i < 6; i++)
      {
        byte b = (byte)array[i];
        BitSet p = BitTool.fromByte(b);
        
        BitSet hilf = new BitSet(2);
        hilf.set(0, p.get(0));
        hilf.set(1, p.get(1));
        
        byte b1 = BitTool.toByte(hilf);
        SensorStatus[i] = b1;
        
        hilf = new BitSet(1);
        hilf.set(0, p.get(2));
        
        b1 = BitTool.toByte(hilf);
        SensorArt[i] = b1;
        if (p.get(3)) {
          Tabelle[i] = 0;
        } else {
          Tabelle[i] = 1;
        }
        if (p.get(4)) {
          NotAus[i] = 1;
        } else {
          NotAus[i] = 0;
        }
      }
    }
    
    public void dekodierePumpe()
    {
      int[] array = Daten.getIntegerArray(142, 0, 3, true);
      for (int i = 0; i < 3; i++)
      {
        byte b = (byte)array[i];
        BitSet p = BitTool.fromByte(b);
        
        BitSet hilf = new BitSet(2);
        hilf.set(0, p.get(0));
        hilf.set(1, p.get(1));
        
        byte b1 = BitTool.toByte(hilf);
        PumpeStatus[i] = b1;
        if (p.get(2))
        {
          PumpeTyp[i] = false;
          DurchTyp[i] = true;
        }
        else
        {
          PumpeTyp[i] = true;
          DurchTyp[i] = false;
        }
        hilf = new BitSet(2);
        hilf.set(0, p.get(3));
        hilf.set(1, p.get(4));
        
        b1 = BitTool.toByte(hilf);
        PumpeAktionAusfall[i] = b1;
        
        PumpeUeberwachung[i] = p.get(5);
        
        hilf = new BitSet(2);
        hilf.set(0, p.get(6));
        hilf.set(1, p.get(7));
        
        b1 = BitTool.toByte(hilf);
        SensorEinheit[i] = b1;
      }
    }
    
    public void dekodiereWasserStand()
    {
      int array = Daten.getIntegerArray(151, 1, 1, true)[0];
      
      byte b = (byte)array;
      BitSet p = BitTool.fromByte(b);
      
      BitSet hilf = new BitSet(2);
      hilf.set(0, p.get(0));
      hilf.set(1, p.get(1));
      
      byte b1 = BitTool.toByte(hilf);
      WasserStatus = b1;
      
      hilf = new BitSet(1);
      hilf.set(0, p.get(2));
      
      b1 = BitTool.toByte(hilf);
      WasserArt = b1;
      
      hilf = new BitSet(2);
      hilf.set(0, p.get(3));
      hilf.set(1, p.get(4));
      
      b1 = BitTool.toByte(hilf);
      WasserAktion = b1;
    }
    
    public void dekodiereVergleich()
    {
      int[] array = Daten.getIntegerArray(157, 4, 3, true);
      for (int i = 0; i < 3; i++)
      {
        byte b = (byte)array[i];
        BitSet p = BitTool.fromByte(b);
        
        VergleichStatus[i] = p.get(0);
      }
    }
    
    public void kodiereLuefterSensorZuweisung()
    {
      int[] array = new int[6];
      for (int i = 0; i < 6; i++)
      {
        BitSet b = new BitSet(8);
        if (LUEFTER_SENSOR_A[i] > 0) {
          b.set(LUEFTER_SENSOR_A[i] - 1);
        }
        if (LUEFTER_SENSOR_B[i] > 0) {
          b.set(LUEFTER_SENSOR_B[i] - 1);
        }
        array[i] = BitTool.toByte(b);
      }
      Daten.setIntegerArray(array, 53, 0, 6, true);
    }
    
    public void kodiereErstesLuefter()
    {
      int[] array = new int[6];
      for (int i = 0; i < 6; i++)
      {
        BitSet b = new BitSet(8);
        switch (LUEFTER_STATUS[i])
        {
        case 0: 
          break;
        case 1: 
          b.set(0);
          break;
        case 2: 
          b.set(1);
        }
        switch (LUEFTER_DREHZAHLFUNK[i])
        {
        case 0: 
          break;
        case 1: 
          b.set(2);
          break;
        case 2: 
          b.set(3);
        }
        if (LUEFTER_ABSCHALT_BEI_AUSFALL[i]) {
          b.set(4);
        }
        switch (LUEFTER_AKTION_AUSFALL[i])
        {
        case 0: 
          break;
        case 1: 
          b.set(5);
          break;
        case 2: 
          b.set(5);
          b.set(6);
          break;
        case 3: 
          b.set(7);
          break;
        case 4: 
          b.set(5);
          b.set(7);
        }
        byte bb = BitTool.toByte(b);
        
        array[i] = BitTool.toByte(b);
      }
      Daten.setIntegerArray(array, 40, 0, 6, true);
    }
    
    public void kodiereZweitesLuefter()
    {
      int[] array = new int[6];
      for (int i = 0; i < 6; i++)
      {
        BitSet b = new BitSet(8);
        if (LUEFTER_DREHZAHL_ERMITT[i] == 1) {
          b.set(0);
        }
        if (LUEFTER_MANUELL_AUTO[i] == 1) {
          b.set(1);
        }
        if (LUEFTER_MAN_DREHZAHL[i] != false) {
          b.set(2);
        }
        switch (LUEFTER_TYP[i])
        {
        case 0: 
          break;
        case 1: 
          b.set(3);
          break;
        case 2: 
          b.set(4);
          break;
        case 3: 
          b.set(3);
          b.set(4);
        }
        switch (LUEFTER_REGELUNG_EINHEIT[i])
        {
        case 0: 
          break;
        case 1: 
          b.set(5);
          break;
        case 2: 
          b.set(6);
        }
        array[i] = BitTool.toByte(b);
      }
      Daten.setIntegerArray(array, 42, 4, 6, true);
    }
    
    public void kodiereNTC()
    {
      int[] array = new int[6];
      for (int i = 0; i < 6; i++)
      {
        BitSet b = new BitSet(8);
        switch (SENSOR_STATUS[i])
        {
        case 0: 
          break;
        case 1: 
          b.set(0);
          break;
        case 2: 
          b.set(1);
        }
        switch (SENSOR_TYP[i])
        {
        case 0: 
          break;
        case 1: 
          b.set(2);
        }
        switch (SENSOR_NTCTABELLE[i])
        {
        case 0: 
          b.set(3);
          break;
        }
        if (SENSOR_NOTAUS[i] == 1) {
          b.set(4);
        }
        array[i] = BitTool.toByte(b);
      }
      Daten.setIntegerArray(array, 82, 4, 6, true);
    }
    
    public void kodierePumpe()
    {
      int[] array = new int[3];
      for (int i = 0; i < 3; i++)
      {
        BitSet b = new BitSet(8);
        switch (WASSERFLUSS_STATUS[i])
        {
        case 0: 
          break;
        case 1: 
          b.set(0);
          break;
        case 2: 
          b.set(1);
        }
        if (WASSERFLUSS_TYP_SENSOR[i] != false) {
          b.set(2);
        }
        switch (WASSERFLUSS_PUMPE_ALARM_AKTION[i])
        {
        case 0: 
          break;
        case 1: 
          b.set(3);
          break;
        case 2: 
          b.set(4);
        }
        if (WASSERFLUSS_SENSOR_UEBERWACHUNG[i] != false) {
          b.set(5);
        }
        switch (WASSERFLUSS_SENSOR_EINHEIT[i])
        {
        case 0: 
          break;
        case 1: 
          b.set(6);
          break;
        case 2: 
          b.set(7);
        }
        array[i] = BitTool.toByte(b);
      }
      Daten.setIntegerArray(array, 142, 0, 3, true);
    }
    
    public void kodiereWasserStand()
    {
      int[] array = new int[1];
      
      BitSet b = new BitSet(8);
      switch (WASSERSTAND_STATUS)
      {
      case 0: 
        break;
      case 1: 
        b.set(0);
        break;
      case 2: 
        b.set(1);
      }
      switch (WASSERSTAND_TYP)
      {
      case 0: 
        break;
      case 1: 
        b.set(2);
      }
      switch (WASSERSTAND_AKTION)
      {
      case 0: 
        break;
      case 1: 
        b.set(3);
        break;
      case 2: 
        b.set(4);
        break;
      case 3: 
        b.set(3);
        b.set(4);
      }
      array[0] = BitTool.toByte(b);
      
      Daten.setIntegerArray(array, 151, 1, 1, true);
    }
    
    public void kodiereVergleich()
    {
      int[] array = new int[3];
      for (int i = 0; i < 3; i++)
      {
        BitSet b = new BitSet(1);
        
        b.set(0, TEMP_VERGLEICH_AKTIV[i]);
        
        array[i] = BitTool.toByte(b);
      }
      Daten.setIntegerArray(array, 157, 4, 3, true);
    }
  }
  
  public class RelaisOnline
    implements Serializable
  {
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public RelaisOnline() {}
    
    public void leseKonfig()
    {
      leseRelaisOnlineTaster();
      leseRelaisOnlineRelais();
    }
    
    public void schreibeKonfig()
    {
      schreibeRelaisOnlineTaster();
      schreibeRelaisOnlineRelais();
    }
    
    public void leseRelaisOnlineRelais()
    {
      int x = 0;
      int y = 0;
      int z = 0;
      for (int i = 0; i < 3; i++)
      {
        z = 0;
        for (int j = 0; j < 3; j++)
        {
          if (BitTool.getInt(Daten.ar[(2200 + 2 * x + z)], Daten.ar[
            (2200 + 2 * x + z + 1)]) > 0)
          {
            ONLINE_NACHLAUF[i][j] = false;
            
            ONLINE_NACHLAUF_WERT[i][j] = BitTool.getInt(
              Daten.ar[(2200 + 2 * x)], Daten.ar[(2200 + 2 * x + 1)]);
          }
          z += 32;
        }
        dekodiereTempSensor();
        if (Daten.ar[(2030 + y)] > 0) {
          ONLINE_TEMPERATUR_SCHALTER[i] = true;
        }
        ONLINE_SCHALTTEMPERATUR[i] = 
          BitTool.getInt(Daten.ar[(2042 + y)], Daten.ar[(2042 + y + 1)]);
        if (Daten.ar[(2038 + y)] > Daten.ar[(2034 + y)])
        {
          ONLINE_UEBERSCHREITEN[i] = true;
          ONLINE_UNTERSCHREITEN[i] = false;
        }
        else
        {
          ONLINE_UEBERSCHREITEN[i] = false;
          ONLINE_UNTERSCHREITEN[i] = true;
        }
        x += 4;
        y += 20;
      }
    }
    
    public void schreibeRelaisOnlineRelais()
    {
      int x = 0;
      int y = 0;
      int z = 0;
      for (int i = 0; i < 3; i++)
      {
        z = 0;
        for (int j = 0; j < 3; j++)
        {
          if (ONLINE_NACHLAUF[i][j] != false)
          {
            Daten.ar[(2100 + 2 * x + z)] = 0;
            Daten.ar[(2100 + 2 * x + z + 1)] = 1;
            
            Daten.ar[(2200 + 2 * x + z)] = 
              BitTool.getHighByte(ONLINE_NACHLAUF_WERT[i][j]);
            Daten.ar[(2200 + 2 * x + z + 1)] = 
              BitTool.getLowByte(ONLINE_NACHLAUF_WERT[i][j]);
            Daten.ar[(2030 + y)] = 0;
          }
          else
          {
            ar[(2100 + 2 * x + z)] = 0;
            ar[(2100 + 2 * x + z + 1)] = 0;
            
            ar[(2200 + 2 * x + z)] = 0;
            ar[(2200 + 2 * x + z + 1)] = 0;
          }
          z += 32;
        }
        if (ONLINE_TEMPERATUR_SCHALTER[i] != false) {
          kodiereTempSensor(i);
          
          ar[(2042 + y)] = 
            BitTool.getHighByte(ONLINE_SCHALTTEMPERATUR[i]);
          ar[(2042 + y + 1)] = 
            BitTool.getLowByte(ONLINE_SCHALTTEMPERATUR[i]);
          if (ONLINE_UEBERSCHREITEN[i] != false) {
            switch (i)
            {
            case 0: 
              ar[(2034 + y)] = 1;
              ar[(2038 + y)] = 8;
              break;
            case 1: 
              ar[(2034 + y)] = 2;
              ar[(2038 + y)] = 9;
              break;
            case 2: 
              ar[(2034 + y)] = 3;
              ar[(2038 + y)] = 10;
            }
          } else {
            switch (i)
            {
            case 0: 
              Daten.ar[(2034 + y)] = 8;
              Daten.ar[(2038 + y)] = 1;
              break;
            case 1: 
              Daten.ar[(2034 + y)] = 9;
              Daten.ar[(2038 + y)] = 2;
              break;
            case 2: 
              Daten.ar[(2034 + y)] = 10;
              Daten.ar[(2038 + y)] = 3;
            }
          }
        }
        else
        {
          Daten.ar[(2030 + y)] = 0;
        }
        x += 4;
        y += 20;
      }
    }
    
    public void leseRelaisOnlineTaster()
    {
      int x = 0;
      for (int i = 0; i < 3; i++)
      {
        switch (Daten.ar[(1244 + x)])
        {
        case 0: 
          ONLINE_TASTER_FUNKTION[i] = 0;
          ONLINE_TASTER_RELAIS[i][0] = false;
          ONLINE_TASTER_RELAIS[i][1] = false;
          ONLINE_TASTER_RELAIS[i][2] = false;
          break;
        case 1: 
        case 15: 
          ONLINE_TASTER_FUNKTION[i] = 0;
          ONLINE_TASTER_RELAIS[i][0] = true;
          ONLINE_TASTER_RELAIS[i][1] = false;
          ONLINE_TASTER_RELAIS[i][2] = false;
          break;
        case 2: 
        case 16: 
          ONLINE_TASTER_FUNKTION[i] = 0;
          ONLINE_TASTER_RELAIS[i][0] = false;
          ONLINE_TASTER_RELAIS[i][1] = true;
          ONLINE_TASTER_RELAIS[i][2] = false;
          break;
        case 4: 
        case 18: 
        	ONLINE_TASTER_FUNKTION[i] = 0;
        	ONLINE_TASTER_RELAIS[i][0] = false;
        	ONLINE_TASTER_RELAIS[i][1] = true;
        	ONLINE_TASTER_RELAIS[i][2] = false;
          break;
        case 3: 
        case 17: 
        	ONLINE_TASTER_FUNKTION[i] = 0;
        	ONLINE_TASTER_RELAIS[i][0] = false;
        	ONLINE_TASTER_RELAIS[i][1] = false;
        	ONLINE_TASTER_RELAIS[i][2] = true;
          break;
        case 5: 
        case 19: 
        	ONLINE_TASTER_FUNKTION[i] = 0;
        	ONLINE_TASTER_RELAIS[i][0] = true;
        	ONLINE_TASTER_RELAIS[i][1] = false;
        	ONLINE_TASTER_RELAIS[i][2] = true;
          break;
        case 6: 
        case 20: 
        	ONLINE_TASTER_FUNKTION[i] = 0;
        	ONLINE_TASTER_RELAIS[i][0] = false;
        	ONLINE_TASTER_RELAIS[i][1] = true;
        	ONLINE_TASTER_RELAIS[i][2] = true;
          break;
        case 7: 
        case 21: 
          ONLINE_TASTER_FUNKTION[i] = 0;
          ONLINE_TASTER_RELAIS[i][0] = true;
          ONLINE_TASTER_RELAIS[i][1] = true;
          ONLINE_TASTER_RELAIS[i][2] = true;
          break;
        case 107: 
        	ONLINE_TASTER_FUNKTION[i] = 1;
        	ONLINE_TASTER_RELAIS[i][0] = false;
        	ONLINE_TASTER_RELAIS[i][1] = false;
        	ONLINE_TASTER_RELAIS[i][2] = false;
          break;
        case 101: 
        	ONLINE_TASTER_FUNKTION[i] = 2;
        	ONLINE_TASTER_RELAIS[i][0] = false;
        	ONLINE_TASTER_RELAIS[i][1] = false;
        	ONLINE_TASTER_RELAIS[i][2] = false;
          break;
        case 105: 
        	ONLINE_TASTER_FUNKTION[i] = 3;
        	ONLINE_TASTER_RELAIS[i][0] = false;
        	ONLINE_TASTER_RELAIS[i][1] = false;
        	ONLINE_TASTER_RELAIS[i][2] = false;
          break;
        case 14: 
        	ONLINE_TASTER_FUNKTION[i] = 4;
        	ONLINE_TASTER_RELAIS[i][0] = false;
        	ONLINE_TASTER_RELAIS[i][1] = false;
        	ONLINE_TASTER_RELAIS[i][2] = false;
        }
        x += 4;
      }
    }
    
    public void schreibeRelaisOnlineTaster()
    {
      int x = 0;
      for (int i = 0; i < 3; i++)
      {
        switch (ONLINE_TASTER_FUNKTION[i])
        {
        case 0: 
          BitSet bs = new BitSet(3);
          
          bs.set(0, ONLINE_TASTER_RELAIS[i][0]);
          bs.set(1, ONLINE_TASTER_RELAIS[i][1]);
          bs.set(2, ONLINE_TASTER_RELAIS[i][2]);
          
          byte b = BitTool.toByte(bs);
          switch (b)
          {
          case 0: 
            Daten.ar[(1244 + x)] = 0;
            break;
          case 1: 
            if (ONLINE_NACHLAUF[0][i] != false) {
              Daten.ar[(1244 + x)] = 1;
            } else {
              Daten.ar[(1244 + x)] = 15;
            }
            break;
          case 2: 
            if (ONLINE_NACHLAUF[1][i] != false) {
              Daten.ar[(1244 + x)] = 2;
            } else {
              Daten.ar[(1244 + x)] = 16;
            }
            break;
          case 3: 
            bs = new BitSet(2);
            
            bs.set(0, ONLINE_NACHLAUF[0][i] == false);
            bs.set(1, ONLINE_NACHLAUF[1][i] == false);
            
            b = BitTool.toByte(bs);
            switch (b)
            {
            case 0: 
              Daten.ar[(1244 + x)] = 4;
              break;
            case 1: 
              Daten.ar[(1244 + x)] = 15;
              break;
            case 2: 
              Daten.ar[(1244 + x)] = 16;
              break;
            case 3: 
              Daten.ar[(1244 + x)] = 18;
            }
            break;
          case 4: 
            if (ONLINE_NACHLAUF[2][i] != false) {
              Daten.ar[(1244 + x)] = 3;
            } else {
              Daten.ar[(1244 + x)] = 17;
            }
            break;
          case 5: 
            bs = new BitSet(2);
            
            bs.set(0, ONLINE_NACHLAUF[0][i] == false);
            bs.set(1, ONLINE_NACHLAUF[2][i] == false);
            
            b = BitTool.toByte(bs);
            switch (b)
            {
            case 0: 
              Daten.ar[(1244 + x)] = 5;
              break;
            case 1: 
              Daten.ar[(1244 + x)] = 15;
              break;
            case 2: 
              Daten.ar[(1244 + x)] = 17;
              break;
            case 3: 
              Daten.ar[(1244 + x)] = 19;
            }
            break;
          case 6: 
            bs = new BitSet(2);
            
            bs.set(0, ONLINE_NACHLAUF[1][i] == false);
            bs.set(1, ONLINE_NACHLAUF[2][i] == false);
            
            b = BitTool.toByte(bs);
            switch (b)
            {
            case 0: 
              Daten.ar[(1244 + x)] = 6;
              break;
            case 1: 
              Daten.ar[(1244 + x)] = 16;
              break;
            case 2: 
              Daten.ar[(1244 + x)] = 17;
              break;
            case 3: 
              Daten.ar[(1244 + x)] = 20;
            }
            break;
          case 7: 
            bs = new BitSet(3);
            
            bs.set(0, ONLINE_NACHLAUF[0][i] == false);
            bs.set(1, ONLINE_NACHLAUF[1][i] == false);
            bs.set(2, ONLINE_NACHLAUF[2][i] == false);
            
            b = BitTool.toByte(bs);
            switch (b)
            {
            case 0: 
              Daten.ar[(1244 + x)] = 7;
              break;
            case 1: 
              Daten.ar[(1244 + x)] = 15;
              break;
            case 2: 
              Daten.ar[(1244 + x)] = 16;
              break;
            case 3: 
              Daten.ar[(1244 + x)] = 18;
              break;
            case 4: 
              Daten.ar[(1244 + x)] = 17;
              break;
            case 5: 
              Daten.ar[(1244 + x)] = 19;
              break;
            case 6: 
              Daten.ar[(1244 + x)] = 20;
              break;
            case 7: 
              Daten.ar[(1244 + x)] = 21;
            }
            break;
          }
          break;
        case 1: 
          Daten.ar[(1244 + x)] = 107;
          break;
        case 2: 
          Daten.ar[(1244 + x)] = 101;
          break;
        case 3: 
          Daten.ar[(1244 + x)] = 105;
          break;
        case 4: 
          Daten.ar[(1244 + x)] = 14;
        }
        x += 4;
      }
    }
    
    public void kodiereTempSensor(int j)
    {
      for (int i = 0; i < 3; i++)
      {
        BitSet b = new BitSet(8);
        if (ONLINE_TEMPERATUR_SCHALTER[i] != false)
        {
          b.set(ONLINE_SENSOR1_WAHL[i]);
          if (ONLINE_SENSOR2_WAHL[i] > 0) {
            b.set(ONLINE_SENSOR2_WAHL[i] - 1);
          }
          Daten.ar[(2030 + j * 20)] = BitTool.toByte(b);
        }
      }
    }
    
    public void dekodiereTempSensor()
    {
      int y = 0;
      for (int i = 0; i < 3; i++)
      {
        byte b = (byte)Daten.ar[(2030 + y)];
        
        BitSet p = BitTool.fromByte(b);
        
        int x = 0;
        for (int j = 0; j < 6; j++) {
          if (p.get(j))
          {
            if (x == 0) {
            	ONLINE_SENSOR1_WAHL[i] = j;
            } else {
            	ONLINE_SENSOR2_WAHL[i] = (j + 1);
            }
            x++;
          }
        }
        y += 20;
      }
    }
  }
  
  public class RelaisOffline
    implements Serializable
  {
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public RelaisOffline() {}
    
    public void leseKonfig()
    {
      leseRelaisOffline();
    }
    
    public void schreibeKonfig()
    {
      schreibeRelaisOffline();
    }
    
    public void leseRelaisOffline()
    {
      int x = 0;
      int y = 0;
      int z = 0;
      for (int i = 0; i < 3; i++)
      {
        if (BitTool.getInt(Daten.ar[(1864 + x)], Daten.ar[(1864 + x + 1)]) > 0)
        {
          OFFLINE_AQUA_DOCTOR_PC_START[i] = true;
          OFFLINE_PC_START_VERZ[i] = 
            BitTool.getInt(Daten.ar[(1864 + x)], Daten.ar[(1864 + x + 1)]);
        }
        else if (Daten.ar[1864] == i + 1)
        {
        	OFFLINE_AQUA_DOCTOR_PC_START[i] = true;
        	OFFLINE_PC_START_VERZ[i] = 0;
        }
        else
        {
        	OFFLINE_AQUA_DOCTOR_PC_START[i] = false;
        	OFFLINE_PC_START_VERZ[i] = 0;
        }
        switch (Daten.ar[(858 + z)])
        {
        case 0: 
        	OFFLINE_RELAIS[i][0] = false;
        	OFFLINE_RELAIS[i][1] = false;
        	OFFLINE_RELAIS[i][2] = false;
          break;
        case 1: 
        	OFFLINE_RELAIS[i][0] = true;
        	OFFLINE_RELAIS[i][1] = false;
        	OFFLINE_RELAIS[i][2] = false;
          break;
        case 2: 
        	OFFLINE_RELAIS[i][0] = false;
        	OFFLINE_RELAIS[i][1] = true;
        	OFFLINE_RELAIS[i][2] = false;
          break;
        case 3: 
        	OFFLINE_RELAIS[i][0] = true;
        	OFFLINE_RELAIS[i][1] = true;
        	OFFLINE_RELAIS[i][2] = false;
          break;
        case 4: 
        	OFFLINE_RELAIS[i][0] = false;
        	OFFLINE_RELAIS[i][1] = false;
        	OFFLINE_RELAIS[i][2] = true;
          
          break;
        case 5: 
        	OFFLINE_RELAIS[i][0] = true;
        	OFFLINE_RELAIS[i][1] = false;
        	OFFLINE_RELAIS[i][2] = true;
          break;
        case 6: 
        	OFFLINE_RELAIS[i][0] = false;
        	OFFLINE_RELAIS[i][1] = true;
        	OFFLINE_RELAIS[i][2] = true;
          break;
        case 7: 
        	OFFLINE_RELAIS[i][0] = true;
        	OFFLINE_RELAIS[i][1] = true;
        	OFFLINE_RELAIS[i][2] = true;
        }
        y = 0;
        for (int j = 0; j < 3; j++)
        {
          if (BitTool.getInt(Daten.ar[(1840 + x + y)], Daten.ar[(1840 + x + y + 1)]) < 10)
          {
        	  OFFLINE_RELAIS_VERZ_ART[i][j] = 0;
        	  OFFLINE_RELAIS_VERZ_WERT[i][j] = 0;
          }
          else
          {
        	  OFFLINE_RELAIS_VERZ_ART[i][j] = 1;
        	  OFFLINE_RELAIS_VERZ_WERT[i][j] = 
              BitTool.getInt(Daten.ar[(1840 + x + y)], Daten.ar[(1840 + x + y + 1)]);
          }
          switch (BitTool.getInt(Daten.ar[(1940 + x + y)], Daten.ar[
            (1940 + x + y + 1)]))
          {
          case 0: 
        	  OFFLINE_RELAIS_SCHALT_ART[i][j] = getAuschaltArt(z, j);
        	  OFFLINE_RELAIS_SCHALT_WERT[i][j] = 
            
              getAuschaltZeit(BitTool.getInt(Daten.ar[(1940 + x + y)], Daten.ar[(1940 + x + y + 1)]));
            break;
          default: 
        	  OFFLINE_RELAIS_SCHALT_ART[i][j] = 1;
        	  OFFLINE_RELAIS_SCHALT_WERT[i][j] = 
            
              getAuschaltZeit(BitTool.getInt(Daten.ar[(1940 + x + y)], Daten.ar[(1940 + x + y + 1)]));
          }
          y += 8;
        }
        z += 4;
        x += 32;
      }
    }
    
    public int getAuschaltZeit(int Zeit)
    {
      switch (Zeit)
      {
      case 0: 
        return 0;
      }
      return Zeit;
    }
    
    public int getAuschaltArt(int Wert, int Relais)
    {
      int x = Daten.ar[(1280 + Wert)];
      int y = Daten.ar[(1476 + Wert)];
      int z = Daten.ar[(1534 + Wert)];
      if (x == 0)
      {
        if (y > 0) {
          switch (Relais)
          {
          case 0: 
            if ((y == 8) || (y == 11) || (y == 12) || (y == 14)) {
              return 2;
            }
            break;
          case 1: 
            if ((y == 9) || (y == 11) || (y == 13) || (y == 14)) {
              return 2;
            }
            break;
          case 2: 
            if ((y == 10) || (y == 12) || (y == 13) || (y == 14)) {
              return 2;
            }
            break;
          }
        }
        if (z > 0) {
          switch (Relais)
          {
          case 0: 
            if ((z == 8) || (z == 11) || (z == 12) || (z == 14)) {
              return 3;
            }
            break;
          case 1: 
            if ((z == 9) || (z == 11) || (z == 13) || (z == 14)) {
              return 3;
            }
            break;
          case 2: 
            if ((z == 10) || (z == 12) || (z == 13) || (z == 14)) {
              return 3;
            }
            break;
          }
        }
      }
      return 0;
    }
    
    public void schreibeRelaisOffline()
    {
      int TasterAbstand = 32;
      int RelaisAbstand = 4;
      for (int i = 0; i < 3; i++)
      {
        if (OFFLINE_AQUA_DOCTOR_PC_START[i] != false)
        {
          Daten.ar[(1864 + TasterAbstand * i)] = 
            BitTool.getHighByte(OFFLINE_PC_START_VERZ[i]);
          Daten.ar[(1864 + TasterAbstand * i + 1)] = 
            BitTool.getLowByte(OFFLINE_PC_START_VERZ[i]);
        }
        else
        {
          Daten.ar[(1864 + TasterAbstand * i)] = 0;
          Daten.ar[(1864 + TasterAbstand * i + 1)] = 0;
        }
        BitSet bs = new BitSet(3);
        
        bs.set(0, OFFLINE_RELAIS[i][0]);
        bs.set(1, OFFLINE_RELAIS[i][1]);
        bs.set(2, OFFLINE_RELAIS[i][2]);
        
        byte b = BitTool.toByte(bs);
        
        Daten.ar[(858 + RelaisAbstand * i)] = b;
        
        BitSet Toggle = new BitSet(3);
        BitSet Taster = new BitSet(3);
        BitSet Hoch = new BitSet(3);
        for (int j = 0; j < 3; j++) {
          switch (OFFLINE_RELAIS_VERZ_ART[i][j])
          {
          case 0: 
            switch (OFFLINE_RELAIS_SCHALT_ART[i][j])
            {
            case 0: 
              Toggle.set(j, false);
              Taster.set(j, false);
              Hoch.set(j, false);
              
              Daten.ar[
                (1840 + 2 * (RelaisAbstand * j) + i * TasterAbstand)] = 0;
              Daten.ar[
                (1840 + 2 * (RelaisAbstand * j) + i * TasterAbstand + 1)] = 0;
              Daten.ar[
                (1940 + 2 * (RelaisAbstand * j) + i * TasterAbstand)] = 0;
              Daten.ar[
                (1940 + 2 * (RelaisAbstand * j) + i * TasterAbstand + 1)] = 0;
              break;
            case 1: 
              Toggle.set(j, false);
              Taster.set(j, false);
              Hoch.set(j, false);
              
              Daten.ar[
                (1840 + 2 * (RelaisAbstand * j) + i * TasterAbstand)] = 0;
              Daten.ar[
                (1840 + 2 * (RelaisAbstand * j) + i * TasterAbstand + 1)] = 1;
              Daten.ar[
                (1940 + 2 * (RelaisAbstand * j) + i * TasterAbstand)] = 
                BitTool.getHighByte(OFFLINE_RELAIS_SCHALT_WERT[i][j]);
              Daten.ar[
                (1940 + 2 * (RelaisAbstand * j) + i * TasterAbstand + 1)] = 
                BitTool.getLowByte(OFFLINE_RELAIS_SCHALT_WERT[i][j]);
              
              break;
            case 2: 
              Toggle.set(j, false);
              Taster.set(j, true);
              Hoch.set(j, false);
              
              Daten.ar[
                (1840 + 2 * (RelaisAbstand * j) + i * TasterAbstand)] = 0;
              Daten.ar[
                (1840 + 2 * (RelaisAbstand * j) + i * TasterAbstand + 1)] = 1;
              Daten.ar[
                (1940 + 2 * (RelaisAbstand * j) + i * TasterAbstand)] = 0;
              Daten.ar[
                (1940 + 2 * (RelaisAbstand * j) + i * TasterAbstand + 1)] = 0;
              
              break;
            case 3: 
              Toggle.set(j, false);
              Taster.set(j, false);
              Hoch.set(j, true);
              
              Daten.ar[
                (1840 + 2 * (RelaisAbstand * j) + i * TasterAbstand)] = 0;
              Daten.ar[
                (1840 + 2 * (RelaisAbstand * j) + i * TasterAbstand + 1)] = 1;
              Daten.ar[
                (1940 + 2 * (RelaisAbstand * j) + i * TasterAbstand)] = 0;
              Daten.ar[
                (1940 + 2 * (RelaisAbstand * j) + i * TasterAbstand + 1)] = 0;
            }
            break;
          case 1: 
            switch (OFFLINE_RELAIS_SCHALT_ART[i][j])
            {
            case 0: 
              Toggle.set(j, false);
              Taster.set(j, false);
              Hoch.set(j, false);
              
              Daten.ar[
                (1840 + 2 * (RelaisAbstand * j) + i * TasterAbstand)] = 
                BitTool.getHighByte(OFFLINE_RELAIS_VERZ_WERT[i][j]);
              Daten.ar[
                (1840 + 2 * (RelaisAbstand * j) + i * TasterAbstand + 1)] = 
                BitTool.getLowByte(OFFLINE_RELAIS_VERZ_WERT[i][j]);
              Daten.ar[
                (1940 + 2 * (RelaisAbstand * j) + i * TasterAbstand)] = 0;
              Daten.ar[
                (1940 + 2 * (RelaisAbstand * j) + i * TasterAbstand + 1)] = 0;
              break;
            case 1: 
              Toggle.set(j, false);
              Taster.set(j, false);
              Hoch.set(j, false);
              
              Daten.ar[
                (1840 + 2 * (RelaisAbstand * j) + i * TasterAbstand)] = 
                BitTool.getHighByte(OFFLINE_RELAIS_VERZ_WERT[i][j]);
              Daten.ar[
                (1840 + 2 * (RelaisAbstand * j) + i * TasterAbstand + 1)] = 
                BitTool.getLowByte(OFFLINE_RELAIS_VERZ_WERT[i][j]);
              Daten.ar[
                (1940 + 2 * (RelaisAbstand * j) + i * TasterAbstand)] = 
                BitTool.getHighByte(OFFLINE_RELAIS_SCHALT_WERT[i][j]);
              Daten.ar[
                (1940 + 2 * (RelaisAbstand * j) + i * TasterAbstand + 1)] = 
                BitTool.getLowByte(OFFLINE_RELAIS_SCHALT_WERT[i][j]);
              
              break;
            case 2: 
              Toggle.set(j, false);
              Taster.set(j, true);
              Hoch.set(j, false);
              
              Daten.ar[
                (1840 + 2 * (RelaisAbstand * j) + i * TasterAbstand)] = 
                BitTool.getHighByte(OFFLINE_RELAIS_VERZ_WERT[i][j]);
              Daten.ar[
                (1840 + 2 * (RelaisAbstand * j) + i * TasterAbstand + 1)] = 
                BitTool.getLowByte(OFFLINE_RELAIS_VERZ_WERT[i][j]);
              Daten.ar[
                (1940 + 2 * (RelaisAbstand * j) + i * TasterAbstand)] = 0;
              Daten.ar[
                (1940 + 2 * (RelaisAbstand * j) + i * TasterAbstand + 1)] = 0;
              
              break;
            case 3: 
              Toggle.set(j, false);
              Taster.set(j, false);
              Hoch.set(j, true);
              
              Daten.ar[
                (1840 + 2 * (RelaisAbstand * j) + i * TasterAbstand)] = 
                BitTool.getHighByte(OFFLINE_RELAIS_VERZ_WERT[i][j]);
              Daten.ar[
                (1840 + 2 * (RelaisAbstand * j) + i * TasterAbstand + 1)] = 
                BitTool.getLowByte(OFFLINE_RELAIS_VERZ_WERT[i][j]);
              Daten.ar[
                (1940 + 2 * (RelaisAbstand * j) + i * TasterAbstand)] = 0;
              Daten.ar[
                (1940 + 2 * (RelaisAbstand * j) + i * TasterAbstand + 1)] = 0;
            }
            break;
          }
        }
        Daten.ar[(1280 + 4 * i)] = getToggleWert(BitTool.toByte(Toggle));
        Daten.ar[(1476 + 4 * i)] = getHochTasterWert(BitTool.toByte(Taster));
        Daten.ar[(1534 + 4 * i)] = getHochTasterWert(BitTool.toByte(Hoch));
      }
    }
    
    public byte getToggleWert(byte b)
    {
      switch (b)
      {
      case 0: 
        return 0;
      case 3: 
        return (byte)(b + 15);
      case 4: 
        return (byte)(b + 13);
      }
      return (byte)(b + 14);
    }
    
    public byte getHochTasterWert(byte b)
    {
      switch (b)
      {
      case 0: 
        return 0;
      case 3: 
        return (byte)(b + 8);
      case 4: 
        return (byte)(b + 6);
      }
      return (byte)(b + 7);
    }
  }
  
  public void laden(ComTabelle tab)
    throws Exception
  {
    if (!tab.beendet)
    {
      for (int i = 0; i < ComTabelle.EEPROM_ANZAHL; i++) {
        tab.setzeLesen(ComTabelle.getAdresse(i, false, false));
      }
      try
      {
        tab.starteEEPromLesen();
      }
      catch (Exception e) {}
      int z = 0;
      for (int i = 0; i < ComTabelle.EEPROM_ANZAHL; i++) {
        try
        {
          for (int j = 0; j < 10; j++)
          {
            ar[z] = tab.EEProm[i][j];
            z++;
          }
        }
        catch (Exception e) {}
      }
      SERIEN_NR = getSerienNr();
      SW_VERSION = getSWVersion();
      HW_VERSION = getHWVersion();
      
      ladeAqua_DoctorEinstellungen();
    }
  }
  
  public void speichern(ComTabelle tab)
    throws Exception
  {
    code.kodiere();
    
    schreibeAqua_DoctorEinstellungenAllgemein();
    schreibeAqua_DoctorEinstellungenLuefter();
    schreibeAqua_DoctorEinstellungenSensor();
    schreibeAqua_DoctorEinstellungenWasserFluss();
    schreibeAqua_DoctorEinstellungenWasserStand();
    schreibeAqua_DoctorEinstellungenDisplay();
    schreibeAqua_DoctorEinstellungenVergleich();
    schreibeAqua_DoctorEinstellungenOnline();
    schreibeAqua_DoctorEinstellungenOffline();
    
    byte b = 63;
    int[] array = new int[10];
    int y = 301;
    for (int i = 0; i < 6; i++) {
      if ((LUEFTER_STATUS[i] == 0) || (LUEFTER_STATUS[i] == 1)) {
        array[i] = 0;
      } else if ((LUEFTER_MANUELL_AUTO[i] == 0) && 
        (LUEFTER_MAN_SPANNUNG[i] != false)) {
        array[i] = LUEFTER_MANUELL_SPANNUNG[i];
      } else {
        array[i] = 250;
      }
    }
    array[6] = b;
    
    tab.setzeSchreiben(ComTabelle.getAdresse(1, true, false), array);
    
    tab.starteRamSchreiben();
    
    int d = 0;
    for (int i = 0; i < 6; i++) {
      if (LUEFTER_DREHZAHL_ERMITT[i] == 1) {
        d = 1;
      }
    }
    ar[6] = d;
    
    int x = 10;
    y = 1;
    for (int i = 1; i < 300; i++)
    {
      System.arraycopy(ar, x, array, 0, 10);
      x += 10;
      
      tab.setzeSchreiben(ComTabelle.getAdresse(y, false, false), array);
      y++;
    }
    tab.starteEEPromSchreiben();
  }
  
  public void schreibeDrehzahlWerte(ComTabelle tab, int Luefter)
  {
    switch (Luefter)
    {
    case 0: 
      tab.setzeSchreiben(ComTabelle.getAdresse(18, false, false), 4, 
        LUEFTER_MANUELL_DREHZAHL[Luefter], false);
      break;
    case 1: 
      tab.setzeSchreiben(ComTabelle.getAdresse(18, false, false), 8, 
        LUEFTER_MANUELL_DREHZAHL[Luefter], false);
      break;
    case 2: 
      tab.setzeSchreiben(ComTabelle.getAdresse(19, false, false), 2, 
        LUEFTER_MANUELL_DREHZAHL[Luefter], false);
      break;
    case 3: 
      tab.setzeSchreiben(ComTabelle.getAdresse(19, false, false), 6, 
        LUEFTER_MANUELL_DREHZAHL[Luefter], false);
      break;
    case 4: 
      tab.setzeSchreiben(ComTabelle.getAdresse(20, false, false), 0, 
        LUEFTER_MANUELL_DREHZAHL[Luefter], false);
      break;
    case 5: 
      tab.setzeSchreiben(ComTabelle.getAdresse(20, false, false), 4, 
        LUEFTER_MANUELL_DREHZAHL[Luefter], false);
    }
    try
    {
      tab.starteEEPromSchreiben();
    }
    catch (Exception e)
    {
    	
    }
  }
  
  public void importKonfiguration(DatenKlasse data)
    throws Exception
  {
    Daten daten = (Daten)data;
    
    SPRACHE = daten.SPRACHE;
    
    ALLGEMEIN_NAME = daten.ALLGEMEIN_NAME;
    
    ALLGEMEIN_TEMP_EINHEIT = daten.ALLGEMEIN_TEMP_EINHEIT;
    ALLGEMEIN_PROFIL = daten.ALLGEMEIN_PROFIL;
    ALLGEMEIN_ATX_ABSCHALT_ZEIT = daten.ALLGEMEIN_ATX_ABSCHALT_ZEIT;
    ALLGEMEIN_ABFRAGE_INTERVALL = daten.ALLGEMEIN_ABFRAGE_INTERVALL;
    
    LUEFTER_NAME = daten.LUEFTER_NAME;
    
    LUEFTER_STATUS = daten.LUEFTER_STATUS;
    LUEFTER_DREHZAHLFUNK = daten.LUEFTER_DREHZAHLFUNK;
    
    LUEFTER_ABSCHALT_BEI_AUSFALL = daten.LUEFTER_ABSCHALT_BEI_AUSFALL;
    
    LUEFTER_AKTION_AUSFALL = daten.LUEFTER_AKTION_AUSFALL;
    LUEFTER_DREHZAHL_ERMITT = daten.LUEFTER_DREHZAHL_ERMITT;
    LUEFTER_TACHO_FAKTOR = daten.LUEFTER_TACHO_FAKTOR;
    LUEFTER_SENSOR_A = daten.LUEFTER_SENSOR_A;
    LUEFTER_SENSOR_B = daten.LUEFTER_SENSOR_B;
    
    LUEFTER_MANUELL_AUTO = daten.LUEFTER_MANUELL_AUTO;
    
    LUEFTER_STARTTEMP = daten.LUEFTER_STARTTEMP;
    LUEFTER_SOLLTEMP = daten.LUEFTER_SOLLTEMP;
    LUEFTER_MAXTEMP = daten.LUEFTER_MAXTEMP;
    
    LUEFTER_REGELUNG_EINHEIT = daten.LUEFTER_REGELUNG_EINHEIT;
    
    LUEFTER_STARTWERT_SPANNUNG = daten.LUEFTER_STARTWERT_SPANNUNG;
    LUEFTER_STARTWERT_DREHZAHL = daten.LUEFTER_STARTWERT_DREHZAHL;
    
    LUEFTER_MAX_SPANNUNG = daten.LUEFTER_MAX_SPANNUNG;
    LUEFTER_MAX_DREHZAHL = daten.LUEFTER_MAX_DREHZAHL;
    
    LUEFTER_HYSTERESE = daten.LUEFTER_HYSTERESE;
    
    LUEFTER_MAN_SPANNUNG = daten.LUEFTER_MAN_SPANNUNG;
    LUEFTER_MAN_DREHZAHL = daten.LUEFTER_MAN_DREHZAHL;
    
    LUEFTER_TYP = daten.LUEFTER_TYP;
    
    LUEFTER_MANUELL_SPANNUNG = daten.LUEFTER_MANUELL_SPANNUNG;
    LUEFTER_MANUELL_DREHZAHL = daten.LUEFTER_MANUELL_DREHZAHL;
    
    LUEFTER_MAXLUEFTER_DREHZAHL = daten.LUEFTER_MAXLUEFTER_DREHZAHL;
    LUEFTER_MINLUEFTER_DREHZAHL = daten.LUEFTER_MINLUEFTER_DREHZAHL;
    
    SENSOR_NAME = daten.SENSOR_NAME;
    SENSOR_STATUS = daten.SENSOR_STATUS;
    SENSOR_NOTAUS = daten.SENSOR_NOTAUS;
    
    SENSOR_TYP = daten.SENSOR_TYP;
    SENSOR_KORREKTUR = daten.SENSOR_KORREKTUR;
    SENSOR_NTCTABELLE = daten.SENSOR_NTCTABELLE;
    SENSOR_WARNWERT = daten.SENSOR_WARNWERT;
    SENSOR_ALARMWERT = daten.SENSOR_ALARMWERT;
    SENSOR_NOTAUSWERT = daten.SENSOR_NOTAUSWERT;
    
    OFFLINE_AQUA_DOCTOR_PC_START = daten.OFFLINE_AQUA_DOCTOR_PC_START;
    OFFLINE_PC_START_VERZ = daten.OFFLINE_PC_START_VERZ;
    
    OFFLINE_STANDARD_SCHEMA = daten.OFFLINE_STANDARD_SCHEMA;
    
    OFFLINE_RELAIS = daten.OFFLINE_RELAIS;
    
    OFFLINE_RELAIS_VERZ_ART = daten.OFFLINE_RELAIS_VERZ_ART;
    
    OFFLINE_RELAIS_VERZ_WERT = daten.OFFLINE_RELAIS_VERZ_WERT;
    
    OFFLINE_RELAIS_SCHALT_ART = daten.OFFLINE_RELAIS_SCHALT_ART;
    
    OFFLINE_RELAIS_SCHALT_WERT = daten.OFFLINE_RELAIS_SCHALT_WERT;
    
    ONLINE_RELAIS_NAME = daten.ONLINE_RELAIS_NAME;
    
    ONLINE_NACHLAUF = daten.ONLINE_NACHLAUF;
    
    ONLINE_NACHLAUF_WERT = daten.ONLINE_NACHLAUF_WERT;
    
    ONLINE_SCHALTBAR_UEBER_SOFTWARE = daten.ONLINE_SCHALTBAR_UEBER_SOFTWARE;
    
    ONLINE_TEMPERATUR_SCHALTER = daten.ONLINE_TEMPERATUR_SCHALTER;
    
    ONLINE_SENSOR1_WAHL = daten.ONLINE_SENSOR1_WAHL;
    ONLINE_SENSOR2_WAHL = daten.ONLINE_SENSOR2_WAHL;
    
    ONLINE_SCHALTTEMPERATUR = daten.ONLINE_SCHALTTEMPERATUR;
    
    ONLINE_UEBERSCHREITEN = daten.ONLINE_UEBERSCHREITEN;
    ONLINE_UNTERSCHREITEN = daten.ONLINE_UNTERSCHREITEN;
    
    ONLINE_TASTER_FUNKTION = daten.ONLINE_TASTER_FUNKTION;
    
    ONLINE_TASTER_RELAIS = daten.ONLINE_TASTER_RELAIS;
    
    ONLINE_RELAIS_KONF_AUSWAHL = daten.ONLINE_RELAIS_KONF_AUSWAHL;
    
    DISPLAY_HELLIGKEIT = daten.DISPLAY_HELLIGKEIT;
    DISPLAY_HELLIGKEIT_SLEEP = daten.DISPLAY_HELLIGKEIT_SLEEP;
    DISPLAY_HELLIGKEIT_STANDBY = daten.DISPLAY_HELLIGKEIT_STANDBY;
    DISPLAY_ZEIT_STANDBY = daten.DISPLAY_ZEIT_STANDBY;
    
    WASSERSTAND_NAME = daten.WASSERSTAND_NAME;
    
    WASSERSTAND_STATUS = daten.WASSERSTAND_STATUS;
    
    WASSERSTAND_TYP = daten.WASSERSTAND_TYP;
    WASSERSTAND_AKTION = daten.WASSERSTAND_AKTION;
    
    WASSERSTAND_OBEN = daten.WASSERSTAND_OBEN;
    WASSERSTAND_UNTEN = daten.WASSERSTAND_UNTEN;
    
    WASSERSTAND_ALARMMARKE = daten.WASSERSTAND_ALARMMARKE;
    
    WASSERFLUSS_NAME = daten.WASSERFLUSS_NAME;
    WASSERFLUSS_STATUS = daten.WASSERFLUSS_STATUS;
    
    WASSERFLUSS_TYP_PUMPE = daten.WASSERFLUSS_TYP_PUMPE;
    WASSERFLUSS_TYP_SENSOR = daten.WASSERFLUSS_TYP_SENSOR;
    WASSERFLUSS_SENSOR_UEBERWACHUNG = daten.WASSERFLUSS_SENSOR_UEBERWACHUNG;
    
    WASSERFLUSS_SENSOR_FAKTOR = daten.WASSERFLUSS_SENSOR_FAKTOR;
    WASSERFLUSS_SENSOR_EINHEIT = daten.WASSERFLUSS_SENSOR_EINHEIT;
    WASSERFLUSS_SENSOR_EINHEIT_FAKTOR = daten.WASSERFLUSS_SENSOR_EINHEIT_FAKTOR;
    
    WASSERFLUSS_SENSOR_WARNMARKE = daten.WASSERFLUSS_SENSOR_WARNMARKE;
    WASSERFLUSS_SENSOR_ALARMMARKE = daten.WASSERFLUSS_SENSOR_ALARMMARKE;
    WASSERFLUSS_SENSOR_NOTAUSMARKE = daten.WASSERFLUSS_SENSOR_NOTAUSMARKE;
    
    WASSERFLUSS_PUMPE_MIN_DREHZAHL = daten.WASSERFLUSS_PUMPE_MIN_DREHZAHL;
    WASSERFLUSS_PUMPE_ALARM_AKTION = daten.WASSERFLUSS_PUMPE_ALARM_AKTION;
    
    WASSERFLUSS_SENSOR_EINEIT_STRING = daten.WASSERFLUSS_SENSOR_EINEIT_STRING;
    
    TEMP_VERGLEICH_NAME = daten.TEMP_VERGLEICH_NAME;
    
    TEMP_VERGLEICH_AKTIV = daten.TEMP_VERGLEICH_AKTIV;
    
    TEMP_VERGLEICH_SENSOR1 = daten.TEMP_VERGLEICH_SENSOR1;
    TEMP_VERGLEICH_SENSOR2 = daten.TEMP_VERGLEICH_SENSOR2;
  }
}
