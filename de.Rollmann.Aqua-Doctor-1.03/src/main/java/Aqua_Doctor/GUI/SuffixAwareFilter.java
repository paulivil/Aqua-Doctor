package Aqua_Doctor.GUI;

import java.io.File;
import javax.swing.filechooser.FileFilter;

public class SuffixAwareFilter
  extends FileFilter
{
  public boolean accept(File f)
  {
    return f.isDirectory();
  }
  
  public String getSuffix(File f)
  {
    String s = f.getPath();String suffix = null;
    int i = s.lastIndexOf('.');
    if ((i > 0) && (i < s.length() - 1)) {
      suffix = s.substring(i + 1).toLowerCase();
    }
    return suffix;
  }
  
  public String getDescription()
  {
    return "";
  }
}

