#include <iostream>
#include <vector>

using namespace std;

char v[26][2];

void pre(int num) {
    cout << (char) (num + 'A');
    if (v[num][0] != '.')
        pre(v[num][0] - 'A');
    if (v[num][1] != '.')
        pre(v[num][1] - 'A');
}

void in(int num) {
    if (v[num][0] != '.')
        in(v[num][0] - 'A');
    cout << (char) (num + 'A');
    if (v[num][1] != '.')
        in(v[num][1] - 'A');
}

void post(int num) {
    if (v[num][0] != '.') {
        post(v[num][0] - 'A');
    }
    if (v[num][1] != '.') {
        post(v[num][1] - 'A');
    }
    cout << (char) (num + 'A');
}

int main() {
    int n;
    char head, t1, t2;
    cin >> n;
    for (int i = 0; i < n; i++) {
        cin >> head >> t1 >> t2;
        v[(int) (head - 'A')][0] = t1;
        v[(int) (head - 'A')][1] = t2;
    }
//    for (int i = 0; i < n; i++) {
//        cout << (char) (i + 'A') << " " << v[i][0] << " " << v[i][1] << endl;
//    }
    pre(0);
    cout << '\n';
    in(0);
    cout << '\n';
    post(0);
}