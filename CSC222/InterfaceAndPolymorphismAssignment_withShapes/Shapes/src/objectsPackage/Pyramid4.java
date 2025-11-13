
package objectsPackage;

import interfacePackage.ShapesInterface;

public class Pyramid4 implements ShapesInterface {
    // square pyramid with base side s and vertical height h
    private final double SIDE;
    private final double HEIGHT;
    private final double SLANT_HEIGHT;
    private final double SURFACE_AREA;
    private final double VOLUME;
    private final String SHAPE = "Square Pyramid";
    public Pyramid4() {
        this.SIDE = Math.random()*10;
        this.HEIGHT = Math.random()*10;
        this.SLANT_HEIGHT = calculateSlantHeight();
        this.SURFACE_AREA = calculateSurfaceArea();
        this.VOLUME = calculateVolume();
    }
    public Pyramid4(double pHeight, double pSide) {
        this.SIDE = pSide;
        this.HEIGHT = pHeight;
        this.SLANT_HEIGHT = calculateSlantHeight();
        this.SURFACE_AREA = calculateSurfaceArea();
        this.VOLUME = calculateVolume();
    }
    private double calculateSlantHeight() {
        return Math.sqrt(HEIGHT*HEIGHT + (SIDE/2.0)*(SIDE/2.0));
    }
    private double calculateSurfaceArea() {
        double baseArea = SIDE*SIDE;
        double lateralArea = 2*SIDE*SLANT_HEIGHT; // 4 triangles -> 1/2 * perimeter * slant = 1/2 * (4s) * l = 2 s l
        return baseArea + lateralArea;
    }
    private double calculateVolume() {
        return (SIDE*SIDE*HEIGHT)/3.0;
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
