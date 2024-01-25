#include <iostream>
#include <vector>
#include <string>
#include <algorithm>
#include <set>

using namespace std;


int main() {
    string input;
    int n, p, game_sum = 0, sum = 0;
    char game;
    set<string> s;
    cin >> n >> game;
    if (game == 'Y')
        p = 1;
    else if (game == 'F')
        p = 2;
    else
        p = 3;
    for (int i = 0; i < n; i++) {
        cin >> input;
        s.insert(input);
    }
    cout << s.size() / p;
}