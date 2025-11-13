import java.util.ArrayList;
import java.util.Scanner;
import interfacePackage.ShapesInterface;


/**
 * 
 */

/**
 * @author Larry Shannon
 *
 */
public class TestDriver
{
	private static Scanner keyboard = new Scanner(System.in);
	/**
	 * @param args
	 */
	public static void main(String[] args)
	{
		ArrayList<ShapesInterface> myShapes = new ArrayList<ShapesInterface>();
		String yesOrNo = "yes";
		int arrayCount = 0;
		do
		{
			addNewShape(myShapes);
			
			System.out.printf("There are %d shapes in the array%n", myShapes.size());
			arrayCount = 0;
			for(ShapesInterface currentShape: myShapes)
			{
				System.out.printf("Shape #%d is a %s%n",++arrayCount, currentShape.toString());
				System.out.printf("Its area is %3.2f square units%n",currentShape.getArea());
				System.out.printf("Its volume is %3.2f cubic units%n",currentShape.getVolume());
				currentShape.displayArea();
				currentShape.displayVolume();
			}
			System.out.println("Would you like to add another shape?");
			do
			{
				System.out.println("Please enter \"yes\" or \"no\"");
				yesOrNo = keyboard.nextLine();
			}while(!yesOrNo.equalsIgnoreCase("yes")&&!yesOrNo.equalsIgnoreCase("no"));
		}while(yesOrNo.equalsIgnoreCase("yes"));
	}
	private static void addNewShape(ArrayList<ShapesInterface> pShapes)
	{
		String randomOrSelected = "r";
		System.out.println("Would you like to generate a random shape or select a shape and a size?");
		do
		{
			System.out.println("Please enter \"r\" for random or \"s\" to select the shape");
			randomOrSelected = keyboard.nextLine();
		}while(!randomOrSelected.equalsIgnoreCase("r")&&!randomOrSelected.equalsIgnoreCase("s"));
		if(randomOrSelected.equalsIgnoreCase("r"))
		{
			pShapes.add(ShapeGenerator.getShape());
		}
		else
		{
			pShapes.add(ShapeGenerator.selectShape());
		}
	}

}
