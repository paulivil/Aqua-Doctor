package de.Rollmann.kommunikation;

import de.Rollmann.kommunikation.Runnable.Abstrakt.EmpfangRunnable;
import de.Rollmann.kommunikation.Runnable.Abstrakt.SendeRunnable;
import de.Rollmann.kommunikation.Runnable.Abstrakt.StandardRunnable;
import de.Rollmann.kommunikation.Runnable.ComSeriell.SuchRunnableCom;
import de.Rollmann.kommunikation.Runnable.Ethernet.EmpfangRunnableEnet;
import de.Rollmann.kommunikation.Runnable.Ethernet.SendeRunnableEnet;
import de.Rollmann.kommunikation.Runnable.MasterRunnable;
import de.Rollmann.kommunikation.Seriell;
import de.Rollmann.tools.TreiberInstaller;


import java.util.ArrayList;

public class SteuerKlasse
{
  private int Baudrate;
  private int DatenBits;
  private int StopBits;
  private int Paritaet;
  private int Flußkontrolle;
  

  private ArrayList<StandardRunnable> Ports = new ArrayList<StandardRunnable>();
  private ArrayList<SuchRunnableCom> suchThread = new ArrayList<SuchRunnableCom>();
  private MasterRunnable mt;
  private SuchRunnableCom suchCom;
  private boolean gefunden = false;
  private static String OS = System.getProperty("os.name").toLowerCase();
  public static boolean isWindows() {
		return (OS.indexOf("win") >= 0);
}
  public static boolean isMac() {
		return (OS.indexOf("mac") >= 0);
	}

	public static boolean isUnix() {
		return (OS.indexOf("nix") >= 0 || OS.indexOf("nux") >= 0 || OS.indexOf("aix") > 0 );
}
	public static String getOS(){
		if (isWindows()) {
			return "win";
		} else if (isMac()) {
			return "osx";
		} else if (isUnix()) {
			return "uni";
		
		} else {
			return "err";
		}
}
  public SteuerKlasse()
  {
	 
	  
	 
    
    try
    {
      if (isWindows())
      {
        if (!TreiberInstaller.pruefeTreiberWinpurejavacomm()) {
          TreiberInstaller.installpurejavacommWin();
        }
            
          
      }
        	    else if (isUnix())
        	    {
        	    	if (!TreiberInstaller.pruefeTreiberLinuxpurejavacomm()) {
        	        TreiberInstaller.installpurejavacommLinux();
        	      }
  }
        	    else if (isMac())
        	    {
        	    	if (!TreiberInstaller.pruefeTreiberMacOSpurejavacomm()) {
        	        TreiberInstaller.installpurejavacommMacOS();
        	      }
  }   
    }     
    catch (Exception e) {}
    
    }
  
 
 
  public MasterRunnable sucheGeraetEnet()
  {
    ThreadGroup tg = new ThreadGroup("Ethernet");
    
    EmpfangRunnableEnet er = new EmpfangRunnableEnet(tg);
    
    SendeRunnableEnet sr = new SendeRunnableEnet(tg);
    
    MasterRunnable mt = new MasterRunnable(er, sr, tg);
    er.setControllRunnable(mt);
    sr.setControllRunnable(mt);
    return mt;
  }
  
  public MasterRunnable sucheGeraetSeriell(int baud, int dbits, int pari, int sbits, int fluß)
  {
    Baudrate = baud;
    DatenBits = dbits;
    Paritaet = pari;
    StopBits = sbits;
    Flußkontrolle = fluß;
   
    Seriell.setzeSettings(Baudrate, DatenBits, Paritaet, StopBits, 
      Flußkontrolle);
    
    new ThreadGroup("Suchen");
    
    String[] Comports = Seriell.getComports();
    for (int i = 0; i < Comports.length; i++) {}
    while (!suchThread.isEmpty()) {}
    return mt;
  }
  
  public MasterRunnable sucheGeraetSeriell(REComSeriell.ComThread com)
  {
    Seriell.setzeSettings(9600, 8, 0, 1, 0);
    
    new ThreadGroup("Suchen");
    
    String[] Comports = Seriell.getComports();
    
    int i = 0;
    while (i < Comports.length)
    {
      while (!suchCom.beendet) {}
      i++;
    }
    if (gefunden) {
      erstelleMasterThreadCom();
    }
    return mt;
  }
  
  public void gefunden(EmpfangRunnable e, SendeRunnable s)
  {
    Ports.add(e);
    Ports.add(s);
    gefunden = true;
  }
  
  public void meldeEnde(SuchRunnableCom src)
  {
    for (int i = 0; i < suchThread.size(); i++) {
      if (((SuchRunnableCom)suchThread.get(i)).equals(src))
      {
        suchThread.remove(i);
        suchThread.trimToSize();
        break;
      }
    }
  }
  
  private void erstelleMasterThreadCom()
  {
    ThreadGroup tg = new ThreadGroup("");
    Ports.trimToSize();
    for (int i = 0; i < Ports.size(); i += 2) {
      mt = new MasterRunnable(
        (EmpfangRunnable)Ports.get(i), (SendeRunnable)Ports.get(i + 1), tg);
    }
  }
}
