package de.Rollmann.tools;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;

public class BridgeInstaller
{
	public static File res = new File("Aqua-Doctor_lib");
	
  public static boolean pruefeBridge()
  {
   
    if (!res.isDirectory()) {
    	res.mkdir(); 
    }
    if (res.isDirectory()) {
    	String[] resContents = res.list(); 
    	for (int i = 0; i < resContents.length; i++) {
    		System.out.println(resContents[i]);
    	}
    }
    File f = new File(res.getAbsolutePath() + "\\RE_Com_Bridge.exe");
    System.out.println(res.getAbsolutePath());
    if (f.exists()) {
      return true;
    }
    return false;
  }
  
  public static boolean installBridge()
  {
    
    
    URL bridgeURL = ClassLoader.getSystemResource("runnable/bridge/RE_Com_Bridge.exe");
       try
    {
      InputStream in = bridgeURL.openStream();
      FileOutputStream out = new FileOutputStream(res.getAbsolutePath() + "\\RE_Com_Bridge.exe");
      byte[] buf = new byte[4096];
      int len;
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
}
