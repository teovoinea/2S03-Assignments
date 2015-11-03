/*
* Name: Nick Morrison, Roberto Temelkovski, Teo Voinea
* MacID: morrin2, temelkr, voineat
* Student Number: 1426613, 1418731, 1409586
* Description: File containing the item class
*/

// ask about 2% tax always being an int for readables

// in Book.java ask about below statement
// Based on the value of Type(Book or eBook) print the list of Items
// What does that mean ?

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
