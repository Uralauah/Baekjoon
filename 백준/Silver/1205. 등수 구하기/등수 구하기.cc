#include <iostream>
#include <vector>
#include <algorithm>

using namespace std;
vector<pair<int, int>> v;
vector<pair<int, int>> line;

bool cmp(pair<int, int> a, pair<int, int> b) {
    return a.first > b.first;
}

void a(int input) {
    bool find = false;
    for (int j = 0; j < v.size(); j++) {
        if (v[j].first == input) {
            find = true;
            v[j].second++;
            break;
        }
    }
    if (!find) {
        v.push_back({input, 1});
        line.push_back({input, 1});
    }
}

int main() {

    int n, score, p, input;
    cin >> n >> score >> p;
    for (int i = 0; i < n; i++) {
        cin >> input;
        a(input);
    }
    a(score);
    sort(v.begin(), v.end(), cmp);
    sort(line.begin(), line.end(), cmp);

    for (int i = 1; i < v.size(); i++) {
        line[i].second = v[i - 1].second + line[i - 1].second;
    }

//    for (int i = 0; i < line.size(); i++) {
//        cout << v[i].first << " " << v[i].second << endl;
//    }
//    cout << endl;
//    for (int i = 0; i < line.size(); i++) {
//        cout << line[i].first << " " << line[i].second << endl;
//    }

    bool find = false;
    for (int i = 0; i < line.size(); i++) {
        if (line[i].first == score) {
            if (line[i].second + v[i].second - 1 > p) {
                break;
            }
            find = true;
            cout << line[i].second;
            break;
        }
    }
    if (!find)
        cout << -1;
}