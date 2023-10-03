#include <iostream>
#include <vector>
#include <fstream>
#include <simon.hpp>
#include <felix.hpp>

using namespace std;

int main (int argc, char *argv[]) {
    vector<Day> earnings{};
    vector<Day> payments{};

    fstream file{"input.txt"};

    string text{};
    do {
        file >> text; 
            
           if(text == "F") {
               file >> text;
               file >> text;
               Day d;
               d.money = stoi(text);
               earnings.push_back(d);
           }
           if(text == "B") {
               file >> text;
               file >> text;
               Day d;
               d.money = stoi(text);
               payments.push_back(d);
           }
    } while(file);
    cout << level1(earnings, payments);
   return 0;
}
