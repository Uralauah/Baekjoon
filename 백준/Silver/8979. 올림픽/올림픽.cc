#include <iostream>
#include <cmath>
#include <string>
using namespace std;

int main() {
	int world[1000][3];
	int n, k;
	cin >> n >> k;
	int num, g, s, b;
	for (int i = 0; i < n; i++)
	{
		cin >> num >> g >> s >> b;
		world[num][0] = g;
		world[num][1] = s;
		world[num][2] = b;
	}
	int score=1;
	if (world[k][0] > 0)
	{
		for (int i = 1; i <= n; i++)
		{
			if (world[i][0] == world[k][0])
			{
				if (world[i][1] == world[k][1])
				{
					if (world[i][2] > world[k][2])
						score++;
				}
				else if (world[i][1] > world[k][1])
					score++;

			}
			else if (world[i][0] > world[k][0])
				score++;
		}
	}
	else if (world[k][0] == 0 && world[k][1] > 0)
	{
		for (int i = 1; i <= n; i++)
		{
			if (world[i][0] > 0)
				score++;
			else if (world[i][1] == world[k][1])
			{
				if (world[i][2] > world[i][2])
					score++;
			}
			else if (world[i][1] > world[k][1])
				score++;
		}
	}
	else if (world[k][0] == 0 && world[k][1] == 0 && world[k][2] > 0)
	{
		for (int i = 1; i <= n; i++)
		{
			if (world[i][0] > 0)
				score++;
			else if (world[i][1] > 0)
				score++;
			else if (world[i][2] > world[k][2])
				score++;
		}
	}
	else
		score = n;
	cout << score;
}