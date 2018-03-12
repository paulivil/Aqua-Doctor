package Aqua_Doctor.ressource;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.io.InputStreamReader;
import javax.swing.JOptionPane;

public class SpracheLader {
	public static  BufferedReader SprachDatei;
	public static File res = new File("Aqua-Doctor_lib");
	 public static  boolean pruefeSprache()
	  {
	   
	    if (!res.isDirectory()) {
	      res.mkdir();
	    }
	    File f = new File(res.getAbsolutePath() + "\\sprachen.csv");
	    
	    if (f.exists()) {
	      return true;
	    }
	    return false;
	  }

	 public static boolean ladeSprache()
	  {
	    
	    
	  String Datei = "\\sprachen.csv";
	  
	       try
	    {
	      InputStream is = new FileInputStream(Datei);
	     SprachDatei = new BufferedReader(new InputStreamReader(is));
	     
	    }
	       catch (FileNotFoundException e) {
	     JOptionPane.showMessageDialog(null, "Keine Sprach-Datei gefunden !!!", 
	    	        "Fehler", 
	    	        0);
	    	      
	    	      return false;
	    	    }
	    	    return true;
	    	  }
}
