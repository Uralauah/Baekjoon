#include <iostream>
#include <vector>
#include <algorithm>

using namespace std;

pair<int, string> user[100001];
int n;

bool cmp(pair<int, string> a, pair<int, string> b) {
    return a.first < b.first;
}

int main() {
    int age;
    string name;
    cin >> n;
    for (int i = 0; i < n; i++) {
        cin >> age >> name;
        user[i] = pair<int, string>(age, name);
    }
    stable_sort(user, user + n, cmp);
    for (int i = 0; i < n; i++) {
        cout << user[i].first << " " << user[i].second << "\n";
    }
}