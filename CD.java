/*
* Name: Nick Morrison, Roberto Temelkovski, Teodor Voinea
* MacID: morrin2, temelkr, voineat
* Student Number: 1426613, 1418731, 1409586
* Description: File containing the item class
*/

//class scaffolding for CD inheriting from the parent class Audio
public class CD extends Audio {
    
    //constructor which takes in a serial number, name, artist name, price, quantity
	public CD(int sNo,String name, String artistName, int price, int quantity){
		//call the super function with appriopriate variables
		super(sNo,name,artistName,price,quantity);
		//update the type
		type = "CD";
                
	}

	//override the abstract getPrice to include envirotax
    @Override
    public int getPrice(){
    	//return the original price with envirotax added
		return (int)(price * 1.02);
    }

}
