/*
* Name: Nick Morrison, Roberto Temelkovski, Teo Voinea
* MacID: morrin2, temelkr, voineat
* Student Number: 1426613, 1418731, 1409586
* Description: Multiplication header file
*/
#ifndef MULTIPLICATION_H // header guard
#define MULTIPLICATION_H // define header

#include <string> // string class 
#include "ArithmeticExpression.h" // include arithmetic expression
class Multiplication : public ArithmeticExpression{ // define class
	private: // private vars
	// none 
	public: // public vars
		Multiplication(); // constructor
		std::string evaluate(std::string input); // evaluate method
		void print(std::string input); // print method
};// close class
#endif