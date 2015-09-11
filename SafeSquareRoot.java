import java.util.Scanner;

public class SafeSquareRoot {
  public static void main(String[] args){
    Scanner keyboard = new Scanner(System.in);
    double x, y;
    String i = "";

    System.out.print("Give me a number, and I shall find the square root of it. ");
    System.out.print("(No negatives, please.) ");
    x = keyboard.nextDouble();

    y = Math.sqrt(Math.abs(x));

    if(x < 0){
      i = "i";
    }

    System.out.println("The square root of " + x + " is " + y + i);
  }
}
