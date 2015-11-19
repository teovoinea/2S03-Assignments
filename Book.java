/*
* Name: Nick Morrison, Roberto Temelkovski, Teodor Voinea
* MacID: morrin2, temelkr, voineat
* Student Number: 1426613, 1418731, 1409586
* Description: File containing the Book class
*/
//import required utilities
import java.util.*;

//Book class scaffolding extending the readable parent class
public class Book extends Readable{
	//variable to store the type
	String type;

	//constructor for book taking in serial number, name, authorname, price, quantity
	public Book(int sNo,String bookName, String authorName, int price, int quantity){
		//call the super class with the required variables
		super(sNo,bookName,authorName,price,quantity);
		//update the type variable
		type = "Book";
	}

	//override the abstract getPrice to include envirotax
	@Override
	public int getPrice(){
		//return the original price with envirotax added
		return (int) (1.02 * price);
	}
}