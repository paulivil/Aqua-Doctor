package Aqua_Doctor;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JInternalFrame;
import javax.swing.JPanel;

public class SoftschalterPanel
  extends JInternalFrame
  implements ActionListener
{
  private static final long serialVersionUID = 1L;
public JButton butTaster1 = new JButton();
  public JButton butTaster2 = new JButton();
  public JButton butTaster3 = new JButton();
  public JButton butRelais1 = new JButton();
  public JButton butRelais2 = new JButton();
  public JButton butRelais3 = new JButton();
  public JPanel pnlTaster = new JPanel();
  public JPanel pnlRelais = new JPanel();
  public FlowLayout flowLayout1 = new FlowLayout();
  
  public SoftschalterPanel()
  {
    try
    {
      jbInit();
    }
    catch (Exception e) {}
  }
  
  public void actionPerformed(ActionEvent e)
  {
    JButton button = (JButton)e.getSource();
    switch (Integer.parseInt(button.getActionCommand()))
    {
    case 1: 
      break;
    case 2: 
      break;
    }
  }
  
  public void jbInit()
    throws Exception
  {
    butTaster1.setText("jButton1");
    butTaster2.setText("jButton1");
    butTaster3.setText("jButton1");
    
    butRelais1.setText("jButton1");
    butRelais2.setText("jButton2");
    butRelais3.setText("jButton3");
    
    pnlTaster.add(butTaster1);
    pnlTaster.add(butTaster2);
    pnlTaster.add(butTaster3);
    
    pnlRelais.add(butRelais1);
    pnlRelais.add(butRelais2);
    pnlRelais.add(butRelais3);
    
    getContentPane().add(pnlTaster, "North");
    getContentPane().add(pnlRelais, "South");
    
    setVisible(true);
    
    setSize(new Dimension(586, 130));
  }
}