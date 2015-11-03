public class Book extends Readable{

	public Book(int price,int sNo,String authorName){
		super(price,sNo,authorName);
	}

	@Override
	// this won't work cause 1.02 is a float
	public int getPrice(){
		//return 1.02 * price;
		return price;
	}

	public int getListInfo(){
		//Based on the value of Type(Book or eBook) print the list of Items
		// What does that mean ?
		return 0;
	}
}