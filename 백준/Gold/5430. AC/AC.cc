#include <iostream>
#include <deque>
#include <sstream>
#include <string>

using namespace std;

int main() {
    int t, n, num;
    string p, input;
    cin >> t;
    stringstream stream;
    deque<int> d;
    bool reverse, fail;
    while (t--) {
        reverse = false;
        fail = false;
        d.clear();
        cin >> p >> n >> input;
        string temp = input.substr(1, input.length() - 2);
        int idx = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 1; j <= 4; j++) {
                if (temp[idx + j] == ',' || idx + j == temp.length()) {
                    string tmp = temp.substr(idx, j);
                    d.push_back(stoi(tmp));
                    idx += j + 1;
                    break;
                }
            }
        }
        for (int i = 0; i < p.length(); i++) {
            if (p[i] == 'R')
                reverse = !reverse;
            if (p[i] == 'D') {
                if (d.empty()) {
                    fail = true;
                    break;
                }
                if (reverse)
                    d.pop_back();
                else {
                    d.pop_front();
                }
            }
        }
        if (fail)
            cout << "error" << "\n";
        else {
            if (d.empty()) {
                cout << "[]\n";
                continue;
            }
            if (!reverse) {
                cout << "[";
                for (int i = 0; i < d.size() - 1; i++)
                    cout << d[i] << ",";
                cout << d[d.size() - 1] << "]\n";
            } else {
                cout << "[";
                for (unsigned long i = d.size() - 1; i > 0; i--)
                    cout << d[i] << ",";
                cout << d[0] << "]\n";
            }
        }
    }
}