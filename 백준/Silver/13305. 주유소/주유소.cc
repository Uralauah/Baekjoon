#include <iostream>
#include <vector>

using namespace std;


int main() {
    long long n, m, sum = 0;
    long long cur_price, loc, next_loc;
    vector<long long> way;
    vector<long long> price;
    cin >> n;
    for (int i = 0; i < n - 1; i++) {
        cin >> m;
        way.push_back(m);
    }
    for (int i = 0; i < n; i++) {
        cin >> m;
        price.push_back(m);
    }
    cur_price = price[0];
    loc = 0, next_loc = 1;
    while (loc < n) {
        //cout << loc << " ";
        for (; next_loc < n; next_loc++) {
            if (price[loc] > price[next_loc]) {
                //cout << next_loc << " ";

                break;
            }
        }
        for (int i = loc; i < next_loc; i++) {
            sum += way[i] * price[loc];
        }
        loc = next_loc;
    }
    cout << sum;
}