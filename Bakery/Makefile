all: felix.o simon.o
	g++ bin/simon.o bin/felix.o -o main
%.o: %.cpp
	g++ -c src/$< -o bin/$@ -I include/ -std=c++20
