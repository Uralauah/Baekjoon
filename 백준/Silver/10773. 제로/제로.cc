#include <iostream>
#include <algorithm>
#include <vector>

using namespace std;

int main() {
    long long sum = 0;
    int k, input, temp;
    vector<int> v;
    cin >> k;
    for (int i = 0; i < k; i++) {
        cin >> input;
        if (input == 0) {
            sum -= v.back();
            v.pop_back();
        } else
            v.push_back(input);
        sum += input;
    }
    cout << sum;
}