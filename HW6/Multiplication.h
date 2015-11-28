/*
* Name: Nick Morrison, Roberto Temelkovski, Teo Voinea
* MacID: morrin2, temelkr, voineat
* Student Number: 1426613, 1418731, 1409586
* Description: Multiplication header file
*/
#ifndef MULTIPLICATION_H
#include <string>
#include "ArithmeticExpression.h"
class Multiplication : public ArithmeticExpression{
	private:

	public:
		Multiplication();
		std::string evaluate();
		void print();
};
#endif