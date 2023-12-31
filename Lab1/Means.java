/*

 * Purpose: Data Structure and Algorithms Lab 1 Problem 8

 * Status: Complete and thoroughly tested

 * Last update: 27/1/20

 * Submitted:  28/1/20

 * Comment: test suite and sample run attached

 * @author: Matthew Ryan

 * @version: 2020.28.1

 */

import io.github.pixee.security.BoundedLineReader;
import java.io.*;

public class Means {

    static BufferedReader stdin = new BufferedReader (new InputStreamReader(System.in));

    public static void main(String args[]) throws IOException
    {
        System.out.print("Enter number of pairs: ");
        int numberOfPairs = Integer.parseInt(BoundedLineReader.readLine(stdin, 5_000_000).trim());
        System.out.println(numberOfPairs);
        inputHandling(numberOfPairs);
    }

    public static void inputHandling(int numberOfPairs) throws IOException
    {
        float userInTotal = 0;
        float weightTotal = 0;

        int counter = 1;

        float weightToCalculate = 0;

        while(counter <= numberOfPairs)
        {
            System.out.print("Enter number " + counter + ": ");
            int	userIn = Integer.parseInt(BoundedLineReader.readLine(stdin, 5_000_000).trim());
            System.out.println(userIn);
            userInTotal += userIn;

            System.out.print("Enter weight " + counter + ": ");
            float weightIn = Float.parseFloat(BoundedLineReader.readLine(stdin, 5_000_000).trim());
            System.out.println(weightIn);
            weightTotal += weightIn;

            weightToCalculate += (userIn * weightIn);

            counter++;
        }
        if(numberOfPairs > 0)
        {
            arithmeticMean(numberOfPairs, userInTotal);
            weightedMean(weightToCalculate, weightTotal, numberOfPairs);
        }
        else
        {
            numberOfPairs = 0;
            System.out.println("Simple arithmetic mean of these " + numberOfPairs + " numbers is: " + numberOfPairs);
            System.out.println("Weighted arithmetic mean of these " + numberOfPairs + " numbers is: " + numberOfPairs );
        }
    }

    public static void arithmeticMean(int numberOfPairs, float userInput)
    {
        float arithmeticMean = (userInput/numberOfPairs);
        System.out.println("Simple arithmetic mean of these " + numberOfPairs + " numbers is: " + arithmeticMean);
    }

    public static void weightedMean(float weightToCalculate, float weightTotal, int numberOfPairs)
    {
        float weightedMean = (weightToCalculate/weightTotal);
        System.out.println("Weighted arithmetic mean of these " + numberOfPairs + " numbers is: " + weightedMean);
    }
}
