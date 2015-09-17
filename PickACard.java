class Card {
  int value;
  String suit;
  String name;
  public String toString(){
    return name + " of " + suit;
  }
}

public class PickACard {
  public static void main(String[] args){
    Card[] deck = buildDeck();
    shuffleDeck(deck);
    // displayDeck(deck);

    int chosen = (int)(Math.random()*deck.length);
    Card picked = deck[chosen];

    System.out.println("You picked a " + picked + " out of the deck.");
    System.out.println("In Blackjack your card is worth " + picked.value + " points.");
  }

  public static Card[] buildDeck(){
    String[] suits = { "clubs", "diamonds", "hearts", "spades" };
    String[] names = { "ZERO", "ONE", "two", "three", "four", "five", "six", "seven", "eight", "nine", "ten", "Jack", "Queen", "King", "Ace" };

    int i = 0;
    Card[] deck = new Card[52];

    for(String s: suits){
      for(int v = 2; v <= 14; v++){
        Card c = new Card();
        c.suit = s;
        c.name = names[v];
        if(v == 14){
          c.value = 11;
        } else if(v > 10){
          c.value = 10;
        } else {
          c.value = v;
        }

        deck[i] = c;
        i++;
      }
    }

    return deck;
  }

  public static void displayDeck(Card[] deck){
    for(Card c : deck){
      System.out.println(c.value + "\t" + c);
    }
  }

  public static Card[] shuffleDeck(Card[] deck){
    for(int i = 0; i < deck.length; i++){
      int j = i + (int)(Math.random()*(deck.length - i));
      Card temp = deck[j];
      deck[j] = deck[i];
      deck[i] = temp;
    }

    return deck;
  }
}
