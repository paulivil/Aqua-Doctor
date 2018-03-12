package de.Rollmann.filter;

import java.io.File;
import javax.swing.filechooser.FileFilter;
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
public class SuffixAwareFilter
  extends FileFilter
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
    return f.isDirectory();
  }
  /**
   * The description of this filter.
   *
   * @return String
   * @todo Diese javax.swing.filechooser.FileFilter-Methode implementieren
   */
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