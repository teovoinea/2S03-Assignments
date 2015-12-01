/*
* Name: Nick Morrison, Roberto Temelkovski, Teo Voinea
* MacID: morrin2, temelkr, voineat
* Student Number: 1426613, 1418731, 1409586
* Description: File containing the Main class
*/
#include <iostream>
#include "Addition.h"
#include "Subtraction.h"
#include "Multiplication.h"
#include "Division.h"
#include <string>
#include <sstream>
using namespace std;
int main(){
	//Get input
	cout << "Please enter an expression: ";
	string input;
	getline(cin, input);
	string output = "0";
	/***************Currently, everything needs to be wrapped in brackets***************/


	//Get the left side of the equation
	int open_brackets = 0;
	int closed_brackets = 0;
	int left_end_index = 0;
	string left = "";
	for (int i = 0; i < input.length(); i++){
		if (input[i] == '('){
			open_brackets++;
		}
		if (input[i] == ')'){
			closed_brackets++;
		}
		if (open_brackets == closed_brackets && open_brackets != 0){
			left += input[i];
			left_end_index = i;
			break;
		}
		else{
			left += input[i];
		}
	}

	//Get the operator between each size
	string sign = "";
	int sign_index = 0;
	for (int i = left_end_index + 1; i < input.length(); i++){
		if (input[i] == '('){
			cout << "Expression is not well formed" << endl;
			break;
		}
		if (input[i] == '+'){
			sign = "+";
			sign_index = i;
			break;
		}
		if (input[i] == '-'){
			sign = "-";
			sign_index = i;
			break;
		}
		if (input[i] == '/'){
			sign = "/";
			sign_index = i;
			break;
		}
		if (input[i] == '*'){
			sign = "*";
			sign_index;
			break;
		}
	}

	//Get the right side of the equation
	open_brackets = 0;
	closed_brackets = 0;
	int right_end_index = 0;
	string right = "";
	for (int i = sign_index + 1; i < input.length(); i++){
		if (input[i] == '('){
			open_brackets++;
		}
		if (input[i] == ')'){
			closed_brackets++;
		}
		if (open_brackets == closed_brackets && open_brackets != 0){
			right += input[i];
			right_end_index = i;
			break;
		}
		else{
			right += input[i];
		}
	}

	if (right_end_index != input.length()){
		cout << "The end of the right hand side is not the end of the expression." << endl;
	}
	cout << "The left hand side is: " << left << endl;
	cout << "The operator between sides is: " << sign << endl;
	cout << "The right hand side is: " << right << endl;
	//output
	cout << input << " = " << output << endl;
}
