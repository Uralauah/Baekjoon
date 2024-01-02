#include <iostream>
using namespace std;

int main(){
	int a[301][301], b[601][601];
	int h, w, x, y, num ,ax = 0, ay = 0;

	cin>>h>>w>>x>>y;
	for (int i=0;i<h+x;i++){
		for (int j=0;j<w+y;j++){
			cin>>num;
			b[i][j]=num;
		}
	}

	for (int i=x;i<h;i++){
		for (int j=y;j<=w+y;j++){
			b[i][j]-=b[i-x][j-y];
		}
	}

	for (int i=0;i<h;i++){
		for (int j=0;j<w;j++){
			cout<<b[i][j]<<" ";
		}
		cout<<endl;
	}
	
}