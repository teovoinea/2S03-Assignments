public class eBook extends ​Readable{
	public eBook(int price,int sNo,String authorName){
		super(price,sNo,authorName);
	}

	@Override
	public int getPrice(){
		// override and only call the parent’s constructor to get the base price.
		// ask about what that means
	}
}