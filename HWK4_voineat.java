/*
* Name: Nick Morrison, Roberto Temelkovski, Teo Voinea
* MacID: morrin2, temelkr, voineat
* Student Number: 1426613, 1418731, 1409586
* Description: File containing the Main class
*/
import java.util.*;
public class HWK4_voineat{
	static private UserInterface ui = new UserInterface();
	public static void main(String[] args){

		boolean loop = true;
		ui.changeCurrentPage(1);
		String input,username,next;
		while(loop){
			if (ui.getCurrentPage() == 1){
				input = ui.P1();
				if (input.equals("1")){
					ui.changeCurrentPage(3);
				}
				else if (input.equals("2")){
					ui.changeCurrentPage(2);
				}
			}else if (ui.getCurrentPage() == 2){
				ui.P2();
				ui.changeCurrentPage(1);
			}else if (ui.getCurrentPage() == 3){
				username = ui.P3();
				input = ui.checkLogin(username);
				if (input.equals("5")){
					ui.changeCurrentPage(5);
				}
				else if (input.equals("4")){
					ui.changeCurrentPage(4);
				}
			}else if (ui.getCurrentPage() == 4){
				ui.P4();
				ui.changeCurrentPage(1);
			}else if (ui.getCurrentPage() == 5){
				input = ui.P5();
				if (input.equals("1")){
					ui.changeCurrentPage(6);
				}
				else if (input.equals("2")){
					ui.changeCurrentPage(7);
				}
				else if (input.equals("3")){;
					ui.changeCurrentPage(1);
				}
			}else if (ui.getCurrentPage() == 6){
				input = ui.P6();
				if (input.equals("1")){
					ui.changeCurrentPage(8);
				}
				else if (input.equals("2")){
					ui.changeCurrentPage(9);
				}
				else if (input.equals("-1")){
				    ui.changeCurrentPage(5);
				}
			}else if (ui.getCurrentPage() == 7){
				ui.P7();
				ui.changeCurrentPage(5);
			}else if (ui.getCurrentPage() == 8){
				input = ui.P8();
				if (input.equals("-1")){
					ui.changeCurrentPage(6);
				}else{
					next = ui.buyReadable(input);
					if (next.equals("0")){
						ui.changeCurrentPage(10);
					}
					else if (next.equals("-2")){
						ui.changeCurrentPage(6);
					}
				}
			}else if (ui.getCurrentPage() == 9){
				input = ui.P9();
				if (input.equals("-1")){
					ui.changeCurrentPage(6);
				}else{
					next = ui.buyAudio(input);
					if (next.equals("0")){
						ui.changeCurrentPage(10);
					}
					else if (next.equals("-2")){
						ui.changeCurrentPage(6);
					}
				}
			}else if (ui.getCurrentPage() == 10){
				loop = ui.P10();
			}
		}
	}
}