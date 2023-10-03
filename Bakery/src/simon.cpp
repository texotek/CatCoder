#include <iostream>
#include <vector>
#include <algorithm>
#include <felix.hpp>
#include <simon.hpp>

using namespace std;

int level1(vector<Day> earnings, vector<Day> payments) {
    if(earnings.size() != payments.size()) {
        cerr << "earnings and payments are not of the same size\n";
        exit(1);
    }

    for(int i{}; i < earnings.size(); ++i) {
        if(payments[i].money > earnings[i].money) {
            return i;
        }
    }
    return -1;
}
