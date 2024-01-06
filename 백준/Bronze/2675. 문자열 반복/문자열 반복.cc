#include <iostream>
#include <string>

using namespace std;

int main() {
    int s, r;
    string input;
    char n;
    cin >> s;
    for (int i = 0; i < s; i++) {
        cin >> r;
        cin >> input;
        for (int j = 0; j < input.length(); j++) {
            for (int k = 0; k < r; k++) {
                cout << input[j];
            }
        }
        cout << endl;
    }
}