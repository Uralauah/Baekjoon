#include <iostream>
#include <string>

using namespace std;

int main() {
    int n, sum = 0;
    string input;
    cin >> n;
    cin >> input;
    for (int i = 0; i < n; i++) {
        sum += (int) input[i] - (int) '0';
    }
    cout << sum;
}