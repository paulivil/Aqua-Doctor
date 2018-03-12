package Aqua_Doctor.ressource;

import Aqua_Doctor.GUI.MainFrame;
import java.io.BufferedReader;
import Aqua_Doctor.ressource.Daten;

public class Sprache
{
  private final int ANZAHL = 287;
  public  String SYSTEM_ZEIT;
  public  String BEZEICHNUNG;
  public  String STATUS;
  public  String BELEUCHTUNG;
  public  String ABFRAGE_INTERVALL;
  public  String MAX;
  public  String MIN;
  public  String OK;
  public  String ERROR;
  public  String NV;
  public  String FERTIG;
  public  String STARTEN;
  public  String DREHZAHLEN_WURDEN_ERMITTELT;
  public  String LUEFTER_BESITZ_KEINE_DREHZAHLFUNKTION;
  public  String MINDREHZAHL_KANN_NICHT_ERMITTELT_WERDEN;
  public  String ERMITTLE_MAXIMALE_DREHZAHL;
  public  String ERMITTLE_MINIMALE_DREHZAHL;
  public  String HINWEIS_LUEFTER_DREHZAHL_ERKENNUNG;
  public  String TITEL_LUEFTER_DREHZAHL_ERKENNEN;
  public  String AN;
  public  String AUS;
  public  String JA;
  public  String NEIN;
  public  String LUEFTER;
  public  String LUEFTER1;
  public  String LUEFTER2;
  public  String LUEFTER3;
  public  String LUEFTER4;
  public  String LUEFTER5;
  public  String LUEFTER6;
  public  String SENSOR;
  public  String SENSOR1;
  public  String SENSOR2;
  public  String SENSOR3;
  public  String SENSOR4;
  public  String SENSOR5;
  public  String SENSOR6;
  public  String SENSOR_A;
  public  String SENSOR_B;
  public  String RELAIS;
  public  String RELAIS1;
  public  String RELAIS2;
  public  String RELAIS3;
  public  String TASTER;
  public  String TASTER1;
  public  String TASTER2;
  public  String TASTER3;
  public  String PROFIL;
  public  String PROFIL1;
  public  String PROFIL2;
  public  String PROFIL3;
  public  String SICHT;
  public  String SICHT1;
  public  String SICHT2;
  public  String SICHT3;
  public  String DREHZAHLFUNKTION;
  public  String LUEFTER_ABSCHALTEN_BEI_AUSFALL;
  public  String AKTION_LUEFTER_AUSFALL;
  public  String MINMAX_DREHZAHL_ERMITTELN;
  public  String TACHO_FAKTOR;
  public  String REGELUNG;
  public  String MANUELL;
  public  String AUTOMATISCH;
  public  String SYSTEMSTART;
  public  String JETZT;
  public  String NIE;
  public  String KEINE;
  public  String STUMMER_ALARM;
  public  String ALARM;
  public  String RUNTERFAHREN;
  public  String NOTABSCHALT;
  public  String KEINER;
  public  String LINEAR;
  public  String PROGRESSIV;
  public  String SOLLWERTREGELUNG;
  public  String AUTOFAN;
  public  String VOLT;
  public  String TYP;
  public  String SOLLTEMP;
  public  String MAXTEMP;
  public  String STARTTEMP;
  public  String STARTWERT;
  public  String REGELUNG_EINHEIT;
  public  String MAXDREHZAHL;
  public  String HYSTERESE;
  public  String AKTIV;
  public  String NICHT_VORHANDEN;
  public  String INAKTIV;
  public  String LUEFTERDREHZAHL;
  public  String LUEFTERSPANNUNG;
  public  String TOOLTIP_TACHO_FAKTOR;
  public  String NOT_AN;
  public  String NOT_AUS;
  public  String KORREKTUR_WERT;
  public  String NTC_TABELLE;
  public  String WARNUNG;
  public  String EINSTELLUNG_UEBERTRAGEN;
  public  String TEMPERATUR_WERTE;
  public  String EINSTELLUNG;
  public  String ANALOG;
  public  String DIGITAL;
  public  String STANDARD;
  public  String EIGENER;
  public  String FRAGE_SENSOR_DATEN_UEBERTRAGEN;
  public  String TITEL_EINSTELLUNGEN_UEBERNEHMEN;
  public  String INFO_SENSOR_DATEN_UEBERTRAGEN;
  public  String FRAGE_SOFWARE_BEENDEN;
  public  String TITEL_SOFWARE_BEENDEN;
  public  String SCHALTZEIT;
  public  String HEATMASTER_2_KANN_PC_STARTEN;
  public  String VERZOEGERUNG;
  public  String ZEIT;
  public  String ENDLOS;
  public  String BIS_ERNEUTEM_TASTENDRUCK;
  public  String BIS_RECHNER_HOCHFAEHRT;
  public  String STARTSCHEMA;
  public  String EINSCHALTUHRZEIT;
  public  String EINSCHALTINTERVALL;
  public  String EINSCHALTDAUER;
  public  String SCHALTTEMPERATUR;
  public  String SCHALTRICHTUNG;
  public  String FUNKTION;
  public  String EINSCHALTEN_MIT_PC;
  public  String NACHLAUFZEIT;
  public  String SCHALTBAR_UEBER_SOFTWARE;
  public  String DAUERHAFT;
  public  String UEBERSCHREITEN;
  public  String UNTERSCHREITEN;
  public  String TIMER;
  public  String TEMPERATURSCHALTER;
  public  String WOCHENTAG;
  public  String MONTAG;
  public  String DIENSTAG;
  public  String MITTWOCH;
  public  String DONNERSTAG;
  public  String FREITAG;
  public  String SAMSTAG;
  public  String SONNTAG;
  public  String TAEGLICH;
  public  String WOECHENTLICH;
  public  String DATUM;
  public  String RELAIS_SCHALTEN;
  public  String BOOST_MODUS;
  public  String SCREENSAVER;
  public  String STANDBY;
  public  String PROFILWECHSEL;
  public  String SICHTWECHSEL;
  public  String ALLE_RELAIS_AUSSCHALTEN;
  public  String AUTO_ABSCHALTUNG;
  public  String HELLIGKEIT;
  public  String KONTRAST;
  public  String EINHEIT_SEKUNDE;
  public  String EINHEIT_MINUTE;
  public  String EINHEIT_STUNDE;
  public  String EINHEIT_TEMPERATUR;
  public  String EINHEIT_UMDREHUNG;
  public  String EINHEIT_LITER_PRO_STUNDE;
  public  String EINHEIT_GALONE_PRO_STUNDE;
  public  String EINHEIT_GALONE_PRO_STUNDE_US;
  public  String EINHEIT_GALONE_PRO_STUNDE_IMP;
  public  String EINHEIT_GRAD_CELSIUS;
  public  String EINHEIT_KELVIN;
  public  String OFFLINE_RAHMEN;
  public  String SCHWIMMSCHALTER;
  public  String ANALOGSENSOR;
  public  String OBEN;
  public  String UNTEN;
  public  String AKTION_BEI_KRITISCHEM_WASSERSTAND;
  public  String AUSRICHTUNG;
  public  String SENSOR_JETZT_KALIBRIEREN;
  public  String ALARMMARKE;
  public  String WARNMARKE;
  public  String FAKTOR;
  public  String PUMPE;
  public  String DURCHFLUSSSENSOR;
  public  String PUMPE_DURCHFLUSSSENSOR;
  public  String MINDEST_DREHZAHL;
  public  String AKTION_PUMPEN_AUSFALL;
  public  String ANZEIGE;
  public  String EINHEIT_FUER_WARNWERTE;
  public  String NOT_AUS_MARKE;
  public  String PUMPE_SENSOR1;
  public  String PUMPE_SENSOR2;
  public  String PUMPE_SENSOR3;
  public  String WIEDERHOLUNG;
  public  String UHRZEIT;
  public  String TERMIN_BEZEICHNUNG;
  public  String ABBRECHEN;
  public  String SPEICHERN;
  public  String DREHZAHL;
  public  String SPANNUNG;
  public  String TAB_LUEFTER;
  public  String TAB_ALLGEMEIN;
  public  String TAB_NTC;
  public  String TAB_WASSERSTAND;
  public  String TAB_PUMPE;
  public  String TAB_ONLINE;
  public  String TAB_OFFLINE;
  public  String TAB_DISPLAY;
  public  String TAB_VERGLEICH;
  public  String FRAGE_ALLE_STANDARD;
  public  String TITEL_ALLE_STANDARD;
  public  String FRAGE_SPEICHERN;
  public  String TITEL_SPEICHERN;
  public  String NAME;
  public  String FRAGE_HEATMASTER_2_GEFUNDEN_KONFIGURATION;
  public  String TITEL_HEATMASTER_2_GEFUNDEN_KONFIGURATION;
  public  String FRAGE_HEATMASTER_2_NICHT_GEFUNDEN;
  public  String TITEL_HEATMASTER_2_NICHT_GEFUNDEN;
  public  String HINWEIS_VERBINDUNG_UNTERBROCHEN;
  public  String TITEL_VERBINDUNG_UNTERBROCHEN;
  public  String UEBERSCHRIFT_KONFIGURATIONS_RAHMEN;
  public  String UEBERSCHRIFT_AKTUELLE_WERTE_RAHMEN;
  public  String MENU_DATEI;
  public  String MENU_DATEI_BEENDEN;
  public  String MENU_ANSICHT;
  public  String MENU_PROFIL_LADEN;
  public  String MENU_PROFIL_SPEICHERN;
  public  String MENU_PROFIL_SPEICHERN_UNTER;
  public  String MENU_HEATMASTER_2;
  public  String MENU_HEATMASTER_2_FIRMWARE_UPDATE;
  public  String MENU_HEATMASTER_2_UEBERWACHUNG;
  public  String MENU_HEATMASTER_2_OFFLINE;
  public  String MENU_KONFIGURATION;
  public  String MENU_KONFIGURATION_ALLGEMAIN;
  public  String MENU_KONFIGURATION_DISPLAY;
  public  String MENU_KONFIGURATION_LUEFTER;
  public  String MENU_KONFIGURATION_NTC;
  public  String MENU_KONFIGURATION_PUMPE;
  public  String MENU_KONFIGURATION_WASSERSTAND;
  public  String MENU_KONFIGURATION_ONLINE;
  public  String MENU_KONFIGURATION_OFFLINE;
  public  String UEBERSCHRIFT_HAUPT_RAHMEN;
  public  String UEBERWACHUNG_AKTIV;
  public  String TEMPERATUR_EINHEIT;
  public  String SPRACHE;
  public  String BESCHREIBUNG_ABSCHALT_ZEIT;
  public  String HINWEIS_LADEN_FEHLGESCHLAGEN;
  public  String TITEL_LADEN_FEHLGESCHLAGEN;
  public  String UPDATE_WAR_ERFOLGREICH;
  public  String FIRMWARE_UPDATE;
  public  String WARNUNG_HEATMASTER_2_NICHT_AUSSCHALTEN;
  public  String SCHLIESSEN;
  public  String HINWEIS_KONFIGURATION_WIRD_VOM_HM_GELADEN;
  public  String HINWEIS_KONFIGURATION_WIRD_ZUM_HM_GESENDET;
  public  String MENU_KONFIGURATION_VOM_HEATMASTER_2_LADEN;
  public  String MENU_TEMPERATUR_VERGLEICHE;
  public  String VERBINDUNG_OK;
  public  String KEINE_VERBINDUNG;
  public  String UEBERWACHUNG_INAKTIV;
  public  String HEATMASTER_2_GEFUNDEN;
  public  String KEIN_HEATMASTER_2_GEFUNDEN;
  public  String STANDBY_ZEIT;
  public  String AKTIVIERT;
  public  String PULSE_PRO_1000_ML;
  public  String WARNUNG_HAT_STUMMEN_ALARM_AUSGELOEST;
  public  String WARNUNG_HAT_DEN_WARNWERT_ERREICHT;
  public  String WARNUNG_HAT_DEN_ALARMWERT_ERREICHT;
  public  String WARNUNG_HAT_DEN_NOTAUSWERT_ERREICHT;
  public  String DATENUEBERTRAGUNG;
  public  String BITTE_AUSWAEHLEN;
  public  String AKTUELLE_WERTE;
  public  String STANDBY_BELEUCHTUNG;
  public  String BETRIEB_BELEUCHTUNG_MIT_VORSCHAU;
  public  String SLEEP_BELEUCHTUNG;
  public  String HINWEIS_ES_WURDE_FUER;
  public  String HINWEIS_KEIN_FAKTOR_EINGEGEBEN;
  public  String VERBINDUNG_HERSTELLEN;
  public  String VERBINDUNG_TRENNEN;
  public  String FRAGE_VERBINDUNG_TRENNEN;
  public  String UEBERWACHEN_AN;
  public  String UEBERWACHEN_AUS;
  public  String LIVEREGELUNG_AKTIV;
  public  String LIVEREGELUNG_AKTIV_SPEICHERN;
  public  String KEINE_DREHZAHL_FUNKTION;
  public  String LADEN;
  public  String KONFIGURATION_GELADEN;
  public  String KONFIGURATION_GESPEICHERT;
  public  String KONFIGURATION_IMPORT;
  public  String KONFIGURATION_EXPORT;
  public  String BEENDEN;
  public  String AKTUELLE_LUEFTERSPANNUNG;
  public  String FEHLER;
  public  String SERIEN_NR;
  public  String SW_VERSION;
  public  String HW_VERSION;
  public  String TAB_INFO;
  public  String[][] sprachen;
  public  String[] Sprachen;
  public BufferedReader SprachDatei;
  
  public Sprache(Daten cfg)
  {
    ladeSprache();
    sprachen = getArray();
    leseSprache(cfg.SPRACHE);
  }
  
  /*private static void readWithCsvMapReader() throws Exception {
	   		
	  		ICsvMapReader mapReader = null;
	  		try {
	   			mapReader = new CsvMapReader(new FileReader("Sprachen.csv"), CsvPreference.STANDARD_PREFERENCE);
	   			
	   			// the header columns are used as the keys to the Map
	   			final String[] header = mapReader.getHeader(true);
	  			final CellProcessor[] processors = getProcessors();
	 			
	   			Map<String, Object> customerMap;
	  			while( (customerMap = mapReader.read(header, processors)) != null ) {
	  				System.out.println(String.format("lineNo=%s, rowNo=%s, customerMap=%s", mapReader.getLineNumber(),
	 					mapReader.getRowNumber(), customerMap));
	  			}
	   			
	  		}
	   		finally {
	   			if( mapReader != null ) {
	   				mapReader.close();
	   		}
	   	}
   	}
 */
  
 
  public boolean ladeSprache()
  {
	  try
	    {


    	if (!SpracheLader.pruefeSprache()) {
            SpracheLader.ladeSprache();
    	}
        return true;
	    }
      
    	 catch (Exception e) {}
    	 return false;
  }
      
  
  public String[][] getArray()
  {
    int x = 0;
    try
    {
      String line = SprachDatei.readLine();
      
      String[] array = line.split(";");
      
      x = array.length - 2;
      
      Sprachen = new String[x];
      
      System.arraycopy(array, 2, Sprachen, 0, x);
      
      String[][] sprachen = new String[x][ANZAHL];
      for (int i = 0; i < 287; i++)
      {
        line = SprachDatei.readLine();
        array = line.split(";");
        for (int j = 0; j < x; j++) {
          try
          {
            sprachen[j][i] = array[(j + 2)];
          }
          catch (Exception ex)
          {
            sprachen[j][i] = "";
          }
        }
      }
      SprachDatei.close();
    }
    catch (Exception ex)
    {
      ladeStandard();
      
      System.gc();
      return null;
    }
    String[][] sprachen = null;
    String[] array;
    String line;
    System.gc();
    return sprachen;
  }
  
  public  void leseSprache(int Sprache)
  {
    try
    {
      int x = 0;
      SYSTEM_ZEIT = sprachen[Sprache][x];
      
      BEZEICHNUNG = sprachen[Sprache][(++x)];
      STATUS = sprachen[Sprache][(++x)];
      BELEUCHTUNG = sprachen[Sprache][(++x)];
      
      ABFRAGE_INTERVALL = sprachen[Sprache][(++x)];
      
      MAX = sprachen[Sprache][(++x)];
      MIN = sprachen[Sprache][(++x)];
      
      ERROR = sprachen[Sprache][(++x)];
      NV = sprachen[Sprache][(++x)];
      OK = sprachen[Sprache][(++x)];
      
      FERTIG = sprachen[Sprache][(++x)];
      STARTEN = sprachen[Sprache][(++x)];
      DREHZAHLEN_WURDEN_ERMITTELT = sprachen[Sprache][(++x)];
      LUEFTER_BESITZ_KEINE_DREHZAHLFUNKTION = sprachen[Sprache][(++x)];
      MINDREHZAHL_KANN_NICHT_ERMITTELT_WERDEN = sprachen[Sprache][(++x)];
      
      ERMITTLE_MAXIMALE_DREHZAHL = sprachen[Sprache][(++x)];
      ERMITTLE_MINIMALE_DREHZAHL = sprachen[Sprache][(++x)];
      HINWEIS_LUEFTER_DREHZAHL_ERKENNUNG = sprachen[Sprache][(++x)];
      TITEL_LUEFTER_DREHZAHL_ERKENNEN = sprachen[Sprache][(++x)];
      
      AN = sprachen[Sprache][(++x)];
      AUS = sprachen[Sprache][(++x)];
      
      JA = sprachen[Sprache][(++x)];
      NEIN = sprachen[Sprache][(++x)];
      
      LUEFTER = sprachen[Sprache][(++x)];
      LUEFTER1 = sprachen[Sprache][(++x)];
      LUEFTER2 = sprachen[Sprache][(++x)];
      LUEFTER3 = sprachen[Sprache][(++x)];
      LUEFTER4 = sprachen[Sprache][(++x)];
      LUEFTER5 = sprachen[Sprache][(++x)];
      LUEFTER6 = sprachen[Sprache][(++x)];
      
      SENSOR = sprachen[Sprache][(++x)];
      SENSOR1 = sprachen[Sprache][(++x)];
      SENSOR2 = sprachen[Sprache][(++x)];
      SENSOR3 = sprachen[Sprache][(++x)];
      SENSOR4 = sprachen[Sprache][(++x)];
      SENSOR5 = sprachen[Sprache][(++x)];
      SENSOR6 = sprachen[Sprache][(++x)];
      SENSOR_A = sprachen[Sprache][(++x)];
      SENSOR_B = sprachen[Sprache][(++x)];
      
      RELAIS = sprachen[Sprache][(++x)];
      RELAIS1 = sprachen[Sprache][(++x)];
      RELAIS2 = sprachen[Sprache][(++x)];
      RELAIS3 = sprachen[Sprache][(++x)];
      
      TASTER = sprachen[Sprache][(++x)];
      TASTER1 = sprachen[Sprache][(++x)];
      TASTER2 = sprachen[Sprache][(++x)];
      TASTER3 = sprachen[Sprache][(++x)];
      
      PROFIL = sprachen[Sprache][(++x)];
      PROFIL1 = sprachen[Sprache][(++x)];
      PROFIL2 = sprachen[Sprache][(++x)];
      PROFIL3 = sprachen[Sprache][(++x)];
      
      SICHT = sprachen[Sprache][(++x)];
      SICHT1 = sprachen[Sprache][(++x)];
      SICHT2 = sprachen[Sprache][(++x)];
      SICHT3 = sprachen[Sprache][(++x)];
      
      DREHZAHLFUNKTION = sprachen[Sprache][(++x)];
      LUEFTER_ABSCHALTEN_BEI_AUSFALL = sprachen[Sprache][(++x)];
      AKTION_LUEFTER_AUSFALL = sprachen[Sprache][(++x)];
      MINMAX_DREHZAHL_ERMITTELN = sprachen[Sprache][(++x)];
      TACHO_FAKTOR = sprachen[Sprache][(++x)];
      REGELUNG = sprachen[Sprache][(++x)];
      MANUELL = sprachen[Sprache][(++x)];
      AUTOMATISCH = sprachen[Sprache][(++x)];
      
      SYSTEMSTART = sprachen[Sprache][(++x)];
      JETZT = sprachen[Sprache][(++x)];
      NIE = sprachen[Sprache][(++x)];
      
      KEINE = sprachen[Sprache][(++x)];
      STUMMER_ALARM = sprachen[Sprache][(++x)];
      ALARM = sprachen[Sprache][(++x)];
      RUNTERFAHREN = sprachen[Sprache][(++x)];
      NOTABSCHALT = sprachen[Sprache][(++x)];
      KEINER = sprachen[Sprache][(++x)];
      LINEAR = sprachen[Sprache][(++x)];
      PROGRESSIV = sprachen[Sprache][(++x)];
      SOLLWERTREGELUNG = sprachen[Sprache][(++x)];
      AUTOFAN = sprachen[Sprache][(++x)];
      VOLT = sprachen[Sprache][(++x)];
      TYP = sprachen[Sprache][(++x)];
      
      SOLLTEMP = sprachen[Sprache][(++x)];
      MAXTEMP = sprachen[Sprache][(++x)];
      STARTTEMP = sprachen[Sprache][(++x)];
      STARTWERT = sprachen[Sprache][(++x)];
      
      REGELUNG_EINHEIT = sprachen[Sprache][(++x)];
      
      MAXDREHZAHL = sprachen[Sprache][(++x)];
      
      HYSTERESE = sprachen[Sprache][(++x)];
      
      AKTIV = sprachen[Sprache][(++x)];
      NICHT_VORHANDEN = sprachen[Sprache][(++x)];
      INAKTIV = sprachen[Sprache][(++x)];
      
      LUEFTERDREHZAHL = sprachen[Sprache][(++x)];
      LUEFTERSPANNUNG = sprachen[Sprache][(++x)];
      
      TOOLTIP_TACHO_FAKTOR = sprachen[Sprache][(++x)];
      
      NOT_AN = sprachen[Sprache][(++x)];
      NOT_AUS = sprachen[Sprache][(++x)];
      KORREKTUR_WERT = sprachen[Sprache][(++x)];
      NTC_TABELLE = sprachen[Sprache][(++x)];
      
      WARNUNG = sprachen[Sprache][(++x)];
      
      EINSTELLUNG_UEBERTRAGEN = sprachen[Sprache][(++x)];
      
      TEMPERATUR_WERTE = sprachen[Sprache][(++x)];
      EINSTELLUNG = sprachen[Sprache][(++x)];
      
      ANALOG = sprachen[Sprache][(++x)];
      DIGITAL = sprachen[Sprache][(++x)];
      
      STANDARD = sprachen[Sprache][(++x)];
      EIGENER = sprachen[Sprache][(++x)];
      
      FRAGE_SENSOR_DATEN_UEBERTRAGEN = sprachen[Sprache][(++x)];
      TITEL_EINSTELLUNGEN_UEBERNEHMEN = sprachen[Sprache][(++x)];
      INFO_SENSOR_DATEN_UEBERTRAGEN = sprachen[Sprache][(++x)];
      
      FRAGE_SOFWARE_BEENDEN = sprachen[Sprache][(++x)];
      TITEL_SOFWARE_BEENDEN = sprachen[Sprache][(++x)];
      
      SCHALTZEIT = sprachen[Sprache][(++x)];
      
      HEATMASTER_2_KANN_PC_STARTEN = sprachen[Sprache][(++x)];
      VERZOEGERUNG = sprachen[Sprache][(++x)];
      ZEIT = sprachen[Sprache][(++x)];
      ENDLOS = sprachen[Sprache][(++x)];
      
      BIS_ERNEUTEM_TASTENDRUCK = sprachen[Sprache][(++x)];
      BIS_RECHNER_HOCHFAEHRT = sprachen[Sprache][(++x)];
      
      STARTSCHEMA = sprachen[Sprache][(++x)];
      
      EINSCHALTUHRZEIT = sprachen[Sprache][(++x)];
      EINSCHALTINTERVALL = sprachen[Sprache][(++x)];
      EINSCHALTDAUER = sprachen[Sprache][(++x)];
      SCHALTTEMPERATUR = sprachen[Sprache][(++x)];
      SCHALTRICHTUNG = sprachen[Sprache][(++x)];
      
      FUNKTION = sprachen[Sprache][(++x)];
      EINSCHALTEN_MIT_PC = sprachen[Sprache][(++x)];
      NACHLAUFZEIT = sprachen[Sprache][(++x)];
      SCHALTBAR_UEBER_SOFTWARE = sprachen[Sprache][(++x)];
      
      DAUERHAFT = sprachen[Sprache][(++x)];
      UEBERSCHREITEN = sprachen[Sprache][(++x)];
      UNTERSCHREITEN = sprachen[Sprache][(++x)];
      
      TIMER = sprachen[Sprache][(++x)];
      TEMPERATURSCHALTER = sprachen[Sprache][(++x)];
      
      WOCHENTAG = sprachen[Sprache][(++x)];
      MONTAG = sprachen[Sprache][(++x)];
      DIENSTAG = sprachen[Sprache][(++x)];
      MITTWOCH = sprachen[Sprache][(++x)];
      DONNERSTAG = sprachen[Sprache][(++x)];
      FREITAG = sprachen[Sprache][(++x)];
      SAMSTAG = sprachen[Sprache][(++x)];
      SONNTAG = sprachen[Sprache][(++x)];
      
      TAEGLICH = sprachen[Sprache][(++x)];
      WOECHENTLICH = sprachen[Sprache][(++x)];
      DATUM = sprachen[Sprache][(++x)];
      
      RELAIS_SCHALTEN = sprachen[Sprache][(++x)];
      BOOST_MODUS = sprachen[Sprache][(++x)];
      SCREENSAVER = sprachen[Sprache][(++x)];
      STANDBY = sprachen[Sprache][(++x)];
      PROFILWECHSEL = sprachen[Sprache][(++x)];
      SICHTWECHSEL = sprachen[Sprache][(++x)];
      ALLE_RELAIS_AUSSCHALTEN = sprachen[Sprache][(++x)];
      
      AUTO_ABSCHALTUNG = sprachen[Sprache][(++x)];
      HELLIGKEIT = sprachen[Sprache][(++x)];
      KONTRAST = sprachen[Sprache][(++x)];
      
      EINHEIT_SEKUNDE = sprachen[Sprache][(++x)];
      EINHEIT_MINUTE = sprachen[Sprache][(++x)];
      EINHEIT_STUNDE = sprachen[Sprache][(++x)];
      EINHEIT_TEMPERATUR = sprachen[Sprache][(++x)];
      EINHEIT_UMDREHUNG = sprachen[Sprache][(++x)];
      EINHEIT_LITER_PRO_STUNDE = sprachen[Sprache][(++x)];
      EINHEIT_GALONE_PRO_STUNDE = sprachen[Sprache][(++x)];
      EINHEIT_GALONE_PRO_STUNDE_US = sprachen[Sprache][(++x)];
      EINHEIT_GALONE_PRO_STUNDE_IMP = sprachen[Sprache][(++x)];
      
      EINHEIT_GRAD_CELSIUS = sprachen[Sprache][(++x)];
      EINHEIT_KELVIN = sprachen[Sprache][(++x)];
      
      OFFLINE_RAHMEN = sprachen[Sprache][(++x)];
      
      SCHWIMMSCHALTER = sprachen[Sprache][(++x)];
      ANALOGSENSOR = sprachen[Sprache][(++x)];
      
      OBEN = sprachen[Sprache][(++x)];
      UNTEN = sprachen[Sprache][(++x)];
      
      AKTION_BEI_KRITISCHEM_WASSERSTAND = sprachen[Sprache][(++x)];
      
      AUSRICHTUNG = sprachen[Sprache][(++x)];
      SENSOR_JETZT_KALIBRIEREN = sprachen[Sprache][(++x)];
      ALARMMARKE = sprachen[Sprache][(++x)];
      WARNMARKE = sprachen[Sprache][(++x)];
      FAKTOR = sprachen[Sprache][(++x)];
      
      PUMPE = sprachen[Sprache][(++x)];
      DURCHFLUSSSENSOR = sprachen[Sprache][(++x)];
      
      PUMPE_DURCHFLUSSSENSOR = sprachen[Sprache][(++x)];
      
      MINDEST_DREHZAHL = sprachen[Sprache][(++x)];
      AKTION_PUMPEN_AUSFALL = sprachen[Sprache][(++x)];
      ANZEIGE = sprachen[Sprache][(++x)];
      EINHEIT_FUER_WARNWERTE = sprachen[Sprache][(++x)];
      NOT_AUS_MARKE = sprachen[Sprache][(++x)];
      PUMPE_SENSOR1 = sprachen[Sprache][(++x)];
      PUMPE_SENSOR2 = sprachen[Sprache][(++x)];
      PUMPE_SENSOR3 = sprachen[Sprache][(++x)];
      
      WIEDERHOLUNG = sprachen[Sprache][(++x)];
      UHRZEIT = sprachen[Sprache][(++x)];
      TERMIN_BEZEICHNUNG = sprachen[Sprache][(++x)];
      
      ABBRECHEN = sprachen[Sprache][(++x)];
      SPEICHERN = sprachen[Sprache][(++x)];
      
      DREHZAHL = sprachen[Sprache][(++x)];
      SPANNUNG = sprachen[Sprache][(++x)];
      
      TAB_LUEFTER = sprachen[Sprache][(++x)];
      TAB_ALLGEMEIN = sprachen[Sprache][(++x)];
      TAB_NTC = sprachen[Sprache][(++x)];
      TAB_WASSERSTAND = sprachen[Sprache][(++x)];
      TAB_PUMPE = sprachen[Sprache][(++x)];
      TAB_ONLINE = sprachen[Sprache][(++x)];
      TAB_OFFLINE = sprachen[Sprache][(++x)];
      TAB_DISPLAY = sprachen[Sprache][(++x)];
      TAB_VERGLEICH = sprachen[Sprache][(++x)];
      
      FRAGE_ALLE_STANDARD = sprachen[Sprache][(++x)];
      TITEL_ALLE_STANDARD = sprachen[Sprache][(++x)];
      
      FRAGE_SPEICHERN = sprachen[Sprache][(++x)];
      TITEL_SPEICHERN = sprachen[Sprache][(++x)];
      
      NAME = sprachen[Sprache][(++x)];
      FRAGE_HEATMASTER_2_GEFUNDEN_KONFIGURATION = sprachen[Sprache][(++x)];
      TITEL_HEATMASTER_2_GEFUNDEN_KONFIGURATION = sprachen[Sprache][(++x)];
      FRAGE_HEATMASTER_2_NICHT_GEFUNDEN = sprachen[Sprache][(++x)];
      TITEL_HEATMASTER_2_NICHT_GEFUNDEN = sprachen[Sprache][(++x)];
      HINWEIS_VERBINDUNG_UNTERBROCHEN = sprachen[Sprache][(++x)];
      TITEL_VERBINDUNG_UNTERBROCHEN = sprachen[Sprache][(++x)];
      UEBERSCHRIFT_KONFIGURATIONS_RAHMEN = sprachen[Sprache][(++x)];
      UEBERSCHRIFT_AKTUELLE_WERTE_RAHMEN = sprachen[Sprache][(++x)];
      
      MENU_DATEI = sprachen[Sprache][(++x)];
      MENU_DATEI_BEENDEN = sprachen[Sprache][(++x)];
      
      MENU_ANSICHT = sprachen[Sprache][(++x)];
      
      MENU_PROFIL_LADEN = sprachen[Sprache][(++x)];
      MENU_PROFIL_SPEICHERN = sprachen[Sprache][(++x)];
      MENU_PROFIL_SPEICHERN_UNTER = sprachen[Sprache][(++x)];
      
      MENU_HEATMASTER_2 = sprachen[Sprache][(++x)];
      MENU_HEATMASTER_2_FIRMWARE_UPDATE = sprachen[Sprache][(++x)];
      
      MENU_HEATMASTER_2_UEBERWACHUNG = sprachen[Sprache][(++x)];
      MENU_HEATMASTER_2_OFFLINE = sprachen[Sprache][(++x)];
      
      MENU_KONFIGURATION = sprachen[Sprache][(++x)];
      MENU_KONFIGURATION_ALLGEMAIN = sprachen[Sprache][(++x)];
      MENU_KONFIGURATION_DISPLAY = sprachen[Sprache][(++x)];
      
      MENU_KONFIGURATION_LUEFTER = sprachen[Sprache][(++x)];
      MENU_KONFIGURATION_NTC = sprachen[Sprache][(++x)];
      MENU_KONFIGURATION_PUMPE = sprachen[Sprache][(++x)];
      MENU_KONFIGURATION_WASSERSTAND = sprachen[Sprache][(++x)];
      
      MENU_KONFIGURATION_ONLINE = sprachen[Sprache][(++x)];
      MENU_KONFIGURATION_OFFLINE = sprachen[Sprache][(++x)];
      
      UEBERSCHRIFT_HAUPT_RAHMEN = sprachen[Sprache][(++x)];
      
      UEBERWACHUNG_AKTIV = sprachen[Sprache][(++x)];
      
      TEMPERATUR_EINHEIT = sprachen[Sprache][(++x)];
      
      SPRACHE = sprachen[Sprache][(++x)];
      
      BESCHREIBUNG_ABSCHALT_ZEIT = sprachen[Sprache][(++x)];
      
      HINWEIS_LADEN_FEHLGESCHLAGEN = sprachen[Sprache][(++x)];
      TITEL_LADEN_FEHLGESCHLAGEN = sprachen[Sprache][(++x)];
      
      UPDATE_WAR_ERFOLGREICH = sprachen[Sprache][(++x)];
      FIRMWARE_UPDATE = sprachen[Sprache][(++x)];
      WARNUNG_HEATMASTER_2_NICHT_AUSSCHALTEN = sprachen[Sprache][(++x)];
      
      SCHLIESSEN = sprachen[Sprache][(++x)];
      
      HINWEIS_KONFIGURATION_WIRD_VOM_HM_GELADEN = sprachen[Sprache][(++x)];
      HINWEIS_KONFIGURATION_WIRD_ZUM_HM_GESENDET = sprachen[Sprache][(++x)];
      MENU_KONFIGURATION_VOM_HEATMASTER_2_LADEN = sprachen[Sprache][(++x)];
      
      MENU_TEMPERATUR_VERGLEICHE = sprachen[Sprache][(++x)];
      VERBINDUNG_OK = sprachen[Sprache][(++x)];
      KEINE_VERBINDUNG = sprachen[Sprache][(++x)];
      UEBERWACHUNG_INAKTIV = sprachen[Sprache][(++x)];
      HEATMASTER_2_GEFUNDEN = sprachen[Sprache][(++x)];
      KEIN_HEATMASTER_2_GEFUNDEN = sprachen[Sprache][(++x)];
      
      STANDBY_ZEIT = sprachen[Sprache][(++x)];
      
      AKTIVIERT = sprachen[Sprache][(++x)];
      
      PULSE_PRO_1000_ML = sprachen[Sprache][(++x)];
      
      WARNUNG_HAT_STUMMEN_ALARM_AUSGELOEST = sprachen[Sprache][(++x)];
      WARNUNG_HAT_DEN_WARNWERT_ERREICHT = sprachen[Sprache][(++x)];
      WARNUNG_HAT_DEN_ALARMWERT_ERREICHT = sprachen[Sprache][(++x)];
      WARNUNG_HAT_DEN_NOTAUSWERT_ERREICHT = sprachen[Sprache][(++x)];
      
      DATENUEBERTRAGUNG = sprachen[Sprache][(++x)];
      
      BITTE_AUSWAEHLEN = sprachen[Sprache][(++x)];
      
      AKTUELLE_WERTE = sprachen[Sprache][(++x)];
      
      STANDBY_BELEUCHTUNG = sprachen[Sprache][(++x)];
      BETRIEB_BELEUCHTUNG_MIT_VORSCHAU = sprachen[Sprache][(++x)];
      SLEEP_BELEUCHTUNG = sprachen[Sprache][(++x)];
      
      HINWEIS_ES_WURDE_FUER = sprachen[Sprache][(++x)];
      HINWEIS_KEIN_FAKTOR_EINGEGEBEN = sprachen[Sprache][(++x)];
      
      VERBINDUNG_HERSTELLEN = sprachen[Sprache][(++x)];
      VERBINDUNG_TRENNEN = sprachen[Sprache][(++x)];
      FRAGE_VERBINDUNG_TRENNEN = sprachen[Sprache][(++x)];
      
      UEBERWACHEN_AN = sprachen[Sprache][(++x)];
      UEBERWACHEN_AUS = sprachen[Sprache][(++x)];
      
      LIVEREGELUNG_AKTIV = sprachen[Sprache][(++x)];
      
      KEINE_DREHZAHL_FUNKTION = sprachen[Sprache][(++x)];
      
      LADEN = sprachen[Sprache][(++x)];
      
      KONFIGURATION_GELADEN = sprachen[Sprache][(++x)];
      KONFIGURATION_GESPEICHERT = sprachen[Sprache][(++x)];
      
      KONFIGURATION_IMPORT = sprachen[Sprache][(++x)];
      KONFIGURATION_EXPORT = sprachen[Sprache][(++x)];
      
      BEENDEN = sprachen[Sprache][(++x)];
      AKTUELLE_LUEFTERSPANNUNG = sprachen[Sprache][(++x)];
      
      FEHLER = sprachen[Sprache][(++x)];
      
      LIVEREGELUNG_AKTIV_SPEICHERN = sprachen[Sprache][(++x)];
      
      SERIEN_NR = sprachen[Sprache][(++x)];
      SW_VERSION = sprachen[Sprache][(++x)];
      HW_VERSION = sprachen[Sprache][(++x)];
      
      TAB_INFO = sprachen[Sprache][(++x)];
    }
    catch (NullPointerException ex)
    {
      ladeStandard();
    }
    catch (Exception ex)
    {
      ladeStandard();
    }
  }
  
  public  void ladeStandard()
  {
    SYSTEM_ZEIT = "System-Zeit : ";
    
    BEZEICHNUNG = "Bezeichnung";
    STATUS = "Status";
    BELEUCHTUNG = "Beleuchtung";
    
    ABFRAGE_INTERVALL = "Abfrage-Intervall";
    
    MAX = "Max";
    MIN = "Min";
    
    ERROR = "Err";
    NV = "n.v.";
    OK = "OK";
    
    FERTIG = "Fertig";
    STARTEN = "Starten";
    DREHZAHLEN_WURDEN_ERMITTELT = "Drehzahlen wurden ermittelt !!!";
    LUEFTER_BESITZ_KEINE_DREHZAHLFUNKTION = 
      "Lüfter besitzt keine Drehzahlfunktion !!!";
    MINDREHZAHL_KANN_NICHT_ERMITTELT_WERDEN = 
      "Min-Drehzahl kann nicht ermittelt werden !!!";
    
    ERMITTLE_MAXIMALE_DREHZAHL = "Ermittle maximale Drehzahl";
    ERMITTLE_MINIMALE_DREHZAHL = "Ermittle minimale Drehzahl";
    HINWEIS_LUEFTER_DREHZAHL_ERKENNUNG = "Achtung der Lüfter-Test kann je nach Lüfter bis zu 5 min dauern !!! Die ermittelten Werte können von den angezeigten abweichen !!!";
    TITEL_LUEFTER_DREHZAHL_ERKENNEN = "Lüfter - Drehzahl ermitteln";
    
    AN = "On";
    AUS = "Off";
    
    JA = "Ja";
    NEIN = "Nein";
    
    LUEFTER = "Lüfter";
    LUEFTER1 = "Lüfter 1";
    LUEFTER2 = "Lüfter 2";
    LUEFTER3 = "Lüfter 3";
    LUEFTER4 = "Lüfter 4";
    LUEFTER5 = "Lüfter 5";
    LUEFTER6 = "Lüfter 6";
    
    SENSOR = "Sensor";
    SENSOR1 = "Sensor 1";
    SENSOR2 = "Sensor 2";
    SENSOR3 = "Sensor 3";
    SENSOR4 = "Sensor 4";
    SENSOR5 = "Sensor 5";
    SENSOR6 = "Sensor 6";
    SENSOR_A = "Sensor A";
    SENSOR_B = "Sensor B";
    
    RELAIS = "Relais";
    RELAIS1 = "Relais 1";
    RELAIS2 = "Relais 2";
    RELAIS3 = "Relais 3";
    
    TASTER = "Taster";
    TASTER1 = "Taster 1";
    TASTER2 = "Taster 2";
    TASTER3 = "Taster 3";
    
    PROFIL = "Profil";
    PROFIL1 = "Profil 1";
    PROFIL2 = "Profil 2";
    PROFIL3 = "Profil 3";
    
    SICHT = "Sicht";
    SICHT1 = "Sicht 1";
    SICHT2 = "Sicht 2";
    SICHT3 = "Sicht 3";
    
    DREHZAHLFUNKTION = "Drehzahlfunktion";
    LUEFTER_ABSCHALTEN_BEI_AUSFALL = 
      "Lüfter abschalten bei Ausfall";
    AKTION_LUEFTER_AUSFALL = "Aktion bei Lüfterausfall";
    MINMAX_DREHZAHL_ERMITTELN = 
      "Min / Max Drehzahl ermitteln";
    TACHO_FAKTOR = "Tacho Faktor";
    REGELUNG = "Regelung";
    MANUELL = "Manuell";
    AUTOMATISCH = "Automatisch";
    
    SYSTEMSTART = "auto- (Systemstart)";
    JETZT = "jetzt";
    NIE = "nie";
    
    KEINE = "keine";
    STUMMER_ALARM = "stummer Alarm";
    ALARM = "Alarm";
    RUNTERFAHREN = "Runterfahren";
    NOTABSCHALT = "Notabschalt";
    KEINER = "Keiner";
    LINEAR = "Linear";
    PROGRESSIV = "progressiv";
    SOLLWERTREGELUNG = "Sollwertregelung";
    AUTOFAN = "Autofan";
    VOLT = "V";
    TYP = "Typ";
    
    SOLLTEMP = "Soll-Temperatur";
    MAXTEMP = "Max-Temperatur";
    STARTTEMP = "Start - Temperatur";
    STARTWERT = "Start - Wert";
    
    REGELUNG_EINHEIT = "Regelung Einheit";
    
    MAXDREHZAHL = "Max-Drehzahl";
    
    HYSTERESE = "Abschalt - Hysterese";
    
    AKTIV = "Aktiv";
    NICHT_VORHANDEN = "nicht vorhanden";
    INAKTIV = "Inaktiv";
    
    LUEFTERDREHZAHL = "Lüfterdrehzahl";
    LUEFTERSPANNUNG = "Lüfterspannung";
    
    TOOLTIP_TACHO_FAKTOR = "Wie viele Pulse pro Umdrehung";
    
    NOT_AN = "Not-An";
    NOT_AUS = "Not-Aus";
    KORREKTUR_WERT = "Korrektur - Wert";
    NTC_TABELLE = "NTC-Tabelle";
    
    WARNUNG = "Warnung";
    
    EINSTELLUNG_UEBERTRAGEN = 
      "Einstellungen auf alle Sensoren übertragen";
    
    TEMPERATUR_WERTE = "Temperatur - Werte";
    EINSTELLUNG = "Einstellung";
    
    ANALOG = "Analog";
    DIGITAL = "Digital";
    
    STANDARD = "Standard";
    EIGENER = "Eigener";
    
    FRAGE_SENSOR_DATEN_UEBERTRAGEN = 
      "Sollen die Einstellungen auf alle Sensoren übernommen werden ?";
    TITEL_EINSTELLUNGEN_UEBERNEHMEN = 
      "Einstellungen übernehmen";
    INFO_SENSOR_DATEN_UEBERTRAGEN = 
      "Einstellungen wurden erfolgreich übernommen.";
    
    FRAGE_SOFWARE_BEENDEN = 
      "Wollen Sie die Sofware wirklich beenden ?";
    TITEL_SOFWARE_BEENDEN = "Beenden";
    
    SCHALTZEIT = "Schaltzeit";
    
    HEATMASTER_2_KANN_PC_STARTEN = "Heatmaster 2 kann PC starten";
    VERZOEGERUNG = "Verzögerung";
    
    ZEIT = "Zeit";
    ENDLOS = "endlos";
    
    BIS_ERNEUTEM_TASTENDRUCK = "bis erneuten Tastendruck";
    BIS_RECHNER_HOCHFAEHRT = "bis Rechner hochführt";
    
    STARTSCHEMA = "Start - Schema";
    
    EINSCHALTUHRZEIT = "Einschaltuhrzeit";
    EINSCHALTINTERVALL = "Einschaltintervall";
    EINSCHALTDAUER = "Einschaltdauer";
    SCHALTTEMPERATUR = "Schalttemperatur";
    SCHALTRICHTUNG = "Schaltrichtung";
    
    FUNKTION = "Funktion";
    EINSCHALTEN_MIT_PC = "Einschalten mit Pc";
    NACHLAUFZEIT = "Nachlaufzeit";
    SCHALTBAR_UEBER_SOFTWARE = "Schaltbar über Software";
    
    DAUERHAFT = "Dauerhaft";
    UEBERSCHREITEN = "Überschreiten";
    UNTERSCHREITEN = "Unterschreiten";
    
    TIMER = "Timer";
    TEMPERATURSCHALTER = "Temperaturschalter";
    
    WOCHENTAG = "Wochentag";
    MONTAG = "Montag";
    DIENSTAG = "Dienstag";
    MITTWOCH = "Mittwoch";
    DONNERSTAG = "Donnerstag";
    FREITAG = "Freitag";
    SAMSTAG = "Samstag";
    SONNTAG = "Sonntag";
    
    TAEGLICH = "täglich";
    WOECHENTLICH = "wöchentlich";
    DATUM = "Datum";
    
    RELAIS_SCHALTEN = "Relais schalten";
    BOOST_MODUS = "Boost Modus";
    SCREENSAVER = "Screensaver";
    STANDBY = "Standby";
    PROFILWECHSEL = "Profilwechsel";
    SICHTWECHSEL = "Sichtwechsel";
    ALLE_RELAIS_AUSSCHALTEN = "Alle Relais ausschalten";
    
    AUTO_ABSCHALTUNG = "Auto - Abschaltung";
    HELLIGKEIT = "Helligkeit";
    KONTRAST = "Kontrast";
    
    EINHEIT_SEKUNDE = "sec";
    EINHEIT_MINUTE = "min";
    EINHEIT_STUNDE = "Std";
    EINHEIT_TEMPERATUR = "?C";
    EINHEIT_UMDREHUNG = "RPM";
    
    EINHEIT_LITER_PRO_STUNDE = "l/h";
    EINHEIT_GALONE_PRO_STUNDE = "g/h";
    EINHEIT_GALONE_PRO_STUNDE_US = "g/h (US)";
    EINHEIT_GALONE_PRO_STUNDE_IMP = "g/h (IMP)";
    EINHEIT_GRAD_CELSIUS = "°C";
    EINHEIT_KELVIN = "K";
    
    OFFLINE_RAHMEN = "Offline Taster / Relais Einstellungen";
    
    SCHWIMMSCHALTER = "Schwimmschalter";
    ANALOGSENSOR = "Analogsensor";
    
    OBEN = "Oben";
    UNTEN = "Unten";
    
    AKTION_BEI_KRITISCHEM_WASSERSTAND = 
      "Aktion bei kritischem Wasserstand";
    
    AUSRICHTUNG = "Ausrichtung";
    SENSOR_JETZT_KALIBRIEREN = 
      "Analogsensor jetzt kalibrieren";
    ALARMMARKE = "Alarmmarke";
    WARNMARKE = "Warnmarke";
    FAKTOR = "Faktor";
    
    PUMPE = "Pumpe";
    DURCHFLUSSSENSOR = "Durchflußsensor";
    
    PUMPE_DURCHFLUSSSENSOR = "Pumpe / Durchflußsensor";
    
    MINDEST_DREHZAHL = "Mindestdrehzahl";
    AKTION_PUMPEN_AUSFALL = "Ereignis Pumpenausfall";
    ANZEIGE = "Anzeige";
    EINHEIT_FUER_WARNWERTE = "Einheit für Warnwerte";
    NOT_AUS_MARKE = "Not-Aus-Marke";
    PUMPE_SENSOR1 = "Pumpe / Sensor 1";
    PUMPE_SENSOR2 = "Pumpe / Sensor 2";
    PUMPE_SENSOR3 = "Pumpe / Sensor 3";
    
    WIEDERHOLUNG = "Wiederholung";
    UHRZEIT = "Uhrzeit";
    TERMIN_BEZEICHNUNG = "Termin - Bezeichnung";
    
    ABBRECHEN = "Abbrechen";
    SPEICHERN = "Speichern";
    
    DREHZAHL = "Drehzahl";
    SPANNUNG = "Spannung";
    
    TAB_LUEFTER = "Lüfter";
    TAB_ALLGEMEIN = "Allgemein";
    TAB_NTC = "Temperatur - Sensoren";
    TAB_WASSERSTAND = "Wasserstandkontrolle";
    TAB_PUMPE = "Pumpe / Wasserflußkontrolle";
    TAB_ONLINE = "Online Taster/Relais";
    TAB_OFFLINE = "Offline Taster/Relais";
    TAB_DISPLAY = "Display";
    TAB_VERGLEICH = "Temperatur - Vergleiche";
    
    FRAGE_ALLE_STANDARD = 
      "Soll die Komplette Konfiguration auf Standard zurückgesetzt werden ?";
    TITEL_ALLE_STANDARD = "Standard-Einstellung";
    
    FRAGE_SPEICHERN = 
      "Sollen die Änderungen gespeichert werden ?";
    TITEL_SPEICHERN = "Konfiguration speichern";
    
    NAME = "Name";
    FRAGE_HEATMASTER_2_GEFUNDEN_KONFIGURATION = "Es wurde ein Heatmaster 2 gefunden. Soll die aktuelle Konfiguration des Heatmaster 2 geladen werden ? Nein = Lokal abgelegte Konfiguration";
    TITEL_HEATMASTER_2_GEFUNDEN_KONFIGURATION = 
      "Konfiguration laden";
    FRAGE_HEATMASTER_2_NICHT_GEFUNDEN = 
      "Es wurde kein Heatmaster 2 gefunden !!!";
    TITEL_HEATMASTER_2_NICHT_GEFUNDEN = "Heatmaster 2";
    HINWEIS_VERBINDUNG_UNTERBROCHEN = 
      "Verbindung zum Heatmaster 2 unterbrochen, wechsle in Offline-Modus !!!";
    TITEL_VERBINDUNG_UNTERBROCHEN = "Verbindungs-Problem";
    UEBERSCHRIFT_KONFIGURATIONS_RAHMEN = "Konfiguration";
    UEBERSCHRIFT_AKTUELLE_WERTE_RAHMEN = "Aktuelle Werte";
    
    MENU_DATEI = "Datei";
    MENU_DATEI_BEENDEN = "Beenden";
    
    MENU_ANSICHT = "Ansicht";
    
    MENU_PROFIL_LADEN = "Profil laden";
    MENU_PROFIL_SPEICHERN = "Profil speichern";
    MENU_PROFIL_SPEICHERN_UNTER = 
      "Profil speichern unter ...";
    
    MENU_HEATMASTER_2 = "Heatmaster 2";
    MENU_HEATMASTER_2_FIRMWARE_UPDATE = "Firmware updaten";
    
    MENU_HEATMASTER_2_UEBERWACHUNG = "Überwachung Aktiv";
    MENU_HEATMASTER_2_OFFLINE = "Offline-Modus";
    
    MENU_KONFIGURATION = "Konfiguration";
    MENU_KONFIGURATION_ALLGEMAIN = "Allgemein";
    MENU_KONFIGURATION_DISPLAY = "Display";
    
    MENU_KONFIGURATION_LUEFTER = "Lüfter";
    MENU_KONFIGURATION_NTC = "NTC";
    MENU_KONFIGURATION_PUMPE = "Pumpe/Durchflußsensor";
    MENU_KONFIGURATION_WASSERSTAND = "Wasserstand";
    
    MENU_KONFIGURATION_ONLINE = "Online Relais / Taster";
    MENU_KONFIGURATION_OFFLINE = "Offline Relais / Taster";
    
    UEBERSCHRIFT_HAUPT_RAHMEN = "Heatmaster 2";
    
    UEBERWACHUNG_AKTIV = "Überwachung aktiv";
    
    TEMPERATUR_EINHEIT = "Temperatur Einheit";
    
    SPRACHE = "Sprache";
    
    BESCHREIBUNG_ABSCHALT_ZEIT = 
      "Hier wird die Zeit eingestellt, die benötigt wird um den Pc herunterzufahren";
    
    HINWEIS_LADEN_FEHLGESCHLAGEN = "Beim laden der Konfiguration ist ein Fehler aufgetreten !!! Überprüfen Sie ob der Heatmaster 2 korrekt angeschlossen ist !!!";
    TITEL_LADEN_FEHLGESCHLAGEN = "Laden Fehlgeschlagen";
    
    UPDATE_WAR_ERFOLGREICH = "Update war erfolgreich";
    FIRMWARE_UPDATE = "Firmware Update";
    
    WARNUNG_HEATMASTER_2_NICHT_AUSSCHALTEN = 
      "Achtung, Heatmaster 2 nicht ausschalten !!!";
    SCHLIESSEN = "Schließen";
    
    HINWEIS_KONFIGURATION_WIRD_VOM_HM_GELADEN = 
      "Konfiguration wird vom Heatmaster 2 geladen";
    HINWEIS_KONFIGURATION_WIRD_ZUM_HM_GESENDET = 
      "Konfiguration wird zum Heatmaster 2 gesendet";
    
    MENU_KONFIGURATION_VOM_HEATMASTER_2_LADEN = 
      "Konfiguration vom Heatmaster 2 laden";
    
    MENU_TEMPERATUR_VERGLEICHE = "Temperatur - Vergleiche";
    VERBINDUNG_OK = "Verbindung Ok";
    KEINE_VERBINDUNG = "Keine Verbindung";
    UEBERWACHUNG_INAKTIV = "Überwachung inaktiv";
    HEATMASTER_2_GEFUNDEN = "Heatmaster 2 gefunden";
    
    KEIN_HEATMASTER_2_GEFUNDEN = "Kein Heatmaster 2 gefunden";
    
    STANDBY_ZEIT = "Standby - Zeit";
    
    AKTIVIERT = "Aktiviert";
    
    PULSE_PRO_1000_ML = "Pulse pro 1000 ml";
    
    WARNUNG_HAT_STUMMEN_ALARM_AUSGELOEST = "' hat den stummen Alarm ausgelöst !!!";
    WARNUNG_HAT_DEN_WARNWERT_ERREICHT = "' hat den Warn-Wert erreicht !!!";
    WARNUNG_HAT_DEN_ALARMWERT_ERREICHT = "' hat den Alarm-Wert erreicht !!!";
    WARNUNG_HAT_DEN_NOTAUSWERT_ERREICHT = "' hat den Not-Aus-Wert erreicht !!!";
    
    DATENUEBERTRAGUNG = "Datenübertragung";
    
    BITTE_AUSWAEHLEN = "Bitte Auswählen";
    
    AKTUELLE_WERTE = "Aktuelle Werte";
    
    STANDBY_BELEUCHTUNG = "Standby - Beleuchtung";
    BETRIEB_BELEUCHTUNG_MIT_VORSCHAU = "Betrieb - Beleuchtung , mit Vorschau";
    SLEEP_BELEUCHTUNG = "Sleep - Beleuchtung";
    
    HINWEIS_ES_WURDE_FUER = "Es wurde für '";
    
    HINWEIS_KEIN_FAKTOR_EINGEGEBEN = 
      "' kein Faktor eingegeben !!! Der Faktor wird auf 1 gesetzt.";
    
    VERBINDUNG_HERSTELLEN = "Verbindung herstellen";
    VERBINDUNG_TRENNEN = "Verbindung trennen";
    FRAGE_VERBINDUNG_TRENNEN = 
      "Soll die Verbindung zum Gerät getrennt werden ?";
    
    UEBERWACHEN_AN = "Überwachen";
    UEBERWACHEN_AUS = "Nicht überwachen";
    
    LIVEREGELUNG_AKTIV = "Live-Regelung aktiv";
    KEINE_DREHZAHL_FUNKTION = "keine Drehz. Fkt.";
    
    LADEN = "Laden";
    
    KONFIGURATION_GELADEN = "Konfiguration geladen";
    KONFIGURATION_GESPEICHERT = "Konfiguration gespeichert";
    
    KONFIGURATION_IMPORT = "Konfiguration importieren";
    KONFIGURATION_EXPORT = "Konfiguration exportieren";
    
    BEENDEN = "Beenden";
    
    AKTUELLE_LUEFTERSPANNUNG = "Aktuelle Spannung";
    
    FEHLER = "Es ist ein Fehler aufgetreten !";
    
    LIVEREGELUNG_AKTIV_SPEICHERN = "Live-Regelung aktiv (bitte erst speichern)";
    
    SERIEN_NR = "SNr. :";
    SW_VERSION = "SW-Version :";
    HW_VERSION = "HW-Version :";
    
    TAB_INFO = "Info";
  }
  
  public void SpracheAendern(int sprache, MainFrame m)
  {
    SprachThread sT = new SprachThread(sprache, m);
  }
  
  public class SprachThread
    implements Runnable
  {
    public Thread t;
    public int x = 0;
    public MainFrame mFrame;
    
    public SprachThread(int sprache, MainFrame m)
    {
      mFrame = m;
      x = sprache;
      t = new Thread(this);
      t.start();
    }
    
    public void run()
    {
      leseSprache(x);
      mFrame.setzeSprache();
      mFrame.konfPanel.SpracheAendern();
    }
  }
}
