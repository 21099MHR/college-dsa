/*
 * Purpose: Data Structure and Algorithms Lab X Problem Y [instantiate X and Y]
 * Status: Complete and thoroughly tested/Incomplete/ Barely started [choose only one!!!]
 * Last update: 4/14/20
 * Submitted:  4/14/20
 * Comment: test suite and sample run attached
 * @author: John Doe
 * @version: 2020.14.04
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.security.SecureRandom;
import java.util.Random;

public class Driver {



    static BufferedReader stdin = new BufferedReader (new InputStreamReader(System.in));


    public static void main(String[] args) throws NumberFormatException, IOException {
        boolean switchOn = true;
        int[] array = {0, 0, 0, 0, 0};
        Random rand = new SecureRandom();

        System.out.print("Welcome to the Sorting Program!\n"
                         + "What type of input would you like to use?"
                         + "\n1. User Input"
                         + "\n2. Random Input"
                         + "\n3. Exit Program\n");


        while(switchOn == true)
        {
            System.out.print("\nMake your selection now: ");
            int input = Integer.parseInt(stdin.readLine());
            System.out.println(input);

            switch(input)
            {
            case 1:
                System.out.println("Please insert your integers now: ");
                for(int i = 0; i < 5; i++)
                {
                    System.out.print("\nInteger " + i + ": ");
                    int toAdd = Integer.parseInt(stdin.readLine());
                    System.out.println(toAdd);
                    array[i] = toAdd;
                }

                bubbleSort(array);
                improvedBubbleSort(array);
                selectionSort(array);
                insertionSort(array);

                break;

            case 2:
                System.out.print("\nWhat upper bound do you want to set?"
                                 + "\nMake your selection now: ");
                int upperBound = Integer.parseInt(stdin.readLine());
                System.out.println(upperBound);

                while(upperBound <= 0)
                {
                    System.out.println("\nMust be a positive number!");
                    upperBound = Integer.parseInt(stdin.readLine()) + 1;
                }

                for(int i = 0; i < 5; i++)
                {
                    array[i] = rand.nextInt(upperBound);


                }

                System.out.print("\nOriginal Array: ");
                for(int i = 0; i < array.length; i++)
                {
                    if(i < array.length-1)
                    {
                        System.out.print(array[i] + ", ");
                    }
                    else
                    {
                        System.out.println(array[i]);
                    }
                }

                bubbleSort(array);
                improvedBubbleSort(array);
                selectionSort(array);
                insertionSort(array);
                break;

            case 3:
                switchOn = false;
                System.out.println("Exiting program... Goodbye!");
                break;
            default:
                break;
            }

        }
    }



    public static void bubbleSort(int[] array)
    {
        int[] cloneArray = array.clone();
        int count = 0;
        int comparisons = 0;
        int swaps = 0;

        for(int c = cloneArray.length-1; c > 0; c--)
        {
            count++;
            for(int i = cloneArray.length-1; i > 0; i--)
            {
                comparisons++;
                if(cloneArray[i] < cloneArray[i-1])
                {
                    int holding = cloneArray[i];
                    cloneArray[i] = cloneArray[i-1];
                    cloneArray[i-1] = holding;
                    swaps = swaps+2;
                }
            }
        }
        System.out.println("\nBubble Sort Loops: " + count);
        System.out.println("Swaps: " + swaps);
        System.out.println("Comparisons: " + comparisons);
        System.out.print("Sorted Array: ");
        for(int i = 0; i < cloneArray.length; i++)
        {
            if(i < array.length-1)
            {
                System.out.print(cloneArray[i] + ", ");
            }
            else
            {
                System.out.println(cloneArray[i] + "\n");
            }
        }
    }

    public static void improvedBubbleSort(int[] array)
    {
        int[] cloneArrayTwo = array.clone();
        int count = 0;
        int swaps = 0;
        int comparisons = 0;

        while
        ((	cloneArrayTwo[0] > cloneArrayTwo[1])
                || (cloneArrayTwo[1] > cloneArrayTwo[2])
                || (cloneArrayTwo[2] > cloneArrayTwo[3])
                || 	(cloneArrayTwo[3] > cloneArrayTwo[4]))
        {
            count++;
            for(int i = cloneArrayTwo.length-1; i > 0; i--)
            {
                comparisons++;
                if(cloneArrayTwo[i] < cloneArrayTwo[i-1])
                {
                    int holding = cloneArrayTwo[i];
                    cloneArrayTwo[i] = cloneArrayTwo[i-1];
                    cloneArrayTwo[i-1] = holding;
                    swaps = swaps+2;

                }
            }
        }

        System.out.println("Improved Bubble Sort Loops: " + count);
        System.out.println("Swaps: " + swaps);
        System.out.println("Comparisons: " + comparisons);
        System.out.print("Sorted Array: ");
        for(int i = 0; i < cloneArrayTwo.length; i++)
        {
            if(i < array.length-1)
            {
                System.out.print(cloneArrayTwo[i] + ", ");
            }
            else
            {
                System.out.println(cloneArrayTwo[i] + "\n");
            }
        }
    }

    public static void selectionSort(int[] array)
    {
        int[] cloneArrayThree = array.clone();

        int count = 0;
        int capture = 0;
        int length = cloneArrayThree.length-1;
        int swaps = 0;
        int comparisons = 0;

        for(int index = 0; index <= length; index++)
        {
            count++;
            for(int i = length; i > index; i--)
            {
                count++;
                comparisons++;
                if(cloneArrayThree[i] < cloneArrayThree[index])
                {
                    capture = cloneArrayThree[index];
                    cloneArrayThree[index] = cloneArrayThree[i];
                    cloneArrayThree[i] = capture;
                    swaps = swaps + 2;
                }
            }
        }

        System.out.println("\nSelection Sort Loops: " + count);
        System.out.println("Swaps: " + swaps);
        System.out.println("Comparisons: " + comparisons);
        System.out.print("Sorted Array: ");
        for(int i = 0; i < cloneArrayThree.length; i++)
        {
            if(i < array.length-1)
            {
                System.out.print(cloneArrayThree[i] + ", ");
            }
            else
            {
                System.out.println(cloneArrayThree[i] + "\n");
            }
        }


    }

    public static void insertionSort(int[]array)
    {
        int[] cloneArrayFour = array.clone();
        int count = 0;
        int capture = 0;
        int length = cloneArrayFour.length-1;

        int shifts = 0;
        int comparisons = 0;

        for(int x = 0; x <= length; x++)
        {   count++;
            for(int y = length; y >= x; y--)
            {
                count++;
                comparisons++;
                if(cloneArrayFour[y] < cloneArrayFour[x])
                {
                    capture = cloneArrayFour[y];
                    for(int i = y; i > x; i--)
                    {
                        cloneArrayFour[i] = cloneArrayFour[i-1];
                        shifts++;
                    }
                    cloneArrayFour[x] = capture;
                }
            }
        }

        System.out.println("\nInsertion Sort Loops: " + count);
        System.out.println("Shifts: " + shifts);
        System.out.println("Comparisons: " + comparisons);
        System.out.print("Sorted Array: ");
        for(int i = 0; i < cloneArrayFour.length; i++)
        {
            if(i < array.length-1)
            {
                System.out.print(cloneArrayFour[i] + ", ");
            }
            else
            {
                System.out.println(cloneArrayFour[i] + "\n");
            }
        }

    }

}

