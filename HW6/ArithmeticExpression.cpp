/*
* Name: Nick Morrison, Roberto Temelkovski, Teo Voinea
* MacID: morrin2, temelkr, voineat
* Student Number: 1426613, 1418731, 1409586
* Description: File containing the Arithmetic Expression class
*/
#include <iostream> // include for cout
#include "ArithmeticExpression.h" // header file 
#include "Expression.h" // expression header file
#include <string> // string class include
using namespace std; // standard name space
ArithmeticExpression::ArithmeticExpression(){ // constructor
	left = new Expression(); // left side expression 
	right = new Expression(); // right side expression
} // close bracket

string ArithmeticExpression::evaluate(){ // start evaluate function
	string s = "This is a string"; // set string
	return s; // return
} // close bracket
void ArithmeticExpression::print(){ // print method
	cout << "This should print something" << endl; // print
} // close
float ArithmeticExpression::convert(string s){ // convert to float
	float f = 3.14; //set float
	return f; // return 
} // close
