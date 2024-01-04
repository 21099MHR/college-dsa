/*
 * Purpose: Data Structure and Algorithms Lab 1 Problem 7
 * Status: Complete and thoroughly tested
 * Last update: 01/22/20
 * Submitted:  01/28/20
 * Comment: test suite and sample run attached
 * @author: Matthew Ryan
 * @version: 2020.28.1
 */

package myRLHelloClass;

import io.github.pixee.security.BoundedLineReader;
import java.io.*;
import java.lang.StringBuilder;

public class MyRLHelloClass {
	
	static BufferedReader stdin = new BufferedReader (new InputStreamReader(System.in));

	public static void main(String args[]) throws IOException
	{
		int userIn;
		String message;
		
		System.out.print("Enter number of people: ");
		userIn = Integer.parseInt(BoundedLineReader.readLine(stdin, 5_000_000));
		System.out.println(userIn);
		
		message = userInput(userIn);
		System.out.println(message);
	}
	
	public static String userInput(int userIn) throws IOException
	{
		int count = 1;
		String message = "";
		StringBuilder builder = new StringBuilder();

		while(count <= userIn)
		{
			System.out.print("Enter name number " + count + ": ");
			String name = BoundedLineReader.readLine(stdin, 5_000_000);
			System.out.println(name + "\n");
			message = processInput(builder, count, userIn, name).toString();
			count++;
		}
		
		return message;
	}
	
	public static StringBuilder processInput(StringBuilder message, int nameCount, int userInTotal, String name)
	{	
		
		if(userInTotal == 1)
		{
			{
				message.append(name + " shouts Hello Class!!!");
				return message;
			}
		}
		else if (nameCount == 1)
		{
			if (userInTotal == 2)
				message.append(name);
			else
				message.append(name + ", ");
		}
	

		if ((nameCount > 1) && (nameCount < userInTotal))	
		{
			message.append(name + ", ");
		}
		
		else if (nameCount == userInTotal)
		{
			message.append("and " + name + " shout Hello Class!!!");
		}
		
		return message;
	}
}
