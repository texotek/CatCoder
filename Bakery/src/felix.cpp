#include <iostream>
#include <vector>
#include <simon.hpp>
#include <felix.hpp>

using namespace std;

int main (int argc, char *argv[]) {
    vector<Day> earnings{};
    vector<Day> payments{};

    string text{};
        do {
           cin >> text; 
            
           if(text == "F") {
               cin >> text;
               cin >> text;
               Day d;
               d.money = stoi(text);
               earnings.push_back(d);
           }
           if(text == "B") {
               cin >> text;
               cin >> text;
               Day d;
               d.money = stoi(text);
               payments.push_back(d);
           }
    } while(text != "exit");
    cout << level1(earnings, payments);
   return 0;
}
