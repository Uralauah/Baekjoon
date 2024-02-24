#include <iostream>
#include <algorithm>
#include <vector>
#include <queue>


#define MAX (10001)
#define INF (987654321)

using namespace std;

int T, N, D, C;
int dp[MAX];

void dijkstra(vector<pair<int, int>> edge[]) {
	dp[C] = 0;
	priority_queue<pair<int, int>, vector<pair<int, int>>, greater<pair<int, int>>> pq;
	pq.push({ 0,C });

	while (!pq.empty()) {
		int cur = pq.top().second;
		int curTime = pq.top().first;
		pq.pop();
		if (dp[cur] < curTime)
			continue;

		for (int i = 0; i < edge[cur].size(); i++) {
			int next = edge[cur][i].first;
			int nextTime = curTime + edge[cur][i].second;

			if (nextTime < dp[next]) {
				dp[next] = nextTime;
				pq.push({ nextTime, next });
			}

		}
	}
	//INF가 아닌 수 중에서 가장 큰 값이 모든 PC 감염 시간
	//INF가 아닌 수들의 개수가 감염된 컴퓨터의 수
	int cnt=0,ans = 0;
	for (int i = 1; i <= N; i++) {
		if (dp[i] != INF) {
			cnt++;
			ans = max(ans, dp[i]);
		}
	}
	cout << cnt << ' ' << ans<< '\n';

}

int main() {

	ios::sync_with_stdio(false);
	cin.tie(0);
	cout.tie(0);
	cin >> T;
	while (T--) {
		vector<pair<int, int>> edge[MAX];
		cin >> N >> D >> C;
		int a, b, s;
		for (int i = 0; i < D; i++) {
			cin >> a >> b >> s;
			//b가 감염되면 a는 s초 후에 감염
			edge[b].push_back({ a,s });
		}
		fill_n(dp, MAX, INF);
		dijkstra(edge);

	}

	return 0;
}