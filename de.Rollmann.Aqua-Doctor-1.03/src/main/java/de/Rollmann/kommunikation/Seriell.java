package de.Rollmann.kommunikation;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Enumeration;

import purejavacomm.CommPortIdentifier;
import purejavacomm.NoSuchPortException;
import purejavacomm.PortInUseException;
import purejavacomm.SerialPort;
import purejavacomm.UnsupportedCommOperationException;



public class Seriell 
{
	
	
	
	
	private static int[] settings;
	  
	  public static void setzeSettings(int Baudrate, int DatenBits,int Paritaet, int StopBits, int Flußkontrolle)
	  {
	    settings = new int[5];
	    settings[0] = Baudrate;
	    settings[1] = DatenBits;
	    settings[2] = StopBits;
	    settings[3] = Paritaet;
	    settings[4] = Flußkontrolle;
	  }
  
    
  
  
  

	public static SerialPort getComPort(int[] settings,String CommPort) throws   NoSuchPortException, PortInUseException, UnsupportedCommOperationException
	{
		
		CommPortIdentifier ComportId = null;
		ComportId = CommPortIdentifier.getPortIdentifier(CommPort);
			  
		SerialPort serialPort = (SerialPort) ComportId.open("ReCom" , 2000);
		serialPort.notifyOnDataAvailable(true);
		serialPort.setSerialPortParams(settings[0], settings[1], settings[2],settings[3]);
		serialPort.setFlowControlMode(settings[4]);
		
		return serialPort; 
	}
	
	public static SerialPort getComPort(String CommPort)
		    throws NoSuchPortException, PortInUseException, UnsupportedCommOperationException
		  {
		    CommPortIdentifier ComportId = null;
		  
		    ComportId = CommPortIdentifier.getPortIdentifier(CommPort);
		    SerialPort serialPort = (SerialPort) ComportId.open("ReCom", 2000);			  
		    serialPort.notifyOnDataAvailable(true);
		    serialPort.setSerialPortParams(settings[0], settings[1], settings[2], 
		      settings[3]);
		    serialPort.setFlowControlMode(settings[4]);
		    
		    return serialPort;
		  }
	public static String[] getComports()
	  {
	    
		ArrayList<String> al = new ArrayList<String>();
	    Enumeration<?> portList = CommPortIdentifier.getPortIdentifiers();
	    while (portList.hasMoreElements())
	    {
	      CommPortIdentifier portId = (CommPortIdentifier)portList.nextElement();
	      if (portId.getPortType() == 1) {
	        try
	        {
	          al.add(portId.getName());
	        }
	        catch (Exception e) {}
	      }
	    }
	    al.trimToSize();
	    
	    String[] str = new String[al.size()];
	    
	    al.toArray(str);
	    
	    return str;
	    
	  
	  
	  }
	
   
  
 
  
  public static InputStream getInputStream(SerialPort serialPort)
    throws IOException
  {
    InputStream inputStream = null;
    
    inputStream = serialPort.getInputStream();
    
    return inputStream;
  }
  
  public static OutputStream getOutputStream(SerialPort serialPort)
    throws IOException
  {
    OutputStream outputStream = serialPort.getOutputStream();
    return outputStream;
  }


  




}