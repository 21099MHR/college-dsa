/*

 * Purpose: Data Structure and Algorithms Lab 3 Problem 1

 * Status: Complete and thoroughly tested

 * Last update: 02/11/20

 * Submitted:  02/11/20

 * Comment: test suite and sample run attached

 * @author: Matthew Ryan

 * @version: 2020.02.11

 */

import io.github.pixee.security.BoundedLineReader;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;

public class Driver {
    static BufferedReader stdin = new BufferedReader (new InputStreamReader(System.in));

    public static void main(String[] args) throws NumberFormatException, IOException {


        LinkedList<Object> items = new LinkedList<Object>();
        boolean switchOn = true;

        System.out.println("\nSelect from the following menu:"
                           + "\n\t1. Insert item to list\n\t2. Remove item from list"
                           + "\n\t3. Get item from list"
                           + "\n\t4. Clear list\n\t5. Print size and content of list"
                           + "\n\t6. Delete largest item in the list."
                           + "\n\t7. Reverse list" + "\n\t8. Exit program");

        while(switchOn == true)
        {
            System.out.print("\nMake your selection now: ");
            int selection = Integer.parseInt(BoundedLineReader.readLine(stdin, 5_000_000).trim());
            System.out.println(selection);

            switch(selection)
            {

            /*
             * Case 0 exists solely to test Problem 3.
             * It takes input from the Command Line, then
             * prints
             */
            case 0:
                System.out.print("1st String to test: ");
                String test1 = BoundedLineReader.readLine(stdin, 5_000_000);
                System.out.print(test1 + "\n2nd String to test: ");
                String test2 = BoundedLineReader.readLine(stdin, 5_000_000);
                System.out.println(test2);

                System.out.println("\n" + test1 + " compared to " + test2 + ": "
                                   + test1.compareTo(test2));

                break;

            case 1:
                System.out.print("\nYou are now inserting an item into the list.\n\tEnter item: ");
                Object item = BoundedLineReader.readLine(stdin, 5_000_000).trim();
                System.out.println(item);

                System.out.print("\tEnter position to insert item in: ");
                int index = Integer.parseInt(BoundedLineReader.readLine(stdin, 5_000_000).trim());
                System.out.println(index);

                if(index >= items.size()+1)
                {
                    System.out.println("\nPosition specified is out of range!");
                }
                else
                {
                    items.add(index, item);
                    System.out.println("\nItem " + item + " inserted at position " + index + " in the list.");
                }
                break;
            case 2:
                System.out.print("\tEnter position to remove item from: ");
                int toRemove = Integer.parseInt(BoundedLineReader.readLine(stdin, 5_000_000).trim());
                System.out.println(toRemove);

                if((toRemove >= items.size()) || (toRemove < 0))
                {
                    System.out.println("\nPosition specified is out of range!");
                }
                else
                {
                    System.out.println("\nItem " + items.get(toRemove) + " removed from position " + toRemove + " in the list.");
                    items.remove(toRemove);
                }
                break;
            case 3:
                System.out.print("\t\nEnter position to retrieve item from: ");
                int toRetrieve = Integer.parseInt(BoundedLineReader.readLine(stdin, 5_000_000).trim());
                System.out.println(toRetrieve);

                if((toRetrieve >= items.size()) || (toRetrieve < 0))
                {
                    System.out.println("\nPosition specified is out of range!");
                }
                else
                {
                    System.out.println("\nItem " + items.get(toRetrieve) + " retrieved from position " + toRetrieve + " in the list.");
                }
                break;
            case 4:
                items.removeAll(items);
                break;
            case 5:

                if(items.size() == 0)
                {
                    System.out.println("List is empty.");
                }
                else
                {
                    System.out.print("List of size " + items.size() + " has the following items: ");

                    for(int i = 0; i < items.size(); i++)
                    {
                        System.out.print(items.get(i) + " ");
                    }
                }
                break;

            case 6:
                if(items.size() == 0)
                {
                    System.out.println("List empty, nothing to delete!");
                }
                else
                {
                    String compare = "";
                    int removeIndex = 0;
                    for(int i = 0; i < items.size(); i++)
                    {
                        if(items.get(i).toString().compareTo(compare) > 0)
                        {
                            compare = items.get(i).toString();
                            removeIndex = i;
                        }
                    }
                    System.out.println("Largest item " + items.get(removeIndex).toString() + " deleted.");
                    items.remove(removeIndex);
                }
                break;

            case 7:

                if(items.size() == 0)
                {
                    System.out.println("List is empty... nothing to reverse!");
                }
                else
                {

                    for(int i = 0, k = items.size()-1; i < items.size()/2; i++, k--)
                    {
                        Object toFront = items.get(k);
                        Object toBack = items.get(i);

                        items.add(i, toFront);
                        items.remove(i+1);

                        items.add(k, toBack);
                        items.remove(k+1);
                    }

                    System.out.println("List reversed");
                }

                break;

            case 8:
                switchOn = false;
                System.out.print("Exiting program...Good Bye");
                break;


            default:

                break;
            }
        }

    }
}


