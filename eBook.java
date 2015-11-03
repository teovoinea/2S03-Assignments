public class eBook extends ​Readable{
	String type;

	public eBook(int sNo,String authorName, String bookName, int price, int quantity){
		super(sNo,authorName,bookName,price,quantity);
		type = "eBook";
	}

	@Override
	public int getPrice(){
		// override and only call the parent’s constructor to get the base price.
		// ask about what that means
	}
}