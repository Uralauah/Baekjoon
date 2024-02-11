#include <iostream>
#include <vector>

using namespace std;

vector<int> person[51];
vector<int> party[51];
vector<int> tp;
bool impossible[51], truth[51];
int sum, n, m, p;

void find(int num) {
    int temp;
    for (int i = 0; i < person[num].size(); i++) {
        temp = person[num][i];
        if (!impossible[temp]) {
            impossible[temp] = true;
            sum--;
            for (int j = 0; j < party[temp].size(); j++) {
                if (!truth[party[temp][j]]) {
                    truth[party[temp][j]] = true;
                    find(party[temp][j]);
                }
            }
        }
    }
}

int main() {
    int input, a;
    cin >> n >> m >> p;
    sum = m;
    for (int i = 0; i < p; i++) {
        cin >> input;
        truth[input] = true;
        tp.push_back(input);
    }
    for (int i = 0; i < m; i++) {
        cin >> a;
        for (int j = 0; j < a; j++) {
            cin >> input;
            party[i].push_back(input);
            person[input].push_back(i);
        }
    }
    for (int i = 0; i < p; i++) {
        find(tp[i]);
    }
    cout << sum;
}