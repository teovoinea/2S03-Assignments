/*
* Name: Nick Morrison, Roberto Temelkovski, Teo Voinea
* MacID: morrin2, temelkr, voineat
* Student Number: 1426613, 1418731, 1409586
* Description: Division header file
*/
#ifndef DIVISION_H
#define DIVISION_H

#include <string>
#include "ArithmeticExpression.h"
class Division : public ArithmeticExpression{
	private:

	public:
		Division();
		std::string evaluate();
		void print();
};
#endif
