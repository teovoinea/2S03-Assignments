/*
* Name: Nick Morrison, Roberto Temelkovski, Teodor Voinea
* MacID: morrin2, temelkr, voineat
* Student Number: 1426613, 1418731, 1409586
* Description: File containing the item class
*/

//class scaffolding for MP3 inheriting from the parent class Audio
public class MP3 extends Audio{

	//constructor which takes in a serial number, name, artistname, price, quantity
	public MP3(int sNo,String name, String artistName, int price, int quantity){
		//call the super function with appropriate variables
		super(sNo,name,artistName,price,quantity);
		//update the type
		type = "MP3";
	}

	/*
	//not necessary, calls super by default
    public int getPrice(){
		return super.getPrice();
    }
    */

}