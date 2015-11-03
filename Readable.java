public class Readable extends Item {
	protected​ String authorName;

	public Readable(int price,int sNo,String authorName){
		super(price,sNo);
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