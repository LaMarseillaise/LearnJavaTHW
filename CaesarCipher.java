import java.util.Scanner;
import java.io.File;
import java.io.FileWriter;
import java.io.PrintWriter;

public class CaesarCipher {
  /**
   * Returns the character shifted by the give number of letters.
   */
  public static char shiftLetter(char c, int n){
    int ch = c;
    if(!Character.isLetter(c)){
      return c;
    }

    ch += n;

    if(Character.isUpperCase(c) && ch > 'Z' || Character.isLowerCase(c) && ch > 'z'){
      ch -= 26;
    }
    if(Character.isUpperCase(c) && ch < 'A' || Character.isLowerCase(c) && ch < 'A'){
      ch += 26;
    }

    return (char)ch;
  }

  public static void main(String[] args) throws Exception {
    Scanner keyboard = new Scanner(System.in);
    String plaintext, ciphertext = "";

    System.out.print("Name of file to encrypt: ");
    File in = new File(keyboard.next());
    System.out.print("Name of encrypted file: ");
    File out = new File(keyboard.next());
    System.out.print("Shift (0-26): ");
    int shift = keyboard.nextInt();

    Scanner input = new Scanner(in);
    PrintWriter output = new PrintWriter(new FileWriter(out));

    while(input.hasNextLine()){
      plaintext = input.nextLine();
      ciphertext = "";

      for(int i = 0; i < plaintext.length(); i++){
        ciphertext += shiftLetter(plaintext.charAt(i), shift);
      }

      output.println(ciphertext);
    }

    input.close();
    output.close();
  }
}
