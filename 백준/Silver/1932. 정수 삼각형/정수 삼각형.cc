#include <iostream>
#include <vector>

using namespace std;

vector<vector<int>> v;
int n;

void dp() {
    for (int i = 1; i < n; i++) {
        for (int j = 0; j < v[i].size() - 1; j++) {
            if (j == 0) {
                v[i][j] += v[i - 1][j];
            } else
                v[i][j] = max(v[i - 1][j - 1] + v[i][j], v[i - 1][j] + v[i][j]);
        }
    }
}

int main() {
    int input;
    cin >> n;
    v.resize(n);
    for (int i = 0; i < n; i++) {
        for (int j = 0; j < i + 1; j++) {
            cin >> input;
            v[i].push_back(input);
        }
        v[i].push_back(0);
    }
    dp();
    int max = v[n - 1][0];
    for (int i = 1; i < v[n - 1].size() - 1; i++) {
        if (v[n - 1][i] > max)
            max = v[n - 1][i];
    }
    cout << max;
}