class Solution {
    public int solution(int n, int[][] results) {
        int answer = 0;
        
        boolean[][] win = new boolean[n+1][n+1];
        boolean[][] lose = new boolean[n+1][n+1];
        
        for(int i = 0;i < results.length; i++){
            win[results[i][0]][results[i][1]] = true;
            lose[results[i][1]][results[i][0]] = true;
        }
        
        for(int i=1;i<=n;i++){
            for(int j = 1;j<=n;j++){
                for(int k = 1; k<=n;k++){
                    if(win[j][i]&&win[i][k])
                        win[j][k] = true;
                    
                    if(lose[j][i]&&lose[i][k])
                        lose[j][k] = true;
                }
            }
        }
        
        for(int i=1;i<=n;i++){
            int cnt = 0;
            for(int j=1;j<=n;j++){
                if(win[i][j]||lose[i][j])
                    cnt++;
            }
            if(cnt==n-1){
                answer++;
            }
        }
        
        return answer;
    }
}