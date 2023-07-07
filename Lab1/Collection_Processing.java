/*

 * Purpose: Data Structure and Algorithms Lab 1 Problem 9

 * Status: Complete and thoroughly tested

 * Last update: 1/28/20

 * Submitted:  1/28/20

 * Comment: test suite and sample run attached

 * @author: Matthew Ryan

 * @version: 2020.28.1

 */

import java.util.ArrayList;
import java.util.Iterator;
import java.util.ListIterator;
import java.io.*;

public class Collection_Processing {

    static BufferedReader stdin = new BufferedReader (new InputStreamReader(System.in));

    /*
     * The following is a menu designed to handle testing on the dataset.
     */

    public static void main(String[] args) throws IOException {
        ArrayList<Character> data = new ArrayList<Character>();

        boolean switchOn = true;
        while(switchOn == true)
        {
            System.out.println("Please select from the following:\n 1. Add \n\nFORWARD PROCESSING: \n 2. for \n 3. for-each \n 4. while \n 5. do-while \n 6. iterator \n\nREVERSE PROCESSING: \n 7. for \n 8. while \n 9. do-while \n 10. iterator \n\nPALINDROME TESTING \n 11. for \n 12. while \n 13. do-while \n 14. iterator \n\n 0. Exit");
            int select = Integer.parseInt(stdin.readLine());
	    System.out.println(select);
            switch(select)
            {
            case 1:
                data = add(data);
                break;
            case 2:
                displayForLoop(data);
                break;
            case 3:
                displayForEachLoop(data);
                break;
            case 4:
                displayWhileLoop(data);
                break;
            case 5:
                displayDoWhileLoop(data);
                break;
            case 6:
                displayIterator(data);
                break;
            case 7:
                displayReverseForLoop(data);
                break;
            case 8:
                displayReverseWhileLoop(data);
                break;
            case 9:
                displayReverseDoWhileLoop(data);
                break;
            case 10:
                displayReverseIterator(data);
                break;
            case 11:
                System.out.println("For loop palindrome test came back: " + testIfPalindromeForLoop(data));
                break;
            case 12:
                System.out.println("While loop palindrome test came back: " + testIfPalindromeWhileLoop(data));
                break;
            case 13:
                System.out.println(("Do While loop palindrome test came back: " + testIfPalindromeDoWhileLoop(data)));
                break;
            case 14:
                System.out.println("Iterator palindrome test came back: " + testIfPalindromeIterator(data));
                break;
            case 0:
                System.out.println("\nExiting! Farewell!");
                switchOn = false;
            default:
                System.out.println("Please select from the menu!\n");
                break;
            }
        }
    }
    public static ArrayList<Character> add(ArrayList<Character> data) throws IOException
    {
        System.out.println("\nEnter character to add: ");
        char toAdd = stdin.readLine().charAt(0);
	System.out.println(toAdd);
        data.add(toAdd);
        return data;
    }

    public static void displayForLoop(ArrayList<Character> data)
    {
        for(int i = 0; i < data.size(); i++)
        {
            System.out.println(data.get(i));
        }
    }

    public static void displayForEachLoop(ArrayList<Character> data)
    {
        data.forEach(Character -> System.out.println(Character));
    }

    public static void displayWhileLoop(ArrayList<Character> data)
    {
        int counter = 0;
        while(counter < data.size())
        {
            System.out.println(data.get(counter));
            counter++;
        }
    }

    public static void displayDoWhileLoop(ArrayList<Character> data)
    {
        int counter = 0;
        do
        {
            System.out.println(data.get(counter));
            counter++;
        } while(counter < data.size());
    }

    public static void displayIterator(ArrayList<Character> data)
    {
        Iterator<Character> it = data.iterator();
        while(it.hasNext())
        {
            System.out.println(it.next());
        }
    }

    /*
     * I found 5 different ways to process collections in Java, all with their own strengths and weaknesses.
     */
    
    public static void displayReverseForLoop(ArrayList<Character> data)
    {
        for(int i = data.size() - 1; i >= 0; i--)
        {
            System.out.println(data.get(i));
        }
    }

    public static void displayReverseWhileLoop(ArrayList<Character> data)
    {
        int counter = data.size() - 1;
        while(counter >= 0)
        {
            System.out.println(data.get(counter));
            counter--;
        }
    }

    public static void displayReverseDoWhileLoop(ArrayList<Character> data)
    {
        int counter = data.size() - 1;
        do
        {
            System.out.println(data.get(counter));
            counter--;
        } while (counter >= 0);
    }

    /*
     * Was unsure if this was doable; commented out to eventually come back to if it is.
     */

    //public static void displayReverseForEachLoop(ArrayList<Character> data)
    //{

    //}

    public static void displayReverseIterator(ArrayList<Character> data)
    {
        ListIterator<Character> it = data.listIterator(data.size());
        while(it.hasPrevious())
        {
            System.out.println(it.previous());
        }
    }

    /*
     * 4 of the 5 proceesses I could reuse for backwards iteration; I'm still a bit iffy on forEach.
     */

    public static boolean testIfPalindromeForLoop(ArrayList<Character> data)
    {

        boolean isPalindrome = true;
        int front = 0;
        int back = data.size()-1;

        for(; front < data.size(); )
        {


            if(data.get(front) != data.get(back))
            {
                isPalindrome = false;
                front += data.size();
            }
            else
            {
                front++;
                back--;
            }
        }

        return isPalindrome;
    }

    public static boolean testIfPalindromeWhileLoop(ArrayList<Character> data)
    {
        boolean isPalindrome = true;

        int counter = 0;

        while((counter < data.size() && (isPalindrome == true)))
        {
            if (data.get(counter) != data.get(data.size()-1-counter))
            {
                isPalindrome = false;
            }
            else
            {
                counter++;
            }
        }

        return isPalindrome;
    }

    public static boolean testIfPalindromeDoWhileLoop(ArrayList<Character> data)
    {
        boolean isPalindrome = true;
        int counter = 0;

        do
        {
            if (data.get(counter) != data.get(data.size()-1-counter))
            {
                isPalindrome = false;
            }
            else
            {
                counter++;
            }
        } while((counter < data.size() && (isPalindrome == true)));

        return isPalindrome;
    }

    public static boolean testIfPalindromeIterator(ArrayList<Character> data)
    {
        boolean isPalindrome = true;

        Iterator<Character> it = data.iterator();
        ListIterator<Character> li = data.listIterator(data.size());

        while((it.hasNext() && li.hasPrevious()) && isPalindrome == true)
        {
            if(it.next() != li.previous())
            {
                isPalindrome = false;
            }
        }
        return isPalindrome;
    }

    /*
     * Likewise, I could only find 4 ways to check for a palindrome since it was directly correlated with being able to process the array backwards.
     */
    
}

