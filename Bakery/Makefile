all: felix.o simon.o
	g++ bin/simon.o bin/felix.o -o main

%.o: src/%.cpp
	g++ -g -c $< -o bin/$@ -I include/ -std=c++20
