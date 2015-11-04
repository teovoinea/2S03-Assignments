/*
* Name: Nick Morrison, Roberto Temelkovski, Teo Voinea
* MacID: morrin2, temelkr, voineat
* Student Number: 1426613, 1418731, 1409586
* Description: File containing the UserInterface class
*/
//TODO: P10, P6
import java.util.*;
import java.io.*;
public class UserInterface{
	private User user = new User();
	private ShoppingCart sc = new ShoppingCart();
	static private ReadableCollection rc;
	//static private AudioCollection ac;
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
	public void P1(){
		boolean loop = true;
		while(loop){
			System.out.println("1. Sign in");
			System.out.println("2. Sign up");
			System.out.println("Choose your option: ");
			String input = scanner.nextLine();
			if (input.equals("1")){
				loop = P3();
				changeCurrentPage(3);
			}
			else if (input.equals("2")){
				loop = P2();
				changeCurrentPage(2);
			}
		}
	}
	public boolean P2(){
		System.out.println("Choose your username: ");
		String username = scanner.nextLine();
		//add username to file
		System.out.println("Username succesfully added");
		return true;
	}
	public boolean P3(){
		System.out.println("Enter your username: ");
		String username = scanner.nextLine();
		if (users.contains(username)){
			System.out.println("Hello Mr." + username);
			user.setUsername(username);
			return false;
		}
		else{
			return P4();
		}
	}
	public boolean P4(){
		System.out.println("");
		System.out.println("No Access");
		return true;
	}
	public void P5(){
		boolean loop = true;
		while(loop){
			System.out.println("1. View Items By Category");
			System.out.println("2. View Shopping Cart");
			System.out.println("3. Sign Out");
			System.out.println("");
			System.out.println("Choose your option");
			String input = scanner.nextLine();
			if (input.equals("1")){
				changeCurrentPage(6);
				loop = P6();
			}
			else if (input.equals("2")){
				changeCurrentPage(7);
				P7();
				loop = true;
			}
			else if (input.equals("3")){
				loop = false;
				P1();
				changeCurrentPage(1);
			}
		}
	}

	public boolean P6(){
		System.out.println("1. Readables");
		System.out.println("2. Audio");
		System.out.println("");
		System.out.println("Choose your option: ");
		System.out.println("");
		System.out.println("Press -1 to return to previous menu");
		String input = scanner.nextLine();
		if (input.equals("1")){
			//readables
		}
		else if (input.equals("2")){
			//audio
		}
		else if (input.equals("-1")){
			//previous menu
			P5();
		}
	}

	public void P7(){
		System.out.println(sc.toString());
	}

	public void P8(){
		System.out.println("Readables: ");
		System.out.println("");
		System.out.format("%4s%32d%6d%10d%32d%5s", output_sno, output_name, output_author, output_price, output_quantity, output_type);
		for (Readable i : rc) {
			ArrayList al = i.toArray();
			System.out.format("%4s%32d%6d%10d%32d%5s", al.get(1), al.get(2), al.get(3), al.get(4), al.get(5));
		}
		System.out.println("Choose your option: ");
		System.out.println("Press -1 to return to previous menu.");
		String input = scanner.nextLine();
		if (input.equals("-1")){
			P6();
		}
		else{
			try{
				int num = Integer.parseInt(input);
				if (num > 0 && num < rc.size()){
					String quantity = scanner.nextLine();
					try{
						int qty = Integer.parseInt(quantity);
						for (int i = 0; i < qty; i++){
							sc.AddItem(rc.get(num));
						}
						System.out.println(qty + " " + rc.get(num).toArray().get(3) + " " + "succesfully added to your cart.");
						String next = scanner.nextLine();
						if (next.equals("0")){
							P10();
						}
						else if (next.equals("-2")){
							P6();
						}
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
		}
	}
	
	public void P9(){
		System.out.println("Audio: ");
		System.out.println("");
		System.out.format("%4s%32d%6d%10d%32d%5s", output_sno, output_name, output_artist, output_price, output_quantity, output_type);
		/*for (Audio i : ac) {
			ArrayList al = i.toArray();
			System.out.format("%4s%32d%6d%10d%32d%5s",al.get(1), al.get(2), al.get(3), al.get(4), al.get(5));
		}
		System.out.println("Choose your option: ");
		System.out.println("Press -1 to return to previous menu.");
		String input = scanner.nextLine();
		if (input.equals("-1")){
			P6();
		}
		else{
			try{
				int num = Integer.parseInt(input);
				if (num > 0 && num < rc.size()){
					String quantity = scanner.nextLine();
					try{
						int qty = Integer.parseInt(quantity);
						for (int i = 0; i < qty; i++){
							sc.AddItem(rc.get(num));
						}
						System.out.println(qty + " " + rc.get(num).toArray().get(3) + " " + "succesfully added to your cart.");
						String next = scanner.nextLine();
						if (next.equals("0")){
							P10();
						}
						else if (next.equals("-2")){
							P6();
						}
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
		}
		*/
	}

	public void P10(){
		System.out.println("Billing Information: ");
	}
	public static void init(){
		ArrayList<ArrayList<String>> readables = new ArrayList<ArrayList<String>>(readFile("Books"));
		readables.addAll(readFile("Ebooks"));
		ArrayList<ArrayList<String>> audio = new ArrayList<ArrayList<String>>(readFile("CDs"));
		audio.addAll(readFile("MP3"));
		rc = new ReadableCollection(readables);
		ac = new AudioCollection(audio);
	}
	public static ArrayList<ArrayList<String>> readFile(String type){
		ArrayList<ArrayList<String>> stringlist = new ArrayList<ArrayList<String>>(); 
		BufferedReader reader;
		try {
        	reader = new BufferedReader(new FileReader(type + ".txt"));
            String line = reader.readLine();

            while (line!=null) {
                // Print read line
                System.out.println(line);
                stringlist.add(new ArrayList<String>(Arrays.asList(line.split(", "))));
                // Read next line for while condition
                line = reader.readLine();
            }
            reader.close();
            return stringlist;
        }catch (IOException e){
        	e.printStackTrace();
        }
	}
	public ArrayList<String> readUser(){
		ArrayList<String> lines = new ArrayList<String>();
		try (BufferedReader br = new BufferedReader(new FileReader("Users.txt"))) {
			String line;
			while ((line = br.readLine()) != null){
				lines.add(line);
			}
		}
		return lines;
	}
}
