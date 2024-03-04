#include <string>
#include <vector>

using namespace std;

vector<vector<int>> ans;

void find(int n,int start, int by, int dest){
    if (n==1){
        ans.push_back({start,dest});
    }
    else{
        find(n-1,start,dest,by);
        ans.push_back({start,dest});
        find(n-1,by,start,dest);
    }
}

vector<vector<int>> solution(int n) {

    find(n,1,2,3);
    return ans;
}