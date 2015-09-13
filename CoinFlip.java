import java.util.Scanner;

public class CoinFlip {
  public static void main( String[] args ) {
    Scanner keyboard = new Scanner(System.in);

    String coin, again;
    int flip, streak = 0;

    do {
      flip = 1 + (int)(Math.random()*2);

      if (flip == 1) {
        coin = "HEADS";
      } else {
        coin = "TAILS";
      }

      System.out.println("You flip a coin and it is... " + coin);

      if (flip == 1) {
        streak++;
        System.out.println("\nThat's " + streak + " in a row....");
        System.out.print("\tWould you like to flip again (y/n)? ");
        again = keyboard.next();
      } else {
        streak = 0;
        again = "n";
      }
    } while ( again.equals("y") );

    System.out.println("Final score: " + streak);
  }
}
