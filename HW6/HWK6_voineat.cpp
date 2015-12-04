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
string encapsulate(string expr);
string desubexpr(string expr, vector<string> subexprs);
//string calculate(string input);
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
	string no_space = "";
	for (int i = 0; i < input.length(); i++){
		if (input[i] != ' '){
			no_space += input[i];
		}
	}
	input = no_space;
	/***************Currently, everything needs to be wrapped in brackets***************/
	//replace ' ' with ''
	string bedmas = encapsulate(input);
	cout << "Encapsulate returns: " << bedmas << endl;
	int l = 0;
	string s = breakdown(bedmas, l);
	cout << "Breakdown returns: " << s << endl;
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
  ArithmeticExpression ae;
	ae.left->exp = "";
	ae.right->exp = "";
	char op;
	if (input[i] == '('){
		ae.left->exp = breakdown(input, ++i);
  }else{
    while (input[i] >= '0' && input[i] <= '9'){
      ae.left->exp += input[i++];
    }
  }
  
	if (input[i] == ')'){
    ++i;
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

string encapsulate(string expr){
  static const char dmas[4] = {'/', '*', '+', '-'};
  int opCount = 0;
  for (int x = 0; x < 4; x++) {
    opCount += count(expr.begin(), expr.end(), dmas[x]);
  }
  if(opCount <= 1) return expr;
  
	vector<string> subexprs;
  int opening,closing;
	for (int i = expr.length()-1; i >= 0; i--){ //looping backwards 'cause Nick said so
		if (expr[i] == '('){
			opening = i;
			for (int j = i; j < expr.length(); j++){
				if (expr[j] == ')'){
					closing = j;
					break;
				}
			}
			subexprs.push_back(expr.substr(opening+1, closing-opening-1));
      //cout << "add : " << subexprs[subexprs.size()-1] << endl;
			string temp = expr.substr(0, opening);
			temp += "$" + to_string(subexprs.size() - 1);
			temp += expr.substr(closing+1, expr.length());
			expr = temp;
			i = 0;
			break;
		}
	}
  opCount = 0;
  for (int x = 0; x < 4; x++) {
    opCount += count(expr.begin(), expr.end(), dmas[x]);
  }
  if(opCount <= 1) return desubexpr(expr,subexprs);
	//the program passes this point for 2+3 but not for 2+3*4
	for (int i = 0; i < 4; i++){ //no foreach in cpp /tear
		for (int j = 0; j < expr.length(); j++){
			if (expr[j] == dmas[i]){ //find the operator
        //cout << "opp found at " << j << " : " << expr << endl;
        int k = j-1;
				string left_number = "";
				while ((expr[k] >= '0' && expr[k] <= '9') || expr[k] == '$'){
					left_number+= expr[k];
					k--;
				}
				//cout << "expr is currently: " << expr << endl; you don't want to try to print expr....
				//cout << "Left number: " << left_number << endl;
				int left_length = left_number.length();
        k = j+1;
				string right_number = "";
				while ((expr[k] >= '0' && expr[k] <= '9') || expr[k] == '$'){
					right_number+= expr[k];
					k++;
          
				}
				//cout << "Right number: " << right_number << endl;
				int right_length = right_number.length();
				subexprs.push_back(expr.substr(j - left_length, j + right_length+1));
        //cout << "add " << subexprs.size()-1 << " : " << subexprs[subexprs.size()-1] << endl;
				string temp = expr.substr(0, j - left_length);
				temp += "$" + to_string(subexprs.size() - 1);
				temp += expr.substr(j + right_length+1);
				expr = temp;
				i = 0;
        opCount = 0;
        for (int x = 0; x < 4; x++) {
          opCount += count(expr.begin(), expr.end(), dmas[x]);
        }
        if(opCount <= 1) return desubexpr(expr,subexprs);
			}
		}
	}
	/*for (int i = subexprs.size(); i > 0; i--){
		//replace doesn't work how you want it to in cpp /tear expr = expr.replace("$"+i, "(" + subexprs[i] + ")");
		for (int j = 0; j < expr.length() - 1; j++){
    string search = "$" + std::to_string(i);
    printf("find %s",search.c_str());
    size_t startPos = expr.find(search);
    if(startPos == string::npos) continue;
    expr.replace(startPos,search.length(),subexprs[i]);
			string s1 = std::to_string(expr[j]) + std::to_string(expr[j+1]);
			if (!s1.compare(s2)){ //compare returns 0 on equality, that's why there's !
				temp += "(" + subexprs[i] + ")";
			}
			else{
				temp += expr[j];
			}
			expr = temp;
		}
	}*/
	return desubexpr(expr,subexprs);
}

string desubexpr(string expr, vector<string> subexprs){
  for (int i = subexprs.size()-1; i >= 0; i--){
    string search = "$" + to_string(i);
    //printf("%i: find %s in %s\n",i,search.c_str(),expr.c_str());
    size_t startPos = expr.find(search);
    if(startPos == string::npos) continue;
    int t = 0;
    expr.replace(startPos,search.length(),"(" + encapsulate(subexprs[i]) + ")");
    //printf("%s\n",expr.c_str());
  }
  return expr;
}