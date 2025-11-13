
import interfacePackage.ShapesInterface;
import objectsPackage.Cone;
import objectsPackage.Triangle;
import objectsPackage.Pyramid4;
import objectsPackage.Pyramid3;
import objectsPackage.Square;
import objectsPackage.Cube;
import java.util.Scanner;

public class ShapeGenerator
{
	private static Scanner keyboard = new Scanner(System.in);

	public static ShapesInterface getShape()
	{
		int numberOfShapes = 6; // Triangle, Cone, Pyramid4, Pyramid3, Square, Cube
		int randomValue = (int)(Math.random() * numberOfShapes);
		ShapesInterface newShape = null;
		switch(randomValue)
		{
			case 0: newShape = new Triangle(); break;
			case 1: newShape = new Cone(); break;
			case 2: newShape = new Pyramid4(); break;
			case 3: newShape = new Pyramid3(); break;
			case 4: newShape = new Square(); break;
			case 5: newShape = new Cube(); break;
			default: newShape = new Triangle(); // fallback
		}
		return newShape;
	}

	public static ShapesInterface selectShape()
	{
		ShapesInterface newShape = null;
		boolean shapeNotSelected = true;
		int menuValue = 0;
		double height = 0.0;
		double base = 0.0;
		double radius = 0.0;
		double side = 0.0;
		do
		{
			shapeNotSelected = false;
			System.out.println("Select from the following shapes:");
			System.out.println("1) Triangle");
			System.out.println("2) Cone");
			System.out.println("3) Square Pyramid (Pyramid4)");
			System.out.println("4) Triangular Pyramid (Pyramid3)");
			System.out.println("5) Square");
			System.out.println("6) Cube");
			if(!keyboard.hasNextInt()) { keyboard.nextLine(); menuValue = 0; }
			else { menuValue = keyboard.nextInt(); keyboard.nextLine(); }

			switch(menuValue)
			{
				case 1:
					System.out.println("You selected a triangle.");
					System.out.println("Please enter the base of the triangle.");
					while(!keyboard.hasNextDouble()) { keyboard.nextLine(); System.out.println("Invalid entry."); System.out.println("Please enter the base of the triangle."); }
					base = keyboard.nextDouble(); keyboard.nextLine();
					System.out.println("Please enter the height of the triangle.");
					while(!keyboard.hasNextDouble()) { keyboard.nextLine(); System.out.println("Invalid entry."); System.out.println("Please enter the height of the triangle."); }
					height = keyboard.nextDouble(); keyboard.nextLine();
					newShape = new Triangle(height, base);
					break;

				case 2:
					System.out.println("You selected a cone.");
					System.out.println("Please enter the radius of the base.");
					while(!keyboard.hasNextDouble()) { keyboard.nextLine(); System.out.println("Invalid entry."); System.out.println("Please enter the radius of the base."); }
					radius = keyboard.nextDouble();
					System.out.println("Please enter the height of the cone.");
					while(!keyboard.hasNextDouble()) { keyboard.nextLine(); System.out.println("Invalid entry."); System.out.println("Please enter the height of the cone."); }
					height = keyboard.nextDouble(); keyboard.nextLine();
					newShape = new Cone(height, radius);
					break;

				case 3:
					System.out.println("You selected a square pyramid.");
					System.out.println("Please enter the side length of the square base.");
					while(!keyboard.hasNextDouble()) { keyboard.nextLine(); System.out.println("Invalid entry."); System.out.println("Please enter the side length of the square base."); }
					side = keyboard.nextDouble(); keyboard.nextLine();
					System.out.println("Please enter the vertical height of the pyramid.");
					while(!keyboard.hasNextDouble()) { keyboard.nextLine(); System.out.println("Invalid entry."); System.out.println("Please enter the vertical height of the pyramid."); }
					height = keyboard.nextDouble(); keyboard.nextLine();
					newShape = new Pyramid4(height, side);
					break;

				case 4:
					System.out.println("You selected a triangular pyramid.");
					System.out.println("Please enter the side length of the (equilateral) triangular base.");
					while(!keyboard.hasNextDouble()) { keyboard.nextLine(); System.out.println("Invalid entry."); System.out.println("Please enter the side length of the triangular base."); }
					side = keyboard.nextDouble(); keyboard.nextLine();
					System.out.println("Please enter the vertical height of the pyramid.");
					while(!keyboard.hasNextDouble()) { keyboard.nextLine(); System.out.println("Invalid entry."); System.out.println("Please enter the vertical height of the pyramid."); }
					height = keyboard.nextDouble(); keyboard.nextLine();
					newShape = new Pyramid3(height, side);
					break;

				case 5:
					System.out.println("You selected a square.");
					System.out.println("Please enter the side length.");
					while(!keyboard.hasNextDouble()) { keyboard.nextLine(); System.out.println("Invalid entry."); System.out.println("Please enter the side length."); }
					side = keyboard.nextDouble(); keyboard.nextLine();
					newShape = new Square(side);
					break;

				case 6:
					System.out.println("You selected a cube.");
					System.out.println("Please enter the side length.");
					while(!keyboard.hasNextDouble()) { keyboard.nextLine(); System.out.println("Invalid entry."); System.out.println("Please enter the side length."); }
					side = keyboard.nextDouble(); keyboard.nextLine();
					newShape = new Cube(side);
					break;

				default:
					shapeNotSelected = true;
			}
		} while(shapeNotSelected);

		return newShape;
	}
}
