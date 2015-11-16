/*
* Name: Nick Morrison, Roberto Temelkovski, Teo Voinea
* MacID: morrin2, temelkr, voineat
* Student Number: 1426613, 1418731, 1409586
* Description: File containing the ShoppingCart class
*/
import java.util.*;
import java.io.*;
public class ShoppingCart extends User{
	private ArrayList<Item> content;

	public ShoppingCart(String username){
		content = new ArrayList<>();
		load(username);
	}
	public Item[] getContent(){
		return content;
	}
	public void AddItem(Item b){
		content.add(b);
	}
	

	void load(String username){
		BufferedReader reader;
		try {
			reader = new BufferedReader(new FileReader("cart["+username + "].txt"));
			String line = reader.readLine();

			while (line!=null) {
				// Read next line for while condition
				line = reader.readLine();
				String[] split = line.split(", ");
				Item item;
				switch(split[5]){
				case "MP3":
					item = new MP3(split[0],split[1],split[2],split[3],split[4],split[5]);
					break;
				case "CD":
					item = new CD(split[0], split[1], split[2], split[3], split[4], split[5]);
					break;
				case "eBook":
					item = new eBook(split[0],split[1],split[2],split[3],split[4],split[5]);
					break;
				case "Book":
					item = new Book(split[0],split[1],split[2],split[3],split[4],split[5]);
					break;
				}
				AddItem(item);
			}
			reader.close();		      
		}catch (IOException e){
			e.printStackTrace();
		}
	}

	public void save(String username){
		try{
			BufferedWriter writer = new BufferedWriter(new FileWriter("cart["+username+"].txt"));
			for(Item item : content){
				ArrayList<String> list = item.toArray();
				String line = list.get(0) + "," + list.get(1) + "," + list.get(2) + "," + list.get(3) + "," + list.get(4) + "," + list.get(5);
				writer.write(line + "\n");
			}
			writer.close();
		}catch(IOException e){
			e.printStackTrace();
		}
	}

	@Override
	public String toString(){
		String out = "";
		for(int i = 0; i < content.length; i++){
			out += content[i].toString() + '\n';
		}
		return out;
	}
}