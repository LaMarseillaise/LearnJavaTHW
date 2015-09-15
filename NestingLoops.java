public class NestingLoops {
  public static void main(String[] args){
    for(int n = 1; n <= 3; n++){
      for(char c = 'A'; c <= 'E'; c++){
        System.out.println(c + " " + n);
      }
    }

    System.out.println("\n");

    for(int a = 1; a <= 3; a++){
      for(int b = 1; b <= 3; b++){
        System.out.print("(" + a + "," + b + ") ");
      }
      System.out.println();
    }

    System.out.println("\n");
  }
}
