import java.util.*;

class Solution {
    public int solution(int[][] info, int n, int m) {
        int answer = Integer.MAX_VALUE;
        
        int[][] dp = new int[info.length+1][m];
        
        for(int i=0;i<info.length+1;i++){
            Arrays.fill(dp[i],1000000);
        }
        
        dp[0][0] = 0;
        
        for(int i=1;i<info.length+1;i++){
            int A = info[i-1][0];
            int B = info[i-1][1];
            for(int j=0;j<m;j++){
                dp[i][j] = Math.min(dp[i][j], dp[i-1][j]+A);
                
                if(j+B<m){
                    dp[i][j+B] = Math.min(dp[i][j+B], dp[i-1][j]);
                }
            }
        }
        
        for(int i=0;i<m;i++){
            answer = Math.min(answer, dp[info.length][i]);
        }
        
        return answer < n ? answer : -1;
    }
}