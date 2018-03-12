package de.Rollmann.komponenten;

import java.awt.Component;
import javax.swing.AbstractCellEditor;
import javax.swing.JCheckBox;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellEditor;
import javax.swing.table.TableColumn;
import javax.swing.table.TableColumnModel;

/**
 * <p>Überschrift: RE_Tools</p>
 *
 * <p>Beschreibung: Verschieden Tools</p>
 *
 * <p>Copyright: Copyright (c) 2007</p>
 *
 * <p>Organisation: Rollmann Elektronik</p>
 *
 * @author Manuel Krispin
 * @version 1.0
 */

public class RE_CheckTable
  extends JTable
{
  /**
	 * 
	 */
	private static final long serialVersionUID = 8993702550962948031L;
public static final int BEVORZUGTEBREITE = 0;
  public static final int MINBREITE = 1;
  public static final int MAXBREITE = 2;
  Object[] tableArray;
//Enth�lt die Datenmatrix

  /* Enth�lt den Bezug zwischen Tabellenzeile und tableArray,
   bei einer Filterung der Daten entspricht die Zeilennummer in der Tabelle
   nicht mehr zwangsl�ufig der Position im tableArray */
  MyTableModel tableModel = new MyTableModel();
  int sortSpalte = -1;
  boolean sortAufsteigend = false;
  
  public RE_CheckTable()
  {
    setRowHeight(19);
    
    tableModel.addColumn("Datei");
    tableModel.addColumn("Auswahl");
    
    this.setModel(tableModel);
//  this.setDefaultRenderer(Object.class, new SortTableCellRenderer());
    //      this.setDefaultEditor(Object.class, new MyTableCellEditor());
    TableColumnModel columnModel = getColumnModel();
    TableColumn moonColumn = columnModel.getColumn(1);
//  moonColumn.setCellEditor(new DefaultCellEditor(new JCheckBox()));
    try
    {
      fuelleTabelle();
    }
    catch (Exception e) {}
    //   setPreferredColumnWidth(arrBreite);


    //    for (int i = 0; i < arrSpalten.length; i++)
    //         this.getColumn(arrSpalten[i]).setHeaderRenderer(headerRenderer);
    sortSpalte = -1;
    sortAufsteigend = false;
    
    getTableHeader().setToolTipText(
      "Sortieren auf Mausklick");
  }
//Methode zur Aktualisierung der Datenmatrix:
  public void setTableArray(Object[] arrObject, int[][] arrBreite)
  {
    tableArray = arrObject;
//  SortArray.sort(tableArray, sortSpalte, sortAufsteigend);
    try
    {
      fuelleTabelle();
      setPreferredColumnWidth(arrBreite);
    }
    catch (Exception e) {}
  }
  //--------------------------------------------------------------------------
  // Tabelle f�llen:
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
    tableModel.addRow(tableArray);
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
    return false;
  }
//===========================================================================
//Innere Klasse als TableModel:
//===========================================================================

  private class MyTableModel
    extends DefaultTableModel
  {
    /**
	 * 
	 */
	private static final long serialVersionUID = -1786871883778381939L;

	public MyTableModel() {}
    
    public void addRow(Object[] obj)
    {
      for (int i = 0; i < obj.length; i++) {
        super.addRow(new String[] { (String)obj[i], "" });
      }
    }
    
    public Class getColumnClass(int columnIndex)
    {
      if (columnIndex == 1) {
        return Boolean.class;
      }
      if (columnIndex == 0) {
        return String.class;
      }
      return String.class;
    }
  }
  
  private class MyTableCellEditor
    extends AbstractCellEditor
    implements TableCellEditor
  {
    private MyTableCellEditor() {}
    
    public Object getCellEditorValue()
    {
      return null;
    }
    
    public Component getTableCellEditorComponent(JTable table, Object value, boolean isSelected, int row, int column)
    {
      if (column == 1)
      {
        JCheckBox chkbox = new JCheckBox();
        chkbox.setEnabled(true);
        return chkbox;
      }
      return null;
    }
  }
}
