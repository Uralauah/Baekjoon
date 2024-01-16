#include <iostream>
#include <cmath>
#include <string>

using namespace std;

int main() {
    string input;
    int l, n;
    long long sum = 0;
    cin >> l >> input;

    for (int i = 0; i < l; i++) {
        n = input[i] - 'a' + 1;
        
        sum += n * pow(31, i);
    }
    cout << sum % 1234567891;
}