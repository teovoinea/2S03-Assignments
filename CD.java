/*
* Name: Nick Morrison, Roberto Temelkovski, Teo Voinea
* MacID: morrin2, temelkr, voineat
* Student Number: 1426613, 1418731, 1409586
* Description: File containing the item class
*/

public class CD extends Audio {
    
	public CD(int sNo,String name, String artistName, int price, int quantity){
		super(sNo,name,artistName,price,quantity);
		type = "CD";
                
	}

    @Override
    public int getPrice(){
	return (int)(price * 1.02);
    }

}
