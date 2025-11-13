/**
 * 
 */
package objectsPackage;

import interfacePackage.ShapesInterface;

/**
 * @author Larry Shannon
 *
 */
public class Triangle implements ShapesInterface
{

	private final double BASE;
	private final double HEIGHT;
	private final double SURFACE_AREA;
	private final String SHAPE = "Triangle";
	public Triangle()
	{
		this.BASE = Math.random() * 10;
		this.HEIGHT = Math.random() * 10;
		this.SURFACE_AREA = (this.BASE * this.HEIGHT) / 2;
	}
	public Triangle(double pHeight, double pBase)
	{
		this.BASE = pBase;
		this.HEIGHT = pHeight;
		this.SURFACE_AREA = calculateSurfaceArea();
	}
	
	private double calculateSurfaceArea()
	{
		return (this.BASE * this.HEIGHT) / 2;
	}
	@Override
	public double getArea()
	{
		// TODO Auto-generated method stub
		return this.SURFACE_AREA;
	}

	@Override
	public double getVolume()
	{
		// A triangle does not have a volume
		return 0;
	}
	@Override
	public void displayArea()
	{
		System.out.printf("This is a %s with an area of %3.2f square units%n",SHAPE, SURFACE_AREA);
	}
	@Override
	public void displayVolume()
	{
		System.out.printf("This is a %s and it has no volume!%n",SHAPE);
	}

	public String toString()
	{
		return SHAPE;
	}

}
