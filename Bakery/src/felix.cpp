#include <iostream>
#include <vector>
#include <fstream>
#include <simon.hpp>
#include <felix.hpp>

using namespace std;

int main (int argc, char *argv[]) {
    vector<Day> earnings{1000};
    vector<Day> payments{1000};

    fstream file{"input.txt"};

    string text{};
    do {
        file >> text; 
        int day;
        file >> day;

        if(text == "F") {
           file >> text;
           Day d;
           d.money = stoi(text);
           earnings[day] = d;
       }
       if(text == "B") {
           file >> text;
           Day d;
           d.money = stoi(text);
           payments[day] = d;
       }
    } while(file);
    cout << level1(earnings, payments);
   return 0;
}
