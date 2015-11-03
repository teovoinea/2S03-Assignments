/*
* Name: Nick Morrison, Roberto Temelkovski, Teo Voinea
* MacID: morrin2, temelkr, voineat
* Student Number: 1426613, 1418731, 1409586
* Description: File containing the item class
*/
package eCommerce;

public class CD extends Audio {
    
    @Override
    public int getPrice(){
	return price * 1.02;
    }

}