/*
* Name: Nick Morrison, Roberto Temelkovski, Teodor Voinea
* MacID: morrin2, temelkr, voineat
* Student Number: 1426613, 1418731, 1409586
* Description: File containing the UserInterface class
*/

//Import required utilities
import java.util.*;
import java.io.*;
//Class scaffolding
public class UserInterface{
	private User user = new User(); //create a private instance of the user class (used for username)
	private ShoppingCart sc; //create a private instance of the ShoppingCart class
	static private ReadableCollection rc; //create a private instance of custom ReadableCollection class
	static private AudioCollection ac; //create a private instance of custome AudioCollection class
	Scanner scanner = new Scanner(System.in); //create scanner object for user input
	ArrayList<String> users; //create an arraylist of all user
	//Output Strings for consistency
	private static String output_sno = "S.No";
	private static String output_name = "Name";
	private static String output_artist = "Artist";
	private static String output_author = "Author";
	private static String output_price = "Price($)";
	private static String output_quantity = "Quantity";
	private static String output_type = "Type";
	//UserInterface constructor
	public UserInterface(){
		init(); //call init function 
		users = readUser(); //store all the users that have ever signed in
	}
	//private int to store the current page
	private int currentPage;
	//public getter for private int currentPage
	public int getCurrentPage(){
		//return private int currentPage
		return currentPage;
	}
	//Setter to modify the current page
	public void changeCurrentPage(int c){
		//sanity check to make sure we're not trying to change pages we don't need
		if (c > 0 && c < 11){
			//set current page
			currentPage = c;
		}
	}

	//Initial menu
	public String P1(){
		//Print options
		System.out.println("1. Sign in");
		System.out.println("2. Sign up");
		System.out.println("Choose your option: ");
		//grab user input
		String input = scanner.nextLine();
		//return user input
		return input;
	}
	//Sign up menu
	public void P2(){
		//Print prompt
		System.out.println("Choose your username: ");
		//grab user input
		String username = scanner.nextLine();
		//Try to write the new username to Users.txt
		try{
			//create buffered writer to write to Users.txt
			BufferedWriter writer = new BufferedWriter(new FileWriter("Users.txt"));
			//write all the previous users because the file is being completely overwritten
			for(String user : users){
				//write each user on a new line
				writer.write(user + "\n");
			}
			//write new user
			writer.write(username);
			writer.close(); //close the buffered writer
		}catch(IOException ex){ //catch any IO Exceptions
		    System.err.println("Error: Unable to write the username to file \"Users.txt\"");
		    return;
		}
		//add the new username to the arraylist of users
		users.add(username);		
		//confirm user has been added
		System.out.println("Username succesfully added");
	}
	//Sign in menu
	public String P3(){
		//Prompt for username
		System.out.println("Enter your username: ");
		String username = scanner.nextLine(); //grab user input
		return username; //return user input
	}
	//In the case the username is invalid
	public void P4(){
		//Output that there is no access
		System.out.println("");
		System.out.println("No Access");
	}
	//Main menu
	public String P5(){
		//Print options for user
		System.out.println("1. View Items By Category");
		System.out.println("2. View Shopping Cart");
		System.out.println("3. Sign Out");
		System.out.println("");
		//Prompt user
		System.out.println("Choose your option");
		String input = scanner.nextLine(); //grab user input
		return input; //return user input
	}
	//View Items By Category Menu
	public String P6(){
		//Print options for user
		System.out.println("1. Readables");
		System.out.println("2. Audio");
		System.out.println("");
		//prompt user
		System.out.println("Choose your option: ");
		System.out.println("");
		System.out.println("Press -1 to return to previous menu");
		String input = scanner.nextLine(); //grab user input
		return input; //return user input
	}
	//print shopping cart screen
	public void P7(){
		//use overloaded shopping cart method toString to print the contents
		System.out.println(sc.toString());
	}

	//print readable options menu
	public String P8(){
		//print readables
		System.out.println("Readables: ");
		System.out.println("");
		//Using string formatting to make a nice table
		//and using the preset (and consistent) output variables
		//print the table header
		System.out.format("%4s%-28s%-8s%-10s%32s%-5s\n", output_sno + "  ", output_name + "  ", output_author + "  ", output_price + "  ", output_quantity + "  ", output_type);
		for (Readable i : rc) { //for each readable in the readable collection
			ArrayList al = i.getInfo(); //get the info of the current readable object
			//Using string formatting to follow the table header above
			//print the necessary information for the current item
			System.out.format("%4s%-32s%-6s%10s%32s%5s\n",al.get(0) + "  ", al.get(1) + "  ", al.get(2) + "  ", al.get(3) + "  ", al.get(4) + "  ", al.get(5));
		}
		//prompt user for input
		System.out.println("Choose your option: ");
		System.out.println("Press -1 to return to previous menu.");
		String input = scanner.nextLine(); //grab user input
		return input; //return user input
	}
	//print audio options menu
	public String P9(){
		//print audio
		System.out.println("Audio: ");
		System.out.println("");
		//Using string formatting to make a nice table
		//and using the preset (and consistent) output variables
		//print the table header
		System.out.format("%4s%-32s%-8s%-10s%32s%-5s\n", output_sno + "  ", output_name + "  ", output_artist + "  ", output_price+"  ", output_quantity+"  ", output_type);
		for (Audio i : ac) { //for each audio in the audio collection
			ArrayList al = i.getInfo();//get the info of the current audio object
			//Using string formatting to follow the table header above
			//print the necessary information for the current item
			System.out.format("%4s%-32s%-6s%10s%32s%5s\n",al.get(0)+"  ", al.get(1)+"  ", al.get(2)+"  ", al.get(3)+"  ", al.get(4)+"  ",al.get(5));
		}
		//prompt user for input
		System.out.println("Choose your option: ");
		System.out.println("Press -1 to return to previous menu.");
		String input = scanner.nextLine(); //grab user input
		return input; //return user input
	}
	//billing information screen
	public boolean P10(){
		//print billing information
		System.out.println("Billing Information: ");
		//using string formatting to make a nice table
		//and using the preset (and consistent) output variables
		//print the table header
		System.out.format("%-32s%-10s%-15s\n",output_name + " ", output_quantity+ " ", output_price + " ");
		//create an arraylist to store *UNIQUE* items (readable OR audio)
		ArrayList<Item> unique = new ArrayList<Item>();
		//add the first element
		//this allows the following loop to work
		unique.add(sc.getContent().get(0));
		for (Item i : sc.getContent()){ //foreach item in the shopping cart
			boolean doAdd = true; //boolean to store whether the item is unique
			for (Item u : unique){ //foreach item in the previous declared unique arraylist
				//check if the current shopping cart item
				//has the same serial number as any element in the unique arraylist
				if (i.getInfo().get(0).equals(u.getInfo().get(0))){
					//the item is not unique
					doAdd = false;
				}
			}
			if (doAdd){ //if the item is unique
				unique.add(i); //add to the unique arraylist
			}
		}
		for (Item i: unique){ //for each unique item
			//using string formatting to follow the table headers above
			//print the current item's name, quantity and price
			System.out.format("%-32s%-10d%-15s\n", i.getInfo().get(2), sc.itemCount(i.getInfo().get(0)),i.getInfo().get(3));
		}
		double totalEnviroTax = 0; //store the total environment tax
		double hst = 0; //store the total hst
		double shipping = 0; //store the total shipping
		double total = 0; //store the final total
		for (Item i: sc.getContent()){ //foreach  item in the shopping cart
			double price = Double.parseDouble(i.getInfo().get(3)); //get the non modified (no enviro tax) price of the current item
			//calculate the enviro tax if there is
			//price variable stores the base cost of the item
			//getPrice() function returns the price with envirotax if it applies, otherwise just returns the base price
			//subtracting the values returns 0 if no enviro tax applies to the item
			//or if there is envirotax, it will simply be price*0.02
			//this eliminates the need for an if statement
			totalEnviroTax += i.getPrice() - price;
			hst += price * 0.13; //calculate hst
			if (i.getInfo().get(5).equals("CD") || i.getInfo().get(5).equals("Book")){ //if the item requires shipping
				shipping += price * 0.1; //calculate shipping
			}
			total += price; //calculate total price
		}
		total += hst + shipping + totalEnviroTax; //sum all the different taxes and prices
		//Using string formatting to try and match the output from the assignment PDF
		System.out.format("%32s%-10s%-15.02f\n","Environment Tax  ", "2%", totalEnviroTax); //print the total enviroment tax
		System.out.format("%32s%-10s%-15.02f\n","HST  ", "13%", hst); //print the total hst
		System.out.format("%32s%-10s%-15.02f\n","Shipping  ", "10%", shipping); //print the total shipping
		System.out.format("%32s%-10s%-15s\n","", "", "_________"); //print a separator
		System.out.format("%32s%-10s%-15.02f\n","Total  ", "", total); //print the final total


		//prompt the user if they want to pay
		while(true){
			System.out.println("Are you sure you want to pay? yes or no.");
			String input = scanner.nextLine(); //grab user input
			if (input.toLowerCase().equals("yes")){ //check if they typed any form of yes (yes,YES,yEs,Yes,yeS, etc.)
				System.out.println("Confirmation ID: U1000"); //print confirmed with confirmation ID
				System.out.println("Items shipped to: " + user.getUsername()); //print items shipped to username
				break;
			}
			else if (input.toLowerCase().equals("no")){ //user doesn't want to pay
				System.out.println("Bye"); //print bye
				break;
			}else{
				System.out.println("Bad input. Please enter either \"yes\" or \"no\"");
			}
		}
		return false; //return false
	}
	//init function
	public static void init(){
		getAudioProducts(); //read audio products from file
		getReadables(); //read readable products from file
	}
	//read audio products from file
	public static void getAudioProducts(){
		//store the items read from CDs.txt in an arraylist of arraylist of strings
		ArrayList<ArrayList<String>> audio = new ArrayList<ArrayList<String>>(readFile("CDs"));
		//append to the arraylist of arraylist of strings with the items of MP3.txt
		audio.addAll(readFile("MP3"));
		//build audio collection with the items read from the file
		ac = new AudioCollection(audio);
	}
	//read readable products from file
	public static void getReadables(){
		//store the items read from Books.txt in an arraylist of arraylist of strings
		ArrayList<ArrayList<String>> readables = new ArrayList<ArrayList<String>>(readFile("Books"));
		//append to the arraylist of arraylist of strings with the items of Ebooks.txt
		readables.addAll(readFile("Ebooks"));
		//build readable collection with the items read from the file
		rc = new ReadableCollection(readables);
	}
	//read products from file
	//returns an arraylist of arraylist of strings so we can
	//reuse the function for both readables and audio
	//takes in the file name
	public static ArrayList<ArrayList<String>> readFile(String type){
		//create arraylist of arraylist of string to store the values in the file
		ArrayList<ArrayList<String>> stringlist = new ArrayList<ArrayList<String>>();
		//create a buffered reader 
		BufferedReader reader;
		try { //try to read the file
			//open the filename.txt
		    reader = new BufferedReader(new FileReader(type + ".txt"));
		    //store the current line
		    String line = reader.readLine();
		    while (line!=null) { //loop through the entire file until the currentline is null
		    	//split the current line at every ', ' this returns an array
		    	//cast the array into an arraylist of strings
		    	//append the arraylist of strings to the arraylist of arraylist of strings (stringlist)
				stringlist.add(new ArrayList<String>(Arrays.asList(line.split(", "))));
				// Read next line for while condition
				line = reader.readLine();
		    }
		    reader.close();// close the reader
		    return stringlist; //return the contents of the file
		}catch (IOException e){ //catch any IO Exceptions
			System.err.println("Error reading file \"" + type + ".txt\"");//error handling
		}
		return stringlist; //if this return statement is reached, always returns null
	}
	//read the contents of Users.txt
	public ArrayList<String> readUser(){
		//create an arraylist of strings to store each username
		ArrayList<String> lines = new ArrayList<String>();
		//try to open Users.txt
		try (BufferedReader br = new BufferedReader(new FileReader("Users.txt"))) {
			String line; //string to store the current line
			while ((line = br.readLine()) != null){ //while the current line isn't null
				lines.add(line); //append to the arraylist of strings the value of the current line
				// this allows us to support any type of username
			}
		}
		catch(IOException e){ //catch IO Exception
			System.err.println("Error reading \"Users.txt\"");
			return null;
		}
		return lines; //return arraylist of strings containing each username in Users.txt
	}
	//function to check if the attempted login username exists
	public String checkLogin(String username){ //takes in the attempted login username
		if (users.contains(username)){ //check if the arraylist of usernames contains the current username
			System.out.println("Welcome, " + username); //print welcome message
			sc = new ShoppingCart(username); //instantiate the shopping cart with the username
			user.setUsername(username); //store the username in the user class
			return "5"; //return 5 (code for main class)
		}
		else{ //username isn't container
			return "4"; //return 4 (code for main class)
		}
	}
	//function to buy a readable object
	public String buyReadable(String input){
		//wrapped in try to handle any kind of input
		try{
			//parse the user input to an integer
			int num = Integer.parseInt(input);
			if (num > 0){ //check if the number is greater than 0
				System.out.println("Enter the quantity: "); //prompt user for quantity
				String quantity = scanner.nextLine(); //grab the user input
				try{ //another try to catch any exceptions
				    int qty = Integer.parseInt(quantity); //cast quantity to an integer
				    Readable readA = rc.findBysNo(num); //build readable by serial nu,ber
				    if(readA == null){
					System.err.println("Unable to find item with serial number: " + num);
					return "-1";
				    }
				    if (num == Integer.parseInt(readA.getInfo().get(0))){ //confirm it's the right object
						if (qty > 0){//check the quantity is right, also need to check if we have enough
							for (int i = 0; i < qty; i++){ //add qty of the same item to the shopping cart
							    sc.AddItem(readA); //add item to the shopping cart
							}
						}
				    }
				    //print the item was added to the shopping cart
					System.out.println(qty + " " + readA.getInfo().get(2) + " " + "succesfully added to your cart.");
					//save the user's cart
					sc.save(user.getUsername());
					//prompt the user for input
					System.out.println("Press -2 to Continue Shopping or Press 0 to CheckOut: ");
					String next = scanner.nextLine(); //grab the user input
					return next; //return input
				}
				catch (Exception e) { //catch any exception
					System.err.println("\"" + quantity + "\" is not a number"); //error handling
					return null;
				}
			}
			else{ //bad input
				System.out.println("It can't be less than 1!");
			}
		}
		catch (Exception e){ //catch any exception
			System.err.println("\"" + input + "\" is not a number!");
		}
		//return null because something went wrong
		return null;
	}
	//function to buy an audio object
	public String buyAudio(String input){
		try{ //wrapped in try to handle any kind of input
			int num = Integer.parseInt(input); //parse input to integer
			if (num > 0){ //check if num is greater than 0
				System.out.println("Enter the quantity: "); //prompt user for the quantity
				String quantity = scanner.nextLine(); //grab the user input
				try{ //try to purchase quantity items
					int qty = Integer.parseInt(quantity); //parse quantity to int
					Audio audioA = ac.findBysNo(num); //create audio object using find by serial number
					if(audioA == null){
					    System.err.println("Unable to find item with serial number: " + num);
					    return "-1";
					}
				    if (num == Integer.parseInt(audioA.getInfo().get(0))){ //check if it's the right object
				    	if (qty > 0){ //check if qty is right, should also check if we have enough
							for (int i = 0; i < qty; i++){//add item to shopping cart qty times
							    sc.AddItem(audioA); //add item to shopping cart
							}
				    	}
				    }
				    //print the action was done succesfully
   					System.out.println(qty + " " + audioA.getInfo().get(2) + " " + "succesfully added to your cart.");
					sc.save(user.getUsername()); //save the user's shopping cart
					//prompt the user for input
					System.out.println("Press -2 to Continue Shopping or Press 0 to CheckOut: ");
					String next = scanner.nextLine(); //grab the user input
					return next; //return the input
				}
				catch (Exception e) { //catch any exception
					System.err.println("\"" + quantity + "\" is not a number!");
				}
			}
			else{
				//bad num
				System.out.println("It was less than 1!");
			}
		}
		catch (Exception e){ //catch any exception
			System.out.println("\"" + input + "\" is not a number!");
		}
		return null; //return null because something went wrong
	}
}
