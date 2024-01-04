/*
 * Purpose: Data Structure and Algorithms Lab X Problem Y [instantiate X and Y]
 * Status: Complete and thoroughly tested/Incomplete/ Barely started [choose only one!!!]
 * Last update: 4/14/20
 * Submitted:  4/14/20
 * Comment: test suite and sample run attached
 * @author: John Doe
 * @version: 2020.14.04
 */

import java.awt.List;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;


public class Driver {
    static BufferedReader stdin = new BufferedReader (new InputStreamReader(System.in));

    public static void main(String[] args) throws NumberFormatException, IOException {
        boolean switchOn = true;
        Random rand = new SecureRandom();

        System.out.print("\nWelcome to the Sorting Program!"
                         + "\nPlease select select from the following:"
                         + "\n1. Manual input"
                         + "\n2. Random input"
                         + "\n3. Exit program");

        while(switchOn == true)
        {
            System.out.print("\n\nMake your selection now: ");
            int input = Integer.parseInt(stdin.readLine());

            int arraySize;
            int[] array;

            switch(input)
            {


            case 1:
                System.out.print("\nPlease enter the size of the array to Sort: ");

                arraySize = Integer.parseInt(stdin.readLine());
                array = new int[arraySize];

                /*
                 * Insert user-input ints here
                 */
                for(int i = 0; i < array.length; i++)
                {
                    System.out.println(array[i]);
                }

                mergeSort(array, 0, array.length-1);
                quickSort(array);
                break;

            case 2:
                System.out.print("\nPlease enter the size of the array to Sort: ");

                arraySize = Integer.parseInt(stdin.readLine());
                array = new int[arraySize];

                System.out.print("\nWhat upper bound do you want to set?"
                                 + "\nMake your selection now: ");
                int upperBound = Integer.parseInt(stdin.readLine());
                System.out.println(upperBound);

                while(upperBound <= 0)
                {
                    System.out.println("\nMust be a positive number!");
                    upperBound = Integer.parseInt(stdin.readLine()) + 1;
                }

                ArrayList<Integer> random = new ArrayList<Integer>(upperBound);

                for(int i = 0; i <= upperBound; i++)
                {
                    random.add(i);
                }

                Collections.shuffle(random);
                for(int toAdd = 0; toAdd < arraySize; toAdd++)
                {
                    array[toAdd] = random.get(toAdd);
                }

                mergeSort(array, 0, array.length-1);
                quickSort(array);
                break;

            case 3:
                switchOn = false;
                System.out.println("Exiting program... Goodbye");
                break;

            default:
                break;
            }
        }
    }

    public static void mergeSort(int[] array, int start, int end)
    {
        int[] cloneArray = array.clone();

        if(start < end)
        {
            int middle = (end - start)/2;
            mergeSort(array, start, middle);
            merge(array, start, middle, end);
        }

        System.out.print("Original Array: ");
        for(int originalArray = 0; originalArray < cloneArray.length; originalArray++)
        {
            {
                if(originalArray < cloneArray.length)
                {
                    System.out.print(cloneArray[originalArray] + ", ");
                }
                else
                {
                    System.out.println(cloneArray[originalArray] + "\n");
                }
            }
        }

        System.out.print("MergeSort Array: ");
        for(int originalArray = 0; originalArray < array.length; originalArray++)
        {
            {
                if(originalArray < array.length)
                {
                    System.out.print(array[originalArray] + ", ");
                }
                else
                {
                    System.out.println(array[originalArray] + "\n");
                }
            }
        }
    }

    private static void merge(int[] array, int start, int middle, int end) {
        int[] temp = new int[end-start+1];

        int startMark = start, midMark = middle+1, tempStart = 0;

        while(startMark <= middle && midMark <= end) {
            if(array[startMark] <= array[midMark]) {
                temp[tempStart] = array[startMark];
                tempStart += 1;
                startMark += 1;
            }
            else {
                temp[tempStart] = array[midMark];
                tempStart += 1;
                midMark += 1;
            }
        }

        while(startMark <= middle) {
            temp[tempStart] = array[startMark];
            tempStart += 1;
            startMark += 1;
        }

        while(midMark <= end) {
            temp[tempStart] = array[midMark];
            tempStart += 1;
            midMark += 1;
        }

        for(startMark = start; startMark <= end; startMark += 1) {
            array[startMark] = temp[startMark - start];
        }
    }

    private static void quickSort(int[] array) {
        int length = array.length-1;

        int counter = 1;

        int indexOne = 0;
        int indexTwo = 0;
        int indexThree = 0;

        int valueOne = 0;
        int valueTwo = 0;
        int valueThree = 0;

        Random rand = new SecureRandom();

        System.out.print("Original Array: ");
        for(int originalArray = 0; originalArray <= length; originalArray++)
        {
            {
                if(originalArray < array.length-1)
                {
                    System.out.print(array[originalArray] + ", ");
                }
                else
                {
                    System.out.println(array[originalArray] + "\n");
                }
            }
        }

        while(counter <= 3)
        {
            if(counter == 1)
            {
                indexOne = rand.nextInt(length+1);
                valueOne = array[indexOne];
            }
            else if(counter == 2)
            {
                indexTwo = rand.nextInt(length+1);
                while(indexTwo == indexOne)
                {
                    indexTwo = rand.nextInt(length+1);
                }
                valueTwo = array[indexTwo];
            }
            else
            {
                indexThree = rand.nextInt(length+1);
                while((indexThree == indexOne) || (indexThree == indexTwo))
                {
                    indexThree = rand.nextInt(length+1);
                }
                valueThree = array[valueThree];

            }

            counter++;
        }

        int pivotValue = 0;

        if(((valueOne < valueTwo) && (valueOne > valueThree)))
        {
            pivotValue = valueOne;
            valueTwo = valueThree = -1;
        }
        else if(((valueTwo < valueOne) && (valueTwo > valueThree)))
        {
            pivotValue = valueTwo;
            valueOne = valueThree = -1;
        }
        else
        {
            pivotValue = valueThree;
            valueOne = valueTwo = -1;
        }



        int storage = 0;
        int[] cloneArray = new int[length+1];

        for(int i = 0, front = 0, end = length; i <= length; i++)
        {
            int arrayValue = array[i];

            if(arrayValue < pivotValue)
            {
                cloneArray[front++] = array[i];
            }
            else if(arrayValue > pivotValue)
            {
                array[end--] = array[i];
            }

        }


        int pivotIndex = 0;
        boolean found = false;

        for(int pivotFind = 0; pivotFind <= length; pivotFind++)
        {
            if((cloneArray[pivotFind] == 0) && (pivotFind != 0) && (found == false))
            {
                if(valueOne > 0)
                {
                    pivotIndex = indexOne;
                }
                else if(valueTwo > 0)
                {
                    pivotIndex = indexTwo;
                }
                else
                {
                    pivotIndex = indexThree;
                }

                found = true;
            }
        }

        cloneArray[pivotIndex] = pivotValue;

        for(int lessThanPivot = 0; lessThanPivot < pivotIndex; lessThanPivot++)
        {
            if(cloneArray[lessThanPivot+1] <= cloneArray[lessThanPivot])
            {
                storage = cloneArray[lessThanPivot];
                cloneArray[lessThanPivot] = cloneArray[lessThanPivot+1];
                cloneArray[lessThanPivot+1] = storage;
            }
        }

        for(int greaterThanPivot = pivotIndex+1; greaterThanPivot < length; greaterThanPivot++)
        {
            if(cloneArray[greaterThanPivot] >= cloneArray[greaterThanPivot+1])
            {
                storage = cloneArray[greaterThanPivot+1];
                cloneArray[greaterThanPivot+1] = cloneArray[greaterThanPivot];
                cloneArray[greaterThanPivot] = storage;
            }
        }


        System.out.print("QuickSort Array: ");
        for(int quickSort = 0; quickSort <= length; quickSort++)
        {
            if(quickSort < cloneArray.length-1)
            {
                System.out.print(cloneArray[quickSort] + ", ");
            }
            else
            {
                System.out.println(cloneArray[quickSort] + "\n");
            }
        }

    }
}
