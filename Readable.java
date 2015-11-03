public class Readable extends Item {
	protected String authorName;

	public Readable(int sNo,String authorName, String bookName, int price, int quantity){
		super(sNo,name,price,quantity);
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
}