#include <iostream>
#include <queue>
#include <vector>
#define MAXTABLE 49
#define MAXMAGIC 100
using namespace std;

vector<int> explosion(vector<int>arr, int ball[3]) {
	queue<int> q;
	vector<int> temp;
	int sum, num, exp;
	while (true) {
		if (arr.empty())
			break;
		sum = 0, num = 0, exp = 0;
		while (!temp.empty())
			temp.pop_back();
		q.push(arr[0]);
		for (int i = 1; i < arr.size(); i++) {
			if (arr[i] == q.front()) {
				q.push(arr[i]);
			}
			else {
				if (q.size() >= 4) {
					sum = q.size();
					for (int i = 0; i < sum; i++) {
						ball[q.front()-1]++;
						q.pop();
					}
					exp++;
				}
				while (!q.empty()) {
					temp.push_back(q.front());
					q.pop();
				}
				q.push(arr[i]);
			}
		}
		if (q.size() >= 4) {
			sum = q.size();
			for (int i = 0; i < sum; i++) {
				ball[q.front()-1]++;
				q.pop();
			}
			exp++;
		}
		while (!q.empty()) {
			temp.push_back(q.front());
			q.pop();
		}
		arr = temp;
		if (exp == 0)
			break;
	}
	return arr;
}

vector<int> realign(vector<int> arr, int size) {
	vector<int>temp;
	queue<int> q;
	q.push(arr[0]);
	for (int i = 1; i < arr.size(); i++) {
		if (q.front() == arr[i])
			q.push(arr[i]);
		else {
			temp.push_back(q.size());
			temp.push_back(q.front());
			while (!q.empty())
				q.pop();
			q.push(arr[i]);
		}
		if (temp.size() == size)
			break;
	}
	if (temp.size() < size) {
		if (!q.empty()) {
			temp.push_back(q.size());
			temp.push_back(q.front());
		}
	}
	return temp;
}

vector<int> magic(vector<int> arr, int d, int s) {
	int min, sum, num = 0, j = 0, del[MAXTABLE] = { 0 };
	vector<int> temp;
	switch (d) {
	case 1:
		sum = 0, min = 7;
		for (int i = 0; i < s; i++) {
			sum = sum + min;
			min += 8;
			del[num++] = sum-1;
		}
		break;
	case 2:
		sum = 0, min = 3;
		for (int i = 0; i < s; i++) {
			sum = sum + min;
			min += 8;
			del[num++] = sum-1;
		}
		break;
	case 3:
		sum = 0, min = 1;
		for (int i = 0; i < s; i++) {
			sum = sum + min;
			min += 8;
			del[num++] = sum-1;
		}
		break;
	case 4:
		sum = 0, min = 5;
		for (int i = 0; i < s; i++) {
			sum = sum + min;
			min += 8;
			del[num++] = sum-1;
		}
		break;
	}
	for (int i = 0; i < arr.size(); i++) {
		if (del[j] == i) {
			j++;
			continue;
		}
		temp.push_back(arr[i]);
	}
	return temp;
}

vector<int> set(int table[MAXTABLE][MAXTABLE], int n) {
	vector<int> arr;
	int a, b, c, i;
	a = n / 2;
	b = n / 2 - 1;
	c = 1;
	if (table[a][b] != 0)
		arr.push_back(table[a++][b]);
	else
		a++;
	while (1) {
		c++;
		for (int i = 0; i < c; i++) {
			if (table[a][b] == 0) {
				b++;
				continue;
			}
			arr.push_back(table[a][b++]);
		}
		for (int i = 0; i < c; i++) {
			if (table[a][b] == 0) {
				a--;
				continue;
			}
			arr.push_back(table[a--][b]);
		}
		c++;
		for (int i = 0; i < c; i++) {
			if (table[a][b] == 0) {
				b--;
				continue;
			}
			arr.push_back(table[a][b--]);
		}
		if (a == 0 && b == -1)
			break;
		for (int i = 0; i < c; i++) {
			if (table[a][b] == 0) {
				a++;
				continue;
			}
			arr.push_back(table[a++][b]);
		}
	}
	return arr;
}

int main() {
	vector<int> arr;
	int ball[3] = { 0 }, size = 0;

	int n, m, sum = 0;
	cin >> n >> m;
	size = n * n - 1;
	int table[MAXTABLE][MAXTABLE], magic_table[MAXMAGIC][2];
	for (int i = 0; i < n; i++) {
		for (int j = 0; j < n; j++) {
			cin >> table[i][j];
		}
	}
	for (int i = 0; i < m; i++) {
		cin >> magic_table[i][0] >> magic_table[i][1];
	}

	arr = set(table, n);
	if (!arr.empty()) {
		for (int i = 0; i < m; i++) {
			arr = magic(arr, magic_table[i][0], magic_table[i][1]);
			arr = explosion(arr, ball);
			if (arr.empty())
				break;
			else
				arr = realign(arr, size);
		}
	}
	
	sum += ball[0] * 1 + ball[1] * 2 + ball[2] * 3;
	cout << sum;
}