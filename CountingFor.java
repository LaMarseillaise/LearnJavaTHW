import java.util.Scanner;

public class CountingFor {
  public static void main(String[] args){
    Scanner keyboard = new Scanner(System.in);

    String message;

    System.out.println("Type in a message, and I'll display it five times.");
    System.out.print("Message: ");
    message = keyboard.nextLine();

    for(int n = 1; n <= 5; n++){
      System.out.println(n + ". " + message);
    }

    System.out.println("\nNow I'll display it ten times and count by 5s.");

    for(int n = 5; n <= 50; n += 5){
      System.out.println(n + ". " + message);
    }

    System.out.println("\nFinally, three times counting backward.");
    for(int n = 3; n > 0; n--){
      System.out.println(n + ". " + message);
    }
  }
}
