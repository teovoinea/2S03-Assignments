/*
* Name: Nick Morrison, Roberto Temelkovski, Teo Voinea
* MacID: morrin2, temelkr, voineat
* Student Number: 1426613, 1418731, 1409586
* Description: File containing the item class
*/

public class MP3 extends Audio{

	public MP3(int sNo,String name, String artistName, int price, int quantity){
		super(sNo,name,artistName,price,quantity);
		type = "MP3";
	}

	/*
    public int getPrice(){
		return super.getPrice();
    }
    */

}