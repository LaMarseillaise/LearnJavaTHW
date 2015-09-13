public class YachtDice {
  public static void main(String[] args){
    int roll1, roll2, roll3, roll4, roll5;
    boolean allTheSame;

    do {
      roll1 = 1 + (int)(Math.random()*6);
      roll2 = 1 + (int)(Math.random()*6);
      roll3 = 1 + (int)(Math.random()*6);
      roll4 = 1 + (int)(Math.random()*6);
      roll5 = 1 + (int)(Math.random()*6);

      System.out.println("\nYou rolled: " + roll1 + " " + roll2 + " " + roll3 + " " + roll4 + " " + roll5);
      showDice(roll1);
      showDice(roll2);
      showDice(roll3);
      showDice(roll4);
      showDice(roll5);
      allTheSame = ( roll1 == roll2 && roll1 == roll3 && roll1 == roll4 && roll1 == roll5 );
    } while (!allTheSame);
    System.out.println("Yacht, see?");
  }

  public static void showDice(int roll){
    String top, middle, bottom;

    if(roll > 3){
      top    = "|o o|";
      bottom = "|o o|";
    } else if(roll == 1){
      top    = "|   |";
      bottom = "|   |";
    } else {
      top    = "|o  |";
      bottom = "|  o|";
    }

    if(roll % 2 == 1){
      middle = "| o |";
    } else if(roll == 6){
      middle = "|o o|";
    } else {
      middle = "|   |";
    }

    System.out.println("+---+");
    System.out.println(top);
    System.out.println(middle);
    System.out.println(bottom);
    System.out.println("+---+");
  }
}
