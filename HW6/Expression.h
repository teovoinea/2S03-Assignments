/*
* Name: Nick Morrison, Roberto Temelkovski, Teo Voinea
* MacID: morrin2, temelkr, voineat
* Student Number: 1426613, 1418731, 1409586
* Description: Expression heeader file
*/
#ifndef EXPRESSION_H
#include <string>
class Expression{
	private:

	public:
		Expression();
		virtual std::string evaluate(); //evaluate expression and return string representation of the result
		virtual void print(); //prints expression
};
#endif