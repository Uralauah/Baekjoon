#include <iostream>
#include <vector>
#include <string>
#include <algorithm>

using namespace std;

bool arr[21];

void add(int x) {
    if (!arr[x])
        arr[x] = true;
}

void remove(int x) {
    if (arr[x])
        arr[x] = false;
}

void check(int x) {
    if (arr[x])
        cout << 1 << '\n';
    else
        cout << "0\n";
}

void toggle(int x) {
    if (arr[x])
        arr[x] = false;
    else
        arr[x] = true;
}

void all() {
    for (int i = 1; i < 21; i++)
        arr[i] = true;
}

void empty() {
    for (int i = 1; i < 21; i++)
        arr[i] = false;
}

int main() {
    ios::sync_with_stdio(false);
    cin.tie(NULL);
    int m, n;
    string input;
    cin >> m;
    for (int i = 0; i < m; i++) {
        cin >> input;
        if (input == "all") {
            all();
        } else if (input == "empty")
            empty();
        else {
            cin >> n;
            if (input == "add")
                add(n);
            else if (input == "remove")
                remove(n);
            else if (input == "check")
                check(n);
            else if (input == "toggle")
                toggle(n);
        }
    }
}