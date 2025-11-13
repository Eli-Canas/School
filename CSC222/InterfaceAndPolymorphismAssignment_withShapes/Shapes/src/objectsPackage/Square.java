
package objectsPackage;

import interfacePackage.ShapesInterface;

public class Square implements ShapesInterface {
    private final double SIDE;
    private final double SURFACE_AREA;
    private final String SHAPE = "Square";
    public Square() {
        this.SIDE = Math.random()*10;
        this.SURFACE_AREA = calculateSurfaceArea();
    }
    public Square(double pSide) {
        this.SIDE = pSide;
        this.SURFACE_AREA = calculateSurfaceArea();
    }
    private double calculateSurfaceArea() {
        return SIDE*SIDE;
    }
    @Override
    public double getArea() {
        return SURFACE_AREA;
    }
    @Override
    public double getVolume() {
        return 0;
    }
    @Override
    public void displayArea() {
        System.out.printf("This is a %s with an area of %3.2f square units%n", SHAPE, SURFACE_AREA);
    }
    @Override
    public void displayVolume() {
        System.out.printf("This is a %s and it has no volume!%n", SHAPE);
    }
    public String toString() {
        return SHAPE;
    }
}
