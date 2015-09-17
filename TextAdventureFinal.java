import java.util.Scanner;

class Room {
  int roomNumber;
  String roomName;
  String description;
  int numExits;
  String[] exits = new String[10];
  int[] destinations = new int[10];
}

public class TextAdventureFinal {
  public static void main(String[] args){
    Scanner keyboard = new Scanner(System.in);

    // initialize rooms from file
    Room[] rooms = loadRoomsFromFile("text-adventure-rooms.txt");

    // showAllRooms(rooms); // for debugging

    // Okay, so let's play the game!
    int currentRoom = 0;
    String ans;
    while(currentRoom >= 0){
      Room cur = rooms[currentRoom];
      System.out.print(cur.description);
      System.out.print("> ");
      ans = keyboard.nextLine();

      // See if what they typed matches an exit name
      boolean found = false;
      for(int i = 0; i < cur.numExits; i++){
        if(cur.exits[i].equals(ans)){
          found = true;
          // if so, change our next room to that exit's room number
          currentRoom = cur.destinations[i];
        }
      }

      if(!found){
        System.out.println("Sorry, I don't understand.");
      }
    }
  }

  public static Room[] loadRoomsFromFile(String filename){
    Scanner file = null;
    try {
      file = new Scanner(new java.io.File(filename));
    } catch (java.io.IOException e){
      System.err.println("Sorry, I can't read from the file '" + filename + "'.");
      System.exit(1);
    }

    int numRooms = file.nextInt();
    Room[] rooms = new Room[numRooms];

    // initialize rooms from file
    int roomNum = 0;
    while(file.hasNext()){
      Room r = getRoom(file);
      if(r.roomNumber != roomNum){
        System.err.println("Reading room # " + r.roomNumber + ", but " + roomNum + " was expected.");
        System.exit(2);
      }
      rooms[roomNum] = r;
      roomNum++;
    }

    file.close();

    return rooms;
  }

  public static void showAllRooms(Room[] rooms){
    for(Room r: rooms){
      String exitString = "";

      for(int i = 0; i < r.numExits; i++){
        exitString += "\t" + r.exits[i] + " (" + r.destinations[i] + ")";
      }

      System.out.println(r.roomNumber + ") " + r.roomName + "\n" + exitString);
    }
  }

  public static Room getRoom(Scanner f){
    // any rooms left in file?
    if(!f.hasNextInt()){
      return null;
    }

    Room r = new Room();
    String line;

    // read in the room number for error checking
    r.roomNumber = f.nextInt();
    f.nextLine(); // skip line after room number
    r.roomName = f.nextLine();

    // get room description
    r.description = "";
    while(true){
      line = f.nextLine();
      if(line.equals("%%")){
        break;
      }
      r.description += line + "\n";
    }

    // get exits
    int i = 0;
    while(true){
      line = f.nextLine();
      if(line.equals("%%")){
        break;
      }
      String[] parts = line.split(":");
      r.exits[i] = parts[0];
      r.destinations[i] = Integer.parseInt(parts[1]);
      i++;
    }

    r.numExits = i;

    return r;
  }
}
