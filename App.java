/*
 * src\App.java
 * A game based on Who Wants to be a Millionaire TV show
 * Tymofiy Sompura
 * ICS 3U1
 * 24 March 2021
 */



import javax.swing.SwingUtilities;

/**
 * Class that runs the MainFrame using SwingUtilities invokeLater(Runnable r) method to avoid unexpected errors
 */
public class App {
 public static void main(String[] args) {
  SwingUtilities.invokeLater(new Runnable() {
   @Override
   public void run() {
    new MainFrame();
   }
  });
 }
}
