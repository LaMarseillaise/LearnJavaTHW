import java.util.Scanner;

class TemperatureSample {
  int month, day, year;
  double temperature;
}

public class TemperaturesByDate {
  public static void main(String[] args) throws Exception {
    String url = "http://learnjavathehardway.org/txt/avg-daily-temps-with-dates-atx.txt";
    Scanner inFile = new Scanner ((new java.net.URL(url)).openStream());

    TemperatureSample[] tempDB = new TemperatureSample[10000];
    int numRecords, i = 0;

    while(inFile.hasNextInt() && i < tempDB.length){
      TemperatureSample e = new TemperatureSample();
      e.month = inFile.nextInt();
      e.day   = inFile.nextInt();
      e.year  = inFile.nextInt();
      e.temperature = inFile.nextDouble();
      if(e.temperature == -99){
        continue;
      }
      tempDB[i] = e;
      i++;
    }

    inFile.close();
    numRecords = i;

    System.out.println(numRecords + " daily temperatures loaded.");

    double[] monthAvgs   = new double[12];
    double[] monthTotals = new double[12];
    int[]    monthCounts = new int[12];

    for(i = 0; i < numRecords; i++){
      monthTotals[tempDB[i].month - 1] += tempDB[i].temperature;
      monthCounts[tempDB[i].month - 1]++;
    }

    for(i = 0; i < monthAvgs.length; i++){
      monthAvgs[i] = roundToOneDecimal(monthTotals[i] / monthCounts[i]);
      System.out.println("Average daily temperature over " + monthCounts[i] + " days in " + monthName(i+1) + ": " + monthAvgs[i]);
    }
  }

  public static double roundToOneDecimal(double d){
    return Math.round(d*10)/10.0;
  }

  public static String monthName(int m){
    String name;

    switch(m) {
      case  1: name = "January";
               break;
      case  2: name = "Feburary";
               break;
      case  3: name = "March";
               break;
      case  4: name = "April";
               break;
      case  5: name = "May";
               break;
      case  6: name = "June";
               break;
      case  7: name = "July";
               break;
      case  8: name = "August";
               break;
      case  9: name = "September";
               break;
      case 10: name = "October";
               break;
      case 11: name = "November";
               break;
      case 12: name = "December";
               break;
      default: name = "error";
    }

    return name;
  }
}
