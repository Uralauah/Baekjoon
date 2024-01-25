#include <iostream>
#include <vector>

using namespace std;


int main() {
    int p, t, input;
    vector<int> line;
    cin >> p;
    for (int i = 0; i < p; i++) {
        cin >> t;
        int sum = 0;
        for (int j = 0; j < 20; j++) {
            cin >> input;
            bool big = false;
            for (int k = 0; k < line.size(); k++) {
                if (line[k] > input) {
                    big = true;
                    line.insert(line.begin() + k, input);
                    sum += (int) line.size() - k - 1;
                    break;
                }
            }
            if (!big) {
                line.push_back(input);
            }
        }
        cout << t << " " << sum << "\n";
        line.clear();
    }
}