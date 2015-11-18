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
	public ArrayList<Item> getContent(){
		return content;
	}
	public void AddItem(Item b){
		content.add(b);
	}

	public int itemCount(String sNo){
		int count = 0;
		for (int i = 0; i < content.size(); i++){
			if (content.get(i).toArray().get(0).equals(sNo)){
				count++;
			}
		}
		return count;
	}
	

	private void load(String username){
		File file = new File("cart["+username+"].txt");
		if(!file.exists()){
			System.out.println("here");
			return;
		}
		BufferedReader reader;
		try {
			reader = new BufferedReader(new FileReader("cart["+username + "].txt"));
			String line = reader.readLine();

			while (line!=null) {
				// Read next line for while condition 
				String[] split = line.split(", ");
				Item item;
				switch(split[5]){
				case "MP3":
					item = new MP3(Integer.parseInt(split[0]),split[1],split[2],Integer.parseInt(split[3]),Integer.parseInt(split[4]));
					AddItem(item);
					break;
				case "CD":
					item = new CD(Integer.parseInt(split[0]),split[1],split[2],Integer.parseInt(split[3]),Integer.parseInt(split[4]));
					AddItem(item);
					break;
				case "eBook":
					item = new eBook(Integer.parseInt(split[0]),split[1],split[2],Integer.parseInt(split[3]),Integer.parseInt(split[4]));
					AddItem(item);
					break;
				case "Book":
					item = new Book(Integer.parseInt(split[0]),split[1],split[2],Integer.parseInt(split[3]),Integer.parseInt(split[4]));
					AddItem(item);
					break;
				}
				line = reader.readLine();	
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
				String line = list.get(0) + ""; 
				line += ", " + list.get(1).toString(); 
				line += ", " + list.get(2).toString(); 
				line += ", " + list.get(3).toString();
				line += ", " + list.get(4).toString();
				line += ", " + list.get(5).toString();
				System.out.println(line);
				writer.write(line + "\n");
			}
			writer.close();
			System.out.println("SAVE");
		}catch(IOException e){
			e.printStackTrace();
		}
	}

	@Override
	public String toString(){
		System.out.println("Shopping Cart: ");
		System.out.println("");
		String out = "";
		for(Item item: content){
			ArrayList<String> list = item.toArray();
			out += list.get(0).toString() + "," + list.get(1).toString() + "," + list.get(2).toString() + "," + list.get(3).toString() + "," + list.get(4).toString() + "," + list.get(5).toString() + "\n";
		}
		return out;
	}
}