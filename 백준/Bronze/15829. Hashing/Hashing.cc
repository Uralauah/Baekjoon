#include <iostream>
#include <cmath>
#include <string>

#define M 1234567891

using namespace std;

int main() {
    ios::sync_with_stdio(0);
    cin.tie(0);
    string input;
    int l, n;
    long long sum = 0, r = 1;
    cin >> l >> input;

    for (int i = 0; i < l; i++) {
        n = input[i] - 'a' + 1;

        sum = (sum + n * r) % M;
        r = r * 31 % M;
    }
    cout << sum % 1234567891;
}