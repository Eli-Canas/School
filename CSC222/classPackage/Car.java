package classPackage;

public class Car{

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

    public Car(){
        this.make = "";
        this.model = "";
        this.year = 0;
        this.fuelSize = 0;
        this.fuelEco = 0;
        this.optimal = 0;
    }
    public Car(String color, String make, String model, int year, double fuelSize, double fuelEco, double optimal){
        this.make = make;
        this.model = model;
        this.year = year;
        this.fuelSize = fuelSize;
        this.fuelEco = fuelEco;
        this.optimal = optimal;
    }

    public double addFuelToTank(double fuel) {
        return 0.0;
    }
}

