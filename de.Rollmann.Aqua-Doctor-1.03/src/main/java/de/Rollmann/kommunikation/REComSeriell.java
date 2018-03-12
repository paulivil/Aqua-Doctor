package de.Rollmann.kommunikation;

import Aqua_Doctor.ressource.Sprache;
import de.Rollmann.kommunikation.ComTabellen.ComTabelle;
import de.Rollmann.kommunikation.Runnable.Abstrakt.EmpfangRunnable;
import de.Rollmann.kommunikation.Runnable.Abstrakt.SendeRunnable;
import de.Rollmann.kommunikation.Runnable.Abstrakt.StandardRunnable;
import de.Rollmann.kommunikation.Runnable.ComSeriell.SuchRunnableCom;
import de.Rollmann.kommunikation.Runnable.MasterRunnable;
import de.Rollmann.komponenten.RE_ComFrame;
import java.awt.Cursor;
import java.util.ArrayList;
import java.util.Arrays;

import purejavacomm.NoSuchPortException;
import purejavacomm.PortInUseException;
import purejavacomm.SerialPort;
import purejavacomm.UnsupportedCommOperationException;

import javax.swing.JOptionPane;

public class REComSeriell
{
  private MasterRunnable master;
  private SuchRunnableCom suchCom;
  private ComTabelle tabcom;
  boolean gefunden = false;
  private Cursor cur;
  private RE_ComFrame mFrame;
  //private ArrayList<StandardRunnable> Ports = new ArrayList<StandardRunnable>(2);
  private ArrayList<StandardRunnable> Ports = new ArrayList<StandardRunnable>();
  SerialPort sPort;
  Sprache spr;
  private REComSeriell ComRE = this;
  
  
  public REComSeriell(Sprache s)
  {
    spr = s;
  }
  
  public boolean stoppeSeriell(RE_ComFrame frame)
  {
    try
    {
      sPort.getOutputStream().close();
    }
    catch (Exception e) {}
    try
    {
      sPort.getInputStream().close();
    }
    catch (Exception e) {}
    try
    {
      master.beenden();
    }
    catch (Exception e) {}
    master = null;
    
    return true;
  }
  
  public boolean starteSeriell(RE_ComFrame frame)
  {
	  mFrame = frame;
	    ComThread c = new ComThread();
	    return true;
	  }
	  
	  public void sucheGeraetSeriell()
	  {
	    Seriell.setzeSettings(9600, 8, 0, 1, 
	      0);
	    
	    ThreadGroup tg = new ThreadGroup("Suchen");
	    
	    String[] Comports = Seriell.getComports();
	    for (int i = 0; i < Comports.length; i++)
	    {
	    	
	    
	      boolean fehler = false;
	      try
	      {
	        sPort = Seriell.getComPort(Comports[i]);
	        sPort.setInputBufferSize(0);
	        sPort.setOutputBufferSize(0);
	        suchCom = new SuchRunnableCom(sPort, this);
	      }
	      catch (PortInUseException e)
	      {
	        fehler = true;
	      }
	      catch (UnsupportedCommOperationException e)
	      {
	        fehler = true;
	      }
	      catch (NoSuchPortException e)
	      {
	        fehler = true;
	      }
	      while ((!suchCom.beendet) && (!fehler)) { }
	    }
	    if (gefunden) {
	      erstelleMasterThreadCom();
	    }
	  }
   
  
  public void gefunden(EmpfangRunnable e, SendeRunnable s)
  {
    Ports.add(e);
    Ports.add(s);
    gefunden = true;
  }
  
  public void meldeEnde(SuchRunnableCom src) {}
  
  private void erstelleMasterThreadCom()
  {
    ThreadGroup tg = new ThreadGroup("");
    Ports.trimToSize();
    for (int i = 0; i < Ports.size(); i += 2) {
      master = new MasterRunnable(
        (EmpfangRunnable)Ports.get(i), (SendeRunnable)Ports.get(i + 1), tg);
    }
  }
  
  class ComThread
    implements Runnable
  {
    public ComThread()
    {
      Thread t = new Thread(this);
      t.start();
     
    }
    //synchronized
    public  void ComGefunden(boolean bol, SerialPort port)
    {
    	gefunden = bol;
      notify();
    }
    
    @SuppressWarnings("null")
  //synchronized
	public  void run()
    {
    	REComBridge.SteuerThread st = null;    
      cur = new Cursor(3);
      
      mFrame.setCursor(cur);
      try
      { 
    	  sucheGeraetSeriell();
        if (gefunden)
        {
          try
          {
        	  tabcom = mFrame.erstelleComTabelle(master);
            wait(1000);
          }
          catch (Exception ex)
          {
            JOptionPane.showMessageDialog(mFrame, 
             spr.KEIN_HEATMASTER_2_GEFUNDEN);
          }
        }
        else
        {
          JOptionPane.showMessageDialog(mFrame, 
        		  spr.KEIN_HEATMASTER_2_GEFUNDEN);
          try
          {
        	 
        	 st.ende=true;
        	
            st.t.interrupt();
          }
          catch (Exception e) {}
        }
        mFrame.setCursor(null);
        try
        {
          wait(1000);
        }
        catch (InterruptedException e) {}
        if (gefunden) {
        	mFrame.erstesLaden();
        }
      }
      catch (Exception ex5)
      {
        JOptionPane.showMessageDialog(mFrame, 
          "Keine " + mFrame.geraet + " gefunden");
      }
    }
  }
}
