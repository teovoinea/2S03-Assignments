/*
* Name: Nick Morrison, Roberto Temelkovski, Teo Voinea
* MacID: morrin2, temelkr, voineat
* Student Number: 1426613, 1418731, 1409586
* Description: Subtraction header file
*/
#ifndef SUBTRACTION_H //header guard
#define SUBTRACTION_H //define header

#include <string> // string class
#include "ArithmeticExpression.h" // arithmetic expression class
class Subtraction : public ArithmeticExpression{ // define class
	private: // private vars

	public: // public vars
		Subtraction(); //constructor
		std::string evaluate(std::string input); // evaluate statement
		void print(std::string input); // print statement
};// close class
#endif