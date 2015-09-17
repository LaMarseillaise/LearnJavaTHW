public class ArraySlotAccess {
  public static void main(String[] args){
    int[] arr = new int[1000];
    int i;

    arr[0] = 0;
    arr[1] = 0;
    arr[2] = 0;

    System.out.println("Array contains: " + arr[0] + " " + arr[1] + " " + arr[2]);

    arr[0] = 1 + (int)(Math.random()*100);
    arr[1] = 1 + (int)(Math.random()*100);
    arr[2] = 1 + (int)(Math.random()*100);

    System.out.println("Array contains: " + arr[0] + " " + arr[1] + " " + arr[2]);

    i = 0;
    arr[i] = 1 + (int)(Math.random()*100);
    i = 1;
    arr[i] = 1 + (int)(Math.random()*100);
    i = 2;
    arr[i] = 1 + (int)(Math.random()*100);

    System.out.print("Array contains: ");
    i = 0;
    System.out.print(arr[i] + " ");
    i = 1;
    System.out.print(arr[i] + " ");
    i = 2;
    System.out.print(arr[i] + " ");
    System.out.println();

    i = 0;
    arr[i] = 1 + (int)(Math.random()*100);
    i++;
    arr[i] = 1 + (int)(Math.random()*100);
    i++;
    arr[i] = 1 + (int)(Math.random()*100);

    System.out.print("Array contains: ");
    i = 0;
    System.out.print(arr[i] + " ");
    i++;
    System.out.print(arr[i] + " ");
    i++;
    System.out.print(arr[i] + " ");
    System.out.println();

    for(i = 0; i < arr.length; i++){
      arr[i] = 1 + (int)(Math.random()*100);
    }

    System.out.print("Array contains: ");
    for(i = 0; i < arr.length; i++){
      System.out.print(arr[i] + " ");
    }

    System.out.println();
  }
}
