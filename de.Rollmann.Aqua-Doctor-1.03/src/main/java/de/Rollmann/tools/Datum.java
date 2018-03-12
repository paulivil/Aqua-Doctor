package de.Rollmann.tools;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

public class Datum
  extends Date
{
  /**
	 * 
	 */
	private static final long serialVersionUID = -5961495438298532990L;

public String format(int DatumLaenge, int UhrzeitLaenge)
  {
    return format(this, DatumLaenge, UhrzeitLaenge);
  }
  
  public static String format(Date d, int datumLaenge, int uhrzeitLaenge)
  {
    DateFormat dateFormat = null;
    Locale locale = Locale.getDefault();
    if (((datumLaenge >= 0 ? 1 : 0) & (uhrzeitLaenge >= 0 ? 1 : 0)) != 0) {
      dateFormat = DateFormat.getDateTimeInstance(datumLaenge, 
        uhrzeitLaenge, locale);
    } else if (((datumLaenge < 0 ? 1 : 0) & (uhrzeitLaenge >= 0 ? 1 : 0)) != 0) {
      dateFormat = DateFormat.getTimeInstance(uhrzeitLaenge, locale);
    } else if (((datumLaenge >= 0 ? 1 : 0) & (uhrzeitLaenge < 0 ? 1 : 0)) != 0) {
      dateFormat = DateFormat.getDateInstance(datumLaenge, locale);
    }
    return dateFormat.format(d);
  }
}
