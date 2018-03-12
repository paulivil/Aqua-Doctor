package de.Rollmann.filter;

import java.io.File;
/**
 * <p>Überschrift: BMP-Konverter</p>
 *
 * <p>Beschreibung: Konvertier BMP Bilder fuer HeatMaster</p>
 *
 * <p>Copyright: Copyright (c) 2005</p>
 *
 * <p>Organisation: Rollmann Elektronik</p>
 *
 * @author Manuel Krispin
 * @version 1.0
 */
public class SdcFilter
  extends SuffixAwareFilter
{
	
	 /**
     * Whether the given file is accepted by this filter.
     *
     * @param f File
     * @return boolean
     * @todo Diese javax.swing.filechooser.FileFilter-Methode implementieren
     */
  public boolean accept(File f)
  {
    boolean accept = super.accept(f);
    if (!accept)
    {
      String suffix = getSuffix(f);
      if (suffix != null) {
        accept = (super.accept(f)) || (suffix.equals("sdc"));
      }
    }
    return accept;
  }
  /**
   * The description of this filter.
   *
   * @return String
   * @todo Diese javax.swing.filechooser.FileFilter-Methode implementieren
   */
  public String getDescription()
  {
    return "Sdc-Files(*.sdc) HeatMaster-Profile ";
  }
}