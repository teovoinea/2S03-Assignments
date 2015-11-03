/*
* Name: Nick Morrison, Roberto Temelkovski, Teo Voinea
* MacID: morrin2, temelkr, voineat
* Student Number: 1426613, 1418731, 1409586
* Description: File containing the UserInterface class
*/
import java.util.*;
public class UserInterface{
	private User user = new User();
	private ShoppingCart sc = new ShoppingCart();
	private ReadableCollection rc;
	private AudioCollection ac;
	public UserInterface(){
		init();
		ArrayList<String> users = readUser();
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
			String input = System.console().readline();
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
		String username = System.console().readline();
		//add username to file
		System.out.println("Username succesfully added");
		return true;
	}
	public boolean P3(){
		System.out.println("Enter your username: ");
		String username = System.console().readline();
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
		System.out.println("1. View Items By Category");
		System.out.println("2. View Shopping Cart");
		System.out.println("3. Sign Out");
		System.out.println("");
		System.out.println("Choose your option");
		/*
		String input = System.console().readline();
		if (input.equals("1")){
			return "P3";
		}
		else if (input.equals("2")){
			return "P4";
		}
		else if (input.equals("3")){
			return "P1";	
		}
		else{ return ""; }*/
	}

	public void P6(){
		System.out.println("1. Readables");
		System.out.println("2. Audio");
		System.out.println("");
		System.out.println("Choose your option: ");
		System.out.println("");
		System.out.println("Press -1 to return to previous menu");
	}

	public void P7(){
	}

	public void P8(){
		System.out.println("Readables: ");
		System.out.println("");
	}
	
	public void P9(){
		System.out.println("Audio: ");
		System.out.println("");
	}

	public void P10(){
		System.out.println("Billing Information: ");
	}
	public static void init(){
		ArrayList<ArrayList<String>> readables = new ArrayList<ArrayList<String>>();
		readables.add(readFile("Books"));
		readables.add(readFile("Ebooks"));
		ArrayList<ArrayList<String>> audio = new ArrayList<ArrayList<String>>();
		audio.add("CDs");
		audio.add("MP3");
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