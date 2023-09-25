
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 * Class for end screen Frame
 */
public class EndScreen extends JPanel{

 private static final long serialVersionUID = 2255287256683847667L;
 
 private final String backgroundPath = "src/blue-gradient.png";
 private BufferedImage background;
 
 private JLabel message;
 
 private JButton quit;
 
 public EndScreen(String endMessage) {
  setBackground(backgroundPath);
  
  message = new JLabel(endMessage);
  message.setFont(new Font("Times New Roman", Font.BOLD, 25));
  message.setForeground(Color.BLACK);
  
  quit = new JButton("Quit");
  
  setLayout(new GridBagLayout());
  GridBagConstraints gc = new GridBagConstraints();
  gc.gridy = 0;
  add(message, gc);
  
  gc.gridy = 1;
  add(new JLabel(" "), gc);
  
  gc.gridy = 2;
  add(new JLabel(" "), gc);
  
  gc.gridy = 3;
  add(quit, gc);
  
  quit.addActionListener(new ActionListener() {
   @Override
   public void actionPerformed(ActionEvent arg0) {
    System.exit(0);
   }
  });
 }
 
 @Override
 protected void paintComponent(Graphics g) {
  super.paintComponent(g);
  g.drawImage(background, 0, 0, this);
 }
 
 private void setBackground(String path) {
  try {
   Image bg;
   bg = ImageIO.read(new File(backgroundPath));
   bg = bg.getScaledInstance(1280, 720, BufferedImage.SCALE_DEFAULT);
   background = new BufferedImage(bg.getWidth(null), bg.getHeight(null), BufferedImage.TYPE_INT_ARGB);

      Graphics2D bGr = background.createGraphics();
      bGr.drawImage(bg, 0, 0, null);
      bGr.dispose();

   //background = background.getSubimage(50, 0, 1280, 690);
  } catch(IOException e) {
   System.out.println("Picture \"" + backgroundPath + "\" not found");
  }
 }
}
