
package objectsPackage;

import interfacePackage.ShapesInterface;

public class Pyramid3 implements ShapesInterface {
    // triangular pyramid with equilateral triangle base of side s and vertical height h
    private final double SIDE;
    private final double HEIGHT;
    private final double SLANT_HEIGHT;
    private final double SURFACE_AREA;
    private final double VOLUME;
    private final String SHAPE = "Triangular Pyramid";
    public Pyramid3() {
        this.SIDE = Math.random()*10;
        this.HEIGHT = Math.random()*10;
        this.SLANT_HEIGHT = calculateSlantHeight();
        this.SURFACE_AREA = calculateSurfaceArea();
        this.VOLUME = calculateVolume();
    }
    public Pyramid3(double pHeight, double pSide) {
        this.SIDE = pSide;
        this.HEIGHT = pHeight;
        this.SLANT_HEIGHT = calculateSlantHeight();
        this.SURFACE_AREA = calculateSurfaceArea();
        this.VOLUME = calculateVolume();
    }
    private double baseArea() {
        // equilateral triangle area (sqrt(3)/4)*s^2
        return Math.sqrt(3.0)/4.0 * SIDE * SIDE;
    }
    private double apothemOfBase() {
        // distance from center to midpoint of edge: s*sqrt(3)/6
        return (Math.sqrt(3.0)/6.0) * SIDE;
    }
    private double calculateSlantHeight() {
        double a = apothemOfBase();
        return Math.sqrt(HEIGHT*HEIGHT + a*a);
    }
    private double calculateSurfaceArea() {
        double lateralArea = 0.5 * (3*SIDE) * SLANT_HEIGHT; // 3 congruent triangles
        return baseArea() + lateralArea;
    }
    private double calculateVolume() {
        return (baseArea() * HEIGHT)/3.0;
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
