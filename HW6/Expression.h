/*
* Name: Nick Morrison, Roberto Temelkovski, Teo Voinea
* MacID: morrin2, temelkr, voineat
* Student Number: 1426613, 1418731, 1409586
* Description: Expression heeader file
*/
#ifndef EXPRESSION_H //header guard
#define EXPRESSION_H // define header 

#include <string> // include string class 
class Expression{ // define expression class
	private: // private vars

	public: // public vars
		Expression(); // constructor
		virtual std::string evaluate(); //evaluate expression and return string representation of the result
		virtual void print(); //prints expression
		std::string exp; //string to hold expression
}; // close class
#endif
