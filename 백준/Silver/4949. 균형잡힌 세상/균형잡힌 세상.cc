
#include <iostream>
#include <vector>
#include <string>

using namespace std;

bool balance(string input) {
    vector<char> v;
    for (int i = 0; i < input.length(); i++) {
        if (input[i] == '(') {
            v.push_back(')');
        }
        if (input[i] == '[')
            v.push_back(']');
        if (input[i] == ')' || input[i] == ']') {
            if (v.empty())
                return false;
            if (v.back() == input[i])
                v.pop_back();
            else
                return false;
        }
    }
    if (v.empty())
        return true;
    else
        return false;
}

int main() {
    string input;
    while (true) {

        getline(cin, input);
        if (input == ".")
            break;
        if (balance(input))
            cout << "yes" << "\n";
        else
            cout << "no" << "\n";
    }
}