/*
* Name: Nick Morrison, Roberto Temelkovski, Teo Voinea
* MacID: morrin2, temelkr, voineat
* Student Number: 1426613, 1418731, 1409586
* Description: Addition header file
*/
#ifndef ADDITION_H
#include <string>
class Addition : public ArithmeticExpression{
	private:

	public:
		Addition();
		std::string evaluate();
		void print();

};
#endif