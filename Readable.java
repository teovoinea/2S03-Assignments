/*
 * Name: Nick Morrison, Roberto Temelkovski, Teo Voinea
 * MacID: morrin2, temelkr, voineat
 * Student Number: 1426613, 1418731, 1409586
 * Description: File containing the Readable Class
 */
import java.util.*;

public class Readable extends Item {
	protected String authorName;

	public Readable(int sNo,String bookName, String authorName, int price, int quantity){
		super(sNo,bookName,price,quantity);
		this.authorName = authorName;
	}

	@Override
	public String getInfo(){
		// returns sNo,name, authorName, etc in a string
		return sNo + ": " + authorName + " - " + name;
	}

	@Override
	public int getPrice(){
		return price;
	}

	@Override
	public ArrayList<String> toArray(){
		ArrayList<String> info = new ArrayList<String>();
		info.add(sNo + "");
		info.add(name);
		info.add(authorName);
		info.add(price+"");
		info.add(quantity+"");
		return info;
	}
}