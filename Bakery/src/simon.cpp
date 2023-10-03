#include <iostream>
#include <vector>
#include <algorithm>
#include <felix.hpp>
#include <simon.hpp>

using namespace std;

string level1(vector<Day> earnings, vector<Day> payments) {
    string out{};
    if(earnings.size() != payments.size()) {
        cerr << "earnings and payments are not of the same size\n";
        exit(1);
    }

    for(int i{}; i < earnings.size(); ++i) {
        if(earnings[i].money > payments[i].money) {
            out += to_string(i+1) + " ";
        }
    }
    return out;
}
