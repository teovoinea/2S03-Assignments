import java.util.*;
public class eBook extends Readable{ //CHANGE THIS TO EBook ROBERTOOO
	String type;

	public eBook(int sNo,String bookName, String authorName, int price, int quantity){
		super(sNo,bookName,authorName,price,quantity);
		type = "eBook";
	}

	@Override
	public ArrayList<String> toArray(){
		ArrayList<String> info = new ArrayList<String>();
		info.add(sNo + "");
		info.add(authorName);
		info.add(name);
		info.add(price+"");
		info.add(quantity+"");
		info.add(type);

		return info;
	}

	@Override
	public int getPrice(){
	    return (int)(price * 1.02);
	}
}