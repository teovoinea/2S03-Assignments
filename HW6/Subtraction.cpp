/*
* Name: Nick Morrison, Roberto Temelkovski, Teo Voinea
* MacID: morrin2, temelkr, voineat
* Student Number: 1426613, 1418731, 1409586
* Description: File containing the Subtraction class
*/
#include "Subtraction.h" // include subtraction header
#include "ArithmeticExpression.h" // include arithmetic expression
#include <iostream> // iostream include
#include <string> // string class
#include <sstream> // string stream
using namespace std; // standard namespace
Subtraction::Subtraction(){

}
string Subtraction::evaluate(string input){ // evaluate
	string s1 = ""; // left side
	string s2 = ""; // right side
	int sign_index = 0; // index of operation 
	for(int i = 0; i < input.length(); i++){ // for loop
		if (input[i] == '-'){ // if you are at position of -
			sign_index = i; // index of 
			break; // break out of for loop 
		} // close if
		else{ // if not '-'
			s1 += input[i]; // put next character in
		} // close else
	} // close for loop
	for(int i = sign_index + 1; i < input.length(); i++){ // start for loop
		s2 += input[i]; //add everything from rs
	} // close for loop
	double value1 = 0; //left side
	double value2 = 0; //right side
	std::istringstream(s1) >> value1; // push left side to value1
	std::istringstream(s2) >> value2; // push right side to value2
	double value = value1 - value2; // multiply values
	return std::to_string(value); // turn value to string
} // close bracket
void Subtraction::print(string input){ //print function
	cout << input << endl; // print statement
} //close bracket