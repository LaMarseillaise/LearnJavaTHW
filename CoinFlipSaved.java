import java.util.Scanner;
import java.io.File;
import java.io.FileWriter;
import java.io.PrintWriter;

public class CoinFlipSaved {
  public static void main(String[] args) throws Exception {
    Scanner keyboard = new Scanner(System.in);

    String coin, again, bestName, saveFile = "coin-flip-score.txt";
    int flip, streak = 0, best;

    File in = new File(saveFile);
    if( in.createNewFile() ){
      System.out.println("Save game file doesn't exist. Created.");
      best = -1;
      bestName = "";
    } else {
      Scanner input = new Scanner(in);
      bestName = input.next();
      best = input.nextInt();
      input.close();
      System.out.println("High score is " + best + " flips in a row by " + bestName);
    }

    do {
      flip = 1 + (int)(Math.random()*2);

      if(flip == 1){
        coin = "HEADS";
      } else {
        coin = "TAILS";
      }

      System.out.println("You flip a coin and it is... " + coin);

      if(flip == 1){
        streak++;
        System.out.println("\tThat's " + streak + " in a row...");
        System.out.print("\tWould you like to flip again (y/n)? ");
        again = keyboard.next();
      } else {
        streak = 0;
        again = "n";
      }
    } while(again.equals("y"));

    System.out.println("Final score: " + streak);

    if(streak > best){
      System.out.println("That's a new high score!");
      System.out.println("Your name: ");
      best = streak;
      PrintWriter out = new PrintWriter(new FileWriter(saveFile));
      out.println(keyboard.next());
      out.println(best);
      out.close();
    } else if(streak == best){
      System.out.println("That ties the high score.");
    } else {
      System.out.println("You'll have to do better than " + streak + " if you want a high score.");
    }
  }
}
