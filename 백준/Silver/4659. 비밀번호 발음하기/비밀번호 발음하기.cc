#include <iostream>
#include <vector>
#include <string>
#include <algorithm>

using namespace std;


int main() {
    string input;
    vector<char> mo = {'a', 'e', 'i', 'o', 'u'};
    int mo_sum = 0, ja_sum = 0;
    bool mo_in = false, accept;
    while (1) {
        cin >> input;
        if (input == "end")
            break;
        mo_in = false, accept = true;
        mo_sum = 0, ja_sum = 0;
        for (int i = 0; i < input.length(); i++) {
            auto it = find(mo.begin(), mo.end(), input[i]);
            if (it != mo.end()) {
                mo_in = true;
                mo_sum++;
                ja_sum = 0;
            } else {
                mo_sum = 0;
                ja_sum++;
            }
            if (ja_sum >= 3 || mo_sum >= 3) {
                accept = false;
                break;
            }
            if (i >= 1 && input[i] == input[i - 1]) {
                if (input[i] == 'e' || input[i] == 'o')
                    continue;
                accept = false;
                break;
            }
        }
        if (!mo_in)
            accept = false;
        if (accept) {
            cout << "<" << input << "> is acceptable." << "\n";
        } else {
            cout << "<" << input << "> is not acceptable." << "\n";
        }
    }
}