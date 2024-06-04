import java.util.Scanner;


public class MiniProjects {
    private static Scanner scnr = new Scanner(System.in);
    public static void main(String [] args) {
        
        //problem1();

        //problem2();

        //problem3();

        //problem4();

        problem5();
    }

    private static void problem1(){
        System.out.print("Enter first string: ");
        String str1 = scnr.nextLine();
        System.out.print("Enter second string: ");
        String str2 = scnr.nextLine();
        String str3 = (str1 + " " + str2);
        scnr.close();

        int len1 = str1.length();
        int len2 = str2.length();
        int len3 = str3.length();

        System.out.println("-------------------------");
        System.out.printf("String: %s",str1);
        System.out.printf(", length: %d\n",len1);
        System.out.printf("String: %s",str2);
        System.out.printf(", length: %d\n",len2);
        System.out.printf("%s, length:%d",str3, len3);
       
   
    }
    
    private static void problem2(){
        System.out.print("Type in your string: ");
        String input = scnr.nextLine();
        String start, end;
        String result;
        int index = input.indexOf("hate");

        if (index == -1){
            System.out.println(input);
            return;
        }
        start = input.substring(0, index);
        end = input.substring(index + 4);
        result = (start + "love" + end);

        System.out.println(result);
    }

    private static void problem3(){
        System.out.print("Whats you favorite color?: ");
        String color = scnr.nextLine();
        System.out.print("Whats your favorite food?: ");
        String food = scnr.nextLine();
        System.out.print("Whats you favorite animal?: ");
        String animal = scnr.nextLine();
        System.out.print("Enter someones name: ");
        String firstName = scnr.nextLine();
    
        System.out.printf("I had a dream that %s ate a %s %s and said it tasted like %s!", firstName, color, animal, food);


    }

    private static void problem4(){
        System.out.print("How deep is your well in feet?: ");
        String depthStr = scnr.nextLine();
        int depth = Integer.parseInt(depthStr);
        System.out.print("What is the radius of your well in inches?: ");
        String radiusStr = scnr.nextLine();
        Double radius = Double.parseDouble(radiusStr);
        double gallons;
        double  gallonsPerCf = 7.48;

        radius = radius / 12;
        gallons = (((Math.pow(radius, 2) * Math.PI) * depth) * gallonsPerCf);


        System.out.printf("Your well casing hold %f gallons. ", gallons);
        




    }

    private static void problem5(){
        int bmr;
        System.out.print("What is your gender? (M/F): ");
        String gender = scnr.nextLine();
        System.out.print("What is you age?: ");
        String ageStr = scnr.nextLine();
        System.out.print("What is your height in inches?: ");
        Double age = Double.parseDouble(ageStr);
        String heightStr = scnr.nextLine();
        Double height = Double.parseDouble(heightStr);
        System.out.print("What is your weight in pounds?: ");
        String weightStr = scnr.nextLine();
        Double weight = Double.parseDouble(weightStr);

        if (gender == "M"){
            yes
        }


    }
}
