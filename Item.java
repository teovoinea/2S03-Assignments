package eCommerce;

public abstract class Item{
	// fields
	protected int price;
	protected int sNo;

	public Item(int price, int sNo){
		this.price = price;
		this.sNo = sNo;
	}

	// methods
	public abstract String getInfo();
	public abstract int getPrice();
}