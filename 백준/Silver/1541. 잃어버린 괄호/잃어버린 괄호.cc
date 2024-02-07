#include <iostream>
#include <string>

using namespace std;

int main() {
    string input;
    cin >> input;
    int start = 0, sum = 0;
    bool minus = false;
    for (int i = 0; i < input.length(); i++) {
        if (input[i] == '-' || input[i] == '+') {
            int temp = stoi(input.substr(start, i - start));
            start = i + 1;
            //cout << temp << " " << sum << endl;
            if (input[i] == '-') {
                if (!minus) {
                    sum += temp;
                    minus = true;
                    continue;
                }
                minus = true;
            }
            if (minus) {
                sum -= temp;
            } else {
                sum += temp;
            }
        }
    }
    int temp = stoi(input.substr(start, input.length() - start));
    if (minus) {
        sum -= temp;
    } else {
        sum += temp;
    }
    cout << sum;
}