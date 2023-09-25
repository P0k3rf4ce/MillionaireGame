

import java.awt.Color;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.BevelBorder;
import javax.swing.border.Border;

/**
 * Class for questions panel (left panel)
 */
public class QuestionPanel extends JPanel {

 private static final long serialVersionUID = 4774726882155271344L;
 
 private JLabel question;
 private JLabel hint;
 
 public QuestionPanel() {
  setBackground(Color.BLACK);
  Border border = BorderFactory.createBevelBorder(BevelBorder.LOWERED);
  setBorder(border);
  
  setLayout(new GridBagLayout());
  GridBagConstraints gc = new GridBagConstraints();
  gc.gridy = 0;
  question = new JLabel("Question");
  question.setFont(new Font("Times New Roman", Font.BOLD, 25));
  question.setForeground(Color.WHITE);
  add(question, gc);
  
  gc.gridy = 1;
  hint = new JLabel("Hint");
  hint.setFont(new Font("Times New Roman", Font.BOLD, 25));
  hint.setForeground(Color.WHITE);
  add(hint, gc);
 }
 
 public void displayQuestion(String q) {
  question.setText(q);
 }
 
 public void displayHint(String h) {
  hint.setText(h);
 }
}
