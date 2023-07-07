
public class Item {
	private String name;
	private int amount;
	private int shelf;	
	private float price;
	
	public void setName(String userIn)
	{
		name = userIn;
	}
	
	public String getName()
	{
		return name;
	}
	
	public void setAmount(int userIn)
	{
		amount = userIn;
	}
	
	public int getAmount()
	{
		return amount;
	}

	public void setPrice(float userIn)
	{
		price = userIn;
	}
	
	public float getPrice()
	{
		return price;
	}
	
	public void setShelf(int userIn)
	{
		shelf = userIn;
	}
	
	public int getShelf()
	{
		return shelf;
	}
	
}
