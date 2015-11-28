/*
* Name: Nick Morrison, Roberto Temelkovski, Teo Voinea
* MacID: morrin2, temelkr, voineat
* Student Number: 1426613, 1418731, 1409586
* Description: Subtraction header file
*/
#ifndef SUBTRACTION_H
#include <string>
#include "ArithmeticExpression.h"
class Subtraction : public ArithmeticExpression{
	private:

	public:
		Subtraction();
		std::string evaluate();
		void print();
};
#endif