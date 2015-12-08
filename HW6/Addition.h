/*
* Name: Nick Morrison, Roberto Temelkovski, Teo Voinea
* MacID: morrin2, temelkr, voineat
* Student Number: 1426613, 1418731, 1409586
* Description: Addition header file
*/
#ifndef ADDITION_H // header guard
#define ADDITION_H // header define

#include <string> // string class 
#include "ArithmeticExpression.h" // include arithmetic expression
class Addition : public ArithmeticExpression{ // addition inherits arithmetic expression
	public: // public methods 
		Addition(); // constructor
		std::string evaluate(std::string input); // evaluate function
		void print(std:: string input); // print function
}; // closes class

#endif