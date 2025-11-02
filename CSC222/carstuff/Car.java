package carstuff;

public class Car {

    // ====== constant-style fields (initialized once per car) ======
    private String make;
    private String model;
    private String color;
    private int year;
    private double fuelTankSize;     // max gallons
    private double bestFuelEconomy;  // mpg at best speed
    private double optimalSpeed;     // mph at best mpg

    // ====== changing state ======
    private double odometer;         // total miles
    private double tripOdometer;     // trip miles
    private double fuelLevel;        // gallons currently in tank

    // ====== trip setup (what driveCar() will try to drive) ======
    private double tripSpeed;        // mph
    private double tripDistance;     // miles

    // ====== constants for logic ======
    private static final double EPS = 0.1;   // epsilon for fuel check
    private static final double MIN_MPG = 2.0;  // lower bound on mpg

    // ------------------------------------------------------------
    // no-arg constructor: random values per spec
    // ------------------------------------------------------------
    public Car() {
        this.year = randInt(1920, 2021);
        this.make = randFrom(new String[]{"Ford","Chevrolet","Opel","Lotus","Honda","Toyota"});
        this.model = randFrom(new String[]{"F150","Mustang","Evija","Evora","Astra","SSR","El Camino","Kaddet","Tigra"});
        this.color = randFrom(new String[]{"Red","Blue","Yellow","Green","Black","White","Magenta","Gold"});

        this.fuelTankSize = randDouble(8.0, 34.99);
        this.fuelLevel = randDouble(0.0, this.fuelTankSize);
        this.odometer = randDouble(0.0, 5.99);
        this.tripOdometer = 0.0;

        this.bestFuelEconomy = randDouble(15.0, 54.99);
        this.optimalSpeed = randDouble(45.0, 64.99);

        this.tripSpeed = 0.0;
        this.tripDistance = 0.0;
    }

    // ------------------------------------------------------------
    // full constructor
    // Car(String, String, String, int, double, double, double)
    // make, model, color, year, tank size, fuel economy, best speed
    // ------------------------------------------------------------
    public Car(String make, String model, String color,
               int year, double tankSize,
               double fuelEconomy, double bestSpeed) {

        this.make = make;
        this.model = model;
        this.color = color;
        this.year = year;
        this.fuelTankSize = tankSize;
        this.bestFuelEconomy = fuelEconomy;
        this.optimalSpeed = bestSpeed;

        this.odometer = randDouble(0.0, 5.99);
        this.tripOdometer = 0.0;
        this.fuelLevel = randDouble(0.0, this.fuelTankSize);

        this.tripSpeed = 0.0;
        this.tripDistance = 0.0;
    }

    // ------------------------------------------------------------
    // public addFuelToTank(double): double
    // returns:
    //   < 0  -> tank can still take (-return) gallons
    //   == 0 -> we filled it exactly (within epsilon)
    //   > 0  -> leftover fuel that didn't fit
    // ------------------------------------------------------------
    public double addFuelToTank(double fuelToAdd) {
        if (fuelToAdd <= 0) {
            return 0.0;
        }

        double spaceLeft = fuelTankSize - fuelLevel;
        double newLevel = fuelLevel + fuelToAdd;

        // close enough to full?
        if (Math.abs(newLevel - fuelTankSize) <= EPS) {
            fuelLevel = fuelTankSize;
            return 0.0;
        }

        // still room
        if (newLevel < fuelTankSize) {
            fuelLevel = newLevel;
            // negative -> still can take this much
            return -(fuelTankSize - fuelLevel);
        }

        // too much -> fill it, return leftover
        fuelLevel = fuelTankSize;
        return newLevel - fuelTankSize;
    }

    // ------------------------------------------------------------
    // "1954, Red, Lotus, Evija, with 5.16 gallons of gas in the tank,
    //  1.49 miles on the oddometer, and 0.00 miles on the trip oddometer."
    // ------------------------------------------------------------
    @Override
    public String toString() {
        return String.format("%d, %s, %s, %s, with %.2f gallons of gas in the tank, %.2f miles on the oddometer, and %.2f miles on the trip oddometer.",
                year, color, make, model, fuelLevel, odometer, tripOdometer);
    }

    // ------------------------------------------------------------
    // equals(Car): same year, make, model
    // ------------------------------------------------------------
    public boolean equals(Car other) {
        if (other == null) return false;
        return this.year == other.year
                && this.make.equals(other.make)
                && this.model.equals(other.model);
    }


    public void setUpTrip(double pSpeed, double pDistance) {
        if (pSpeed <= 0 || pDistance <= 0) {
            // still store, driveCar() will handle
            this.tripSpeed = pSpeed;
            this.tripDistance = pDistance;
            return;
        }
        this.tripSpeed = pSpeed;
        this.tripDistance = pDistance;
    }

    // ------------------------------------------------------------
    // driveCar():boolean
    // - uses tripSpeed & tripDistance
    // - mpg is best at optimalSpeed, poorer away from it
    // - floors to MIN_MPG
    // - updates odometers
    // - clears trip info
    // ------------------------------------------------------------
    public boolean driveCar() {
        double distance = this.tripDistance;
        double speed = this.tripSpeed;

        // clear trip info at the end no matter what
        boolean finishedTrip;

        if (distance <= 0 || speed <= 0) {
            // nothing to do, but caller expects "true" (no failure)
            finishedTrip = true;
        } else {
            double mpg = calcMpg(speed);
            double gallonsNeeded = distance / mpg;

            if (gallonsNeeded <= fuelLevel + EPS) {
                // we can finish
                fuelLevel -= gallonsNeeded;
                odometer += distance;
                tripOdometer += distance;
                finishedTrip = true;
            } else {
                // run out partway
                double milesPossible = fuelLevel * mpg;
                odometer += milesPossible;
                tripOdometer += milesPossible;
                fuelLevel = 0.0;
                finishedTrip = false;
            }
        }

        // per spec, reset trip vars
        this.tripDistance = 0.0;
        this.tripSpeed = 0.0;

        return finishedTrip;
    }

    // ------------------------------------------------------------
    // getTripOdometer():double – to nearest tenth
    // ------------------------------------------------------------
    public double getTripOdometer() {
        return Math.round(tripOdometer * 10.0) / 10.0;
    }

    // ------------------------------------------------------------
    // clearTripOdometer():void
    // ------------------------------------------------------------
    public void clearTripOdometer() {
        this.tripOdometer = 0.0;
    }

    // ------------------------------------------------------------
    // getOdometer():double – to nearest tenth
    // ------------------------------------------------------------
    public double getOdometer() {
        return Math.round(odometer * 10.0) / 10.0;
    }

    // ------------------------------------------------------------
    // getFuelLevel():double
    // ------------------------------------------------------------
    public double getFuelLevel() {
        return fuelLevel;
    }

    // ------------------------------------------------------------
    // getFuelTankSize():double
    // ------------------------------------------------------------
    public double getFuelTankSize() {
        return fuelTankSize;
    }

    // ------------------------------------------------------------
    // some getters that the Garage/Driver may need
    // ------------------------------------------------------------
    public String getMake()  { return make; }
    public String getModel() { return model; }
    public String getColor() { return color; }
    public int getYear()     { return year; }

    // ------------------------------------------------------------
    // mpg calculation: best at optimalSpeed, linearly worse away from it
    // ------------------------------------------------------------
    private double calcMpg(double speed) {
        if (speed <= 0) return MIN_MPG;

        double diff = Math.abs(speed - optimalSpeed);
        double ratio = diff / optimalSpeed;         // 0 when optimal, >0 when off
        double penalty = bestFuelEconomy * 0.5 * ratio;  // up to ~50% worse
        double mpg = bestFuelEconomy - penalty;

        if (mpg < MIN_MPG) mpg = MIN_MPG;
        return mpg;
    }

    // ------------------------------------------------------------
    // helper random methods
    // ------------------------------------------------------------
    private static int randInt(int min, int maxInclusive) {
        return min + (int)(Math.random() * (maxInclusive - min + 1));
    }

    private static double randDouble(double min, double max) {
        return min + (Math.random() * (max - min));
    }

    private static String randFrom(String[] vals) {
        return vals[(int)(Math.random() * vals.length)];
    }
}
