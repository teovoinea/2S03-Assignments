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
#include <cmath>
using namespace std;
string calculate(string input);
double evaluate(string expression);
double applyOp(char op, double b, double a);
bool hasPrecedence(char op1, char op2);
string remove_brackets(string input);
string breakdown(string input, int &i);
string* split(string input);
string encapsulate(string expr);
string desubexpr(string expr, string _subexprs, int exprsCount);
string calculate(string input);
string handleNegatives(string input);
Addition add = Addition();
Subtraction sub = Subtraction();
Multiplication mul = Multiplication();
Division divide = Division();

// TODO 
// (5*2-1)+(3+2) breaks
// any scenario where its a (length 3 expression) op (length 2 expression) only evaluates the first expression


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
	input = handleNegatives(no_space);
	/***************Currently, everything needs to be wrapped in brackets***************/
	//replace ' ' with ''
	cout << input << endl;
	string bedmas = encapsulate(input);
    cout << bedmas << endl;
	int l = 0;
	int m = 0;
	string s = breakdown(bedmas, l);
        //	string calc = breakdown(input, m);

	//cout << "answer: " << calc << endl;
	cout << "answer: " << s << endl;

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

//recursively calculate the value of the expression
//this assumes the expression is completely well formed
//which is why we have the previous steps to encapsulate and
//error check the input
string calculate(string input){
  string* split_string = split(input);
	string store_return = ""; //the final return value for this call
	split_string[0] = remove_brackets(split_string[0]); //the left side of the equation, without brackets
	split_string[2] = remove_brackets(split_string[2]); //the right side of the equation, without brackets
	//if true -> no brackets on either left AND right hand side, can directly be solved
	if (remove_brackets(split_string[0]) == split_string[0] && remove_brackets(split_string[2]) == split_string[2]){
		//check what operation it is
		if (split_string[1] == "+"){
			//pass in whole string eg: "3+4"
			store_return = add.evaluate(split_string[0] + split_string[1] + split_string[2]);
			add.print(split_string[0] + split_string[1] + split_string[2]); //print the input, because we're dealing with only numbers
		}
		if (split_string[1] == "-"){
			//pass in whole string eg: "3-4"
			store_return = sub.evaluate(split_string[0] + split_string[1] + split_string[2]);
			sub.print(split_string[0] + split_string[1] + split_string[2]); //print the input, because we're dealing with only numbers
		}
		if (split_string[1] == "*"){
			//pass in whole string eg: "3*4"
			store_return = mul.evaluate(split_string[0] + split_string[1] + split_string[2]);
			mul.print(split_string[0] + split_string[1] + split_string[2]); //print the input, because we're dealing with only numbers
		}
		if (split_string[1] == "/"){
			//pass in whole string eg: "3/4"
			store_return = divide.evaluate(split_string[0] + split_string[1] + split_string[2]);
			divide.print(split_string[0] + split_string[1] + split_string[2]); //print the input, because we're dealing with only numbers
		}
    delete[] split_string;
		return store_return;
	}
	//if true -> brackets on left but not right
	if (remove_brackets(split_string[2]) == split_string[2]){
		//check what operation it is
		if (split_string[1] == "+"){
			//pass in whole string eg: expression+4
			store_return = add.evaluate(calculate(split_string[0]) + split_string[1] + split_string[2]);
			add.print(split_string[1] + split_string[2]); //print the right half because that's the part that's only numbers
		}
		if (split_string[1] == "-"){
			//pass in whole string eg: expression-4
			store_return = sub.evaluate(calculate(split_string[0]) + split_string[1] + split_string[2]);
			sub.print(split_string[1] + split_string[2]); //print the right half because that's the part that's only numbers
		}	
		if (split_string[1] == "*"){
			//pass in whole string eg: expression*4
			store_return = mul.evaluate(calculate(split_string[0]) + split_string[1] + split_string[2]);
			mul.print(split_string[1] + split_string[2]); //print the right half because that's the part that's only numbers
		}
		if (split_string[1] == "/"){
			//pass in whole string eg: expression/4
			store_return = divide.evaluate(calculate(split_string[0]) + split_string[1] + split_string[2]);
			divide.print(split_string[1] + split_string[2]); //print the right half because that's the part that's only numbers
		}
    delete[] split_string;
		return store_return;
	}
	//if true -> brackets on right but not left
	if (remove_brackets(split_string[0]) == split_string[0]){
		//check what operation it is
		if (split_string[1] == "+"){
			//pass in whole string eg: 3+expression
			store_return = add.evaluate(split_string[0] + split_string[1] + calculate(split_string[2]));
			add.print(split_string[0] + split_string[1]); //print the left half because that's the part that's only numbers
		}
		if (split_string[1] == "-"){
			//pass in whole string eg: 3-expression
			store_return = sub.evaluate(split_string[0] + split_string[1] + calculate(split_string[2]));
			sub.print(split_string[0] + split_string[1]); //print the left half because that's the part that's only numbers
		}
		if (split_string[1] == "*"){
			//pass in whole string eg: 3*expression
			store_return = mul.evaluate(split_string[0] + split_string[1] + calculate(split_string[2]));
			mul.print(split_string[0] + split_string[1]); //print the left half because that's the part that's only numbers
		}
		if (split_string[1] == "/"){
			//pass in whole string eg: 3/expression
			store_return = divide.evaluate(split_string[0] + split_string[1] + calculate(split_string[2]));
			divide.print(split_string[0] + split_string[1]); //print the left half because that's the part that's only numbers
		}
    delete[] split_string;
		return store_return;
	}
	//if true -> brackets on left AND right
	if (remove_brackets(split_string[0]) != split_string[0] && remove_brackets(split_string[2]) != split_string[2]){
		//check what operation it is
		if (split_string[1] == "+"){
			//pass in whole string eg: expression+expression
			store_return = add.evaluate(calculate(split_string[0]) + split_string[1] + calculate(split_string[2]));
			//Don't print anything because we don't have any base numbers
		}
		if (split_string[1] == "-"){
			//pass in whole string eg: expression-expression
			store_return = sub.evaluate(calculate(split_string[0]) + split_string[1] + calculate(split_string[2]));
			//Don't print anything because we don't have any base numbers
		}
		if (split_string[1] == "*"){
			//pass in whole string eg: expression*expression
			store_return = mul.evaluate(calculate(split_string[0]) + split_string[1] + calculate(split_string[2]));
			//Don't print anything because we don't have any base numbers
		}
		if (split_string[1] == "/"){
			//pass in whole string eg: expression/expression
			store_return = divide.evaluate(calculate(split_string[0]) + split_string[1] + calculate(split_string[2]));
			//Don't print anything because we don't have any base numbers
		}
    delete[] split_string;
		return store_return;	
	}
}

string remove_brackets(string input){
	string no_brackets = "";
	int openCount = 0;
	int closeCount = 0;
	bool doBreak = (input[0] == '(' && input[1] == '(');
	for (int i = 0; i < input.size(); i++){
		if (input[i] == '('){
			openCount++;
		}else if (input[i] == ')'){
			closeCount++;
		}
		if (i == input.size()-1 && openCount == closeCount && input[i] == ')' && !doBreak){
			for (int i = 1; i < input.size()-1;i++){
				no_brackets += input[i];
			}
			return no_brackets;
		}else if (!doBreak){

		}
	}
	return input;
}



string* split(string input){
  string* split_string = new string[3];

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
			//cout << "Expression is not well formed" << endl;
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
  cout << "breakdown: " << input.substr(i) << endl;
	char op;
	if (input[i] == '('){
		ae.left->exp = breakdown(input, ++i);
  }else{
    while (input[i] >= '0' && input[i] <= '9'){
      ae.left->exp += input[i++];
    }
  }
	while (input[i] == ')'){
    ++i;
  }
  if(i >= input.length()) return ae.left->exp;
	op = input[i++];
  if(i >= input.length()) return ae.left->exp;
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
  static const char dmas[4] = {'/', '*', '-', '+'};
  int opCount = 0;
  for (int x = 0; x < 4; x++) {
    opCount += count(expr.begin(), expr.end(), dmas[x]);
  }
  if(opCount <= 1) return expr;
  
  string subexprs;
  int exprsCount = 0;
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
			subexprs += expr.substr(opening+1, closing-opening-1);
      exprsCount++;
      subexprs += ",";
      //cout << "add : " << subexprs[subexprs.size()-1] << endl;
			string temp = expr.substr(0, opening);
			temp += "$" + to_string(exprsCount - 1);
			temp += expr.substr(closing+1, expr.length());
			expr = temp;
			i = expr.length()-1;
		}
	}
  opCount = 0;
  for (int x = 0; x < 4; x++) {
    opCount += count(expr.begin(), expr.end(), dmas[x]);
  }
  if(opCount <= 1) return desubexpr(expr,subexprs,exprsCount);
	//the program passes this point for 2+3 but not for 2+3*4
	for (int i = 0; i < 4; i++){ //no foreach in cpp /tear
		for (int j = 0; j < expr.length(); j++){
			if (expr[j] == dmas[i]){ //find the operator
        //cout << "op found at " << j << " : " << expr << endl;
        int k = j-1;
				string left_number = "";
				while ((expr[k] >= '0' && expr[k] <= '9') || expr[k] == '$'){
					k--;
				}
        k++;
        while(k < j){
          left_number+= expr[k];
          k++;
        }
				//cout << "expr is currently: " << expr << endl; you don't want to try to print expr....
				//cout << "Left number: " << left_number << endl;
				int left_length = left_number.length();
        k = j+1;
				string right_number = "";
				while ((expr[k] >= '0' && expr[k] <= '9') || expr[k] == '$'){
					right_number += expr[k];
					k++;
				}
				//cout << "Right number: " << right_number << endl;
				int right_length = right_number.length();
        //cout << "add " << left_number + dmas[i] + right_number << endl;
				subexprs += left_number + dmas[i] + right_number + ",";
        exprsCount++;
        //cout << "add " << subexprs.size()-1 << " : " << subexprs[subexprs.size()-1] << endl;
				string temp = expr.substr(0, j - left_length);
				temp += "$" + to_string(exprsCount - 1);
				temp += expr.substr(j + right_length+1);
				expr = temp;
				i = 0;
        //cout << expr << endl;
        opCount = 0;
        for (int x = 0; x < 4; x++) {
          opCount += count(expr.begin(), expr.end(), dmas[x]);
        }
        if(opCount <= 1) return desubexpr(expr,subexprs,exprsCount);
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
	return desubexpr(expr,subexprs,exprsCount);
}

string desubexpr(string expr, string _subexprs, int exprsCount){
  string* subexprs = new string[exprsCount];
  //cout << "_subexprs = " <<  _subexprs << endl;
  istringstream ss(_subexprs);
  string token;
  int x = 0;
  while(getline(ss,token,',') && x < exprsCount){
    subexprs[x] = token;
    x++;
  }
  for (int i = exprsCount-1; i >= 0; i--){
    string search = "$" + to_string(i);
    size_t startPos = expr.find(search);
    //printf("%i: find %s in %s for %s\n",i,search.c_str(),expr.c_str(),subexprs[i].c_str());
    if(startPos == string::npos) continue;
    int t = 0;
    expr.replace(startPos,search.length(),"(" + encapsulate(subexprs[i]) + ")");
    //printf("%s\n",expr.c_str());
  }
  delete[] subexprs;
  return expr;
}

string handleNegatives(string input){
	string output;
	for (int i = 0; i < input.size(); i++){
		if (input[i] == '(' && input[i+1] == '-'){
			output += "(0";
		}else{
			output += input[i];
		}
	}
	return output;
}
