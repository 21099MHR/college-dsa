
/*

 * Purpose: Data Structure and Algorithms Lab 6 Problem 2

 * Status: Complete and thoroughly tested

 * Last update: 03/03/2020

 * Submitted:  03/03/2020

 * Comment: test suite and sample run attached

 * @author: Matthew Ryan

 * @version: 2020.03/03

 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Driver {
    static BufferedReader stdin = new BufferedReader (new InputStreamReader(System.in));

    public static <T> void main(String[] args) throws NumberFormatException, IOException, QueueException {

        DEQ<T> queue = new DEQ<T>();

        System.out.println("Select from the following: "
                           + "\n\t0. Exit"
                           + "\n\t1. Insert item at back"
                           + "\n\t2. Insert item at front"
                           + "\n\t3. Remove item from front"
                           + "\n\t4. Remove item from back"
                           + "\n\t5. Display front item"
                           + "\n\t6. Display last item"
                           + "\n\t7. Clear collection"
                           + "\n\t8. Display content of collection");

        boolean switchOn = true;
        T result;

        while(switchOn == true)
        {
            System.out.print("\n\nMake your selection now: ");
            int selection = Integer.parseInt(stdin.readLine());
            System.out.println(selection);
            switch(selection)
            {
            case 0:
                switchOn = false;
                System.out.println("\nExiting program... Goodbye!");
                break;
            case 1:
                System.out.print("\nItem to be added at back: ");
                Object newItem = stdin.readLine();
                System.out.println(newItem);
                queue.enqueue(newItem);
                System.out.println(newItem + " has been added to back of queue.");
                break;

            case 2:
                System.out.print("\nItem to be added at front: ");
                Object frontItem = stdin.readLine();
                System.out.println(frontItem);
                queue.enqueueFirst(frontItem);
                System.out.println(frontItem + " has been added to front of queue.");
                break;

            case 3:
                result = queue.dequeue();
                if(result == null)
                {
                    System.out.println("Queue empty!");
                }
                else
                {
                    System.out.println("\n" + result +
                                       " has been removed from the front of the queue.");
                }
                break;

            case 4:

                result = queue.dequeueLast();
                if(result == null)
                {
                    System.out.println("Queue empty!");
                }
                else
                {
                    System.out.println("\n" + result +
                                       " has been removed from the back of the queue.");
                }

                break;

            case 5:
                result = queue.peek();
                if(result == null)
                {
                    System.out.println("Queue empty!");
                }
                else
                {
                    System.out.println("\nFront item of queue: " + result);
                }
                break;

            case 6:
                result = queue.peekLast();
                if(result == null)
                {
                    System.out.println("Queue empty!");
                }
                else
                {
                    System.out.println("\nBack item of queue: " + result);
                }
                break;
            case 7:
                queue.dequeueAll();
                System.out.println("\nQueue cleared.");
                break;

            case 8:
                if(queue.numItems == 0)
                {
                    System.out.println("Queue empty!");
                }
                else
                {
                    System.out.println("\nContents of queue: " + queue.toString());
                }
                break;

            default:
                break;
            }

        }


    }

}
