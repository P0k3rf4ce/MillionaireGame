

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

import javax.swing.JPanel;

/**
 * Class for the actual game frame
 */
public class Game extends JPanel {

 private static final long serialVersionUID = -8395759457708163217L;

 private String questionsPath = "src/questions.txt";
 private String multChoicePath = "src/multipleChoiceOptions.txt";

 private String[] questions;
 private String[][] multChoice;
 private String[] randomChoices;
 private String[] rewards;

 private boolean[] chosen;
 private boolean lost;

 private final Random r = new Random();

 private PrizePanel prizePanel;
 public ChoicePanel choicePanel;
 private QuestionPanel questionPanel;

 private int answerIndex = 0;
 private int userAnswer;
 private int level;
 

 public Game() {
  questions = ReadTextFiles.readQues(questionsPath);
  multChoice = ReadTextFiles.readChoiceOptions(multChoicePath);

  chosen = new boolean[30];

  resetChosenArray();

  prizePanel = new PrizePanel();
  prizePanel.setPreferredSize(new Dimension(320, 480));

  choicePanel = new ChoicePanel();
  choicePanel.setPreferredSize(new Dimension(1280, 240));

  questionPanel = new QuestionPanel();
  questionPanel.setPreferredSize(new Dimension(960, 480));

  level = 1;
  rewards = prizePanel.getRewards();
  nextQuestion();

  setLayout(new BorderLayout());
  add(choicePanel, BorderLayout.SOUTH);

  add(prizePanel, BorderLayout.EAST);
  add(questionPanel, BorderLayout.WEST);

  choicePanel.friendButton.addActionListener(new ActionListener() {
   @Override
   public void actionPerformed(ActionEvent e) {
    choicePanel.friendButton.setEnabled(false);
    questionPanel.displayHint("It's option " + (callFriend(answerIndex) + 1) + "!");
   }
  });

  choicePanel.audienceButton.addActionListener(new ActionListener() {
   @Override
   public void actionPerformed(ActionEvent e) {
    choicePanel.audienceButton.setEnabled(false);
    questionPanel.displayHint("It's option " + (askAudience(answerIndex) + 1) + "!");
   }
  });

  choicePanel.button5050.addActionListener(new ActionListener() {
   @Override
   public void actionPerformed(ActionEvent e) {
    choicePanel.button5050.setEnabled(false);
    int[] array5050 = lifeLine5050(answerIndex);
    questionPanel.displayHint("\"" + randomChoices[array5050[0]] + "\"" + " OR " + "\"" + randomChoices[array5050[1]] + "\"");
   }
  });

  

  choicePanel.button1.addActionListener(new ActionListener() {
   @Override
   public void actionPerformed(ActionEvent e) {
    userAnswer = 0;
    checkAnswer(answerIndex, userAnswer);
   }
  });

  choicePanel.button2.addActionListener(new ActionListener() {
   @Override
   public void actionPerformed(ActionEvent e) {
    userAnswer = 1;
    checkAnswer(answerIndex, userAnswer);
   }
  });

  choicePanel.button3.addActionListener(new ActionListener() {
   @Override
   public void actionPerformed(ActionEvent e) {
    userAnswer = 2;
    checkAnswer(answerIndex, userAnswer);
   }
  });

  choicePanel.button4.addActionListener(new ActionListener() {
   @Override
   public void actionPerformed(ActionEvent e) {
    userAnswer = 3;
    checkAnswer(answerIndex, userAnswer);
   }
  });
 }

 private void nextQuestion() {
  if (level <= 15){
   // choicePanel.resetButtons();
   int i;
   do {
    i = r.nextInt(30);
   } while (chosen[i]);
   chosen[i] = true;
 
   String answer = multChoice[i][0];
 
   randomChoices = randomizeAnswerChoices(multChoice[i]);
 
   for (int j = 0; j < 4; j++) {
    if (randomChoices[j].equals(answer)) {
     answerIndex = j;
     break;
    }
   }
   questionPanel.displayQuestion(questions[i]);
   questionPanel.displayHint("");
   choicePanel.setButtonText(randomChoices);
 
   prizePanel.highlightPrize(15 - level);
  } else {
   choicePanel.quitButton.doClick();
  }
 }
 
 public String getEndMessage() {
  String result = "";
  if (lost) {
   if ((15 - level)/5 == 2) {
    result = "Unfortunately, you have not won anything.";
   } else {
    result = "Wrong! However, you still won " + rewards[15 - (level - 1)/5 * 5];
   }
  } else {
   if (15-level == 14) {
    result = "Unfortunately, you have not won anything.";
   } else {
    result = "Congrats! You have won " + rewards[15 - level + 1]; 
   }
  }
  return result;
 }

 private void checkAnswer(int answerIndex, int userAnswer) {
  if (userAnswer == answerIndex) {
   prizePanel.unhighlightPrize(15 - level);
   level++;
   nextQuestion();
  } else {
   lost = true;
   choicePanel.quitButton.doClick();
  }
 }

 private String[] randomizeAnswerChoices(String[] choices) {
  String[] result = new String[4];
  int index;
  boolean[] used = { false, false, false, false };
  for (int i = 0; i < 4; i++) {
   do {
    index = r.nextInt(4);
   } while (used[index]);

   used[index] = true;
   result[i] = choices[index];
  }
  return result;
 }

 private void resetChosenArray() {
  for (int i = 0; i < chosen.length; i++) {
   chosen[i] = false;
  }
 }

 /*
  * Returns hint for call a friend life line based on the correct answer with 75%
  * accuracy pre: int answerIndex, between 0 and 3 inclusive post: a random int
  * that 75% of the time is equal to answerIndex, otherwise off by 1
  */
 public static int callFriend(int answerIndex) {
  double random = Math.random();

  if (random < 0.25) {
   if (answerIndex == 0) {
    return answerIndex + 1;
   } else {
    return answerIndex - 1;
   }
  } else {
   return answerIndex;
  }
 }

 /*
  * Returns hint for ask audience life line based on the correct answer with 75%
  * accuracy pre: int answerIndex, between 0 and 3 inclusive post: a random int
  * that 75% of the time is equal to answerIndex, otherwise off by 1
  */
 public static int askAudience(int answerIndex) {
  double random = Math.random();

  if (random < 0.25) {
   if (answerIndex == 3) {
    return answerIndex - 1;
   } else {
    return answerIndex + 1;
   }
  } else {
   return answerIndex;
  }
 }

 /*
  * Returns hints for 50/50 life line based on the correct answer pre: int
  * answerIndex, between 0 and 3 inclusive post: an int[] with two slots that
  * contain indexes for the two answers amongst which is the correct one
  */
 public static int[] lifeLine5050(int answerIndex) {
  int[] result = new int[2];
  int secondIndex;

  String availableDigits = "0123";
  availableDigits = availableDigits.replace(answerIndex + "", "");

  double random = Math.random();

  if (random <= 0.33333) {
   secondIndex = Integer.parseInt(availableDigits.substring(0, 1));
  } else if (random <= 0.66666) {
   secondIndex = Integer.parseInt(availableDigits.substring(1, 2));
  } else {
   secondIndex = Integer.parseInt(availableDigits.substring(2, 3));
  }

  if (answerIndex > secondIndex) {
   result[0] = secondIndex;
   result[1] = answerIndex;
  } else {
   result[0] = answerIndex;
   result[1] = secondIndex;
  }

  return result;
 }
}
