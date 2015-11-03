/*
* Name: Nick Morrison, Roberto Temelkovski, Teo Voinea
* MacID: morrin2, temelkr, voineat
* Student Number: 1426613, 1418731, 1409586
* Description: File containing the Main class
*/
import java.util.*;
public class HWK4_voineat{
	private UserInterface ui = new UserInterface();
	private User user = new User();
	private ShoppingCart sc = new ShoppingCart();
	private ReadableCollection rc;
	private AudioCollection ac;
	public static void main(String[] args){
		init();
		ui.changeCurrentPage(1);
		String input = System.console().readline();
		if (input.equals("1")){
			System.out.println("Enter your username: ");
			String username = System.console().readline();
			user.setUsername(username);
			//if (username in Users.txt)
				//System.out.println("Hello Mr." + username);
				//return username;
			//else
				//System.out.println("");
				//System.out.println("No Access") 
				//return ""
		}
		else if (input.equals("2")){
			System.out.println("Choose your username: ");
			String username = System.console().readline();
			//add username to file
			System.out.println("Username succesfully added");
			return username;
		}
		else{
			return "";
		}
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
        	// do the thing
        }
	}
}