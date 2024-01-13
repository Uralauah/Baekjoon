#include <iostream>

using namespace std;

long int arr[31][31] = {0};

long int bridge(int n, int r) {
    if (arr[n][r])
        return arr[n][r];
    else {
        arr[n][r] = bridge(n - 1, r - 1) + bridge(n - 1, r);
        return arr[n][r];
    }
}

int main() {
    int n, m, t;
    cin >> t;
    for (int i = 0; i < 31; i++) {
        arr[i][0] = 1;
        arr[i][i] = 1;
    }
    for (int i = 0; i < t; i++) {
        cin >> n >> m;
        cout << bridge(m, n)<<"\n";
    }

}