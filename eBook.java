/*
* Name: Nick Morrison, Roberto Temelkovski, Teodor Voinea
* MacID: morrin2, temelkr, voineat
* Student Number: 1426613, 1418731, 1409586
* Description: File containing the eBook class
*/
import java.util.*;
public class eBook extends Readable{ //CHANGE THIS TO EBook ROBERTOOO
	String type;

	public eBook(int sNo,String bookName, String authorName, int price, int quantity){
		super(sNo,bookName,authorName,price,quantity);
		type = "eBook";
	}

	/*
	@Override
	public int getPrice(){
	    return price;
	}
	*/
}