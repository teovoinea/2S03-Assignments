import java.util.*;
public class eBook extends Readable{ //CHANGE THIS TO EBook ROBERTOOO
	String type;

	public eBook(int sNo,String bookName, String authorName, int price, int quantity){
		super(sNo,bookName,authorName,price,quantity);
		type = "eBook";
	}

	@Override
	public ArrayList toArray(){
		ArrayList info = new ArrayList();
		info.add(sNo);
		info.add(authorName);
		info.add(name);
		info.add(price);
		info.add(quantity);
		info.add(type);

		return info;
	}

	@Override
	public int getPrice(){
		// override and only call the parent's constructor to get the base price.
		// ask about what that means
	}
}