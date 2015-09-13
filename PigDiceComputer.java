public class PigDiceComputer {
  public static void main(String[] args){
    int roll, total = 0;

    do {
      roll = 1 + (int)(Math.random()*6);
      System.out.println("Computer rolled a " + roll + ".");
      if(roll == 1){
        System.out.println("\tThat ends its turn.");
        total = 0;
      } else {
        total += roll;
        System.out.println("\tComputer has " + total + " points so far this round.");

        if(total < 20){
          System.out.println("\tComputer chooses to roll again.");
        }
      }
    } while(roll != 1 && total < 20);

    System.out.println("Computer ends the round with " + total + " points.");
  }
}
