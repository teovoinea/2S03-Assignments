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
		return sNo + ": " + authorName + " " + authorName;
	}

	@Override
	public int getPrice(){
		return price;
	}

	@Override
	public ArrayList toArray(){
		ArrayList info = new ArrayList();
		info.add(sNo);
		info.add(authorName);
		info.add(name);
		info.add(price);
		info.add(quantity);

		return info;
	}
}