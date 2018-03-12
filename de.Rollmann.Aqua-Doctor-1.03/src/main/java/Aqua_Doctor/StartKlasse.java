package Aqua_Doctor;

import Aqua_Doctor.GUI.MainFrame;
import Aqua_Doctor.ressource.Daten;
import Aqua_Doctor.ressource.Sprache;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.PrintWriter;
import java.io.StringWriter;

import javax.swing.UIManager;


public class StartKlasse

	   
{
	

  public Daten cfg;
  public MainFrame mFrame;
  public Sprache spr;
  public boolean Aqua_DoctorKonfig = false;
  
  public StartKlasse()
  {
    try
    {
      UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
    }
    catch (Exception e) {}
    cfg = new Daten();
    cfg.ladeLokalStandard();
    
    spr = new Sprache(this.cfg);
    
    mFrame = new MainFrame(cfg, spr);
  }
  
  public static void main(String[] args) throws Exception
  {
	  Thread.currentThread().setUncaughtExceptionHandler(new Thread.UncaughtExceptionHandler() { 
          public void uncaughtException(Thread t, Throwable e) { 
              StringWriter sw = new StringWriter();
              e.printStackTrace(new PrintWriter(sw));
              String stacktrace = sw.toString();
              System.out.println(stacktrace);
          }
	  });
    StartKlasse startKlasse = new StartKlasse();
    
  }
  
  public void ladeProfil()
  {
    try
    {
      FileInputStream disk = new FileInputStream("Profil.dat");
      ObjectInputStream oi = new ObjectInputStream(disk);
      cfg = ((Daten)oi.readObject());
      oi.close();
    }
    catch (ClassNotFoundException e)
    {
      cfg = new Daten();
      cfg.ladeLokalStandard();
    }
    catch (FileNotFoundException e)
    {
      cfg = new Daten();
      cfg.ladeLokalStandard();
    }
    catch (IOException e)
    {
      cfg = new Daten();
      cfg.ladeLokalStandard();
    }
  }
  
  public void ladeInit()
  {
    
    try
    {
      FileInputStream disk = new FileInputStream("Aqua_Doctor.dat");
      ObjectInputStream oi= new ObjectInputStream(disk);
      oi.close();
    }
    catch (Exception e) {}
  }
}
