

import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.border.BevelBorder;
import javax.swing.border.Border;

/**
 * Class for choice panel (bottom panel)
 */
public class ChoicePanel extends JPanel {

 private static final long serialVersionUID = -3626516817014274543L;
 
 public JButton button1;
 public JButton button2;
 public JButton button3;
 public JButton button4;
 
 public JButton friendButton;
 public JButton audienceButton;
 public JButton button5050;
 public JButton quitButton;

 public ChoicePanel() {
  setBackground(new Color(136, 136, 136));
  setLayout(new GridBagLayout());
  GridBagConstraints gc = new GridBagConstraints();
  Border border = BorderFactory.createBevelBorder(BevelBorder.LOWERED);
  
  setBorder(border);
  
  button1 = new JButton();
  button2 = new JButton();
  button3 = new JButton();
  button4 = new JButton();
  
  friendButton = new JButton("CALL A FRIEND");
  audienceButton = new JButton("ASK THE AUDIENCE");
  button5050 = new JButton("50/50");
  quitButton = new JButton("Quit");
  
  ////////////////////// ROW 1 //////////////////////
  gc.gridy = 0;
  gc.weightx = 4;
  gc.weighty = 1;
  gc.fill = GridBagConstraints.NONE;
  
  
  gc.gridx = 0;
  gc.anchor = GridBagConstraints.CENTER;
  add(friendButton, gc);
  
  gc.gridx = 1;
  gc.anchor = GridBagConstraints.CENTER;
  add(audienceButton, gc);
  
  gc.gridx = 2;
  gc.anchor = GridBagConstraints.CENTER;
  add(button5050, gc);
  
  gc.gridx = 3;
  gc.anchor = GridBagConstraints.CENTER;
  add(quitButton, gc);
  
  ////////////////////// ROW 2 //////////////////////
  gc.gridy++;
  gc.weightx = 3;
  gc.weighty = 1;
  
  gc.gridx = 0;
  gc.anchor = GridBagConstraints.CENTER;
  add(button1, gc);
  
  gc.gridx = 1;
  gc.anchor = GridBagConstraints.CENTER;
  add(button2, gc);
  
  gc.gridx = 2;
  gc.anchor = GridBagConstraints.CENTER;
  add(button3, gc);
  
  gc.gridx = 3;
  gc.anchor = GridBagConstraints.CENTER;
  add(button4, gc);
  
  
  
  
 }
 
 public void setButtonText(String[] choices) {
  button1.setText("1. " + choices[0]);
  button2.setText("2. " + choices[1]);
  button3.setText("3. " + choices[2]);
  button4.setText("4. " + choices[3]);
 }
 
}
