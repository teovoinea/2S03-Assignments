OBJS = Addition.o ArithmeticExpression.o Division.o Expression.o Multiplication.o Subtraction.o HWK6_voineat.o
.SUFFIXES: .o.cpp

all: HWK6_voineat

HWK6_voineat: $(OBJS)
	g++ -o $@ $?
	./HWK6_voineat
.cpp.o:
	$(CXX) -std=c++0x -c $<
clean:
	rm HWK6_voineat *.o
