#include <iostream>
#include <vector>
#include <algorithm>
#include <felix.hpp>
#include <simon.hpp>

using namespace std;

string level1(vector<Day> earnings, vector<Day> payments) {
    cout << "starting level1\n";
    string out{};
    if(earnings.size() != payments.size()) {
        cerr << "earnings and payments are not of the same size\n";
        exit(1);
    }

    for(int i{}; i < earnings.size(); ++i) {
        if(earnings[i].money > payments[i].money) {
            cout << "day " << i+1 << " added\n";
            out += to_string(i+1) + " ";
        }
    }
    return out;
}
