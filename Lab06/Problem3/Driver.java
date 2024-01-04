/*

 * Purpose: Data Structure and Algorithms Lab 6 Problem 3

 * Status: Complete and thoroughly tested

 * Last update: 03/03/2020

 * Submitted:  03/03/2020

 * Comment: test suite and sample run attached

 * @author: Matthew Ryan

 * @version: 2020.03.03

 */

import io.github.pixee.security.BoundedLineReader;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class Driver {
    static BufferedReader stdin = new BufferedReader (new InputStreamReader(System.in));

    public static <T> void main(String[] args) throws NumberFormatException, IOException, QueueException {


        Bag<T> bag = new Bag<T>();
        SampleBag<T> samples = new SampleBag<T>();

        boolean switchOn = true;

        System.out.println("\nSelect from the following menu:"
                           + "\n\t0. Exit."
                           + "\n\t1. Pick up an order."
                           + "\n\t2. Drop off an order."
                           + "\n\t3. Display number of packages and weight of bag."
                           + "\n\t4. Display number of items and weight of the bag of samples."
                           + "\n\t5. Enjoy an item from the bag of samples."
                           + "\n\t6. Enjoy all the samples in the bag of samples.\r\n");

        while(switchOn == true)
        {
            System.out.print("\nMake your selection now: ");
            int selection = Integer.parseInt(BoundedLineReader.readLine(stdin, 5_000_000).trim());
            System.out.println(selection);

            switch(selection)
            {

            case 0:
                switchOn = false;
                System.out.println("Exiting program...Good Bye");
                break;

            case 1:

                String name = "";
                String sender = "";
                String recipient = "";
                float weight = 0;
                int amount = 0;

                System.out.println("Please specify info: ");

                System.out.print("Item name: ");
                name = BoundedLineReader.readLine(stdin, 5_000_000).trim();
                System.out.println(name);

                System.out.print("\nItem weight: ");
                weight = Float.parseFloat(BoundedLineReader.readLine(stdin, 5_000_000).trim());
                System.out.println(weight);

                System.out.print("\n# of items: ");
                amount = Integer.parseInt(BoundedLineReader.readLine(stdin, 5_000_000).trim());
                System.out.println(amount);

                System.out.print("\nSender: ");
                sender = BoundedLineReader.readLine(stdin, 5_000_000).trim();
                System.out.println(sender);

                System.out.print("\nRecipient: ");
                recipient = BoundedLineReader.readLine(stdin, 5_000_000).trim();
                System.out.println(recipient);

                Package pack = new Package(name, weight, amount, sender, recipient);
                bag.pickUpOrder(pack);
                System.out.println("A package of " + name + " each weighing " + weight + " lbs are now in the bag.");
                break;
            case 2:

                if(bag.getBag().isEmpty())
                {
                    System.out.println("No deliveries to process!");
                }
                else
                {
                    Package dropOff = (Package) bag.getBag().dequeue();


                    float newWeight = bag.getWeight() - (dropOff.getItemWeight() * dropOff.getItemAmount());
                    int newPackages = bag.getPackages()-1;

                    bag.setWeight(newWeight);
                    bag.setPackages(newPackages);


                    System.out.print("Here is your package " + dropOff.getItemReceiver() + ". May I keep a sample (Y/N)? ");
                    String response = BoundedLineReader.readLine(stdin, 5_000_000);
                    System.out.print(response);

                    while(!((response.toUpperCase().equals("Y") || (response.toUpperCase().equals("N")))))
                    {
                        System.out.print("Please say (Y)es or (No)! ");
                        response = BoundedLineReader.readLine(stdin, 5_000_000).trim();
                        System.out.println(response);
                    }

                    System.out.println("\nYour package contains: ");

                    if(dropOff.getItemAmount() == 1)
                    {
                        System.out.println("A " + dropOff.getItemName() + " weighing " + dropOff.getItemWeight()
                                           + " from " + dropOff.getItemSender() + " to " + dropOff.getItemReceiver());
                    }
                    else
                    {
                        System.out.println(dropOff.getItemAmount() + " " + dropOff.getItemName()
                                           + "s each weighing " + dropOff.getItemWeight()
                                           + " from " + dropOff.getItemSender() + " to " + dropOff.getItemReceiver());
                    }

                    if((response.toUpperCase().equals("Y")))
                    {
                        System.out.println(" Thanks for letting me keep a " + dropOff.getItemName() + "!");
                        Package sample = new Package(dropOff.getItemName().toString(), dropOff.getItemWeight(), 1, dropOff.getItemSender(), dropOff.getItemReceiver());
                        samples.pickUpOrder(sample);
                    }
                    else
                    {
                        System.out.println(" Thanks anyway.");
                    }
                }

                break;
            case 3:
                System.out.println("Bag has " + bag.getPackages() + " packages and weights " + bag.getWeight() + " lbs.");
                break;
            case 4:
                System.out.println("Sample bag has " + samples.getPackages() + " packages and weights " + samples.getWeight() + " lbs.");

                break;
            case 5:
                if(bag.getBag().isEmpty())
                {
                    System.out.println("No samples to enjoy!");
                }
                else
                {
                    Package sample = (Package) samples.getBag().pop();

                    float newWeight = samples.getWeight() - sample.getItemWeight();
                    int newPackages = samples.getPackages()-1;

                    samples.setWeight(newWeight);
                    samples.setPackages(newPackages);

                    System.out.println("This " + sample.getItemName() + " is amazing! I love free stuff!");
                }
                break;
            case 6:
                if(samples.getBag().isEmpty())
                {
                    System.out.println("Sample bag is already empty.");
                }
                else
                {
                    samples.getBag().popAll();
                    samples.setPackages(0);
                    samples.setWeight(0);
                    System.out.println("Sample bag has been emptied.");
                }
                break;

            default:
                break;
            }
        }
    }
}


