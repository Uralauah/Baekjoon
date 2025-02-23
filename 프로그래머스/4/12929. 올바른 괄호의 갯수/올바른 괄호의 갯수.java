class Solution {
    public int cnt = 0;
    
    public void find(int l, int r){
        if(l<0||r<0)
            return;
        if(l==0 && r==0){
            cnt++;
            return;
        }
        if(l==r){
            find(l-1, r);
        }
        else{
            find(l-1,r);
            find(l,r-1);
        }
    }
    
    public int solution(int n) {
        int answer = 0;
        
        find(n,n);
        
        return cnt;
    }
}

