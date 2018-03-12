package de.Rollmann.tools;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.nio.file.Paths;

public class TreiberInstaller
{
  private static String PathToJava = System.getProperty("java.home");
  
  public static boolean pruefeTreiberMacOSpurejavacomm()
  {
	  File f = Paths.get(PathToJava + "\\lib\\ext\\purejavacomm.jar").toFile();
    if (f.exists()) {
      return true;
    }
    return false;
  }
  
  public static boolean pruefeTreiberLinuxpurejavacomm()
  {
	  File f = Paths.get(PathToJava + "\\lib\\ext\\purejavacomm.jar").toFile();
    if (f.exists()) {
      return true;
    }
    return false;
  }
  
  public static boolean pruefeTreiberWinpurejavacomm()
  {
	  File f = Paths.get(PathToJava + "\\lib\\ext\\purejavacomm.jar").toFile();
    if (f.exists()) {
      return true;
    }
    return false;
  }
  
 
  
  public static boolean installpurejavacommMacOS()
  {
    URL commJarURL = ClassLoader.getSystemResource(
      "lib/ext/purejavacomm.jar");
    try
    {
      InputStream in = commJarURL.openStream();
      FileOutputStream out = new FileOutputStream(PathToJava + 
        "/Library/Java/Extensions");
      int len =  0;
      byte[] buf = new byte[4096];
      while ((len = in.read(buf)) > 0)
      {
       out.write(buf, 0, len);
      }
      out.close();
      in.close();
           
      return true;
    }
    catch (IOException ex) {}
    return false;
  }
  public static boolean installpurejavacommLinux()
  {
    URL commJarURL = ClassLoader.getSystemResource(
      "lib/ext/purejavacomm.jar");
    try
    {
      InputStream in = commJarURL.openStream();
      FileOutputStream out = new FileOutputStream(PathToJava + 
        "/lib/ext/purejavacomm.jar");
      int len =  0;
      byte[] buf = new byte[4096];
      while ((len = in.read(buf)) > 0)
      {
       out.write(buf, 0, len);
      }
      out.close();
      in.close();
           
      return true;
    }
    catch (IOException ex) {}
    return false;
  }
  
 
  
  public static boolean installpurejavacommWin()
  {
    URL commJarURL = ClassLoader.getSystemResource("lib/ext/purejavacomm.jar");
    try
    {
      InputStream in = commJarURL.openStream();
      FileOutputStream out = new FileOutputStream(PathToJava + 
        "\\lib\\ext\\purejavacomm.jar");
           int len =  0;
      byte[] buf = new byte[4096];
      
      while ((len = in.read(buf)) > 0)
      {
        out.write(buf, 0, len);
      }
      out.close();
      in.close();
  
     
      return true;
      
    }
    catch (IOException ex) {}
    return false;
  }
  
  
  
  public static boolean installTray()
  {
    try
    {
      FileInputStream in = new FileInputStream("lib\\jdic_stub.jar");
      FileOutputStream out = new FileOutputStream(PathToJava + 
        "\\lib\\jdic_stub.jar");
      int len =  0;
      byte[] buf = new byte[4096];
      while ((len = in.read(buf)) > 0)
      {
       out.write(buf, 0, len);
      }
      out.close();
      in.close();
      
      in = new FileInputStream("lib\\jdic.jar");
      out = new FileOutputStream(PathToJava + "\\lib\\jdic.jar");
      buf = new byte[4096];
      while ((len = in.read(buf)) > 0) {
        out.write(buf, 0, len);
      }
      out.close();
      in.close();
      
      in = new FileInputStream("runnable\\tray.dll");
      out = new FileOutputStream(PathToJava + "\\bin\\tray.dll");
      buf = new byte[4096];
      while ((len = in.read(buf)) > 0) {
        out.write(buf, 0, len);
      }
      out.close();
      in.close();
      
      in = new FileInputStream("runnable\\jdic.dll");
      out = new FileOutputStream(PathToJava + "\\bin\\jdic.dll");
      buf = new byte[4096];
      while ((len = in.read(buf)) > 0) {
        out.write(buf, 0, len);
      }
      out.close();
      in.close();
      return true;
    }
    catch (IOException ex) {}
    return false;
  }
}
