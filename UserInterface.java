/*
* Name: Nick Morrison, Roberto Temelkovski, Teodor Voinea
* MacID: morrin2, temelkr, voineat
* Student Number: 1426613, 1418731, 1409586
* Description: File containing the UserInterface class
*/
import java.util.*;
import java.io.*;
public class UserInterface{
	private User user = new User();
	private ShoppingCart sc;
	static private ReadableCollection rc;
	static private AudioCollection ac;
	Scanner scanner = new Scanner(System.in);
	ArrayList<String> users;
	private static String output_sno = "S.No";
	private static String output_name = "Name";
	private static String output_artist = "Artist";
	private static String output_author = "Author";
	private static String output_price = "Price($)";
	private static String output_quantity = "Quantity";
	private static String output_type = "Type";
	public UserInterface(){
		init();
		users = readUser();
	}
	private int currentPage;
	public int getCurrentPage(){
		return currentPage;
	}
	public void changeCurrentPage(int c){
		if (c > 0 && c < 11){
			currentPage = c;
		}
	}

	//Sign in menu
	public String P1(){
		System.out.println("1. Sign in");
		System.out.println("2. Sign up");
		System.out.println("Choose your option: ");
		String input = scanner.nextLine();
		return input;
	}
	public void P2(){
		System.out.println("Choose your username: ");
		String username = scanner.nextLine();
		try{
			BufferedWriter writer = new BufferedWriter(new FileWriter("Users.txt"));
			for(String user : users){
				writer.write(user + "\n");
			}
			writer.write(username);
			writer.close();
		}catch(IOException ex){
			System.err.println(ex.getMessage());
		}
		users.add(username);		
		//add username to file
		System.out.println("Username succesfully added");
	}
	public String P3(){
		System.out.println("Enter your username: ");
		String username = scanner.nextLine();
		return username;
	}
	public void P4(){
		System.out.println("");
		System.out.println("No Access");
	}

	public String P5(){
		System.out.println("1. View Items By Category");
		System.out.println("2. View Shopping Cart");
		System.out.println("3. Sign Out");
		System.out.println("");
		System.out.println("Choose your option");
		String input = scanner.nextLine();
		return input;
	}

	public String P6(){
		System.out.println("1. Readables");
		System.out.println("2. Audio");
		System.out.println("");
		System.out.println("Choose your option: ");
		System.out.println("");
		System.out.println("Press -1 to return to previous menu");
		String input = scanner.nextLine();
		return input;
	}

	public void P7(){
		System.out.println(sc.toString());
	}

	public String P8(){
		System.out.println("Readables: ");
		System.out.println("");
		System.out.format("%4s%-28s%-8s%-10s%32s%-5s\n", output_sno + "  ", output_name + "  ", output_author + "  ", output_price + "  ", output_quantity + "  ", output_type);
		for (Readable i : rc) {
			ArrayList al = i.toArray();
			System.out.format("%4s%-32s%-6s%10s%32s%5s\n",al.get(0) + "  ", al.get(1) + "  ", al.get(2) + "  ", al.get(3) + "  ", al.get(4) + "  ", al.get(5));
		}
		System.out.println("Choose your option: ");
		System.out.println("Press -1 to return to previous menu.");
		String input = scanner.nextLine();
		return input;
	}

	public String P9(){
		System.out.println("Audio: ");
		System.out.println("");
		System.out.format("%4s%-32s%-8s%-10s%32s%-5s\n", output_sno + "  ", output_name + "  ", output_artist + "  ", output_price+"  ", output_quantity+"  ", output_type);
		for (Audio i : ac) {
			ArrayList al = i.toArray();
			System.out.format("%4s%-32s%-6s%10s%32s%5s\n",al.get(0)+"  ", al.get(1)+"  ", al.get(2)+"  ", al.get(3)+"  ", al.get(4)+"  ",al.get(5));
		}
		System.out.println("Choose your option: ");
		System.out.println("Press -1 to return to previous menu.");
		String input = scanner.nextLine();
		return input;
	}

	public boolean P10(){
		System.out.println("Billing Information: ");
		System.out.format("%-32s%-10s%-15s\n","Name: ", "Quantity: ", "Price: ");
		ArrayList<Item> unique = new ArrayList<Item>();
		unique.add(sc.getContent().get(0));

		for (Item i : sc.getContent()){
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

		for (Item i: unique){
			System.out.format("%-32s%-10d%-15s\n", i.toArray().get(2), sc.itemCount(i.toArray().get(0)),i.toArray().get(3));
		}

		double totalEnviroTax = 0;
		double hst = 0;
		double shipping = 0;
		double total = 0;
		for (Item i: sc.getContent()){
			// QUESTION TO ASK
			// DO WE USE DOUBLES OR NAH
			// ALSO DO EBOOKS AND MP3S HAVE SHIPPING
			double price = Double.parseDouble(i.toArray().get(3));
			totalEnviroTax += i.getPrice() - price;
			hst += price * 0.13;
			if (i.toArray().get(5).equals("CD") || i.toArray().get(5).equals("Book")){
				shipping += price * 0.1;
			}
			total += price;
		}
		total += hst + shipping + totalEnviroTax;
		System.out.format("%32s%-10s%-15.02f\n","Environment Tax  ", "2%", totalEnviroTax);
		System.out.format("%32s%-10s%-15.02f\n","HST  ", "13%", hst);
		System.out.format("%32s%-10s%-15.02f\n","Shipping  ", "10%", shipping);
		System.out.format("%32s%-10s%-15s\n","", "", "_________");		
		System.out.format("%32s%-10s%-15.02f\n","Total  ", "", total);

		System.out.println("Are you sure you want to pay? yes or no.");
		String input = scanner.nextLine();
		if (input.toLowerCase().equals("yes")){
			System.out.println("Confirmation ID: U1000");
			System.out.println("Items shipped to: " + user.getUsername());
		}
		else{
			System.out.println("Bye");
		}
	return false;
	}
	public static void init(){
		getAudioProducts();
		getReadables();
	}
	public static void getAudioProducts(){
		ArrayList<ArrayList<String>> audio = new ArrayList<ArrayList<String>>(readFile("CDs"));
		audio.addAll(readFile("MP3"));
		ac = new AudioCollection(audio);
	}
	public static void getReadables(){
		ArrayList<ArrayList<String>> readables = new ArrayList<ArrayList<String>>(readFile("Books"));
		readables.addAll(readFile("Ebooks"));
		rc = new ReadableCollection(readables);
	}
	public static ArrayList<ArrayList<String>> readFile(String type){
		ArrayList<ArrayList<String>> stringlist = new ArrayList<ArrayList<String>>(); 
		BufferedReader reader;
		try {
		    reader = new BufferedReader(new FileReader(type + ".txt"));
		    String line = reader.readLine();
		    
		    while (line!=null) {
			// Print read line
			//System.out.println(line);
			stringlist.add(new ArrayList<String>(Arrays.asList(line.split(", "))));
			// Read next line for while condition
			line = reader.readLine();
		    }
	    reader.close();
		    return stringlist;
		}catch (IOException e){
		    e.printStackTrace();
		}
		return stringlist;
	}
	public ArrayList<String> readUser(){
		ArrayList<String> lines = new ArrayList<String>();
		try (BufferedReader br = new BufferedReader(new FileReader("Users.txt"))) {
			String line;
			while ((line = br.readLine()) != null){
				lines.add(line);
			}
		}
		catch(IOException e){
			e.printStackTrace();
		}
		return lines;
	}
	public String checkLogin(String username){
		if (users.contains(username)){
			System.out.println("Welcome, " + username);
			sc = new ShoppingCart(username);    
			user.setUsername(username);
			return "5";
		}
		else{
			return "4";
		}
	}

	public String buyReadable(String input){
		try{
			int num = Integer.parseInt(input);
			if (num > 0){
				System.out.println("Enter the quantity: ");
				String quantity = scanner.nextLine();
				try{
					int qty = Integer.parseInt(quantity);
				    Readable readA = rc.findBysNo(num);
				    if (num == Integer.parseInt(readA.toArray().get(0))){
						for (int i = 0; i < qty; i++){
						    sc.AddItem(readA);
						}
				    }
						System.out.println(qty + " " + readA.toArray().get(2) + " " + "succesfully added to your cart.");
					sc.save(user.getUsername());
					System.out.println("Press -2 to Continue Shopping or Press 0 to CheckOut: ");
					String next = scanner.nextLine();
					return next;
				}
				catch (Exception e) {
					e.printStackTrace();
				}
			}
			else{

			}
		}
		catch (Exception e){
			e.printStackTrace();
		}
		return null;
	}

	public String buyAudio(String input){
		try{
			int num = Integer.parseInt(input);
			if (num > 0){
				System.out.println("Enter the quantity: ");
				String quantity = scanner.nextLine();
				try{
					int qty = Integer.parseInt(quantity);
					Audio audioA = ac.findBysNo(num);
				    if (num == Integer.parseInt(audioA.toArray().get(0))){
						for (int i = 0; i < qty; i++){
						    sc.AddItem(audioA);
						}
				    }
   					System.out.println(qty + " " + audioA.toArray().get(2) + " " + "succesfully added to your cart.");
					sc.save(user.getUsername());
					System.out.println("Press -2 to Continue Shopping or Press 0 to CheckOut: ");
					String next = scanner.nextLine();
					return next;
				}
				catch (Exception e) {
					e.printStackTrace();
				}
			}
			else{

			}
		}
		catch (Exception e){
			e.printStackTrace();
		}
		return null;
	}
}
