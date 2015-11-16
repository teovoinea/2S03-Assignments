/*
* Name: Nick Morrison, Roberto Temelkovski, Teo Voinea
* MacID: morrin2, temelkr, voineat
* Student Number: 1426613, 1418731, 1409586
* Description: File containing the Audio Class
*/

public class Audio extends Item{

    protected String artistName;
    protected String name;

    public Audio(int sNo,String name, String artistName, int price, int quantity){
        super(sNo,name,price,quantity);
        this.artistName = artistName;
    }

    @Override
    public int getPrice(){
	   return price;
    }
    
    @Override
    public String[] getInfo(){
	   return new String[]{sNo + "", artistName, price, name, quantity};
    }

    public int getListInfo(){
	   return 0;
    }

}