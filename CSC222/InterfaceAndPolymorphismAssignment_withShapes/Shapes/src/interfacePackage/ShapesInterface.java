package interfacePackage;
/**
 * 
 */

/**
 * @author Larry Shannon
 *
 */
public interface ShapesInterface
{
	public double getArea();
	// This method returns the area of a 2 dimensional shape
	// or the surface are of a 3 dimensional shape.
	public double getVolume();
	// This method returns the volume of a 3 dimensional shape
	// or 0 for a 2 dimensional shape.
	public void displayArea();
	// This method displays the name of the shape and its area,
	// If the shape is 2 dimensional it displays the 2 dimensional area	
	// If the shape is 3 dimensional it displays the surface area	of the shape
	public void displayVolume();
	// This method displays the name of the shape and its volume,
	// This method displays the volume of a 3 dimensional shape and 0 for a 2 dimensional shape.

}
