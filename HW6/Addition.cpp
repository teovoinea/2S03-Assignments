/*
* Name: Nick Morrison, Roberto Temelkovski, Teo Voinea
* MacID: morrin2, temelkr, voineat
* Student Number: 1426613, 1418731, 1409586
* Description: File containing the Addition class
*/
#include "Addition.h"
#include "ArithmeticExpression.h"
#include <iostream>
#include <string>
#include <sstream>
using namespace std;
Addition::Addition(){

}
string Addition::evaluate(string input){
	string s1 = "";
	string s2 = "";
	int sign_index = 0;
	for(int i = 0; i < input.length(); i++){
		if (input[i] == '+'){
			sign_index = i;
			break;
		}
		else{
			s1 += input[i];
		}
	}
	for(int i = sign_index + 1; i < input.length(); i++){
		s2 += input[i];
	}
	double value1 = 0;
	double value2 = 0;
	std::istringstream(s1) >> value1;
	std::istringstream(s2) >> value2;
	double value = value1 + value2;
	return std::to_string(value);
}
void Addition::print(string input){
	cout << input;
}