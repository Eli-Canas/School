package New;


import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

public class Mini {
 
     
    /********
    ****1****
    ********/
    //Combine two strings and display the length of the combined string
    private static void combineStrings() {   
        Scanner scnr = new Scanner(System.in);
       
        System.out.print("Enter first string: ");
        String str1 = scnr.nextLine();
        System.out.print("Enter second string: ");
        String str2 = scnr.nextLine();

        String str3 = str1 + " " + str2;
        System.out.println(str3);

        int len1 = str3.length();
        System.out.println("Length of combined string: " + len1);
    }

    /********
    ****2****
    ********/
    //Replace all instances of "hate" with "love"
    private static void HateToLove(){
        Scanner scnr = new Scanner(System.in);
       
        System.out.print("Enter a string: ");
        String str1 = scnr.nextLine();
        String str2 = str1.replace("hate", "love");
        System.out.println("I have rephrased that line to read:");
        System.out.println(str2);

    }

    /********
    ****3****
    ********/

    //Mad Libs game
    private static void MadLib(){
        Scanner scnr = new Scanner(System.in);
        System.out.print("Whats you favorite color?: ");
        String color = scnr.nextLine();
        System.out.print("Whats your favorite food?: ");
        String food = scnr.nextLine();
        System.out.print("Whats you favorite animal?: ");
        String animal = scnr.nextLine();
        System.out.print("Enter someones name: ");
        String firstName = scnr.nextLine();
    
        System.out.printf("I had a dream that %s ate a %s %s and said it tasted like %s!", "\u001B[3m" + firstName + "\u001B[0m", "\u001B[3m" + color + "\u001B[0m", "\u001B[3m" + animal + "\u001B[0m", "\u001B[3m" + food + "\u001B[0m");
    }

    /********
    ****4****
    ********/
    //Calculate the volume of a well casing in gallons
    private static void WellCalculator(){
        Scanner scnr = new Scanner(System.in);
        System.out.print("How deep is your well in feet?: ");
        String depthStr = scnr.nextLine();
        int depth = Integer.parseInt(depthStr);
        System.out.print("What is the radius of your well in inches?: ");
        String radiusStr = scnr.nextLine();
        Double radius = Double.parseDouble(radiusStr);
        double gallons;
        double  gallonsPerCf = 7.48;

        radius = radius / 12;
        gallons = Math.round(((Math.pow(radius, 2) * Math.PI) * depth) * gallonsPerCf);


        System.out.printf("Your well casing hold %.1f gallons.\n", gallons);
    }

    /********
    ****5****
    ********/

    //Calculate BMR using Harris-Benedict equation
    private static void HarrisBenedict(){
        Scanner scnr = new Scanner(System.in);

        Double bmr;
    
        System.out.print("What is you age?: ");
        String ageStr = scnr.nextLine();
        System.out.print("What is your height in inches?: ");
        Double age = Double.parseDouble(ageStr);
        String heightStr = scnr.nextLine();
        Double height = Double.parseDouble(heightStr);
        System.out.print("What is your weight in pounds?: ");
        String weightStr = scnr.nextLine();
        Double weight = Double.parseDouble(weightStr);
        int chocolate = 230;

       
        bmr = (655 +(4.3 * weight) + (4.7 * height) + (4.7 * age)); 
        bmr = (bmr / chocolate);
        System.out.printf(("If you eat only chocolate you can eat %.1f bars to maintain weight as a Female.\n"),bmr );
    
        bmr = (66 +(6.3 * weight) + (12.9 * height) + (6.8 * age)); 
        bmr = (bmr / chocolate);
        System.out.printf(("If you eat only chocolate you can eat %.1f bars to maintain weight as a Male.\n"),bmr );
    }

    /********
    ****6****
    ********/

    //Determine the middle string in lexicographic order
    private static void lexicographicOrder(){
        Scanner scnr = new Scanner(System.in);
        System.out.print("First string: ");
        String str1 = scnr.nextLine();
        System.out.print("Second string: ");
        String str2 = scnr.nextLine();
        System.out.print("Third string: ");
        String str3 = scnr.nextLine();
        int result1 = str1.compareTo(str2);
        int result2; 
        
        
        if (result1 > 0){
            result2 = str2.compareTo(str3);
            if (result2 > 0){
                System.out.println(str2);
            }
            else{
                if (str1.compareTo(str3) > 0){
                    System.out.println(str3);
                }
                else{
                    System.out.println(str1);
                }
            }
        }
        else{
            result2 = str2.compareTo(str3);
            if (result2 > 0){
                if (str1.compareTo(str3) > 0){
                    System.out.println(str1);
                }
                else{
                    System.out.println(str3);
                }
            }
            else{
                System.out.println(str2);
            }
        }
    }
 
    /********
    ****7****
    ********/

    //A program that responds to user input in a specific way
    private static void oneLiner(){
        Scanner scnr = new Scanner(System.in);

        String userInput = scnr.nextLine();
        int index = userInput.length();
        
        if (userInput.endsWith("?")){
            if (index % 2 == 0){
                System.out.println("Yes.");
            }
            else{
                System.out.println("No.");
            }
        }
        else if (userInput.endsWith("!")){
            System.out.println("Wow.");
        }
        else{
            System.out.printf("You always say \"%s\".",userInput);
        }
    }

    /********
    ****8****
    ********/

    //Check if a date is valid
    private static void date(){
        Scanner scnr = new Scanner(System.in);
        System.out.print("Please enter a date (Format MM/DD/YYYY)");
        String date = scnr.nextLine();
        
        String monthStr;
        if (date.startsWith("0")){
            monthStr = date.substring(1, 2);
        }
        else{
            monthStr = date.substring(0, 2);
        }
        int month = Integer.parseInt(monthStr);
        
        String dayStr = date.substring(2, 5);
        int day = Integer.parseInt(dayStr);
        
        String yearStr = date.substring(6);
        int year = Integer.parseInt(yearStr);
        
        List<Integer> days31 = Arrays.asList(1, 3, 4, 7, 8, 10,12);
        List<Integer> days30 = Arrays.asList(4, 6, 9, 11);
        List<Integer> days28 = Arrays.asList(2);

        

        System.out.println(date);

        if (month > 0 && month <=12){
            if (days31.contains(month)){
                if (day > 0 && day <= 31){
                    System.out.println("Valid.");
                }
            }

        }
        else{
            System.out.println("Date not valid.");
        }
    }
   
    /********
    ****9****
    ********/
    
    //Calculate how many chocolate bars you can eat to maintain your weight
    private static void CalorieCounting(){
        Scanner scnr = new Scanner(System.in);
        Double bmr;
        System.out.print("What is your gender? (M/W): ");
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
        int chocolate = 230;

        if ((gender.toUpperCase()).equals("W")){
            bmr = (655 +(4.3 * weight) + (4.7 * height) + (4.7 * age)); 
            bmr = (bmr / chocolate);
            System.out.printf(("If you eat only chocolate you can eat %.1f bars to maintain weight.\n"),bmr );
            
        }
        else if ((gender.toUpperCase()).equals("M")){
            bmr = (66 +(6.3 * weight) + (12.9 * height) + (6.8 * age)); 
            bmr = (bmr / chocolate);
            System.out.printf(("If you eat only chocolate you can eat %.1f bars to maintain weight.\n"),bmr );


        }
        else{
            System.out.println("Not (M/W) please pick one of the two.");
        }
    }

    /*********
    ****10****
    *********/

    private static void LetterShift(){
    Scanner scnr = new Scanner(System.in);
        int count = 0;

        System.out.println("Enter words (type quit to stop):");

        while (true) {
            String word = scnr.nextLine().toLowerCase(); 

            if (word.equals("quit")) {
                break;
            }

            if (hasProperty(word)) {
                System.out.println(word + " has the property!");
                count++;
            } else {
                System.out.println(word + " does not have the property.");
            }
        }

        System.out.println("Total words found with property: " + count);
    }

    
    public static boolean hasProperty(String word) {
        if (word.length() < 2) return false;

        
        String transformed = word.substring(1) + word.charAt(0);

        
        String reversed = new StringBuilder(transformed).reverse().toString();

        
        return reversed.equals(word);
    }


    /*********
    ****11****
    *********/

    private static void Prizes(){
        
        Set<Integer> winners = new HashSet<>();
        while (winners.size() < 3) {
            int num = (int) (Math.random() * 10) + 1;
            winners.add(num);
        }
        
        System.out.println("The winners of the prizes are: ");
        for (int winner : winners) {
            System.out.println("Finalist " + winner);
        }
    }
    


    /*********
    ****12****
    *********/

    private static void ChocolateCoupon(){
        Scanner scnr = new Scanner(System.in);

        System.out.print("Enter dollars (N): ");
        int dollars = scnr.nextInt();

        chocolateFeast(dollars);
    }

    public static void chocolateFeast(int N) {
        int totalBars = N;      
        int coupons = N;        

        
        while (coupons >= 6) {
            int newBars = coupons / 6;     
            totalBars += newBars;          
            coupons = (coupons % 6) + newBars; 
        }

        System.out.println("Total chocolate bars eaten: " + totalBars);
        System.out.println("Coupons left over: " + coupons);
    }

    

// main just calls the helper
    public static void main(String[] args) {
        combineStrings();
        HateToLove();
        MadLib();
        WellCalculator();
        HarrisBenedict();
        lexicographicOrder();
        oneLiner();
        date(); //Could not get fully working
        CalorieCounting();
        LetterShift();
        Prizes();
        ChocolateCoupon();
    }
}

