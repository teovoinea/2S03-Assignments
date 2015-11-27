/*
* Name: Nick Morrison, Roberto Temelkovski, Teodor Voinea
* MacID: morrin2, temelkr, voineat
* Student Number: 1426613, 1418731, 1409586
* Description: File containing the Audio Class
*/

//import the required utilities
import java.util.ArrayList;
//class scaffolding extending the Item parent class
public class Audio extends Item{

    //protected variables that exist for all audio objects
    protected String artistName;
    protected String type;

    //constructor that takes in serial number, name of the audio object, name of the artist, price and quantity
    public Audio(int sNo,String name, String artistName, int price, int quantity){
        //construct by calling super
        super(sNo,name,price,quantity);
        //update the artist name
        this.artistName = artistName;
    }

    //override the parent class function
    @Override
    public int getPrice(){
        //return price variable
	   return price;
    }

    //return all the attributes of the audio object
    //as an arraylist of strings
    @Override
    public ArrayList<String> getInfo(){
        //create arraylist of string to store the variables
    	ArrayList<String> re = new ArrayList<String>();
        //append all class attributes to the arraylist
    	re.add(sNo + "");
    	re.add(artistName);
    	re.add(name);
    	re.add(price+"");
    	re.add(quantity+"");
    	re.add(type);
        //return arraylist of strings
    	return re;
    }
}