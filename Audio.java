package eCommerce;
/*
* Name: Nick Morrison, Roberto Temelkovski, Teo Voinea
* MacID: morrin2, temelkr, voineat
* Student Number: 1426613, 1418731, 1409586
* Description: File containing the Audio Class
*/

public class Audio extends Item{

    protected String artistName;
    protected String name;

    public int getPrice(){
	return price;
    }
    
    public String[] getInfo(){
	return new String[]{sNo + "", artistName, price, name, quantity};
    }

    public int getListInfo(){
	return 0;
    }

}