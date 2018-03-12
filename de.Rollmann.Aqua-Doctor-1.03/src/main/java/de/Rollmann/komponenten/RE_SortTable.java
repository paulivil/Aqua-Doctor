package de.Rollmann.komponenten;

import de.Rollmann.tools.Datum;
import de.Rollmann.tools.SortArray;
import java.awt.Color;
import java.awt.Component;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.Date;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.border.Border;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableColumnModel;
/**
 * <p>Überschrift: RE_Tools</p>
 *
 * <p>Beschreibung: Tabelle mit Sortierfunktion auf jeder Spalte</p>
 *
 * <p>Copyright: Copyright (c) 2007</p>
 *
 * <p>Organisation: Rollmann Elektronik</p>
 *
 * @author Manuel Krispin
 * @version 1.0
 */
public class RE_SortTable
  extends JTable
{
  private static final long serialVersionUID = 1L;
  // Konstanten:
  public static final int BEVORZUGTEBREITE = 0;
  public static final int MINBREITE = 1;
  public static final int MAXBREITE = 2;
  Object[][] tableArray;
  ArrayList<Integer> tableCollection = new ArrayList<Integer>();
  /* Enth�lt den Bezug zwischen Tabellenzeile und tableArray,
  bei einer Filterung der Daten entspricht die Zeilennummer in der Tabelle
  nicht mehr zwangsl�ufig der Position im tableArray */
  DefaultTableModel tableModel = new DefaultTableModel();
  int sortSpalte = -1;
  boolean sortAufsteigend = false;
//--------------------------------------------------------------------------
  /* Konstruktor: */
  public RE_SortTable()
  {
    super(1, 1);
  }
  
  public RE_SortTable(Object[][] arrObj, String[] arrSpalten, int[][] arrBreite)
  {
    tableArray = arrObj;
    
    setRowHeight(19);
    for (int i = 0; i < arrSpalten.length; i++) {
      tableModel.addColumn(arrSpalten[i]);
    }
    setDefaultRenderer(Object.class, new SortTableCellRenderer(null));
    try
    {
      this.fuelleTabelle();
    }
    catch (Exception e) {}
    setModel(tableModel);
    setPreferredColumnWidth(arrBreite);
    SortTableHeaderRenderer headerRenderer = new SortTableHeaderRenderer(null);
    for (int i = 0; i < arrSpalten.length; i++) {
    	this.getColumn(arrSpalten[i]).setHeaderRenderer(headerRenderer);
    }
    sortSpalte = -1;
    sortAufsteigend = false;
 // Listener, um auf Klick auf Spaltenkopf (f�r Sortierung) zu reagieren:
    this.getTableHeader().addMouseListener(new MouseAdapter()
    {
      public void mouseClicked(MouseEvent e)
      {
        tabellenHeaderAktion(e);
      }
    });
    this.getTableHeader().setToolTipText(
      "Sortieren auf Mausklick");
  }
//Methode zur Aktualisierung der Datenmatrix:
  public void setTableArray(Object[][] arrObject)
  {
    tableArray = arrObject;
    SortArray.sort(tableArray, sortSpalte, sortAufsteigend);
    try
    {
      fuelleTabelle();
    }
    catch (Exception e) {}
  }
//--------------------------------------------------------------------------
//Tabelle f�llen:
  private void fuelleTabelle()
    throws Exception
  {
	// Erstmal Tabelle leeren:
    int anzahl = tableModel.getRowCount();
    for (int i = anzahl - 1; i >= 0; i--) {
      tableModel.removeRow(i);
    }
 // Leeren des tableVectors. Er soll immer den Bezug zwischen table
    // und tableArray sicherstellen. */
    tableCollection.clear();
 // Neue Werte reinf�llen:
    for (int i = 0; i < tableArray.length; i++)
    {
    	tableCollection.add(i);
      tableModel.addRow(tableArray[i]);
    }
  }
//--------------------------------------------------------------------------
  // Setzen der Spaltenbreite:
  private void setPreferredColumnWidth(int[][] arrBreite)
  {
    TableColumnModel tcModel = getColumnModel();
    for (int i = 1; i < tableModel.getColumnCount(); i++)
    {
      tcModel.getColumn(i).setPreferredWidth(arrBreite[i][0]);
      tcModel.getColumn(i).setMinWidth(arrBreite[i][1]);
      tcModel.getColumn(i).setMaxWidth(arrBreite[i][2]);
    }
  }
//--------------------------------------------------------------------------
  // Festlegen, dass die Zellen nicht editierbar sind:
  public boolean isCellEditable(int row, int column)
  {
    return true;
  }
 
 
  public void sortiereTabelle(boolean aufsteigend)
    throws Exception
  {
    TableColumnModel columnModel = this.getColumnModel();
    
    tableModel = ((DefaultTableModel)getModel());

    int column = 1;
    
    ArrayList<Object> v = new ArrayList<Object>();
    ArrayList<Object> v2 = new  ArrayList<Object>();
    for (int i = 0; i < tableModel.getRowCount(); i++)
    {
    	ArrayList<Object> vec = (ArrayList<Object>) tableModel.getDataVector().get(i);
      try
      {
        if ((vec.get(1) != "") && (vec.get(1) != null)) {
          v.add(vec);
        } else {
          v2.add(vec);
        }
      }
      catch (Exception e)
      {
        vec.set(1, "");
        v2.add(vec);
      }
    }
    v.trimToSize();
    
    tableArray = new Object[tableModel.getRowCount()][tableModel.getColumnCount()];
    for (int i = 0; i < v.size(); i++) {
      tableArray[i] = ( (ArrayList<Integer>) v.get(i)).toArray();
    }
    SortArray.sort(tableArray, column, aufsteigend);
    sortSpalte = column;
    for (int i = v.size(); i < tableModel.getRowCount(); i++) {
      tableArray[i] = ((ArrayList<Integer>) v2.get(i - v.size())).toArray();
    }
    if (column == sortSpalte) {
      sortAufsteigend = (!sortAufsteigend);
    } else {
      sortAufsteigend = true;
    }
    try
    {
      fuelleTabelle();
    }
    catch (Exception e) {}
  }
//--------------------------------------------------------------------------
  /* Reaktion auf das Doppelklicken eines Spaltenkopfes (f�r Umsortierung): */
  public void tabellenHeaderAktion(MouseEvent e)
  {
    if (e.getClickCount() == 1)
    {
      TableColumnModel columnModel = this.getColumnModel();
      int viewColumn = columnModel.getColumnIndexAtX(e.getX());
      int column = convertColumnIndexToModel(viewColumn);
      if (column != -1)
    	//  int shiftPressed = e.getModifiers() & InputEvent.SHIFT_MASK;
    	//  boolean ascending = (shiftPressed == 0);  
      {
        tableModel = ((DefaultTableModel)getModel());
        
        tableArray = new Object[
          tableModel.getRowCount()][tableModel.getColumnCount()];
        for (int i = 0; i < tableModel.getRowCount(); i++)
        {
        	ArrayList<?> vec = (ArrayList<?>)tableModel.getDataVector().get(i);
          
          tableArray[i] = vec.toArray();
        }
        if (column == sortSpalte) {
          sortAufsteigend = (!sortAufsteigend);
        } else {
          sortAufsteigend = true;
        }
        SortArray.sort(tableArray, column, sortAufsteigend);
        sortSpalte = column;
        try
        {
          fuelleTabelle();
        }
        catch (Exception e1) {}
      }
    }
  }
//===========================================================================
//Innere Klasse als TableCellRenderer:
//===========================================================================
  private class SortTableCellRenderer
    implements TableCellRenderer
  {
    private SortTableCellRenderer(Object object) {}
    
    public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column)
    {
      JLabel label = new JLabel();
      label.setOpaque(true);
      Border b = BorderFactory.createEmptyBorder(1, 1, 1, 1);
      
      label.setBorder(b);
      label.setFont(table.getFont());
      label.setForeground(table.getForeground());
      label.setBackground(table.getBackground());
      if (isSelected) {
    	// Andere Hintergrundfarbe f�r die selektierte Zeile:
        label.setBackground(Color.yellow);
      } else {
        label.setBackground(Color.white);
      }
      // Aufbereitungen entsprechend den Objekttypen w�re hier m�glich, zun�chst nicht implementiert:
      try
      {
        label.setText((String)value);
      }
      catch (Exception ex)
      {
        if (value.getClass().equals(new Date().getClass()))
        {
          Date d = (Date)value;
          label.setText(Datum.format(d, 2, -1));
        }
        else if (value.getClass().equals(new ImageIcon().getClass()))
        {
          ImageIcon icon = (ImageIcon)value;
          label.setIcon(icon);
          label.setText("");
          label.setIconTextGap(10);
          label.setHorizontalTextPosition(0);
        }
      }
      return label;
    }
  }
//Ende der inneren Klasse f�r CellRenderer.
//===========================================================================

//===========================================================================
//Innere Klasse als TableHeaderRenderer:
//===========================================================================
  private class SortTableHeaderRenderer
    implements TableCellRenderer
  {
    private SortTableHeaderRenderer(Object object) {}
    
    public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column)
    {
      JLabel label = new JLabel();
      label.setOpaque(true);
      Border b = BorderFactory.createEtchedBorder();
      label.setBorder(b);
      label.setFont(table.getFont());
      label.setForeground(table.getTableHeader().getForeground());
      label.setBackground(table.getTableHeader().getBackground());
      label.setText((String)value);
      if (column == sortSpalte) {
        if (sortAufsteigend) {
          label.setIcon(new ImageIcon(
            "drawable/PfeilUp16x16.gif"));
        } else {
          label.setIcon(new ImageIcon(
            "drawable/PfeilDwn16x16.gif"));
        }
      }
      return label;
    }
  }
//Ende der inneren Klasse BlueTableHeaderRenderer.
//===========================================================================
}
