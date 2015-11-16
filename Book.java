import java.util.*;

public class Book extends Readable{
	String type;

	public Book(int sNo,String bookName, String authorName, int price, int quantity){
		super(sNo,bookName,authorName,price,quantity);
		type = "Book";
	}

	// this won't work cause 1.02 is a float
	// maybe pass in price ?
	//@Override
	public int getPrice(float eTax){
		//return 1.02 * price;
		return (int) eTax * price;
	}

	public int getListInfo(){
		//Based on the value of Type(Book or eBook) print the list of Items
		// What does that mean ?
		return 0;
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


	public String[] getStringArray(){
	    return new String[]{sNo+"",authorName,name,price+"",quantity+"",type};
	}
}