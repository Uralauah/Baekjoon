#include <iostream>

using namespace std;

int n, m, arr[201];

int Find(int a) {
    if (arr[a] == a)
        return a;
    return arr[a] = Find(arr[a]);
}

void Union(int i, int j) {
    i = Find(i);
    j = Find(j);
    if (i == j)
        return;
    arr[i] = j;
    Find(i);

}

int main() {
    cin >> n >> m;
    int input;
    for (int i = 1; i <= n; i++)
        arr[i] = i;
    for (int i = 1; i <= n; i++) {
        for (int j = 1; j <= n; j++) {
            cin >> input;
            if (input == 1)
                Union(i, j);
            
        }
    }
    int cur, next;
    bool trip = true;
    cin >> cur;
    for (int i = 1; i < m; i++) {
        cin >> next;
        if (Find(cur) != Find(next))
            trip = false;
        if (!trip)
            break;
        cur = next;
    }
    if (trip)
        cout << "YES";
    else
        cout << "NO";
}