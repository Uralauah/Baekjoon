#include <iostream>
#include <vector>

using namespace std;

vector<long long> v;
int n;

int main() {
    cin >> n;
    long long a;
    for (int i = 0; i < n; i++) {
        cin >> a;
        v.push_back(a);
    }
    long long sum = 1;
    long long temp = 1;
    for (int i = v.size() - 2; i >= 0; i--) {
        if (v[i] > temp) {
            sum += temp + 1;
            temp++;
        } else {
            sum += v[i];
            temp = v[i];
        }
    }
    cout << sum;
}