

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Point;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JButton;
import javax.swing.JPanel;

/**
 * Class for the actual game frame
 */
public class MainMenu extends JPanel{

 private static final long serialVersionUID = -3088890058631223710L;
 
 private final String backgroundPath = "src/background.jpg";
 private BufferedImage background;
 
 public JButton startButton;

 public MainMenu() {
  
  setBackground(backgroundPath);
  
  setLayout(null);
  
  startButton = new JButton("Start");
  startButton.setSize(new Dimension(100, 50));
  startButton.setLocation(new Point(580, 400));
  startButton.setVisible(true);
  
  this.add(startButton);
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
   bg = bg.getScaledInstance(1380, 690, BufferedImage.SCALE_DEFAULT);
   background = new BufferedImage(bg.getWidth(null), bg.getHeight(null), BufferedImage.TYPE_INT_ARGB);

      Graphics2D bGr = background.createGraphics();
      bGr.drawImage(bg, 0, 0, null);
      bGr.dispose();

   background = background.getSubimage(50, 0, 1280, 690);
  } catch(IOException e) {
   System.out.println("Picture \"" + backgroundPath + "\" not found");
  }
 }
 
}
