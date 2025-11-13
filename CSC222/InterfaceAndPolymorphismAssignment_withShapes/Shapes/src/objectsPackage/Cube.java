
package objectsPackage;

import interfacePackage.ShapesInterface;

public class Cube implements ShapesInterface {
    private final double SIDE;
    private final double SURFACE_AREA;
    private final double VOLUME;
    private final String SHAPE = "Cube";
    public Cube() {
        this.SIDE = Math.random()*10;
        this.SURFACE_AREA = calculateSurfaceArea();
        this.VOLUME = calculateVolume();
    }
    public Cube(double pSide) {
        this.SIDE = pSide;
        this.SURFACE_AREA = calculateSurfaceArea();
        this.VOLUME = calculateVolume();
    }
    private double calculateSurfaceArea() {
        return 6*SIDE*SIDE;
    }
    private double calculateVolume() {
        return SIDE*SIDE*SIDE;
    }
    @Override
    public double getArea() {
        return SURFACE_AREA;
    }
    @Override
    public double getVolume() {
        return VOLUME;
    }
    @Override
    public void displayArea() {
        System.out.printf("This is a %s with a surface area of %3.2f square units%n", SHAPE, SURFACE_AREA);
    }
    @Override
    public void displayVolume() {
        System.out.printf("This is a %s with a volume of %3.2f cubic units%n", SHAPE, VOLUME);
    }
    public String toString() {
        return SHAPE;
    }
}
