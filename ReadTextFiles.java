

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * Class to read text from text files
 */
public class ReadTextFiles {
 
 /**
  * Designed to read the file containing all the questions
  * pre: valid String that represents a valid path for a .txt file
  * post: String[] containing 30 Strings that represent different questions
  */
 public static String[] readQues(String filePath){
  String[] ques = new String[30];
  Scanner input;
  int i = 0;
  
  try{
   File f = new File(filePath);
   input = new Scanner(f);
   
   while (input.hasNext()) {
    ques[i] = input.nextLine();
    i++;
   }
  } catch (FileNotFoundException e) {
   System.out.println("File \"" + filePath + "\" was not found");
  } catch(Exception e) {
   System.out.println("Unexpected error while reading the file");
  }
  
  return ques;
 }
 
 /**
  * Designed to read the file containing all the answer choices
  * pre: valid String that represents a valid path for a .txt file
  * post: String[][] containing 30 Strings[] that each contain 4 answer choices
  */
 public static String[][] readChoiceOptions(String filePath){
  String[][] mult = new String[30][4];
  Scanner input;
  int i = 0;
  
  try{
   File f = new File(filePath);
   input = new Scanner(f);
   
   while (input.hasNext()) {
    mult[i / 4][i % 4] = input.nextLine();
    i++;
   }
  } catch (FileNotFoundException e) {
   System.out.println("File \"" + filePath + "\" was not found");
  } catch(Exception e) {
   System.out.println("Unexpected error while reading the file");
  }
  
  return mult;
 }
}
