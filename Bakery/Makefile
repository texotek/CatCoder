all: felix.o simon.o
	g++ bin/simon.o bin/felix.o -o main

felix.o: src/felix.cpp
	g++ -c $< -o bin/$@ -I include/ -std=c++20
simon.o: src/simon.cpp
	g++ -c $< -o bin/$@ -I include/ -std=c++20
