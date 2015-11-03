import java.util.*;
public class eBook extends Readable{
	String type;

	public eBook(int sNo,String authorName, String bookName, int price, int quantity){
		super(sNo,authorName,bookName,price,quantity);
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