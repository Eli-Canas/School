
import java.util.Scanner;

public class car{
    Scanner scnr = new Scanner(System.in);
    public static void main(String[] args){
        carType();
    }

    public carType(String make, String model, int year, double fuelSize, double fuelEco, double optimal){
        System.out.print("What is the Make of your car?: ");
        make = scnr.nextline();
        System.out.print("What is the Model of your car?: ");
        model = scnr.nextline();
        System.out.print("What is the Year of your car?: ");
        year = scnr.nextInt();
        System.out.print("What is the Gas tank size of your car?: ");
        fuelSize = scnr.nextDouble();
        System.out.printf("What is the peak fuel economy of your %d %s %s?: ", year, make, model);
        fuelEco = scnr.nextDouble();
        System.out.printf("What is the best MPH for fuel economy in your %d %s %s?: ", year, make, model);
        optimal = scnr.nextDouble();
}
    
/* 
final String make;
final String model;
final int year;
final double fuelSize;
final double fuelEco;
final double optimal;
double odo;
double tripOdo;
String color;
double fuelLevel;
}

public carType(){
}
}
*/