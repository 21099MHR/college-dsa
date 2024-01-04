
/*
 * Purpose: Data Structure and Algorithms Lab 12 Problems 1/2
 * Status: Complete
 * Last update: 4/30/20
 * Submitted:  04/30/20
 * Comment: Completed with testbed.
 * @author: Matthew Ryan
 * @version: 2020.04.30
 */

import io.github.pixee.security.BoundedLineReader;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.SocketTimeoutException;

public class Driver {

	static BufferedReader stdin = new BufferedReader(new InputStreamReader(System.in));

	public static void main(String[] args) throws NumberFormatException, IOException {

		HashTable<String, Integer> table = new HashTable<String, Integer>();

		System.out.println("Welcome to the Hashing Program!\nPlease select from the following."
				+ "\n\n\t0. Exit Program" + "\n\t1. Insert a symbol with an associated value in the table."
				+ "\n\t2. Delete a symbol from the table."
				+ "\n\t3. Retrieve and display the value associated with a symbol key from the table."
				+ "\n\t4. Display hashCode of a symbol key." + "\n\t5. Display content of the symbol table.");

		boolean switchOn = true;
		while (switchOn == true) {
			System.out.print("\nMake your selection now: ");
			int input = Integer.parseInt(BoundedLineReader.readLine(stdin, 5_000_000));
			System.out.println(input);
			
			switch (input) {
			case 0:
				switchOn = false;
				System.out.println("Exiting program... Goodbye!");
				break;

			case 1:
				System.out.print("Please specify\nKey: ");
				String key = BoundedLineReader.readLine(stdin, 5_000_000);
				System.out.println(key);

				System.out.print("\nValue: ");
				int value = Integer.parseInt(BoundedLineReader.readLine(stdin, 5_000_000));
				System.out.println(value);

				if(table.tableInsert(key, value) == false)
				{
					System.out.println("Key already exists in table.");
				}
				else
				{
					System.out.println("Key " + key + " with value of " + value + " has been inserted.");
				}
				break;

			case 2:
				System.out.print("Please specify Key to delete: ");
				String deleteKey = BoundedLineReader.readLine(stdin, 5_000_000);
				System.out.println(deleteKey);
				
				if (table.tableDelete(deleteKey) == true) {
					System.out.println(deleteKey + " has been deleted.");
				} else {
					System.out.println("Key not found.");
				}

				break;

			case 3:
				System.out.print("Please specify key to retrieve: ");
				String retrieveKey = BoundedLineReader.readLine(stdin, 5_000_000);
				System.out.println(retrieveKey);
				
				Integer retrieveValue = table.tableRetrieve(retrieveKey);
				if (retrieveValue == null) {
					System.out.println("Key not found.");
				} else {
					System.out.println("Value of " + retrieveKey + ": " + retrieveValue);
				}

				break;

			case 4:

				System.out.print("Please specify which key to display hashCode of: ");
				String hashKey = BoundedLineReader.readLine(stdin, 5_000_000);
				System.out.println(hashKey);
				
				if (table.tableRetrieve(hashKey) == null) {
					System.out.println("Key not found in table.");
				} else {
					System.out.println("HashKey of " + hashKey + ": " + table.hashCode(hashKey));
				}

				break;

			case 5:
				System.out.println("Contents of symbol table: " + table.toString());
				break;

			default:

				break;
			}

		}

	}

}
