/*
* Name: Nick Morrison, Roberto Temelkovski, Teo Voinea
* MacID: morrin2, temelkr, voineat
* Student Number: 1426613, 1418731, 1409586
* Description: Division header file
*/
#ifndef DIVISION_H // header guard
#define DIVISION_H // define class
#include <string> // include string 
#include "ArithmeticExpression.h" // include arithmetic expression
class Division : public ArithmeticExpression{ // define class
	private: // private vars
	// none
	public: // public vars and methods 
 		Division(); // constructor
 		std::string evaluate(std::string input); //evaluate method
		void print(std:: string input); // print method 
}; // close class
#endif