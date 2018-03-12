package Aqua_Doctor.GUI;

import java.io.File;
import Aqua_Doctor.GUI.SuffixAwareFilter;

public class HexFilter
  extends SuffixAwareFilter
{
  public boolean accept(File f)
  {
    boolean accept = super.accept(f);
    if (!accept)
    {
      String suffix = getSuffix(f);
      if (suffix != null) {
        accept = (super.accept(f)) || (suffix.equals("dat"));
      }
    }
    return accept;
  }
  
  public String getDescription()
  {
    return "Aqua-Doctor-Files(*.dat)";
  }
}

