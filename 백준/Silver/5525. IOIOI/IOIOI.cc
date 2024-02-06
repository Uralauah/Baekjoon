#include <iostream>
#include <string>

using namespace std;

int main() {
    ios::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);
    int n, m, sum = 0;
    string input;
    string io = "I";
    cin >> n >> m >> input;
    for (int i = 0; i < n; i++) {
        io += "OI";
    }
    for (int i = 0; i < m; i++) {
        int temp = 0;
        if (input[i] == 'I') {
            while (true) {
                if (input[i + 1] != 'O' || input[i + 2] != 'I')
                    break;
                temp++;
                if (temp == n) {
                    temp--;
                    sum++;
                }
                i += 2;
            }
        }
    }
    cout << sum;
}