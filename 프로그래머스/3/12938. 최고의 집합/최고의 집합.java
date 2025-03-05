class Solution {
    public int[] solution(int n, int s) {
        int[] answer = new int[n];
        
        if(s/n<1)
            return new int[]{-1};
        
        for(int i=0;i<n;i++){
            answer[i] = s/n;
        }
        int temp = s%n;
        int idx = n-1;
        for(;temp>0;temp--){
            answer[idx--] ++;
        }
        
        return answer;
    }
}
