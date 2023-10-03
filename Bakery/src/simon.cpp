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
        return{};
    }

    for(int i{}; i < earnings.size(); ++i) {
        cout << "comparing earning " << i << " with " << earnings[i].money;
        cout << " and payments with " << payments[i].money <<'\n';
        if(earnings[i].money > payments[i].money) {
            cout << "day " << i << " added\n";
            out += to_string(i) + " ";
        }
    }
    return out;
}
