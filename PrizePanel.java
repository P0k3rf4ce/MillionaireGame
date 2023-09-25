

import java.awt.Color;
import java.awt.Font;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.BevelBorder;
import javax.swing.border.Border;

/**
 * Class for choice panel (right panel)
 */
public class PrizePanel extends JPanel {

 private static final long serialVersionUID = -2370870480849386420L;
 
 private String[] rewards = {"$1,000,000", "$500,000", "$250,000", "$125,000", "$64,000", "$32,000", "$16,000", "$8,000", "$4,000", "$2,000", "$1,000", "$500", "$300", "$200", "$100"};
 private JLabel[] prizes;
 
 public PrizePanel() {
  setBackground(Color.BLUE);
  Border border = BorderFactory.createBevelBorder(BevelBorder.LOWERED);
  setBorder(border);
  
  setLayout(new BoxLayout(this, BoxLayout.PAGE_AXIS));
  
  prizes = new JLabel[rewards.length];
  
  for(int i = 0; i < rewards.length; i++) {
   if (rewards.length - i >= 10) {
    prizes[i] = new JLabel((rewards.length - i) + "    " + rewards[i]);
   } else {
    prizes[i] = new JLabel("  " + (rewards.length - i) + "    " + rewards[i]);
   }
   prizes[i].setFont(new Font("Times New Roman", Font.BOLD, 25));
   if (i % 5 == 0) {
    prizes[i].setForeground(Color.WHITE);
   } else {
    prizes[i].setForeground(Color.ORANGE);
   }
   prizes[i].setBackground(new Color(255, 100, 0));
   add(prizes[i]);
  }
  
 }
 
 public String[] getRewards() {
  return rewards;
 }
 
 public void highlightPrize(int i) {
  prizes[i].setOpaque(true);
  prizes[i].setForeground(Color.BLACK);
 }
 
 public void unhighlightPrize(int i) {
  prizes[i].setOpaque(false);
  if (i % 5 == 0) {
   prizes[i].setForeground(Color.WHITE);
  } else {
   prizes[i].setForeground(Color.ORANGE);
  }
 }

}
