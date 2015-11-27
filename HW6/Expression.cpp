/*
* Name: Nick Morrison, Roberto Temelkovski, Teo Voinea
* MacID: morrin2, temelkr, voineat
* Student Number: 1426613, 1418731, 1409586
* Description: File containing the Expression class
*/
#include <iostream>;
#include "Expression.h"
using namespace std;
Expression:Expression(){

}

virtual string Expression:evaluate(){
	string test = "This returns a string";
	return test;
}

virtual void Expression:print(){
	cout << "This prints something" << endl;
}