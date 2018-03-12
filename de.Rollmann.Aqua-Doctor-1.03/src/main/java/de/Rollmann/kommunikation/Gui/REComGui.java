package de.Rollmann.kommunikation.Gui;

import java.awt.Rectangle;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

public class REComGui
  extends JFrame
{
  /**
	 * 
	 */
	private static final long serialVersionUID = 4655138964663201812L;
public REComGui()
  {
    try
    {
      jbInit();
    }
    catch (Exception e) {}
  }
  
  private void jbInit()
    throws Exception
  {
    jLabel1.setText("jLabel1");
    pnlHaupt.setLayout(null);
    butSuchen.setBounds(new Rectangle(23, 20, 187, 31));
    butSuchen.setText("Geräte suchen");
    scrGeraete.setBounds(new Rectangle(23, 79, 246, 354));
    scrEigenschaften.setBounds(new Rectangle(356, 79, 212, 352));
    getContentPane().add(scrHaupt, "Center");
    scrHaupt.getViewport().add(pnlHaupt);
    pnlHaupt.add(scrGeraete);
    scrGeraete.getViewport().add(jList1);
    pnlHaupt.add(butSuchen);
    pnlHaupt.add(scrEigenschaften);
    scrEigenschaften.getViewport().add(jList2);
  }
  
  JScrollPane scrHaupt = new JScrollPane();
  JLabel jLabel1 = new JLabel();
  JPanel pnlHaupt = new JPanel();
  JButton butSuchen = new JButton();
  JScrollPane scrGeraete = new JScrollPane();
  JScrollPane scrEigenschaften = new JScrollPane();
  JList<?> jList1 = new JList<Object>();
  JList<?> jList2 = new JList<Object>();
}
