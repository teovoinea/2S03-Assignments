/*
* Name: Nick Morrison, Roberto Temelkovski, Teo Voinea
* MacID: morrin2, temelkr, voineat
* Student Number: 1426613, 1418731, 1409586
* Description: Arithmetic Expression header file
*/
#ifndef ARITHMETICEXPRESSION_H //header guard
#define ARITHMETICEXPRESSION_H // define class

#include "Expression.h" //include expression header
#include <string> // include string class
class ArithmeticExpression : public Expression{ // define class
	private: // private vars 
	// none
	public: // public vars/ methods 
		ArithmeticExpression(); // constructor
		std::string evaluate(); // evaluate method
		void print(); // print method 
		float convert(std::string s); // convert method
		Expression *left; // pointer to left expression
		Expression *right; // pointer to right expression
};
#endif

