package de.Rollmann.kommunikation;

import de.Rollmann.kommunikation.ComTabellen.ComTabelle;
import de.Rollmann.kommunikation.Runnable.MasterRunnable;
import de.Rollmann.komponenten.RE_ComFrame;
import de.Rollmann.tools.BridgeInstaller;
import java.awt.Cursor;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;
import javax.swing.JOptionPane;

public class REComBridge
{
  private MasterRunnable master;
  private SteuerKlasse steuer;
  private Process p;
  private ComTabelle tabcom;
  private Socket s;
  boolean steuerConnected = false;
  boolean gefunden = false;
  private Cursor cur;
  private RE_ComFrame mFrame;
  
  public boolean pruefeBridge()
  {
    try
    {
      if (!BridgeInstaller.pruefeBridge()) {
        BridgeInstaller.installBridge();
      }
      return true;
    }
    catch (Exception ex) {}
    return false;
  }
  
  public boolean stoppeBridge(RE_ComFrame frame)
  {
    return true;
  }
  
  public boolean starteBridge(RE_ComFrame frame)
  {
    mFrame = frame;
    
    ComThread c = new ComThread();
    return true;
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
    public synchronized void melde()
    {
      notify();
    }
  //synchronized
    public void run()
    {
      REComBridge.SteuerThread st = null;
      
      cur = new Cursor(3);
      
      mFrame.setCursor(cur);
      
      File f = new File(".");
      try
      {
        String[] play = {
          "cmd", "/c", "start", 
          "RE_Com_Bridge.exe" };
        
        ProcessBuilder pc = new ProcessBuilder(play);
        
        pc.directory(f);
        
        p = pc.start();
        
        st = new SteuerThread(this);
        
        wait(10000);
        st.ende = true;
      }
      catch (IOException e) {}catch (InterruptedException e) {}
      if (gefunden) {
        try
        {
          steuer = new SteuerKlasse();
          
          master = steuer.sucheGeraetEnet();
          try
          {
            tabcom = mFrame.erstelleComTabelle(master);
          }
          catch (Exception e) {}
          wait(1000);
        }
        catch (Exception e)
        {
          Process pp;
          try
          {
            pp = Runtime.getRuntime().exec(
              "cmd /c taskkill /F /IM RE_Com_Bridge.exe");
          }
          catch (IOException e1) {}
          JOptionPane.showMessageDialog(mFrame, 
            "Kein " + mFrame.geraet + " gefunden");
        }
      } else {
        try
        {
          st.ende = true;
          st.t.interrupt();
          Process pp;
          try
          {
            pp = Runtime.getRuntime().exec(
              "cmd /c taskkill /F /IM RE_Com_Bridge.exe");
          }
          catch (IOException e) {}
          JOptionPane.showMessageDialog(mFrame, 
            "Kein " + mFrame.geraet + " gefunden");
        }
        catch (Exception e) {}
      }
      mFrame.setCursor(null);
      try
      {
        wait(1000);
      }
      catch (InterruptedException e) {}
      mFrame.erstesLaden();
    }
  }
  
 class SteuerThread
    implements Runnable
  {
    Thread t;
    OutputStream out;
    InputStream in;
    Socket s;
    boolean ende = false;
    REComBridge.ComThread c;
    
    public SteuerThread(REComBridge.ComThread com)
    {
      c = com;
      Thread t = new Thread(this);
      t.start();
    }
  //synchronized
    public synchronized void run()
    {
      for (int i = 0; i < 10; i++)
      {
        try
        {
          s = new Socket(InetAddress.getLocalHost().getHostAddress(), 
            61000);
          out = s.getOutputStream();
          in = s.getInputStream();
          
          steuerConnected = true;
        }
        catch (UnknownHostException e) {}catch (IOException e) {}
        try
        {
          wait(1000);
        }
        catch (InterruptedException e) {}
      }
      int x = 0;
      while (!ende)
      {
        try
        {
          out.write(99);
        }
        catch (Exception e) {}
        try
        {
          while (in.available() > 0)
          {
            x = in.read();
            wait(10);
          }
        }
        catch (IOException e) {}catch (InterruptedException e) {}
        if (x == 99)
        {
          gefunden = true;
          ende = true;
        }
      }
      try
      {
        s.close();
      }
      catch (Exception e) {}
      try
      {
        in.close();
      }
      catch (Exception e) {}
      try
      {
        out.close();
      }
      catch (Exception e) {}
      c.melde();
    }
  }
}
