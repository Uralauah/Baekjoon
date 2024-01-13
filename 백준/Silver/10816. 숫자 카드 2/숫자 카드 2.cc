#include <iostream>
#include <queue>
#include <algorithm>
#include <map>

using namespace std;


int main() {
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);
    int n, input;
    cin >> n;
    map<int, int> card;
    for (int i = 0; i < n; i++) {
        cin >> input;
        card[input]++;
    }

    cin >> n;
    for (int i = 0; i < n; i++) {
        cin >> input;
        if (card[input])
            cout << card[input] << " ";
        else
            cout << 0 << " ";
    }
}
