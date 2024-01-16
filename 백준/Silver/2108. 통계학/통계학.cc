
#include <iostream>
#include <vector>
#include <cmath>
#include <algorithm>

using namespace std;

int main() {
    int n, input, max_num = -5000, min_num = 5000, max = 1;
    vector<int> v;
    double sum = 0;
    int arr[8001] = {0}, all[500001];
    cin >> n;
    for (int i = 0; i < n; i++) {
        cin >> input;
        sum += input;
        if (min_num > input)
            min_num = input;
        if (max_num < input)
            max_num = input;
        all[i] = input;
        arr[input + 4000]++;
    }
    cout << floor(sum / n + 0.5) << "\n";
    sort(all, all + n);
    cout << all[n / 2] << "\n";
    for (int i = 0; i < 8001; i++) {
        if (max == arr[i]) {
            v.push_back(i - 4000);
        }
        if (max < arr[i]) {
            v.clear();
            v.push_back(i - 4000);
            max = arr[i];
        }
    }
    sort(v.begin(), v.end());
    if (v.size() > 1)
        cout << v[1] << "\n";
    else
        cout << v[0] << "\n";
    cout << max_num - min_num;
}