/*
 * src\MainFrame.java
 */



import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 * Puts all the smaller components together in one window
 */
public class MainFrame extends JFrame{

 private static final long serialVersionUID = 2269971701250845501L;
 
 private CardLayout cl;
 
 private JPanel cards;
 private MainMenu menu;
 private Game game;
 private EndScreen end;
 
 /**
  * MainFrame constructor. Acts as a main method would (handles all the processes)
  * pre: None
  * post: Functional game
  */
 public MainFrame() {

  cards = new JPanel(new CardLayout());
  menu = new MainMenu();
  game = new Game(); 
  
  
  cards.add(menu, "Menu");
  cards.add(game, "Game");
  
  
  cl = (CardLayout) cards.getLayout();
  cl.show(cards, "Menu");

  menu.startButton.addActionListener(new ActionListener() {
   
   @Override
   public void actionPerformed(ActionEvent e) {
    cl.show(cards, "Game");
    
   }
  });
  
  game.choicePanel.quitButton.addActionListener(new ActionListener() {
   @Override
   public void actionPerformed(ActionEvent e) {
    end = new EndScreen(game.getEndMessage());
    
    cards.add(end, "End");
    cl.show(cards, "End");
   }
  });

  //setLayout(cl);
  add(cards, BorderLayout.CENTER);
  setTitle("Who Wants To Be A Millionaire?");
  setSize(new Dimension(1280, 720));
  setDefaultCloseOperation(EXIT_ON_CLOSE);
  setVisible(true);
 }
 
}
