#include <string>
#include <iostream>

int fibonnaci(int);

int main (int argc, char *argv[]) {

    if (argc < 2) {
        std::cout << "Please give a argument" << std::endl;
        return 1;
    }

    int number = std::stoi(argv[1]);

    std::cout << number << std::endl;
    std::cout << fibonnaci(number) << std::endl;
    return 0;
}

int fibonnaci(int number) {
    if(number <= 0) return 0;
    else if(number == 1) return 1;
    return fibonnaci(number - 1) + fibonnaci(number - 2);
}
