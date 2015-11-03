package eCommerce;
/*
* Name: Nick Morrison, Roberto Temelkovski, Teo Voinea
* MacID: morrin2, temelkr, voineat
* Student Number: 1426613, 1418731, 1409586
* Description: File containing the item class
*/

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
