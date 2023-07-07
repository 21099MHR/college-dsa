
public class Customer {
	
	protected String name;
	protected int amazonBuy;
	protected int teslaBuy;
	protected int microsoftBuy;
	
	public Customer(String name, int amazonBuy, int teslaBuy, int microsoftBuy)
	{
		this.name = name;
		this.amazonBuy = amazonBuy;
		this.teslaBuy = teslaBuy;
		this.microsoftBuy = microsoftBuy;
	}
	
	public String toString()
	{
		return name + " requesting " + amazonBuy + " Amazon, " + teslaBuy + " Tesla, and " + microsoftBuy + " Microsoft stock";
		
	}
}
