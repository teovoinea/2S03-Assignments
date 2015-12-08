/*
* Name: Nick Morrison, Roberto Temelkovski, Teo Voinea
* MacID: morrin2, temelkr, voineat
* Student Number: 1426613, 1418731, 1409586
* Description: File containing the Expression class
*/
#include <iostream> // iostream for cout
#include "Expression.h" // expression header
#include <string> // string operations 
using namespace std; // using standard namespace
string exp; // holds expression
Expression::Expression(){ // constructor
	exp = ""; // set expression to blank
} // close bracket

string Expression::evaluate(){ // returns a string
	string test = "This returns a string"; // set test var
	return test; // returns test
} // close bracket

void Expression::print(){ //function 
	cout << "This prints something" << endl; // print
} // close
