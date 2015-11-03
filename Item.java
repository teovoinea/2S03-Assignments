package eCommerce;

// ask about 2% tax always being an int for readables

// in Book.java ask about below statement
// Based on the value of Type(Book or eBook) print the list of Items
// What does that mean ?

// Book OO design says just add 2 % but under billing info, it has HST and shipping

// 	In eBook.java	
// override and only call the parent’s constructor to get the base price.
// ask about what that means

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