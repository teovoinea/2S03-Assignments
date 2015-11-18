/*
* Name: Nick Morrison, Roberto Temelkovski, Teo Voinea
* MacID: morrin2, temelkr, voineat
* Student Number: 1426613, 1418731, 1409586
* Description: File containing the ShoppingCart class
*/
import java.util.*;
import java.io.*;
import java.text.SimpleDateFormat;
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
			String line; 
			while ((line = reader.readLine())!=null) {
				// Read next line for while condition 
				String[] split = line.split(",");
				Item item;
				int sNo = Integer.parseInt(split[0]);
				if(AudioCollection.instance.findBysNo(sNo) != null){
					AddItem(AudioCollection.instance.findBysNo(sNo));
				}
				else if(ReadableCollection.instance.findBysNo(sNo) != null){
					AddItem(ReadableCollection.instance.findBysNo(sNo));
				}								
			}
			reader.close();		      
		}catch (IOException e){
			e.printStackTrace();
		}
	}

	public void save(String username){
		try{
			BufferedWriter writer = new BufferedWriter(new FileWriter("cart["+username+"].txt"));
			HashMap<String,Integer> amounts = new HashMap<>();
			for(Item item : content){
				ArrayList<String> list = item.toArray();
				if(amounts.containsKey(list.get(0))){
					amounts.put(list.get(0),amounts.get(list.get(0)) + 1);					
				}else{
					amounts.put(list.get(0),1);					
				}				
				/*String line = list.get(0) + ""; 
				line += ", " + list.get(1).toString(); 
				line += ", " + list.get(2).toString(); 
				line += ", " + list.get(3).toString();
				line += ", " + list.get(4).toString();
				line += ", " + list.get(5).toString();*/

			}			
			ArrayList<Item> unique = new ArrayList<Item>();
			unique.add(content.get(0));

			for (Item i : content){
				boolean doAdd = true;
				for (Item u : unique){
					if (i.toArray().get(0).equals(u.toArray().get(0))){
						doAdd = false;
					}
				}
				if (doAdd){
					unique.add(i);
				}
			}
			for(Item i : unique){
				ArrayList<String> list = i.toArray();
				String line = list.get(0) + "," + list.get(2) + ",";
				String date = (new SimpleDateFormat("dd/MM/yyyy").format(new Date()));
				line += date + "," + amounts.get(list.get(0));	
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