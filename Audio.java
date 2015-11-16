/*
* Name: Nick Morrison, Roberto Temelkovski, Teo Voinea
* MacID: morrin2, temelkr, voineat
* Student Number: 1426613, 1418731, 1409586
* Description: File containing the Audio Class
*/

import java.util.ArrayList;
public class Audio extends Item{

    protected String artistName;
    protected String type;

    public Audio(int sNo,String name, String artistName, int price, int quantity){
        super(sNo,name,price,quantity);
        this.artistName = artistName;
    }

    @Override
    public int getPrice(){
	   return price;
    }
    
    @Override
    public String getInfo(){
	return sNo + ": " + artistName + " - " + name;
    }
    
    @Override
    public ArrayList toArray(){
	ArrayList re = new ArrayList();
	re.add(sNo);
	re.add(artistName);
	re.add(name);
	re.add(price);
	re.add(quantity);
	return re;
    }

}