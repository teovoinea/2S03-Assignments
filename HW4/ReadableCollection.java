/*
 * Name: Nick Morrison, Roberto Temelkovski, Teodor Voinea
 * MacID: morrin2, temelkr, voineat
 * Student Number: 1426613, 1418731, 1409586
 * Description: File containing the ReadableCollection class
 */

//import required utilities
import java.util.ArrayList;

//ReadableCollection class scaffolding extending an ArrayList of Readable Items
public class ReadableCollection extends ArrayList<Readable>{

	//store a static instance of itself
	public static ReadableCollection instance;
	//double variable to store the environmental tax
	double eTax = 1.00;

	//constructor for ReadableCollection that takes an arraylist of strings
	//builds an arraylist of Audio Items from the arraylist of strings
	public ReadableCollection(ArrayList<ArrayList<String>> stringList){
		super(); //call super
		instance = this; //update the instance variables
		for (int i =0; i < stringList.size(); i++){ //loop through all the variables
			//check whether the current item to build is an eBook or Book
			if (stringList.get(i).get(5).equals("Book")){ //item is a Book
				add(new Book(Integer.parseInt(stringList.get(i).get(0)), //pass in the variables required to build the book, serial number
					     stringList.get(i).get(1) , //name
					     stringList.get(i).get(2), //author name
					     Integer.parseInt(stringList.get(i).get(3)), //price
					     Integer.parseInt(stringList.get(i).get(4)))); //quantity
				eTax += 0.02; //add 0.02 to envirotax
			}else if (stringList.get(i).get(5).equals("eBook")){ //item is a Book
				//add a new eBook object to the array
				add(new eBook(Integer.parseInt(stringList.get(i).get(0)), //pass in the variables required to build the eBook, serial number
					     stringList.get(i).get(1) , //name
					     stringList.get(i).get(2), //author name
					     Integer.parseInt(stringList.get(i).get(3)), //price
					     Integer.parseInt(stringList.get(i).get(4)))); //quantity
			}
		}
	}

	//create a getPrice function because it doesn't inherit from the Item parent class
	public int getTotalPrice(){
		//create an integer storage variable to store the final price
		int totalPrice = 0;
		//loop through each item in the audioCollection and sum the price
		for (int i = 0; i < size(); i++){
			totalPrice += get(i).getPrice();
		}
		//return the final price
		return totalPrice;
	}

	//find object by serial number
	public Readable findBysNo(int sNo){ //take in serial number to search for
		Readable read = new Readable(-1,"", "", -1, -1); //don't know if we still need this
		//loop through each audio item stored
		for (Readable r : this){ 
			//check if the serial numbers match
			if (sNo == r.sNo){
				//return the found audio object
				return r;
			}
		}
		//item wasn't found
		return null;
	}
}