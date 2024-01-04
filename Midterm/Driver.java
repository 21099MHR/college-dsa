import io.github.pixee.security.BoundedLineReader;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class Driver {

	static BufferedReader stdin = new BufferedReader (new InputStreamReader(System.in));
	
	public static <T> void main(String[] args) throws NumberFormatException, IOException, QueueException {
		
		QueueSLS<T> requests = new QueueSLS<T>();
		StackSLS<T> pending = new StackSLS<T>();
		
		int customerTotal = 0;
		
		int amazonTotal = 0;
		int teslaTotal = 0;
		int microsoftTotal = 0;
		
		
		
		System.out.print("Welcome to the Common A.T.M. Stock Exchange Center!\nEnter amount of Amazon stock available: ");
		int amazonStock = Integer.parseInt(BoundedLineReader.readLine(stdin, 5_000_000).trim());
		System.out.println(amazonStock);
		
		System.out.print("Enter amount of Tesla stock available: ");
		int teslaStock = Integer.parseInt(BoundedLineReader.readLine(stdin, 5_000_000).trim());
		System.out.println(teslaStock);
		
		System.out.print("Enter amount of Microsoft stock available: ");
		int microsoftStock = Integer.parseInt(BoundedLineReader.readLine(stdin, 5_000_000).trim());
		System.out.println(microsoftStock);
		
		System.out.println("\nSelect from the following menu:\n"
				+ " 0. Display Stock and Exit\n"
				+ " 1. Customer enters with request to buy stock\n"
				+ " 2. Customer enters with request to sell stock\n"
				+ " 4. Display customers waiting to be served and their requests\n"
				+ " 5. Display pending requests waiting to be processed\n"
				+ " 6. Process pending requests\n"
				+ " 7. Display number of customers that have been served\n"
				+ " 8. Display total amount of stock that has been traded\n");
		
		boolean switchOn = true;
		
		while(switchOn == true)
		{
		System.out.print("\nMake your selection now: ");	
		int selection = Integer.parseInt(BoundedLineReader.readLine(stdin, 5_000_000).trim());
		System.out.println(selection);
		
		switch(selection)
		{
		
		case 0:
			System.out.println("Stock left at closing: " + amazonStock + " Amazon, " + teslaStock + " Tesla, and "
					+ microsoftStock + " Microsoft\nBye!");
			switchOn = false;
			break;
			
		case 1:
			
			System.out.print("Welcome! Name, please: ");
			String name = BoundedLineReader.readLine(stdin, 5_000_000).trim();
			System.out.println(name);
			
			System.out.print("\nHow much Amazon stock do you want: ");
			int amazonBuy = Integer.parseInt(BoundedLineReader.readLine(stdin, 5_000_000).trim());
			System.out.println(amazonBuy);
			
			System.out.print("\nHow much Tesla stock do you want: ");
			int teslaBuy = Integer.parseInt(BoundedLineReader.readLine(stdin, 5_000_000).trim());
			System.out.println(teslaBuy);
			
			System.out.print("\nHow much Microsoft stock do you want: ");
			int microsoftBuy = Integer.parseInt(BoundedLineReader.readLine(stdin, 5_000_000).trim());
			System.out.println(microsoftBuy);
			
			Customer toBuy = new Customer(name, amazonBuy, teslaBuy, microsoftBuy);
			
			requests.enqueue(toBuy);
			
			System.out.println(name + " requesting " + amazonBuy + " Amazon, " + teslaBuy +  " Tesla, and " 
			+ microsoftBuy + " Microsoft stock is now waiting.");
			
			break;
			
		case 2:
			System.out.print("Welcome, your name, please: ");
			
			String nameSell = BoundedLineReader.readLine(stdin, 5_000_000).trim();
			
			System.out.print("\nHow much Amazon stock are you selling: ");
			int amazonSell = Integer.parseInt(BoundedLineReader.readLine(stdin, 5_000_000).trim());
			amazonStock += amazonSell;
			
			System.out.print("\nHow much Tesla stock are you selling: ");
			int teslaSell = Integer.parseInt(BoundedLineReader.readLine(stdin, 5_000_000).trim());
			teslaStock += teslaSell;
			
			System.out.println("\nHow much Microsoft stock are you selling: ");
			int microsoftSell = Integer.parseInt(BoundedLineReader.readLine(stdin, 5_000_000).trim());
			microsoftStock += microsoftSell;
			
			System.out.println("Thanks, " + nameSell + ", here is your receipt for the " + amazonSell + " Amazon, " + teslaSell 
					+ " Tesla, and " + microsoftSell + " Microsoft stock!");
			
			break;
			
		case 3:
			if(requests.isEmpty())
			{
				System.out.println("No customer is waiting to be served!");
			}
			else
			{
			Customer toServe = (Customer) requests.dequeue();
			String serveeName = toServe.name;
			
			int amazonToServe = toServe.amazonBuy;
			int teslaToServe = toServe.teslaBuy;
			int microsoftToServe = toServe.microsoftBuy;
			
			if((amazonStock < amazonToServe) || (teslaStock < teslaToServe) || (microsoftStock < microsoftToServe))
			{
				System.out.println(serveeName + "'s requests for " + amazonToServe + " Amazon, " + teslaToServe
						+ " Tesla, and " + microsoftToServe + " Microsoft stock is now pending. Goodbye, " + serveeName + 
						". We will let you\nknow when your request is processed!");
				pending.push(toServe);
			}
			else
			{
				System.out.println(serveeName + " is leaving with " + amazonToServe + " Amazon, " + teslaToServe + " Tesla, "
						+ "and " + microsoftToServe + " Microsoft stock.");
				
				customerTotal++;
				
				amazonTotal += amazonToServe;
				teslaTotal += teslaToServe;
				microsoftTotal += microsoftToServe;
			}
			}	
			break;
			
		case 4:			
			if(requests.isEmpty())
			{
				System.out.println("No customer is waiting to be served!");
			}
			else
			{
				System.out.println("The following customers are waiting to be served: ");
			Node<T> node = requests.front;
			
			while(node.getNext() != null)
			{
				Customer toPrint = (Customer) node.getItem();
				System.out.println(toPrint.toString());
				node = node.getNext();
			}
			}	
			break;
			
		case 5:			
			if(pending.isEmpty())
			{
				System.out.println("No customer is waiting to be served!");
			}
			else
			{
				System.out.println("The following requests are pending: ");

			Node<T> pendingNode = requests.front;
			
			while(pendingNode.getNext() != null)
			{
				Customer toPrint = (Customer) pendingNode.getItem();
				System.out.println((toPrint.toString()));
				pendingNode = pendingNode.getNext();
			}
			}
			break;
			
		case 6:
			
			if(pending.isEmpty())
			{
				System.out.println("No customer is waiting to be served!");
			}
			else
			{
			Customer pendingServe = (Customer) pending.peek();
			int amazonPending = pendingServe.amazonBuy;
			int teslaPending = pendingServe.teslaBuy;
			int microsoftPending = pendingServe.microsoftBuy;	
		
			
			if(pending.isEmpty())
			{
				System.out.println("No requests to process!");
			}
			else if((amazonStock >= amazonPending) && (teslaStock >= teslaPending) && (microsoftStock >= microsoftPending))
			{
			while((amazonStock >= amazonPending) && (teslaStock >= teslaPending) && (microsoftStock >= microsoftPending) && (pending.peek() != null))
			{
				String pendingName = pendingServe.name;
				
				System.out.println(pendingName + "'s request for " + amazonPending + " Amazon, " + teslaPending + " Tesla, and " + 
				microsoftPending + " Microsoft stock has been fulfilled and the customer has been notified.");
				
				pending.pop();
				customerTotal++;
			
				pendingServe = (Customer) pending.peek();
				pendingName = pendingServe.name;
				amazonPending = pendingServe.amazonBuy;
				teslaPending = pendingServe.teslaBuy;
				microsoftPending = pendingServe.microsoftBuy;	
			}
			}
			else
			{
				System.out.println("No request could be processed!");
			}
			}
			break;
			
		case 7:
			if(customerTotal == 0)
			{
				System.out.println("No customers have been served yet.");
			}
			else
			{
				System.out.print(customerTotal);
				if(customerTotal == 1)
				{
					System.out.println(" customer has been served.");
				}
				else
				{
					System.out.println(" customers have been served.");
				}
			}
			break;
			
		case 8:
			System.out.println("Total stock traded: " + amazonTotal + " Amazon, " + teslaTotal + " Tesla, and " 
		+ microsoftTotal + " Microsoft");
			break;
			
		default:
			
			break;
				
			
		}	
		}
	}
}
	


