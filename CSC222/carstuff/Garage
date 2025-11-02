package carstuff;

public class Garage {

    private Car[] parking;

    public Garage(int size) {
        if (size < 1) size = 1;
        if (size > 10) size = 10;
        parking = new Car[size];
    }

    public void displayCars() {
        System.out.println("Here are the current cars.");
        for (int i = 0; i < parking.length; i++) {
            System.out.print("Space " + (i + 1) + ": ");
            if (parking[i] == null) {
                System.out.println("null");
            } else {
                System.out.println(parking[i]);
            }
        }
    }

    // user talks to Garage, Garage talks to Car
    public double addFuelToCar(int space, double fuelToAdd) {
        int idx = space - 1;
        if (idx < 0 || idx >= parking.length || parking[idx] == null) {
            System.out.println("THere is no car in that space!");
            return 0.0;
        }
        return parking[idx].addFuelToTank(fuelToAdd);
    }

    // remove car to drive
    public Car getCar(int space) {
        int idx = space - 1;
        if (idx < 0 || idx >= parking.length) return null;
        Car c = parking[idx];
        parking[idx] = null;
        return c;
    }

    // put car back
    public boolean parkCar(Car c) {
        for (int i = 0; i < parking.length; i++) {
            if (parking[i] == null) {
                parking[i] = c;
                return true;
            }
        }
        return false;
    }

    public boolean isEmpty() {
        for (Car c : parking) {
            if (c != null) return false;
        }
        return true;
    }

    public boolean hasSpace() {
        for (Car c : parking) {
            if (c == null) return true;
        }
        return false;
    }

    public int getSize() {
        return parking.length;
    }
}
