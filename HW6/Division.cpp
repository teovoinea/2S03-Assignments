/*
* Name: Nick Morrison, Roberto Temelkovski, Teo Voinea
* MacID: morrin2, temelkr, voineat
* Student Number: 1426613, 1418731, 1409586
* Description: File containing the Division class
*/
#include <iostream> // include iostream
#include "ArithmeticExpression.h" // include arithmetic expression
#include "Division.h" // division header
#include <string> // string class 
#include <sstream> // string stream
using namespace std; //standard namespace
Division::Division(){ // constructor

}// close constructor
string Division::evaluate(string input){ // start method
	string s1 = ""; // empty string 
	string s2 = ""; // empty string
	int sign_index = 0; // index of '/'
	for(int i = 0; i < input.length(); i++){ // start for loop
		if (input[i] == '/'){ // if '/' 
			sign_index = i; // set index of '/' 
			break; // break from for loop
		} // close if structure
		else{ // if not '+'
			s1 += input[i]; // add current letter to s1
 		} // close else 
	} // close for loop
	for(int i = sign_index + 1; i < input.length(); i++){ //from '/' to the end
		s2 += input[i]; //add to second side
	} // closes for loop
	double value1 = 0; // init variable
	double value2 = 0; // init variable
	std::istringstream(s1) >> value1; // push side 1 to variable
	std::istringstream(s2) >> value2; // push side 2 to variable
	double value = value1 / value2; // add values together
	return std::to_string(value); // return the string value 
}
void Division::print(string input){ // start function
	cout << input << endl; // print input
} // close function