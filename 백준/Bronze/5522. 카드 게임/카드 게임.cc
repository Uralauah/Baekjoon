#include <iostream>

using namespace std;

int main() {
    ios::sync_with_stdio(0);
    cin.tie(0);
    int sum = 0, input;
    for (int i = 0; i < 5; i++) {
        cin >> input;
        sum += input;
    }
    cout << sum;
}