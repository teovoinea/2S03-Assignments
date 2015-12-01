/*
* Name: Nick Morrison, Roberto Temelkovski, Teo Voinea
* MacID: morrin2, temelkr, voineat
* Student Number: 1426613, 1418731, 1409586
* Description: Addition header file
*/
#ifndef ADDITION_H
#define ADDITION_H

#include <string>
#include "ArithmeticExpression.h"
class Addition : public ArithmeticExpression{
	public:
		Addition();
		std::string evaluate();
		void print();

};
#endif
