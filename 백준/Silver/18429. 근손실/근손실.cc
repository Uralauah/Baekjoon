#include <iostream>
#include <vector>
using namespace std;

int sum = 0, k, n;
bool visited[8];

void workout(vector<int> kit, int weight, int set)
{
	if (weight<500)
		return;
	if (set==n)
	{
		sum++;
		return;
	}

	for (int i = 0; i < n; i++)
	{
		if (!visited[i])
		{
			visited[i] = true;
			weight = weight + kit.at(i) - k;
			workout(kit, weight, set + 1);
			visited[i] = false;
			weight = weight + k - kit.at(i);
		}
	}
}

int main()
{
	int weight = 500, num;
	vector<int> kit;
	cin >> n >> k;
	for (int i = 0; i < n; i++)
	{
		cin >> num;
		kit.push_back(num);
	}
	workout(kit, weight, 0);
	cout << sum << endl;
}