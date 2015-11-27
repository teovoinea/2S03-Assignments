/*
* Name: Nick Morrison, Roberto Temelkovski, Teo Voinea
* MacID: morrin2, temelkr, voineat
* Student Number: 1426613, 1418731, 1409586
* Description: File containing the Main class
*/
import java.util.*; // import everything
public class HWK4_voineat{ // main class
	static private UserInterface ui = new UserInterface(); // create User interface object
	public static void main(String[] args){ //start main function
		boolean loop = true; // originally set to loop infinitely
		ui.changeCurrentPage(1); // set to page 1
		String input,username,next; // initialize strings 
		while(loop){ // infinite loop
			if (ui.getCurrentPage() == 1){ // if 1st page
				input = ui.P1(); // get input from first page
				if (input.equals("1")){ // if input is 1
					ui.changeCurrentPage(3); // go to third page
				}// closing bracket
				else if (input.equals("2")){ // if input is 2
					ui.changeCurrentPage(2); // go to second page
				} // closing bracket
			}else if (ui.getCurrentPage() == 2){ // if you are on the second page
				ui.P2(); // call P2 function
				ui.changeCurrentPage(1); // change to page 1
			}else if (ui.getCurrentPage() == 3){ // if you are on page 3
				username = ui.P3(); // get username from 3rd page input
				input = ui.checkLogin(username); // get input from trying to log in
				if (input.equals("5")){ // if sucessful log in
					ui.changeCurrentPage(5); // go to logged in page
				}else if (input.equals("4")){ // if false log in 
					ui.changeCurrentPage(4); //go to error page
				} // close bracket
			}else if (ui.getCurrentPage() == 4){ // if not logged in
				ui.P4(); // print access denied 
				ui.changeCurrentPage(1); // go to first page
			}else if (ui.getCurrentPage() == 5){ // if logged in
				input = ui.P5(); // get input
				if (input.equals("1")){ // if input is 1
					ui.changeCurrentPage(6); // go to page 6
				} // close
				else if (input.equals("2")){ // if input is 2
					ui.changeCurrentPage(7); // go to page 7
				} // close
				else if (input.equals("3")){ // if input is 3
					ui.changeCurrentPage(1); // go to page 1
				} // close
			}else if (ui.getCurrentPage() == 6){ // if on page 6
				input = ui.P6(); // get input
				if (input.equals("1")){ // if input is 1
					ui.changeCurrentPage(8); // go to page 8
				}else if (input.equals("2")){ // if input is 2
					ui.changeCurrentPage(9); //go to page 9
				} // close 
				else if (input.equals("-1")){ // go back a page
				    ui.changeCurrentPage(5); // go to page 5
				} // close
			}else if (ui.getCurrentPage() == 7){ // if on page 7
				ui.P7(); // show shopping cart
				ui.changeCurrentPage(5); // go to page 5
			}else if (ui.getCurrentPage() == 8){ // if page 8
				input = ui.P8(); // get input from page 8
				if (input.equals("-1")){ // if -1 is input
					ui.changeCurrentPage(6); // go back a page
				}else{ // if not -1
					next = ui.buyReadable(input); // get input from buyReadable
					if(next == null)continue;
					if (next.equals("0")){ // if input is 0
						ui.changeCurrentPage(10); // go to checkout page
					}else if (next.equals("-2")){ // if input is -2
						ui.changeCurrentPage(6); // go to page 6
					} // close
				}// close
			}else if (ui.getCurrentPage() == 9){// if on page 9
				input = ui.P9(); // get input 
				if (input.equals("-1")){ // if input is -1
					ui.changeCurrentPage(6); // go to previous page
				}else{ // if not -1
					next = ui.buyAudio(input); // get input for next page
					if(next == null)continue;
					if (next.equals("0")){ // if 0
						ui.changeCurrentPage(10); // go to checkout
					} // close 
					else if (next.equals("-2")){ // if -2 
						ui.changeCurrentPage(6); // go back two pages
					} // close
				}// close
			}else if (ui.getCurrentPage() == 10){ // if check out page
				loop = ui.P10(); // print details and exit loop
			} // close
		} // close
	} // close
} // close