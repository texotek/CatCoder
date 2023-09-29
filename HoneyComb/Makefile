all: main.o
	g++ main.o -o main

main.o: main.cpp
	g++ -c -g main.cpp -o main.o -std=c++20

clean:
	rm main main.o
