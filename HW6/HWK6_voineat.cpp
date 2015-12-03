/*
* Name: Nick Morrison, Roberto Temelkovski, Teo Voinea
* MacID: morrin2, temelkr, voineat
* Student Number: 1426613, 1418731, 1409586
* Description: File containing the Main class
*/
/*************** FOLLOW THESE FUNCTIONS: http://www.geeksforgeeks.org/expression-evaluation/ ***************/
#include <iostream>
#include "Addition.h"
#include "Subtraction.h"
#include "Multiplication.h"
#include "Division.h"
#include <stdio.h>
#include <string>
#include <sstream>
#include <vector>
#include <stack>
#include <cmath>
using namespace std;
string calculate(string input);
double evaluate(string expression);
double applyOp(char op, double b, double a);
bool hasPrecedence(char op1, char op2);
string remove_brackets(string input);
string breakdown(string input, int &i);
vector<string> split(string input);
//string calculate(string input);
ArithmeticExpression ae = ArithmeticExpression();
Addition add = Addition();
Subtraction sub = Subtraction();
Multiplication mul = Multiplication();
Division divide = Division();

int main(){
	//Get input
	cout << "Please enter an expression: ";
	string input;
	getline(cin, input);
	string output = "0";
	/***************Currently, everything needs to be wrapped in brackets***************/
	//replace ' ' with ''
	int l = 0;
	string s = breakdown(input, l);
	cout << "Breakdown returns: " << s << endl;
	//cout << Addition().evaluate("3+4");
	//string final_out = calculate(input);
	//cout << input << " = " << final_out << endl;
	//vector<string> split_string = split(input);	
	//string final_out = calculate(input);
	/*
	if (right_end_index != input.length()){
		cout << "The end of the right hand side is not the end of the expression." << endl;
	}*/


	//cout << "The left hand side is: " << remove_brackets(split_string[0]) << endl;
	//cout << "The operator between sides is: " << split_string[1] << endl;
	//cout << "The right hand side is: " << remove_brackets(split_string[2]) << endl;
	//output
	//output = calculate(input);
	//cout << output << endl;
}
/*
double evaluate(string expression){
	std::stack<double> values;
	std::stack<char> ops;
	breakdown(expression,values,ops);
	
	while(!ops.empty()){
		double p1 = values.top();
		values.pop();
		double p2 = values.top();
		values.pop();
		char c1 = ops.top();
		ops.pop();
		double returnVal = applyOp(c1, p1, p2);
		values.push(returnVal); //error
	}
	
	double v = values.top();
	values.pop();
	return v; //error
}*/

bool hasPrecedence(char op1, char op2){
	if (op2 == '(' || op2 == ')'){
		return false;
	}
	if ((op1 == '*' || op1 == '/') && (op2 == '+' || op2 == '-')){
		return false;
	}
	else{
		return true;
	}
}

double applyOp(char op, double b, double a){
	string s = "";
	s += std::to_string(a);
	s += op;
	s += std::to_string(b);
	cout << s << endl;
	string r = "";
	double res = 0;
	switch(op){
		case '+':
			r = add.evaluate(s);
			std::istringstream(r) >> res;
			return res;
		case '-':
			r = sub.evaluate(s);
			std::istringstream(r) >> res;
			return res;
		case '*':
			r = mul.evaluate(s);
			std::istringstream(r) >> res;
			return res;
		case '/':
			r = divide.evaluate(s);
			std::istringstream(r) >> res;
			return res;
		default:
			return 0;
	}
	return 0;
}


string calculate(string input){
	vector<string> split_string = split(input);
	string store_return = "";
	split_string[0] = remove_brackets(split_string[0]);
	split_string[2] = remove_brackets(split_string[2]);
	//cout << split_string[0] << endl
	//if true -> no brackets on either left AND right hand side, can directly be solved
	if (remove_brackets(split_string[0]) == split_string[0] && remove_brackets(split_string[2]) == split_string[2]){
		//check what operation it is
		if (split_string[1] == "+"){
			//pass in whole string eg: 3+4
			store_return = add.evaluate(split_string[0] + split_string[1] + split_string[2]);
		}
		if (split_string[1] == "-"){
			//pass in whole string eg: 3-4
			store_return = sub.evaluate(split_string[0] + split_string[1] + split_string[2]);
		}
		if (split_string[1] == "*"){
			//pass in whole string eg: 3*4
			store_return = mul.evaluate(split_string[0] + split_string[1] + split_string[2]);
		}
		if (split_string[1] == "/"){
			//pass in whole string eg: 3/4
			store_return = divide.evaluate(split_string[0] + split_string[1] + split_string[2]);
		}
		return store_return;
	}
	//if true -> brackets on left but not right
	if (remove_brackets(split_string[2]) == split_string[2]){
		//check what operation it is
		if (split_string[1] == "+"){
			//pass in whole string eg: expression+4
			store_return = add.evaluate(calculate(split_string[0]) + split_string[1] + split_string[2]);
		}
		if (split_string[1] == "-"){
			//pass in whole string eg: expression-4
			store_return = sub.evaluate(calculate(split_string[0]) + split_string[1] + split_string[2]);
		}
		if (split_string[1] == "*"){
			//pass in whole string eg: expression*4
			store_return = mul.evaluate(calculate(split_string[0]) + split_string[1] + split_string[2]);
		}
		if (split_string[1] == "/"){
			//pass in whole string eg: expression/4
			store_return = divide.evaluate(calculate(split_string[0]) + split_string[1] + split_string[2]);
		}
		return store_return;
	}
	//if true -> brackets on right but not left
	if (remove_brackets(split_string[0]) == split_string[0]){
		//check what operation it is
		if (split_string[1] == "+"){
			//pass in whole string eg: 3+expression
			store_return = add.evaluate(split_string[0] + split_string[1] + calculate(split_string[2]));
		}
		if (split_string[1] == "-"){
			//pass in whole string eg: 3-expression
			store_return = sub.evaluate(split_string[0] + split_string[1] + calculate(split_string[2]));
		}
		if (split_string[1] == "*"){
			//pass in whole string eg: 3*expression
			store_return = mul.evaluate(split_string[0] + split_string[1] + calculate(split_string[2]));
		}
		if (split_string[1] == "/"){
			//pass in whole string eg: 3/expression
			store_return = divide.evaluate(split_string[0] + split_string[1] + calculate(split_string[2]));
		}
		return store_return;
	}
	//if true -> brackets on left AND right
	if (remove_brackets(split_string[0]) != split_string[0] && remove_brackets(split_string[2]) != split_string[2]){
		//check what operation it is
		if (split_string[1] == "+"){
			//pass in whole string eg: 3+expression
			store_return = add.evaluate(calculate(split_string[0]) + split_string[1] + calculate(split_string[2]));
		}
		if (split_string[1] == "-"){
			//pass in whole string eg: 3-expression
			store_return = sub.evaluate(calculate(split_string[0]) + split_string[1] + calculate(split_string[2]));
		}
		if (split_string[1] == "*"){
			//pass in whole string eg: 3*expression
			store_return = mul.evaluate(calculate(split_string[0]) + split_string[1] + calculate(split_string[2]));
		}
		if (split_string[1] == "/"){
			//pass in whole string eg: 3/expression
			store_return = divide.evaluate(calculate(split_string[0]) + split_string[1] + calculate(split_string[2]));
		}
		return store_return;	
	}
}


string remove_brackets(string input){
	string no_brackets = "";
	for (int i = 0; i < input.length(); i++){
		if (i == 0 && input[i] == '('){

		}
		else if (i == input.length() - 1 && input[i] == ')'){

		}
		else{
			no_brackets += input[i];
		}
	}
	return no_brackets;
}

vector<string> split(string input){
	vector<string> split_string(3);

	//Get the left side of the equation
	int open_brackets = 0;
	int closed_brackets = 0;
	int left_end_index = 0;
	string left = "";
	for (int i = 0; i < input.length(); i++){
		if (input[i] == '('){
			open_brackets++;
		}
		if (input[i] == ')'){
			closed_brackets++;
		}
		if (open_brackets == closed_brackets && open_brackets != 0){
			left += input[i];
			left_end_index = i;
			break;
		}
		else{
			left += input[i];
		}
	}

	//Get the operator between each size
	string sign = "";
	int sign_index = 0;
	for (int i = left_end_index + 1; i < input.length(); i++){
		if (input[i] == '('){
			cout << "Expression is not well formed" << endl;
			break;
		}
		if (input[i] == '+'){
			sign = "+";
			sign_index = i;
			break;
		}
		if (input[i] == '-'){
			sign = "-";
			sign_index = i;
			break;
		}
		if (input[i] == '/'){
			sign = "/";
			sign_index = i;
			break;
		}
		if (input[i] == '*'){
			sign = "*";
			sign_index;
			break;
		}
	}

	//Get the right side of the equation
	open_brackets = 0;
	closed_brackets = 0;
	int right_end_index = 0;
	string right = "";
	for (int i = sign_index + 1; i < input.length(); i++){
		if (input[i] == '('){
			open_brackets++;
		}
		if (input[i] == ')'){
			closed_brackets++;
		}
		if (open_brackets == closed_brackets && open_brackets != 0){
			right += input[i];
			right_end_index = i;
			break;
		}
		else{
			right += input[i];
		}
	}

	split_string[0] = left;
	split_string[1] = sign;
	split_string[2] = right;
	return split_string;
}

string breakdown(string input, int &i){
	ae.left->exp = "";
	ae.right->exp = "";
	char op;
	if (input[i] == '('){
		ae.left->exp = breakdown(input, ++i);
	} 
	cout << ae.left->exp << endl;
	if (input[i] == ')'){
		i++;
	}
	while (input[i] >= '0' && input[i] <= '9'){
		ae.left->exp += input[i++];
	}
	op = input[i++];
	if (input[i] == '('){
		ae.right->exp = breakdown(input, ++i);
	}
	else{
		while (input[i] >= '0' && input[i] <= '9'){
			ae.right->exp += input[i];
			i++;
		}
	}
	return calculate(ae.left->exp + op + ae.right->exp);
}