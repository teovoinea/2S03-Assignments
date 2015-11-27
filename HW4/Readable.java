/*
 * Name: Nick Morrison, Roberto Temelkovski, Teodor Voinea
 * MacID: morrin2, temelkr, voineat
 * Student Number: 1426613, 1418731, 1409586
 * Description: File containing the Readable Class
 */

//import the required utilities
import java.util.*;
//class scaffolding extending the Item parent class
public class Readable extends Item {
	//protected variable that exist for all readable objects
	protected String authorName;

	//constructor that takes in serial number, name of the readable object, author of the object, price, quantity of the object
	public Readable(int sNo,String bookName, String authorName, int price, int quantity){
		//construct by calling super
		super(sNo,bookName,price,quantity);
		//update the artist name
		this.authorName = authorName;
	}
	
	//override the parent class function
	@Override
	public int getPrice(){
		//return price variable
		return price;
	}

	//return all the attributes of the Readable object
	//as an arraylist of string
	@Override
	public ArrayList<String> getInfo(){
		//create arraylist of string to store the variables
		ArrayList<String> info = new ArrayList<String>();
		//append all class attributes to the arraylist
		info.add(sNo + "");
		info.add(name);
		info.add(authorName);
		info.add(price+"");
		info.add(quantity+"");
		//return arraylist of strings
		return info;
	}
}