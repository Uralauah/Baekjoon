#include <iostream>
#include <map>
#include <string>
#include <algorithm>

using namespace std;

int main() {
    ios::sync_with_stdio(false);
    cin.tie(NULL);
    int n, m;
    string name;
    map<int, string> findbyid;
    map<string, int> findbyname;
    bool isnum;

    cin >> n >> m;
    for (int i = 0; i < n; i++) {
        cin >> name;
        findbyid.insert({i + 1, name});
        findbyname.insert({name, i + 1});
    }
    for (int i = 0; i < m; i++) {
        cin >> name;
        isnum = true;
        for (int j = 0; j < name.length(); j++) {
            if (isdigit(name[j]) == 0) {
                isnum = false;
                break;
            }
        }
        if (isnum) {
            int a = stoi(name);
            auto it = findbyid.find(a);
            cout << it->second << '\n';
        } else {
            auto it = findbyname.find(name);
            cout << it->second << '\n';
        }
    }
}