/*
* Name: Nick Morrison, Roberto Temelkovski, Teo Voinea
* MacID: morrin2, temelkr, voineat
* Student Number: 1426613, 1418731, 1409586
* Description: File containing the ShoppingCart class
*/
public class ShoppingCart extends User{
	public ShoppingCart(){
	}
	private Item[] content;
	public Item[] getContent(){
		return content;
	}
	public void AddItem(Item b){
		Item[] temp = new Item[content.length + 1];
		for(int i = 0; i < content.length; i++){
			temp[i] = content[i];
		}
		temp[content.length] = b;
		content = new Item[temp.length];
		for (int i = 0; i < temp.length; i++){
			content[i] = temp[i];
		}
	}
}