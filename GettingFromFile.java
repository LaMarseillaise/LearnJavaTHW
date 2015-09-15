import java.util.Scanner;
import java.io.File;

public class GettingFromFile {
  public static void main(String[] args) throws Exception {
    Scanner fileIn = new Scanner(new File("name-and-numbers.txt"));

    int a, b, c, sum;
    String name;

    System.out.print("Getting name and three numbers from file...");
    name = fileIn.nextLine();
    a = fileIn.nextInt();
    b = fileIn.nextInt();
    c = fileIn.nextInt();
    fileIn.close();

    System.out.println("done.");
    System.out.println("Your name is " + name);
    sum = a + b + c;
    System.out.println(a + " + " + b + " + " + c + " = " + sum);
  }
}
