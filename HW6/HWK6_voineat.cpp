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
#include <string>
#include <sstream>
#include <vector>
#include <stack>
using namespace std;
int evaluate(string expression);
int applyOp(char op, int b, int a);
bool hasPrecedence(char op1, char op2);
string remove_brackets(string input);
vector<string> split(string input);
//string calculate(string input);
Addition add(); //Addition().evaluate("3+4") -> "7.0000"
Subtraction sub();
Multiplication mul();
Division div();
int main(){
	//Get input
	cout << "Please enter an expression: ";
	string input;
	getline(cin, input);
	string output = "0";
	/***************Currently, everything needs to be wrapped in brackets***************/
	//replace ' ' with ''
	string no_space = ""; 
	for(int i =0; i < input.length(); i++){
		if (input[i] != ' '){
			no_space += input[i];
		}
	}
	input = no_space;
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
	cout << input << " = " << output << endl;
}

int evaluate(string expression){
	std::stack<double> values;
	std::stack<char> ops;

	for (int i = 0; i < expression.length(); i++){
		if (expression[i] == ' '){
			continue;
		}
		if (expression[i] >= '0' && expression[i] <= '9'){
			string num = "";
			while(i < expression.length() && expression[i] >= '0' && expression[i] <= '9'){
				num += expression[i++];
			}
			double d = 0;
			std::istringstream(num) >> d;
			values.push(d);
		}
		else if(expression[i] == '('){
			ops.push(expression[i]);
		}
		else if(expression[i] == ')'){
			while(ops.top() != '('){
				values.push(applyOp(ops.pop(), values.pop(), values.pop()));
			}
			ops.pop();
		}
		else if(expression[i] == '+' || expression[i] == '-' || expression[i] == '*' || expression[i] == '/'){
			while(!ops.empty() && hasPrecedence(expression[i], ops.top())){
				values.push(applyOp(ops.pop(), values.pop(), values.pop()));
			}
			ops.push(expression[i]);
		}
	}
	while(!ops.empty()){
		values.push(applyOp(ops.pop(), values.pop(), values.pop()));
	}
	return values.pop();
}

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

int applyOp(char op, int b, int a){
	string s = "";
	s += std::to_string(a);
	s += op;
	s += std::to_string(b);
	string r = "";
	double res = 0;
	switch(op){
		case '+':
			r = Addition().evaluate(s);
			std::istringstream(r) >> res;
			return res;
		case '-':
			r = Subtraction().evaluate(s);
			std::istringstream(r) >> res;
			return res;
		case '*':
			r = Multiplication().evaluate(s);
			std::istringstream(r) >> res;
			return res;
		case '/':
			r = Division().evaluate(s);
			std::istringstream(r) >> res;
			return res;
	}
	return 0;
}

/*
string caluclate(string input){
	vector<string> split_string = split(input);
	double total = 0;
	string store_return = "";
	//if true -> no brackets on either left AND right hand side, can directly be solved
	if (remove_brackets(split_string[0]) == split_string[0] && remove_brackets(split_string[2]) == split_string[2]){
		//check what operation it is
		if (split_string[1] == '+'){
			//pass in whole string eg: 3+4
			store_return = add::evaluate(split_string[0] + split_string[1] + split_string[2]);
		}
		if (split_string[1] == '-'){
			//pass in whole string eg: 3-4
			store_return = sub::evaluate(split_string[0] + split_string[1] + split_string[2]);
		}
		if (split_string[1] == '('){
			//pass in whole string eg: 3*4
			store_return = mul::evaluate(split_string[0] + split_string[1] + split_string[2]);
		}
		if (split_string[1] == '/'){
			//pass in whole string eg: 3/4
			store_return = div::evaluate(split_string[0] + split_string[1] + split_string[2]);
		}
		return store_return;
	}
	//if true -> brackets on left but not right
	if (remove_brackets(split_string[2]) == split_string[2]){
		//check what operation it is
		if (split_string[1] == '+'){
			//pass in whole string eg: expression+4
			store_return = add::evaluate(calculate(split_string[0]) + split_string[1] + split_string[2]);
		}
		if (split_string[1] == '-'){
			//pass in whole string eg: expression-4
			store_return = sub::evaluate(calculate(split_string[0]) + split_string[1] + split_string[2]);
		}
		if (split_string[1] == '('){
			//pass in whole string eg: expression*4
			store_return = mul::evaluate(calculate(split_string[0]) + split_string[1] + split_string[2]);
		}
		if (split_string[1] == '/'){
			//pass in whole string eg: expression/4
			store_return = div::evaluate(calculate(split_string[0]) + split_string[1] + split_string[2]);
		}
		return store_return;
	}
	//if true -> brackets on right but not left
	if (remove_brackets(split_string[0]) == split_string[0]){
		//check what operation it is
		if (split_string[1] == '+'){
			//pass in whole string eg: 3+expression
			store_return = add::evaluate(split_string[0] + split_string[1] + calculate(split_string[2]));
		}
		if (split_string[1] == '-'){
			//pass in whole string eg: 3-expression
			store_return = sub::evaluate(split_string[0] + split_string[1] + calculate(split_string[2]));
		}
		if (split_string[1] == '('){
			//pass in whole string eg: 3*expression
			store_return = mul::evaluate(split_string[0] + split_string[1] + calculate(split_string[2]));
		}
		if (split_string[1] == '/'){
			//pass in whole string eg: 3/expression
			store_return = div::evaluate(split_string[0] + split_string[1] + calculate(split_string[2]));
		}
		return store_return;
	}
	//if true -> brackets on left AND right
	if (remove_brackets(split_string[0]) != split_string[0] && remove_brackets(split_string[2]) != split_string[2]){
		//check what operation it is
		if (split_string[1] == '+'){
			//pass in whole string eg: 3+expression
			store_return = add::evaluate(calculate(split_string[0]) + split_string[1] + calculate(split_string[2]));
		}
		if (split_string[1] == '-'){
			//pass in whole string eg: 3-expression
			store_return = sub::evaluate(calculate(split_string[0]) + split_string[1] + calculate(split_string[2]));
		}
		if (split_string[1] == '('){
			//pass in whole string eg: 3*expression
			store_return = Multiplication::evaluate(calculate(split_string[0]) + split_string[1] + calculate(split_string[2]));
		}
		if (split_string[1] == '/'){
			//pass in whole string eg: 3/expression
			store_return = Division::evaluate(calculate(split_string[0]) + split_string[1] + calculate(split_string[2]));
		}
		return store_return;	
	}
}*/

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