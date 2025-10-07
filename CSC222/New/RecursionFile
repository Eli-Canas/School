import java.util.Scanner;

public class RecursionFile {
        
        public static int integerLog(int number, int base) {
            //if number is less than base, return 0
            if (number < base) {
                return 0;
            } 
            else {
                //return 1 plus the integer log of number divided by base
                return 1 + integerLog(number / base, base);
            }
        }
        
        public static void main(String[] args) {
            Scanner scanner = new Scanner(System.in);
            char choice;
            
            do {
                System.out.println("Please enter a number to find the integer log of:");
                int number = scanner.nextInt();
                System.out.println("Please enter the base for the calculation:");
                int base = scanner.nextInt();
                
                int result = integerLog(number, base);
                System.out.printf("The base %d integer log of %d is %d%n", base, number, result);
                
                System.out.println("Would you like to enter another pair of numbers?");
                System.out.println("Please enter 'y' for yes or 'n' for no.");
                choice = scanner.next().charAt(0);
                
                // Consume the newline character left by nextInt() or next()
                scanner.nextLine();
            } while (choice == 'y' || choice == 'Y');
            
            System.out.println("Good-bye!");
            scanner.close();
        }
}
    

