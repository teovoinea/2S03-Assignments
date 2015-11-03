/*
* Name: Nick Morrison, Roberto Temelkovski, Teo Voinea
* MacID: morrin2, temelkr, voineat
* Student Number: 1426613, 1418731, 1409586
* Description: File containing the UserInterface class
*/
public class UserInterface{
	public UserInterface(){
	}
	private int currentPage;
	public int getCurrentPage(){
		return currentPage;
	}
	public void changeCurrentPage(int c){
		if (c > 0 && c < 11){
			currentPage = c;
		}
		if (c == 1){
			P1();
		}
		else if (c == 2){
			P2();
		}
		else if (c == 3){
			P3();
		}
		else if (c == 4){
			P4();
		}
		else if (c == 5){
			P5();
		}
		else if (c == 6){
			P6();
		}
		else if (c == 7){
			P7();
		}
		else if (c == 8){
			P8();
		}
		else if (c == 9){
			P9();
		}
		else if (c == 10){
			P10();
		}
	}

	//Sign in menu
	public void P1(){
		System.out.println("1. Sign in");
		System.out.println("2. Sign up");
		System.out.println("Choose your option: ");
	}
	public void P2(){
		System.out.println("Choose your username: ");
	}
	public void P3(){
		System.out.println("Enter your username: ");
	}
	public void P4(){
		System.out.println("Enter your username: ")
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
}