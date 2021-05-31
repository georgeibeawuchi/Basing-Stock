
public class Product 
{
	//These state the names and the type of the data used.
	private String name;
	private int stockLevel;
	private double price;
	
	//This defines the content type's placeholder names.
	public Product(String nameIn, int stockLevelIn, double priceIn)
	{
		name = nameIn;
		stockLevel = stockLevelIn;
		price = priceIn;
	}
	
	//This is the calculation of the re-stock.
	public void reStock(int stockLevelIn)
	{
		stockLevel = stockLevel + stockLevelIn;
	}
	
	//This is the calculation of the selling.
	public double sell(int stockLevelIn)
	{
		return stockLevelIn * price;
	}
	
	//This is the definition of the price's placeholder.
	public void setPrice(double priceIn)
	{
		price = priceIn;
	}
	
	//This returns the name.
	public String getName()
	{
		return name;
	}
	
	//This returns the stock level.
	public int getStockLevel()
	{
		return stockLevel;
	}
	
	//This returns the price.
	public double getPrice()
	{
		return price;
	}
}