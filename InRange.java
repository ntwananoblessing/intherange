import java.io.*;
import java.util.*;
public class InRange{
    public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    System.out.println("Enter the first point on the line:");
    int x1 = scanner.nextInt();
    int y1 = scanner.nextInt();
    System.out.println("Enter the second point on the line:") ;
    int x2 = scanner.nextInt();
    int y2 = scanner.nextInt();
    System.out.println("Enter the distance:");
    double d = scanner.nextDouble();
    scanner.nextLine();
    System.out.println(" Enter the name of the points file:");
    String filename = scanner.nextLine();
    int count = 0;
    try{
        List<String> points = new ArrayList<>();
       Scanner inStream = new Scanner(new FileInputStream(filename));
       while (inStream.hasNextLine()){
        String theLine = inStream.nextLine();
        String[] line = theLine.split(" ");
        double xi = Double.parseDouble(line[0]);
        double yi = Double.parseDouble(line[1]);
        //calculations
         double A = Math.abs((x2-x1)*(y1-yi)-(x1-xi)*(y2-y1));
         double B = Math.sqrt(Math.pow((x2-x1),2) + Math.pow((y2-y1),2));
         double distance = A/B;
         //conditions
         if (distance<d){
            count++;
            points.add(theLine);
         }
         
       }
       System.out.println("Number of points in range: "+ count +".");
       for (String point: points){
        System.out.println(point);
       }
         System.out.println("Done");
    }
    catch(FileNotFoundException e){
          System.out.println("File Not Found!!");
    }
}
}