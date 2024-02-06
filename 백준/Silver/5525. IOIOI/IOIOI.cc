#include <iostream>
#include <string>

using namespace std;

int main() {
    int n, m, sum = 0;
    string input;
    string io = "I";
    cin >> n >> m >> input;
    for (int i = 0; i < n; i++) {
        io += "OI";
    }
    for (int i = 0; i < m; i++) {
        if (input[i] == 'I') {
            if (input.substr(i, 2 * n + 1) == io)
                sum++;
        }
    }
    cout << sum;
}