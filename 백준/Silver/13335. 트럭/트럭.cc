#include <iostream>
#include <queue>
using namespace std;

int main(){
	queue<int> truck;
	queue<int> bridge;
	int n,w,l,weight,time=0,sum=0;

	cin>>n>>w>>l;
	for (int i=0;i<n;i++){
		cin>>weight;
		truck.push(weight);
	}

	weight=0;
	while(1){
		if (truck.empty())
			break;
		if (bridge.size()>=w){
			weight-=bridge.front();
			bridge.pop();
		}
		if (weight+truck.front()>l)
			bridge.push(0);
		else{
			bridge.push(truck.front());
			weight+=truck.front();
			truck.pop();
		}
		time++;

	}
	cout<<time+w;
}