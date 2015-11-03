public class Book extends Readable{
	String type;

	public Book(int sNo,String authorName, String bookName, int price, int quantity){
		super(sNo,authorName,bookName,price,quantity);
		type = "Book";
	}

	// this won't work cause 1.02 is a float
	// maybe pass in price ?
	@Override
	public int getPrice(float eTax){
		//return 1.02 * price;
		return (int) eTax * price;
	}

	public int getListInfo(){
		//Based on the value of Type(Book or eBook) print the list of Items
		// What does that mean ?
		return 0;
	}

	public String[] getStringArray(){
		System.out.println(sNo + "");
	}
}