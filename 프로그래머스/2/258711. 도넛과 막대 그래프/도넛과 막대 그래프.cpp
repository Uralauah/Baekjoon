#include <string>
#include <vector>

using namespace std;
int arr[1000001][2];
int edge=0,a=0,b=0,c=0,big=0;

void find(){
    for(int i=0;i<=big;i++){
        if(arr[i][0]==0){
            if(arr[i][1]>=1)
                a++;
        }
        else if(arr[i][0]>=2){
            if(arr[i][1]==0)
                edge=i;
            else
                b++;
        }
    }
    c=arr[edge][0]-a-b;
}

vector<int> solution(vector<vector<int>> edges) {
    vector<int> answer;
    for(int i=0;i<edges.size();i++){
        if(big<edges[i][0])
            big=edges[i][0];
        if(big<edges[i][1])
            big=edges[i][1];
        arr[edges[i][0]][0]++;
        arr[edges[i][1]][1]++;
    }
    find();
    answer.push_back(edge);
    answer.push_back(c);
    answer.push_back(a);
    answer.push_back(b);
    return answer;
}