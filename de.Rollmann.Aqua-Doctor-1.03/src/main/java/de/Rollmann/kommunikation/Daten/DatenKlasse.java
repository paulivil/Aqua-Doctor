package de.Rollmann.kommunikation.Daten;

import de.Rollmann.kommunikation.ComTabellen.ComTabelle;
import java.io.Serializable;

public abstract class DatenKlasse
  implements Serializable
{
  /**
	 * 
	 */
	private static final long serialVersionUID = -5717916517217300425L;

public abstract void laden(ComTabelle comtab)
    throws Exception;
  
  public abstract void speichern(ComTabelle comtab)
    throws Exception;
  
  public abstract void importKonfiguration(DatenKlasse data)
    throws Exception;
}
