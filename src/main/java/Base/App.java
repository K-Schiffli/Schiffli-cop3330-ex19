/*
 *  UCF COP3330 Summer 2021 Assignment 1 Solutions
 *  Copyright 2021 Kevin Schiffli
 */
package Base;

import java.text.DecimalFormat;
import java.util.Scanner;

public class App {
    static Scanner in = new Scanner(System.in);

    public static void main( String[] args )
    {
        double weight = getNumber("weight in pounds");
        double height = getNumber("height in inches");
        double BMI = calcBMI(weight, height);
        printOutput(BMI);
    }
    public static double getNumber(String phrase)
    {
        System.out.printf( "Please enter your %s: ", phrase );
        String input = in.nextLine();

        boolean validFlag = false;
        while(!validFlag)
            try
            {
                Double.parseDouble(input);
                validFlag = true;
            }
            catch (NumberFormatException e)
            {
                System.out.println("Please enter a valid number: ");
                input = in.nextLine();
            }
        return Double.parseDouble(input);
    }

    public static double calcBMI(double weight, double height)
    {
        return (weight / (height * height)) * 703;
    }

    public static void printOutput(double BMI)
    {
        DecimalFormat decFormat = new DecimalFormat("#,###.##");
        String formattedBMI = decFormat.format(BMI);

        System.out.printf("Your BMI is %s.\n", formattedBMI);

        if (BMI < 18.5) System.out.print("You are underweight. You should see your doctor.");
        else if (BMI > 32.5) System.out.print("You are overweight. You should see your doctor.");
        else System.out.print("You are within the ideal weight range.");
    }
}
