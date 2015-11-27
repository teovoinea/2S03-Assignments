/*
* Name: Nick Morrison, Roberto Temelkovski, Teodor Voinea
* MacID: morrin2, temelkr, voineat
* Student Number: 1426613, 1418731, 1409586
* Description: File containing the AudioCollection Class
*/

//import required utilities
import java.util.ArrayList;

//AudioCollection class scaffolding extending an arraylist of Audio Items
public class AudioCollection extends ArrayList<Audio>{

	//store a static instance of itself
	public static AudioCollection instance;
	//double variable to store the environmental tax
    double eTax = 1.00;

    //constructor for AudioCollection that takes an arraylist of strings
    //builds an arraylist of Audio items from the arraylist of strings
    public AudioCollection(ArrayList<ArrayList<String>> stringList){
		super(); //call super
		instance = this; //update the instance variable
		for (int i =0; i < stringList.size(); i++){ //loop through all the variables in the stringlist variable
			//check whether the current item to build is a CD or an MP3
	    	if (stringList.get(i).get(5).equals("CD")){ //item is a CD
	    	//add a new CD Object to the array
			add(new CD(Integer.parseInt(stringList.get(i).get(0)), //pass in the variables for the CD constructor, serialNumber
			     stringList.get(i).get(1) , //name
			     stringList.get(i).get(2), //artist name
			     Integer.parseInt(stringList.get(i).get(3)), //price
			     Integer.parseInt(stringList.get(i).get(4)))); //quantity
			eTax += 0.02; //add 0.02 to envirotax
	    	}else if (stringList.get(i).get(5).equals("MP3")){ //item is a MP3
	    	//add a new MP3 Object to the array
			add(new MP3(Integer.parseInt(stringList.get(i).get(0)), //pass in the variables for the MP3 constructor, serialNumber
			     stringList.get(i).get(1), //name
			     stringList.get(i).get(2), //artist name
			     Integer.parseInt(stringList.get(i).get(3)), //price
			     Integer.parseInt(stringList.get(i).get(4)))); //quantity
	    	}
		}
    }

    //create a getPrice function because it doesn't inherit from the item class
    public int getPrice(){
    	//create an integer storage variable to store the final price
		int re = 0;
		//loop through each item in the audioCollection and sum the price
		for(int i = 0; i < size();i++){
		    re += get(i).getPrice();
		}
		//return the final price
		return re;
    }

    //find object by serial number
    public Audio findBysNo(int sNo){ //take in serial number to search for
        //TODO get rid of random audio and return null
        Audio audio = new Audio(-1,"", "", -1, -1); //don't know if we still need this
        //loop through each audio item stored
        for (Audio a : this){
        	//check if the serial numbers match
            if (sNo == a.sNo){
            	//return the found audio object
                return a;
            }
        }
        //item wasn't found
        return null;
    }

}