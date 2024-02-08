#include <iostream>
#include <string>
#include <cmath>

using namespace std;

int n;
int m;
bool dis[10] = { false, };

bool is_possible(int num) {
	string s = to_string(num);

	for (int i = 0; i < s.size(); i++) {
		if (dis[s[i] - 48])
			return false;
	}
	return true;
}

int main(void) {

	int ans = 0;

	cin >> n;
	cin >> m;

	for (int i = 0; i < m; i++) {
		int d;
		cin >> d;
		dis[d] = true;
	}

	if (n == 100) {
		cout << 0;
		return 0;
	}

	ans = abs(n - 100);

	for (int i = 0; i <= 1000000; i++) {
		if (is_possible(i)) {
			int temp = abs(n - i) + to_string(i).size();
			ans = min(ans, temp);
		}
	}

	cout << ans;

	return 0;
}