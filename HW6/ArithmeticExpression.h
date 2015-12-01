/*
* Name: Nick Morrison, Roberto Temelkovski, Teo Voinea
* MacID: morrin2, temelkr, voineat
* Student Number: 1426613, 1418731, 1409586
* Description: Arithmetic Expression header file
*/
#ifndef ARITHMETICEXPRESSION_H
#define ARITHMETICEXPRESSION_H

#include "Expression.h"
#include <string>
class ArithmeticExpression : public Expression{
	private:

	public:
		ArithmeticExpression();
		std::string evaluate();
		void print();
		float convert(std::string s);
};
#endif
